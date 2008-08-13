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

import java.io.File;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;

/**
 * @author René le CLERCQ
 */
public class LetterTypeRecord implements IResultRecord {

    private static final long serialVersionUID = -3566003931817371629L;
    private static final String DEFAULT_FILE = "AttestationDefault.xsl-fo";

	private Long id;
    private String shortLabel;
	private String label;
	private boolean send = true;
	private String xsltfo;
    private String defaultfo;
    private String body;
    
    private boolean specific = false;
	
    private DisplayColumn certificatColumns[] =
    {
            new DisplayColumn("shortLabel", "Libellé", false, null),
            new DisplayColumn("label", "Description", false, null)};

	/**
	 */
	public LetterTypeRecord() {
		super();
	}

    public Long getResultId() {
        return id;
    }
    
	public void load() {
	}

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	/**
	 */
	public String getLabel() {
		return label;
	}

	/**
	 */
	public void setLabel(String string) {
		label = string;
	}

	/**
	 */
	public boolean isSend() {
		return send;
	}

	/**
	 */
	public void setSend(boolean b) {
		send = b;
	}

	/**
	 */
	public String getShortLabel() {
		return shortLabel;
	}

	/**
	 */
	public void setShortLabel(String string) {
		shortLabel = string;
	}

	public File getXsltfo() {
        File xsltFile = DispatchFilter.getAssetsBaseFile(StartupServlet.WEBAPP_MODEL_DIR + "/" + xsltfo);
        if (xsltFile.exists())
            return xsltFile;
        
        if ((defaultfo != null) && (defaultfo.length() > 0)) {
            xsltFile = DispatchFilter.getAssetsBaseFile(StartupServlet.WEBAPP_MODEL_DIR + "/" + defaultfo); 
            if (xsltFile.exists())
                return xsltFile;
        }        
        return DispatchFilter.getAssetsBaseFile(StartupServlet.WEBAPP_MODEL_DIR + "/" + DEFAULT_FILE);
	}

    public void setXsltfo(String fileName) {
        xsltfo = fileName;
    }

    public String getFilename() {
        return xsltfo;
    }

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return certificatColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

    public File getBody() {
        File bodyFile = DispatchFilter.getAssetsBaseFile(StartupServlet.WEBAPP_MODEL_DIR + "/" + body);
        return bodyFile;
    }

    public void setDefaultfo(String defaultfo) {
        this.defaultfo = defaultfo;
    }

    public boolean isSpecific() {
        return xsltfo.equals(getXsltfo().getName());
    }

    public void setSpecific(boolean specific) {
        this.specific = specific;
    }

}
