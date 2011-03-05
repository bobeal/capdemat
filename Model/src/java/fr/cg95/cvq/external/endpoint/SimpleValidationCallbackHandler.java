package fr.cg95.cvq.external.endpoint;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.ws.soap.security.callback.AbstractCallbackHandler;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;

/**
 * Simple callback handler that validates passwords agains capdemat configuration bean. Password
 * validation is done on a case-sensitive basis.
 * 
 * @author vba@zenexity.fr
 *
 */
public class SimpleValidationCallbackHandler extends AbstractCallbackHandler implements InitializingBean {

    private IExternalService externalService;
    
    @Override
    protected void handleInternal(Callback callback) throws IOException, UnsupportedCallbackException {
        
        if (callback instanceof PasswordValidationCallback) {
            PasswordValidationCallback passwordCallback = (PasswordValidationCallback) callback;
            if (passwordCallback.getRequest() instanceof PasswordValidationCallback.PlainTextPasswordRequest) {
                passwordCallback.setValidator(new SimplePlainTextPasswordValidator());
            } else {
                throw new UnsupportedCallbackException(callback,
                        "SimpleValidationCallbackHandler can handle only PasswordValidationCallback");
            }
        }
        else {
            throw new UnsupportedCallbackException(callback);
        }
    }


    public void afterPropertiesSet() throws Exception {
    }
    
    private class SimplePlainTextPasswordValidator implements PasswordValidationCallback.PasswordValidator {

        public boolean validate(PasswordValidationCallback.Request request)
                throws PasswordValidationCallback.PasswordValidationException {
            
            PasswordValidationCallback.PlainTextPasswordRequest plainTextPasswordRequest =
                    (PasswordValidationCallback.PlainTextPasswordRequest) request;
            String label = plainTextPasswordRequest.getUsername();
            String password = plainTextPasswordRequest.getPassword();
            
            boolean authStatus = externalService.authenticate(label, password);
            if (authStatus)
                try {
                    SecurityContext.setCurrentContext(SecurityContext.EXTERNAL_SERVICE_CONTEXT);
                    SecurityContext.setCurrentExternalService(label);
                } catch (CvqException e) {
                    e.printStackTrace();
                    // FIXME : can we do better than that ?
                    return false;
                }
            
            return authStatus;
        }
    }

    public void setExternalService(IExternalService externalService) {
        this.externalService = externalService;
    }
}
