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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.beanutils.MethodUtils;

import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.StringUtils;

/**
 * @author René le CLERCQ
 */
public class CvqBoxTag extends CvqFormBodyTag {

    private String repository = null;
    private String property = null;
    private String baseName = null;

    public String getRepositoryEntry(Object item) {
        try {
            if (item instanceof ReferentialData)
                return ((ReferentialData)item).getValue();
            
            if (item instanceof String)
                return (String)item;
            
            return (String)MethodUtils.invokeMethod(item,getter(property),null);
        } catch (IllegalAccessException e) {
            e.getMessage();
        } catch (InvocationTargetException e) {
            e.getMessage();
        } catch (NoSuchMethodException e) {
            e.getMessage();
        }
        return null;
    }
    
    private String getter(String field) {
        String first = field.substring(0,1);
        String method = first.toUpperCase() + field.substring(1);
        return "get" + method;
    }
    
    public String getName(int i) {
        if (baseName == null)
            baseName = getName();
        
        setName(baseName + "[" + i + "]");
        
        return getName();
    }
    
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getRepository() {
        if (repository != null)
            return repository;
        
        return "";
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

}
