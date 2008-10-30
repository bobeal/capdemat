package fr.cg95.cvq.service.document;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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
import fr.cg95.cvq.security.annotation.HomeFolder;
import fr.cg95.cvq.security.annotation.Individual;
import net.sourceforge.safr.core.invocation.MethodInvocation;
import net.sourceforge.safr.core.invocation.ProceedingInvocation;
import net.sourceforge.safr.core.provider.AccessManager;

public class DocumentAccessManager implements AccessManager {

    private IDocumentDAO documentDAO;
    
    @Override
    public void checkCreate(Object arg0) {
        Document document = (Document) arg0;
        if (!performPermissionCheck(document.getHomeFolderId(), document.getIndividualId()))
            throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.WRITE);
    }

    @Override
    public void checkRead(Object arg0) {
        try {
            Document document = (Document) documentDAO.findById(Document.class, (Long) arg0);
            if (!performPermissionCheck(document.getHomeFolderId(), document.getIndividualId()))
                throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.READ);
        } catch (CvqObjectNotFoundException confe) {
            throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.READ);
        }
    }

    @Override
    public void checkUpdate(Object arg0) {
        Document document = null;
        if (arg0 instanceof Document) {
            document = (Document) arg0;
        } else {
            try {
                document = (Document) documentDAO.findById(Document.class, (Long) arg0);
            } catch (CvqObjectNotFoundException confe) {
                throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.WRITE);
            }            
        }

        if (!performPermissionCheck(document.getHomeFolderId(), document.getIndividualId()))
            throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.WRITE);
    }

    @Override
    public void checkDelete(Object arg0) {
        try {
            Document document = (Document) documentDAO.findById(Document.class, (Long) arg0);
            if (!performPermissionCheck(document.getHomeFolderId(), document.getIndividualId()))
                throw new PermissionException(Document.class, arg0, PrivilegeDescriptor.WRITE);
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
    public void checkCustomBefore(MethodInvocation methodInvocation) {
        int i = 0;
        Method method = methodInvocation.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
//        Type[] genericTypes = method.getGenericParameterTypes();
        Object[] arguments = methodInvocation.getArguments();
        Long homeFolderId = null;
        Long individualId = null;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(HomeFolder.class)) {
                    homeFolderId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(Individual.class)) {
                    individualId = (Long) argument;
                }
            }
//            Type parameterType = genericTypes[i];
//            System.err.println("\t has type " + parameterType);                
            i++;
        }
        
        if (!performPermissionCheck(homeFolderId, individualId))
            throw new PermissionException("Denied access to method " + method.getName());
    }

    @Override
    public void checkExecute(MethodInvocation arg0) {
    }
    
    private boolean performPermissionCheck(Long homeFolderId, Long individualId) {
        
        CredentialBean credentialBean = SecurityContext.getCurrentCredentialBean();
        if (credentialBean.isFoContext()) {
            Adult currentAdult = credentialBean.getEcitizen();
            if (homeFolderId != null) {
                if (!homeFolderId.equals(currentAdult.getHomeFolder().getId()))
                    return false;
            } else if (individualId != null) {
                if (!credentialBean.getManagedIndividualsIds().contains(individualId))
                    return false;
            } else {
                return false;
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
                    return false;
            } catch (CvqException e) {
                return false;
            }
        } else {
            return false;
        }        
        
        return true;
    }
    
    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
