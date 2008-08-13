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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
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

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.dispatcher.DispatchFilter;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.wizard.manager.ManagerWizardAction;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author Laurent MARQUEZ
 * 
 */
public abstract class BasePersonalAction extends ManagerWizardAction implements Constants {
    private static Logger _logger = Logger.getLogger(BasePersonalAction.class);

    protected MessageResources _messageResources;

    protected void initialize(HttpServletRequest pRequest) {
        _logger.debug("initialize()");
        if (null == _messageResources) {
            _messageResources = MessageResources.getMessageResources(FILE_PROPERTY_NAME);
        }
    }

    public ActionForward execute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
        _logger.debug("execute()");
        initialize(pRequest);

        BaseAction.setCurrentEcitizen(pRequest.getSession());

        // If the forward is null the child action wants to show the wizard
        // page
        ActionForward forward = doExecute(pMapping, pForm, pRequest, pResponse);
        if (forward != null)
            return forward;

        return super.execute(pMapping, pForm, pRequest, pResponse);
    }

    protected abstract ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception;

    protected void manage(HttpServletRequest request) {
        try {
            BaseAction.setCurrentEcitizen(request.getSession());
        } catch (CvqException e) {
        }
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);

        wizardState.setDisplayTemplate(DispatchFilter.getAssetsBaseFile("tpl/account.vm"));
        wizardState.setTagTemplate(DispatchFilter.getAssetsBaseFile("tpl/accounttags.vm"));

        LocalAuthorityConfigurationBean siteData = BusinessManager.getCurrentSiteData();
        wizardState.setSiteData("FrontOffice", siteData.getName(), siteData.getDisplayTitle(),
                "closeSession.do", "Déconnexion");
        wizardState.setProperties(siteData.getFoAccountTabs());

        super.manage(request);
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

            PdfAction jAction = PdfAction.javaScript("this.print({bUI:false,nStart:0,nEnd:"
                    + (n - 1) + ",bSilent:true});\r", writer);
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
                    cb.addTemplate(page, 0, -1f, 1f, 0, 0, 
                            reader.getPageSizeWithRotation(i).height());
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
