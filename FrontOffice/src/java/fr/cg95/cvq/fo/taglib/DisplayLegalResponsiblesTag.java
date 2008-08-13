/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq 
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

package fr.cg95.cvq.fo.taglib;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.citizen.form.Responsible;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.util.Constants;


public class DisplayLegalResponsiblesTag extends BaseTag implements Constants {

	private String styleClass;

	private String action;
	private String script;
	
	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

			Collection responsibles = (Collection) RequestUtils.lookup(pageContext, name,	property, getScope());

			String style = getStyleClass();
			
			Iterator iter = responsibles.iterator();
			int index = 0;
			while (iter.hasNext()) {
			    Object item = iter.next();
				
				out.println(
					"<ul class=\"list\">"
				        + "<li class=\"action_row\">"
				        + "<a title=\"\" class=\"action_row_right\" " + href(index) + ">"
				        + "<span class=\"custom_color\"></span>"
                        + displayText(item, true)
                        + "</a></li></ul>");


				index++;
			}
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

    private String onClick(int index) {
        String onClick = "onclick=\"";
        String action = null;
        String script = null;
        String prefix = "";
        String postfix = "";
        
        if (getAction() != null) {
            prefix = "document.location.href='";
            postfix = "'";
            action = getAction("get=" + index);
        }                                       
        if (getScript() != null) {
            prefix = "javascript:";
            postfix = ";";
            script = getScript();
        }
        onClick += prefix;
        if (action != null) {
            if (script != null) {
                onClick += script + "('" + action + "')";
            } else {
                onClick += action;
            }
        } else if (script != null) {
            onClick += script;
        }
        onClick += postfix + "\"";
        return onClick;                                     
    }
    
    private String href(int index) {
        String href = "href=\"";
        String action = null;
        String script = null;
        String prefix = "";
        String postfix = "";
        
        if (getAction() != null) {
            prefix = "";
            postfix = "";
            action = getAction("get=" + index);
        }                                       
        if (getScript() != null) {
            prefix = "javascript:";
            postfix = ";";
            script = getScript();
        }
        href += prefix;
        if (action != null) {
            if (script != null) {
                href += script + "('" + action + "')";
            } else {
                href += action;
            }
        } else if (script != null) {
            href += script;
        }
        href += postfix + "\"";
        return href;                                     
    }
    
    private String getAction(String extra) {
        String action = getAction();
        if ((action != null) && (action.length() > 0)) {

            String parameters = "";
            int question = action.indexOf("?");
            if (question >= 0) {
                parameters = action.substring(question+1);
                action = action.substring(0, question);
            }
            if (!action.endsWith(".do"))
                action += ".do";

            if (parameters.length() > 0)
                action += "?" + parameters;

            if (extra.length() > 0)
                action += "&" + extra;
        }
        return action;
    }
    
	private String displayText(Object object, boolean full) {
        String select = "";
        String name = "";
        if (object instanceof Responsible) {
            select = ((Responsible)object).getChildLegalResponsibleLegalResponsibleFirstName();
            name = ((Responsible)object).getChildLegalResponsibleLegalResponsibleLastName();
        } else if (object instanceof AdultForm) {
            select = ((AdultForm)object).getFirstName();
            name = ((AdultForm)object).getLastName();
        }
		select += " ";
		
		if (!full)
			select = select + name.substring(0,1).toUpperCase() + ".";
		else
			select = select + name;

		return select;
	}
	
	public String getAction() {
		return action;
	}

	public String getScript() {
		return script;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setAction(String string) {
		action = string;
	}

	public void setScript(String string) {
		script = string;
	}

	public void setStyleClass(String string) {
		styleClass = string;
	}

}
