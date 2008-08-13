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

package fr.cg95.cvq.bo.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.IImportExportRequest;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.tag.ResultDisplayTag;

/**
 * @author René le CLERCQ
 */
public class ImportExportForm extends ActionForm {
	
	private static final long serialVersionUID = -5028982934080753836L;

	public static final int MODE_IMPORT = 1;
	public static final int MODE_EXPORT = 2;
	
	private int mode = MODE_EXPORT;
	private FormFile file;
    private SearchForm currentSearch;
    private String dataType = "";

	public ImportExportForm() {
		super();
	}

	public SearchForm getCurrentSearch() {
		return currentSearch;
	}

	public void setCurrentSearch(SearchForm search) {
		currentSearch = search;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		if (getMode() == MODE_EXPORT) {
			StateManager stateManager = (StateManager) request.getSession().getAttribute(StateManager.STATE_MANAGER);
	
			if ((stateManager.getCurrentSearch() != null)
				&& (stateManager.getCurrentSearch().getTotalRecordNb() > 0)
				&& (stateManager.getCurrentSearch().getWholeResultsList().get(0) instanceof RequestRecord)) {
	
				setCurrentSearch(stateManager.getCurrentSearch());
	
				long start = stateManager.getCurrentSearch().getCurrentRecord();
				long end = stateManager.getCurrentSearch().getCurrentRecord() + ResultDisplayTag.RESULTS_PER_PAGE;
				if (end > stateManager.getCurrentSearch().getTotalRecordNb())
					end = stateManager.getCurrentSearch().getTotalRecordNb();
	
				// Reset the group for the current display
				for (long r = start; r < end; r++) {
					((IImportExportRequest) currentSearch.getWholeResultsList().get((int) r)).setSelected(false);
				}
	
			} else {
				setCurrentSearch(null);
			}
		}
		super.reset(mapping, request);
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int i) {
		mode = i;
	}

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
