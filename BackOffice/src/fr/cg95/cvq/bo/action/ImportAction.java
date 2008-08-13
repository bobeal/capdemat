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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.form.ImportExportForm;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.record.IXsdRequestRecord;
import fr.cg95.cvq.bo.record.XsdRequestRecord;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.importer.ICsvParserService;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.RequestsDocument;

/**
 * @author René le CLERCQ
 */
public class ImportAction extends BaseAction {

	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Get the session variables
		ImportExportForm importForm = (ImportExportForm)form;
		importForm.setMode(ImportExportForm.MODE_IMPORT);
		
        String action = request.getParameter("action");
        String page = request.getParameter("page");
		
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        
        if (request.getParameter("clear") != null) {
            importForm.setCurrentSearch(null);
        }

        if ((action != null) && action.equals("load")) {
            importForm.setCurrentSearch(null);
            FormFile formFile = importForm.getFile();

            if (importForm.getDataType().equals("Concerto")) {
                ICsvParserService parserService = BusinessManager.getCsvParserService();
                parserService.parseData("Concerto", formFile.getFileData());
                wizardState.setAlert("Le fichier " + formFile.getFileName() + " a été importé.");
    
            } else if (importForm.getDataType().equals("SubscribersList")) {
                ICsvParserService parserService = BusinessManager.getCsvParserService();
                parserService.parseData("SubscribersList", formFile.getFileData());
                wizardState.setAlert("Le fichier " + formFile.getFileName() + " a été importé.");
            
            } else if (importForm.getDataType().equals("FrontOfficeInformation")) {
                File assetsFile = DispatchFilter.getAssetsBaseFile("html/information.html");
    //            DispatchFilter.backupFile(assetsFile);
                DispatchFilter.copyFile(formFile.getInputStream(), assetsFile);
                wizardState.setAlert("Le fichier " + formFile.getFileName() + " a été importé.");
    
            } else if (importForm.getDataType().equals("LetterLayout")) {
                File assetsFile = DispatchFilter.getAssetsBaseFile("xsl/" + formFile.getFileName());
    //            DispatchFilter.backupFile(assetsFile);
                DispatchFilter.copyFile(formFile.getInputStream(), assetsFile);
                wizardState.setAlert("Le fichier " + formFile.getFileName() + " a été importé.");
    
            } else if (importForm.getDataType().equals("XmlRequests")) {
    			RequestType[] demandes = loadImportFile(formFile.getInputStream());
    			
    			SearchForm searchForm = new SearchForm();
    			
    			importForm.setCurrentSearch(searchForm);
    
                ArrayList<Object> results = new ArrayList<Object>();
    			for (int i = 0; i < demandes.length; i++) {
    				results.add(XsdRequestRecord.newInstance(demandes[i]));
    			}
    			searchForm.setWholeResultsList(results);
            }
		} else if ((page != null) && page.equals("import")) {
			// Import the selected request
			if ((importForm != null) && (importForm.getCurrentSearch() != null)) {
				ArrayList<RequestType> importList = new ArrayList<RequestType>();
				Iterator iter = importForm.getCurrentSearch().getWholeResultsList().iterator();
				while (iter.hasNext()) {
					IXsdRequestRecord record = (IXsdRequestRecord) iter.next();
					record.setMessage(null);
					
					if (record.isSelected())
						importList.add(record.getDemand());
				}
				if (!importList.isEmpty()) {
                    HashMap<RequestType, Exception> results = importRequests(getStateManager(request).getRequestManager(), importList);

					iter = importForm.getCurrentSearch().getWholeResultsList().iterator();
					while (iter.hasNext()) {
						IXsdRequestRecord record = (IXsdRequestRecord) iter.next();
						Exception error = results.get(record.getDemand());
                        if (error != null)
							record.setMessage(error.getMessage());
						else if (record.isSelected())
							record.setMessage("Ok");
					}
				}
			}
		}
        // check if we have results to display
//        if ((importForm.getCurrentSearch() == null) || 
//                (importForm.getCurrentSearch().getWholeResultsList() == null))
            request.setAttribute(ManagerWizardState.EMPTY_REQUEST_PARAMETER, "");
        
		return null;
	}

    private RequestType[] loadImportFile(InputStream stream) throws XmlException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));  
        RequestsDocument document = RequestsDocument.Factory.parse(reader);
        RequestType[] requests = document.getRequests().getRequestArray();
        RequestType[] xmlRequests = new RequestType[document.getRequests().sizeOfRequestArray()];
        for (int i = 0; i < requests.length; i ++) {
            try {
                Object xmlObject = XmlObject.Factory.parse(requests[i].getDomNode().getFirstChild().getNextSibling());

                String name = requests[i].getDomNode().getFirstChild().getNextSibling().getNodeName();
                Method method = xmlObject.getClass().getMethod("get"+name, (Class[])null);
                
                xmlRequests[i] = (RequestType)method.invoke(xmlObject, (Object[])null);;

            } catch (XmlException e) {
                e.getMessage();
            } catch (SecurityException e) {
                e.getMessage();
            } catch (NoSuchMethodException e) {
                e.getMessage();
            } catch (IllegalArgumentException e) {
                e.getMessage();
            } catch (IllegalAccessException e) {
                e.getMessage();
            } catch (InvocationTargetException e) {
                e.getMessage();
            }
        }
        return xmlRequests;
    }

    private HashMap<RequestType, Exception> importRequests(RequestManager requestManager, Collection demandes) {
        HashMap<RequestType, Exception> errors = new HashMap<RequestType, Exception>();
        
        Iterator iter = demandes.iterator();
        while (iter.hasNext()) {
            RequestType demande = (RequestType)iter.next();
        
            try {
                requestManager.importRequest(demande);
                
            } catch (CvqException e) {
                e.printStackTrace();
                errors.put(demande, e);
            }
        }
        return errors;
    }
    
}
