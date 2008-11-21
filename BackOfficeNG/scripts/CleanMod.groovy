import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU
import groovy.text.SimpleTemplateEngine

Ant.property(environment:"env")                             
grailsHome = Ant.antProject.properties."env.GRAILS_HOME"

includeTargets << new File ( "${grailsHome}/scripts/Clean.groovy" )

target ('default': "Cleans project modules") {
    cleanMod()
}

target (cleanMod: "Implementation of clean-mod") {
    event("CleanStart", [])
    //depends(clean)
    event("CleanEnd", [])
}