package fr.cg95.cvq.service.request.social.impl;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.DhrAssetKindType;
import fr.cg95.cvq.business.request.social.DhrDwellingKindType;
import fr.cg95.cvq.business.request.social.DhrPrincipalPensionPlanType;
import fr.cg95.cvq.business.request.social.DhrRequestKindType;
import fr.cg95.cvq.business.request.social.DomesticHelpRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.xml.request.social.DhrCurrentDwellingType;
import fr.cg95.cvq.xml.request.social.DhrSpouseStatusType;
import fr.cg95.cvq.xml.request.social.DhrSpouseType;

/**
 * Implementation of the domestic help request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class DomesticHelpRequestService extends RequestService {

    static Logger logger = Logger.getLogger(DomesticHelpRequestService.class);

    @Override
    public void init() {
        DomesticHelpRequest.conditions.put("dhrRequestKind", new EqualityChecker(DhrRequestKindType.COUPLE.name()));
        DomesticHelpRequest.conditions.put("dhrHaveFamilyReferent", new EqualityChecker("true"));
        DomesticHelpRequest.conditions.put("dhrRequesterNationality",
            new EqualityChecker("OutsideEuropeanUnion"));
        DomesticHelpRequest.conditions.put("dhrPrincipalPensionPlan", new EqualityChecker(DhrPrincipalPensionPlanType.OTHER.name()));
        DomesticHelpRequest.conditions.put("dhrRequesterHaveGuardian", new EqualityChecker("true"));
        DomesticHelpRequest.conditions.put("dhrSpouseTitle", new EqualityChecker("Madam"));
        DomesticHelpRequest.conditions.put("dhrSpouseNationality",
            new EqualityChecker("OutsideEuropeanUnion"));
        DomesticHelpRequest.conditions.put("dhrIsSpouseRetired", new EqualityChecker("true"));
        DomesticHelpRequest.conditions.put("dhrSpousePrincipalPensionPlan",
            new EqualityChecker("Other"));
        DomesticHelpRequest.conditions.put("dhrCurrentDwellingKind",
            new EqualityChecker(DhrDwellingKindType.PLACE_OF_RESIDENCE.name()));
        DomesticHelpRequest.conditions.put("dhrPreviousDwelling.dhrPreviousDwellingKind",
            new EqualityChecker(DhrDwellingKindType.PLACE_OF_RESIDENCE.name()));
        DomesticHelpRequest.conditions.put("dhrNotRealAsset.dhrNotRealAssetKind",
            new EqualityChecker(DhrAssetKindType.REAL_ESTATE.name()));
    }

    @Override
    public void onRequestIssued(final Request request) throws CvqException,
            CvqObjectNotFoundException {

        DomesticHelpRequest dhr = (DomesticHelpRequest) request;
        processTotals(dhr);
    }

    @Override
    public void onRequestModified(Request request) throws CvqException {

        processTotals((DomesticHelpRequest) request);
    }

    private void processTotals(DomesticHelpRequest dhr) {
//        int subjectTotalIncomes = (dhr.getRequesterPensions() == null ? 0 : dhr
//                .getRequesterPensions().intValue())
//                + (dhr.getRequesterAllowances() == null ? 0 : dhr.getRequesterAllowances()
//                        .intValue())
//                + (dhr.getRequesterFurnitureInvestmentIncome() == null ? 0 : dhr
//                        .getRequesterFurnitureInvestmentIncome().intValue())
//                + (dhr.getRequesterRealEstateInvestmentIncome() == null ? 0 : dhr
//                        .getRequesterRealEstateInvestmentIncome().intValue())
//                + (dhr.getRequesterNetIncome() == null ? 0 : dhr.getRequesterNetIncome().intValue());
//        dhr.setRequesterIncomesAnnualTotal(BigInteger.valueOf(subjectTotalIncomes));
//
//        if (dhr.getSpouseInformation() != null) {
//            int spouseTotalIncomes = (dhr.getSpousePensions() == null ? 0 : dhr.getSpousePensions()
//                    .intValue())
//                    + (dhr.getSpouseAllowances() == null ? 0 : dhr.getSpouseAllowances().intValue())
//                    + (dhr.getSpouseFurnitureInvestmentIncome() == null ? 0 : dhr
//                            .getSpouseFurnitureInvestmentIncome().intValue())
//                    + (dhr.getSpouseRealEstateInvestmentIncome() == null ? 0 : dhr
//                            .getSpouseRealEstateInvestmentIncome().intValue())
//                    + (dhr.getSpouseNetIncome() == null ? 0 : dhr.getSpouseNetIncome().intValue());
//            dhr.setSpouseIncomesAnnualTotal(BigInteger.valueOf(spouseTotalIncomes));
//        }
//        int realAssetsTotal = 0;
//        List<DhrRealAsset> realAssets = dhr.getRealAssets();
//        for (DhrRealAsset realAsset : realAssets) {
//            realAssetsTotal += realAsset.getRealAssetValue() == null ? 0 : realAsset
//                    .getRealAssetValue().intValue();
//        }
//        dhr.setRealAssetsValuesTotal(BigInteger.valueOf(realAssetsTotal));
//
//        int notRealAssetsTotal = 0;
//        List<DhrNotRealAsset> notRealAssets = dhr.getNotRealAssets();
//        for (DhrNotRealAsset notRealAsset : notRealAssets) {
//            notRealAssetsTotal += notRealAsset.getAssetValue() == null ? 0 : notRealAsset
//                    .getAssetValue().intValue();
//        }
//        dhr.setNotRealAssetsValuesTotal(BigInteger.valueOf(notRealAssetsTotal));
//
//        int taxesTotal = (dhr.getIncomeTax() == null ? 0 : dhr.getIncomeTax().intValue())
//                + (dhr.getLocalRate() == null ? 0 : dhr.getLocalRate().intValue())
//                + (dhr.getPropertyTaxes() == null ? 0 : dhr.getPropertyTaxes().intValue())
//                + (dhr.getProfessionalTaxes() == null ? 0 : dhr.getProfessionalTaxes().intValue());
//        dhr.setTaxesTotal(BigInteger.valueOf(taxesTotal));
    } 
    
    @Override
    public boolean accept(Request request) {
        return request instanceof DomesticHelpRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new DomesticHelpRequest();
    }
}