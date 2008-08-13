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
package fr.cg95.cvq.generator.plugins.gui;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;

/**
 * @author René le CLERCQ
 */
public class GuiPlugin implements IPluginGenerator {

	private static final String CFG_PLUGIN = "plugin";

	private static final String CFG_PLUGIN_GUI = "gui";

	private static final String CFG_OUTPUT = "output";

	private static final String CFG_OUTPUT_PATH = "path";

	private static final String CFG_OUTPUT_LANG = "lang";

	private static final String CFG_JAVA = "java";

	private static final String CFG_JAVA_VTL = "vtl";

	private static final String CFG_JAVA_SRC = "src";

	private static final String CFG_JAVA_PACKAGE = "package";

	private static final String CFG_JAVA_FORM = "form";

	private static final String CFG_JAVA_POSTFIX = "postfix";

	private static final String CFG_JSP = "jsp";

	private static final String CFG_JSP_VTL = "vtl";

	private static final String CFG_JSP_SRC = "src";

	private static final String CFG_JSP_BEAN = "bean";

	private static final String CFG_JSP_PREFIX = "prefix";

	private static Logger logger = Logger.getLogger(GuiPlugin.class);

	private HashMap displayStages = null;

	private String requestName = null;

	private ParseElement current = null;

	private String gui = null;

	private String outputPath = null;

	private String lang = null;

	private String javaVtl = null;

	private String javaSrc = null;

	private String javaPackage = null;

	private String javaForm = null;

	private String javaPostfix = null;

	private String jspVtl = null;

	private String jspSrc = null;

	private String jspBean = null;

	private String jspPrefix = null;

	private String namespace = null;

	private String modelNamespace = null;

	public GuiPlugin() {
		super();
	}

