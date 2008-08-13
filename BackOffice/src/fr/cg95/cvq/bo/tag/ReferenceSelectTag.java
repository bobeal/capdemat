/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
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
package fr.cg95.cvq.bo.tag;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.manager.ProfileManager;

/**
 */
public class ReferenceSelectTag extends BaseBodyTag {

	private static final long serialVersionUID = 1617342763380975147L;
	
	private String id;
	private String value;
    private String label;
    private String key;
	private String onchange;
    private int rows;
	private boolean search;
	private boolean empty = true;
	
	private Collection collection; 
	private String selection; 

	public int doStartTag() {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			boolean readOnly = false;
            
			collection = null;
			try {
				collection = 
					(Collection) RequestUtils.lookup(pageContext, name, property, getScope());
			} catch (Exception e) {
				readOnly = (property != null) && (property.length() > 0);
				e.getMessage();
			}
							
			selection = null;
			try {
				Object obj = RequestUtils.lookup(pageContext, name, value, getScope());
				if (label != null)
					selection = (String)PropertyUtils.getProperty(obj, label);
				else
					selection = (String)obj;
			} catch (Exception e) {
			}
							
			out.print("<select name=\"" + id + "\" id=\"" + id + "\"");
			if (styleClass != null)
				out.print(" class=\"" + styleClass + "\"");

            ProfileManager profileManager = getProfileManager();
			if (profileManager != null) {
				if (profileManager.isReadonly())
                    readOnly = true;
			}
			if (readOnly)
			    out.print(" disabled");
            
            if (onchange != null)
                out.print(" onchange=\"javascript:" + onchange + ";\"");

            if (rows > 1) {
                out.print(" size=\"" + rows + "\"");
                empty = false;
            }
			out.println(">");
	
            if (isSearch())
                out.println("<option value=''>Indifférent</option>");

            else if (isEmpty())         
                out.println("<option value=\"none\" ></option>");

		} catch (Exception ignored) {
		}
		return EVAL_BODY_BUFFERED;
	}

	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		StringTokenizer options = new StringTokenizer(body.getString(),"\n");
		
		JspWriter out = body.getEnclosingWriter();
		try {
		    String selectedValue = (selection == null) ? "" : selection ;
            while (options.hasMoreTokens()) {
				String option = options.nextToken();
				option = option.replaceAll("\r","");
				if (option.trim().length() > 0) {
                    if (option.indexOf(selectedValue) > 0) {
    					// Mark the current value as selected
    					String tag = "<option";
    					int split = option.indexOf(tag) + tag.length() + 1;
    					option = option.substring(0,split) + " selected " + option.substring(split);
    				}
    				out.println(option);
                }
			}
		
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();

			if (collection != null) {
				Iterator iter = collection.iterator();
				while (iter.hasNext()){
                    Object object = iter.next();
                    String text = "";
                    String keyValue = "";
					if (label != null) {
						text = (String)PropertyUtils.getProperty(object, label);
                        if (key != null)
                            keyValue = (String)PropertyUtils.getProperty(object, key);
                        else
                            keyValue = text;
                    } else {
						text = (String)object;
                        keyValue = text;
                    }
					
					String selected = ((selection != null) && selection.equals(keyValue))? "selected" : "";	
					
					out.println("<option value=\"" + keyValue +  "\" " + selected + " >" + text + "</option>");
				}
			}
			out.println("</select>");


		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}



	/**
	 */
	public String getId() {
		return id;
	}

	/**
	 */
	public String getLabel() {
		return label;
	}

	/**
	 */
	public String getOnchange() {
		return onchange;
	}

	/**
	 */
	public String getValue() {
		return value;
	}

	/**
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 */
	public void setLabel(String string) {
		label = string;
	}

	/**
	 */
	public void setOnchange(String string) {
		onchange = string;
	}

	/**
	 */
	public void setValue(String string) {
		value = string;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isSearch() {
		return search;
	}

	public void setEmpty(boolean b) {
		empty = b;
	}

	public void setSearch(boolean b) {
		search = b;
	}

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
