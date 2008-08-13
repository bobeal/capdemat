/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2006 Conseil Général du Val d'Oise. All Rights
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
package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

import fr.cg95.cvq.wizard.ReferentialData;

/**
 * @author René le CLERCQ
 */
public class RadioTag extends CvqBoxTag {

	private static final String ID = "fr.cg95.cvq.wizard.tag.cvqforms.RadioTag";

	private String label = null;
	
    private Collection radioList = null;
    
    public int doStartTag() throws JspException {

        radioList = null;
        if (!writeTag("radio","start",this)) {
            
            if (display() && ((getMode() == null) || !getMode().equalsIgnoreCase("static"))) {
            
                JspWriter out = pageContext.getOut();
    
                HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    
                try {
                    // For the first time we generate the Javascript
                    if (request.getAttribute(RadioTag.ID) == null) {
                        out.println("<script language=\"JavaScript\">");
                        out.println("  function changeStateRadioButton(radioButtonId){");
                        out.println("   var radioButton = document.getElementById(radioButtonId);");
                        out.println("   radioButton.checked = true;");
                        out.println("   updateDisplay(radioButton.name);");
                        out.println("  }");
                        out.println("</script>");
    
                        request.setAttribute(RadioTag.ID, "set");
                    }
                } catch (Exception ignored) {
                }
            }
        }
        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
        BodyContent body = getBodyContent();
        if (body != null) {
            StringTokenizer options = new StringTokenizer(body.getString(),"\n");
            
            while (options.hasMoreTokens()) {
                StringTokenizer option = new StringTokenizer(options.nextToken(),"\"");
                // skip option tag
                option.nextToken();
                if (option.hasMoreTokens()) {
                    // Keep key value
                    String key = option.nextToken();
                    // Skip end of option tag
                    String value = option.nextToken(">");
                    // Keep the display label 
                    value = option.nextToken("<");
                    // Remove remaining > from string
                    value = value.substring(1);

                    if (radioList == null)
                        radioList = new ArrayList();

                    radioList.add(new ReferentialData(key, value));
                }
            }
        }        
        return SKIP_BODY;
    }

