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

import java.util.HashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * @author René le CLERCQ
 */
public class FormTag extends CvqFormBodyTag {

	static private final String CVQ_FORM_TAGS = "CvqFormTags";
	
	String action = null;
    
    String styleClass = null;
	
	public FormTag() {
		super();
	}

	public int doStartTag() throws JspException {
        if (!writeTag("form","start",this)) {
    		try {
    			JspWriter out = pageContext.getOut();
    
    			out.print("<form name=\"" + getName() + "\" method=\"post\" " +
    			            " enctype=\"multipart/form-data; charset=utf-8\"" +
    			            " action=\"" + getAction() + "\" onsubmit=\"return validateForm(this);\"");
    
                if (getStyleClass() != null)
                    out.print(" class=\"" + getStyleClass() + "\"");
                
                out.println(">");
                
    		} catch (Exception ignored) {
    		}
        }
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
        if (!writeTag("form","end",this)) {
    		try {
    			JspWriter out = pageContext.getOut();
    
    			out.println("</form>");
    
    		} catch (Exception ignored) {
    		}
        }
		return EVAL_PAGE;
	}

	public boolean addCvqFormTag(ICvqFormTag formTag) {
		HashMap cvqFormTags = (HashMap)pageContext.getAttribute(CVQ_FORM_TAGS);
		if (cvqFormTags == null) {
			cvqFormTags = new HashMap();
			pageContext.setAttribute(CVQ_FORM_TAGS,cvqFormTags);
		}
		
		ICvqFormTag tag = (ICvqFormTag)cvqFormTags.get(formTag.getName());
		
		if ((tag == null) || !compare(tag.getMode(),formTag.getMode())) {
			cvqFormTags.put(formTag.getName(), formTag);
			return true;
		}
		return false;
	}
	
	public ICvqFormTag getCvqFormTag(String property) {
		HashMap cvqFormTags = (HashMap)pageContext.getAttribute(CVQ_FORM_TAGS);
		if (cvqFormTags == null)
			return null;

		return (ICvqFormTag)cvqFormTags.get(property);
	}
	
	private boolean compare(String s1, String s2) {
		if ((s1 == null) && (s2 == null))
			return true;
		
		if ((s1 == null) || (s2 == null))
			return false;
		
		return s1.equals(s2);
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

}
