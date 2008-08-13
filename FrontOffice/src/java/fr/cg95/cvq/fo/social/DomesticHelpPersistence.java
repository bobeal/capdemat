package fr.cg95.cvq.fo.social;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.IPersistence;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.social.domestichelp.form.Patrimony;
import fr.cg95.cvq.fo.social.domestichelp.form.Previousresidence;
import fr.cg95.cvq.fo.social.domestichelp.form.Residence;
import fr.cg95.cvq.fo.social.domestichelp.form.Resources;
import fr.cg95.cvq.fo.social.domestichelp.form.Subject;
import fr.cg95.cvq.service.social.IDomesticHelpRequestService;
import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.wizard.StageFormList;
import fr.cg95.cvq.wizard.WizardListener;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.AddressType;
import fr.cg95.cvq.xml.common.FamilyStatusType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.TitleType;
import fr.cg95.cvq.xml.social.CurrentDwellingType;
import fr.cg95.cvq.xml.social.DhrDonationAssetType;
import fr.cg95.cvq.xml.social.DhrDonationType;
import fr.cg95.cvq.xml.social.DhrPersonalEstateAndSavingType;
import fr.cg95.cvq.xml.social.DhrPreviousDwellingType;
import fr.cg95.cvq.xml.social.DhrRealAssetType;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument;
import fr.cg95.cvq.xml.social.RequesterSpouseType;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument.DomesticHelpRequest;

public class DomesticHelpPersistence extends IPersistence implements WizardListener {

    public String getServiceName(String definitionName) {
        return IDomesticHelpRequestService.SERVICE_NAME;
    }

