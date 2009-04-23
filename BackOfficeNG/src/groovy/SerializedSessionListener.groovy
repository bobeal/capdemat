import javax.servlet.http.HttpSessionEvent
import javax.servlet.http.HttpSessionListener

public class SerializedSessionListener implements HttpSessionListener {
    
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }   

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        def session = httpSessionEvent.getSession()
        getSessionUUIDs(session).each {
            def tmpSessionPath = session['javax.servlet.context.tempdir'] + '/' + it
            def tmpSessionDir = new File(tmpSessionPath)
            if (tmpSessionDir.exists())
                tmpSessionDir.delete()
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

