package fr.cg95.cvq.dao.request.xml;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.dao.request.ILocalReferentialDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import java.io.File;
import java.util.Set;

/**
 * @author julien
 */
public class LocalReferentialDAO implements ILocalReferentialDAO {
    
    private IRequestServiceRegistry requestServiceRegistry;
    private ILocalAuthorityRegistry localAuthorityRegistry;

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }
    

    @Override
    public Set<LocalReferentialType> listByRequestType(final String requestTypeLabel) {
        File file = getLocalReferentialFile(requestTypeLabel);
        if (file == null) {
            return null;
        }
        try {
            return LocalReferentialXml.xmlToModel(file);
        } catch (CvqException e) {
            return null;
        }
    }

    @Override
    public LocalReferentialType getByRequestTypeAndName(final String requestTypeLabel, final String typeName) {
        final Set<LocalReferentialType> lrts = listByRequestType(requestTypeLabel);
        if (lrts == null) {
            return null;
        }
        for (final LocalReferentialType lrt : lrts) {
            if (lrt.getName().equals(typeName)) {
                return lrt;
            }
        }
        return null;
    }

    @Override
    public void save(final String requestTypeLabel, final LocalReferentialType lrt) {
        try {
            LocalReferentialXml.modelToXml(lrt, getLocalReferentialFile(requestTypeLabel));
        } catch (CvqException ex) {
            // What am I supposed to do?
        }
    }
    
    /**
     * @param requestTypeLabel
     * @return The File associated to the given requestTypeLabel, or null if this request type does not have a local referential
     */
    private File getLocalReferentialFile(final String requestTypeLabel) {
        final String fileName = requestServiceRegistry.getRequestService(requestTypeLabel).getLocalReferentialFilename();
        if (fileName != null) {
            return localAuthorityRegistry.getLocalAuthorityResourceFile(Type.LOCAL_REFERENTIAL, fileName, true);
        }
        return null;
    }
}
