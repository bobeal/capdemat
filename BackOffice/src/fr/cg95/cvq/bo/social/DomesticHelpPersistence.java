package fr.cg95.cvq.bo.social;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.social.DhrDonation;
import fr.cg95.cvq.business.social.DhrPersonalEstateAndSaving;
import fr.cg95.cvq.business.social.DhrRealAsset;
import fr.cg95.cvq.business.social.DomesticHelpRequest;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.social.IDomesticHelpRequestService;

public class DomesticHelpPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IDomesticHelpRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
    }
    
    public void loadRequest(Request request, RequestRecord requestRecord) {
        DomesticHelpRequest registration = (DomesticHelpRequest)request;
        DomesticHelpRequestRecord record = (DomesticHelpRequestRecord)requestRecord;
        
        // Patrimony
        record.setDonations(getDonations(registration.getDonations()));
        record.setRealAssets(getRealAssets(registration.getRealAssets()));
        record.setSavings(getSavings(registration.getSavings()));
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {

    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {

    }

    private List getDonations(Set modelSet) {
        ArrayList<DhrDonations> list = new ArrayList<DhrDonations>();
        Iterator iter = modelSet.iterator();
        while (iter.hasNext()) {
            DhrDonation registration = (DhrDonation)iter.next();
            
            DhrDonations record = new DhrDonations();
            record.load(registration);
            
            list.add(record);
        }
        return list;
    }

    private List getRealAssets(Set modelSet) {
        ArrayList<DhrRealAssets> list = new ArrayList<DhrRealAssets>();
        Iterator iter = modelSet.iterator();
        while (iter.hasNext()) {
            DhrRealAsset registration = (DhrRealAsset)iter.next();
            
            DhrRealAssets record = new DhrRealAssets();
            record.load(registration);
            
            list.add(record);
        }
        return list;
    }

    private List getSavings(Set modelSet) {
        ArrayList<DhrSavings> list = new ArrayList<DhrSavings>();
        Iterator iter = modelSet.iterator();
        while (iter.hasNext()) {
            DhrPersonalEstateAndSaving registration = (DhrPersonalEstateAndSaving)iter.next();
            
            DhrSavings record = new DhrSavings();

            record.load(registration);
            
            list.add(record);
        }
        return list;
    }

}
