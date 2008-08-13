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
 package fr.cg95.cvq.bo.record;


import java.util.HashMap;

import javax.servlet.jsp.PageContext;

/**
 * @author René le CLERCQ
 */
public class HistoryRecord implements IResultRecord {

	private static final long serialVersionUID = -1983737224481772913L;
	
	private String state;
	private String action;
	private String date;
	private String author;
	private String note;
	
	private DisplayColumn historyColumns[] =
		{
			new DisplayColumn("action", "Action", false, null),
			new DisplayColumn("state", "Etat", false, null),
			new DisplayColumn("date", "Date", false, null),
			new DisplayColumn("author", "Auteur", false, null),
			new DisplayColumn("note", "Commentaire", false, null)};

	/**
	 */
	public HistoryRecord() {
		super();
	}

    public Long getResultId() {
        return null;
    }
    
	public void load() {
	}

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

	public String getAction() {
		return action;
	}

	public String getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	public String getNote() {
		return note;
	}

	public String getState() {
		return state;
	}

	public void setAction(String string) {
		action = string;
	}

	public void setAuthor(String string) {
		author = string;
	}

	public void setDate(String string) {
		date = string;
	}

	public void setNote(String string) {
		note = string;
	}

	public void setState(String string) {
		state = string;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return historyColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

}
