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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * @author René le CLERCQ
 */
public class DisplayElement {
	public static final String GUI_FO = "fo";
	public static final String GUI_BO = "bo";
	public static final String GUI_NAMESPACE = "namespace";
	public static final String GUI_REPOSITORY = "repository";
	public static final String GUI_MODEL = "model";
	public static final String GUI_MODEL_NAMESPACE = "namespace";
	public static final String GUI_DISPLAY = "display";
	public static final String GUI_DISPLAY_FIELD = "field";
	public static final String GUI_DISPLAY_TYPE = "type";
	public static final String GUI_DISPLAY_STAGE = "stage";
	public static final String GUI_DISPLAY_PAGE = "page";
	public static final String GUI_DISPLAY_PAGENO = "pageno";
	public static final String GUI_DISPLAY_LINE = "line";
	public static final String GUI_DISPLAY_LABEL = "label";
    public static final String GUI_DISPLAY_HELP = "help";
    public static final String GUI_DISPLAY_INFO = "info";
    public static final String GUI_DISPLAY_MSG = "message";
    public static final String GUI_DISPLAY_SEPERATOR = "seperator";
    public static final String GUI_DISPLAY_CONDITION = "condition";
    public static final String GUI_DISPLAY_MODE = "mode";
    public static final String GUI_DISPLAY_BLOCK = "block";
    public static final String GUI_DISPLAY_CLASS = "class";
    public static final String GUI_DISPLAY_METHOD = "method";
	
    private DisplayElement parent = null;
    private Vector children = new Vector();
	
	String repository = null;
	
	String name = null;
	String field = null;
	String index = null;
	String stage = null;
	String page = null;
	String pageno = null;
	Integer line = null;
	String suffix = "";
	String block = "";
    
    String className = null;
    String clazz = null;
    String method = null;
    
    int length = 0;
    String root = null;
    String property = null;
	String type = null;
    String xsdType = null;
    String schemaType = null;
    String javaType = null;
	String format = null;
	boolean required = false;
	String mask = null;
    int maxLength = 0;
    int minLength = 0;
	int rows = 1;
	boolean array = false;
	String label = null;
    String help = null;
    String info = null;
    String message = null;
    String seperator = null;
    String condition = null;
	String mode = null;
	String values[] = null;
	HashMap translations = null;
	String enumType = null;
	String guiControl = null;
    String subjectType = null;
    String xmlParentClass = null;
	boolean lastItem = false;
	
    public DisplayElement(DisplayElement parent) {
		super();
        this.parent = parent;
	}

    public DisplayElement getParent() {
        return this.parent;
    }
   
	public Vector getChildren() {
        if (children != null)
            Collections.sort(children, new ElementsComparator());

		return children;
	}
	
	public void addChild(DisplayElement child) {
		children.add(child);
	}
	
    public boolean isMultiColumn() {
        return (type.length() > 0) && ("columns town".indexOf(type) != -1);
    }
    
    public String getSetCondition(String object) {
        return getSetCondition(object, false);
    }

    public String getSetCondition(String object, boolean useRoot) {
        String fullname = property;
        if (useRoot) {
            if ((method != null) && (method.length() > 0)) {
                fullname = property.replaceFirst(field, method);
            }
            useRoot = (this.root != null) && (this.root.length() != 0);
        }
        boolean usedRoot = !useRoot;

        StringTokenizer tokens = new StringTokenizer(fullname,".");
        int nbTokens = tokens.countTokens();
        if (nbTokens > 1) {
            String condition = "";
            String method = object;
            for (int i = 0; i < nbTokens-2; i++) {
                String token = tokens.nextToken();
                if (!usedRoot && token.equals(root))
                    usedRoot = true;
                
                if (usedRoot) {
                    method += ".get" + getPropertyMethod(token, "0");
                    condition += "(" + method + " != null) && ";
                }
            }
            String token = tokens.nextToken();
            if (!usedRoot && token.equals(root))
                usedRoot = true;

            if (!usedRoot)
                return null;

            method += ".get" + getPropertyMethod(token, "0");
            condition += "(" + method + " != null)";
            
            return condition;
        }
        if (baseTypes.indexOf(javaType) != -1) {
            return "(" + object + "." + javaName("get") + "() != null)";
        }
        return null;
    }
    
