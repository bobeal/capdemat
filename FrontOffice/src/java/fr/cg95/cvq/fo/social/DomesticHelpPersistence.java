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
import fr.cg95.cvq.fo.social.domestichelp.form.Residences;
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
import fr.cg95.cvq.xml.social.DhrAssetKindType;
import fr.cg95.cvq.xml.social.DhrAssetTypeType;
import fr.cg95.cvq.xml.social.DhrDwellingType;
import fr.cg95.cvq.xml.social.DhrNotRealAssetType;
import fr.cg95.cvq.xml.social.DhrPensionPlanType;
import fr.cg95.cvq.xml.social.DhrRealAssetType;
import fr.cg95.cvq.xml.social.DhrRequestKindType;
import fr.cg95.cvq.xml.social.DhrRequesterHasSpouse;
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
            cvqRequest.setList("assets", new StageFormList(this, cvqRequest));
            cvqRequest.setList("notrealasset", new StageFormList(this, cvqRequest));

            setAuthorizedSubjects(familyHome);
        }
        if (request.getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER) == null) {
            request.setAttribute(ProcessWizardState.NAME_REQUEST_PARAMETER, "eDomestichelp");

        } else {
            DomesticHelpRequest dhr = DomesticHelpRequest.Factory.newInstance();

            // get the index of the element from the selection list from the
            // HTTP request
            int index = Integer.parseInt(request
                    .getParameter(ProcessWizardState.INDEX_REQUEST_PARAMETER));
            AdultForm adult = (AdultForm) familyHome.getSelectionListWithoutCurrent().toArray()[index];

            familyHome.setIndividualToRegister(adult);

            StageFormList list = new StageFormList(this, request.getSession());
            list.addAll(familyHome.getSelectionListWithoutCurrent());

            cvqRequest.setList("spouselist", list);

            initializeSubject(dhr, adult.getId());

            dhr.setRequesterRequestKind(DhrRequestKindType.INDIVIDUAL);
            dhr.addNewRequesterFamilyReferent().addNewFamilyReferentAddress();

            RequesterSpouseType spouse = dhr.addNewRequesterSpouse();
            spouse.addNewSpouseInformation().addNewBirthPlace();
            spouse.addNewSpouseEmployerAddress();
            spouse.getSpouseInformation().setTitle(TitleType.UNKNOWN);
            spouse.getSpouseInformation().setFamilyStatus(FamilyStatusType.OTHER);

            dhr.addNewRequesterSituation().addNewTutorAddress();

            CurrentDwellingType currentDwelling = dhr.addNewCurrentDwelling();
            currentDwelling.setCurrentDwellingType(DhrDwellingType.AUTRE);
            AddressType currentDwellingAddress = currentDwelling.addNewCurrentDwellingAddress();

            currentDwellingAddress.setAdditionalDeliveryInformation(adult.getAdditionalDeliveryInformation());
            currentDwellingAddress.setAdditionalGeographicalInformation(adult
                    .getAdditionalGeographicalInformation());
            currentDwellingAddress.setStreetNumber(adult.getStreetNumber());
            currentDwellingAddress.setStreetName(adult.getStreetName());
            currentDwellingAddress.setPlaceNameOrService(adult.getPlaceNameOrService());
            currentDwellingAddress.setCity(adult.getCity());
            currentDwellingAddress.setPostalCode(adult.getPostalCode());

            dhr.addNewPreviousDwelling().addNewPreviousDwellingAddress();

            dhr.addNewRequesterIncomes();
            dhr.addNewRequesterSpouseIncomes();
            dhr.addNewNotRealAssets();
            dhr.addNewNotRealAssets().addNewAssetAddress();
            dhr.addNewNotRealAssets().addNewAssetBeneficiaryAddress();
            dhr.addNewNotRealAssets().addNewAssetNotaryAddress();

            dhr.addNewRealAssets().addNewRealAssetAddress();
            dhr.addNewTaxesAmount();
            dhr.setRequesterHasSpouse(DhrRequesterHasSpouse.FALSE);

            familyHome.setSpouse(false);
            if (dhr.getSubject().getAdult().getFamilyStatus().equals(FamilyStatusType.MARRIED)
                    || dhr.getSubject().getAdult().getFamilyStatus().equals(
                            FamilyStatusType.COMMON_LAW_MARRIAGE)) {
                if (!familyHome.getSelectionListWithoutCurrent().isEmpty()) {
                    familyHome.setSpouse(true);
                    dhr.setRequesterHasSpouse(DhrRequesterHasSpouse.TRUE);
                }
            }
            return dhr;
        }
        return null;
    }

    public Long validateRequest(HttpServletRequest request, Request cvqRequest,
            Object xmlRequestData) throws Exception {
        DomesticHelpRequestDocument.DomesticHelpRequest xmlRequest = (DomesticHelpRequestDocument.DomesticHelpRequest) xmlRequestData;
        // Check we have a valid spouse
        if (xmlRequest.getRequesterSpouse().getSpouseInformation().getId() == 0) {
            xmlRequest.unsetRequesterSpouse();
            xmlRequest.addNewRequesterSpouse();
        }
        
        // Save old residences
        Calendar threeMonthsAgo = Calendar.getInstance();

        // Save seperate lists
        
        xmlRequest.setRealAssetsArray(saveAssets(cvqRequest.getList("assets")));
        xmlRequest.setNotRealAssetsArray(saveNotRealAssets(cvqRequest.getList("notrealasset")));

        DomesticHelpRequestDocument document = DomesticHelpRequestDocument.Factory.newInstance();
        document.setDomesticHelpRequest(xmlRequest);
        
        IDomesticHelpRequestService service = (IDomesticHelpRequestService) BusinessManager.getAc()
                .getBean(IDomesticHelpRequestService.SERVICE_NAME);

        return service.create(document.getDomNode());
    }

    public String onStateChange(HttpServletRequest request, IStageForm stageForm, String state,
            String newState) {

        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        String correctedState = newState;
        if (stageForm instanceof Subject) {
            Subject subject = (Subject) stageForm;

            if (newState.equals("requestkind")) {
                if (!familyHome.getSpouse())
                    correctedState = "referent";
            } else if (newState.equals("displayrequestkind")) {
                if (!familyHome.getSpouse())
                    correctedState = "displayreferent";
            }
            if (state.equals("referent")) {
                checkSubjectFormReferentState(subject);
            } else if (state.equals("subject")) {
                if (newState.equals("tutor")) {
                    checkSubjectFormSubjectState(subject);
                    if (!subject.getRequesterSituationTutorPresence()) {
                        if (!familyHome.getSpouse()) {
                            correctedState = "displayreferent";
                        } else {
                            correctedState = "spouseselect";
                        }
                    }
                } else if (newState.equals("displayrequestkind")) {
                    correctedState = "referent";
                }
            } else if (state.equals("tutor")) {
                if (newState.equals("spouseselect")) {
                    if (!familyHome.getSpouse()) {
                        correctedState = "displayreferent";
                    }
                }
            } else if (state.equals("spouse")) {
                checkSubjectFormSpouseState(subject);
            } else if (state.equals("displayrequestkind")) {
                if (newState.equals("tutor")) {
                    if (!subject.getRequesterSituationTutorPresence()) {
                        correctedState = "subject";
                    }
                } else if (newState.equals("spouse") || newState.equals("spouseselect")) {
                    if (!familyHome.getSpouse()) {
                        if (!subject.getRequesterSituationTutorPresence()) {
                            correctedState = "subject";
                        } else {
                            correctedState = "tutor";
                        }
                    }
                }
            } else if (state.equals("displayreferent")) {
                if (!newState.equals("display") && !newState.equals("referent")) {
                    if (familyHome.getSpouse()) {
                        correctedState = "displayrequestkind";
                    } else {
                        if (subject.getRequesterSituationTutorPresence()) {
                            correctedState = "tutor";
                        } else {
                            correctedState = "subject";
                        }
                    }
                }
            } else if (state.equals("display")) {
                if (newState.equals("displaytutor")) {
                    if (!subject.getRequesterSituationTutorPresence()) {
                        if (!familyHome.getSpouse()) {
                            correctedState = null;
                        } else {
                            correctedState = "displayspouse";
                        }
                    }
                }
            } else if (state.equals("displaytutor")) {
                if (newState.equals("displayspouse")) {
                    if (!familyHome.getSpouse()) {
                        correctedState = null;
                    }
                }
            } else if (state.equals("displayspouse")) {
                if (newState.equals("displaytutor")) {
                    if (!subject.getRequesterSituationTutorPresence()) {
                        correctedState = "display";
                    }
                }
            }
        } else if (stageForm instanceof Residences) {
            Residences residences = (Residences) stageForm;
            Calendar threeMonthsAgo = Calendar.getInstance();
            threeMonthsAgo.add(Calendar.MONTH, -3);
            if (state.equals("current")) {
                if (newState.equals("previous")) {
                    if (((residences.getCurrentDwellingCurrentDwellingArrivalDate() == null) || residences
                            .getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                            && !residences.getCurrentDwellingCurrentDwellingType().equals(
                                    DhrDwellingType.ETABLISSMENT_PA.toString())) {
                        checkResidencesFormCurrentState(residences);
                        correctedState = "display";
                    } else {
                        residences.setPreviousDwellingPreviousDwellingDepartureDate(residences
                                .getCurrentDwellingCurrentDwellingArrivalDate());
                    }
                }
            } else if (state.equals("display")) {
                if (newState.equals("displayprevious")) {
                    if (((residences.getCurrentDwellingCurrentDwellingArrivalDate() == null) || residences
                            .getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                            && !residences.getCurrentDwellingCurrentDwellingType().equals(
                                    DhrDwellingType.ETABLISSMENT_PA.toString())) {
                        correctedState = null;
                    }
                } else if (newState.equals("previous")) {
                    if (((residences.getCurrentDwellingCurrentDwellingArrivalDate() == null) || residences
                            .getCurrentDwellingCurrentDwellingArrivalDate().before(threeMonthsAgo))
                            && !residences.getCurrentDwellingCurrentDwellingType().equals(
                                    DhrDwellingType.ETABLISSMENT_PA.toString())) {
                        correctedState = "current";
                    }
                }
            }
        } else if (stageForm instanceof Resources) {
            Resources resources = (Resources) stageForm;
            if (state.equals("subject")) {
                if (newState.equals("spouse")) {
                    if (!familyHome.getSpouse()) {
                        correctedState = "display";
                    }
                }
            } else if (state.equals("display")) {
                if (newState.equals("spouse")) {
                    if (!familyHome.getSpouse())
                        correctedState = "subject";
                }
                if (newState.equals("displayspouse")) {
                    if (!familyHome.getSpouse())
                        correctedState = null;
                }
            }
        }
        return correctedState;
    }

    public String onStageChange(HttpServletRequest request, IStageForm stageForm, String stageName) {
        return null;
    }

    public void onSelect(Object data, Object stageForm) {
        if ((stageForm instanceof AdultForm) && (data instanceof HttpSession)) {
            try {
                Adult spouse = (Adult) BusinessManager.getInstance().findIndividual(
                        ((AdultForm) stageForm).getId());
                Subject subject = (Subject) IStageForm.getStageForm((HttpSession) data);
                Request cvqRequest = getCvqRequest((HttpSession) data);
                DomesticHelpRequest dhr = (DomesticHelpRequest) cvqRequest.getData();

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

    private DhrRealAssetType[] saveAssets(Collection list) {
        ArrayList<DhrRealAssetType> xmlArray = new ArrayList<DhrRealAssetType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Patrimony data = (Patrimony) iter.next();
            DhrRealAssetType xmlData = DhrRealAssetType.Factory.newInstance();

            AddressType address = xmlData.addNewRealAssetAddress();
            address.setAdditionalDeliveryInformation(data
                    .getRealAssetsRealAssetAddressAdditionalDeliveryInformation());
            address.setAdditionalGeographicalInformation(data
                    .getRealAssetsRealAssetAddressAdditionalGeographicalInformation());
            address.setCity(data.getRealAssetsRealAssetAddressCity());
            address.setPlaceNameOrService(data.getRealAssetsRealAssetAddressPlaceNameOrService());
            address.setPostalCode(data.getRealAssetsRealAssetAddressPostalCode());
            address.setStreetName(data.getRealAssetsRealAssetAddressStreetName());
            address.setStreetNumber(data.getRealAssetsRealAssetAddressStreetNumber());

            xmlData.setRealAssetNetFloorArea(data.getRealAssetsRealAssetNetFloorArea());
            xmlData.setRealAssetValue(data.getRealAssetsRealAssetValue());

            xmlArray.add(xmlData);
        }

        return xmlArray.toArray(new DhrRealAssetType[0]);
    }

    private DhrNotRealAssetType[] saveNotRealAssets(Collection list) {
        ArrayList<DhrNotRealAssetType> xmlArray = new ArrayList<DhrNotRealAssetType>();

        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Patrimony data = (Patrimony) iter.next();
            DhrNotRealAssetType xmlData = DhrNotRealAssetType.Factory.newInstance();

            xmlData.setAssetKind(DhrAssetKindType.Enum.forString(data.getNotRealAssetsAssetKind()));
            xmlData.setAssetType(DhrAssetTypeType.Enum.forString(data.getNotRealAssetsAssetType()));

            AddressType assetAddress = xmlData.addNewAssetAddress();
            assetAddress.setAdditionalDeliveryInformation(data
                    .getNotRealAssetsAssetAddressAdditionalDeliveryInformation());
            assetAddress.setAdditionalGeographicalInformation(data
                    .getNotRealAssetsAssetAddressAdditionalGeographicalInformation());
            assetAddress.setCity(data.getNotRealAssetsAssetAddressCity());
            assetAddress.setPlaceNameOrService(data
                    .getNotRealAssetsAssetAddressPlaceNameOrService());
            assetAddress.setPostalCode(data.getNotRealAssetsAssetAddressPostalCode());
            assetAddress.setStreetName(data.getNotRealAssetsAssetAddressStreetName());
            assetAddress.setStreetNumber(data.getNotRealAssetsAssetAddressStreetNumber());

            xmlData.setAssetBeneficiaryFirstName(data.getNotRealAssetsAssetBeneficiaryFirstName());
            xmlData.setAssetBeneficiaryName(data.getNotRealAssetsAssetBeneficiaryName());

            AddressType beneficiaryAddress = xmlData.addNewAssetBeneficiaryAddress();
            beneficiaryAddress.setAdditionalDeliveryInformation(data
                    .getNotRealAssetsAssetBeneficiaryAddressAdditionalDeliveryInformation());
            beneficiaryAddress.setAdditionalGeographicalInformation(data
                    .getNotRealAssetsAssetBeneficiaryAddressAdditionalGeographicalInformation());
            beneficiaryAddress.setCity(data.getNotRealAssetsAssetBeneficiaryAddressCity());
            beneficiaryAddress.setPlaceNameOrService(data
                    .getNotRealAssetsAssetBeneficiaryAddressPlaceNameOrService());
            beneficiaryAddress.setPostalCode(data
                    .getNotRealAssetsAssetBeneficiaryAddressPostalCode());
            beneficiaryAddress.setStreetName(data
                    .getNotRealAssetsAssetBeneficiaryAddressStreetName());
            beneficiaryAddress.setStreetNumber(data
                    .getNotRealAssetsAssetBeneficiaryAddressStreetNumber());

            xmlData.setAssetValue(data.getNotRealAssetsAssetValue());
            xmlData.setAssetDate(data.getNotRealAssetsAssetDate());
            xmlData.setAssetNotaryName(data.getNotRealAssetsAssetNotaryName());

            AddressType notaryAddress = xmlData.addNewAssetNotaryAddress();
            notaryAddress.setAdditionalDeliveryInformation(data
                    .getNotRealAssetsAssetNotaryAddressAdditionalDeliveryInformation());
            notaryAddress.setAdditionalGeographicalInformation(data
                    .getNotRealAssetsAssetNotaryAddressAdditionalGeographicalInformation());
            notaryAddress.setCity(data.getNotRealAssetsAssetNotaryAddressCity());
            notaryAddress.setPlaceNameOrService(data
                    .getNotRealAssetsAssetNotaryAddressPlaceNameOrService());
            notaryAddress.setPostalCode(data.getNotRealAssetsAssetNotaryAddressPostalCode());
            notaryAddress.setStreetName(data.getNotRealAssetsAssetNotaryAddressStreetName());
            notaryAddress.setStreetNumber(data.getNotRealAssetsAssetNotaryAddressStreetNumber());

            xmlArray.add(xmlData);
        }
        return xmlArray.toArray(new DhrNotRealAssetType[0]);
    }

    private void checkSubjectFormReferentState(Subject subject) {
        if (!subject.getRequesterFamilyReferentFamilyReferentDesignated()) {
            subject.setRequesterFamilyReferentFamilyReferentName("");
            subject.setRequesterFamilyReferentFamilyReferentFirstName("");
            subject
                    .setRequesterFamilyReferentFamilyReferentAddressAdditionalDeliveryInformation("");
            subject
                    .setRequesterFamilyReferentFamilyReferentAddressAdditionalGeographicalInformation("");
            subject.setRequesterFamilyReferentFamilyReferentAddressCity("");
            subject.setRequesterFamilyReferentFamilyReferentAddressPlaceNameOrService("");
            subject.setRequesterFamilyReferentFamilyReferentAddressPostalCode("");
            subject.setRequesterFamilyReferentFamilyReferentAddressStreetName("");
            subject.setRequesterFamilyReferentFamilyReferentAddressStreetNumber("");
        }
    }

    private void checkSubjectFormSubjectState(Subject subject) {
        if (!subject.getRequesterPensionPlan().equals(DhrPensionPlanType.OTHER.toString())) {
            subject.setPensionPlanPrecision("");
        }
        if (!subject.getRequesterSituationTutorPresence()) {
            subject.setRequesterSituationTutor("");
            subject.setRequesterSituationTutorName("");
            subject.setRequesterSituationTutorAddressAdditionalDeliveryInformation("");
            subject.setRequesterSituationTutorAddressAdditionalGeographicalInformation("");
            subject.setRequesterSituationTutorAddressCity("");
            subject.setRequesterSituationTutorAddressPlaceNameOrService("");
            subject.setRequesterSituationTutorAddressPostalCode("");
            subject.setRequesterSituationTutorAddressStreetName("");
            subject.setRequesterSituationTutorAddressStreetNumber("");
        }
    }

    private void checkSubjectFormSpouseState(Subject subject) {

        if (subject.getRequesterSpouseSpousePensionner()) {
            subject.setRequesterSpouseSpouseOccupation("");
            subject.setRequesterSpouseSpouseEmployer("");
            subject.setRequesterSpouseSpouseEmployerAddressAdditionalDeliveryInformation("");
            subject.setRequesterSpouseSpouseEmployerAddressAdditionalGeographicalInformation("");
            subject.setRequesterSpouseSpouseEmployerAddressCity("");
            subject.setRequesterSpouseSpouseEmployerAddressPlaceNameOrService("");
            subject.setRequesterSpouseSpouseEmployerAddressPostalCode("");
            subject.setRequesterSpouseSpouseEmployerAddressStreetName("");
            subject.setRequesterSpouseSpouseEmployerAddressStreetNumber("");
        } else {
            subject.setRequesterSpouseSpouseComplementaryPensionPlanPrecision("");
            subject.setRequesterSpouseSpousePensionPlan("");
            subject.setRequesterSpouseSpousePensionPlanPrecision("");
        }
    }

    private void checkResidencesFormCurrentState(Residences residences) {
//        residences.setPreviousDwellingPreviousDwellingArrivalDate(null);
//        residences.setPreviousDwellingPreviousDwellingDepartureDate(null);
//        residences.setPreviousDwellingPreviousDwellingAddressAdditionalDeliveryInformation("");
//        residences.setPreviousDwellingPreviousDwellingAddressAdditionalGeographicalInformation("");
//        residences.setPreviousDwellingPreviousDwellingAddressCity("");
//        residences.setPreviousDwellingPreviousDwellingAddressPlaceNameOrService("");
//        residences.setPreviousDwellingPreviousDwellingAddressPostalCode("");
//        residences.setPreviousDwellingPreviousDwellingAddressStreetName("");
//        residences.setPreviousDwellingPreviousDwellingAddressStreetNumber("");
    }
}