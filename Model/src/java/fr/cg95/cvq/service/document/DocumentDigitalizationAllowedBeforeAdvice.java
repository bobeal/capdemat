package fr.cg95.cvq.service.document;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import fr.cg95.cvq.exception.CvqDisabledFunctionalityException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

public final class DocumentDigitalizationAllowedBeforeAdvice implements MethodBeforeAdvice {

    static Logger logger = Logger.getLogger(DocumentDigitalizationAllowedBeforeAdvice.class);

    private ILocalAuthorityRegistry localAuthorityRegistry;
    
    public void before(final Method method, final Object[] args, final Object target)
        throws CvqDisabledFunctionalityException {

        LocalAuthorityConfigurationBean lacb =
            localAuthorityRegistry.getLocalAuthorityBean(SecurityContext.getCurrentSite());

        if (!lacb.isDocumentDigitalizationEnabled().booleanValue()) {
            logger.error("before() document digitalization is not enabled for site "
                         + lacb.getName());
            throw new CvqDisabledFunctionalityException();
        }
    }
    
    public void setLocalAuthorityRegistry(final ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}
