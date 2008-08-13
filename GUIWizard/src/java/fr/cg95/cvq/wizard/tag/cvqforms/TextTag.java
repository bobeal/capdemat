/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2006 Conseil Général du Val d'Oise. All Rights
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
package fr.cg95.cvq.wizard.tag.cvqforms;

import javax.servlet.jsp.JspException;

/**
 * @author René le CLERCQ
 */
public class TextTag extends CvqFormTag {
	
	private static final int MAX_SIZE = 41;
	
	private Integer size = null;
    private String maxlength = null;
	private String rows = null;
	
	public TextTag() {
		super();
	}

	public int doEndTag() throws JspException {
		
		if (display()) try {
            writeTag("text", "end", this);
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}
    
    public Integer getSize() {
        if (size != null)
            return size;
        
        if (getMaxlength() != null) {
            return Math.min(MAX_SIZE,Integer.parseInt(getMaxlength()) * 115 / 100);
        } else {
            return MAX_SIZE;
        }
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

}
