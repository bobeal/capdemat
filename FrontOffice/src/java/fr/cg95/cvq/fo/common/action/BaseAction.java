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
package fr.cg95.cvq.fo.common.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.DispatchFilter;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.wizard.process.ProcessStageAction;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;

/**
 * @author Laurent MARQUEZ
 * 
 */
public abstract class BaseAction extends ProcessStageAction implements Constants {

    public static final String AUTHENTIFICATION = "BaseAction.authentification";

    private static Logger logger = Logger.getLogger(BaseAction.class);

    protected MessageResources _messageResources;

    protected void initialize(HttpServletRequest pRequest) {
        logger.debug("initialize()");
        if (null == _messageResources) {
            _messageResources = MessageResources.getMessageResources(FILE_PROPERTY_NAME);
        }
    }

    public ActionForward execute(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest,
            HttpServletResponse pResponse) throws Exception {
        logger.debug("execute()");

        initialize(pRequest);

        setCurrentEcitizen(pRequest.getSession());

        ActionForward actionForward = doExecute(pMapping, pForm, pRequest, pResponse);

        // In the case of a null ActionForward,
        // we used the ProcessWizard
        if (null == actionForward)
            return super.execute(pMapping, pForm, pRequest, pResponse);

        return actionForward;
    }

    protected abstract ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception;

    protected void process(HttpServletRequest request) {
        // Wizard initialization
        ProcessWizardState wizardState = getWizardState(request);

        if (wizardState.getSeasonLabel() == null) {
            RequestManager requestManager = SessionManager.getRequestManager(request);
            Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());
            if (cvqRequest != null)
                wizardState.setSeasonLabel(getSeasonLabel(requestManager.getRequestType(cvqRequest).getId()));
        }            
        wizardState.setDisplayTemplate(DispatchFilter.getAssetsBaseFile("tpl/process.vm"));
        wizardState.setTagTemplate(DispatchFilter.getAssetsBaseFile("tpl/tags.vm"));
        
        LocalAuthorityConfigurationBean siteData = BusinessManager.getCurrentSiteData();
        wizardState.setSiteData(siteData.getName(), siteData.getDisplayTitle(), "/endProcess.do");

