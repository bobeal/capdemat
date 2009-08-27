package fr.cg95.cvq.generator.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.FileScanner;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.Path;

import fr.cg95.cvq.generator.CodeGenerator;
import fr.cg95.cvq.generator.PluginInstanciationException;

public class GeneratorTask extends MatchingTask {

    private ArrayList<FileSet> schemas = new ArrayList<FileSet>();

    private Path plugins;

    @Override
    public void execute()
        throws BuildException {
        // check we have at least one schema to parse
        if (schemas.size() == 0 && fileset.getDir(getProject()) == null) {
            String msg = "A nested fileset is required.";
            throw new BuildException(msg);
        }
        if (fileset.getDir(getProject()) != null)
            schemas.add(fileset);
        CodeGenerator codeGenerator = new CodeGenerator();
        // register plugins
        for (String pathElement : plugins.list()) {
            if (pathElement.endsWith("_plugin.xml")) {
                try {
                    codeGenerator.registerPlugin(new File(pathElement));
                } catch (PluginInstanciationException pie) {
                    throw new BuildException("Error while loading plugin " + pathElement + "(" + pie.getMessage() + ")");
                } catch (IOException xe) {
                    throw new BuildException("IO Exception while parsing plugin definition from " + pathElement);
                }
            }
        }
        // invoke schemas parsing
        for (FileSet fs : schemas) {
            FileScanner scanner = fs.getDirectoryScanner(getProject());
            File basedir = scanner.getBasedir();
            for (String path : scanner.getIncludedFiles()) {
                codeGenerator.parseXsdFile(new File(basedir, path));
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

    public void addFileset(FileSet fileset) {
        schemas.add(fileset);
    }
}
