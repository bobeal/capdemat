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

import java.io.Serializable;

/**
 * @author René le CLERCQ
 */
public class DisplayColumn implements Serializable {

	private static final long serialVersionUID = 6167277527989601333L;
	
	private String field;
	private String label;
	private String type;
	private boolean sort;
	private String select;
	private String valid;
	private String check;
	private Integer maxChars;

    public DisplayColumn(String field, String label, boolean sort, String select) {
        this(field, label, "text", sort, select, null, null, null);
    }

    public DisplayColumn(String field, String label, boolean sort, String select, Integer maxChars) {
        this(field, label, "text", sort, select, null, null, maxChars);
    }

	public DisplayColumn(String field, String label, String type, boolean sort, String select) {
		this(field, label, type, sort, select, null, null, null);
	}
	
	public DisplayColumn(String field, String label, String type, String check) {
		this(field, label, type, false, null, null, check, null);
	}
	
	public DisplayColumn(String field, String label, String type, boolean sort, String select, String valid) {
		this(field, label, type, sort, select, valid, null, null);
	}

	private DisplayColumn(String field, String label, String type, boolean sort, String select, String valid, String check, Integer maxChars) {
		this.field = field;
		this.label = label;
		this.type = type;
		this.sort = sort;
		this.select = select;
		this.valid = valid;
		this.check = check;
		this.maxChars = maxChars;
	}

	public String getField() {
		return field;
	}

    public String getLabel() {
        if ((label == null) || (label.length() == 0))
            label="&nbsp;";
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

	public String getSelect() {
		return select;
	}

	public boolean isSort() {
		return sort;
	}

	public String getType() {
		return type;
	}

	public String getValid() {
		return valid;
	}

	public String getCheck() {
		return check;
	}

    public Integer getMaxChars() {
        return maxChars;
    }

}
