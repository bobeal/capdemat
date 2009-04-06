package fr.cg95.cvq.service.request.social.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.social.DomesticHelpRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.social.IDomesticHelpRequestService;

/**
 * Implementation of the domestic help request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class DomesticHelpRequestService extends RequestService implements
        IDomesticHelpRequestService {

    static Logger logger = Logger.getLogger(DomesticHelpRequestService.class);

    @Override
    public Long create(final Request request) throws CvqException,
            CvqObjectNotFoundException {

        DomesticHelpRequest dhr = (DomesticHelpRequest) request;
        performBusinessChecks(dhr);

        processTotals(dhr);

        return finalizeAndPersist(dhr);
    }

    @Override
    public void modify(Request request) throws CvqException {

        processTotals((DomesticHelpRequest) request);
        super.modify(request);
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
    public Request getSkeletonRequest() throws CvqException {
        return new DomesticHelpRequest();
    }
    
    
    public final Map<String,IConditionChecker> filledConditions = new HashMap<String,IConditionChecker>();
    private void initFilledConditions() {
        filledConditions.put("dhrRequestKind", new EqualityChecker("Couple"));
        filledConditions.put("dhrHaveFamilyReferent", new EqualityChecker("true"));
        filledConditions.put("dhrRequesterNationality", new EqualityChecker("OutsideEuropeanUnion"));
        filledConditions.put("dhrPrincipalPensionPlan", new EqualityChecker("Other"));
        filledConditions.put("dhrRequesterHaveGuardian", new EqualityChecker("true"));
        filledConditions.put("dhrSpouseTitle", new EqualityChecker("Madam"));
        filledConditions.put("dhrSpouseNationality", new EqualityChecker("OutsideEuropeanUnion"));
        filledConditions.put("dhrIsSpouseRetired", new EqualityChecker("true"));
        filledConditions.put("dhrSpousePrincipalPensionPlan", new EqualityChecker("Other"));
        filledConditions.put("dhrCurrentDwellingKind", new EqualityChecker("placeOfResidence"));
        filledConditions.put("dhrPreviousDwelling[0].dhrPreviousDwellingKind", new EqualityChecker("placeOfResidence"));
        filledConditions.put("dhrNotRealAsset[0].dhrNotRealAssetKind", new EqualityChecker("RealEstate"));
    }
    
    /**
     * TODO - move to abstract RequestService
     */
    @Override
    public boolean isConditionFilled (Map<String, String> triggers) {
        initFilledConditions();
        boolean test = true;
        for (Entry<String, String> trigger : triggers.entrySet())
            if (filledConditions.get(trigger.getKey()) != null 
                && filledConditions.get(trigger.getKey()).test(trigger.getValue()))
                test = test && true;
            else
                return false;
        return test;
    }
}