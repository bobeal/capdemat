import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.security.PermissionException
import grails.converters.JSON

class ExceptionUtils {
    
    def static isXRequestError(request) {
        return request.getHeader('x-requested-with') != null
    }
    
    def static isModelException(ex) {
        boolean result = false
        if (ExceptionUtils.extractModelException(ex)) 
            result = true
            
        return result
    }
    
    def static isPermissionException(ex) {
       def cause = ex?.cause
               
       while (cause) {
           if (cause instanceof PermissionException) return true;
           cause = cause?.cause
       }
       return false;
    }

    def static getModelI18nKey(ex) {
        def mex = ExceptionUtils.extractModelException(ex)
        if(mex) return mex.i18nKey
        else return ''
    }
    
    def private static extractModelException(ex) {
        def cause = ex?.cause
        
        while(cause) {
            if(cause instanceof CvqException) return cause;
            cause = cause?.cause
        }
        return null;
    }
}
