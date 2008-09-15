package fr.cg95.cvq.service.social.impl;

import java.math.BigInteger;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.social.DhrDonation;
import fr.cg95.cvq.business.social.DhrPersonalEstateAndSaving;
import fr.cg95.cvq.business.social.DhrRealAsset;
import fr.cg95.cvq.business.social.DomesticHelpRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.social.IDomesticHelpRequestService;
import fr.cg95.cvq.xml.social.DomesticHelpRequestDocument;

/**
 * Implementation of the domestic help request service.
 * 
 * @author Rafik Djedjig (rdj@zenexity.fr)
 */
public class DomesticHelpRequestService extends RequestService 
    implements IDomesticHelpRequestService {
    
    static Logger logger = Logger.getLogger(DomesticHelpRequestService.class);

    public Long create(final Request request, final Long requesterId)
        throws CvqException, CvqObjectNotFoundException {
    
        DomesticHelpRequest dhr = (DomesticHelpRequest) request;
        
        // FIXME : don't understand why I have to re-synchronize adults but not addresses
        Adult spouse = dhr.getSpouseInformation();
        if (spouse != null) {
            spouse = (Adult) genericDAO.findById(Adult.class, spouse.getId());
            dhr.setSpouseInformation(spouse);
        }
        processTotals(dhr);
        
        initializeCommonAttributes(dhr, requesterId);
    
        return create(dhr);
    }

    public Long create(Node node) throws CvqException {
        
        DomesticHelpRequestDocument requestDocument = null;
        try {
            requestDocument = DomesticHelpRequestDocument.Factory.parse(node);
        } catch (XmlException xe) {
            logger.error("create() Error while parsing received data");
            xe.printStackTrace();
        }

        DomesticHelpRequest request = 
            DomesticHelpRequest.xmlToModel(requestDocument);
        HomeFolder homeFolder = super.createOrSynchronizeHomeFolder(request);

        // FIXME : don't understand why I have to re-synchronize adults but not addresses
        Adult spouse = request.getSpouseInformation();
        if (spouse != null) {
            spouse = (Adult) genericDAO.findById(Adult.class, spouse.getId());
            request.setSpouseInformation(spouse);
        }
        processTotals(request);
        
        initializeCommonAttributes(request);

        Long requestId = super.create(request);
        if (homeFolder != null) {
            homeFolder.setBoundToRequest(Boolean.valueOf(true));
            homeFolder.setOriginRequestId(requestId);
        }
        
        return requestId;
    }

    public void modify(Request request) throws CvqException {
        
        processTotals((DomesticHelpRequest) request);
        super.modify(request);
    }
    
    private void processTotals(DomesticHelpRequest dhr) {
        
        int subjectTotalIncomes = 
            (dhr.getRequesterPensions() == null ? 0 : dhr.getRequesterPensions().intValue()) 
            + (dhr.getRequesterAllowances() == null ? 0 : dhr.getRequesterAllowances().intValue()) 
            + (dhr.getRequesterInvestmentIncome() == null ? 0 : dhr.getRequesterInvestmentIncome().intValue()) 
            + (dhr.getRequesterNetIncome() == null ? 0 : dhr.getRequesterNetIncome().intValue());
        dhr.setRequesterIncomesAnnualTotal(BigInteger.valueOf(subjectTotalIncomes));
        
        if (dhr.getSpouseInformation() != null) {
            int spouseTotalIncomes = 
                (dhr.getSpousePensions() == null ? 0 : dhr.getSpousePensions().intValue()) 
                + (dhr.getSpouseAllowances() == null ? 0 : dhr.getSpouseAllowances().intValue()) 
                + (dhr.getSpouseInvestmentIncome() == null ? 0 : dhr.getSpouseInvestmentIncome().intValue()) 
                + (dhr.getSpouseNetIncome() == null ? 0 : dhr.getSpouseNetIncome().intValue());
            dhr.setSpouseIncomesAnnualTotal(BigInteger.valueOf(spouseTotalIncomes));
        }
        
        int realAssetsTotal = 0;
        Set<DhrRealAsset> realAssets = dhr.getRealAssets();
        for (DhrRealAsset realAsset : realAssets) {
            realAssetsTotal += 
                realAsset.getRealAssetValue() == null ? 0 : realAsset.getRealAssetValue().intValue();
        }
        dhr.setRealAssetsValuesTotal(BigInteger.valueOf(realAssetsTotal));
        
        int donationsTotal = 0;
        Set<DhrDonation> donations = dhr.getDonations();
        for (DhrDonation donation : donations) {
            donationsTotal += 
                donation.getDonationValue() == null ? 0 : donation.getDonationValue().intValue();
        }
        dhr.setDonationsValuesTotal(BigInteger.valueOf(donationsTotal));
        
        int savingsTotal = 0;
        Set<DhrPersonalEstateAndSaving> savings = dhr.getSavings();
        for (DhrPersonalEstateAndSaving saving : savings) {
            savingsTotal += 
                saving.getPaybookAmount() == null ? 0 : saving.getPaybookAmount().intValue();
        }
        dhr.setSavingsTotal(BigInteger.valueOf(savingsTotal));
        
        int capitalsTotal = 
            (dhr.getSharesAmount() == null ? 0 : dhr.getSharesAmount().intValue()) 
            + (dhr.getBondsAmount() == null ? 0 : dhr.getBondsAmount().intValue());
        dhr.setCapitalAmountTotal(BigInteger.valueOf(capitalsTotal));
        
        int taxesTotal = 
            (dhr.getIncomeTax() == null ? 0 : dhr.getIncomeTax().intValue())
            + (dhr.getLocalRate() == null ? 0 : dhr.getLocalRate().intValue())
            + (dhr.getPropertyTaxes() == null ? 0 : dhr.getPropertyTaxes().intValue())
            + (dhr.getProfessionalTaxes() == null ? 0 : dhr.getProfessionalTaxes().intValue());
        dhr.setTaxesTotal(BigInteger.valueOf(taxesTotal));
        
        int expensesTotal = 
            (dhr.getRent() == null ? 0 : dhr.getRent().intValue())
            + (dhr.getAlimonies() == null ? 0 : dhr.getAlimonies().intValue());
        dhr.setExpensesTotal(BigInteger.valueOf(expensesTotal));
    }
    
    public boolean accept(Request request) {
        return request instanceof DomesticHelpRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new DomesticHelpRequest();
    }
       
}
