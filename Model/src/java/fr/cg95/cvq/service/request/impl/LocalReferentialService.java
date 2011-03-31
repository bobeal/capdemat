package fr.cg95.cvq.service.request.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialEntryData;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.dao.request.ILocalReferentialDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.ILocalReferentialService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestTypeLifecycleAware;
import java.util.HashSet;

public class LocalReferentialService 
    implements ILocalReferentialService,
        IRequestTypeLifecycleAware {

    private static Logger logger = Logger.getLogger(LocalReferentialService.class);

    private ILocalReferentialDAO localReferentialDAO;
    
    private Set<IRequestService> requestServices = new HashSet<IRequestService>();

    /**
     * IRequestTypeLifecycleAware interface
     */
    @Override
    public void addRequestTypeService(final IRequestService service) {

        logger.debug("inspecting request type : " + service.getLabel());

        if (service.getLocalReferentialFilename() == null) {
            logger.debug("addRequestTypeService() Service does not have a local referential");
            return;
        } else {
            synchronized(this) {
                requestServices.add(service);
            }
        }
    }

    /**
     * IRequestTypeLifecycleAware interface
     */
    @Override
    public void removeRequestType(String requestTypeLabel) {

        logger.debug("removing request type : " + requestTypeLabel);

        synchronized(this) {
            IRequestService requestToRemove = null;

            for (IRequestService request : requestServices) {
                if (request.getLabel().equals(requestTypeLabel)) {
                    requestToRemove = request;
                    break;
                }
            }
            if (requestToRemove != null) {
                requestServices.remove(requestToRemove);
            }
        }
    }


    @Override
    @Context(types = {ContextType.AGENT,ContextType.ECITIZEN,ContextType.UNAUTH_ECITIZEN}, privilege = ContextPrivilege.NONE)
    public Set<LocalReferentialType> getLocalReferentialTypes(final String requestTypeLabel) throws CvqException {
        Set<LocalReferentialType> lrts = localReferentialDAO.listByRequestType(requestTypeLabel);
        if (lrts != null)
            return lrts;
        throw new CvqException("No local referential for " + requestTypeLabel);
    }

    @Override
    @Context(types = {ContextType.AGENT,ContextType.ECITIZEN,ContextType.UNAUTH_ECITIZEN}, privilege = ContextPrivilege.NONE)
    public LocalReferentialType getLocalReferentialType(String requestTypeLabel, String typeName) throws CvqException {
        LocalReferentialType lrt = localReferentialDAO.getByRequestTypeAndName(requestTypeLabel, typeName);
        if (lrt != null)
            return lrt;
        throw new CvqException(typeName + " not found!");
    }
    
    @Override
    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    public boolean isLocalReferentialConfigured(final String requestTypeLabel)
        throws CvqException {
        
        Set<LocalReferentialType> lrTypes = getLocalReferentialTypes(requestTypeLabel);
        boolean isConfigure = true;
        for (LocalReferentialType lrType : lrTypes)
            if (lrType.getEntries() == null || !lrType.getEntries().iterator().hasNext())
                isConfigure = false;
        
        return isConfigure;
    }

    @Context(types = {ContextType.AGENT}, privilege = ContextPrivilege.MANAGE)
    private void saveLocalReferentialType(final String requestTypeLabel, LocalReferentialType newLrt)
        throws CvqException {
        
        localReferentialDAO.save(requestTypeLabel, newLrt);
    }

    @Override
    public void removeLocalReferentialEntry(String requestTypeLabel, String typeName, String entryKey) throws CvqException {
        LocalReferentialType lrt = getLocalReferentialType(requestTypeLabel, typeName);
        LocalReferentialEntry entry = lrt.getEntryByKey(entryKey);
        if (entry != null) {
            lrt.removeEntry(entry);
            saveLocalReferentialType(requestTypeLabel, lrt);
        }
    }

    @Override
    public LocalReferentialEntryData getLocalReferentialEntry(String requestTypeLabel, String typeName, String key) throws CvqException {
        return getLocalReferentialType(requestTypeLabel, typeName).getEntryByKey(key);
    }

    @Override
    public boolean isLocalReferentialTypeAllowingMultipleChoices(String requestTypeLabel, String typeName) throws CvqException {
        return getLocalReferentialType(requestTypeLabel, typeName).isMultiple();
    }

    @Override
    public void setLocalReferentialTypeAllowingMultipleChoices(String requestTypeLabel, String typeName, boolean multiple) throws CvqException {
        LocalReferentialType lrt = getLocalReferentialType(requestTypeLabel, typeName);
        lrt.setMultiple(multiple);
        saveLocalReferentialType(requestTypeLabel, lrt);
    }

    @Override
    public String addLocalReferentialEntry(String requestTypeLabel, String typeName, String parentKey, String label, String message) throws CvqException {
        LocalReferentialType lrt = getLocalReferentialType(requestTypeLabel, typeName);
        LocalReferentialEntry parent = parentKey == null ? null : lrt.getEntryByKey(parentKey);
        
        LocalReferentialEntry entry = new LocalReferentialEntry();
        entry.setLabel(label);
        entry.setMessage(message);
        
        lrt.addEntry(entry, parent);
        saveLocalReferentialType(requestTypeLabel, lrt);
        
        return entry.getKey();
    }

    @Override
    public String addLocalReferentialEntry(String requestTypeLabel, String typeName, String parentKey, String key, String label, String message) throws CvqException {
        // FIXME factoriser ce code avec celui d’au-dessus
        LocalReferentialType lrt = getLocalReferentialType(requestTypeLabel, typeName);
        LocalReferentialEntry parent = parentKey == null ? null : lrt.getEntryByKey(parentKey);
        
        LocalReferentialEntry entry = new LocalReferentialEntry();
        entry.setLabel(label);
        entry.setMessage(message);
        entry.setKey(key);
        
        lrt.addEntry(entry, parent);
        saveLocalReferentialType(requestTypeLabel, lrt);
        
        return entry.getKey();
    }
    
    @Override
    public void editLocalReferentialEntry(String requestTypeLabel, String typeName, String key, String label, String message) throws CvqException {
        LocalReferentialType lrt = getLocalReferentialType(requestTypeLabel, typeName);
        LocalReferentialEntry lre = lrt.getEntryByKey(key);
        
        lre.setLabel(label);
        lre.setMessage(message);
        
        saveLocalReferentialType(requestTypeLabel, lrt);
    }
    
    /**
     * @deprecated only used in unit tests
     */
    @Override
    @Deprecated
    public final Set<LocalReferentialType> getAllLocalReferentialData()
        throws CvqException {

        logger.debug("getAllLocalReferentialData()");

        Set<LocalReferentialType> resultSet = new LinkedHashSet<LocalReferentialType>();
        
        synchronized (this) {
            for (IRequestService request : requestServices) {
                resultSet.addAll(localReferentialDAO.listByRequestType(request.getLabel()));
            }
        }

        return resultSet;
    }


    @Override
    @Deprecated
    public Set<String> getAllLocalReferentialRequestTypeLabels() throws CvqException {
        Set<String> labels = new LinkedHashSet<String>();
        
        Set<LocalReferentialType> lrts = getAllLocalReferentialData();
        for (LocalReferentialType lrt : lrts) {
            labels.add(lrt.getLabel());
        }
        
        return labels;
    }

    public void setLocalReferentialDAO(ILocalReferentialDAO localReferentialDAO) {
        this.localReferentialDAO = localReferentialDAO;
    }
}
