package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="domestic_help_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class DomesticHelpRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public DomesticHelpRequest() {
        super();
        familyReferentDesignated = Boolean.valueOf(false);
        spouseMoreThan15YearsInFrance = Boolean.valueOf(false);
        tutorPresence = Boolean.valueOf(false);
        moreThan15YearsInFrance = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        DomesticHelpRequestDocument object = (DomesticHelpRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DomesticHelpRequestDocument domesticHelpRequestDoc = DomesticHelpRequestDocument.Factory.newInstance();
        DomesticHelpRequestDocument.DomesticHelpRequest domesticHelpRequest = domesticHelpRequestDoc.addNewDomesticHelpRequest();
        super.fillCommonXmlInfo(domesticHelpRequest);
        if (this.notRealAssetsValuesTotal != null)
            domesticHelpRequest.setNotRealAssetsValuesTotal(new BigInteger(this.notRealAssetsValuesTotal.toString()));
        int i = 0;
        if (notRealAssets != null) {
            fr.cg95.cvq.xml.request.social.DhrNotRealAssetType[] notRealAssetsTypeTab = new fr.cg95.cvq.xml.request.social.DhrNotRealAssetType[notRealAssets.size()];
            Iterator notRealAssetsIt = notRealAssets.iterator();
            while (notRealAssetsIt.hasNext()) {
                DhrNotRealAsset object = (DhrNotRealAsset) notRealAssetsIt.next();
                notRealAssetsTypeTab[i] = (DhrNotRealAssetType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setNotRealAssetsArray(notRealAssetsTypeTab);
        }
        CurrentDwellingType currentDwellingTypeCurrentDwelling = domesticHelpRequest.addNewCurrentDwelling();
        if (this.currentDwellingType != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingType(fr.cg95.cvq.xml.request.social.DhrDwellingType.Enum.forString(this.currentDwellingType.toString()));
        TaxesAmountType taxesAmountTypeTaxesAmount = domesticHelpRequest.addNewTaxesAmount();
        if (this.professionalTaxes != null)
            taxesAmountTypeTaxesAmount.setProfessionalTaxes(new BigInteger(this.professionalTaxes.toString()));
        SpouseIncomesType spouseIncomesTypeRequesterSpouseIncomes = domesticHelpRequest.addNewRequesterSpouseIncomes();
        if (this.spousePensions != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpousePensions(new BigInteger(this.spousePensions.toString()));
        if (this.taxesTotal != null)
            taxesAmountTypeTaxesAmount.setTaxesTotal(new BigInteger(this.taxesTotal.toString()));
        RequesterSituationType requesterSituationTypeRequesterSituation = domesticHelpRequest.addNewRequesterSituation();
        if (this.tutorAddress != null)
            requesterSituationTypeRequesterSituation.setTutorAddress(Address.modelToXml(this.tutorAddress));
        i = 0;
        if (realAssets != null) {
            fr.cg95.cvq.xml.request.social.DhrRealAssetType[] realAssetsTypeTab = new fr.cg95.cvq.xml.request.social.DhrRealAssetType[realAssets.size()];
            Iterator realAssetsIt = realAssets.iterator();
            while (realAssetsIt.hasNext()) {
                DhrRealAsset object = (DhrRealAsset) realAssetsIt.next();
                realAssetsTypeTab[i] = (DhrRealAssetType) object.modelToXml();
                i = i + 1;
            }
            domesticHelpRequest.setRealAssetsArray(realAssetsTypeTab);
        }
        domesticHelpRequest.setPensionPlanPrecision(this.pensionPlanPrecision);
        RequesterSpouseType requesterSpouseTypeRequesterSpouse = domesticHelpRequest.addNewRequesterSpouse();
        requesterSpouseTypeRequesterSpouse.setSpouseComplementaryPensionPlanPrecision(this.spouseComplementaryPensionPlanPrecision);
        RequesterFamilyReferentType requesterFamilyReferentTypeRequesterFamilyReferent = domesticHelpRequest.addNewRequesterFamilyReferent();
        if (this.familyReferentAddress != null)
            requesterFamilyReferentTypeRequesterFamilyReferent.setFamilyReferentAddress(Address.modelToXml(this.familyReferentAddress));
        if (this.familyReferentDesignated != null)
            requesterFamilyReferentTypeRequesterFamilyReferent.setFamilyReferentDesignated(this.familyReferentDesignated.booleanValue());
        date = this.currentDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            currentDwellingTypeCurrentDwelling.setCurrentDwellingArrivalDate(calendar);
        }
        if (this.incomeTax != null)
            taxesAmountTypeTaxesAmount.setIncomeTax(new BigInteger(this.incomeTax.toString()));
        if (this.spouseMoreThan15YearsInFrance != null)
            requesterSpouseTypeRequesterSpouse.setSpouseMoreThan15YearsInFrance(this.spouseMoreThan15YearsInFrance.booleanValue());
        if (this.requesterRequestKind != null)
            domesticHelpRequest.setRequesterRequestKind(fr.cg95.cvq.xml.request.social.DhrRequestKindType.Enum.forString(this.requesterRequestKind.toString()));
        requesterSituationTypeRequesterSituation.setTutorName(this.tutorName);
        if (this.spouseAllowances != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseAllowances(new BigInteger(this.spouseAllowances.toString()));
        if (this.currentDwellingNetFloorArea != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingNetFloorArea(new BigInteger(this.currentDwellingNetFloorArea.toString()));
        if (this.currentDwellingStatus != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingStatus(fr.cg95.cvq.xml.request.social.DhrDwellingStatusType.Enum.forString(this.currentDwellingStatus.toString()));
        requesterSpouseTypeRequesterSpouse.setSpouseEmployer(this.spouseEmployer);
        if (this.requesterPensionPlan != null)
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.xml.request.social.DhrPensionPlanType.Enum.forString(this.requesterPensionPlan.toString()));
        if (this.nationality != null)
            domesticHelpRequest.setNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.nationality.toString()));
        if (this.realAssetsValuesTotal != null)
            domesticHelpRequest.setRealAssetsValuesTotal(new BigInteger(this.realAssetsValuesTotal.toString()));
        if (this.spouseEmployerAddress != null)
            requesterSpouseTypeRequesterSpouse.setSpouseEmployerAddress(Address.modelToXml(this.spouseEmployerAddress));
        domesticHelpRequest.setComplementaryPensionPlanPrecision(this.complementaryPensionPlanPrecision);
        if (this.spouseNationality != null)
            requesterSpouseTypeRequesterSpouse.setSpouseNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.spouseNationality.toString()));
        DhrPreviousDwellingType dhrPreviousDwellingTypePreviousDwelling = domesticHelpRequest.addNewPreviousDwelling();
        if (this.previousDwellingAddress != null)
            dhrPreviousDwellingTypePreviousDwelling.setPreviousDwellingAddress(Address.modelToXml(this.previousDwellingAddress));
        if (this.currentDwellingAddress != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingAddress(Address.modelToXml(this.currentDwellingAddress));
        currentDwellingTypeCurrentDwelling.setCurrentDwellingPersonalPhone(this.currentDwellingPersonalPhone);
        if (this.spouseInformation != null)
            requesterSpouseTypeRequesterSpouse.setSpouseInformation(Adult.modelToXml(this.spouseInformation));
        if (this.tutorPresence != null)
            requesterSituationTypeRequesterSituation.setTutorPresence(this.tutorPresence.booleanValue());
        RequesterIncomesType requesterIncomesTypeRequesterIncomes = domesticHelpRequest.addNewRequesterIncomes();
        if (this.requesterIncomesAnnualTotal != null)
            requesterIncomesTypeRequesterIncomes.setRequesterIncomesAnnualTotal(new BigInteger(this.requesterIncomesAnnualTotal.toString()));
        if (this.tutor != null)
            requesterSituationTypeRequesterSituation.setTutor(fr.cg95.cvq.xml.request.social.DhrTutorType.Enum.forString(this.tutor.toString()));
        requesterFamilyReferentTypeRequesterFamilyReferent.setFamilyReferentName(this.familyReferentName);
        if (this.spouseRealEstateInvestmentIncome != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseRealEstateInvestmentIncome(new BigInteger(this.spouseRealEstateInvestmentIncome.toString()));
        if (this.localRate != null)
            taxesAmountTypeTaxesAmount.setLocalRate(new BigInteger(this.localRate.toString()));
        if (this.requesterPensions != null)
            requesterIncomesTypeRequesterIncomes.setRequesterPensions(new BigInteger(this.requesterPensions.toString()));
        date = this.spouseFranceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            requesterSpouseTypeRequesterSpouse.setSpouseFranceArrivalDate(calendar);
        }
        requesterFamilyReferentTypeRequesterFamilyReferent.setFamilyReferentFirstName(this.familyReferentFirstName);
        if (this.requesterHasSpouse != null)
            domesticHelpRequest.setRequesterHasSpouse(fr.cg95.cvq.xml.request.social.DhrRequesterHasSpouse.Enum.forString(this.requesterHasSpouse.toString()));
        if (this.propertyTaxes != null)
            taxesAmountTypeTaxesAmount.setPropertyTaxes(new BigInteger(this.propertyTaxes.toString()));
        date = this.previousDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwellingTypePreviousDwelling.setPreviousDwellingArrivalDate(calendar);
        }
        if (this.spouseIncomesAnnualTotal != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseIncomesAnnualTotal(new BigInteger(this.spouseIncomesAnnualTotal.toString()));
        requesterSpouseTypeRequesterSpouse.setSpouseOccupation(this.spouseOccupation);
        date = this.franceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            domesticHelpRequest.setFranceArrivalDate(calendar);
        }
        if (this.requesterAllowances != null)
            requesterIncomesTypeRequesterIncomes.setRequesterAllowances(new BigInteger(this.requesterAllowances.toString()));
        if (this.spousePensionPlan != null)
            requesterSpouseTypeRequesterSpouse.setSpousePensionPlan(fr.cg95.cvq.xml.request.social.DhrPensionPlanType.Enum.forString(this.spousePensionPlan.toString()));
        if (this.moreThan15YearsInFrance != null)
            domesticHelpRequest.setMoreThan15YearsInFrance(this.moreThan15YearsInFrance.booleanValue());
        if (this.requesterFurnitureInvestmentIncome != null)
            requesterIncomesTypeRequesterIncomes.setRequesterFurnitureInvestmentIncome(new BigInteger(this.requesterFurnitureInvestmentIncome.toString()));
        if (this.spouseFurnitureInvestmentIncome != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseFurnitureInvestmentIncome(new BigInteger(this.spouseFurnitureInvestmentIncome.toString()));
        date = this.previousDwellingDepartureDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwellingTypePreviousDwelling.setPreviousDwellingDepartureDate(calendar);
        }
        requesterSpouseTypeRequesterSpouse.setSpousePensionPlanPrecision(this.spousePensionPlanPrecision);
        if (this.spouseNetIncome != null)
            spouseIncomesTypeRequesterSpouseIncomes.setSpouseNetIncome(new BigInteger(this.spouseNetIncome.toString()));
        if (this.requesterRealEstateInvestmentIncome != null)
            requesterIncomesTypeRequesterIncomes.setRequesterRealEstateInvestmentIncome(new BigInteger(this.requesterRealEstateInvestmentIncome.toString()));
        if (this.spousePensionner != null)
            requesterSpouseTypeRequesterSpouse.setSpousePensionner(this.spousePensionner.booleanValue());
        if (this.requesterNetIncome != null)
            requesterIncomesTypeRequesterIncomes.setRequesterNetIncome(new BigInteger(this.requesterNetIncome.toString()));
        if (this.currentDwellingRoomNumber != null)
            currentDwellingTypeCurrentDwelling.setCurrentDwellingRoomNumber(new BigInteger(this.currentDwellingRoomNumber.toString()));
        return domesticHelpRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        DomesticHelpRequestDocument domesticHelpRequestDoc =
            (DomesticHelpRequestDocument) modelToXml();
        return domesticHelpRequestDoc.getDomesticHelpRequest();
    }

    public static DomesticHelpRequest xmlToModel(DomesticHelpRequestDocument domesticHelpRequestDoc) {

        DomesticHelpRequestDocument.DomesticHelpRequest domesticHelpRequestXml = domesticHelpRequestDoc.getDomesticHelpRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DomesticHelpRequest domesticHelpRequest = new DomesticHelpRequest();
        domesticHelpRequest.fillCommonModelInfo(domesticHelpRequest,domesticHelpRequestXml);
        domesticHelpRequest.setNotRealAssetsValuesTotal(domesticHelpRequestXml.getNotRealAssetsValuesTotal());
        List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> notRealAssetsList = new ArrayList<fr.cg95.cvq.business.request.social.DhrNotRealAsset> ();
        if ( domesticHelpRequestXml.sizeOfNotRealAssetsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getNotRealAssetsArray().length; i++) {
                notRealAssetsList.add(DhrNotRealAsset.xmlToModel(domesticHelpRequestXml.getNotRealAssetsArray(i)));
            }
        }
        domesticHelpRequest.setNotRealAssets(notRealAssetsList);
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingType() != null)
            domesticHelpRequest.setCurrentDwellingType(fr.cg95.cvq.business.request.social.DhrDwellingType.forString(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingType().toString()));
        else
            domesticHelpRequest.setCurrentDwellingType(fr.cg95.cvq.business.request.social.DhrDwellingType.getDefaultDhrDwellingType());
        domesticHelpRequest.setProfessionalTaxes(domesticHelpRequestXml.getTaxesAmount().getProfessionalTaxes());
        domesticHelpRequest.setSpousePensions(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpousePensions());
        domesticHelpRequest.setTaxesTotal(domesticHelpRequestXml.getTaxesAmount().getTaxesTotal());
        if (domesticHelpRequestXml.getRequesterSituation().getTutorAddress() != null)
            domesticHelpRequest.setTutorAddress(Address.xmlToModel(domesticHelpRequestXml.getRequesterSituation().getTutorAddress()));
        List<fr.cg95.cvq.business.request.social.DhrRealAsset> realAssetsList = new ArrayList<fr.cg95.cvq.business.request.social.DhrRealAsset> ();
        if ( domesticHelpRequestXml.sizeOfRealAssetsArray() > 0) {
            for (int i = 0; i < domesticHelpRequestXml.getRealAssetsArray().length; i++) {
                realAssetsList.add(DhrRealAsset.xmlToModel(domesticHelpRequestXml.getRealAssetsArray(i)));
            }
        }
        domesticHelpRequest.setRealAssets(realAssetsList);
        domesticHelpRequest.setPensionPlanPrecision(domesticHelpRequestXml.getPensionPlanPrecision());
        domesticHelpRequest.setSpouseComplementaryPensionPlanPrecision(domesticHelpRequestXml.getRequesterSpouse().getSpouseComplementaryPensionPlanPrecision());
        if (domesticHelpRequestXml.getRequesterFamilyReferent().getFamilyReferentAddress() != null)
            domesticHelpRequest.setFamilyReferentAddress(Address.xmlToModel(domesticHelpRequestXml.getRequesterFamilyReferent().getFamilyReferentAddress()));
        domesticHelpRequest.setFamilyReferentDesignated(Boolean.valueOf(domesticHelpRequestXml.getRequesterFamilyReferent().getFamilyReferentDesignated()));
        calendar = domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setCurrentDwellingArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setIncomeTax(domesticHelpRequestXml.getTaxesAmount().getIncomeTax());
        domesticHelpRequest.setSpouseMoreThan15YearsInFrance(Boolean.valueOf(domesticHelpRequestXml.getRequesterSpouse().getSpouseMoreThan15YearsInFrance()));
        if (domesticHelpRequestXml.getRequesterRequestKind() != null)
            domesticHelpRequest.setRequesterRequestKind(fr.cg95.cvq.business.request.social.DhrRequestKindType.forString(domesticHelpRequestXml.getRequesterRequestKind().toString()));
        else
            domesticHelpRequest.setRequesterRequestKind(fr.cg95.cvq.business.request.social.DhrRequestKindType.getDefaultDhrRequestKindType());
        domesticHelpRequest.setTutorName(domesticHelpRequestXml.getRequesterSituation().getTutorName());
        domesticHelpRequest.setSpouseAllowances(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseAllowances());
        domesticHelpRequest.setCurrentDwellingNetFloorArea(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingNetFloorArea());
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingStatus() != null)
            domesticHelpRequest.setCurrentDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.forString(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingStatus().toString()));
        else
            domesticHelpRequest.setCurrentDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.getDefaultDhrDwellingStatusType());
        domesticHelpRequest.setSpouseEmployer(domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployer());
        if (domesticHelpRequestXml.getRequesterPensionPlan() != null)
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.business.request.social.DhrPensionPlanType.forString(domesticHelpRequestXml.getRequesterPensionPlan().toString()));
        else
            domesticHelpRequest.setRequesterPensionPlan(fr.cg95.cvq.business.request.social.DhrPensionPlanType.getDefaultDhrPensionPlanType());
        if (domesticHelpRequestXml.getNationality() != null)
            domesticHelpRequest.setNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getNationality().toString()));
        else
            domesticHelpRequest.setNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
        domesticHelpRequest.setRealAssetsValuesTotal(domesticHelpRequestXml.getRealAssetsValuesTotal());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployerAddress() != null)
            domesticHelpRequest.setSpouseEmployerAddress(Address.xmlToModel(domesticHelpRequestXml.getRequesterSpouse().getSpouseEmployerAddress()));
        domesticHelpRequest.setComplementaryPensionPlanPrecision(domesticHelpRequestXml.getComplementaryPensionPlanPrecision());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseNationality() != null)
            domesticHelpRequest.setSpouseNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getRequesterSpouse().getSpouseNationality().toString()));
        else
            domesticHelpRequest.setSpouseNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
        if (domesticHelpRequestXml.getPreviousDwelling().getPreviousDwellingAddress() != null)
            domesticHelpRequest.setPreviousDwellingAddress(Address.xmlToModel(domesticHelpRequestXml.getPreviousDwelling().getPreviousDwellingAddress()));
        if (domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingAddress() != null)
            domesticHelpRequest.setCurrentDwellingAddress(Address.xmlToModel(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingAddress()));
        domesticHelpRequest.setCurrentDwellingPersonalPhone(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingPersonalPhone());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpouseInformation() != null)
            domesticHelpRequest.setSpouseInformation(Adult.xmlToModel(domesticHelpRequestXml.getRequesterSpouse().getSpouseInformation()));
        domesticHelpRequest.setTutorPresence(Boolean.valueOf(domesticHelpRequestXml.getRequesterSituation().getTutorPresence()));
        domesticHelpRequest.setRequesterIncomesAnnualTotal(domesticHelpRequestXml.getRequesterIncomes().getRequesterIncomesAnnualTotal());
        if (domesticHelpRequestXml.getRequesterSituation().getTutor() != null)
            domesticHelpRequest.setTutor(fr.cg95.cvq.business.request.social.DhrTutorType.forString(domesticHelpRequestXml.getRequesterSituation().getTutor().toString()));
        else
            domesticHelpRequest.setTutor(fr.cg95.cvq.business.request.social.DhrTutorType.getDefaultDhrTutorType());
        domesticHelpRequest.setFamilyReferentName(domesticHelpRequestXml.getRequesterFamilyReferent().getFamilyReferentName());
        domesticHelpRequest.setSpouseRealEstateInvestmentIncome(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseRealEstateInvestmentIncome());
        domesticHelpRequest.setLocalRate(domesticHelpRequestXml.getTaxesAmount().getLocalRate());
        domesticHelpRequest.setRequesterPensions(domesticHelpRequestXml.getRequesterIncomes().getRequesterPensions());
        calendar = domesticHelpRequestXml.getRequesterSpouse().getSpouseFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setSpouseFranceArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setFamilyReferentFirstName(domesticHelpRequestXml.getRequesterFamilyReferent().getFamilyReferentFirstName());
        if (domesticHelpRequestXml.getRequesterHasSpouse() != null)
            domesticHelpRequest.setRequesterHasSpouse(fr.cg95.cvq.business.request.social.DhrRequesterHasSpouse.forString(domesticHelpRequestXml.getRequesterHasSpouse().toString()));
        else
            domesticHelpRequest.setRequesterHasSpouse(fr.cg95.cvq.business.request.social.DhrRequesterHasSpouse.getDefaultDhrRequesterHasSpouse());
        domesticHelpRequest.setPropertyTaxes(domesticHelpRequestXml.getTaxesAmount().getPropertyTaxes());
        calendar = domesticHelpRequestXml.getPreviousDwelling().getPreviousDwellingArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setPreviousDwellingArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setSpouseIncomesAnnualTotal(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseIncomesAnnualTotal());
        domesticHelpRequest.setSpouseOccupation(domesticHelpRequestXml.getRequesterSpouse().getSpouseOccupation());
        calendar = domesticHelpRequestXml.getFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setFranceArrivalDate(calendar.getTime());
        }
        domesticHelpRequest.setRequesterAllowances(domesticHelpRequestXml.getRequesterIncomes().getRequesterAllowances());
        if (domesticHelpRequestXml.getRequesterSpouse().getSpousePensionPlan() != null)
            domesticHelpRequest.setSpousePensionPlan(fr.cg95.cvq.business.request.social.DhrPensionPlanType.forString(domesticHelpRequestXml.getRequesterSpouse().getSpousePensionPlan().toString()));
        else
            domesticHelpRequest.setSpousePensionPlan(fr.cg95.cvq.business.request.social.DhrPensionPlanType.getDefaultDhrPensionPlanType());
        domesticHelpRequest.setMoreThan15YearsInFrance(Boolean.valueOf(domesticHelpRequestXml.getMoreThan15YearsInFrance()));
        domesticHelpRequest.setRequesterFurnitureInvestmentIncome(domesticHelpRequestXml.getRequesterIncomes().getRequesterFurnitureInvestmentIncome());
        domesticHelpRequest.setSpouseFurnitureInvestmentIncome(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseFurnitureInvestmentIncome());
        calendar = domesticHelpRequestXml.getPreviousDwelling().getPreviousDwellingDepartureDate();
        if (calendar != null) {
            domesticHelpRequest.setPreviousDwellingDepartureDate(calendar.getTime());
        }
        domesticHelpRequest.setSpousePensionPlanPrecision(domesticHelpRequestXml.getRequesterSpouse().getSpousePensionPlanPrecision());
        domesticHelpRequest.setSpouseNetIncome(domesticHelpRequestXml.getRequesterSpouseIncomes().getSpouseNetIncome());
        domesticHelpRequest.setRequesterRealEstateInvestmentIncome(domesticHelpRequestXml.getRequesterIncomes().getRequesterRealEstateInvestmentIncome());
        domesticHelpRequest.setSpousePensionner(Boolean.valueOf(domesticHelpRequestXml.getRequesterSpouse().getSpousePensionner()));
        domesticHelpRequest.setRequesterNetIncome(domesticHelpRequestXml.getRequesterIncomes().getRequesterNetIncome());
        domesticHelpRequest.setCurrentDwellingRoomNumber(domesticHelpRequestXml.getCurrentDwelling().getCurrentDwellingRoomNumber());
        return domesticHelpRequest;
    }

    private java.math.BigInteger notRealAssetsValuesTotal;

    public final void setNotRealAssetsValuesTotal(final java.math.BigInteger notRealAssetsValuesTotal) {
        this.notRealAssetsValuesTotal = notRealAssetsValuesTotal;
    }


    /**
     * @hibernate.property
     *  column="not_real_assets_values_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getNotRealAssetsValuesTotal() {
        return this.notRealAssetsValuesTotal;
    }

    private List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> notRealAssets;

    public final void setNotRealAssets(final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> notRealAssets) {
        this.notRealAssets = notRealAssets;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.list-index
     *  column="not_real_assets_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.DhrNotRealAsset"
     */
    public final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> getNotRealAssets() {
        return this.notRealAssets;
    }

    private fr.cg95.cvq.business.request.social.DhrDwellingType currentDwellingType;

    public final void setCurrentDwellingType(final fr.cg95.cvq.business.request.social.DhrDwellingType currentDwellingType) {
        this.currentDwellingType = currentDwellingType;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_type"
     */
    public final fr.cg95.cvq.business.request.social.DhrDwellingType getCurrentDwellingType() {
        return this.currentDwellingType;
    }

    private java.math.BigInteger professionalTaxes;

    public final void setProfessionalTaxes(final java.math.BigInteger professionalTaxes) {
        this.professionalTaxes = professionalTaxes;
    }


    /**
     * @hibernate.property
     *  column="professional_taxes"
     *  type="serializable"
     */
    public final java.math.BigInteger getProfessionalTaxes() {
        return this.professionalTaxes;
    }

    private java.math.BigInteger spousePensions;

    public final void setSpousePensions(final java.math.BigInteger spousePensions) {
        this.spousePensions = spousePensions;
    }


    /**
     * @hibernate.property
     *  column="spouse_pensions"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpousePensions() {
        return this.spousePensions;
    }

    private java.math.BigInteger taxesTotal;

    public final void setTaxesTotal(final java.math.BigInteger taxesTotal) {
        this.taxesTotal = taxesTotal;
    }


    /**
     * @hibernate.property
     *  column="taxes_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getTaxesTotal() {
        return this.taxesTotal;
    }

    private fr.cg95.cvq.business.users.Address tutorAddress;

    public final void setTutorAddress(final fr.cg95.cvq.business.users.Address tutorAddress) {
        this.tutorAddress = tutorAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="tutor_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getTutorAddress() {
        return this.tutorAddress;
    }

    private List<fr.cg95.cvq.business.request.social.DhrRealAsset> realAssets;

    public final void setRealAssets(final List<fr.cg95.cvq.business.request.social.DhrRealAsset> realAssets) {
        this.realAssets = realAssets;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  lazy="false"
     *  cascade="all"
     * @hibernate.key
     *  column="domestic_help_request_id"
     * @hibernate.list-index
     *  column="real_assets_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.social.DhrRealAsset"
     */
    public final List<fr.cg95.cvq.business.request.social.DhrRealAsset> getRealAssets() {
        return this.realAssets;
    }

    private String pensionPlanPrecision;

    public final void setPensionPlanPrecision(final String pensionPlanPrecision) {
        this.pensionPlanPrecision = pensionPlanPrecision;
    }


    /**
     * @hibernate.property
     *  column="pension_plan_precision"
     *  length="50"
     */
    public final String getPensionPlanPrecision() {
        return this.pensionPlanPrecision;
    }

    private String spouseComplementaryPensionPlanPrecision;

    public final void setSpouseComplementaryPensionPlanPrecision(final String spouseComplementaryPensionPlanPrecision) {
        this.spouseComplementaryPensionPlanPrecision = spouseComplementaryPensionPlanPrecision;
    }


    /**
     * @hibernate.property
     *  column="spouse_complementary_pension_plan_precision"
     *  length="50"
     */
    public final String getSpouseComplementaryPensionPlanPrecision() {
        return this.spouseComplementaryPensionPlanPrecision;
    }

    private fr.cg95.cvq.business.users.Address familyReferentAddress;

    public final void setFamilyReferentAddress(final fr.cg95.cvq.business.users.Address familyReferentAddress) {
        this.familyReferentAddress = familyReferentAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="family_referent_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getFamilyReferentAddress() {
        return this.familyReferentAddress;
    }

    private Boolean familyReferentDesignated;

    public final void setFamilyReferentDesignated(final Boolean familyReferentDesignated) {
        this.familyReferentDesignated = familyReferentDesignated;
    }


    /**
     * @hibernate.property
     *  column="family_referent_designated"
     */
    public final Boolean getFamilyReferentDesignated() {
        return this.familyReferentDesignated;
    }

    private java.util.Date currentDwellingArrivalDate;

    public final void setCurrentDwellingArrivalDate(final java.util.Date currentDwellingArrivalDate) {
        this.currentDwellingArrivalDate = currentDwellingArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_arrival_date"
     */
    public final java.util.Date getCurrentDwellingArrivalDate() {
        return this.currentDwellingArrivalDate;
    }

    private java.math.BigInteger incomeTax;

    public final void setIncomeTax(final java.math.BigInteger incomeTax) {
        this.incomeTax = incomeTax;
    }


    /**
     * @hibernate.property
     *  column="income_tax"
     *  type="serializable"
     */
    public final java.math.BigInteger getIncomeTax() {
        return this.incomeTax;
    }

    private Boolean spouseMoreThan15YearsInFrance;

    public final void setSpouseMoreThan15YearsInFrance(final Boolean spouseMoreThan15YearsInFrance) {
        this.spouseMoreThan15YearsInFrance = spouseMoreThan15YearsInFrance;
    }


    /**
     * @hibernate.property
     *  column="spouse_more_than15_years_in_france"
     */
    public final Boolean getSpouseMoreThan15YearsInFrance() {
        return this.spouseMoreThan15YearsInFrance;
    }

    private fr.cg95.cvq.business.request.social.DhrRequestKindType requesterRequestKind;

    public final void setRequesterRequestKind(final fr.cg95.cvq.business.request.social.DhrRequestKindType requesterRequestKind) {
        this.requesterRequestKind = requesterRequestKind;
    }


    /**
     * @hibernate.property
     *  column="requester_request_kind"
     */
    public final fr.cg95.cvq.business.request.social.DhrRequestKindType getRequesterRequestKind() {
        return this.requesterRequestKind;
    }

    private String tutorName;

    public final void setTutorName(final String tutorName) {
        this.tutorName = tutorName;
    }


    /**
     * @hibernate.property
     *  column="tutor_name"
     *  length="38"
     */
    public final String getTutorName() {
        return this.tutorName;
    }

    private java.math.BigInteger spouseAllowances;

    public final void setSpouseAllowances(final java.math.BigInteger spouseAllowances) {
        this.spouseAllowances = spouseAllowances;
    }


    /**
     * @hibernate.property
     *  column="spouse_allowances"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseAllowances() {
        return this.spouseAllowances;
    }

    private java.math.BigInteger currentDwellingNetFloorArea;

    public final void setCurrentDwellingNetFloorArea(final java.math.BigInteger currentDwellingNetFloorArea) {
        this.currentDwellingNetFloorArea = currentDwellingNetFloorArea;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_net_floor_area"
     *  type="serializable"
     */
    public final java.math.BigInteger getCurrentDwellingNetFloorArea() {
        return this.currentDwellingNetFloorArea;
    }

    private fr.cg95.cvq.business.request.social.DhrDwellingStatusType currentDwellingStatus;

    public final void setCurrentDwellingStatus(final fr.cg95.cvq.business.request.social.DhrDwellingStatusType currentDwellingStatus) {
        this.currentDwellingStatus = currentDwellingStatus;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_status"
     */
    public final fr.cg95.cvq.business.request.social.DhrDwellingStatusType getCurrentDwellingStatus() {
        return this.currentDwellingStatus;
    }

    private String spouseEmployer;

    public final void setSpouseEmployer(final String spouseEmployer) {
        this.spouseEmployer = spouseEmployer;
    }


    /**
     * @hibernate.property
     *  column="spouse_employer"
     *  length="50"
     */
    public final String getSpouseEmployer() {
        return this.spouseEmployer;
    }

    private fr.cg95.cvq.business.request.social.DhrPensionPlanType requesterPensionPlan;

    public final void setRequesterPensionPlan(final fr.cg95.cvq.business.request.social.DhrPensionPlanType requesterPensionPlan) {
        this.requesterPensionPlan = requesterPensionPlan;
    }


    /**
     * @hibernate.property
     *  column="requester_pension_plan"
     */
    public final fr.cg95.cvq.business.request.social.DhrPensionPlanType getRequesterPensionPlan() {
        return this.requesterPensionPlan;
    }

    private fr.cg95.cvq.business.users.NationalityType nationality;

    public final void setNationality(final fr.cg95.cvq.business.users.NationalityType nationality) {
        this.nationality = nationality;
    }


    /**
     * @hibernate.property
     *  column="nationality"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.NationalityType getNationality() {
        return this.nationality;
    }

    private java.math.BigInteger realAssetsValuesTotal;

    public final void setRealAssetsValuesTotal(final java.math.BigInteger realAssetsValuesTotal) {
        this.realAssetsValuesTotal = realAssetsValuesTotal;
    }


    /**
     * @hibernate.property
     *  column="real_assets_values_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getRealAssetsValuesTotal() {
        return this.realAssetsValuesTotal;
    }

    private fr.cg95.cvq.business.users.Address spouseEmployerAddress;

    public final void setSpouseEmployerAddress(final fr.cg95.cvq.business.users.Address spouseEmployerAddress) {
        this.spouseEmployerAddress = spouseEmployerAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="spouse_employer_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getSpouseEmployerAddress() {
        return this.spouseEmployerAddress;
    }

    private String complementaryPensionPlanPrecision;

    public final void setComplementaryPensionPlanPrecision(final String complementaryPensionPlanPrecision) {
        this.complementaryPensionPlanPrecision = complementaryPensionPlanPrecision;
    }


    /**
     * @hibernate.property
     *  column="complementary_pension_plan_precision"
     *  length="50"
     */
    public final String getComplementaryPensionPlanPrecision() {
        return this.complementaryPensionPlanPrecision;
    }

    private fr.cg95.cvq.business.users.NationalityType spouseNationality;

    public final void setSpouseNationality(final fr.cg95.cvq.business.users.NationalityType spouseNationality) {
        this.spouseNationality = spouseNationality;
    }


    /**
     * @hibernate.property
     *  column="spouse_nationality"
     *  length="32"
     */
    public final fr.cg95.cvq.business.users.NationalityType getSpouseNationality() {
        return this.spouseNationality;
    }

    private fr.cg95.cvq.business.users.Address previousDwellingAddress;

    public final void setPreviousDwellingAddress(final fr.cg95.cvq.business.users.Address previousDwellingAddress) {
        this.previousDwellingAddress = previousDwellingAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="previous_dwelling_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getPreviousDwellingAddress() {
        return this.previousDwellingAddress;
    }

    private fr.cg95.cvq.business.users.Address currentDwellingAddress;

    public final void setCurrentDwellingAddress(final fr.cg95.cvq.business.users.Address currentDwellingAddress) {
        this.currentDwellingAddress = currentDwellingAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="current_dwelling_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getCurrentDwellingAddress() {
        return this.currentDwellingAddress;
    }

    private String currentDwellingPersonalPhone;

    public final void setCurrentDwellingPersonalPhone(final String currentDwellingPersonalPhone) {
        this.currentDwellingPersonalPhone = currentDwellingPersonalPhone;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_personal_phone"
     *  length="10"
     */
    public final String getCurrentDwellingPersonalPhone() {
        return this.currentDwellingPersonalPhone;
    }

    private fr.cg95.cvq.business.users.Adult spouseInformation;

    public final void setSpouseInformation(final fr.cg95.cvq.business.users.Adult spouseInformation) {
        this.spouseInformation = spouseInformation;
    }


    /**
     * @hibernate.many-to-one
     *  column="spouse_information_id"
     *  class="fr.cg95.cvq.business.users.Adult"
     */
    public final fr.cg95.cvq.business.users.Adult getSpouseInformation() {
        return this.spouseInformation;
    }

    private Boolean tutorPresence;

    public final void setTutorPresence(final Boolean tutorPresence) {
        this.tutorPresence = tutorPresence;
    }


    /**
     * @hibernate.property
     *  column="tutor_presence"
     */
    public final Boolean getTutorPresence() {
        return this.tutorPresence;
    }

    private java.math.BigInteger requesterIncomesAnnualTotal;

    public final void setRequesterIncomesAnnualTotal(final java.math.BigInteger requesterIncomesAnnualTotal) {
        this.requesterIncomesAnnualTotal = requesterIncomesAnnualTotal;
    }


    /**
     * @hibernate.property
     *  column="requester_incomes_annual_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterIncomesAnnualTotal() {
        return this.requesterIncomesAnnualTotal;
    }

    private fr.cg95.cvq.business.request.social.DhrTutorType tutor;

    public final void setTutor(final fr.cg95.cvq.business.request.social.DhrTutorType tutor) {
        this.tutor = tutor;
    }


    /**
     * @hibernate.property
     *  column="tutor"
     */
    public final fr.cg95.cvq.business.request.social.DhrTutorType getTutor() {
        return this.tutor;
    }

    private String familyReferentName;

    public final void setFamilyReferentName(final String familyReferentName) {
        this.familyReferentName = familyReferentName;
    }


    /**
     * @hibernate.property
     *  column="family_referent_name"
     *  length="38"
     */
    public final String getFamilyReferentName() {
        return this.familyReferentName;
    }

    private java.math.BigInteger spouseRealEstateInvestmentIncome;

    public final void setSpouseRealEstateInvestmentIncome(final java.math.BigInteger spouseRealEstateInvestmentIncome) {
        this.spouseRealEstateInvestmentIncome = spouseRealEstateInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="spouse_real_estate_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseRealEstateInvestmentIncome() {
        return this.spouseRealEstateInvestmentIncome;
    }

    private java.math.BigInteger localRate;

    public final void setLocalRate(final java.math.BigInteger localRate) {
        this.localRate = localRate;
    }


    /**
     * @hibernate.property
     *  column="local_rate"
     *  type="serializable"
     */
    public final java.math.BigInteger getLocalRate() {
        return this.localRate;
    }

    private java.math.BigInteger requesterPensions;

    public final void setRequesterPensions(final java.math.BigInteger requesterPensions) {
        this.requesterPensions = requesterPensions;
    }


    /**
     * @hibernate.property
     *  column="requester_pensions"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterPensions() {
        return this.requesterPensions;
    }

    private java.util.Date spouseFranceArrivalDate;

    public final void setSpouseFranceArrivalDate(final java.util.Date spouseFranceArrivalDate) {
        this.spouseFranceArrivalDate = spouseFranceArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="spouse_france_arrival_date"
     */
    public final java.util.Date getSpouseFranceArrivalDate() {
        return this.spouseFranceArrivalDate;
    }

    private String familyReferentFirstName;

    public final void setFamilyReferentFirstName(final String familyReferentFirstName) {
        this.familyReferentFirstName = familyReferentFirstName;
    }


    /**
     * @hibernate.property
     *  column="family_referent_first_name"
     *  length="38"
     */
    public final String getFamilyReferentFirstName() {
        return this.familyReferentFirstName;
    }

    private fr.cg95.cvq.business.request.social.DhrRequesterHasSpouse requesterHasSpouse;

    public final void setRequesterHasSpouse(final fr.cg95.cvq.business.request.social.DhrRequesterHasSpouse requesterHasSpouse) {
        this.requesterHasSpouse = requesterHasSpouse;
    }


    /**
     * @hibernate.property
     *  column="requester_has_spouse"
     */
    public final fr.cg95.cvq.business.request.social.DhrRequesterHasSpouse getRequesterHasSpouse() {
        return this.requesterHasSpouse;
    }

    private java.math.BigInteger propertyTaxes;

    public final void setPropertyTaxes(final java.math.BigInteger propertyTaxes) {
        this.propertyTaxes = propertyTaxes;
    }


    /**
     * @hibernate.property
     *  column="property_taxes"
     *  type="serializable"
     */
    public final java.math.BigInteger getPropertyTaxes() {
        return this.propertyTaxes;
    }

    private java.util.Date previousDwellingArrivalDate;

    public final void setPreviousDwellingArrivalDate(final java.util.Date previousDwellingArrivalDate) {
        this.previousDwellingArrivalDate = previousDwellingArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="previous_dwelling_arrival_date"
     */
    public final java.util.Date getPreviousDwellingArrivalDate() {
        return this.previousDwellingArrivalDate;
    }

    private java.math.BigInteger spouseIncomesAnnualTotal;

    public final void setSpouseIncomesAnnualTotal(final java.math.BigInteger spouseIncomesAnnualTotal) {
        this.spouseIncomesAnnualTotal = spouseIncomesAnnualTotal;
    }


    /**
     * @hibernate.property
     *  column="spouse_incomes_annual_total"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseIncomesAnnualTotal() {
        return this.spouseIncomesAnnualTotal;
    }

    private String spouseOccupation;

    public final void setSpouseOccupation(final String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }


    /**
     * @hibernate.property
     *  column="spouse_occupation"
     *  length="50"
     */
    public final String getSpouseOccupation() {
        return this.spouseOccupation;
    }

    private java.util.Date franceArrivalDate;

    public final void setFranceArrivalDate(final java.util.Date franceArrivalDate) {
        this.franceArrivalDate = franceArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="france_arrival_date"
     */
    public final java.util.Date getFranceArrivalDate() {
        return this.franceArrivalDate;
    }

    private java.math.BigInteger requesterAllowances;

    public final void setRequesterAllowances(final java.math.BigInteger requesterAllowances) {
        this.requesterAllowances = requesterAllowances;
    }


    /**
     * @hibernate.property
     *  column="requester_allowances"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterAllowances() {
        return this.requesterAllowances;
    }

    private fr.cg95.cvq.business.request.social.DhrPensionPlanType spousePensionPlan;

    public final void setSpousePensionPlan(final fr.cg95.cvq.business.request.social.DhrPensionPlanType spousePensionPlan) {
        this.spousePensionPlan = spousePensionPlan;
    }


    /**
     * @hibernate.property
     *  column="spouse_pension_plan"
     */
    public final fr.cg95.cvq.business.request.social.DhrPensionPlanType getSpousePensionPlan() {
        return this.spousePensionPlan;
    }

    private Boolean moreThan15YearsInFrance;

    public final void setMoreThan15YearsInFrance(final Boolean moreThan15YearsInFrance) {
        this.moreThan15YearsInFrance = moreThan15YearsInFrance;
    }


    /**
     * @hibernate.property
     *  column="more_than15_years_in_france"
     */
    public final Boolean getMoreThan15YearsInFrance() {
        return this.moreThan15YearsInFrance;
    }

    private java.math.BigInteger requesterFurnitureInvestmentIncome;

    public final void setRequesterFurnitureInvestmentIncome(final java.math.BigInteger requesterFurnitureInvestmentIncome) {
        this.requesterFurnitureInvestmentIncome = requesterFurnitureInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="requester_furniture_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterFurnitureInvestmentIncome() {
        return this.requesterFurnitureInvestmentIncome;
    }

    private java.math.BigInteger spouseFurnitureInvestmentIncome;

    public final void setSpouseFurnitureInvestmentIncome(final java.math.BigInteger spouseFurnitureInvestmentIncome) {
        this.spouseFurnitureInvestmentIncome = spouseFurnitureInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="spouse_furniture_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseFurnitureInvestmentIncome() {
        return this.spouseFurnitureInvestmentIncome;
    }

    private java.util.Date previousDwellingDepartureDate;

    public final void setPreviousDwellingDepartureDate(final java.util.Date previousDwellingDepartureDate) {
        this.previousDwellingDepartureDate = previousDwellingDepartureDate;
    }


    /**
     * @hibernate.property
     *  column="previous_dwelling_departure_date"
     */
    public final java.util.Date getPreviousDwellingDepartureDate() {
        return this.previousDwellingDepartureDate;
    }

    private String spousePensionPlanPrecision;

    public final void setSpousePensionPlanPrecision(final String spousePensionPlanPrecision) {
        this.spousePensionPlanPrecision = spousePensionPlanPrecision;
    }


    /**
     * @hibernate.property
     *  column="spouse_pension_plan_precision"
     *  length="50"
     */
    public final String getSpousePensionPlanPrecision() {
        return this.spousePensionPlanPrecision;
    }

    private java.math.BigInteger spouseNetIncome;

    public final void setSpouseNetIncome(final java.math.BigInteger spouseNetIncome) {
        this.spouseNetIncome = spouseNetIncome;
    }


    /**
     * @hibernate.property
     *  column="spouse_net_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getSpouseNetIncome() {
        return this.spouseNetIncome;
    }

    private java.math.BigInteger requesterRealEstateInvestmentIncome;

    public final void setRequesterRealEstateInvestmentIncome(final java.math.BigInteger requesterRealEstateInvestmentIncome) {
        this.requesterRealEstateInvestmentIncome = requesterRealEstateInvestmentIncome;
    }


    /**
     * @hibernate.property
     *  column="requester_real_estate_investment_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterRealEstateInvestmentIncome() {
        return this.requesterRealEstateInvestmentIncome;
    }

    private Boolean spousePensionner;

    public final void setSpousePensionner(final Boolean spousePensionner) {
        this.spousePensionner = spousePensionner;
    }


    /**
     * @hibernate.property
     *  column="spouse_pensionner"
     */
    public final Boolean getSpousePensionner() {
        return this.spousePensionner;
    }

    private java.math.BigInteger requesterNetIncome;

    public final void setRequesterNetIncome(final java.math.BigInteger requesterNetIncome) {
        this.requesterNetIncome = requesterNetIncome;
    }


    /**
     * @hibernate.property
     *  column="requester_net_income"
     *  type="serializable"
     */
    public final java.math.BigInteger getRequesterNetIncome() {
        return this.requesterNetIncome;
    }

    private java.math.BigInteger currentDwellingRoomNumber;

    public final void setCurrentDwellingRoomNumber(final java.math.BigInteger currentDwellingRoomNumber) {
        this.currentDwellingRoomNumber = currentDwellingRoomNumber;
    }


    /**
     * @hibernate.property
     *  column="current_dwelling_room_number"
     *  type="serializable"
     */
    public final java.math.BigInteger getCurrentDwellingRoomNumber() {
        return this.currentDwellingRoomNumber;
    }

}