	public String javaName(String mode) {
        return rootJavaName(mode, false);
    }
    
    public String rootName(String mode) {
        return rootJavaName(mode, true);
    }
    
    private String rootJavaName(String mode, boolean useRoot) {

        if (isMultiColumn() && !children.isEmpty())
            return ((DisplayElement)children.get(0)).javaName(mode);
            
        if (field == null)
            return "";
        
        String fullname = property;
        if (useRoot) {
            if ((method != null) && (method.length() > 0)) {
                fullname = property.replaceFirst(field, method);
            }
            useRoot = (this.root != null) && (this.root.length() != 0);
        }
        if (mode.startsWith("get")) {
			StringTokenizer tokens = new StringTokenizer(fullname,".");
			int nbTokens = tokens.countTokens();
			if (mode.equals("get1"))
                nbTokens = 0;
            
            int skip = 0;
            if (mode.equals("get-2"))
                skip = 2;
            
            boolean usedRoot = !useRoot;
            String method = "";
			for (int i = 0; i < nbTokens-1; i++) {
                String token = tokens.nextToken();
                if (!usedRoot && token.equals(root))
                    usedRoot = true;
			    if ((i >= skip) && usedRoot)
			        method += "get" + getPropertyMethod(token, "0") + ".";
            }
			method += "get" + getPropertyMethod(tokens.nextToken(), null);
			
			// We are dealing with an enumeration
			if (mode.equals("get") && (values != null))
				method += "().toString";
			
			return method;
		}
		else if (mode.equals("set")) {
            boolean usedRoot = !useRoot;
			suffix = "";
			StringTokenizer tokens = new StringTokenizer(fullname,".");
			int nbTokens = tokens.countTokens();
			String method = "";
			for (int i = 0; i < nbTokens-1; i++) {
			    String token = tokens.nextToken();
                if (!usedRoot && token.equals(root))
                    usedRoot = true;
                if (usedRoot)
                    method += "get" + getPropertyMethod(token,"0") + ".";
            }
			method += "set" + getPropertyMethod(tokens.nextToken(), null);
			
			// We are dealing with an enumeration
			if (values != null) {
				method += "(" + enumType + ".Enum.forString";
				suffix = ")";
			}
			return method;

        } else if (useRoot) {
            boolean usedRoot = !useRoot;
            StringTokenizer tokens = new StringTokenizer(fullname,".");
            int nbTokens = tokens.countTokens();
            String method = "";
            for (int i = 0; i < nbTokens; i++) {
                String token = tokens.nextToken();
                if (!usedRoot && token.equals(root))
                    usedRoot = true;
                if (usedRoot)
                    method += token;
            }
            String first = method.substring(0,1);
            if (mode.equalsIgnoreCase("method"))
                return first.toUpperCase() + method.substring(1);
    
            else
                return first.toLowerCase() + method.substring(1);

        } else {
			String method = fullname.replaceAll("\\.","");
			method = method.replaceAll("\\[\\]","");
			String first = method.substring(0,1);
	
			if (mode.equalsIgnoreCase("method"))
				return first.toUpperCase() + method.substring(1);
	
			else
				return first.toLowerCase() + method.substring(1);
		}
	}
	
    public String authorityReferentialInitialize(String mode) {
        String result = null;
        if (mode.equals("set")) {
            StringTokenizer tokens = new StringTokenizer(property,".");
            result = "set" +  tokens.nextToken();
        } else if (mode.equals("ctor")) {
            StringTokenizer tokens = new StringTokenizer(property,".");
            result = tokens.nextToken() + "Type.Factory.newInstance()";
        } else if (mode.equals("get")) {
            StringTokenizer tokens = new StringTokenizer(property,".");
            result = "get" +  tokens.nextToken();            
        }
        
        return result;
    }
    
	private String getPropertyMethod(String property, String parameter) {
		if (property.endsWith("[]")) {
			String method = property.substring(0,property.length() - 2) + "Array";
			if (parameter == null)
				return method;
			
			return method + "(" + parameter + ")";
		}
		if (parameter == null)
			return property;
		
		return property + "()";
	}
	
	private final String baseTypes = "Long Boolean Double";
	
