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
import fr.cg95.cvq.wizard.StringUtils;

/**
 * @author René le CLERCQ
 */
public class CheckTag extends CvqBoxTag {

	private static final String ID = "fr.cg95.cvq.wizard.tag.cvqforms.CheckTag";
	
    private String label = null;
    private String style = null;
    
    private Collection checkList = null;
	
    public int doStartTag() throws JspException {

        checkList = null;
        
        if (!writeTag("check","start",this)) {
            if (display() && ((getMode() == null) || !getMode().equalsIgnoreCase("static"))) {
            
                JspWriter out = pageContext.getOut();
    
                HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    
                try {
                    // For the first time we generate the Javascript
                    if (request.getAttribute(CheckTag.ID) == null) {
                        out.println("<script language=\"JavaScript\">");
                        out.println("  function changeStateCheckBox(checkBoxId){");
                        out.println("    var checkBox = document.getElementById(checkBoxId);");
                        out.println("    checkBox.checked = !checkBox.checked;");
                        out.println("  }");
                        out.println("</script>");
        
                        request.setAttribute(CheckTag.ID, "set");
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
                    if (checkList == null)
                        checkList = new ArrayList();

                    checkList.add(new ReferentialData(key, value));
                }
            }
        }        
        return SKIP_BODY;
    }

	public int doEndTag() throws JspException {
        if (display()) try {
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            
            if (checkList == null)
                checkList = (Collection)request.getSession().getAttribute(getRepository());
            
            if (!writeTag("check","end",this)) {
    			JspWriter out = pageContext.getOut();
    
    			if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
    				if (checkList == null) {
    					writeCheck(out, "check", getName(), getLabel(), getBooleanValue());
    				} else if ((checkList.size() > 10)) {
                        displayColumns(out, "", 2, checkList.iterator());
                    } else {
                        displayNoColumns(out, "", checkList.iterator());
    				}
    
    			} else if (checkList == null) {
    				if (getBooleanValue())
    					out.println(getStaticValue(getLabel()));
    			} else {
    				int i = 0;
    				Iterator iter = checkList.iterator();
    				while (iter.hasNext()) {
    					getName(i++);
    					String label = getRepositoryEntry(iter.next());
    					if (getBooleanValue())
    						out.println(getStaticValue(label));
    				}
    			}
            }
        } catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}


    private String getStaticValue(String label) {
        return getStaticValue(label, "&nbsp;");
    }
    
    private String getStaticValue(String label, String seperator) {
        if (getStyle() == null)
            return StringUtils.split(label + seperator, 22);
        
        return "<div class=\"" + getStyle() + "\">" + label + "</div>";
    }
    
    private void displayNoColumns(JspWriter out, String styleClass, Iterator iter) throws IOException {
        int i = 0;
        while (iter.hasNext()) {
            writeCheck(out, styleClass, getName(i++), getRepositoryEntry(iter.next()), getBooleanValue());
        }
    }
    
    private void displayColumns(JspWriter out, String styleClass, int columns, Iterator iter) throws IOException {
        out.println("<table width=\"100%\"cellspacing=\"0\" cellpadding=\"0\">\n");
        int i = 0;
        while (iter.hasNext()) {
            if (i % columns == 0)
                out.println("<tr>\n");
            out.println("<td>\n");    
            writeCheck(out, styleClass, getName(i), getRepositoryEntry(iter.next()), getBooleanValue());
            out.println("</td>\n");    
            if (i % columns == 1)
                out.println("</tr>\n");
            i++;
        }
        out.println("</table>\n");
    }
    
	private void writeCheck(JspWriter out, String styleClass, String id, String text, boolean checked) throws IOException {
		out.println("<div class=\"" + styleClass + "\" onClick=\"changeStateCheckBox('" + id + "');\">");
		out.println("  <span onClick=\"changeStateCheckBox('" + id + "');\">");

		out.print("    <input type=\"checkbox\" name=\"" + id + "\" value=\"ok\"  id=\"" + id + "\" class=\"" + id + "\"");
		if (checked)
			out.print(" checked");
		out.println(getEvents(KEYPRESS_EVENT) + ">");
		out.println("    </input>");

		out.println("  </span>");
		out.println(text);
		out.println("</div>");
	}
	
    public Collection getCheckedItems() {
        ArrayList<String> result = new ArrayList<String>();
        if (checkList == null) {
            if (getBooleanValue())
                result.add(getStaticValue(getLabel(), ""));
        } else {
            int i = 0;
            Iterator iter = checkList.iterator();
            while (iter.hasNext()) {
                getName(i++);
                String label = getRepositoryEntry(iter.next());
                if (getBooleanValue())
                    result.add(getStaticValue(label, ""));
            }
        }
        return result;
    }
    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Collection getCheckList() {
        return checkList;
    }

}
