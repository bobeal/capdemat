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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author René le CLERCQ
 */
public class DisplayPage {
	
	public static final String ALL_PAGES = "*";

	String name = null;
	String pageno = null;
	boolean infoRequired = false;
    String currentBlock = "";
    
    Boolean staticPage = null;
	
	ArrayList displayElements = null;
	
	public DisplayPage() {
		super();
	}

	public DisplayPage(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public boolean newBlock(DisplayElement displayElement) {
        if (!displayElement.getBlock(true).equals(currentBlock)) {
            currentBlock = displayElement.getBlock(true);
            return currentBlock.length() > 0;
        }
        return false;
    }
    
    public boolean endBlock(DisplayElement displayElement) {
        return (currentBlock.length() > 0) && !currentBlock.equals(displayElement.getBlock(true));
    }
    
	public void addElement(DisplayElement displayElement) {
		if (displayElement.getPage().equals(name)) {
			if (displayElements == null)
				displayElements = new ArrayList();
		
			displayElements.add(displayElement);
		}
	}
    
    public DisplayElement findDisplayElement(DisplayElement displayElement) {
        if (displayElements == null)
            return null;
        
        for (int i = 0; i < displayElements.size(); i++) {
            DisplayElement existingElement = (DisplayElement)displayElements.get(i);
            if (equals(existingElement.getField(), displayElement.getField()) &&
                equals(existingElement.getType(), displayElement.getType()) &&
                equals(existingElement.getLine(), displayElement.getLine()))
                return existingElement;
        }
        return null;
    }
	
    private boolean equals(Object o1, Object o2) {
        if ((o1 == null) && (o2 == null))
            return true;
        
        if (o1 != null)
            return o1.equals(o2);
        
        return o2.equals(o1);
    }
    
	public ArrayList getDisplayElements() {
		if (displayElements != null)
			Collections.sort(displayElements, new ElementsComparator());

		return displayElements;
	}

	public void setDisplayElements(ArrayList displayElements) {
		this.displayElements = displayElements;
	}

	public boolean getInfoRequired() {
		return infoRequired;
	}

	public void setInfoRequired(boolean infoRequired) {
		this.infoRequired = infoRequired;
	}

	public String getPageno() {
		return pageno;
	}

	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

    public String getCurrentBlock() {
        return currentBlock;
    }

    public boolean getStaticPage() {
        if (staticPage == null) {
            staticPage = new Boolean(true);
            for (int i = 0; i < displayElements.size(); i++) {
                DisplayElement displayElement = (DisplayElement)displayElements.get(i);
                if (!displayElement.getMode().equals("static") && !displayElement.getMode().equals("labelonly"))
                    staticPage = new Boolean(false);
            }
        }
        return staticPage.booleanValue();   
    }

    public boolean getSummaryPage() {
        if (displayElements.size() > 0) {
            DisplayElement displayELement = (DisplayElement)displayElements.get(0);
            return getStaticPage() && 
                    displayELement.getStage().equals("validation") && 
                   (displayELement.getPage().indexOf("summary") == 0);
        }
        return false;
    }

    public boolean getDisplayPage() {
        return (name.indexOf("display") != -1);
    }

}

