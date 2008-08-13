/*
 * Cartevaloise
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by
 *        Bruno Perrin, Philippe Usclade and René le Clercq
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.wizard.process;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ForwardConfig;
import org.apache.struts.config.ModuleConfig;
import org.apache.velocity.Template;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlValidationError;

import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.VelocityUtils;
import fr.cg95.cvq.wizard.process.xmlbean.CvqprocessDocument;
import fr.cg95.cvq.wizard.process.xmlbean.GlobalsDefinitionType;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessDefinitionType;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;
import fr.cg95.cvq.wizard.process.xmlbean.ScriptType;
import fr.cg95.cvq.wizard.process.xmlbean.StageDefType;
import fr.cg95.cvq.wizard.process.xmlbean.TimeoutType;
import fr.cg95.cvq.wizard.process.xmlbean.CvqprocessDocument.Cvqprocess;

/**
 * @author René le CLERCQ
 */
public class ProcessWizardPlugin implements PlugIn {

	private static final int STATE_COLOR_GRAYINDEX = 192;

	/** Commons Logging instance. */
	protected static Logger log = Logger.getLogger(ProcessWizardPlugin.class.getName());

    Template processTemplate = null;
    Template tagTemplate = null;

	private ActionServlet servlet = null;

	private ModuleConfig config = null;

    private HashMap<String, ProcessWizard> wizards = new HashMap<String, ProcessWizard>();
    private HashMap<String, ProcessWizardGroup> groups = new HashMap<String, ProcessWizardGroup>();

    private String files = null;
    private String directory = null;
    private String template = null;
    private String tags = null;

	private GlobalsDefinitionType globals = null;

	private static ProcessWizardPlugin plugin = null;

	public ProcessWizardPlugin() {
		super();

		if (plugin == null)
			plugin = this;
	}

	public static ProcessWizardPlugin plugin() {
		return plugin;
	}

	public void destroy() {
	}

    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		this.servlet = servlet;
		this.config = config;

		if (files != null) {
			StringTokenizer xmlFiles = new StringTokenizer(files, ";");
			while (xmlFiles.hasMoreTokens())
				xmlbUnmarshalling(xmlFiles.nextToken());
        }
        if (directory != null) {
            File dir = new File(servlet.getServletContext().getRealPath(directory));
            if (dir.exists()) {
                File[] xmlFile = dir.listFiles(new XmlFilenameFilter());
                for (int i = 0; i < xmlFile.length; i++)
                    xmlbUnmarshalling(directory + File.separator + xmlFile[i].getName());
            }
        }
        
        if (wizards.isEmpty())
			log.severe("Capdemat - ProcessWizard no process definition file defined.");

		// Initialise the Velocity environment
        processTemplate = VelocityUtils.loadTemplate(getTemplate());
        tagTemplate = VelocityUtils.loadTemplate(getTags());

