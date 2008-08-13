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
package fr.cg95.cvq.wizard;

import java.util.ArrayList;

/**
 * @author René le CLERCQ
 */
public class ReferentialData {

	private String key;
	private String value;
    private String label;
    
    private String message;
    
    private boolean selected = false;
    private String precision;
    private String precisionLabel;
    private String priority;
    private String priorityLabel;
    
    private ReferentialData parent = null;
    private ArrayList<ReferentialData> children = new ArrayList<ReferentialData>();
	
    public ReferentialData() {
        super();
    }

    public ReferentialData(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public ReferentialData addDetail(String key, String text) {
        ReferentialData child = new ReferentialData(key, text);
        
        child.setParent(this);
        children.add(child);
        
        return child;
    }
    
    public ReferentialData getDetail(String key) {
        for (int i = 0; i < children.size(); i++) 
            if (children.get(i).getKey().equals(key))
                return children.get(i);

        return null;
    }
    
    public String write(String indent) {
        String tag = "";
        boolean writeNode = (indent != null);
        if (writeNode) {
            tag = indent + "<node ";
            
            tag += "key=\"" + key + "\" ";
            tag += "text=\"" + value + "\" ";
            if (message != null)
                tag += "message=\"" + message + "\" ";
            tag += "selected=\"" + String.valueOf(selected) + "\" ";
            tag += "precision=\"" + precision + "\" ";
            if (precisionLabel != null)
                tag += "precisionLabel=\"" + precisionLabel + "\" ";
            tag += "priority=\"" + priority + "\" ";
            if (priorityLabel != null)
                tag += "priorityLabel=\"" + priorityLabel + "\"";
            tag += ">";
        } else {
            indent = "";
        }

        for (int i = 0; i < children.size(); i++) 
            tag += children.get(i).write(indent + "  ");

        if (writeNode)
            tag += indent + "</node>";
        
        return tag;
    }
    
    public String getId() {
		return key;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

    public String getMessage() {
        return message;
    }

    public String getPrecision() {
        return precision;
    }

    public String getPrecisionLabel() {
        return precisionLabel;
    }

    public String getPriority() {
        return priority;
    }

    public String getPriorityLabel() {
        return priorityLabel;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public void setPrecisionLabel(String precisionLabel) {
        this.precisionLabel = precisionLabel;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setPriorityLabel(String priorityLabel) {
        this.priorityLabel = priorityLabel;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ArrayList<ReferentialData> getChildren() {
        return children;
    }

    public ReferentialData getParent() {
        return parent;
    }

    public void setParent(ReferentialData parent) {
        this.parent = parent;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
	
}
