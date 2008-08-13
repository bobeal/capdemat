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

package fr.cg95.cvq.wizard.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author René le CLERCQ
 */
public class BaserefTag extends TagSupport {

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.print("<base href=\"" + request.getScheme() + "://" + request.getServerName());
			if (request.getScheme().equals("http") && (request.getServerPort() == 80));
            else if (request.getScheme().equals("https") && (request.getServerPort() == 443));
            else if (request.getScheme().equals("https") && (request.getServerPort() == 8080))
                out.print(":8443");
			else 
				out.print(":" + request.getServerPort());
			out.println(request.getContextPath() + "/\">");

		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}

}
