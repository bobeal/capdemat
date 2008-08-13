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

package fr.cg95.cvq.bo.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.form.ImportExportForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.RequestsDocument;
import fr.cg95.cvq.xml.common.RequestsDocument.Requests;

/**
 * @author René le CLERCQ
 */
public class ExportAction extends BaseAction {

	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Get the session variables
		StateManager stateManager = getStateManager(request);
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        
		ImportExportForm exportForm = (ImportExportForm) form;
		
		if (request.getParameter("clear") != null) {
			stateManager.init(request.getSession(),wizardState.getWizard());
		}

		String page = request.getParameter("page");
		if ((page != null) && page.equals("export")) {
			// Export the selected request
            if ((exportForm != null) && (exportForm.getCurrentSearch() != null)) {
                ArrayList<Long> exportList = new ArrayList<Long>();
                Iterator iter = exportForm.getCurrentSearch().getWholeResultsList().iterator();
                while (iter.hasNext()) {
                    RequestRecord record = (RequestRecord) iter.next();
                    record.setMessage(null);
                    
                    if (record.isSelected())
                        exportList.add(record.getId());
                }
                if (!exportList.isEmpty()) {
                    File xmlFile = StartupServlet.getTempContextFile(request.getSession(), "CVQ", ".xml");
                    Collection results = exportRequests(xmlFile, exportList);

                    iter = exportForm.getCurrentSearch().getWholeResultsList().iterator();
                    while (iter.hasNext()) {
                        RequestRecord record = (RequestRecord) iter.next();
                        if (results.contains(record.getId()))
                            record.setMessage("Erreur");
                        else if (record.isSelected())
                            record.setMessage("Ok");
                    }
                    request.setAttribute(
                            "url",
                            "downloadAction.do?file=" + StartupServlet.getFileRelativeName(request, xmlFile));
				}
			}
		}
        // check if we have results to display
//        if ((stateManager.getCurrentSearch() == null) || 
//                (stateManager.getCurrentSearch().getWholeResultsList() == null))
            request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");
        
		return null;
	}

    private Collection exportRequests(File xmlFile, Collection requestIds) {
        Vector<Long> results = new Vector<Long>();
        
        RequestsDocument document = fr.cg95.cvq.xml.common.RequestsDocument.Factory.newInstance();

        Requests demands = document.addNewRequests();
        
        ArrayList<RequestType> xmlRequests = new ArrayList<RequestType>();
        Iterator iter = requestIds.iterator();
        while (iter.hasNext()) {
            Long id = (Long)iter.next();
            try {
                Request request = BusinessManager.getDefaultRequestService().getById(id);
                
                RequestType doc = RequestType.Factory.parse(request.modelToXmlString());
                
                xmlRequests.add(doc);

            } catch (Exception e) {
                e.getMessage();
                results.add(id);
            }
        }
        demands.setRequestArray((RequestType[])xmlRequests.toArray(new RequestType[xmlRequests.size()]));
    
        xmlbMarshalling(document, xmlFile);

        return results;
    }
    
    private void xmlbMarshalling(RequestsDocument document, File xmlFile) {
        try {
            XmlOptions xmlOptions = new XmlOptions();
            xmlOptions.setSavePrettyPrint();
            xmlOptions.setSavePrettyPrintIndent(4);
            xmlOptions.setSaveAggressiveNamespaces();
            xmlOptions.setSaveOuter();
            xmlOptions.setCharacterEncoding("UTF-8");

            document.save(xmlFile, xmlOptions);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
