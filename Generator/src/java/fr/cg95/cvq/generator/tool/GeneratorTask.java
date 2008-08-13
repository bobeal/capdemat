package fr.cg95.cvq.generator.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.FileScanner;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;

import fr.cg95.cvq.generator.CodeGenerator;
import fr.cg95.cvq.generator.PluginInstanciationException;

public class GeneratorTask extends MatchingTask {

    private ArrayList schemas = new ArrayList();

    private Path plugins;

    public void execute() throws BuildException {

	// check we have at least one schema to parse
	if (schemas.size() == 0 && fileset.getDir(getProject()) == null) {
	    String msg = "A nested fileset is required.";
	    throw new BuildException(msg);
	}

        if (fileset.getDir(getProject()) != null)
            schemas.add(fileset);

	CodeGenerator codeGenerator = new CodeGenerator();

	// register plugins
	String[] pathElements = plugins.list();
	for (int i=0; i < pathElements.length; i++) {
	    if (pathElements[i].endsWith("_plugin.xml")) {
		try {
		    codeGenerator.registerPlugin(new File(pathElements[i]));
		} catch (PluginInstanciationException pie) {
		    throw new BuildException("Error while loading plugin " + pathElements[i] + "(" + pie.getMessage() + ")");
		} catch (IOException xe) {
		    throw new BuildException("IO Exception while parsing plugin definition from " + pathElements[i]);
		}
	    }
	}

	// invoke schemas parsing
        Iterator si = schemas.iterator();
        while (si.hasNext())
        {
            FileSet fs = (FileSet) si.next();
            FileScanner scanner = fs.getDirectoryScanner(getProject());
            File basedir = scanner.getBasedir();
            String[] paths = scanner.getIncludedFiles();

	    for (int i=0; i < paths.length; i++) {
		codeGenerator.parseXsdFile(new File(basedir, paths[i]));
	    }
        }

	codeGenerator.shutdownPlugins();
    }

    public void setPlugins(Path plugins) {
	this.plugins = plugins;
    }

    public Path createPlugins() {
        if (plugins == null) {
            plugins = new Path(getProject());
        }
        return plugins.createPath();
    }

    public void addFileset(FileSet fileset)
    {
        schemas.add(fileset);
    }
}