		if (config != null) {
			// Create an automatic action mapping
			ActionMapping action = new ActionMapping();
			action.setPath("/processWizard");
			action.setType("fr.cg95.cvq.wizard.process.ProcessWizardAction");
			action.setScope("request");

			config.addActionConfig(action);

			action = new ActionMapping();
			action.setPath("/processStage");
			action.setType("fr.cg95.cvq.wizard.process.ProcessStageAction");
			action.setScope("request");

			config.addActionConfig(action);

			action = new ActionMapping();
			action.setPath("/processSelect");
			action.setType("fr.cg95.cvq.wizard.process.ProcessSelectAction");
			action.setScope("request");

			config.addActionConfig(action);

			ForwardConfig forward = new ForwardConfig();
			forward.setName("doWizardStep");
			forward.setPath("/processWizard.do");

			config.addForwardConfig(forward);
		}
	}
    
    public IProcessWizard getProcess(String name) {
        if (name == null)
            return null;

        return wizards.get(name);
    }
    
    public Collection getProcesses() {
        return wizards.values();
    }
    
    private void xmlbUnmarshalling(String xmlFileName) {
		if (servlet != null)
			xmlFileName = servlet.getServletContext().getRealPath(xmlFileName);

		try {
            File xmlFile = new File(xmlFileName);
			CvqprocessDocument document = CvqprocessDocument.Factory.parse(xmlFile);

			ArrayList errors = new ArrayList();
			XmlOptions xmlOptions = new XmlOptions();
			xmlOptions.setErrorListener(errors);
			if (!document.validate(xmlOptions)) {
				for (int i = 0; i < errors.size(); i++) {
					XmlValidationError error = (XmlValidationError) errors.get(i);
					log.severe(error.getMessage() + "(line " + error.getLine() + ", column "
							+ error.getColumn() + ")");
				}
                new XmlException("Validation error(s) in file: " + xmlFileName).printStackTrace();

            } else {
                log.info("Capdemat - ProcessWizard Processing definition file: " + xmlFileName);

				Cvqprocess xmlCvq = document.getCvqprocess();

				if (xmlCvq.isSetGlobals()) {
					if (globals == null)
						globals = xmlCvq.getGlobals();
					else {
                        globals.setTimeoutArray((TimeoutType[]) ArrayUtils.addAll(globals
                                .getTimeoutArray(), xmlCvq.getGlobals().getTimeoutArray()));
                        globals.setScriptArray((ScriptType[]) ArrayUtils.addAll(globals
                                .getScriptArray(), xmlCvq.getGlobals().getScriptArray()));
						globals.setStagedefArray((StageDefType[]) ArrayUtils.addAll(globals
								.getStagedefArray(), xmlCvq.getGlobals().getStagedefArray()));
						globals.setStyleArray((String[]) ArrayUtils.addAll(globals.getStyleArray(),
								xmlCvq.getGlobals().getStyleArray()));
					}
				}
				if (xmlCvq.isSetProcesses()) {
				    ProcessDefinitionType processes = xmlCvq.getProcesses();
                    if (!processes.isSetGroup())
                        processes.setGroup(getNameWithoutExtension(xmlFile));
                        
                    List<ProcessType> processGroup = getProcessGroup(processes);
                    Iterator iter = Arrays.asList(processes.getProcessArray()).iterator();
					while (iter.hasNext()) {
						ProcessType process = (ProcessType) iter.next();
						processGroup.add(process);
						wizards.put(process.getName(), new ProcessWizard(process));
					}
				}
			}
		} catch (XmlException xmle) {
		    if ((xmle.getCause() != null))
		        xmle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

    private List<ProcessType> getProcessGroup(ProcessDefinitionType xmlGroup) {
        ProcessWizardGroup group = groups.get(xmlGroup.getGroup());
        if (group == null) {
            group = new ProcessWizardGroup(xmlGroup);
            groups.put(group.getName(), group);
        }

        return group.getProcesses();
    }
    
    private String getNameWithoutExtension(File f) {
        String s = f.getName();
        String name = s;
        int i = s.lastIndexOf('.');
     
        if (i > 0 &&  i < s.length() - 1) {
            name = s.substring(0, i);
        }
     
        return name;
    }

	public String getFiles() {
		return files;
	}

	public void setFiles(String proces_definition) {
		this.files = proces_definition;
	}

	public GlobalsDefinitionType getGlobals() {
		return globals;
	}

    public HashMap<String, ProcessWizardGroup> getProcessGroups() {
        return groups;
    }
    
	private static Object[] current = null;

//	private static HashMap<Object, Object> findMap = null;

	public static Object find(Object[] list, String property, String value) {

	  HashMap<Object, Object> findMap = null;
//		if (list != current) {
			current = list;
			if (findMap == null)
				findMap = new HashMap<Object, Object>();
			else
				findMap.clear();

			for (int i = 0; i < list.length; i++)
				findMap.put(callGetMethod(list[i], property), list[i]);
//		}
		return findMap.get(value);
	}

	public static int findIndex(Object[] list, String property, Object value) {

		for (int i = 0; i < list.length; i++) {
            Object data = callGetMethod(list[i], property);
			if ((data != null) && data.equals(value))
				return i;
        }
		return -1;
	}

	public static Object callGetMethod(Object object, String method) {
		try {
			return PropertyUtils.getProperty(object, method);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

    public static String getParameter(ServletRequest request, String key) {
        String param = null;
        Object value = request.getAttribute(key);
        if (value != null) {
            if (value instanceof String)
                param = (String) value;

            if (value instanceof String[])
                param = ((String[]) value)[0];
        }
        if ((param == null) || (param.length() == 0)) {
            param = request.getParameter(key);
        }
        return param;
    }

//    public static String getParameter(ServletRequest request, String key) {
//        String param = request.getParameter(key);
//        if ((param == null) || (param.length() == 0)) {
//            Object value = request.getAttribute(key);
//            if (value instanceof String)
//                param = (String) value;
//
//            if (value instanceof String[])
//                param = ((String[]) value)[0];
//        }
//        return param;
//    }

	/**
	 */
	public ModuleConfig getConfig() {
		return config;
	}

	public static String getHelp(String site) {
		String help = "http://aidecartevaloise.valdoise.fr";

		return help;
	}

	private static String disableColor(String baseColor) {
		int red = Integer.parseInt(baseColor.substring(1, 3), 16);
		int green = Integer.parseInt(baseColor.substring(3, 5), 16);
		int blue = Integer.parseInt(baseColor.substring(5, 7), 16);

		red = red + (STATE_COLOR_GRAYINDEX - red) / 2;
		green = green + (STATE_COLOR_GRAYINDEX - green) / 2;
		blue = blue + (STATE_COLOR_GRAYINDEX - blue) / 2;

		String result = "#" + Integer.toHexString(red) + Integer.toHexString(green)
				+ Integer.toHexString(blue);
		return result;
	}

    public Template getProcessTemplate() {
        return processTemplate;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public Template getTagTemplate() {
        return tagTemplate;
    }

    public String getTemplate() {
        if ((template == null) || (template.length() == 0))
            return "/META-INF/process.vm";
        
        return "/META-INF/" + template + ".vm";
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTags() {
        if ((tags == null) || (tags.length() == 0))
            return "/META-INF/tags.vm";
        
        return "/META-INF/" + tags + ".vm";
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    
}

class XmlFilenameFilter implements FilenameFilter {

    public boolean accept(File dir, String name) {
        return (name.toLowerCase().endsWith(".xml"));
    }
    
}