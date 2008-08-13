/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.fo.taglib;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.util.MessageResources;

import fr.cg95.cvq.fo.util.Constants;

/**
 */
public class BaseTag extends TagSupport implements Constants {

    protected String name;

    protected String property;

    protected String scope;

    protected String styleClass;

    protected MessageResources _messageResources = MessageResources
            .getMessageResources(FILE_PROPERTY_NAME);

    /**
     */
    public String getName() {
        return name;
    }

    /**
     */
    public String getProperty() {
        return property;
    }

    /**
     */
    public String getScope() {
        if (scope == null)
            scope = "session";
        return scope;
    }

    /**
     */
    public void setName(String pName) {
        name = pName;
    }

    /**
     */
    public void setProperty(String pProperty) {
        property = pProperty;
    }

    /**
     */
    public void setScope(String pScope) {
        scope = pScope;
    }

    /**
     */
    public String getStyleClass() {
        return styleClass;
    }

    /**
     */
    public void setStyleClass(String pStyleClass) {
        styleClass = pStyleClass;
    }

    /**
     * @return Returns the messageResources.
     */
    public MessageResources getMessageResources() {
        return _messageResources;
    }
    /**
     * @param pMessageResources The messageResources to set.
     */
    public void setMessageResources(MessageResources pMessageResources) {
        _messageResources = pMessageResources;
    }

}