	public void initialize(Node configurationNode) {
		if (configurationNode != null) {
			Node node = configurationNode.getFirstChild();
			while (node != null) {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element elementNode = (Element) node;
					if (node.getNodeName().equals(CFG_PLUGIN)) {
						gui = elementNode.getAttribute(CFG_PLUGIN_GUI);
					} else if (node.getNodeName().equals(CFG_OUTPUT)) {
						outputPath = elementNode.getAttribute(CFG_OUTPUT_PATH);
						lang = elementNode.getAttribute(CFG_OUTPUT_LANG);
					} else if (node.getNodeName().equals(CFG_JAVA)) {
						javaVtl = elementNode.getAttribute(CFG_JAVA_VTL);
						javaSrc = elementNode.getAttribute(CFG_JAVA_SRC);
						javaPackage = elementNode.getAttribute(CFG_JAVA_PACKAGE);
						javaForm = elementNode.getAttribute(CFG_JAVA_FORM);
						javaPostfix = elementNode.getAttribute(CFG_JAVA_POSTFIX);
					} else if (node.getNodeName().equals(CFG_JSP)) {
						jspVtl = elementNode.getAttribute(CFG_JSP_VTL);
						jspSrc = elementNode.getAttribute(CFG_JSP_SRC);
						jspBean = elementNode.getAttribute(CFG_JSP_BEAN);
						jspPrefix = elementNode.getAttribute(CFG_JSP_PREFIX);
					}
				}
				node = node.getNextSibling();
			}
		}
	}

	public void shutdown() {
		logger.debug("shutdown()");
	}

	public void startRequest(String requestName, String targetNamespace) {
        System.out.println("****** Generating code for  " + requestName + " (" + gui + ") ******");

		displayStages = null;
		this.requestName = requestName;
		current = new ParseElement(requestName, current);
	}

	public void endRequest(String requestName) {

		checkDisplayElements(current.getAppinfo());
		
		if (displayStages != null) {
			launchVelocity(javaVtl, jspVtl);
		}
		current = null;
	}

	public void startElement(String elementName, String type) {
		ParseElement child = new ParseElement(elementName, current);
		current.addChild(child);

		current = child;
	}

	public void endElement(String elementName) {
		checkDisplayElements(current.getAppinfo());
		current = current.getParent();
	}

	public void startElementProperties(ElementProperties elementProperties) {
		current.setProperties(elementProperties);
	}

	public void endElementProperties() {

	}

	public void onUserInformation(UserDocumentation userDocumentation) {
		if (userDocumentation.getLang().equalsIgnoreCase(lang)) {
			if (userDocumentation.getSourceUri().equalsIgnoreCase(SHORT_DESC)) {
			    if ((current.getLabel() == null) || (current.getLabel().length() == 0))
			        current.setLabel(userDocumentation.getText());

            } else if (userDocumentation.getSourceUri().equalsIgnoreCase(ENUM_TRANS))
				current.setTranslation(userDocumentation.getXmlTranslationNodes());
		}
	}

	public void onApplicationInformation(ApplicationDocumentation applicationDocumentationList) {
		current.setAppinfo(applicationDocumentationList);
		if (current.getParent() == null)
			checkGlobalRequestElements(applicationDocumentationList);
	}

	protected void checkGlobalRequestElements(ApplicationDocumentation appInfo) {
		if (appInfo != null) {
			Node node = appInfo.getXmlNode();
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementNode = (Element) node;
				if (node.getNodeName().equals(gui))
					namespace = elementNode.getAttribute(DisplayElement.GUI_NAMESPACE);
				if (node.getNodeName().equals(DisplayElement.GUI_MODEL))
					modelNamespace = elementNode.getAttribute(DisplayElement.GUI_MODEL_NAMESPACE);
			}
		}
	}

	private void checkDisplayElements(ApplicationDocumentation appInfo) {
		if (appInfo != null) {
			String repository = null;
			Node node = appInfo.getXmlNode();
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elementNode = (Element) node;
				repository = elementNode.getAttribute(DisplayElement.GUI_REPOSITORY);
			}
			node = node.getFirstChild();
			while (node != null) {
				DisplayElement displayElement = parseNode(null, node, repository); 
				if (displayElement != null) {
				    DisplayElement existingElement = getExistingElement(displayElement); 
                    if (existingElement == null) {
                        addDisplayElement(displayElement, false);
                        addChildNodes(displayElement, node.getFirstChild());
                    } else {
                        addChildNodes(existingElement, node.getFirstChild());
                    }
				}
				node = node.getNextSibling();
			}
		}
	}

	private DisplayElement parseNode(DisplayElement parent, Node node, String repository) {
		if ((node.getNodeType() == Node.ELEMENT_NODE) && node.getNodeName().equals(DisplayElement.GUI_DISPLAY)) {
			DisplayElement displayElement = new DisplayElement(parent);
			displayElement.setRepository(repository);

			Element elementNode = (Element) node;

            repository = elementNode.getAttribute(DisplayElement.GUI_REPOSITORY);
            if (repository.length() > 0)
                displayElement.setRepository(repository);
                
//            if (elementNode.hasAttribute(DisplayElement.GUI_DISPLAY_FIELD))
                displayElement.setField(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_FIELD));
            
			displayElement.setType(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_TYPE));
			displayElement.setStage(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_STAGE));
			displayElement.setPage(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_PAGE));
			displayElement.setPageno(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_PAGENO));
			displayElement.setLine(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_LINE));
			displayElement.setLabel(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_LABEL));
            displayElement.setHelp(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_HELP));
            displayElement.setInfo(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_INFO));
            if (elementNode.hasAttribute(DisplayElement.GUI_DISPLAY_MSG))
                displayElement.setMessage(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_MSG));
            displayElement.setSeperator(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_SEPERATOR));
			displayElement.setMode(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_MODE));
            displayElement.setCondition(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_CONDITION));
            displayElement.setBlock(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_BLOCK));
            displayElement.setClazz(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_CLASS));
            displayElement.setMethod(elementNode.getAttribute(DisplayElement.GUI_DISPLAY_METHOD));

            if (!displayElement.getType().equals("javaOnly"))
			    displayElement.setGuiControl(displayElement.getType());

			if (!findDisplayElement("", current, displayElement)) {
				logger.error("Display field <" + displayElement.getField()
						+ "> not found in XSD type definition <" + current.getName() + ">.");
				return null;
			}
			return displayElement;
		}
		return null;
	}

	private void addChildNodes(DisplayElement parent, Node node) {
		while (node != null) {
			DisplayElement displayElement = parseNode(parent, node, ""); 
            if (displayElement != null) {
                DisplayElement existingElement = getExistingElement(displayElement);
                if ( existingElement == null) {
    			    if (parent.getType().equals("list")) {
                        parent.setJavaType("List");
                        displayElement.setClassName(parent.javaName("method") + javaPostfix);
                        addDisplayElement(displayElement, true);
                    } else if (parent.isMultiColumn()) {
                        if ((parent.getCondition() != null) && (parent.getCondition().length() > 0))
                            displayElement.setCondition(parent.getCondition());
                        displayElement.setStage(parent.getStage());
                        addDisplayElement(displayElement, true);
                    }
                    parent.addChild(displayElement);
                } else {
                    if (parent.isMultiColumn() && 
                            (parent.getCondition() != null) && (parent.getCondition().length() > 0))
                        existingElement.setCondition(parent.getCondition());
                }
                addChildNodes(displayElement, node.getFirstChild());
			}
			node = node.getNextSibling();
		}
	}
			
	private void addDisplayElement(DisplayElement displayElement, boolean javaOnly) {
		if (displayStages == null)
			displayStages = new HashMap();
        
		DisplayStage stage = (DisplayStage) displayStages.get(displayElement.getStage());
		if (stage == null) {
			stage = new DisplayStage(displayElement.getStage());
			displayStages.put(stage.getName(), stage);
		}
		boolean defaultClassName = true;
        String className = stage.javaName(requestName + javaPostfix);
        if ((displayElement.getParent() != null) && (displayElement.getParent().getClazz() != null) && (displayElement.getParent().getClazz().length() > 0)) {
            className = displayElement.getParent().getClazz();
            StringTokenizer tokens = new StringTokenizer(displayElement.getField(), ".");
            if (tokens.hasMoreTokens())
                displayElement.setRoot(tokens.nextToken());
            
            defaultClassName = false;
        }
        displayElement.setClassName(className);
        
		if (javaOnly || displayElement.getType().equals("javaOnly"))
			stage.addJavaDisplayElement(displayElement, defaultClassName);
		else
			stage.addDisplayElement(displayElement);
	}
	
    private DisplayElement getExistingElement(DisplayElement displayElement) {
        if (displayStages == null)
            return null;
        
        DisplayStage stage = (DisplayStage) displayStages.get(displayElement.getStage());
        if (stage == null)
            return null;
        
        
        return stage.findDisplayElement(displayElement);
    }
    
	private boolean findDisplayElement(String fullName, ParseElement parseElement,
			DisplayElement displayElement) {

        String field = displayElement.getField();
        if (field == null)
            return true;

        if (field.equalsIgnoreCase(fullName)) {
            
            fillDisplayElement(parseElement, displayElement);

//			if (displayElement.getGuiControl().equals("checklist") && !displayElement.isRepository()) {
//				addChildElements(displayElement, parseElement.getChildren(), "checkbox", false);
//				displayElement.setMode("static");
//			} else if (displayElement.getGuiControl().equals("yesnolist")) {
//				if (addChildElements(displayElement, parseElement.getChildren(), "yesno", false)) {
//					displayElement.setMode("static");
//					displayElement.setGuiControl(null);
//				}
//			} else if (displayElement.getGuiControl().equals("ArrayStorage")) {
//				addChildElements(displayElement, parseElement.getChildren(), "text", true);
//			}
			return true;
		}
		Vector children = parseElement.getChildren();
		if (children != null) {
			if (fullName.length() != 0)
				fullName += ".";

			Iterator iter = children.iterator();
			while (iter.hasNext()) {
				ParseElement child = (ParseElement) iter.next();

				if (findDisplayElement(fullName + child.getName(), child, displayElement)) {
					return true;
				}
			}
		}
		return false;
	}

	private void fillDisplayElement(ParseElement parseElement, DisplayElement displayElement) {
		ElementProperties properties = parseElement.getProperties();

		displayElement.setName(parseElement.getName());

		String property = parseElement.getProperty();
        ParseElement parent = parseElement.getParent();
        while ((parent != null) && (parent.getParent() != null)) {
            property = parent.getProperty() + "." + property;
            parent = parent.getParent();
        }
        displayElement.setProperty(property);
        if ((this.current.getParent() != null) && ((this.current.getParent().getParent() != null)))
            displayElement.setRoot(this.current.getProperty());
        else
            displayElement.setRoot("");

        displayElement.setLength(1);
        
        if ((displayElement.getLabel() == null) || (displayElement.getLabel().length() == 0))
            displayElement.setLabel(parseElement.getLabel());

        if (properties != null) {
            displayElement.setSubjectType(getSubjectType(parseElement));
            
            if ((displayElement.getXsdType() == null) || (displayElement.getXsdType().length() == 0))
    			displayElement.setXsdType(properties.getXmlBeanType());
            
            displayElement.setSchemaType(properties.getXmlSchemaType());
            displayElement.setJavaType(properties.getJavaType());
    
    		if (properties.isListType()) {
    			displayElement.setXsdType("ArrayStorage");
    			displayElement.setLength(properties.getListLength());
    		}
            
            if ((properties.getMaxOccurs() == null) || (properties.getMaxOccurs().longValue() > 1)) {
                displayElement.setXsdType("ArrayStorage");
                if (properties.getMaxOccurs() == null)
                    displayElement.setLength(Integer.MAX_VALUE);
                else
                    displayElement.setLength(properties.getMaxOccurs().intValue());
            }
    
    		String patterns[] = properties.getPatterns();
    		if ((patterns != null) && (patterns.length > 0))
    			displayElement.setMask(patterns[0]);
    
    		String values[] = properties.getEnumValues();
    		if ((values != null) && (values.length > 0)) {
    			displayElement.setValues(values);
    			displayElement.setTranslations(parseElement.getTranslation());
    
    			if (!properties.isSimpleType())
    				displayElement.setEnumType("RequestType." + displayElement.getProperty());
    			else if (properties.getXmlSchemaType() != null)
    				displayElement.setEnumType(properties.getXmlSchemaType());
                else {
                    displayElement.setEnumType(
                            parseElement.getParent().getProperties().getXmlSchemaType() + "." + parseElement.getName());
                }
    			
    			if (parseElement.getParent().getProperties() != null)
    			    displayElement.setXmlParentClass(parseElement.getParent().getProperties().getXmlSchemaType());
    			
                if ((displayElement.getGuiControl() == null) || (displayElement.getGuiControl().length() == 0))
                    displayElement.setGuiControl("select");
    		}
    		if (!displayElement.getType().equals("javaOnly"))
    		    treatGuiControl(displayElement, properties.isSimpleType());
    
            if (properties.getLength() > 0) {
                displayElement.setMinLength(properties.getLength());
                displayElement.setMaxLength(properties.getLength());
            } else {
                displayElement.setMinLength(properties.getMinLength());
                displayElement.setMaxLength(properties.getMaxLength());
            }
        }
		// int rows = (properties.getMaxOccurs() == null) ? Integer.MAX_VALUE :
		// properties.getMaxOccurs().intValue();
		// displayElement.setArray(rows > 1);
		// if (displayElement.isArray()) {
		// displayElement.setRows(rows);
		// }
		if (displayElement.isRepository()) {
            displayElement.setRows(-1);
			if (!displayElement.isMultipleSelect() && 
                    (displayElement.getGuiControl() != null 
                            && !displayElement.getGuiControl().equals("selectAuthorityReferential")))
				displayElement.setGuiControl("select");
		}

        if ((displayElement.getGuiControl() == null) || !displayElement.getGuiControl().equals("yesnolist")) {
            if ((displayElement.getMode() != null) && displayElement.getMode().equals("required"))
                displayElement.setRequired(true);
            else if ((displayElement.getMode() != null) && displayElement.getMode().equals("inline,required")) {
                displayElement.setMode("inline");
                displayElement.setRequired(true);
            }
            else if ((displayElement.getMode() != null) && displayElement.getMode().equals("notrequired"))
                displayElement.setRequired(false);
            else if ((displayElement.getMode() != null) && displayElement.getMode().equals("blockrequired"))
                displayElement.setRequired(displayElement.isMultipleSelect());
            else if ((displayElement.getMode() != null) && displayElement.getMode().equals("labelonly")) {
                displayElement.setRequired(false);
                displayElement.setSchemaType("");
                displayElement.setJavaType(null);
            } else if (properties != null)
                displayElement.setRequired(properties.getMinOccurs().intValue() != 0);
        }
	}

    private String getSubjectType(ParseElement parseElement) {
        ParseElement parent = parseElement.getParent();
        ParseElement child = parseElement;
        while ((parent != null) && (parent.getParent() != null)) {
            child = parent;
            parent = parent.getParent();
            if ((parent.getProperties() != null) && (parent.getProperties().getXmlSchemaType().equals("SubjectType")))
                return child.getName();
        }
        return null;
    }
    
	private void treatGuiControl(DisplayElement displayElement, boolean simpleType) {
		String guiControl = displayElement.getGuiControl();

        if (simpleType && ((guiControl == null) || (guiControl.length() == 0))) {
			displayElement.setGuiControl("text");

		} else if (guiControl.startsWith("list(")){
			displayElement.setGuiControl("objectlist");
        } else if (guiControl.startsWith("radiolist[")){
            int pos = guiControl.indexOf("[");
            if (pos > 0) {
                String radioValues = guiControl.substring(pos + 1, guiControl.indexOf(']'));
                displayElement.setGuiControl(guiControl.substring(0, pos));
                String values[] = displayElement.getValues();
                ArrayList newValues = new ArrayList();
                for (int i = 0; i < values.length; i++) {
                    if (radioValues.indexOf(values[i]) != -1)
                        newValues.add(values[i]);
                }
                displayElement.setValues((String[])newValues.toArray(new String[newValues.size()]));
            }
		} else {
			int pos = guiControl.indexOf("[");
			if (pos > 0) {
				int rows = Integer.parseInt(guiControl.substring(pos + 1, guiControl.indexOf(']')));
				displayElement.setGuiControl(guiControl.substring(0, pos));
				displayElement.setRows(rows);
			}
			pos = guiControl.indexOf("(");
			if (pos > 0) {
				displayElement.setGuiControl(guiControl.substring(0, pos));
			}
		}
	}

    public String loadFormRequestField(DisplayElement field) {
        try {
            Class clazz = Class.forName("fr.cg95.cvq.xml." + modelNamespace + "." + requestName + "Document$" + requestName);
            Class[] parameterTypes = null;
            Method method = clazz.getMethod(field.javaName("get"), parameterTypes);

            Class returnType = method.getReturnType();
            if (returnType.getName().equals("[Lfr.cg95.cvq.xml.common.LocalReferentialDataType;"))
                return "request." + field.javaName("get") + "()";
            
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
        }
        return "null";
    }
    
    public String saveFormRequestField(DisplayElement field) {
        try {
            Class clazz = Class.forName("fr.cg95.cvq.xml." + modelNamespace + "." + requestName + "Document$" + requestName);
            Class[] parameterTypes = new Class[1];
            parameterTypes[0] = LocalReferentialDataType[].class; 
            
            Method method = clazz.getMethod(field.javaName("set"), parameterTypes);

            return "request." + field.javaName("set");
            
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e) {
        }
        return null;
    }
    
	private void launchVelocity(String javaTemplateFile, String jspTemplateFile) {
		try {
            VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
					"org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
			ve.setProperty("runtime.log.logsystem.log4j.category", "stdout");
            ve.setProperty("velocimacro.library","");
			ve.init();
			VelocityContext context = new VelocityContext();

			// Load the template file
			Template javaTemplate = null;
			Template jspTemplate = null;

			try {
				javaTemplate = ve.getTemplate(javaTemplateFile, "UTF-8");
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Generator : error : cannot find template " + javaTemplateFile);
			} catch (ParseErrorException pee) {
				System.out.println("Generator : Syntax error in template " + javaTemplateFile + ":" + pee);
			}

			try {
				jspTemplate = ve.getTemplate(jspTemplateFile, "UTF-8");
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Generator : error : cannot find template " + jspTemplateFile);
			} catch (ParseErrorException pee) {
				System.out.println("Generator : Syntax error in template " + jspTemplateFile + ":" + pee);
			}

			File outputDir = new File(outputPath);

			String packageName = javaPackage +  "." + namespace;
			if ((javaForm != null) && (javaForm.length() > 0))
				packageName += "." + javaForm;

			File packageDir = new File(outputDir, javaSrc + File.separator
					+ packageName.replaceAll("\\.", "/"));
			packageDir.mkdirs();

			File jspDir = new File(outputDir, jspSrc + File.separator + namespace.replaceAll("\\.","/"));
			jspDir.mkdirs();

			Iterator stages = displayStages.values().iterator();
			while (stages.hasNext()) {
				DisplayStage displayStage = (DisplayStage) stages.next();

				if (javaTemplate != null) {
				    Iterator classes = displayStage.getJavaClasses().values().iterator();
                    while (classes.hasNext()) {
                        JavaClass clazz = (JavaClass)classes.next();
                        
                        File javaFile = new File(packageDir, clazz.getName() + ".java");
    
    					logger.info("Generating java class: " + javaFile.getPath());
                        
                        context.put("plugin", this);
                        context.put("request", requestName);
                        context.put("stage", displayStage);
                        context.put("clazz", clazz);
    					context.put("package", packageName);
    					context.put("namespace", modelNamespace);
    
    					FileWriter javaWriter = new FileWriter(javaFile);
    					javaTemplate.setEncoding("UTF-8");
    					javaTemplate.merge(context, javaWriter);
    
    					javaWriter.flush();
    					javaWriter.close();
                    }
				}

				if (jspTemplate != null) {
					File stageDir = new File(jspDir, displayStage.getName());

					HashMap displayPages = displayStage.getDisplayPages();

					DisplayPage allPages = (DisplayPage) displayPages.get(DisplayPage.ALL_PAGES);
					Iterator pages = displayPages.values().iterator();
					while (pages.hasNext()) {
						DisplayPage displayPage = (DisplayPage) pages.next();
						if (displayPage != allPages) {

							ArrayList displayElements = displayPage.getDisplayElements();
							if (allPages != null)
								displayElements.addAll(0, allPages.getDisplayElements());

							File jspPage = new File(stageDir, displayPage.getName() + ".jsp");

							logger.info("Generating jsp page: " + jspPage.getPath());

							jspPage.getParentFile().mkdirs();

							context.put("bean", jspBean);
							context.put("prefix", jspPrefix);
							context.put("page", displayPage);
							context.put("fields", displayElements);

							FileWriter jspWriter = new FileWriter(jspPage);
							jspTemplate.setEncoding("UTF-8");
							jspTemplate.merge(context, jspWriter);

							jspWriter.flush();
							jspWriter.close();
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
