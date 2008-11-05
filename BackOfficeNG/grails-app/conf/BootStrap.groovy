import fr.cg95.cvq.exception.CvqException


class BootStrap {
    
    //def exceptionHandler
    
    def init = { servletContext ->
        servletContext.setAttribute("newDataBinder", GlobalPropertyEditorConfig.&newDataBinder)
        //exceptionHandler.exceptionMappings =['java.lang.Exception' : '/error/unexpected']
    }
    def destroy = {
        
    }
} 
