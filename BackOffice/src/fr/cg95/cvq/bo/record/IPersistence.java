package fr.cg95.cvq.bo.record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.xml.common.RequestType;

public abstract class IPersistence implements Serializable {
    
    private ArrayList fields = null;
    
    public abstract String getServiceName(String definitionName);
    public abstract void initRequest(RequestRecord requestRecord);
    public abstract void loadRequest(Request request, RequestRecord requestRecord);
    public abstract void saveRequest(Request request, RequestRecord requestRecord) throws CvqException;
    public abstract void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException;
    
    public Long importRequest(RequestType xmlRequest) throws CvqException {
        throw new CvqException("Not implemented.");
    }
    
    public Collection getReportFields() {
        return fields;
    }
    
    protected static boolean getBoolean(Boolean bool) {
        if (bool != null)
            return bool.booleanValue();

        return false;
    }

}
