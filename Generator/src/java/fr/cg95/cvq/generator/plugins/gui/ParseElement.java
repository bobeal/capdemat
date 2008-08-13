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
package fr.cg95.cvq.generator.plugins.gui;

import java.util.HashMap;
import java.util.Vector;

import fr.cg95.cvq.generator.ApplicationDocumentation;
import fr.cg95.cvq.generator.ElementProperties;

/**
 * @author René le CLERCQ
 */
public class ParseElement {

	String name = null;
	String label = null;
	ParseElement parent = null;
	Vector children = null;
	HashMap translation = null;
	
	ElementProperties properties = null;
	ApplicationDocumentation appinfo = null;
	
	public ParseElement() {
		super();
	}

	public ParseElement(String name, ParseElement parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public ParseElement getParent() {
		return parent;
	}

	public void setParent(ParseElement parent) {
		this.parent = parent;
	}

	public void addChild(ParseElement child) {
		if (children == null)
			children = new Vector();
		
		children.add(child);
	}

	public Vector getChildren() {
		return children;
	}

	public ApplicationDocumentation getAppinfo() {
		return appinfo;
	}

	public void setAppinfo(ApplicationDocumentation appinfo) {
		this.appinfo = appinfo;
	}

    public String getProperty() {
        if (getProperties() != null)
            if ((getProperties().getMaxOccurs() == null) || (getProperties().getMaxOccurs().intValue() > 1))
                return name + "[]";

        return name;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
		this.name = name;
	}

	public ElementProperties getProperties() {
		return properties;
	}

	public void setProperties(ElementProperties properties) {
		this.properties = properties;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public HashMap getTranslation() {
		return translation;
	}

	public void setTranslation(HashMap translation) {
		this.translation = translation;
	}

}