	public String javaType() {
        if ((mode != null) && mode.equalsIgnoreCase("labelonly"))
            return null;

        if ((mode != null) && mode.equalsIgnoreCase("stagetitle"))
            return null;

        if ((type != null) && type.equalsIgnoreCase("ArrayStorage"))
			return null;
		
		if ((guiControl != null) && (guiControl.equals("checklist") || guiControl.equals("yesnolist")))
			return "boolean";
		
		if (isMultipleSelect())
			return "boolean";
		
		if (isRepository())
			return "String";

        if ((javaType != null) && baseTypes.indexOf(javaType) != -1)
            return javaType.toLowerCase();

        if (xsdType.indexOf("XmlDate") > 0)
            return "Calendar";
        
        if (javaType != null)
            return javaType;

        if (xsdType.equals("ArrayStorage"))
            return "List";
        
		String first = xsdType.substring(0,1);

		return first.toUpperCase() + xsdType.substring(1);
	}
	
	public boolean xmlPersistent() {
	    return (property.indexOf("[]") == -1);
    }
    
	public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String escTranslate(String text) {
        String value = translate(text);

        return value.replaceAll("'","&rsquo;");
    }
    
    public String translate(String text) {
		if (this.getTranslations() != null)
			return (String)this.getTranslations().get(text);
		
		return text;
	}

	public boolean getDisplayLabel() {
		return isRepository() ||
            ((mode != null) && mode.equalsIgnoreCase("labelonly") && !type.equals("stagetitle")) ||
			(guiControl == null) || guiControl.equals("text") || 
                                       guiControl.equals("select") || 
                                       guiControl.equals("columns") || 
                                       guiControl.equals("town") || 
                                       guiControl.equals("radiolist") || 
                                       guiControl.equals("checklist") || 
									   guiControl.equals("objectlist") || 
									   guiControl.equals("yesno");
	}
	
    public String getLabelFieldClass() {
        if ((guiControl != null) && guiControl.equals("text") && (getRows() > 1))
            return "label-field-textarea";

        return "label-field";
    }

    public String getGuiControl() {
		return guiControl;
	}

