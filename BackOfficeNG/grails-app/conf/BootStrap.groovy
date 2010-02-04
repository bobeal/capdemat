import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes

class BootStrap {
    
    def init = { servletContext ->
        servletContext.setAttribute("newDataBinder", GlobalPropertyEditorConfig.&newDataBinder)

         // HACK: avoid default configuration of messageSource!!! (http://tramuntanal.wikidot.com/grails)
        def appContext = servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
        def messageSource = appContext.getBean("messageSource")
        messageSource.fallbackToSystemLocale = false
    }
    
    def destroy = {
    }
} 
