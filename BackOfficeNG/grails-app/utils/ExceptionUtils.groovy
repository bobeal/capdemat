import fr.cg95.cvq.exception.*
import grails.converters.JSON

class ExceptionUtils {
    
    static isModelException = { ex ->
        def cause = ex?.cause
        
        while(cause) {
            if(cause instanceof CvqException) return true;
            cause = cause?.cause
        }
        return false;
    }
    
    //static getModelJSON = { ex ->
    //    //return ([status:"modelException", message:message(code:ex.message?.encodeAsHTML())] as JSON)
    //    return message(ex.message?.encodeAsHTML())
    //}
    
    
}
