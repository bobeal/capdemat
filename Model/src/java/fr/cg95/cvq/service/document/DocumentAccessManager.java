package fr.cg95.cvq.service.document;

import java.util.Set;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.security.CredentialBean;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import net.sourceforge.safr.core.invocation.MethodInvocation;
import net.sourceforge.safr.core.invocation.ProceedingInvocation;
import net.sourceforge.safr.core.provider.AccessManager;

public class DocumentAccessManager implements AccessManager {

    private IDocumentDAO documentDAO;
    
    @Override
    public void checkCreate(Object arg0) {
        performPermissionCheck((Document) arg0, PrivilegeDescriptor.WRITE);
    }

    @Override
    public void checkRead(Object arg0) {
        try {
            Document document = (Document) documentDAO.findById(Document.class, (Long) arg0);
            performPermissionCheck(document, PrivilegeDescriptor.READ);
        } catch (CvqObjectNotFoundException confe) {
            throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.READ);
        }
    }

    @Override
    public void checkUpdate(Object arg0) {
        if (arg0 instanceof Document) {
            performPermissionCheck((Document) arg0, PrivilegeDescriptor.WRITE);
        } else {
            try {
                Document document = (Document) documentDAO.findById(Document.class, (Long) arg0);
                performPermissionCheck(document, PrivilegeDescriptor.READ);
            } catch (CvqObjectNotFoundException confe) {
                throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.READ);
            }            
        }
    }

    @Override
    public void checkDelete(Object arg0) {
        try {
            Document document = (Document) documentDAO.findById(Document.class, (Long) arg0);
            performPermissionCheck(document, PrivilegeDescriptor.WRITE);
        } catch (CvqObjectNotFoundException confe) {
            throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.WRITE);
        }
    }

    @Override
    public Object checkCustomAfter(MethodInvocation arg0, Object arg1) {
        return null;
    }

    @Override
    public Object checkCustomAround(ProceedingInvocation arg0) throws Throwable {
        return null;
    }

    @Override
    public void checkCustomBefore(MethodInvocation arg0) {
    }

    @Override
    public void checkExecute(MethodInvocation arg0) {
    }
    
    private void performPermissionCheck(Document document, PrivilegeDescriptor privilegeDescriptor) {

        CredentialBean credentialBean = SecurityContext.getCurrentCredentialBean();
        if (credentialBean.isFoContext()) {
            Adult currentAdult = credentialBean.getEcitizen();
            Long homeFolderId = document.getHomeFolderId();
            Long individualId = document.getIndividualId();
            if (homeFolderId != null) {
                if (!homeFolderId.equals(currentAdult.getHomeFolder().getId()))
                    throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
            } else if (individualId != null) {
                if (!credentialBean.getManagedIndividualsIds().contains(individualId))
                    throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
            } else {
                throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
            }
        } else if (SecurityContext.getCurrentContext().equals(SecurityContext.BACK_OFFICE_CONTEXT)) {
            try {
                Agent agent = SecurityContext.getCurrentAgent();
                Set<SiteRoles> siteRoles = agent.getSitesRoles();
                boolean hasAnAgentProfile = false;
                for (SiteRoles siteRole : siteRoles) {
                    if (siteRole.getProfile().equals(SiteProfile.AGENT))
                        hasAnAgentProfile = true;
                }
                if (!hasAnAgentProfile)
                    throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
            } catch (CvqException e) {
                throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
            }
        } else {
            throw new PermissionException(Document.class, document, PrivilegeDescriptor.READ);
        }        
    }

    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
