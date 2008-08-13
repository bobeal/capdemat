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

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;

/**
 * @author René le CLERCQ
 */
public class SaveFieldAction extends BaseAction {

	/* (non-Javadoc)
	 * @see fr.cg95.cvq.bo.action.BaseAction#executeLogic(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected ActionForward executeLogic(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		String name = request.getParameter("field");
		
		StringTokenizer split = new StringTokenizer(name, "_");
		String field = (split.hasMoreTokens()) ? split.nextToken() : null;
		String id = (split.hasMoreTokens()) ? split.nextToken() : null;
		String[] value = request.getParameterValues(name);

		modifyData(request, new Long(id), field, value);

		return null;
	}

	protected void modifyData(HttpServletRequest request, Long id, String field, String[] value) {
		// Get the session variables
		StateManager stateManager = getStateManager(request);

		// Find the data object in the selected record

		RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();

		BaseRecord dataRecord = record.getDataRecord(id);

		// Modify its data
		if (dataRecord != null)
			dataRecord.modify(field, value);
	}

}