	public void setGuiControl(String guiControl) {
		this.guiControl = guiControl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		if (field.endsWith("]")) {
			int pos = field.indexOf('[');
			if (pos != -1) {
				this.field = field.substring(0,pos);
				this.index = field.substring(pos+1, field.length()-1);
			}
		} else {
			this.field = field;
		}
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(String line) {
        if ((line != null) && (line.length() > 0))
            this.line = new Integer(Integer.valueOf(line).intValue() * 100);
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageno() {
		return pageno;
	}

	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

	public String getLabel() {
        if (isMultiColumn() && !children.isEmpty()) {
            String columnLabel = ((DisplayElement)children.get(0)).getLabel();
            for (int i = 1; i < children.size(); i++) 
                columnLabel += ", " + ((DisplayElement)children.get(i)).getLabel();
            
            return columnLabel;
        }
        return label;
	}

	public String getLowercaseLabel() {
		return label.toLowerCase();
	}

    public String getEscLabel() {
        if (label != null)
            return label.replaceAll("'","&quote;");
        
        return property;
    }

    public String getEscMessage() {
        if (message != null)
            return message.replaceAll("'","&quote;");

        return null;
    }

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMask() {
	    if (mask == null) {
            if (xsdType.indexOf("XmlDate") > 0)
                mask = "[0-9]{1,2}[\\\\/][0-9]{1,2}[\\\\/][0-9]{4}";

            else if (xsdType.indexOf("XmlPositiveInteger") > 0)
                mask = "^[0-9]+$";

            else if (xsdType.indexOf("XmlDouble") > 0)
                mask = "^[0-9]+([\\\\,][0-9]{2})?$";
        }
            
        return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public int getMaxLength() {
        if (maxLength == 0) { 
            if (xsdType.indexOf("XmlDate") > 0)
                return 10;
            if (xsdType.indexOf("XmlPositiveInteger") > 0)
                return 10;
        }
		return maxLength;
	}

	public void setMaxLength(String maxLength) {
		this.maxLength = Integer.parseInt(maxLength);
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public boolean displayRequired() {
        if (isMultiColumn() && !children.isEmpty())
            return ((DisplayElement)children.get(0)).displayRequired();
            
		return required && (mode != null) && !mode.equalsIgnoreCase("static");
	}
	
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getFormat() {
		if (mask != null) {
			if (mask.equals("[A-Z.]*"))
				return "uppercase";
			else if (mask.equals("[a-z.]*"))
				return "uppercase";
			else if (mask.equals("[A-Z]?.*"))
				return "firstupper";
		}
        if (xsdType.indexOf("XmlDate") > 0)
            return "date";
        
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public HashMap getTranslations() {
		return translations;
	}

	public void setTranslations(HashMap translations) {
		this.translations = translations;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getXsdType() {
		return xsdType;
	}

	public void setXsdType(String type) {
		if (type.startsWith("NMTOKENS"))
			type ="ArrayStorage";
		this.xsdType = type;
	}

	public String getEnumType() {
		return enumType;
	}

	public void setEnumType(String enumType) {
		this.enumType = enumType;
	}

	public String getSuffix() {
		String result = suffix;
		suffix = "";
		return result;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public boolean isLastItem() {
		return lastItem;
	}

	public void setLastItem(boolean lastItem) {
		this.lastItem = lastItem;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String helplabel) {
		this.help = helplabel;
	}

	public boolean isMultipleSelect() {
		if (isRepository() && !guiControl.equals("select"))
			return getLength() != 1;

		return false;
	}
	
	public boolean isRepository() {
		return (repository != null) && (repository.length() > 0);
	}
	
	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public boolean isArray() {
		return array;
	}

	public void setArray(boolean array) {
		this.array = array;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

    public String getInfo() {
        return info;
    }

    public void setInfo(String example) {
        this.info = example;
    }

    public String getSeperator() {
        if ((seperator.length() == 0) && (mode != null) && mode.equals("title"))
            return "20";
        
        return seperator;
    }

    public void setSeperator(String seperator) {
        if (seperator.equals("true"))
            seperator ="40";
        this.seperator = seperator;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
        if (condition.length() > 0) {
            String[] operators = condition.split("==|!=");
            if (condition.indexOf("==") != -1) {
                this.condition = operators[0].trim() + "." + "equals(\"" + operators[1].trim() + "\")";
                
            } else if(condition.indexOf("!=") != -1) {
                this.condition = "!" + operators[0].trim() + "." + "equals(\"" + operators[1].trim() + "\")";
                
            } else {
                this.condition = condition;
            }
        }
    }

    public String getBlock() {
        return block;
    }

    public String getBlock(boolean check) {
        if (!check)
            return block;
        
        if (isRepository() && guiControl.equals("checklist") && mode.equals("blockrequired"))
            return "";
        
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSchemaType() {
        if (schemaType != null)
            return schemaType;
        return "";
    }

    public void setSchemaType(String commonType) {
        this.schemaType = commonType;
    }

    public boolean hasPrivateField() {
        return (javaType() != null) &&
                ((guiControl == null) || !guiControl.equals("ticket") && 
                                       !guiControl.equals("referential")); 
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLabelClass() {
        if ((mode != null) && mode.equals("title"))
            return "full";

        if ((guiControl != null) && guiControl.equals("select"))
            return "label";

        if ((guiControl != null) && guiControl.equals("full"))
            return "full";

        if (isRepository())
            return "full";
        
        if ((guiControl != null) && guiControl.equals("checklist"))
            return "full";
        
        return "label";
    }

    public boolean getDisplayTitle() {
        return (isRepository() && guiControl.equals("checklist")) ||
               ((mode != null) && mode.equals("title"));
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getXmlParentClass() {
        return xmlParentClass;
    }

    public void setXmlParentClass(String xmlParentClass) {
        this.xmlParentClass = xmlParentClass;
    }
    
}

class ElementsComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        DisplayElement disp1 = null; 
        
        if (o1 instanceof DisplayElement)
            disp1 = (DisplayElement)o1;

        DisplayElement disp2 = null; 
        
        if (o2 instanceof DisplayElement)
            disp2 = (DisplayElement)o2;

        if ((disp1 != null) && (disp2 != null))
            return disp1.getLine().compareTo(disp2.getLine());
            
        return 0;
    }

}
