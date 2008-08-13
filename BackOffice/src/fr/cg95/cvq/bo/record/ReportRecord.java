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

import java.awt.Color;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

/**
 * @author René le CLERCQ
 */
public class ReportRecord implements IResultRecord {

	private static final long serialVersionUID = -1322206033637535203L;
	
	private String label = null;
	private String nbdemands = null;
	private String nbvalidated = null;
	private Color color = null;
    private String title = null;

	private DisplayColumn reportMonthColumns[] =
		{
			new DisplayColumn("label", "Mois", false, null),
			new DisplayColumn("nbdemands", "Nombre de demandes reçus", false, null),
			new DisplayColumn("nbvalidated", "Nombre de demandes validées", false, null)};

	private DisplayColumn reportStateColumns[] =
		{
			new DisplayColumn("label", "Etat", false, null),
			new DisplayColumn("nbdemands", "Nombre de demandes", false, null)};

	private DisplayColumn reportTypeColumns[] =
		{
			new DisplayColumn("label", "Type", false, null),
			new DisplayColumn("nbdemands", "Nombre de demandes", false, null)};

	private DisplayColumn reportQualityColumns[] = {
			new DisplayColumn("label", "Temps de traitement", false, null),
			new DisplayColumn("nbdemands", "Nombre de demandes", false, null)};
	
	/**
	 */
	public ReportRecord() {
		super();
	}

	public ReportRecord(String label, String nbdemands, String nbvalidated) {
		super();
		this.label = label;
		this.nbdemands = nbdemands;
		this.nbvalidated = nbvalidated;
	}

    public ReportRecord(String label, Long nbdemands, Long nbvalidated) {
        this(label, nbdemands, null, nbvalidated);
    }
    
    public ReportRecord(String label, Long nbdemands, String columnTitle, Long nbvalidated) {
		super();
		this.label = label;
		if (nbdemands != null)
			this.nbdemands = String.valueOf(nbdemands.longValue());

		if (nbvalidated != null)
			this.nbvalidated = String.valueOf(nbvalidated.longValue());
        
        this.title = columnTitle;
        if (columnTitle != null)
            reportMonthColumns[2].setLabel("Nombre de demandes " + columnTitle);
	}

	public ReportRecord(String label, Long nbdemands, Long nbvalidated, Color color) {
		super();
		this.label = label;
		if (nbdemands != null)
			this.nbdemands = String.valueOf(nbdemands.longValue());

		if (nbvalidated != null)
			this.nbvalidated = String.valueOf(nbvalidated.longValue());
		
		if (color != null)
			this.color = color;
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

	public String getLabel() {
		return label;
	}

	public String getNbdemands() {
		return nbdemands;
	}

	public String getNbvalidated() {
		return nbvalidated;
	}

	public Color getColor() {
		return color;
	}
	
	public void setLabel(String string) {
		label = string;
	}

	public void setNbdemands(String string) {
		nbdemands = string;
	}

	public void setNbvalidated(String string) {
		nbvalidated = string;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		if (type.equals("month"))
			return reportMonthColumns;
			
		else if (type.equals("state"))
			return reportStateColumns;

		else if (type.equals("type"))
			return reportTypeColumns;

		else if (type.equals("quality"))
			return reportQualityColumns;
		
		return null;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
