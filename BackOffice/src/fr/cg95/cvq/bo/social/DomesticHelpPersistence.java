package fr.cg95.cvq.bo.social;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.social.DhrNotRealAsset;
import fr.cg95.cvq.business.social.DhrRealAsset;
import fr.cg95.cvq.business.social.DomesticHelpRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.social.IDomesticHelpRequestService;

public class DomesticHelpPersistence extends IPersistence {

    public String getServiceName(String definitionName) {
        return IDomesticHelpRequestService.SERVICE_NAME;
    }

    public void initRequest(RequestRecord requestRecord) {
    }

    public void loadRequest(Request request, RequestRecord requestRecord) {
        DomesticHelpRequest registration = (DomesticHelpRequest) request;
        DomesticHelpRequestRecord record = (DomesticHelpRequestRecord) requestRecord;

        // Patrimony
        record.setNotRealAssets(getNotRealAssets(registration.getNotRealAssets()));
        record.setRealAssets(getRealAssets(registration.getRealAssets()));
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {

    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {

    }

    private List getNotRealAssets(Set modelSet) {
        ArrayList<DhrNotRealAssets> list = new ArrayList<DhrNotRealAssets>();
        Iterator iter = modelSet.iterator();
        while (iter.hasNext()) {
            DhrNotRealAsset registration = (DhrNotRealAsset) iter.next();

            DhrNotRealAssets record = new DhrNotRealAssets();
            record.load(registration);

            list.add(record);
        }
        return list;
    }

    private List getRealAssets(Set modelSet) {
        ArrayList<DhrRealAssets> list = new ArrayList<DhrRealAssets>();
        Iterator iter = modelSet.iterator();
        while (iter.hasNext()) {
            DhrRealAsset registration = (DhrRealAsset) iter.next();

            DhrRealAssets record = new DhrRealAssets();
            record.load(registration);

            list.add(record);
        }
        return list;
    }

}