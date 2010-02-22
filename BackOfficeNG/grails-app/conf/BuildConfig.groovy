grails.project.plugins.dir="./plugins"

grails.war.resources = { stagingDir ->
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.aop-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.asm-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.aspects-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.beans-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.context-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.context.support-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.core-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.expression-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.instrument-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.jdbc-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.jms-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.orm-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.oxm-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.transaction-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.web-3.0.0.RELEASE.jar")
    delete(file:"${stagingDir}/WEB-INF/lib/org.springframework.web.servlet-3.0.0.RELEASE.jar")
}
