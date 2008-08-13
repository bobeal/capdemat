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
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.wizard.ReferentialData;

/**
 * @author René le CLERCQ
 */
public class SelectAuthorityReferentialTag extends CvqFormBodyTag {

	private String repository = null;
	private String property = null;
	
	public SelectAuthorityReferentialTag() {
		super();
	}

	public int doStartTag() throws JspException {

        if (!writeTag("select","start",this)) {
    		if (display() && ((getMode() == null) || !getMode().equalsIgnoreCase("static"))) {
    		
    			JspWriter out = pageContext.getOut();
    			try {
    				out.println("<select " +
    								"name=\"" + getName() + "\" " +
    								"id=\"" + getName() + "\" " +
    								"class=\"" + getName() + "\" " + getEvents() + ">");
    	
    			} catch (Exception ignored) {
    			}
    		}
        }
        return EVAL_BODY_BUFFERED;
	}

	public int doAfterBody() throws JspException {
        if (display()) {
            if (!writeTag("select","body",this)) {
                BodyContent body = getBodyContent();
        		StringTokenizer options = new StringTokenizer(body.getString(),"\n");
        		
        		JspWriter out = body.getEnclosingWriter();
        		String value = getStringValue();
                if (value != null)
                    value = "\"" + value + "\"";
                
        		try {
        			while (options.hasMoreTokens()) {
        				String option = options.nextToken();
        				option = option.replaceAll("\r","");
        				if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
        					// Print out all the options Unknown apart
        					if (option.indexOf("Unknown") < 0) {
        						if ((value != null) && option.indexOf(value) > 0) {
        							// Mark the current value as selected
        							int split = option.indexOf(value) + value.length();
        							option = option.substring(0,split) + " selected" + option.substring(split);
        						}
        						out.println(option);
        					}
        				} else if ((value != null) && (value.length() > 2) && option.indexOf(value) > 0) {
        					// Only printout the label of the current value
        					int start = option.indexOf(">");
        					int end = option.indexOf("<", start);
        					
        					option = option.substring(start + 1,end);
        					out.println(option);
        				}
        			}
        		
        		} catch (IOException e) {
        			throw new JspException(e);
        		}
            }
        }
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
        if (display()) try {
            if (!writeTag("select","end",this)) {
    			JspWriter out = pageContext.getOut();
    
    			Collection listItems = (Collection)pageContext.getSession().getAttribute(repository);
    
    			if (listItems != null) {
    				String value = getStringValue();
    				Iterator iter = listItems.iterator();
    				while (iter.hasNext()) {
    					//ReferentialData data = (ReferentialData)iter.next();
    				    Object data = iter.next();
                        
                        out.print(getOptionLine(value, data));
    				}
    			}
    			if ((getMode() == null) || !getMode().equalsIgnoreCase("static"))
    				out.println("</select>");
            }
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

    private String getOptionLine(String value, Object data) {
        String line = "";
        if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
            if (data instanceof RecreationCenter) {
                RecreationCenter recreationCenter = (RecreationCenter) data;
                String selected = (recreationCenter.getName().equals(value)) ? " selected" : "";
                line = "<option value=\"" + recreationCenter.getName() + "\"" + selected + ">" 
                    + recreationCenter.getName() + "</option>\n";
            }
//            if (data.getChildren().isEmpty()) {
//                String selected = (data.getKey().equals(value)) ? " selected" : "";
//                line = "<option value=\"" + data.getKey() + "\"" + selected + ">" + data.getValue() + "</option>\n";
//            } else {
//                line = "<optgroup label=\"" + data.getValue() + "\">\n";
//                for (int i = 0; i < data.getChildren().size(); i++)
//                    line += getOptionLine(value, (ReferentialData)data.getChildren().get(i));
//
//                line += "</optgroup>\n";
//            }
            
        } else if (value != null) {
            if (data instanceof RecreationCenter) {
                RecreationCenter recreationCenter = (RecreationCenter) data;
                if (recreationCenter.getName().equals(value))
                    line = value;
            } 
        }
        
//        else if (!data.getChildren().isEmpty()) {
//            for (int i = 0; i < data.getChildren().size(); i++)
//                line += getOptionLine(value, (ReferentialData)data.getChildren().get(i));
//        }
        return line;
    }
    
	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		if ((property != null) && (property.length() > 0))
			this.property = property;
		else
			this.property = null;
	}

}
