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

import java.io.ByteArrayOutputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class PaperAction extends BaseAction {

	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

	    byte[] fileData = null;
        
        SaveForm saveForm = (SaveForm) form;
        if ((saveForm == null) || (saveForm.getFile() == null)) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ServletInputStream is = request.getInputStream();
            
            byte[] data = new byte[4092];
            int nbRead = 0;
            while ((nbRead = is.read(data)) > 0)
                baos.write(data, 0, nbRead);
    
            is.close();
            fileData = baos.toByteArray();
        } else {
            fileData = saveForm.getFile().getFileData();
        }
        
        if (fileData.length > 0) {
            // Get the session variables
    		StateManager stateManager = getStateManager(request);
    
    		RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
    		PaperRecord paper = null;
    
    		if (request.getParameter("add") != null) {
    			paper = (PaperRecord) record.getSelectedPaper();
    
    			int page = paper.addPage(request.getSession(), fileData);
    
    			record.setSelectedPaper(paper, String.valueOf(page));

                ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
                wizardState.setAlert("N'oubliez pas d'enregistrer le justificatif pour valider votre ajout.");
    		}
        }
        return null;
	}

}
