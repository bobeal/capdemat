package fr.cg95.cvq.generator.plugins.tool;

import groovy.text.SimpleTemplateEngine;
import groovy.text.TemplateEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class GroovyManager {

    //private static Logger logger = Logger.getLogger(GroovyManager.class);

    private static TemplateEngine templateEngine = new SimpleTemplateEngine();
    private static final String TEMPLATE_DIR =
        "Generator/src/java/fr/cg95/cvq/generator/plugins/model/templates/";

    public static void generate(File file, String templateFile,
        Map<String, ? extends Object> model) {
        try {
            FileWriter result = new FileWriter(file);
            result.write(generate(templateFile, model));
            result.flush();
        } catch (IOException e) {
            System.out.println("Got exception while generating " + file
                + " with template " + templateFile);
            System.out.println(e);
        }
    }

    public static void generate(String fileName, String templateFile,
        Map<String, ? extends Object> model) {
        generate(new File(fileName), templateFile, model);
    }

    public static String generate(String templateFile, Map<String, ? extends Object> model) {
        StringWriter result = new StringWriter();
        try {
            templateEngine.createTemplate(new File(TEMPLATE_DIR + templateFile))
                .make(model).writeTo(result);
        } catch (Exception e) {
            System.out.println("Got exception with template " + templateFile);
            System.out.println(e);
        }
        return result.toString();
    }
}
