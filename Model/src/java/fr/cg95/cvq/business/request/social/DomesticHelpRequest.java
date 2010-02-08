
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

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
      
        dhrIsSpouseRetired = Boolean.valueOf(false);
      
        dhrRequesterIsFrenchResident = Boolean.valueOf(false);
      
        dhrRequesterHaveGuardian = Boolean.valueOf(false);
      
        dhrRequestKind = fr.cg95.cvq.business.request.social.DhrRequestKindType.INDIVIDUAL;
      
        dhrSpouseIsFrenchResident = Boolean.valueOf(false);
      
        dhrHaveFamilyReferent = Boolean.valueOf(false);
      
    }

    @Override
    public final String modelToXmlString() {
        DomesticHelpRequestDocument object = (DomesticHelpRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final DomesticHelpRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DomesticHelpRequestDocument domesticHelpRequestDoc = DomesticHelpRequestDocument.Factory.newInstance();
        DomesticHelpRequestDocument.DomesticHelpRequest domesticHelpRequest = domesticHelpRequestDoc.addNewDomesticHelpRequest();
        super.fillCommonXmlInfo(domesticHelpRequest);
        int i = 0;
      DhrSpouseStatusType dhrSpouseStatusTypeDhrSpouseStatus = domesticHelpRequest.addNewDhrSpouseStatus();
        if (this.dhrSpousePrincipalPensionPlan != null)
            dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpousePrincipalPensionPlan(fr.cg95.cvq.xml.request.social.DhrPrincipalPensionPlanType.Enum.forString(this.dhrSpousePrincipalPensionPlan.toString()));
      
        i = 0;
        if (dhrRealAsset != null) {
            fr.cg95.cvq.xml.request.social.DhrRealAssetType[] dhrRealAssetTypeTab = new fr.cg95.cvq.xml.request.social.DhrRealAssetType[dhrRealAsset.size()];
            for (DhrRealAsset object : dhrRealAsset) {
              dhrRealAssetTypeTab[i++] = object.modelToXml();
            }
            domesticHelpRequest.setDhrRealAssetArray(dhrRealAssetTypeTab);
        }
      
        dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpouseProfession(this.dhrSpouseProfession);
        DhrIncomesType dhrIncomesTypeDhrRequesterIncomes = domesticHelpRequest.addNewDhrRequesterIncomes();
        if (this.dhrNetIncome != null)
            dhrIncomesTypeDhrRequesterIncomes.setDhrNetIncome(new BigInteger(this.dhrNetIncome.toString()));
        DhrTaxesAmountType dhrTaxesAmountTypeDhrTaxesAmount = domesticHelpRequest.addNewDhrTaxesAmount();
        if (this.professionalTaxes != null)
            dhrTaxesAmountTypeDhrTaxesAmount.setProfessionalTaxes(new BigInteger(this.professionalTaxes.toString()));
      
        if (this.dhrIsSpouseRetired != null)
            dhrSpouseStatusTypeDhrSpouseStatus.setDhrIsSpouseRetired(this.dhrIsSpouseRetired.booleanValue());
        DhrSpouseType dhrSpouseTypeDhrSpouse = domesticHelpRequest.addNewDhrSpouse();
        if (this.dhrSpouseTitle != null)
            dhrSpouseTypeDhrSpouse.setDhrSpouseTitle(fr.cg95.cvq.xml.common.TitleType.Enum.forString(this.dhrSpouseTitle.toString()));
        DhrRequesterType dhrRequesterTypeDhrRequester = domesticHelpRequest.addNewDhrRequester();
        date = this.dhrRequesterBirthDate;
        if (date != null) {
            calendar.setTime(date);
            dhrRequesterTypeDhrRequester.setDhrRequesterBirthDate(calendar);
        }
      
        if (this.dhrRealEstateInvestmentIncome != null)
            dhrIncomesTypeDhrRequesterIncomes.setDhrRealEstateInvestmentIncome(new BigInteger(this.dhrRealEstateInvestmentIncome.toString()));
      
        if (this.dhrRequesterIsFrenchResident != null)
            dhrRequesterTypeDhrRequester.setDhrRequesterIsFrenchResident(this.dhrRequesterIsFrenchResident.booleanValue());
        DhrCurrentDwellingType dhrCurrentDwellingTypeDhrCurrentDwelling = domesticHelpRequest.addNewDhrCurrentDwelling();
        if (this.dhrCurrentDwellingAddress != null)
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingAddress(Address.modelToXml(this.dhrCurrentDwellingAddress));
      
        date = this.dhrSpouseFranceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrSpouseTypeDhrSpouse.setDhrSpouseFranceArrivalDate(calendar);
        }
      
        i = 0;
        if (dhrNotRealAsset != null) {
            fr.cg95.cvq.xml.request.social.DhrNotRealAssetType[] dhrNotRealAssetTypeTab = new fr.cg95.cvq.xml.request.social.DhrNotRealAssetType[dhrNotRealAsset.size()];
            for (DhrNotRealAsset object : dhrNotRealAsset) {
              dhrNotRealAssetTypeTab[i++] = object.modelToXml();
            }
            domesticHelpRequest.setDhrNotRealAssetArray(dhrNotRealAssetTypeTab);
        }
      
        if (this.dhrRequesterNationality != null)
            dhrRequesterTypeDhrRequester.setDhrRequesterNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.dhrRequesterNationality.toString()));
      
        date = this.dhrCurrentDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingArrivalDate(calendar);
        }
        DhrFamilyReferentType dhrFamilyReferentTypeDhrFamilyReferent = domesticHelpRequest.addNewDhrFamilyReferent();
        dhrFamilyReferentTypeDhrFamilyReferent.setDhrReferentFirstName(this.dhrReferentFirstName);
      
        if (this.dhrIncomesAnnualTotal != null)
            dhrIncomesTypeDhrRequesterIncomes.setDhrIncomesAnnualTotal(new BigInteger(this.dhrIncomesAnnualTotal.toString()));
        DhrRequesterGuardianType dhrRequesterGuardianTypeDhrRequesterGuardian = domesticHelpRequest.addNewDhrRequesterGuardian();
        if (this.dhrRequesterHaveGuardian != null)
            dhrRequesterGuardianTypeDhrRequesterGuardian.setDhrRequesterHaveGuardian(this.dhrRequesterHaveGuardian.booleanValue());
      
        if (this.dhrIncomeTax != null)
            dhrTaxesAmountTypeDhrTaxesAmount.setDhrIncomeTax(new BigInteger(this.dhrIncomeTax.toString()));
      
        dhrSpouseTypeDhrSpouse.setDhrSpouseBirthPlace(this.dhrSpouseBirthPlace);
      
        date = this.dhrSpouseBirthDate;
        if (date != null) {
            calendar.setTime(date);
            dhrSpouseTypeDhrSpouse.setDhrSpouseBirthDate(calendar);
        }
      
        if (this.dhrCurrentDwellingNetArea != null)
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingNetArea(new BigDecimal(this.dhrCurrentDwellingNetArea));
      
        date = this.dhrRequesterFranceArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrRequesterTypeDhrRequester.setDhrRequesterFranceArrivalDate(calendar);
        }
      
        if (this.dhrCurrentDwellingStatus != null)
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingStatus(fr.cg95.cvq.xml.request.social.DhrDwellingStatusType.Enum.forString(this.dhrCurrentDwellingStatus.toString()));
      
        dhrSpouseTypeDhrSpouse.setDhrSpouseFirstName(this.dhrSpouseFirstName);
      
        if (this.dhrSpouseFamilyStatus != null)
            dhrSpouseTypeDhrSpouse.setDhrSpouseFamilyStatus(fr.cg95.cvq.xml.common.FamilyStatusType.Enum.forString(this.dhrSpouseFamilyStatus.toString()));
      
        if (this.dhrFurnitureInvestmentIncome != null)
            dhrIncomesTypeDhrRequesterIncomes.setDhrFurnitureInvestmentIncome(new BigInteger(this.dhrFurnitureInvestmentIncome.toString()));
      
        if (this.dhrGuardianAddress != null)
            dhrRequesterGuardianTypeDhrRequesterGuardian.setDhrGuardianAddress(Address.modelToXml(this.dhrGuardianAddress));
      
        dhrFamilyReferentTypeDhrFamilyReferent.setDhrReferentName(this.dhrReferentName);
      
        if (this.localRate != null)
            dhrTaxesAmountTypeDhrTaxesAmount.setLocalRate(new BigInteger(this.localRate.toString()));
      
        dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpouseEmployer(this.dhrSpouseEmployer);
      
        if (this.dhrRequestKind != null)
            dhrSpouseTypeDhrSpouse.setDhrRequestKind(fr.cg95.cvq.xml.request.social.DhrRequestKindType.Enum.forString(this.dhrRequestKind.toString()));
        DhrRequesterPensionPlanType dhrRequesterPensionPlanTypeDhrRequesterPensionPlan = domesticHelpRequest.addNewDhrRequesterPensionPlan();
        if (this.dhrPrincipalPensionPlan != null)
            dhrRequesterPensionPlanTypeDhrRequesterPensionPlan.setDhrPrincipalPensionPlan(fr.cg95.cvq.xml.request.social.DhrPrincipalPensionPlanType.Enum.forString(this.dhrPrincipalPensionPlan.toString()));
      
        dhrRequesterPensionPlanTypeDhrRequesterPensionPlan.setDhrComplementaryPensionPlan(this.dhrComplementaryPensionPlan);
      
        if (this.dhrReferentAddress != null)
            dhrFamilyReferentTypeDhrFamilyReferent.setDhrReferentAddress(Address.modelToXml(this.dhrReferentAddress));
      
        if (this.propertyTaxes != null)
            dhrTaxesAmountTypeDhrTaxesAmount.setPropertyTaxes(new BigInteger(this.propertyTaxes.toString()));
      
        dhrRequesterGuardianTypeDhrRequesterGuardian.setDhrGuardianName(this.dhrGuardianName);
      
        if (this.pensions != null)
            dhrIncomesTypeDhrRequesterIncomes.setPensions(new BigInteger(this.pensions.toString()));
      
        if (this.dhrCurrentDwellingKind != null)
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingKind(fr.cg95.cvq.xml.request.social.DhrDwellingKindType.Enum.forString(this.dhrCurrentDwellingKind.toString()));
      
        if (this.dhrCurrentDwellingNumberOfRoom != null)
            dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingNumberOfRoom(new BigDecimal(this.dhrCurrentDwellingNumberOfRoom));
      
        if (this.dhrGuardianMeasure != null)
            dhrRequesterGuardianTypeDhrRequesterGuardian.setDhrGuardianMeasure(fr.cg95.cvq.xml.request.social.DhrGuardianMeasureType.Enum.forString(this.dhrGuardianMeasure.toString()));
      
        dhrCurrentDwellingTypeDhrCurrentDwelling.setDhrCurrentDwellingPhone(this.dhrCurrentDwellingPhone);
      
        if (this.dhrSpouseIsFrenchResident != null)
            dhrSpouseTypeDhrSpouse.setDhrSpouseIsFrenchResident(this.dhrSpouseIsFrenchResident.booleanValue());
      
        if (this.dhrAllowances != null)
            dhrIncomesTypeDhrRequesterIncomes.setDhrAllowances(new BigInteger(this.dhrAllowances.toString()));
      
        if (this.dhrSpouseNationality != null)
            dhrSpouseTypeDhrSpouse.setDhrSpouseNationality(fr.cg95.cvq.xml.common.NationalityType.Enum.forString(this.dhrSpouseNationality.toString()));
      
        dhrSpouseTypeDhrSpouse.setDhrSpouseMaidenName(this.dhrSpouseMaidenName);
      
        i = 0;
        if (dhrPreviousDwelling != null) {
            fr.cg95.cvq.xml.request.social.DhrPreviousDwellingType[] dhrPreviousDwellingTypeTab = new fr.cg95.cvq.xml.request.social.DhrPreviousDwellingType[dhrPreviousDwelling.size()];
            for (DhrPreviousDwelling object : dhrPreviousDwelling) {
              dhrPreviousDwellingTypeTab[i++] = object.modelToXml();
            }
            domesticHelpRequest.setDhrPreviousDwellingArray(dhrPreviousDwellingTypeTab);
        }
      
        dhrSpouseTypeDhrSpouse.setDhrSpouseName(this.dhrSpouseName);
      
        dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpousePensionPlanDetail(this.dhrSpousePensionPlanDetail);
      
        dhrRequesterTypeDhrRequester.setDhrRequesterBirthPlace(this.dhrRequesterBirthPlace);
      
        if (this.dhrSpouseAddress != null)
            dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpouseAddress(Address.modelToXml(this.dhrSpouseAddress));
      
        if (this.dhrHaveFamilyReferent != null)
            dhrFamilyReferentTypeDhrFamilyReferent.setDhrHaveFamilyReferent(this.dhrHaveFamilyReferent.booleanValue());
      
        dhrRequesterPensionPlanTypeDhrRequesterPensionPlan.setDhrPensionPlanDetail(this.dhrPensionPlanDetail);
      
        dhrSpouseStatusTypeDhrSpouseStatus.setDhrSpouseComplementaryPensionPlan(this.dhrSpouseComplementaryPensionPlan);
      
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
        domesticHelpRequest.fillCommonModelInfo(domesticHelpRequest, domesticHelpRequestXml);
    
        if (domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpousePrincipalPensionPlan() != null)
            domesticHelpRequest.setDhrSpousePrincipalPensionPlan(fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType.forString(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpousePrincipalPensionPlan().toString()));
        else
            domesticHelpRequest.setDhrSpousePrincipalPensionPlan(fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType.getDefaultDhrPrincipalPensionPlanType());
      
        List<fr.cg95.cvq.business.request.social.DhrRealAsset> dhrRealAssetList = new ArrayList<fr.cg95.cvq.business.request.social.DhrRealAsset>(domesticHelpRequestXml.sizeOfDhrRealAssetArray());
        for (DhrRealAssetType object : domesticHelpRequestXml.getDhrRealAssetArray()) {
            dhrRealAssetList.add(fr.cg95.cvq.business.request.social.DhrRealAsset.xmlToModel(object));
        }
        domesticHelpRequest.setDhrRealAsset(dhrRealAssetList);
      
        domesticHelpRequest.setDhrSpouseProfession(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpouseProfession());
      
        domesticHelpRequest.setDhrNetIncome(domesticHelpRequestXml.getDhrRequesterIncomes().getDhrNetIncome());
      
        domesticHelpRequest.setProfessionalTaxes(domesticHelpRequestXml.getDhrTaxesAmount().getProfessionalTaxes());
      
        domesticHelpRequest.setDhrIsSpouseRetired(Boolean.valueOf(domesticHelpRequestXml.getDhrSpouseStatus().getDhrIsSpouseRetired()));
      
        if (domesticHelpRequestXml.getDhrSpouse().getDhrSpouseTitle() != null)
            domesticHelpRequest.setDhrSpouseTitle(fr.cg95.cvq.business.users.TitleType.forString(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseTitle().toString()));
        else
            domesticHelpRequest.setDhrSpouseTitle(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
        calendar = domesticHelpRequestXml.getDhrRequester().getDhrRequesterBirthDate();
        if (calendar != null) {
            domesticHelpRequest.setDhrRequesterBirthDate(calendar.getTime());
        }
      
        domesticHelpRequest.setDhrRealEstateInvestmentIncome(domesticHelpRequestXml.getDhrRequesterIncomes().getDhrRealEstateInvestmentIncome());
      
        domesticHelpRequest.setDhrRequesterIsFrenchResident(Boolean.valueOf(domesticHelpRequestXml.getDhrRequester().getDhrRequesterIsFrenchResident()));
      
        if (domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingAddress() != null)
            domesticHelpRequest.setDhrCurrentDwellingAddress(Address.xmlToModel(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingAddress()));
      
        calendar = domesticHelpRequestXml.getDhrSpouse().getDhrSpouseFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setDhrSpouseFranceArrivalDate(calendar.getTime());
        }
      
        List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> dhrNotRealAssetList = new ArrayList<fr.cg95.cvq.business.request.social.DhrNotRealAsset>(domesticHelpRequestXml.sizeOfDhrNotRealAssetArray());
        for (DhrNotRealAssetType object : domesticHelpRequestXml.getDhrNotRealAssetArray()) {
            dhrNotRealAssetList.add(fr.cg95.cvq.business.request.social.DhrNotRealAsset.xmlToModel(object));
        }
        domesticHelpRequest.setDhrNotRealAsset(dhrNotRealAssetList);
      
        if (domesticHelpRequestXml.getDhrRequester().getDhrRequesterNationality() != null)
            domesticHelpRequest.setDhrRequesterNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getDhrRequester().getDhrRequesterNationality().toString()));
        else
            domesticHelpRequest.setDhrRequesterNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
      
        calendar = domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setDhrCurrentDwellingArrivalDate(calendar.getTime());
        }
      
        domesticHelpRequest.setDhrReferentFirstName(domesticHelpRequestXml.getDhrFamilyReferent().getDhrReferentFirstName());
      
        domesticHelpRequest.setDhrIncomesAnnualTotal(domesticHelpRequestXml.getDhrRequesterIncomes().getDhrIncomesAnnualTotal());
      
        domesticHelpRequest.setDhrRequesterHaveGuardian(Boolean.valueOf(domesticHelpRequestXml.getDhrRequesterGuardian().getDhrRequesterHaveGuardian()));
      
        domesticHelpRequest.setDhrIncomeTax(domesticHelpRequestXml.getDhrTaxesAmount().getDhrIncomeTax());
      
        domesticHelpRequest.setDhrSpouseBirthPlace(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseBirthPlace());
      
        calendar = domesticHelpRequestXml.getDhrSpouse().getDhrSpouseBirthDate();
        if (calendar != null) {
            domesticHelpRequest.setDhrSpouseBirthDate(calendar.getTime());
        }
      
        if (domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingNetArea() != null)
            domesticHelpRequest.setDhrCurrentDwellingNetArea(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingNetArea().shortValue());
      
        calendar = domesticHelpRequestXml.getDhrRequester().getDhrRequesterFranceArrivalDate();
        if (calendar != null) {
            domesticHelpRequest.setDhrRequesterFranceArrivalDate(calendar.getTime());
        }
      
        if (domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingStatus() != null)
            domesticHelpRequest.setDhrCurrentDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.forString(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingStatus().toString()));
        else
            domesticHelpRequest.setDhrCurrentDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.getDefaultDhrDwellingStatusType());
      
        domesticHelpRequest.setDhrSpouseFirstName(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseFirstName());
      
        if (domesticHelpRequestXml.getDhrSpouse().getDhrSpouseFamilyStatus() != null)
            domesticHelpRequest.setDhrSpouseFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.forString(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseFamilyStatus().toString()));
        else
            domesticHelpRequest.setDhrSpouseFamilyStatus(fr.cg95.cvq.business.users.FamilyStatusType.getDefaultFamilyStatusType());
      
        domesticHelpRequest.setDhrFurnitureInvestmentIncome(domesticHelpRequestXml.getDhrRequesterIncomes().getDhrFurnitureInvestmentIncome());
      
        if (domesticHelpRequestXml.getDhrRequesterGuardian().getDhrGuardianAddress() != null)
            domesticHelpRequest.setDhrGuardianAddress(Address.xmlToModel(domesticHelpRequestXml.getDhrRequesterGuardian().getDhrGuardianAddress()));
      
        domesticHelpRequest.setDhrReferentName(domesticHelpRequestXml.getDhrFamilyReferent().getDhrReferentName());
      
        domesticHelpRequest.setLocalRate(domesticHelpRequestXml.getDhrTaxesAmount().getLocalRate());
      
        domesticHelpRequest.setDhrSpouseEmployer(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpouseEmployer());
      
        if (domesticHelpRequestXml.getDhrSpouse().getDhrRequestKind() != null)
            domesticHelpRequest.setDhrRequestKind(fr.cg95.cvq.business.request.social.DhrRequestKindType.forString(domesticHelpRequestXml.getDhrSpouse().getDhrRequestKind().toString()));
        else
            domesticHelpRequest.setDhrRequestKind(fr.cg95.cvq.business.request.social.DhrRequestKindType.getDefaultDhrRequestKindType());
      
        if (domesticHelpRequestXml.getDhrRequesterPensionPlan().getDhrPrincipalPensionPlan() != null)
            domesticHelpRequest.setDhrPrincipalPensionPlan(fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType.forString(domesticHelpRequestXml.getDhrRequesterPensionPlan().getDhrPrincipalPensionPlan().toString()));
        else
            domesticHelpRequest.setDhrPrincipalPensionPlan(fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType.getDefaultDhrPrincipalPensionPlanType());
      
        domesticHelpRequest.setDhrComplementaryPensionPlan(domesticHelpRequestXml.getDhrRequesterPensionPlan().getDhrComplementaryPensionPlan());
      
        if (domesticHelpRequestXml.getDhrFamilyReferent().getDhrReferentAddress() != null)
            domesticHelpRequest.setDhrReferentAddress(Address.xmlToModel(domesticHelpRequestXml.getDhrFamilyReferent().getDhrReferentAddress()));
      
        domesticHelpRequest.setPropertyTaxes(domesticHelpRequestXml.getDhrTaxesAmount().getPropertyTaxes());
      
        domesticHelpRequest.setDhrGuardianName(domesticHelpRequestXml.getDhrRequesterGuardian().getDhrGuardianName());
      
        domesticHelpRequest.setPensions(domesticHelpRequestXml.getDhrRequesterIncomes().getPensions());
      
        if (domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingKind() != null)
            domesticHelpRequest.setDhrCurrentDwellingKind(fr.cg95.cvq.business.request.social.DhrDwellingKindType.forString(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingKind().toString()));
        else
            domesticHelpRequest.setDhrCurrentDwellingKind(fr.cg95.cvq.business.request.social.DhrDwellingKindType.getDefaultDhrDwellingKindType());
      
        if (domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingNumberOfRoom() != null)
            domesticHelpRequest.setDhrCurrentDwellingNumberOfRoom(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingNumberOfRoom().shortValue());
      
        if (domesticHelpRequestXml.getDhrRequesterGuardian().getDhrGuardianMeasure() != null)
            domesticHelpRequest.setDhrGuardianMeasure(fr.cg95.cvq.business.request.social.DhrGuardianMeasureType.forString(domesticHelpRequestXml.getDhrRequesterGuardian().getDhrGuardianMeasure().toString()));
        else
            domesticHelpRequest.setDhrGuardianMeasure(fr.cg95.cvq.business.request.social.DhrGuardianMeasureType.getDefaultDhrGuardianMeasureType());
      
        domesticHelpRequest.setDhrCurrentDwellingPhone(domesticHelpRequestXml.getDhrCurrentDwelling().getDhrCurrentDwellingPhone());
      
        domesticHelpRequest.setDhrSpouseIsFrenchResident(Boolean.valueOf(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseIsFrenchResident()));
      
        domesticHelpRequest.setDhrAllowances(domesticHelpRequestXml.getDhrRequesterIncomes().getDhrAllowances());
      
        if (domesticHelpRequestXml.getDhrSpouse().getDhrSpouseNationality() != null)
            domesticHelpRequest.setDhrSpouseNationality(fr.cg95.cvq.business.users.NationalityType.forString(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseNationality().toString()));
        else
            domesticHelpRequest.setDhrSpouseNationality(fr.cg95.cvq.business.users.NationalityType.getDefaultNationalityType());
      
        domesticHelpRequest.setDhrSpouseMaidenName(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseMaidenName());
      
        List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> dhrPreviousDwellingList = new ArrayList<fr.cg95.cvq.business.request.social.DhrPreviousDwelling>(domesticHelpRequestXml.sizeOfDhrPreviousDwellingArray());
        for (DhrPreviousDwellingType object : domesticHelpRequestXml.getDhrPreviousDwellingArray()) {
            dhrPreviousDwellingList.add(fr.cg95.cvq.business.request.social.DhrPreviousDwelling.xmlToModel(object));
        }
        domesticHelpRequest.setDhrPreviousDwelling(dhrPreviousDwellingList);
      
        domesticHelpRequest.setDhrSpouseName(domesticHelpRequestXml.getDhrSpouse().getDhrSpouseName());
      
        domesticHelpRequest.setDhrSpousePensionPlanDetail(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpousePensionPlanDetail());
      
        domesticHelpRequest.setDhrRequesterBirthPlace(domesticHelpRequestXml.getDhrRequester().getDhrRequesterBirthPlace());
      
        if (domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpouseAddress() != null)
            domesticHelpRequest.setDhrSpouseAddress(Address.xmlToModel(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpouseAddress()));
      
        domesticHelpRequest.setDhrHaveFamilyReferent(Boolean.valueOf(domesticHelpRequestXml.getDhrFamilyReferent().getDhrHaveFamilyReferent()));
      
        domesticHelpRequest.setDhrPensionPlanDetail(domesticHelpRequestXml.getDhrRequesterPensionPlan().getDhrPensionPlanDetail());
      
        domesticHelpRequest.setDhrSpouseComplementaryPensionPlan(domesticHelpRequestXml.getDhrSpouseStatus().getDhrSpouseComplementaryPensionPlan());
      
        return domesticHelpRequest;
    }

  
    private fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrSpousePrincipalPensionPlan;

    public final void setDhrSpousePrincipalPensionPlan(final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrSpousePrincipalPensionPlan) {
        this.dhrSpousePrincipalPensionPlan = dhrSpousePrincipalPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_principal_pension_plan"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType getDhrSpousePrincipalPensionPlan() {
        return this.dhrSpousePrincipalPensionPlan;
    }
  
    private List<fr.cg95.cvq.business.request.social.DhrRealAsset> dhrRealAsset;

    public final void setDhrRealAsset(final List<fr.cg95.cvq.business.request.social.DhrRealAsset> dhrRealAsset) {
        this.dhrRealAsset = dhrRealAsset;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_real_asset_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrRealAsset"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrRealAsset> getDhrRealAsset() {
        return this.dhrRealAsset;
    }
  
    private String dhrSpouseProfession;

    public final void setDhrSpouseProfession(final String dhrSpouseProfession) {
        this.dhrSpouseProfession = dhrSpouseProfession;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_profession"
        
      
    */
    public final String getDhrSpouseProfession() {
        return this.dhrSpouseProfession;
    }
  
    private java.math.BigInteger dhrNetIncome;

    public final void setDhrNetIncome(final java.math.BigInteger dhrNetIncome) {
        this.dhrNetIncome = dhrNetIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_net_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrNetIncome() {
        return this.dhrNetIncome;
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
  
    private Boolean dhrIsSpouseRetired;

    public final void setDhrIsSpouseRetired(final Boolean dhrIsSpouseRetired) {
        this.dhrIsSpouseRetired = dhrIsSpouseRetired;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_is_spouse_retired"
        
      
    */
    public final Boolean getDhrIsSpouseRetired() {
        return this.dhrIsSpouseRetired;
    }
  
    private fr.cg95.cvq.business.users.TitleType dhrSpouseTitle;

    public final void setDhrSpouseTitle(final fr.cg95.cvq.business.users.TitleType dhrSpouseTitle) {
        this.dhrSpouseTitle = dhrSpouseTitle;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_title"
        
      
    */
    public final fr.cg95.cvq.business.users.TitleType getDhrSpouseTitle() {
        return this.dhrSpouseTitle;
    }
  
    private java.util.Date dhrRequesterBirthDate;

    public final void setDhrRequesterBirthDate(final java.util.Date dhrRequesterBirthDate) {
        this.dhrRequesterBirthDate = dhrRequesterBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_birth_date"
        
      
    */
    public final java.util.Date getDhrRequesterBirthDate() {
        return this.dhrRequesterBirthDate;
    }
  
    private java.math.BigInteger dhrRealEstateInvestmentIncome;

    public final void setDhrRealEstateInvestmentIncome(final java.math.BigInteger dhrRealEstateInvestmentIncome) {
        this.dhrRealEstateInvestmentIncome = dhrRealEstateInvestmentIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_real_estate_investment_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrRealEstateInvestmentIncome() {
        return this.dhrRealEstateInvestmentIncome;
    }
  
    private Boolean dhrRequesterIsFrenchResident;

    public final void setDhrRequesterIsFrenchResident(final Boolean dhrRequesterIsFrenchResident) {
        this.dhrRequesterIsFrenchResident = dhrRequesterIsFrenchResident;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_is_french_resident"
        
      
    */
    public final Boolean getDhrRequesterIsFrenchResident() {
        return this.dhrRequesterIsFrenchResident;
    }
  
    private fr.cg95.cvq.business.users.Address dhrCurrentDwellingAddress;

    public final void setDhrCurrentDwellingAddress(final fr.cg95.cvq.business.users.Address dhrCurrentDwellingAddress) {
        this.dhrCurrentDwellingAddress = dhrCurrentDwellingAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_current_dwelling_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrCurrentDwellingAddress() {
        return this.dhrCurrentDwellingAddress;
    }
  
    private java.util.Date dhrSpouseFranceArrivalDate;

    public final void setDhrSpouseFranceArrivalDate(final java.util.Date dhrSpouseFranceArrivalDate) {
        this.dhrSpouseFranceArrivalDate = dhrSpouseFranceArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_france_arrival_date"
        
      
    */
    public final java.util.Date getDhrSpouseFranceArrivalDate() {
        return this.dhrSpouseFranceArrivalDate;
    }
  
    private List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> dhrNotRealAsset;

    public final void setDhrNotRealAsset(final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> dhrNotRealAsset) {
        this.dhrNotRealAsset = dhrNotRealAsset;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_not_real_asset_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrNotRealAsset"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrNotRealAsset> getDhrNotRealAsset() {
        return this.dhrNotRealAsset;
    }
  
    private fr.cg95.cvq.business.users.NationalityType dhrRequesterNationality;

    public final void setDhrRequesterNationality(final fr.cg95.cvq.business.users.NationalityType dhrRequesterNationality) {
        this.dhrRequesterNationality = dhrRequesterNationality;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_nationality"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.NationalityType getDhrRequesterNationality() {
        return this.dhrRequesterNationality;
    }
  
    private java.util.Date dhrCurrentDwellingArrivalDate;

    public final void setDhrCurrentDwellingArrivalDate(final java.util.Date dhrCurrentDwellingArrivalDate) {
        this.dhrCurrentDwellingArrivalDate = dhrCurrentDwellingArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_arrival_date"
        
      
    */
    public final java.util.Date getDhrCurrentDwellingArrivalDate() {
        return this.dhrCurrentDwellingArrivalDate;
    }
  
    private String dhrReferentFirstName;

    public final void setDhrReferentFirstName(final String dhrReferentFirstName) {
        this.dhrReferentFirstName = dhrReferentFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_referent_first_name"
        *  length="38"
      
    */
    public final String getDhrReferentFirstName() {
        return this.dhrReferentFirstName;
    }
  
    private java.math.BigInteger dhrIncomesAnnualTotal;

    public final void setDhrIncomesAnnualTotal(final java.math.BigInteger dhrIncomesAnnualTotal) {
        this.dhrIncomesAnnualTotal = dhrIncomesAnnualTotal;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_incomes_annual_total"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrIncomesAnnualTotal() {
        return this.dhrIncomesAnnualTotal;
    }
  
    private Boolean dhrRequesterHaveGuardian;

    public final void setDhrRequesterHaveGuardian(final Boolean dhrRequesterHaveGuardian) {
        this.dhrRequesterHaveGuardian = dhrRequesterHaveGuardian;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_have_guardian"
        
      
    */
    public final Boolean getDhrRequesterHaveGuardian() {
        return this.dhrRequesterHaveGuardian;
    }
  
    private java.math.BigInteger dhrIncomeTax;

    public final void setDhrIncomeTax(final java.math.BigInteger dhrIncomeTax) {
        this.dhrIncomeTax = dhrIncomeTax;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_income_tax"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrIncomeTax() {
        return this.dhrIncomeTax;
    }
  
    private String dhrSpouseBirthPlace;

    public final void setDhrSpouseBirthPlace(final String dhrSpouseBirthPlace) {
        this.dhrSpouseBirthPlace = dhrSpouseBirthPlace;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_birth_place"
        
      
    */
    public final String getDhrSpouseBirthPlace() {
        return this.dhrSpouseBirthPlace;
    }
  
    private java.util.Date dhrSpouseBirthDate;

    public final void setDhrSpouseBirthDate(final java.util.Date dhrSpouseBirthDate) {
        this.dhrSpouseBirthDate = dhrSpouseBirthDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_birth_date"
        
      
    */
    public final java.util.Date getDhrSpouseBirthDate() {
        return this.dhrSpouseBirthDate;
    }
  
    private Short dhrCurrentDwellingNetArea;

    public final void setDhrCurrentDwellingNetArea(final Short dhrCurrentDwellingNetArea) {
        this.dhrCurrentDwellingNetArea = dhrCurrentDwellingNetArea;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_net_area"
        
      
    */
    public final Short getDhrCurrentDwellingNetArea() {
        return this.dhrCurrentDwellingNetArea;
    }
  
    private java.util.Date dhrRequesterFranceArrivalDate;

    public final void setDhrRequesterFranceArrivalDate(final java.util.Date dhrRequesterFranceArrivalDate) {
        this.dhrRequesterFranceArrivalDate = dhrRequesterFranceArrivalDate;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_france_arrival_date"
        
      
    */
    public final java.util.Date getDhrRequesterFranceArrivalDate() {
        return this.dhrRequesterFranceArrivalDate;
    }
  
    private fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrCurrentDwellingStatus;

    public final void setDhrCurrentDwellingStatus(final fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrCurrentDwellingStatus) {
        this.dhrCurrentDwellingStatus = dhrCurrentDwellingStatus;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_status"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingStatusType getDhrCurrentDwellingStatus() {
        return this.dhrCurrentDwellingStatus;
    }
  
    private String dhrSpouseFirstName;

    public final void setDhrSpouseFirstName(final String dhrSpouseFirstName) {
        this.dhrSpouseFirstName = dhrSpouseFirstName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_first_name"
        *  length="38"
      
    */
    public final String getDhrSpouseFirstName() {
        return this.dhrSpouseFirstName;
    }
  
    private fr.cg95.cvq.business.users.FamilyStatusType dhrSpouseFamilyStatus;

    public final void setDhrSpouseFamilyStatus(final fr.cg95.cvq.business.users.FamilyStatusType dhrSpouseFamilyStatus) {
        this.dhrSpouseFamilyStatus = dhrSpouseFamilyStatus;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_family_status"
        
      
    */
    public final fr.cg95.cvq.business.users.FamilyStatusType getDhrSpouseFamilyStatus() {
        return this.dhrSpouseFamilyStatus;
    }
  
    private java.math.BigInteger dhrFurnitureInvestmentIncome;

    public final void setDhrFurnitureInvestmentIncome(final java.math.BigInteger dhrFurnitureInvestmentIncome) {
        this.dhrFurnitureInvestmentIncome = dhrFurnitureInvestmentIncome;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_furniture_investment_income"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrFurnitureInvestmentIncome() {
        return this.dhrFurnitureInvestmentIncome;
    }
  
    private fr.cg95.cvq.business.users.Address dhrGuardianAddress;

    public final void setDhrGuardianAddress(final fr.cg95.cvq.business.users.Address dhrGuardianAddress) {
        this.dhrGuardianAddress = dhrGuardianAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_guardian_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrGuardianAddress() {
        return this.dhrGuardianAddress;
    }
  
    private String dhrReferentName;

    public final void setDhrReferentName(final String dhrReferentName) {
        this.dhrReferentName = dhrReferentName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_referent_name"
        *  length="38"
      
    */
    public final String getDhrReferentName() {
        return this.dhrReferentName;
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
  
    private String dhrSpouseEmployer;

    public final void setDhrSpouseEmployer(final String dhrSpouseEmployer) {
        this.dhrSpouseEmployer = dhrSpouseEmployer;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_employer"
        
      
    */
    public final String getDhrSpouseEmployer() {
        return this.dhrSpouseEmployer;
    }
  
    private fr.cg95.cvq.business.request.social.DhrRequestKindType dhrRequestKind;

    public final void setDhrRequestKind(final fr.cg95.cvq.business.request.social.DhrRequestKindType dhrRequestKind) {
        this.dhrRequestKind = dhrRequestKind;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_request_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrRequestKindType getDhrRequestKind() {
        return this.dhrRequestKind;
    }
  
    private fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrPrincipalPensionPlan;

    public final void setDhrPrincipalPensionPlan(final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType dhrPrincipalPensionPlan) {
        this.dhrPrincipalPensionPlan = dhrPrincipalPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_principal_pension_plan"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType getDhrPrincipalPensionPlan() {
        return this.dhrPrincipalPensionPlan;
    }
  
    private String dhrComplementaryPensionPlan;

    public final void setDhrComplementaryPensionPlan(final String dhrComplementaryPensionPlan) {
        this.dhrComplementaryPensionPlan = dhrComplementaryPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_complementary_pension_plan"
        
      
    */
    public final String getDhrComplementaryPensionPlan() {
        return this.dhrComplementaryPensionPlan;
    }
  
    private fr.cg95.cvq.business.users.Address dhrReferentAddress;

    public final void setDhrReferentAddress(final fr.cg95.cvq.business.users.Address dhrReferentAddress) {
        this.dhrReferentAddress = dhrReferentAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_referent_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrReferentAddress() {
        return this.dhrReferentAddress;
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
  
    private String dhrGuardianName;

    public final void setDhrGuardianName(final String dhrGuardianName) {
        this.dhrGuardianName = dhrGuardianName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_guardian_name"
        *  length="38"
      
    */
    public final String getDhrGuardianName() {
        return this.dhrGuardianName;
    }
  
    private java.math.BigInteger pensions;

    public final void setPensions(final java.math.BigInteger pensions) {
        this.pensions = pensions;
    }

    /**
 
        * @hibernate.property
        *  column="pensions"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getPensions() {
        return this.pensions;
    }
  
    private fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrCurrentDwellingKind;

    public final void setDhrCurrentDwellingKind(final fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrCurrentDwellingKind) {
        this.dhrCurrentDwellingKind = dhrCurrentDwellingKind;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingKindType getDhrCurrentDwellingKind() {
        return this.dhrCurrentDwellingKind;
    }
  
    private Short dhrCurrentDwellingNumberOfRoom;

    public final void setDhrCurrentDwellingNumberOfRoom(final Short dhrCurrentDwellingNumberOfRoom) {
        this.dhrCurrentDwellingNumberOfRoom = dhrCurrentDwellingNumberOfRoom;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_number_of_room"
        
      
    */
    public final Short getDhrCurrentDwellingNumberOfRoom() {
        return this.dhrCurrentDwellingNumberOfRoom;
    }
  
    private fr.cg95.cvq.business.request.social.DhrGuardianMeasureType dhrGuardianMeasure;

    public final void setDhrGuardianMeasure(final fr.cg95.cvq.business.request.social.DhrGuardianMeasureType dhrGuardianMeasure) {
        this.dhrGuardianMeasure = dhrGuardianMeasure;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_guardian_measure"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrGuardianMeasureType getDhrGuardianMeasure() {
        return this.dhrGuardianMeasure;
    }
  
    private String dhrCurrentDwellingPhone;

    public final void setDhrCurrentDwellingPhone(final String dhrCurrentDwellingPhone) {
        this.dhrCurrentDwellingPhone = dhrCurrentDwellingPhone;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_current_dwelling_phone"
        *  length="10"
      
    */
    public final String getDhrCurrentDwellingPhone() {
        return this.dhrCurrentDwellingPhone;
    }
  
    private Boolean dhrSpouseIsFrenchResident;

    public final void setDhrSpouseIsFrenchResident(final Boolean dhrSpouseIsFrenchResident) {
        this.dhrSpouseIsFrenchResident = dhrSpouseIsFrenchResident;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_is_french_resident"
        
      
    */
    public final Boolean getDhrSpouseIsFrenchResident() {
        return this.dhrSpouseIsFrenchResident;
    }
  
    private java.math.BigInteger dhrAllowances;

    public final void setDhrAllowances(final java.math.BigInteger dhrAllowances) {
        this.dhrAllowances = dhrAllowances;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_allowances"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrAllowances() {
        return this.dhrAllowances;
    }
  
    private fr.cg95.cvq.business.users.NationalityType dhrSpouseNationality;

    public final void setDhrSpouseNationality(final fr.cg95.cvq.business.users.NationalityType dhrSpouseNationality) {
        this.dhrSpouseNationality = dhrSpouseNationality;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_nationality"
        *  length="32"
      
    */
    public final fr.cg95.cvq.business.users.NationalityType getDhrSpouseNationality() {
        return this.dhrSpouseNationality;
    }
  
    private String dhrSpouseMaidenName;

    public final void setDhrSpouseMaidenName(final String dhrSpouseMaidenName) {
        this.dhrSpouseMaidenName = dhrSpouseMaidenName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_maiden_name"
        *  length="38"
      
    */
    public final String getDhrSpouseMaidenName() {
        return this.dhrSpouseMaidenName;
    }
  
    private List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> dhrPreviousDwelling;

    public final void setDhrPreviousDwelling(final List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> dhrPreviousDwelling) {
        this.dhrPreviousDwelling = dhrPreviousDwelling;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="domestic_help_request_id"
        * @hibernate.list-index
        *  column="dhr_previous_dwelling_index"
        * @hibernate.one-to-many
        *  class="fr.cg95.cvq.business.request.social.DhrPreviousDwelling"
      
    */
    public final List<fr.cg95.cvq.business.request.social.DhrPreviousDwelling> getDhrPreviousDwelling() {
        return this.dhrPreviousDwelling;
    }
  
    private String dhrSpouseName;

    public final void setDhrSpouseName(final String dhrSpouseName) {
        this.dhrSpouseName = dhrSpouseName;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_name"
        *  length="38"
      
    */
    public final String getDhrSpouseName() {
        return this.dhrSpouseName;
    }
  
    private String dhrSpousePensionPlanDetail;

    public final void setDhrSpousePensionPlanDetail(final String dhrSpousePensionPlanDetail) {
        this.dhrSpousePensionPlanDetail = dhrSpousePensionPlanDetail;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_pension_plan_detail"
        
      
    */
    public final String getDhrSpousePensionPlanDetail() {
        return this.dhrSpousePensionPlanDetail;
    }
  
    private String dhrRequesterBirthPlace;

    public final void setDhrRequesterBirthPlace(final String dhrRequesterBirthPlace) {
        this.dhrRequesterBirthPlace = dhrRequesterBirthPlace;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_requester_birth_place"
        
      
    */
    public final String getDhrRequesterBirthPlace() {
        return this.dhrRequesterBirthPlace;
    }
  
    private fr.cg95.cvq.business.users.Address dhrSpouseAddress;

    public final void setDhrSpouseAddress(final fr.cg95.cvq.business.users.Address dhrSpouseAddress) {
        this.dhrSpouseAddress = dhrSpouseAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_spouse_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrSpouseAddress() {
        return this.dhrSpouseAddress;
    }
  
    private Boolean dhrHaveFamilyReferent;

    public final void setDhrHaveFamilyReferent(final Boolean dhrHaveFamilyReferent) {
        this.dhrHaveFamilyReferent = dhrHaveFamilyReferent;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_have_family_referent"
        
      
    */
    public final Boolean getDhrHaveFamilyReferent() {
        return this.dhrHaveFamilyReferent;
    }
  
    private String dhrPensionPlanDetail;

    public final void setDhrPensionPlanDetail(final String dhrPensionPlanDetail) {
        this.dhrPensionPlanDetail = dhrPensionPlanDetail;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_pension_plan_detail"
        
      
    */
    public final String getDhrPensionPlanDetail() {
        return this.dhrPensionPlanDetail;
    }
  
    private String dhrSpouseComplementaryPensionPlan;

    public final void setDhrSpouseComplementaryPensionPlan(final String dhrSpouseComplementaryPensionPlan) {
        this.dhrSpouseComplementaryPensionPlan = dhrSpouseComplementaryPensionPlan;
    }

    /**
 
        * @hibernate.property
        *  column="dhr_spouse_complementary_pension_plan"
        
      
    */
    public final String getDhrSpouseComplementaryPensionPlan() {
        return this.dhrSpouseComplementaryPensionPlan;
    }
  
}
