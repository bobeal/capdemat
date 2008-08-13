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

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.manager.ProfileManager;

/**
 */
public class InputTag extends BaseTag {

	private static final long serialVersionUID = -2026044320306722382L;
	
	private String type;
	private String onclick;
	private String value;

	public int doEndTag() {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			if (value == null)
				value = property;
			
			int pos = property.lastIndexOf('.');
			if (pos > 0)
				property = property.substring(pos+1);
			
			String text = null; 
			try {
				Object obj = RequestUtils.lookup(pageContext, name, value, getScope());
                if (obj != null)
                    text = obj.toString();
                
			} catch (Exception e) {
				text = value;
			}
			if (text == null)
				text = "";
								
			out.print(
				"<input type=\""
					+ getType()
					+ "\" name=\""
					+ getProperty()
					+ "\" id=\""
					+ getProperty()
					+ "\"");
					
			if (onclick != null)
				out.print(" onclick=\"" + onclick + "\"");

			if (styleClass != null)
				out.print(" class=\"" + styleClass + "\"");

			ProfileManager profileManager = getProfileManager();
			if (profileManager != null) {
				if (profileManager.isReadonly())
					out.print(" disabled");
			}

			out.println(" value=\"" + text + "\"/>");

		} catch (Exception ignored) {
		}
		value = null;
        return EVAL_PAGE;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setType(String string) {
		type = string;
	}

	public void setValue(String string) {
		value = string;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String string) {
		onclick = string;
	}

}
