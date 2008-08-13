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
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.wizard.DateUtils;

/**
 * @author René le CLERCQ
 */
public class ListTag extends CvqFormBodyTag {

    private static final NumberFormat DECIMAL_FORMAT = DecimalFormat.getCurrencyInstance();

    private String property = null;

	private ArrayList displayItems = new ArrayList();
	
	private class DisplayItem {
		String name = null;
		String label = null;
        LinkedHashMap values = new LinkedHashMap();
	}
	
	public ListTag() {
		super();
	}

	public int doStartTag() throws JspException {

		displayItems.clear();
		
		return EVAL_BODY_BUFFERED;
	}

	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		StringTokenizer definitions = new StringTokenizer(body.getString(),"\n");
		
		while (definitions.hasMoreTokens()) {
			String token = definitions.nextToken();
            token = token.replaceAll("\r","").trim();
            if (token.length() > 2) {
                token = token.substring(1,token.length()-1);
    			
                StringTokenizer definition = new StringTokenizer(token,",");
                if (definition.countTokens() >= 2) {
                    DisplayItem item = new DisplayItem();
    				
    				item.name = definition.nextToken();
    				item.label = definition.nextToken().trim();
    				
                    while (definition.hasMoreTokens()) {
                        StringTokenizer values = new StringTokenizer(definition.nextToken(), "=");
                        if (values.countTokens() == 1) {
                            item.values.put(values.nextToken(), "");
                            
                        } else if (values.countTokens() == 2) {
                            item.values.put(values.nextToken(), values.nextToken());
                        }
                    }
    				displayItems.add(item);
                }
            }
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
        if (display()) try {
            if (!writeTag("list","end",this)) {
    			JspWriter out = pageContext.getOut();
    
    			Collection listItems = getObjectList();

                if (listItems != null) {
    				Iterator iter = listItems.iterator();
    				while (iter.hasNext())
    					displayItem(out, iter.next());
    			}
            }
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

	private void displayItem(JspWriter out, Object item) throws IOException {
		for (int i = 0; i < displayItems.size(); i++) {
			DisplayItem displayItem = (DisplayItem)displayItems.get(i);
			
			String value = getDisplayValue(item, displayItem.name, displayItem.values);

			out.println("<div class=\"label-field\">");
			out.println("<label for=\"value\" class=\"label\">");
			out.println(displayItem.label);
			out.println("</label>");
			out.println(value);
			out.println("</div>");
		}
		out.println("<br/>");
	}
    
    public String getDisplayValue(Object item, DisplayItem displayItem) {
        return getDisplayValue(item, displayItem.name, displayItem.values);
    }
    
    public String getDisplayValue(Object item, String property, LinkedHashMap values) {
        String display = "";
        Object value = null;
        try {
            value = PropertyUtils.getProperty(item, property);
            if (value != null) {
                if (value instanceof Double) {
                    display = DECIMAL_FORMAT.format(((Double)value).doubleValue());
                    display = display.substring(0,display.length()-1) + "&euro;";

                } else if (value instanceof Calendar) {
                    display = DateUtils.parseDate((Calendar)value);

                } else if (value instanceof boolean[]) {
                    boolean[] checked = (boolean[])value;
                    String repdef = (String)values.get("repository");
                    List repository = (List)pageContext.getSession().getAttribute(repdef);
                    for (int i = 0; i < checked.length; i++) {
                        if (checked[i]) {
//                            if (display.length() > 0) {
                                display += "</p>\n";
                                display += "</li>\n";
                                display += "<li class=\"text_row\">\n";
                                display += "<p class=\"empty_label\">&nbsp;</p>\n";
                                display += "<p class=\"text\">\n";
//                            }
                            display += (String)repository.get(i);
                        }
                    }
                    
                } else if (value instanceof List) {
                    Set keys = values.keySet();
                    Iterator iter = ((List)value).iterator();
                    while(iter.hasNext()) {
                        if (display.length() > 0) {
                            display += "</p>\n";
                            display += "</li>\n";
                            display += "<li class=\"text_row\">\n";
                            display += "<p class=\"empty_label\">&nbsp;</p>\n";
                            display += "<p class=\"text\">\n";
                        }
                        Object listItem = iter.next();
                        Iterator keyIter = keys.iterator();
                        while (keyIter.hasNext()) {
                            String field = (String)keyIter.next();
                            display += PropertyUtils.getProperty(listItem, field) + " ";
                        }
                    }

                } else if (!values.isEmpty()){
                    display = (String)values.get(value);
                } else {
                    display = value.toString();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return (display == null) ? "" : display;
    }
	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

    public Collection getObjectList() {
        try {
            return (Collection) RequestUtils.lookup(pageContext, getName(), property, "session");
        } catch (Exception e) {
        }
        return null;
    }
    
    public Collection getDisplayItems() {
        return displayItems;
    }
    
    public String getItemLabel(DisplayItem displayItem) {
        return displayItem.label;
    }
}
