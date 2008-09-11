import org.codehaus.groovy.grails.commons.GrailsClassUtils as GCU

grailsHome = Ant.project.properties."environment.GRAILS_HOME"
includeTargets << new File ( "${grailsHome}/scripts/RunApp.groovy" )

target ('default': "Compress js and css source files. Run's a Grails application in Jetty") {
        depends( checkVersion, configureProxy, packageApp )
    yuiCompress()
    runApp()
    watchContext()
}

target(yuiCompress: "Compress js and css source files") {
    new File('web-app/').eachFileRecurse { file ->
      if (file.getName().endsWith('.js') || file.getName().endsWith('.css')) {
          println "Bong YUI compressor : ${file}"
          Ant.java (jar: "ext/yuicompressor-2.3.6.jar", fork: true) {
              arg (value: "-o")
              arg (value: "${file}")
              arg (value: "${file}")
          }
      }
    }
}