    public RequestType createRequest(HttpServletRequest request, Request cvqRequest) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        if (!cvqRequest.isInitialised()) {
            cvqRequest.setDbRequest(new fr.cg95.cvq.business.social.DomesticHelpRequest());

            cvqRequest.setList("residences", new StageFormList(this, cvqRequest));

            cvqRequest.setList("assets", new StageFormList(this, cvqRequest));
            cvqRequest.setList("donation", new StageFormList(this, cvqRequest));
            cvqRequest.setList("savings", new StageFormList(this, cvqRequest));
            
            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eDomestichelp");

        } else {        
            DomesticHelpRequest dhr = DomesticHelpRequest.Factory.newInstance();
            
            // get the index of the element from the selection list from the HTTP request
            int index = Integer.parseInt(request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            AdultForm adult = (AdultForm)familyHome.getSelectionListWithoutCurrent().toArray()[index];
            
            familyHome.setIndividualToRegister(adult);
            
            StageFormList list = new StageFormList(this, request.getSession());
            list.addAll(familyHome.getSelectionListWithoutCurrent());
            
            cvqRequest.setList("spouselist", list);
            
            initializeSubject(dhr, adult.getId());
            
            RequesterSpouseType spouse = dhr.addNewRequesterSpouse();
            spouse.addNewSpouseInformation().addNewBirthPlace();
            spouse.addNewSpouseEmployerAddress();
            spouse.getSpouseInformation().setTitle(TitleType.UNKNOWN);
            spouse.getSpouseInformation().setFamilyStatus(FamilyStatusType.OTHER);

            dhr.addNewRequesterSituation().addNewTutorAddress();

            CurrentDwellingType dwelling = dhr.addNewCurrentDwelling();
            AddressType address = dwelling.addNewCurrentDwellingAddress();

            address.setId(dhr.getSubject().getAdult().getAddress().getId());

            address.setAdditionalDeliveryInformation(adult.getAdditionalDeliveryInformation());
            address.setAdditionalGeographicalInformation(adult.getAdditionalGeographicalInformation());
            address.setStreetNumber(adult.getStreetNumber());
            address.setStreetName(adult.getStreetName());
            address.setPlaceNameOrService(adult.getPlaceNameOrService());
            address.setCity(adult.getCity());
            address.setPostalCode(adult.getPostalCode());
            
            dhr.addNewRequesterIncomes();
            dhr.addNewRequesterSpouseIncomes();
            
            dhr.addNewCapitals();
            dhr.addNewDonations().addNewDonationNotaryAddress();
            dhr.addNewRealAssets().addNewRealAssetAddress();
            dhr.addNewSavings();
            dhr.addNewTaxesAmount();
            
            dhr.addNewMensualExpenses();
            
            familyHome.setSpouse(false);
            if (dhr.getSubject().getAdult().getFamilyStatus().equals(FamilyStatusType.MARRIED) ||
                dhr.getSubject().getAdult().getFamilyStatus().equals(FamilyStatusType.COMMON_LAW_MARRIAGE))
                if (!familyHome.getSelectionListWithoutCurrent().isEmpty())
                    familyHome.setSpouse(true);

            return dhr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {
        DomesticHelpRequestDocument.DomesticHelpRequest xmlRequest = 
            (DomesticHelpRequestDocument.DomesticHelpRequest) xmlRequestData;

        // Check we have a valid spouse
        if (xmlRequest.getRequesterSpouse().getSpouseInformation().getId() == 0) {
            xmlRequest.unsetRequesterSpouse();
            xmlRequest.addNewRequesterSpouse();
        }
        
        // Save old residences
        Calendar threeMonthsAgo = Calendar.getInstance();
        
        threeMonthsAgo.add(Calendar.MONTH, -3);
        if ((xmlRequest.getCurrentDwelling().getCurrentDwellingArrivalDate() != null) &&
                xmlRequest.getCurrentDwelling().getCurrentDwellingArrivalDate().after(threeMonthsAgo)) {
            xmlRequest.setPreviousDwellingsArray(saveResidences(cvqRequest.getList("residences")));
        }
        
        // Save seperate lists
        xmlRequest.setRealAssetsArray(saveAssets(cvqRequest.getList("assets")));
        xmlRequest.setDonationsArray(saveDonation(cvqRequest.getList("donation")));
        xmlRequest.setSavingsArray(saveSavings(cvqRequest.getList("savings")));
        
        DomesticHelpRequestDocument document = 
            DomesticHelpRequestDocument.Factory.newInstance();
        document.setDomesticHelpRequest(xmlRequest);

        IDomesticHelpRequestService service = 
            (IDomesticHelpRequestService)BusinessManager.getAc().getBean(IDomesticHelpRequestService.SERVICE_NAME);
        
        return service.create(document.getDomNode());
    }
    
    public String onStateChange(HttpServletRequest request, IStageForm stageForm, String state, String newState) {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        String correctedState = newState;
        if (stageForm instanceof Subject) {
            Subject subject = (Subject)stageForm;
            if (state.equals("subject")) {
                if (newState.equals("spouseselect") || newState.equals("spouse")) {
                    if (!familyHome.getSpouse()) {
                        correctedState = "tutor";
                        if (!subject.getRequesterSituationTutorPresence())
                            correctedState = "display";
                    }
                }
            } else if (state.equals("spouse")) {
                if (newState.equals("tutor"))
                    if (!subject.getRequesterSituationTutorPresence())
                        correctedState = "display";

            } else if (state.equals("tutor")) {
                if (newState.equals("spouse") || newState.equals("spouseselect")) {
                    if (!familyHome.getSpouse())
                        correctedState = "subject";
                }
            } else if (state.equals("display")) {
                if (newState.equals("displayspouse")) {
                    if (!familyHome.getSpouse()) {
                        correctedState = "displaytutor";
                        if (!subject.getRequesterSituationTutorPresence())
                            correctedState = null;
                    }
                } else if (newState.equals("tutor")) {
                    if (!subject.getRequesterSituationTutorPresence()) {
                        correctedState = "spouse";
                        if (!familyHome.getSpouse())
                            correctedState = "subject";
                    }
                } else if (newState.equals("spouse") || newState.equals("spouseselect")) {
                    if (!familyHome.getSpouse())
                        correctedState = "subject";
                }
            } else if (state.equals("displayspouse")) {
                if (newState.equals("displaytutor"))
                    if (!subject.getRequesterSituationTutorPresence())
                        correctedState = null;

            } else if (state.equals("displaytutor")) {
                if (newState.equals("displayspouse")) {
                    if (!familyHome.getSpouse())
                        correctedState = "display";
                }
            }

        } else if (stageForm instanceof Residence) {
            Request cvqRequest = getCvqRequest(request);
            Residence residence = (Residence)stageForm;
            if (residence.getPreviousDwellings() == null) {
                StageFormList residences = (StageFormList)cvqRequest.getList("residences");
                residence.setPreviousDwellings(residences);
                if (residences.isEmpty())
                    residences.add(new Previousresidence());
            }
            
            Calendar threeMonthsAgo = Calendar.getInstance();
            
            threeMonthsAgo.add(Calendar.MONTH, -3);
            if (state.equals("current")) { 
                if (newState.equals("previous")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                         residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = "display";
                    else
                        ((Previousresidence)residence.getPreviousDwellings().get(0)).
                            setPreviousDwellingsPreviousDwellingDepartureDate(
                                    residence.getCurrentDwellingCurrentDwellingArrivalDate());
                }
            } else if (state.equals("display")) {
                if (newState.equals("previous")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                         residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = "current";

                } else if (newState.equals("displayprevious")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                            residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = null;
                }
            }

        } else if (stageForm instanceof Previousresidence) {
            Calendar threeMonthsAgo = Calendar.getInstance();
            Residence residence = (Residence)request.getSession().getAttribute("Residence");
            
            threeMonthsAgo.add(Calendar.MONTH, -3);
            if (state.equals("current")) { 
                if (newState.equals("previous")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                            residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = "display";
                }
            } else if (state.equals("display")) {
                if (newState.equals("previous")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                            residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = "current";

                } else if (newState.equals("displayprevious")) {
                    if ((residence.getCurrentDwellingCurrentDwellingArrivalDate() == null) ||
                            residence.getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                        correctedState = null;
                }
            }
            
        } else if (stageForm instanceof Resources) {
            
            if (state.equals("subject")) {
                if (newState.equals("spouse")) {
                    if (!familyHome.getSpouse())
                        correctedState = "display";
                }
            } else if (state.equals("display")) {
                if (newState.equals("spouse")) {
                    if (!familyHome.getSpouse())
                        correctedState = "subject";
                }
            }
        }
        return correctedState;
    }
    
    public String onStageChange(HttpServletRequest request, IStageForm stageForm, String stageName) {
        return null;
    }
    
    public void onSelect(Object data, Object stageForm) {
        if ((stageForm instanceof AdultForm) && (data instanceof HttpSession)){
            try {
                Adult spouse = (Adult)BusinessManager.getInstance().findIndividual(((AdultForm)stageForm).getId());
                Subject subject = (Subject)IStageForm.getStageForm((HttpSession)data);
                Request cvqRequest = getCvqRequest((HttpSession)data);
                DomesticHelpRequest dhr = (DomesticHelpRequest)cvqRequest.getData();

                RequesterSpouseType xmlSpouse = dhr.getRequesterSpouse();
                xmlSpouse.setSpouseInformation(Adult.modelToXml(spouse));

                if (spouse.getBirthDate() != null) {
                    Calendar date = Calendar.getInstance();
                    date.setTime(spouse.getBirthDate());
                    subject.setRequesterSpouseSpouseInformationBirthDate(date);
                }
                subject.setRequesterSpouseSpouseInformationBirthPlaceCity(spouse.getBirthCity());
                subject.setRequesterSpouseSpouseInformationFirstName(spouse.getFirstName());
                subject.setRequesterSpouseSpouseInformationLastName(spouse.getLastName());
                subject.setRequesterSpouseSpouseInformationMaidenName(spouse.getMaidenName());
                
            } catch (CvqException e) {
                e.getMessage();
            }
        }
        super.onSelect(data, stageForm);
    }

    private DhrPreviousDwellingType[] saveResidences(Collection list) {
        ArrayList<DhrPreviousDwellingType> xmlArray = new ArrayList<DhrPreviousDwellingType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Previousresidence data = (Previousresidence)iter.next();
            DhrPreviousDwellingType xmlData = DhrPreviousDwellingType.Factory.newInstance();
            
            AddressType address = xmlData.addNewPreviousDwellingAddress();
         // TODO Better refactor this, to respect Address Normalisation
            address.setStreetName(data.getPreviousDwellingsPreviousDwellingAddressStreetName());
            address.setCity(data.getPreviousDwellingsPreviousDwellingAddressCity());
            address.setPostalCode(data.getPreviousDwellingsPreviousDwellingAddressPostalCode());
            
            xmlData.setPreviousDwellingArrivalDate(data.getPreviousDwellingsPreviousDwellingArrivalDate());
            xmlData.setPreviousDwellingDepartureDate(data.getPreviousDwellingsPreviousDwellingDepartureDate());
            
            xmlArray.add(xmlData);
        }
        
        return xmlArray.toArray(new DhrPreviousDwellingType[0]);
    }
    
    private DhrRealAssetType[] saveAssets(Collection list) {
        ArrayList<DhrRealAssetType> xmlArray = new ArrayList<DhrRealAssetType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Patrimony data = (Patrimony)iter.next();
            DhrRealAssetType xmlData = DhrRealAssetType.Factory.newInstance();
            
            AddressType address = xmlData.addNewRealAssetAddress();
         // TODO Better refactor this, to respect Address Normalisation
            address.setStreetName(data.getRealAssetsRealAssetAddressStreetName());
            address.setCity(data.getRealAssetsRealAssetAddressCity());
            address.setPostalCode(data.getRealAssetsRealAssetAddressPostalCode());
            
            xmlData.setRealAssetCadastre(data.getRealAssetsRealAssetCadastre());
            xmlData.setRealAssetNetFloorArea(data.getRealAssetsRealAssetNetFloorArea());
            xmlData.setRealAssetValue(data.getRealAssetsRealAssetValue());
            
            xmlArray.add(xmlData);
        }
        
        return xmlArray.toArray(new DhrRealAssetType[0]);
    }
    
    private DhrDonationType[] saveDonation(Collection list) {
        ArrayList<DhrDonationType> xmlArray = new ArrayList<DhrDonationType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Patrimony data = (Patrimony)iter.next();
            DhrDonationType xmlData = DhrDonationType.Factory.newInstance();
            
            xmlData.setDonationAsset(DhrDonationAssetType.Enum.forString(data.getDonationsDonationAsset()));
            xmlData.setDonationAssetPlace(data.getDonationsDonationAssetPlace());
            xmlData.setDonationBeneficiaryFirstName(data.getDonationsDonationBeneficiaryFirstName());
            xmlData.setDonationBeneficiaryName(data.getDonationsDonationBeneficiaryName());
            xmlData.setDonationDate(data.getDonationsDonationDate());

            AddressType address = xmlData.addNewDonationNotaryAddress();
         // TODO Better refactor this, to respect Address Normalisation
            address.setStreetName(data.getDonationsDonationNotaryAddressStreetName());
            address.setCity(data.getDonationsDonationNotaryAddressCity());
            address.setPostalCode(data.getDonationsDonationNotaryAddressPostalCode());

            xmlData.setDonationValue(data.getDonationsDonationValue());
            
            xmlArray.add(xmlData);
        }
        
        return xmlArray.toArray(new DhrDonationType[0]);
    }
    
    private DhrPersonalEstateAndSavingType[] saveSavings(Collection list) {
        ArrayList<DhrPersonalEstateAndSavingType> xmlArray = new ArrayList<DhrPersonalEstateAndSavingType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Patrimony data = (Patrimony)iter.next();
            DhrPersonalEstateAndSavingType xmlData = DhrPersonalEstateAndSavingType.Factory.newInstance();
            
            xmlData.setPaybookAmount(data.getSavingsPaybookAmount());
            xmlData.setPaybookNumber(data.getSavingsPaybookNumber());
            
            xmlArray.add(xmlData);
        }
        
        return xmlArray.toArray(new DhrPersonalEstateAndSavingType[0]);
    }

}
