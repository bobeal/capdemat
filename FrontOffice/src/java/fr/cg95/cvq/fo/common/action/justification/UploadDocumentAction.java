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
package fr.cg95.cvq.fo.common.action.justification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

/**
 * @author René le CLERCQ
 */
public class UploadDocumentAction extends BaseAction {

	public ActionForward doExecute(
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {

		ProcessWizardState wizardState = getWizardState(pRequest);

        // Force the display transition if on terminal
        if (isOnTerminal(pRequest))
            wizardState.setTransition("display");
        
		Request cvqRequest = (Request)pRequest.getSession().getAttribute(Request.class.getName());
		DocumentForm currentDocument = getCurrentDocument(pRequest,cvqRequest);

		// get the document form
		DocumentForm document = (DocumentForm) pForm;

		try {
			currentDocument.uploadDocument(pRequest, document.getUploadedFile());

		} catch (Exception e) {

			// set the error login message in the session
			pRequest.getSession().setAttribute(BAD_FILE_FORMAT_KEY, BAD_FILE_FORMAT_VALUE);
			
			wizardState.setTransition(wizardState.getState());
		}

		currentDocument.setMethod(ADD);

		// set the current document to the request
		pRequest.setAttribute(DOCUMENT_FORM, currentDocument);

		// GUI Wizard doesn't use the ActionForward
		return null;
	}
}