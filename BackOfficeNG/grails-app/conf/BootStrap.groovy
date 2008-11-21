import fr.cg95.cvq.exception.CvqException
import com.zenexity.capdemat.utils.*
import grails.util.*
import groovy.util.*

class BootStrap {
    
    //def exceptionHandler
    
    def init = { servletContext ->
        servletContext.setAttribute("newDataBinder", GlobalPropertyEditorConfig.&newDataBinder)
        //exceptionHandler.exceptionMappings =['java.lang.Exception' : '/error/unexpected']
        ModuleHelper.prepareAll(new File(servletContext.getRealPath('.')).parent)
    }
    
    def destroy = {
        
    }
} 
