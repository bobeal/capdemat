package helpers

class ModuleHelper {
    
    public main = { args ->
    }
    
    public static prepare = { File file, basedir ->
        if(file.name.endsWith('Controller.groovy')) ModuleHelper.prepareController(file,basedir)
        else if(file.name.endsWith('.gsp')) ModuleHelper.prepareView(file,basedir)
        
        ModuleHelper.prepareMappings(ModuleHelper.getAppName(file,basedir),basedir)
    }
    
    public static prepareAll = { basedir ->
        def ant = new AntBuilder();
        File apps = new File("$basedir/modules")
        if (apps.exists()) {
            apps.eachFile {
                def app = it
                File cts = new File("${it.canonicalPath}/controllers")
                cts.eachFile {ModuleHelper.prepare(it,basedir)}
                ModuleHelper.prepareMappings(app.name,basedir)
                
                ['shared','layouts'].each{
                    def t = it
                    ant.copy(todir:"$basedir/grails-app/views/$t",overwrite:true,failonerror:false) {
                        fileset(dir:"$app.canonicalPath/views/$t") {include(name:"**/*.gsp")}
                    }
                }
            }
        }
    }
    
    public static cleanAll = { basedir ->
        def ant = new AntBuilder()
        File apps = new File("$basedir/modules")
        if(apps.exists()) {
            apps.eachFile {
                def app = it
                File cts = new File("${it.canonicalPath}/controllers")
                cts.eachFile {
                    def cname = "${ModuleHelper.firstCase(app.name,'')}${it.name}"
                    ant.delete(file:"$basedir/grails-app/controllers/$cname", failonerror:false)
                    def vname = "$app.name${it.name.replaceAll('Controller.groovy','')}" 
                    ant.delete(dir:"$basedir/grails-app/views/$vname")
                }
                
                ['shared','layouts'].each{
                    def t = new File("$basedir/grails-app/views/$it")
                    if(t.exists()) {
                        t.eachFile{
                            ant.delete(
                                file:"$basedir/grails-app/views/${t.name}/${it.name}", 
                                failonerror:false
                            )
                        }
                    }
                }
                
                def mname = "${ModuleHelper.firstCase(app.name,'')}UrlMappings.groovy"
                ant.delete(file:"$basedir/grails-app/conf/$mname", failonerror:false)
            }
        }
    }
    
    protected static prepareController = { file, basedir ->
        def ant = new AntBuilder();
        // Place controller to grails-app
        String name = file.name.replaceAll('.groovy','')
        File parent = new File(file.parent.replaceAll('/controllers',''))
        def prefix = ModuleHelper.firstCase(parent.name,'Upper')
        def newName = "${prefix}${name}"
        String content = file.text.replaceAll(/(class\s+)(\w+Controller)/,'$1'+newName )
        File target = new File("$basedir/grails-app/controllers/${newName}.groovy").write(content)
        
        // Place depended views to grails-app
        File views = new File(file.parent.replaceAll(
            '/controllers',
            '/views/'+ModuleHelper.firstCase(name,'Lower').replaceAll('Controller',''))
        )
        
        if(views.exists() && views.directory) {
            newName = ModuleHelper.firstCase(newName.toString(),'Lower').replaceAll('Controller','')
            target = new File("$basedir/grails-app/views/${newName}")
            
            ant.copy(todir:target.canonicalPath,overwrite:true) {
                fileset(dir:views.canonicalPath) {include(name:"**/*.gsp")}
            }
            
        }
        
    }
    
    protected static prepareView = { file, basedir ->
        def app = ModuleHelper.getAppName(file,basedir)
        def view = file.canonicalPath.replaceAll(basedir,'')
            .replaceAll("^/?modules/$app/views/([^/]*)/.*",'$1')
        def controller = "${ModuleHelper.firstCase(view,'')}Controller.groovy"
        def cl = new File("$basedir/modules/$app/controllers/$controller");
        
        if( cl.exists() ) {
            ModuleHelper.prepareController(cl,basedir)
        } else {
            def ant = new AntBuilder();
            ant.copy(todir:"$basedir/grails-app/views/$view/",overwrite:true) {
                fileset(dir:"$basedir/modules/$app/views/$view/") {include(name:"**/*.gsp")}
            }
        }
    }
    
    protected static prepareMappings = {appname, basedir ->
        //def appname = ModuleHelper.getAppName(file,basedir)
        def contdir = new File("$basedir/modules/$appname/controllers")
        def mapfile = new File("$basedir/grails-app/conf/${ModuleHelper.firstCase(appname,'')}UrlMappings.groovy")  
        
        if(mapfile.exists()) mapfile.delete()
        mapfile << "class ${ModuleHelper.firstCase(appname,'')}UrlMappings {\n" +
                "  static mappings = {\n\n"
        
        contdir.eachFile{
            def cname = ModuleHelper.firstCase(it.name,'Lower').replaceAll('Controller.groovy','')
            mapfile << "    \"/$appname/$cname/\$action?/\$id?\" (controller : \"" +
                "$appname${ModuleHelper.firstCase(cname,'')}\" )\n"
        }
        
        mapfile << "\n  }\n}\n"
    }
    
    protected static getAppName = {file, basedir ->
        return  file.canonicalPath.replaceAll(basedir,'').replaceAll("^/?modules/([^/]*)/.*",'$1')
    }
    
    private static firstCase = { str,cs ->
        if(!['Upper','Lower'].contains(cs)) cs = 'Upper'
        def result = str as List
        result[0] = result[0]."to${cs}Case"()
        return result.join('')
    }
}