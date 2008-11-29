package fr.cg95.cvq.service.document.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.dao.document.IDocumentDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.GenericAccessManager;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.security.annotation.IsHomeFolder;
import fr.cg95.cvq.security.annotation.IsIndividual;
import fr.cg95.cvq.service.document.annotation.IsDocument;

@Aspect
public class DocumentContextCheckAspect implements Ordered {

    private IDocumentDAO documentDAO;
    
    @Before("fr.cg95.cvq.SystemArchitecture.businessService() && @annotation(context) && within(fr.cg95.cvq.service.document..*)")
    public void contextAnnotatedMethod(JoinPoint joinPoint, Context context) {
        
        if (!context.type().equals(ContextType.ECITIZEN) 
                && !context.type().equals(ContextType.ECITIZEN_AGENT))
            return;
        
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        
        Method method = signature.getMethod();
        Annotation[][] parametersAnnotations = method.getParameterAnnotations();
        Object[] arguments = joinPoint.getArgs();
        Long homeFolderId = null;
        Long individualId = null;
        int i = 0;
        for (Object argument : arguments) {
            if (parametersAnnotations[i] != null && parametersAnnotations[i].length > 0) {
                Annotation parameterAnnotation = parametersAnnotations[i][0];
                if (parameterAnnotation.annotationType().equals(IsHomeFolder.class)) {
                    homeFolderId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsIndividual.class)) {
                    individualId = (Long) argument;
                } else if (parameterAnnotation.annotationType().equals(IsDocument.class)) {
                    Document document = null;
                    if (argument instanceof Long) {
                        try {
                            document = (Document) documentDAO.findById(Document.class, (Long) argument);
                        } catch (CvqObjectNotFoundException confe) {
                            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                                    joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                                    "unknown resource type : " + argument);
                        }
                    } else if (argument instanceof Document) {
                        document = (Document) argument;
                    } else {
                        throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                                joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                                "unable to retrieve document from " + argument);
                    }
                    homeFolderId = document.getHomeFolderId();
                    individualId = document.getIndividualId();
                }
            }
            i++;
        }

        if (!GenericAccessManager.performPermissionCheck(homeFolderId, 
                individualId, context.privilege()))
            throw new PermissionException(joinPoint.getSignature().getDeclaringType(), 
                    joinPoint.getSignature().getName(), context.type(), context.privilege(), 
                    "access denied on home folder " + homeFolderId 
                        + " / individual " + individualId);
    }
    
    @Override
    public int getOrder() {
        return 1;
    }

    public void setDocumentDAO(IDocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
