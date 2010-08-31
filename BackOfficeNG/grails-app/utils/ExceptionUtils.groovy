import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.exception.CvqConcurrentModificationException
import fr.cg95.cvq.security.PermissionException

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
    
    def static getModelI18nArgs(ex) {
        def mex = ExceptionUtils.extractModelException(ex)
        def args = []
        if(mex) mex.i18nArgs.each { args.add(it) }
        return args
    }

    def private static extractModelException(ex) {
        def cause = ex
        while(cause) {
            if(cause instanceof CvqException) return cause;
            cause = cause?.cause
        }
        return null;
    }

    def static extractConcurrentModificationException(ex) {
        def cause = ex
        while (cause) {
            if (cause instanceof CvqConcurrentModificationException) return cause;
            cause = cause.cause
        }
        return null
    }
}
