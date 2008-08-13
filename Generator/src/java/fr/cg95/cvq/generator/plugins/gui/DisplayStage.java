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

/**
 * @author René le CLERCQ
 */
public class DisplayStage {

	private String name = null;
	private String javaName = null;
	
	HashMap displayPages = null;
	HashMap javaClasses = null;

	public DisplayStage() {
		super();
	}

	public DisplayStage(String name) {
		super();
		this.name = name;
	}

	public String javaName() {
		return javaName;
	}
	
	public String javaName(String defaultName) {
		if ((name == null) || (name.length() == 0))
			javaName = defaultName;
		else
			javaName = name;
		
		String first = javaName.substring(0,1);

		javaName = first.toUpperCase() + javaName.substring(1);
		
		return javaName;
	}
	
	public void addDisplayElement(DisplayElement displayElement) {
		if (displayPages == null)
			displayPages = new HashMap();
		
		DisplayPage page = (DisplayPage)displayPages.get(displayElement.getPage());
		if (page == null) {
			page = new DisplayPage(displayElement.getPage());
			displayPages.put(page.getName(), page);
		}
		if ((displayElement.getPageno() != null) && (displayElement.getPageno().length() > 0))
			page.setPageno(displayElement.getPageno());
		
		if (displayElement.displayRequired())
			page.setInfoRequired(true);
		
		page.addElement(displayElement);
		
        if (((displayElement.getMode() == null) || (!displayElement.getMode().equals("labelonly") && !displayElement.getMode().equals("stagetitle") )) &&
             !displayElement.isMultiColumn())
		    addJavaDisplayElement(displayElement, true);
	}

    public DisplayElement findDisplayElement(DisplayElement displayElement) {
        if (displayPages == null)
            return null;
        
        DisplayPage page = (DisplayPage)displayPages.get(displayElement.getPage());
        if (page == null)
            return null;
        
        return page.findDisplayElement(displayElement);
    }
    
    public void addJavaDisplayElement(DisplayElement displayElement, boolean defaultClassName) {
        if (javaClasses == null)
            javaClasses = new HashMap();
        
        String className = displayElement.getClassName();
        if (className == null)
            className = javaName("");
        
        JavaClass clazz = (JavaClass)javaClasses.get(className);
        if (clazz == null) {
            clazz = new JavaClass(className);
            if (!defaultClassName) {
                String modelClass = displayElement.getParent().getSchemaType();
                if (modelClass.endsWith("Type"))
                    modelClass = modelClass.substring(0,modelClass.length()-4);
                clazz.setModelClass(modelClass);
            }

            javaClasses.put(clazz.getName(), clazz);
        }
        clazz.addJavaDisplayElement(displayElement);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap getDisplayPages() {
		return displayPages;
	}
	
	public HashMap getJavaClasses() {
		return javaClasses;
	}
	
}
