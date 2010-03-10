import javax.servlet.http.HttpSessionEvent
import javax.servlet.http.HttpSessionListener

import org.codehaus.groovy.grails.commons.ApplicationHolder
import org.springframework.context.ApplicationContext

import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.document.IDocumentService

public class SerializedSessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        ApplicationContext ctx = (ApplicationContext) ApplicationHolder.getApplication().getMainContext()
        IDocumentService documentService = (IDocumentService) ctx.getBean("documentService")
        ILocalAuthorityRegistry localAuthorityRegistry = (ILocalAuthorityRegistry) ctx.getBean("localAuthorityRegistry")

        def session = httpSessionEvent.getSession()
        getSessionUUIDs(session).each {
            localAuthorityRegistry.callback(session['currentSiteName'], documentService,
                "deleteUnpersistedSessionDocuments", [it] as String[])
        }
    }

    private Set getSessionUUIDs(session) {
        def uuidSet = [] as Set
        session.attributeNames.each {
            if (isUuid(it)) uuidSet.add(it)
        }
        return uuidSet
    }

    private boolean isUuid(uuidString) {
        try {
            UUID.fromString(uuidString)
            return true
        } catch (IllegalArgumentException e) {
            return false
        }
    }
}

