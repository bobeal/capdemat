import fr.cg95.cvq.exception.*
import grails.converters.JSON

class ExceptionUtils {
    
    static isModelException = { ex ->
        if(ExceptionUtils.extractModelException(ex)) return true
        else return false
    }
    
    static getModelI18nKey = { ex ->
        def mex = ExceptionUtils.extractModelException(ex)
        if(mex) return mex.i18nKey
        else return ''
    }
    
    private static extractModelException = { ex ->
        def cause = ex?.cause
        
        while(cause) {
            if(cause instanceof CvqException) return cause;
            cause = cause?.cause
        }
        return null;
    }
    
    //static getModelJSON = { ex ->
    //    //return ([status:"modelException", message:message(code:ex.message?.encodeAsHTML())] as JSON)
    //    return message(ex.message?.encodeAsHTML())
    //}
    
    
}
