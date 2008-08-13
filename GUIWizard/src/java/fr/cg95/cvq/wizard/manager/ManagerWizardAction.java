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
 package fr.cg95.cvq.wizard.manager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author René le CLERCQ
 */
public class ManagerWizardAction extends Action {

    /** Commons Logging instance. */
    private static Logger log = Logger.getLogger(ManagerWizardAction.class);

    private String info = null;
    private String pdfFile;
    
	public ManagerWizardAction() {
		super();
	}

    public void setInfo(String info) {
        this.info = info;
    }

    public void printPdf(String pdfFile) {
        this.pdfFile = pdfFile;
    }

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

	    log.debug("Create pageContext");
		// Display the current tab of the current manager
//	    BufferedHttpResponseWrapper bufferedResponse = new BufferedHttpResponseWrapper(response);
		JspFactory jspFactory = JspFactory.getDefaultFactory();
		PageContext pageContext =
			jspFactory.getPageContext(servlet, request, response, null, true, 16384, true);

		String siteToLookFor = null;
		String currentSiteName = (String) request.getSession().getAttribute("currentSiteName");
		if (currentSiteName != null)
			siteToLookFor = currentSiteName;
		else
			siteToLookFor = request.getServerName();
		
		// Find the manager in the XML definition, look for name definition in the 
		// request parameters and attributes
		ManagerWizard manager =
			ManagerWizardPlugin.plugin().getManager(
				siteToLookFor,
				ManagerWizardPlugin.getParameter(request, "name"));

		updateWizardState(request);

		// See if the wizard state is already initialized.
		ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);

		if ((manager == null) && (wizardState != null)) {
			// Get the Xml definition based on the manager name in the wizardState
			manager =
				ManagerWizardPlugin.plugin().getManager(
					siteToLookFor,
					wizardState.getManager());
		}
		if (manager != null) {
			// We have a Xml definition so we generate a page on the fly...
            manager.init(pageContext);
            manage(request);
			manager.page(pageContext);
        }
//		response.getWriter().write(bufferedResponse.getOutput());
		jspFactory.releasePageContext(pageContext);
        log.debug("PageContext released");
		return null;
	}

	protected void manage(HttpServletRequest request) {
    }

    protected ManagerWizardState updateWizardState(HttpServletRequest request) {
		// See if the wizard state is already initialized, if so get the tab demanded.
		ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);

		if (wizardState != null) {
			int tab = wizardState.getTab();
			try {
				tab =
					Integer.parseInt(
						ManagerWizardPlugin.getParameter(
							request,
							ManagerWizardState.TAB_REQUEST_PARAMETER));
			} catch (Exception e) {
			}
			wizardState.setTab(tab);

			int index = wizardState.getIndex();
			try {
				index =
					Integer.parseInt(
						ManagerWizardPlugin.getParameter(
							request,
							ManagerWizardState.INDEX_REQUEST_PARAMETER));
			} catch (Exception e) {
			}
			wizardState.setIndex(index);

            String state = null;
            try {
                state =
                    ManagerWizardPlugin.getParameter(
                        request,
                        ManagerWizardState.TRANSITION_REQUEST_PARAMETER);
            } catch (Exception e) {
            }
//          if ((state == null) && (wizardState.getState() != null) && (wizardState.getState().length() > 0))
//                System.out.println(wizardState.getTabId() + "(" + wizardState.getTab() + ")" + ": " + wizardState.getState());

            if (state != null)        
                wizardState.setState(state);

            String submenu = null;
            try {
                submenu =
                    ManagerWizardPlugin.getParameter(
                        request,
                        ManagerWizardState.SUBMENU_REQUEST_PARAMETER);
            } catch (Exception e) {
            }
            if (submenu != null) {
                wizardState.setSubmenu(submenu);
                wizardState.setState(null);
            }

            String emptyContent = null;
            try {
                emptyContent =
                    ManagerWizardPlugin.getParameter(
                        request,
                        ManagerWizardState.EMPTY_REQUEST_PARAMETER);
            } catch (Exception e) {
            }
            wizardState.setEmptyContent(emptyContent != null);

			if (info != null) {
				wizardState.setPopup(info);
				info = null;
			}
            
            if (pdfFile != null) {
                wizardState.setPdfFile(pdfFile);
                pdfFile = null;
            }
		}
        return wizardState;
	}

}

class BufferedHttpResponseWrapper extends HttpServletResponseWrapper {

    PrintWriter writer = null;
    ByteArrayOutputStream baos = null;

    /**
     * Constructor for BufferedHttpResponseWrapper.
     * Create a new buffered Writer
     * 
     * @param response The response object to wrap
     */
    public BufferedHttpResponseWrapper(HttpServletResponse response) {
        super(response);
        baos = new ByteArrayOutputStream();
        writer = new PrintWriter(baos);
    }

    /**
     * Return the buffered Writer
     *  
     * @see javax.servlet.ServletResponse#getWriter()
     */
    public PrintWriter getWriter() throws IOException {
        return writer;
    }

    /**
     * Return the output written to the Writer.
     * To get the output, the Writer must be flushed and closed.
     * The content is captured by the ByteArrayOutputStream.
     *  
     * @return
     */
    public String getOutput() {
        writer.flush();
        writer.close();
        return baos.toString();
    }
}
