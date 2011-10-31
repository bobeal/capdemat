grails.project.plugins.dir="./plugins"

grails.war.resources = { stagingDir ->
    File libDir = new  File(stagingDir, 'WEB-INF/lib')
    
    def deleteJars = { jarNamePattern ->
        libDir.eachFile { file ->
            if (file.name.matches(jarNamePattern)) {
                file.delete()
            }
        }
    }

    deleteJars java.util.regex.Pattern.compile('org.springframework.*3.0.0.*.jar') // conflicts with our version of spring framework
    deleteJars java.util.regex.Pattern.compile('ejb3-persistence-.*.jar') // remove JPA 1 from the war 
    deleteJars java.util.regex.Pattern.compile('hsqldb-*.jar')
}
