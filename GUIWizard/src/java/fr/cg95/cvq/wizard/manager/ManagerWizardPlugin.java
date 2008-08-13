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
package fr.cg95.cvq.wizard.manager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
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

import fr.cg95.cvq.wizard.VelocityUtils;
import fr.cg95.cvq.wizard.manager.xmlbean.CvqmanagerDocument;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerGlobalsType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerMenuType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerMenusType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerProcessesType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerScriptType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerTabType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerTimeoutType;
import fr.cg95.cvq.wizard.manager.xmlbean.ManagerType;
import fr.cg95.cvq.wizard.manager.xmlbean.CvqmanagerDocument.Cvqmanager;

/**
 * @author René le CLERCQ
 */
public class ManagerWizardPlugin implements PlugIn {

	/** Commons Logging instance. */
	protected static Logger log = Logger.getLogger(ManagerWizardPlugin.class.getName());

	private ActionServlet servlet = null;

	private ModuleConfig config = null;

	Template managerTemplate = null;
    Template tagTemplate = null;

	private HashMap<String, ManagerWizard> wizards = new HashMap<String, ManagerWizard>();

	private String files = null;
    private String directory = null;
    private String template = null;
    private String tags = null;

    private ManagerGlobalsType globals = null;
    private ManagerMenusType menus = null;
    private ManagerProcessesType processes = null;
    private HashMap<String, ManagerProcessGroup> groups = new HashMap<String, ManagerProcessGroup>();

	private static ManagerWizardPlugin plugin = null;

	public ManagerWizardPlugin() {
		super();

		if (plugin == null)
			plugin = this;
	}

	public static ManagerWizardPlugin plugin() {
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
            log.severe("Capdemat - ManagerWizard no process definition file defined.");
        
		// Initialise the Velocity environment
        managerTemplate = VelocityUtils.loadTemplate(getTemplate());
        tagTemplate = VelocityUtils.loadTemplate(getTags());

        if (config != null) {
		    String type = "fr.cg95.cvq.wizard.manager.ManagerWizardAction";
            if ((globals != null) && globals.isSetDefaultaction())
                type = globals.getDefaultaction().getType();
            
            // Create an automatic action mapping
			ActionMapping action = new ActionMapping();
			action.setPath("/managerWizard");
			action.setType(type);
			action.setScope("request");

			config.addActionConfig(action);

			ForwardConfig forward = new ForwardConfig();
			forward.setName("doManagerWizard");
			forward.setPath("/managerWizard.do");

			config.addForwardConfig(forward);
		}
	}

	public ManagerWizard getManager(String site, String name) {
		if ((site == null) || (name == null))
			return null;

		ManagerWizard wizard = wizards.get(name);

		return wizard;
	}

	private void xmlbUnmarshalling(String xmlFileName) {
		if (servlet != null)
			xmlFileName = servlet.getServletContext().getRealPath(xmlFileName);

		try {
            File xmlFile = new File(xmlFileName);
			CvqmanagerDocument document = CvqmanagerDocument.Factory.parse(xmlFile);

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
                log.info("Capdemat - ManagerWizard Processing definition file: " + xmlFileName);

                Cvqmanager xmlCvq = document.getCvqmanager();

                if (xmlCvq.isSetGlobals()) {
                    if (globals == null)
                        globals = xmlCvq.getGlobals();
                    else {
                        globals.setTimeoutArray((ManagerTimeoutType[]) ArrayUtils.addAll(globals
                                .getTimeoutArray(), xmlCvq.getGlobals().getTimeoutArray()));
                        globals.setScriptArray((ManagerScriptType[]) ArrayUtils.addAll(globals
                                .getScriptArray(), xmlCvq.getGlobals().getScriptArray()));
                        globals.setStyleArray((String[]) ArrayUtils.addAll(globals.getStyleArray(),
                                xmlCvq.getGlobals().getStyleArray()));
                    }
                }

                if (xmlCvq.isSetMenus()) {
                    if (menus == null)
                        menus = xmlCvq.getMenus();
                    else {
                        menus.setMenuArray((ManagerMenuType[]) ArrayUtils.addAll(menus
                                .getMenuArray(), xmlCvq.getMenus().getMenuArray()));
                    }
                }

                if (xmlCvq.isSetProcesses()) {
                    ManagerProcessesType xmlProcesses = xmlCvq.getProcesses();
                    if (!xmlProcesses.isSetGroup())
                        xmlProcesses.setGroup(getNameWithoutExtension(xmlFile));
                        
                    setProcessGroup(xmlProcesses);
                    
                    if (processes == null)
                        processes = xmlProcesses;
                    else {
                        processes.setProcessArray(
                            (ManagerProcessType[]) ArrayUtils.addAll(
                                    processes.getProcessArray(), xmlProcesses.getProcessArray()));
                    }
                }

                if (xmlCvq.isSetManagers()) {
                    Iterator iter = Arrays.asList(xmlCvq.getManagers().getManagerArray()).iterator();
                    while (iter.hasNext()) {
                        ManagerType manager = (ManagerType) iter.next();

                        wizards.put(manager.getName(), new ManagerWizard(manager));
                    }
                }
			}
		} catch (XmlException xmle) {
			xmle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

    private void setProcessGroup(ManagerProcessesType xmlGroup) {
        ManagerProcessGroup group = groups.get(xmlGroup.getGroup());
        if (group == null) {
            group = new ManagerProcessGroup(xmlGroup);
            groups.put(group.getName(), group);
        }
        
        group.addProcesses(xmlGroup.getProcessArray());
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

	public void setFiles(String manager_definition) {
		this.files = manager_definition;
	}

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public ManagerGlobalsType getGlobals() {
        return globals;
    }

    public ManagerMenusType getMenus() {
        return menus;
    }

    public ManagerProcessesType getProcesses() {
        return processes;
    }

    public HashMap<String, ManagerProcessGroup> getProcessGroups() {
        return groups;
    }
    
	private static List current = null;

	private static HashMap<Object, Object> findMap = null;

	public static Object find(Object[] array, String property, String value) {

        if (array != null) { 
    		List list = Arrays.asList(array);
    		if (list != current) {
    			current = list;
    			if (findMap == null)
    				findMap = new HashMap<Object, Object>();
    			else
    				findMap.clear();
    
    			Iterator iter = list.iterator();
    			while (iter.hasNext()) {
    				Object obj = iter.next();
    				if (obj instanceof String)
    					findMap.put(obj, obj);
    				else
    					findMap.put(callGetMethod(obj, property), obj);
    			}
    		}
    		return findMap.get(value);
        }
        return null;
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
		String param = request.getParameter(key);
		if ((param == null) || (param.length() == 0)) {
			Object value = request.getAttribute(key);
			if (value instanceof String)
				param = (String) value;

			if (value instanceof String[])
				param = ((String[]) value)[0];
		}
		return param;
	}

	static String getTabId(String name, int index) {
		ManagerWizard manager = plugin.wizards.get(name);
		if (manager != null) {
			ManagerType xmlbManager = manager.getXmlbManager();
			ManagerTabType xmlbTab = (ManagerTabType) xmlbManager.getTabArray(index);
			if (xmlbTab != null) {
				return xmlbTab.getId();
			}
		}
		return null;
	}

	public ModuleConfig getConfig() {
		return config;
	}

	public Template getManagerTemplate() {
		return managerTemplate;
	}

    public Template getTagTemplate() {
        return tagTemplate;
    }

    public String getTemplate() {
        if ((template == null) || (template.length() == 0))
            return "/META-INF/manager.vm";
        
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