        super.process(request);
    }

    public static void setCurrentEcitizen(HttpSession session) throws CvqException {
        setCurrentEcitizen((LoginForm) session.getAttribute(BaseAction.AUTHENTIFICATION));
    }
    
    public static void setCurrentEcitizen(LoginForm login) throws CvqException {
        logger.debug("setCurrentEcitizen()");

        if ((login != null) && (login.getUserName() != null)) {
            if (login.getContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
                // set the login to the security contex
                SecurityContext.setCurrentEcitizen(login.getUserName());
            } else {
                SecurityContext.setCurrentContext(SecurityContext.BACK_OFFICE_CONTEXT);
                SecurityContext.setCurrentAgent(login.getUserName());
            }
        }
    }

    protected boolean isAuthentified(HttpServletRequest pRequest) {
        LoginForm login = (LoginForm)pRequest.getSession().getAttribute(BaseAction.AUTHENTIFICATION);
        return (login != null) && (login.getUserName() != null);
    }
    
    protected void setRequiredDocuments(RequestManager requestManager, Request pRequest) throws CvqException {

        BusinessObjectFactory.setRequiredDocuments(requestManager, pRequest);

    }

    protected void setExpectedDocuments(FamilyHome familyHome, Request pRequest) throws CvqException {

        BusinessObjectFactory.setExpectedDocuments(familyHome, pRequest);

    }

    protected DocumentForm getCurrentDocument(HttpServletRequest pRequest, Request cvqRequest) {
        // get the type id of the document from the HTTP request
        String typeId = pRequest.getParameter(TYPEID);

        Integer currentTypeId = null;

        if (null != typeId) {
            currentTypeId = new Integer(typeId);
        } else {

            currentTypeId = cvqRequest.getCurrentDocumentTypeId();
        }
        // set the type of the document
        cvqRequest.setCurrentDocumentType(currentTypeId);

        // get the document form from the expected document list
        return cvqRequest.getDocument(currentTypeId);
    }

    protected void saveDocuments(Request registrationRequest, Long familyHomeId, Long individualId) throws CvqException, java.io.IOException {

        IRequestService iRequestService = BusinessManager.getInstance().getRequestService();

        IDocumentService iDocumentService = BusinessManager.getInstance().getDocumentService();

        // documents of the cvq request
        Collection suppliedDocuments = registrationRequest.getSuppliedDocument();
        Iterator it = suppliedDocuments.iterator();
        Set documentSet = new HashSet();
        while (it.hasNext()) {
            DocumentForm documentForm = (DocumentForm) it.next();

            Long documentId = (documentForm.getId() != null) ? Long.valueOf(documentForm.getId()) : null;
            if (documentId == null) {
                // create the "administrative" part of the document
                fr.cg95.cvq.business.document.Document document = new fr.cg95.cvq.business.document.Document();
                DocumentType documentType = iDocumentService.getDocumentTypeById(documentForm.getTypeId());
                document.setDocumentType(documentType);

                documentId = iDocumentService.create(document, familyHomeId, individualId);

                // then add all the binary data pages
                ArrayList suppliedDocument = new ArrayList(documentForm.getServerFileMap());
                int iMax = suppliedDocument.size();
                for (int i = 0; i < iMax; i++) {
                    byte data[] = getFileData((File) suppliedDocument.get(i));
                    DocumentBinary docBin = BusinessObjectFactory.createDocumentBinaryFromFront(data, i);
                    iDocumentService.addPage(documentId, docBin);
                }
            }
            documentSet.add(documentId);
        }

        iRequestService.addDocuments(registrationRequest.getId(), documentSet);
    }

    private String getSeasonLabel(Long requestTypeId) {

        try {
            Date now = new Date();
            RequestType requestType = 
                BusinessManager.getInstance().getDefaultRequestService().getRequestTypeById(requestTypeId);

            Iterator iter = requestType.getSeasons().iterator();
            while (iter.hasNext()) {
                RequestSeason season = (RequestSeason)iter.next();
                if ((season.getRegistrationStart() != null) && season.getRegistrationStart().before(now) &&
                    (season.getRegistrationEnd() != null) && season.getRegistrationEnd().after(now))
                    return season.getLabel();
            }
        } catch (CvqException e) {
        }
        
        return null;
    }
    
    private byte[] getFileData(File file) {
        int size = new Long(file.length()).intValue();
        byte[] data = new byte[size];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);

            fis.read(data);

        } catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        } catch (IOException ioe) {
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
            }
        }
        return data;
    }

    protected String getCityName() {
        return SecurityContext.getCurrentSite().getName();
    }
    
    protected String getPostalCode() {
        return SecurityContext.getCurrentSite().getPostalCode();
    }
    
    protected String generateIdByClock() {

        Integer idGeneratedByClock = new Integer((int) System.currentTimeMillis());

        int id = Integer.parseInt(idGeneratedByClock.toString());
        String hexa = Integer.toString(id, 16);

        // Only take the last 6 characters
        int pos = (hexa.length() > 6) ? hexa.length() - 6 : 0;
        hexa = hexa.substring(pos);

        return hexa;
    }

    protected void addAutoPrint(File pdf) {
        try {
            FileInputStream fopout = new FileInputStream(pdf);
            PdfReader reader = new PdfReader(fopout);

            FileOutputStream pdfout = new FileOutputStream(pdf);

            int n = reader.getNumberOfPages();
            Document document = new Document(reader.getPageSizeWithRotation(1));
            PdfWriter writer = PdfWriter.getInstance(document, pdfout);
            document.open();

            PdfAction jAction = PdfAction.javaScript("this.print({bUI:false,nStart:0,nEnd:" + (n - 1)
                    + ",bSilent:true});\r", writer);
            writer.addJavaScript(jAction);

            PdfContentByte cb = writer.getDirectContent();
            PdfImportedPage page;
            int rotation;
            int i = 0;
            while (i < n) {
                i++;
                document.setPageSize(reader.getPageSizeWithRotation(i));
                document.newPage();
                page = writer.getImportedPage(reader, i);
                rotation = reader.getPageRotation(i);
                if (rotation == 90 || rotation == 270) {
                    cb.addTemplate(page, 0, -1f, 1f, 0, 0, reader.getPageSizeWithRotation(i).height());
                } else {
                    cb.addTemplate(page, 1f, 0, 0, 1f, 0, 0);
                }
                System.out.println("Processed page " + i);
            }
            document.close();
        } catch (IOException ioe) {
            ioe.getMessage();
        } catch (DocumentException de) {
            de.getMessage();
        }
    }

    protected boolean hasCookie(HttpServletRequest pRequest, String pName) {
        Cookie cookies[] = pRequest.getCookies();
        if (cookies == null)
            return false;

        int i = 0;
        while ((i < cookies.length) && !cookies[i++].getName().equals(pName))
            ;

        return (i < cookies.length);
    }

    protected boolean isOnTerminal(HttpServletRequest pRequest) {
        return hasCookie(pRequest, COOKIE_NAME);
    }

    protected String getTerminal(HttpServletRequest pRequest) {
        Cookie cookies[] = pRequest.getCookies();
        if (cookies == null)
            return null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(COOKIE_NAME))
                return cookies[i].getValue();
        }
        return null;
    }

    /**
     * Cleanups all user sessions attributes
     * 
     * @param session
     *            Users's session
     */
    protected void cleanupSessionAttributes(HttpSession session) {
        cleanupSessionAttributes(session, "");
    }

    protected static void cleanupSessionAttributes(HttpSession session, String excluded) {

        // we need to use a transition vector because we can't
        // directly modify the Enumeration provided by the Session
        // object (concurrent modifications not allowed)
        Enumeration e = session.getAttributeNames();
        Vector v = new Vector();
        while (e.hasMoreElements()) {
            v.add(e.nextElement());
        }

        e = v.elements();
        while (e.hasMoreElements()) {
            String att = (String) e.nextElement();

            // Do not remove exluded attributes
            if (excluded.indexOf(att) == -1)
                session.removeAttribute(att);
        }
    }

}
