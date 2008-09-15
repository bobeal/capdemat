package fr.cg95.cvq.fo.citizen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.cg95.cvq.business.request.HomeFolderModificationRequest;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.LegalResponsibleRole;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.citizen.form.Account;
import fr.cg95.cvq.fo.citizen.form.Adult;
import fr.cg95.cvq.fo.citizen.form.Child;
import fr.cg95.cvq.fo.citizen.form.Responsible;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.request.IHomeFolderModificationRequestService;
import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.wizard.StageFormList;
import fr.cg95.cvq.wizard.WizardListener;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest;

public class AccountPersistence extends IPersistence implements WizardListener {

    public String getServiceName(String definitionName) {
        if (definitionName.equals("eCitizen"))
            return IVoCardRequestService.SERVICE_NAME;

        if (definitionName.equals("eFamily"))
            return IHomeFolderModificationRequestService.SERVICE_NAME;

        return "";
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        
        VoCardRequest vcr = VoCardRequest.Factory.newInstance();

        cvqRequest.setDbRequest(new fr.cg95.cvq.business.ecitizen.VoCardRequest());

        cvqRequest.setList("adult", new StageFormList(this, request.getSession()));
        cvqRequest.setList("child", new StageFormList(this, request.getSession()));

        if (cvqRequest.getProcess().equals("eCitizen")) {
            initializeNewAdult(request.getSession());
            
        } else {
            FamilyHome familyHome = SessionManager.getFamilyHome(request);
            try {
                getFoAdults(BusinessManager.getInstance().getHomeFolderService().getAdults(familyHome.getId()), cvqRequest.getList("adult"));
                getFoChildren(BusinessManager.getInstance().getHomeFolderService().getChildren(familyHome.getId()), 
                        cvqRequest.getList("child"), 
                        cvqRequest.getList("adult"));

                ArrayList legalAdults = new ArrayList();
                Iterator iter = cvqRequest.getList("adult").iterator();
                while (iter.hasNext()) {
                    Adult adult = (Adult)iter.next();
                    legalAdults.add(adult.getAdultFirstName() + " " + adult.getAdultLastName());
                }
                request.getSession().setAttribute("adults", legalAdults);
                request.getSession().setAttribute("Account", new Account());
                
            } catch (CvqException e) {
                e.getMessage();
            }
        }
        return vcr;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception {
        IVoCardRequestService iVOCardRequestService = 
            (IVoCardRequestService)BusinessManager.getAc().getBean(IVoCardRequestService.SERVICE_NAME);

        IHomeFolderModificationRequestService homeFolderService = 
            (IHomeFolderModificationRequestService)BusinessManager.getAc().
                    getBean(IHomeFolderModificationRequestService.SERVICE_NAME);

        // adults of the the family home
        ArrayList adults = getModelAdults(cvqRequest.getList("adult"));

        // set login information
        fr.cg95.cvq.business.users.Adult modelAccManager = getModelAccountManager(adults);
        
        Account account = (Account)request.getSession().getAttribute("Account");
        if (account.getLoginNewAccount()) {
            modelAccManager.setAnswer(account.getLoginAnswer());
            modelAccManager.setPassword(account.getLoginPassword());
            modelAccManager.setQuestion(account.getLoginQuestion());
        }        
        // children of the the family home
        Set children = getModelChildren(adults, cvqRequest.getList("child"));

        MeansOfContact meansOfContact =
            MeansOfContact.xmlToModel(((RequestType)xmlRequestData).getMeansOfContact());

        if (cvqRequest.getProcess().equals("eCitizen")) {  // Vo Card request
            // create the request
            fr.cg95.cvq.business.ecitizen.VoCardRequest voCardRequest = new fr.cg95.cvq.business.ecitizen.VoCardRequest();

            voCardRequest.setMeansOfContact(meansOfContact);

            iVOCardRequestService.create(voCardRequest, new HashSet(adults), children, modelAccManager.getAdress());
            
            LoginForm login = new LoginForm();
            login.setUserName(modelAccManager.getLogin());
            BaseAction.setCurrentEcitizen(login);

            ((VoCardRequest)xmlRequestData).getRequester().setPassword(account.getLoginPassword());
            
            return voCardRequest.getId();

        } else { // Modify the request
            HomeFolderModificationRequest homeFolderRequest = 
                homeFolderService.create(modelAccManager.getHomeFolder().getId(), modelAccManager.getId());

            homeFolderRequest.setMeansOfContact(meansOfContact);

            homeFolderService.modify(homeFolderRequest, new HashSet(adults), children, modelAccManager.getAdress());

            return homeFolderRequest.getId();
        }
    }

    public void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState, Request cvqRequest) {
        try {
            FamilyHome familyHome = SessionManager.getFamilyHome(request);

            if ((familyHome != null) && (familyHome.getId() != null)) {
                HomeFolder homeFolder = BusinessManager.getInstance().getHomeFolderService().getById(
                        familyHome.getId());
                BusinessObjectFactory.setFamilyHomeForm(homeFolder, familyHome);

                Account account = (Account)request.getSession().getAttribute("Account");
                if (account.getLoginNewAccount()) {
                    try {
                        LoginForm login = new LoginForm();
                        login.setUserName(familyHome.getFamilyHomeResponsible().getLogin());
                        request.getSession().setAttribute(BaseAction.AUTHENTIFICATION, login);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (CvqObjectNotFoundException e) {
            e.getMessage();
        } catch (CvqException e) {
            e.getMessage();
        }
        super.terminateRequest(request, wizardState, cvqRequest);
    }

    public String onStateChange(HttpServletRequest request, IStageForm stageForm, String state, String newState) {
        String correctedState = newState;
        if (stageForm instanceof Adult) {
            Request cvqRequest = getCvqRequest(request);
            if ((cvqRequest != null) && (cvqRequest.getProcess().equals("eFamily"))) {
                ProcessWizardState wizardState = ProcessWizardState.getWizardState(request); 

                if (!wizardState.isStageSaved(0)) {
                    // Mark all stages as saved to display them in the side bar
                    for (int stage = 0; stage < wizardState.sizeOfStageArray(); stage++)
                        wizardState.setStageSaved(stage);
                    
                    // Display the stage menu page to add adults and children
                    return null;
                }

                Adult accountManager = getAccountManager(cvqRequest.getList("adult"));
                ((Adult)stageForm).setShowAccMan((accountManager == null) || (accountManager == stageForm));
                
                if (newState.equals("display") && state.equals("address")) {
                    FamilyHome familyHome = SessionManager.getFamilyHome(request);
                    
                    Account account = (Account)request.getSession().getAttribute("Account");
                    
                    if ((familyHome == null) || (familyHome.getResponsibleId() == null))
                        account.setLoginNewAccount(true);

                    else if (accountManager == null)
                        account.setLoginNewAccount(true);
                    
                    else if (accountManager.getAdultId() != familyHome.getResponsibleId().longValue())
                        account.setLoginNewAccount(true);
                    
                    else
                        account.setLoginNewAccount(false);
                    
                    wizardState.setStageSaved(request, "Account", !account.getLoginNewAccount());
                    wizardState.setStageSaved(request, "Validation", !account.getLoginNewAccount());
                }
            }
        }
        if (newState.equals("account")) {
            Account account = (Account)request.getSession().getAttribute("Account");
            if (state.equals("account")) {
                if (!account.getLoginNewAccount())
                    correctedState = "exists";
            } else if (state.equals("exists")) {
                if (stageForm instanceof Account)
                    return null;
                else if (!account.getLoginNewAccount())
                    correctedState = "exists";
            }
        }
        
        return correctedState;
    }
    
    public String onStageChange(HttpServletRequest request, IStageForm stageForm, String stageName) {
        if (stageName.equals("Adult")) {
            Request cvqRequest = getCvqRequest(request);
            Adult accountManager = getAccountManager(cvqRequest.getList("adult"));
            if (accountManager == null) {
                return "Vous devez définir au moins un adulte responsable du compte.";
            }
            FamilyHome familyHome = SessionManager.getFamilyHome(request);
            
            Account account = (Account)request.getSession().getAttribute("Account");
            if (account == null) {
                account = new Account();
                request.getSession().setAttribute("Account", account);
            }
            
            if ((familyHome == null) || (familyHome.getResponsibleId() == null))
                account.setLoginNewAccount(true);
            else if (accountManager.getAdultId() != familyHome.getResponsibleId().longValue())
                account.setLoginNewAccount(true);
            else
                account.setLoginNewAccount(false);
            
            ArrayList legalAdults = new ArrayList();
            Iterator iter = cvqRequest.getList("adult").iterator();
            while (iter.hasNext()) {
                Adult adult = (Adult)iter.next();
                legalAdults.add(adult.getAdultFirstName() + " " + adult.getAdultLastName());
            }
            request.getSession().setAttribute("adults", legalAdults);
        }
        return null;
    }

    public void onNew(Object data, Object stageForm) {
        if (stageForm instanceof Adult) {
            Request cvqRequest = getCvqRequest((HttpSession)data);
            Adult adult = (Adult)stageForm;
            adult.setShowAccMan(true);

            Adult defaultAdult = getDefaultAdult(cvqRequest.getList("adult"));
            if (defaultAdult != null ) {
                adult.setAdultLastName(defaultAdult.getAdultLastName());
                adult.setAdultAddressAdditionalDeliveryInformation(defaultAdult.getAdultAddressAdditionalDeliveryInformation());
                adult.setAdultAddressAdditionalGeographicalInformation(defaultAdult.getAdultAddressAdditionalGeographicalInformation());
                adult.setAdultAddressStreetNumber(defaultAdult.getAdultAddressStreetNumber());
                adult.setAdultAddressStreetName(defaultAdult.getAdultAddressStreetName());
                adult.setAdultAddressPlaceNameOrService(defaultAdult.getAdultAddressPlaceNameOrService());
                adult.setAdultAddressPostalCode(defaultAdult.getAdultAddressPostalCode());
                adult.setAdultAddressCity(defaultAdult.getAdultAddressCity());

                adult.setAdultHomePhone(defaultAdult.getAdultHomePhone());
                if (defaultAdult.getAccountManager())
                    // AccountManager already defined, do not show radio buttons
                    adult.setShowAccMan(false);
            } else {
                // the first adult form must be initalized as the accountManager
                adult.setAccountManager(true);
            }

            // Update child legal responsibles
            for (Object child : cvqRequest.getList("child"))
                updateChildAdults((Child)child, (Adult)stageForm, (ArrayList)cvqRequest.getList("adult"));

        }
        if (stageForm instanceof Child) {
            Request cvqRequest = getCvqRequest((HttpSession)data);
            Child child = (Child)stageForm;
            Adult defaultAdult = getDefaultAdult(cvqRequest.getList("adult"));
            child.setChildLastName(defaultAdult.getAdultLastName());
            child.setChildLegalResponsible(new StageFormList(this, cvqRequest));
        }
        super.onNew(data, stageForm);
    }

    public void onSelect(Object data, Object stageForm) {
        if (stageForm instanceof Adult) {
            Request cvqRequest = getCvqRequest((HttpSession)data);
            Adult adult = (Adult)stageForm;

            Adult accountManager = getAccountManager(cvqRequest.getList("adult"));

            if (adult.getAccountManager())
                adult.setShowAccMan(true);
            else
                adult.setShowAccMan(accountManager == null);
        }
        super.onSelect(data, stageForm);
    }

    public void onRemove(Object data, Object stageForm) {
        if (stageForm instanceof Adult) {
            HttpSession session  = (HttpSession)data;
            Request cvqRequest = getCvqRequest(session);
            ProcessWizardState wizardState = ProcessWizardState.getWizardState(session);
            
            // Update child legal responsibles
            for (Object child : cvqRequest.getList("child"))
                updateChildAdults((Child)child, (Adult)stageForm, (ArrayList)cvqRequest.getList("adult"));

            if (cvqRequest.getList("adult").size() == 1) {
                // Create new adult
                wizardState.setState("adult");
                initializeNewAdult(session);
            } else {
                // Display stage menu
                wizardState.setEndStage(true);
            }

        } else if (stageForm instanceof Child) {
            HttpSession session  = (HttpSession)data;
            ProcessWizardState wizardState = ProcessWizardState.getWizardState(session);
            
            wizardState.setEndStage(true);
        }
        super.onRemove(data, stageForm);
    }

    private void initializeNewAdult(HttpSession session) {
        Adult adult = new Adult();
        adult.setShowAccMan(true);
        adult.setAccountManager(true);
        
        session.setAttribute("fr.cg95.cvq.wizard.process.ProcessStageAction.stage", "Adult");
        session.setAttribute("Adult", adult);
    }
    
    private Adult getDefaultAdult(Collection adults) {
        Iterator it = adults.iterator();

        if (adults.size() == 1)
            return (Adult) it.next();

        while (it.hasNext()) {
            Adult adult = (Adult) it.next();
            if (adult.getAccountManager())
                return adult;
        }
        return null;
    }

    private Adult getAccountManager(Collection adults) {
        Iterator it = adults.iterator();

        while (it.hasNext()) {
            Adult adult = (Adult) it.next();
            if (adult.getAccountManager())
                return adult;
        }
        return null;
    }

    private void updateChildAdults(Child child, Adult adult, ArrayList adults) {
        // Copy existing childAdults list
        boolean[] childAdults = new boolean[child.getSizeOfChildAdult()];
        
        for (int i = 0; i < childAdults.length; i++)
            childAdults[i] = child.getChildAdult(i);
        
        // Find adult in list
        int index = 0;
        while ((index < adults.size()) && (adults.get(index) != adult)) index ++;
        
        if (index < adults.size()) {
            // If adult in list remove from childAdult list
            child.setSizeOfChildAdult(childAdults.length - 1);
            int j = 0;
            for (int i = 0; i < index; i++)
                child.setChildAdult(j++, childAdults[i]);

            for (int i = index + 1; i < childAdults.length; i++)
                child.setChildAdult(j++, childAdults[i]);

        } else {
            // If adult not in list increase size of childAdult list
            child.setSizeOfChildAdult(childAdults.length + 1);
            for (int i = 0; i < childAdults.length; i++)
                child.setChildAdult(i, childAdults[i]);

            child.setChildAdult(childAdults.length, false);
        }
    }
    
    private fr.cg95.cvq.business.users.Adult getModelAccountManager(Collection adults) {
        Iterator it = adults.iterator();

        while (it.hasNext()) {
            fr.cg95.cvq.business.users.Adult modelAdult = (fr.cg95.cvq.business.users.Adult) it.next();
            if (modelAdult.isHomeFolderResponsible())
                return modelAdult;
        }
        return null;
    }

    private Collection getFoAdults(Set adults, Collection foAdults) {
        Iterator it = adults.iterator();

        while (it.hasNext())
            foAdults.add(modelToFo((fr.cg95.cvq.business.users.Adult) it.next()));

        return foAdults;
    }

    private Collection getFoChildren(Set children, Collection foChildren, Collection foAdults) {
        Iterator it = children.iterator();

        while (it.hasNext())
            foChildren.add(modelToFo((fr.cg95.cvq.business.users.Child)it.next(), foAdults));

        return foChildren;
    }

    private Adult modelToFo(fr.cg95.cvq.business.users.Adult modelAdult) {
        Adult foAdult = new Adult();
        
        foAdult.setAdultId(modelAdult.getId().longValue());
        
        foAdult.setAccountManager(modelAdult.isHomeFolderResponsible());

        if (modelAdult.getAdress() != null) {
            foAdult.setAdultAddressAdditionalDeliveryInformation(modelAdult.getAdress().getAdditionalDeliveryInformation());
            foAdult.setAdultAddressAdditionalGeographicalInformation(modelAdult.getAdress().getAdditionalGeographicalInformation());
            foAdult.setAdultAddressStreetNumber(modelAdult.getAdress().getStreetNumber());
            foAdult.setAdultAddressStreetName(modelAdult.getAdress().getStreetName());
            foAdult.setAdultAddressPlaceNameOrService(modelAdult.getAdress().getPlaceNameOrService());
            foAdult.setAdultAddressCity(modelAdult.getAdress().getCity());
            foAdult.setAdultAddressPostalCode(modelAdult.getAdress().getPostalCode());
        }        
        foAdult.setAdultBirthPlaceCity(modelAdult.getBirthCity());
        foAdult.setAdultBirthPlaceCountry(modelAdult.getBirthCountry());
        foAdult.setAdultBirthPlacePostalCode(modelAdult.getBirthPostalCode());

        if (modelAdult.getBirthDate() != null) {
            Calendar date = Calendar.getInstance();
            date.setTime(modelAdult.getBirthDate());
            foAdult.setAdultBirthDate(date);
        }
        
        foAdult.setAdultCfbn(modelAdult.getCfbn());
        foAdult.setAdultEmail(modelAdult.getEmail());
        
        if (modelAdult.getFamilyStatus() != null)
            foAdult.setAdultFamilyStatus(modelAdult.getFamilyStatus().toString());

        foAdult.setAdultFirstName(modelAdult.getFirstName());
        foAdult.setAdultFirstName2(modelAdult.getFirstName2());
        foAdult.setAdultFirstName3(modelAdult.getFirstName3());
        foAdult.setAdultHomePhone(modelAdult.getHomePhone());
        foAdult.setAdultLastName(modelAdult.getLastName());
        foAdult.setAdultMaidenName(modelAdult.getMaidenName());
        foAdult.setAdultMobilePhone(modelAdult.getMobilePhone());
        foAdult.setAdultNameOfUse(modelAdult.getNameOfUse());
        foAdult.setAdultOfficePhone(modelAdult.getOfficePhone());
        foAdult.setAdultProfession(modelAdult.getProfession());

        if (modelAdult.getTitle() != null)
            foAdult.setAdultTitle(modelAdult.getTitle().toString());

        return foAdult;
    }
    
    private Child modelToFo(fr.cg95.cvq.business.users.Child modelChild, Collection adults) {
        Child foChild = new Child();
        
        foChild.setChildId(modelChild.getId().longValue());
        
        if (modelChild.getBirthDate() != null) {
            Calendar date = Calendar.getInstance();
            date.setTime(modelChild.getBirthDate());
            foChild.setChildBirthDate(date);
        }
        
        foChild.setChildBirthPlaceCity(modelChild.getBirthCity());
        foChild.setChildBirthPlaceCountry(modelChild.getBirthCountry());
        foChild.setChildBirthPlacePostalCode(modelChild.getBirthPostalCode());

        foChild.setChildFirstName(modelChild.getFirstName());
        foChild.setChildFirstName2(modelChild.getFirstName2());
        foChild.setChildFirstName3(modelChild.getFirstName3());
        foChild.setChildLastName(modelChild.getLastName());

        if (modelChild.getSex() != null) 
            foChild.setChildSex(modelChild.getSex().toString());

        foChild.setSizeOfChildAdult(adults.size());
        foChild.setChildLegalResponsible(new StageFormList());
        
        Iterator iter = modelChild.getLegalResponsibles().iterator();
        while (iter.hasNext()) {
            ChildLegalResponsible responsible = (ChildLegalResponsible)iter.next();
            
            int index = findAdultIndex(adults, responsible.getLegalResponsible()); 
            if (index >= 0) {
                foChild.setChildAdult(index, true);
            } else {
                foChild.getChildLegalResponsible().add(modelToFoResponsible(responsible));
            }
        }
        return foChild;
    }

    private int findAdultIndex(Collection adults, fr.cg95.cvq.business.users.Adult modelAdult) {
        int index = 0;
        Iterator iter = adults.iterator();
        while (iter.hasNext()) {
            Adult adult = (Adult)iter.next();
            if (modelAdult.getId().longValue() == adult.getAdultId())
                return index;
            
            index++;
        }
        return -1;
    }
    
    private Responsible modelToFoResponsible(ChildLegalResponsible legalResponsible) {
        Responsible foResponsible = new Responsible();
        fr.cg95.cvq.business.users.Adult modelAdult = legalResponsible.getLegalResponsible();

        foResponsible.setChildLegalResponsibleLegalResponsibleId(modelAdult.getId().longValue());
        
        foResponsible.setChildLegalResponsibleRole(legalResponsible.getRole().toString());

        if (modelAdult.getAdress() != null) {
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation(
                    modelAdult.getAdress().getAdditionalDeliveryInformation());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation(
                    modelAdult.getAdress().getAdditionalGeographicalInformation());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressStreetNumber(
                    modelAdult.getAdress().getStreetNumber());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressStreetName(
                    modelAdult.getAdress().getStreetName());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService(
                    modelAdult.getAdress().getPlaceNameOrService());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressCity(
                    modelAdult.getAdress().getCity());
            foResponsible.setChildLegalResponsibleLegalResponsibleAddressPostalCode(
                    modelAdult.getAdress().getPostalCode());
        }        
        foResponsible.setChildLegalResponsibleLegalResponsibleBirthPlaceCity(modelAdult.getBirthCity());
        foResponsible.setChildLegalResponsibleLegalResponsibleBirthPlaceCountry(modelAdult.getBirthCountry());
        foResponsible.setChildLegalResponsibleLegalResponsibleBirthPlacePostalCode(modelAdult.getBirthPostalCode());

        if (modelAdult.getBirthDate() != null) {
            Calendar date = Calendar.getInstance();
            date.setTime(modelAdult.getBirthDate());
            foResponsible.setChildLegalResponsibleLegalResponsibleBirthDate(date);
        }
        
        foResponsible.setChildLegalResponsibleLegalResponsibleCfbn(modelAdult.getCfbn());
        foResponsible.setChildLegalResponsibleLegalResponsibleEmail(modelAdult.getEmail());
        
        if (modelAdult.getFamilyStatus() != null)
            foResponsible.setChildLegalResponsibleLegalResponsibleFamilyStatus(modelAdult.getFamilyStatus().toString());

        foResponsible.setChildLegalResponsibleLegalResponsibleFirstName(modelAdult.getFirstName());
        foResponsible.setChildLegalResponsibleLegalResponsibleFirstName2(modelAdult.getFirstName2());
        foResponsible.setChildLegalResponsibleLegalResponsibleFirstName3(modelAdult.getFirstName3());
        foResponsible.setChildLegalResponsibleLegalResponsibleHomePhone(modelAdult.getHomePhone());
        foResponsible.setChildLegalResponsibleLegalResponsibleLastName(modelAdult.getLastName());
        foResponsible.setChildLegalResponsibleLegalResponsibleMaidenName(modelAdult.getMaidenName());
        foResponsible.setChildLegalResponsibleLegalResponsibleMobilePhone(modelAdult.getMobilePhone());
        foResponsible.setChildLegalResponsibleLegalResponsibleNameOfUse(modelAdult.getNameOfUse());
        foResponsible.setChildLegalResponsibleLegalResponsibleOfficePhone(modelAdult.getOfficePhone());
        foResponsible.setChildLegalResponsibleLegalResponsibleProfession(modelAdult.getProfession());

        if (modelAdult.getTitle() != null)
            foResponsible.setChildLegalResponsibleLegalResponsibleTitle(modelAdult.getTitle().toString());

        return foResponsible;
    }
    
    private ArrayList getModelAdults(Collection adults) {
        ArrayList modelAdults = new ArrayList();
        Iterator it = adults.iterator();

        while (it.hasNext())
            modelAdults.add(foToModel((Adult) it.next()));

        return modelAdults;
    }

    private Set getModelChildren(ArrayList adults, Collection children) {
        HashSet modelChildren = new HashSet();
        Iterator it = children.iterator();

        while (it.hasNext())
            modelChildren.add(foToModel((Child) it.next(), adults));

        return modelChildren;
    }

    private fr.cg95.cvq.business.users.Adult foToModel(Adult foAdult) {
        fr.cg95.cvq.business.users.Adult modelAdult = null;
        if (foAdult.getAdultId() != 0)
            try {
                modelAdult = BusinessManager.getInstance().getAdultService().getById(new Long(foAdult.getAdultId()));
            } catch (CvqObjectNotFoundException e1) {
            } catch (CvqException e1) {
            }
        if (modelAdult == null)
            modelAdult = new fr.cg95.cvq.business.users.Adult();

        if (foAdult.getAccountManager())
            modelAdult.addHomeFolderResponsibleRole();
        else
            modelAdult.removeHomeFolderResponsibleRole();

        // only change adult's address if there are real modifications
        Address originalAddress = modelAdult.getAdress();
        if ((originalAddress == null) ||
                !equals(foAdult.getAdultAddressAdditionalDeliveryInformation(),
                        originalAddress.getAdditionalDeliveryInformation()) ||
                !equals(foAdult.getAdultAddressAdditionalGeographicalInformation(),
                        originalAddress.getAdditionalGeographicalInformation()) ||
                !equals(foAdult.getAdultAddressStreetNumber(),
                        originalAddress.getStreetNumber()) ||
                !equals(foAdult.getAdultAddressStreetName(),
                        originalAddress.getStreetName()) ||
                !equals(foAdult.getAdultAddressPlaceNameOrService(),
                        originalAddress.getPlaceNameOrService()) ||
                !equals(foAdult.getAdultAddressPostalCode(),
                        originalAddress.getPostalCode()) ||
                !equals(foAdult.getAdultAddressCity(),
                        originalAddress.getCity())) {
            Address address = new Address();
            address.setAdditionalDeliveryInformation(foAdult.getAdultAddressAdditionalDeliveryInformation());
            address.setAdditionalGeographicalInformation(foAdult.getAdultAddressAdditionalGeographicalInformation());
            address.setStreetNumber(foAdult.getAdultAddressStreetNumber());
            address.setStreetName(foAdult.getAdultAddressStreetName());
            address.setPlaceNameOrService(foAdult.getAdultAddressPlaceNameOrService());
            address.setCity(foAdult.getAdultAddressCity());
            address.setPostalCode(foAdult.getAdultAddressPostalCode());
            modelAdult.setAdress(address);
        }        
        
        modelAdult.setBirthCity(foAdult.getAdultBirthPlaceCity());
        modelAdult.setBirthCountry(foAdult.getAdultBirthPlaceCountry());
        modelAdult.setBirthPostalCode(foAdult.getAdultBirthPlacePostalCode());

        if (foAdult.getAdultBirthDate() != null)
            modelAdult.setBirthDate(foAdult.getAdultBirthDate().getTime());
        
        modelAdult.setCfbn(foAdult.getAdultCfbn());
        modelAdult.setEmail(foAdult.getAdultEmail());
        modelAdult.setFamilyStatus(foAdult.getAdultFamilyStatus());
        modelAdult.setFirstName(foAdult.getAdultFirstName());
        modelAdult.setFirstName2(foAdult.getAdultFirstName2());
        modelAdult.setFirstName3(foAdult.getAdultFirstName3());
        modelAdult.setHomePhone(foAdult.getAdultHomePhone());
        modelAdult.setLastName(foAdult.getAdultLastName());
        modelAdult.setMaidenName(foAdult.getAdultMaidenName());
        modelAdult.setMobilePhone(foAdult.getAdultMobilePhone());
        modelAdult.setNameOfUse(foAdult.getAdultNameOfUse());
        modelAdult.setOfficePhone(foAdult.getAdultOfficePhone());
        modelAdult.setProfession(foAdult.getAdultProfession());
        modelAdult.setTitleType(foAdult.getAdultTitle());

        return modelAdult;
    }
    
    private fr.cg95.cvq.business.users.Child foToModel(Child foChild, ArrayList adults) {
        fr.cg95.cvq.business.users.Child modelChild = null;
        if (foChild.getChildId() != 0)
            try {
                modelChild = BusinessManager.getInstance().getChildService().getById(new Long(foChild.getChildId()));
            } catch (CvqObjectNotFoundException e1) {
            } catch (CvqException e1) {
            }
        if (modelChild == null)
            modelChild = new fr.cg95.cvq.business.users.Child();
        
        if (foChild.getChildBirthDate() != null)
            modelChild.setBirthDate(foChild.getChildBirthDate().getTime());
        
        modelChild.setBirthCity(foChild.getChildBirthPlaceCity());
        modelChild.setBirthCountry(foChild.getChildBirthPlaceCountry());
        modelChild.setBirthPostalCode(foChild.getChildBirthPlacePostalCode());
        modelChild.setFirstName(foChild.getChildFirstName());
        modelChild.setFirstName2(foChild.getChildFirstName2());
        modelChild.setFirstName3(foChild.getChildFirstName3());
        modelChild.setLastName(foChild.getChildLastName());
        modelChild.setSex(foChild.getChildSex());

        if (modelChild.getLegalResponsibles() == null)
            modelChild.setLegalResponsibles(new HashSet());
        else
            modelChild.getLegalResponsibles().clear();

        for (int i=0; i < foChild.getSizeOfChildAdult(); i++) {
            if (foChild.getChildAdult(i)) {
                fr.cg95.cvq.business.users.Adult adult = (fr.cg95.cvq.business.users.Adult)adults.get(i);

                LegalResponsibleRole lrr = null;
                if (adult.getTitle().equals(TitleType.MISTER)) 
                    lrr = LegalResponsibleRole.FATHER;
                else if (adult.getTitle().equals(TitleType.AGENCY))
                    lrr = LegalResponsibleRole.TUTOR;
                else
                    lrr = LegalResponsibleRole.MOTHER;
                
                ChildLegalResponsible responsible = new ChildLegalResponsible();
                responsible.setRole(lrr);
                responsible.setLegalResponsible(adult);
                responsible.setChild(modelChild);
                modelChild.getLegalResponsibles().add(responsible);
            }
        }
        for (int i = 0; i < foChild.getSizeOfChildLegalResponsible(); i++) {
            Responsible foResponsible = (Responsible)foChild.getChildLegalResponsible().get(i);
            
            fr.cg95.cvq.business.users.Adult adult = foToModelAdult(foResponsible);
            LegalResponsibleRole lrr = LegalResponsibleRole.forString(foResponsible.getChildLegalResponsibleRole());
            
            ChildLegalResponsible responsible = new ChildLegalResponsible();
            responsible.setRole(lrr);
            responsible.setLegalResponsible(adult);
            responsible.setChild(modelChild);
            modelChild.getLegalResponsibles().add(responsible);
        }
        return modelChild;
    }

    private fr.cg95.cvq.business.users.Adult foToModelAdult(Responsible foResponsible) {
        fr.cg95.cvq.business.users.Adult modelAdult = null;
        if (foResponsible.getChildLegalResponsibleLegalResponsibleId() != 0)
            try {
                modelAdult = BusinessManager.getInstance().getAdultService().getById(
                                new Long(foResponsible.getChildLegalResponsibleLegalResponsibleId()));
            } catch (CvqObjectNotFoundException e1) {
            } catch (CvqException e1) {
            }
        if (modelAdult == null)
            modelAdult = new fr.cg95.cvq.business.users.Adult();

        // only change adult's address if there are real modifications
        Address originalAddress = modelAdult.getAdress();
        if ((originalAddress == null) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation(),
                        originalAddress.getAdditionalDeliveryInformation()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation(),
                        originalAddress.getAdditionalGeographicalInformation()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressStreetNumber(),
                        originalAddress.getStreetNumber()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressStreetName(),
                         originalAddress.getStreetName()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService(),
                        originalAddress.getPlaceNameOrService()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressPostalCode(),
                        originalAddress.getPostalCode()) ||
                !equals(foResponsible.getChildLegalResponsibleLegalResponsibleAddressCity(),
                        originalAddress.getCity())) {
            Address address = new Address();
            address.setAdditionalDeliveryInformation(
                    foResponsible.getChildLegalResponsibleLegalResponsibleAddressAdditionalDeliveryInformation());
            address.setAdditionalGeographicalInformation(
                    foResponsible.getChildLegalResponsibleLegalResponsibleAddressAdditionalGeographicalInformation());
            address.setStreetNumber(
                    foResponsible.getChildLegalResponsibleLegalResponsibleAddressStreetNumber());
            address.setStreetName(
                    foResponsible.getChildLegalResponsibleLegalResponsibleAddressStreetName());
            address.setPlaceNameOrService(
                    foResponsible.getChildLegalResponsibleLegalResponsibleAddressPlaceNameOrService());
            address.setCity(foResponsible.getChildLegalResponsibleLegalResponsibleAddressCity());
            address.setPostalCode(foResponsible.getChildLegalResponsibleLegalResponsibleAddressPostalCode());
            modelAdult.setAdress(address);
        }        
        modelAdult.setBirthCity(foResponsible.getChildLegalResponsibleLegalResponsibleBirthPlaceCity());
        modelAdult.setBirthCountry(foResponsible.getChildLegalResponsibleLegalResponsibleBirthPlaceCountry());
        modelAdult.setBirthPostalCode(foResponsible.getChildLegalResponsibleLegalResponsibleBirthPlacePostalCode());

        if (foResponsible.getChildLegalResponsibleLegalResponsibleBirthDate() != null)
            modelAdult.setBirthDate(foResponsible.getChildLegalResponsibleLegalResponsibleBirthDate().getTime());
        
        modelAdult.setCfbn(foResponsible.getChildLegalResponsibleLegalResponsibleCfbn());
        modelAdult.setEmail(foResponsible.getChildLegalResponsibleLegalResponsibleEmail());
        modelAdult.setFamilyStatus(foResponsible.getChildLegalResponsibleLegalResponsibleFamilyStatus());
        modelAdult.setFirstName(foResponsible.getChildLegalResponsibleLegalResponsibleFirstName());
        modelAdult.setFirstName2(foResponsible.getChildLegalResponsibleLegalResponsibleFirstName2());
        modelAdult.setFirstName3(foResponsible.getChildLegalResponsibleLegalResponsibleFirstName3());
        modelAdult.setHomePhone(foResponsible.getChildLegalResponsibleLegalResponsibleHomePhone());
        modelAdult.setLastName(foResponsible.getChildLegalResponsibleLegalResponsibleLastName());
        modelAdult.setMaidenName(foResponsible.getChildLegalResponsibleLegalResponsibleMaidenName());
        modelAdult.setMobilePhone(foResponsible.getChildLegalResponsibleLegalResponsibleMobilePhone());
        modelAdult.setNameOfUse(foResponsible.getChildLegalResponsibleLegalResponsibleNameOfUse());
        modelAdult.setOfficePhone(foResponsible.getChildLegalResponsibleLegalResponsibleOfficePhone());
        modelAdult.setProfession(foResponsible.getChildLegalResponsibleLegalResponsibleProfession());
        modelAdult.setTitleType(foResponsible.getChildLegalResponsibleLegalResponsibleTitle());

        return modelAdult;
    }

    private boolean equals(Object o1, Object o2) {
        if (o1 != null)
            return o1.equals(o2);
        
        return o2 == null;
    }
    
}
