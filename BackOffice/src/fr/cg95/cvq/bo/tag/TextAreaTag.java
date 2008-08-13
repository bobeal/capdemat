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
public class TextAreaTag extends BaseTag {

	private static final long serialVersionUID = -7814204472296576288L;
	
	private String id;
	private String cols;
	private String rows;

	public int doEndTag() {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			String text = ""; 
			try {
				text = 
					(String) RequestUtils.lookup(pageContext, name, property, getScope());
			} catch (Exception e) {
				e.getMessage();
			}
							
			out.print("<textarea name=\"" + getId() + "\"");
			if (styleClass != null)
				out.print(" class=\"" + styleClass + "\"");

			ProfileManager profileManager = getProfileManager();
			if (profileManager != null) {
				if (profileManager.isReadonly())
					out.print(" disabled");
			}

			out.println(" cols=\"" + getCols() + "\" rows=\"" + getRows() + "\">");
			out.println(text);
			out.println("</textarea>");

		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

	public String getCols() {
		return cols;
	}

	public String getRows() {
		return rows;
	}

	public void setCols(String string) {
		cols = string;
	}

	public void setRows(String string) {
		rows = string;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		id = string;
	}

}
