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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.tag.ExceptionTag;


public class ErrorAction extends BaseAction {
	
	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		
        // Check we are NOT already treating an error
        if (request.getAttribute(ExceptionTag.ID) == null) {
    	    try {
                // Reload selected request 
                StateManager stateManager = getStateManager(request);
                IResultRecord record = stateManager.getSelectedRecord(); 
                if ((record != null) && (record instanceof RequestRecord)) {
                    ((RequestRecord)record).unLoad();
                    record.load();
                    ((RequestRecord)record).setFullyLoaded();
        		}
        		Throwable ex = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");
        		if (ex == null)
        			ex = (Throwable)request.getAttribute("javax.servlet.error.exception");
    				
                setInfo("/jsp/bo/service/error");
                request.setAttribute(ExceptionTag.ID, ex);

            // Catch all exceptions to avoid infinite loop
            } catch (Exception e) {
            }
        }
		return null;
	}

}