	public int doEndTag() throws JspException {
		
        if (display()) try {
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            
            if (radioList == null)
                radioList = (Collection)request.getSession().getAttribute(getRepository());
            
            if (!writeTag("radio","end",this)) {
    			JspWriter out = pageContext.getOut();
    
    			if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
    				if (radioList == null) {
    					if ((label != null) && label.startsWith("[") && label.endsWith("]")) {
    						String value = label.substring(1,label.length()-1);
    						
    						String id = getName();
    						StringTokenizer tokens = new StringTokenizer(value,",");
    						while (tokens.hasMoreTokens()) {
    							value = tokens.nextToken();
    							addButton(out, "radio", getName(), id, value);
    							id += "1";
    						}
    					} else {
    						addButton(out, "radio", getName(), getName(), label);
    					}
    
                    // We are dealing with a <yes,no> list
                    } else if ((label != null) && label.startsWith("[") && label.endsWith("]")) {
                        int i = 0;
                        Iterator iter = radioList.iterator();
                        while (iter.hasNext()) {
                            addYesNoListButton(out, i++, getRepositoryEntry(iter.next()), false);
                        }
    
                    // We are dealing with a single select list
                    } else if ((radioList.size() > 10)) {
                        displayColumns(out, "", 2, radioList.iterator());
                    } else {
                        displayNoColumns(out, "", radioList.iterator());
                    }
    
    			} else if (radioList == null) {
    				out.println(addStaticButton());
    
                } else if ((label != null) && label.startsWith("[") && label.endsWith("]")) {
                    int i = 0;
                    Iterator iter = radioList.iterator();
                    while (iter.hasNext()) {
                        addYesNoListButton(out, i++, getRepositoryEntry(iter.next()), true);
                    }
    			} else {
                    String value = getStringValue();
    			    Iterator iter = radioList.iterator();
                    while (iter.hasNext()) {
                        ReferentialData data = (ReferentialData)iter.next();
                        if (data.getKey().equals(value))
                            out.println(data.getValue());
                    }
    			}
            }
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

	private String addStaticButton() {
	    String result = "";
        Object value = getValue();
		if ((value != null) && (value instanceof Boolean))
			if (label.startsWith("[") && label.endsWith("]")) {
				String display = label.substring(1,label.length()-1);
				
				StringTokenizer tokens = new StringTokenizer(display,",");
				if (tokens.hasMoreTokens()) {
					display = tokens.nextToken();
					if (((Boolean) value).booleanValue())
						result += display;

					else if (tokens.hasMoreTokens())
						result += tokens.nextToken();
				}
		}
        return result;
	}
	
    private void displayNoColumns(JspWriter out, String styleClass, Iterator iter) throws IOException {
        int i = 0;
        while (iter.hasNext()) {
            ReferentialData data = (ReferentialData)iter.next();
            addListButton(out, styleClass, i++, data.getKey(), data.getValue());
        }
    }
    
    private void displayColumns(JspWriter out, String styleClass, int columns, Iterator iter) throws IOException {
        out.println("<table width=\"100%\"cellspacing=\"0\" cellpadding=\"0\">\n");
        int i = 0;
        while (iter.hasNext()) {
            if (i % columns == 0)
                out.println("<tr>\n");
            out.println("<td>\n");    
            ReferentialData data = (ReferentialData)iter.next();
            addListButton(out, styleClass, i, data.getKey(), data.getValue());
            out.println("</td>\n");    
            if (i % columns == 1)
                out.println("</tr>\n");
            i++;
        }
        out.println("</table>\n");
    }
    
    private void addButton(JspWriter out, String styleClass, String name, String id, String value) throws IOException {
        boolean checked = false;
        if (getBooleanValue() && value.equalsIgnoreCase("oui"))
            checked = true;
        else if (!getBooleanValue() && value.equalsIgnoreCase("non"))
            checked = true;
        
        addButton(out, styleClass, name, id, value, value, checked);
    }
    
	private void addButton(JspWriter out, String styleClass, String name, String id, String value, String display, boolean checked) throws IOException {
	    if (value == null) 
            value = "";
        
        out.println("<div class=\"" + styleClass + "\" onClick=\"changeStateRadioButton('" + id + "');\">");
		out.print("  <input type=\"radio\" name=\"" + name + "\" value=\"" + value + "\" id=\"" + id + "\"");
		
		if (checked)
            out.print(" checked");
		
		out.println(getEvents(KEYPRESS_EVENT) + ">");
		out.println(display);
		out.println("  </input>");
		out.println("</div>");
	}

    private void addListButton(JspWriter out, String styleClass, int index, String value, String label) throws IOException {
        boolean checked = value.equals(getStringValue());
        
//        out.println("<div class=\"label-field\">");
        addButton(out, styleClass, getName(), getName() + index, value, label, checked);
//        out.println("</div>");
    }
    
    private void addYesNoListButton(JspWriter out, int i, String label, boolean isStatic) throws IOException {
        String name = getName(i);
        out.println("<div class=\"label-field\">");
        out.println("<label for=\"" + name + "\" class=\"label\">");
        out.println(label);
        out.println("</label>");
        if (isStatic) {
            out.println(addStaticButton());
        } else {
            addButton(out, "radio", name, name, "Oui");
            addButton(out, "radio", name, name + "1", "Non");
        }
        out.println("</div>");
    }
    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Collection getLabelList() {
        if ((label != null) && label.startsWith("[") && label.endsWith("]")) {
            ArrayList<String> labels = new ArrayList<String>();
            String value = label.substring(1,label.length()-1);
            
            StringTokenizer tokens = new StringTokenizer(value,",");
            while (tokens.hasMoreTokens()) {
                labels.add(tokens.nextToken());
            }
            return labels;
        }
        return null;
    }
    
	public Collection getSelectedItems() {
        ArrayList<String> results = new ArrayList<String>();
        Collection labels = getLabelList();
        
        if (radioList == null) {
            results.add(addStaticButton());
    
        } else if (labels != null) {
            int i = 0;
            Iterator iter = radioList.iterator();
            while (iter.hasNext()) {
                getName(i++);
                ReferentialData data = (ReferentialData)iter.next();
                
                Object value = getValue();
                if ((value != null) && (value instanceof Boolean))
                    if (((Boolean) value).booleanValue())
                        results.add(getRepositoryEntry(data));
            }

        } else {
            String value = getStringValue();
            Iterator iter = radioList.iterator();
            while (iter.hasNext()) {
                ReferentialData data = (ReferentialData)iter.next();
                if (data.getKey().equals(value))
                    results.add(data.getValue());
            }
        }
        return results;
    }
    
	public boolean isChecked(String value) {
	    boolean checked = false;
        if (getBooleanValue() && value.equalsIgnoreCase("oui"))
            checked = true;
        else if (!getBooleanValue() && value.equalsIgnoreCase("non"))
            checked = true;
        
        return checked;
    }
    
    public Collection getRadioList() {
        return radioList;
    }
    
    public void setFirst() {
        pageContext.getRequest().setAttribute(RadioTag.ID, "set");
    }
    
    public boolean isFirst() {
        return pageContext.getRequest().getAttribute(RadioTag.ID) != null;
    }
}
