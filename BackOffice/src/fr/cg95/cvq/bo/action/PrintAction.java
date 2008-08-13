/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.citizen.VoCardRequestRecord;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.AdultRecord;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.RequestRecord;

public class PrintAction extends BaseAction {

	protected ActionForward executeLogic(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

        SaveForm saveForm = (SaveForm) form;

        File pdf = StartupServlet.getTempContextFile(request.getSession(), "tmp", ".pdf");

        StateManager stateManager = getStateManager(request);

        if (request.getParameter("ticket") != null) 
            createTicket(pdf, stateManager);

        else if (request.getParameter("formular") != null)
            printForm(pdf, stateManager);

        else if (saveForm.getCertificat() != null)
            pdf = createPdfFile(request, saveForm);

        if (pdf.exists()) {
            String pdfName = URLEncoder.encode(pdf.getName(), "utf-8");
            pdfName = pdfName.replaceAll("[+]", "%20");
    		request.setAttribute("url", StartupServlet.getFileContextName(request, pdfName));
    		request.setAttribute("popup", "");
    
    		return mapping.findForward("popup");
        }
        return null;
	}

    private void printForm(File pdf, StateManager stateManager) throws IOException {

        if (stateManager.getSelectedRecord() instanceof RequestRecord) {
            RequestRecord requestRecord = (RequestRecord)stateManager.getSelectedRecord();

            BusinessManager.printRequest(pdf, requestRecord.getId());
            
        }
    }
    
	private void createTicket(File pdf, StateManager stateManager) throws Exception {

		IResultRecord record = stateManager.getSelectedRecord();
		if (record instanceof VoCardRequestRecord) {

			VoCardRequestRecord voRecord = (VoCardRequestRecord)record;
			AdultRecord adult = voRecord.getFamily().getResponsible();

			double ptscm = 72/2.54;
		
			float width = (float)(7 * ptscm);
			float height = (float)(1.2 * ptscm);
			
			Rectangle pageSize = new Rectangle(width,height);
			Document ticket = new Document(pageSize,0,0,0,0);
			PdfWriter.getInstance(ticket,new FileOutputStream(pdf));
			ticket.open();
			
			Paragraph p = new Paragraph();
			
			Font font = p.font();
			font.setSize(10);
			
			Chunk lastName = new Chunk(adult.getLastName(), font);
			Chunk firstName = new Chunk(adult.getFirstName(), font);
			
			p.add(lastName);
			p.add(Chunk.NEWLINE);
			p.add(firstName);
	
			ticket.add(p);
			ticket.close();
		}
	}
	
}
