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
import java.io.FileOutputStream;

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

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.citizen.VoCardRequestRecord;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;

/**
 * @author René le CLERCQ
 */
public class CardAction extends BaseAction {

    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        SaveForm saveForm = (SaveForm) form;

        if (saveForm.getPrint() != null) {
            File pdf = createTicket(request);
            request.setAttribute("url", StartupServlet.getFileContextName(request, pdf));
            request.setAttribute("popup", "");

            return mapping.findForward("popup");
            
        } else {
            IndividualRecord individual = (IndividualRecord)getStateManager(request).getSelectedRecord();
            BusinessManager.updateCard(individual.getCardId(), BusinessDictionary.getCardState(saveForm.getState()));
            individual.setCardState(saveForm.getState());
        }
        return null;
    }

    private File createTicket(HttpServletRequest request) throws Exception {

        File pdf = StartupServlet.getTempContextFile(request.getSession(), "tmp", ".pdf");
        
        IndividualRecord adult = null;
        IResultRecord record = getStateManager(request).getSelectedRecord();
        if (record instanceof VoCardRequestRecord) {

            VoCardRequestRecord voRecord = (VoCardRequestRecord)record;
            adult = voRecord.getFamily().getResponsible();
            
        } else if (record instanceof IndividualRecord) {
            adult = (IndividualRecord)record;
        }
        if (adult != null) {
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
        return pdf;
    }
    
}
