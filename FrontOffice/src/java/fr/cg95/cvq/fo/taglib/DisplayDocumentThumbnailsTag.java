/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.dispatcher.StartupServlet;

/**
 */
public class DisplayDocumentThumbnailsTag extends BaseTag {
	static Logger _logger = Logger.getLogger(DisplayDocumentThumbnailsTag.class);

	protected String _action;
    private int columns = 3;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

            Request cvqRequest = (Request)pageContext.getSession().getAttribute(Request.class.getName());
            
            DocumentForm document = null;
            if (cvqRequest != null)
                document = cvqRequest.getCurrentDocument();

            if (document == null)
                document = (DocumentForm) RequestUtils.lookup(pageContext, name, property, getScope());

            BaseAction.setCurrentEcitizen(pageContext.getSession());
            if (document.getNumberOfPages() == 0)
				BusinessObjectFactory.loadDocumentPages(pageContext.getSession(), document);
            
            int height = (1 + (document.getNumberOfPages()-1) / columns) * 200;
			out.println("<div class=\"div_imagearea\" style=\"height:" + height + "px;\">");

			String action_page = "";
			if (_action.indexOf(".do") > 0) {
				if (_action.endsWith(".do"))
					action_page = _action + "?page=";
				else
					action_page = _action + "&page=";
			} else {
				action_page = _action + ".do?page=";
			}
			int page = 1;
			int row = 0;
			while (page <= document.getNumberOfPages()) {
				int top = row * 205;
				int col = 0;
				while ((page <= document.getNumberOfPages()) && (col < columns)) {
					int left = col * 164;
					out.println(
						"<div class=\"div_image\" style=\"left:"
							+ left
							+ "px; top:"
							+ top
							+ "px\""
							+ "onclick=\"document.location.href='"
							+ action_page
							+ page
							+ "'\""
							+ ">");

					out.println(
						"<img src=\""
							+ StartupServlet.getFileContextName(
								(HttpServletRequest) pageContext.getRequest(),
								document.getServerFile(page))
							+ "\" alt=\"Page "
							+ page
							+ "\""
							+ "width=\"140\" height=\"195\">");
					out.println("</div>");
					page++;
					col++;
				}
				row++;
			}

			out.println("</div>");

		} catch (Exception ignored) {
			_logger.debug(ignored.toString());
		}
		return EVAL_PAGE;
	}

	/**
	 * @return Returns the action.
	 */
	public String getAction() {
		return _action;
	}
	/**
	 * @param pAction The action to set.
	 */
	public void setAction(String pAction) {
		_action = pAction;
	}

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
