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
package fr.cg95.cvq.fo.common.action;

import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.xml.common.RequestType;

/**
 * @author René le CLERCQ
 */
public class BaseXmlAction extends BaseAction {

    private static final String PROCESS_SESSION_ATTRIBUTES = "BaseXmlAction.SavedSessionAttributes";
    
    private static Logger logger = Logger.getLogger(CreateRequestAction.class);

	public BaseXmlAction() {
		super();
	}

	protected ActionForward doExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}

    protected void saveSessionAttributes(HttpSession session) {
        Enumeration e = session.getAttributeNames();
        String sessionAttributes = "-";
        while (e.hasMoreElements()) {
            sessionAttributes += e.nextElement().toString() + "-";
        }
        session.setAttribute(PROCESS_SESSION_ATTRIBUTES, sessionAttributes);
    }
    
    protected void removeProcessSessionAttributes(HttpSession session) {
        if (session.getAttribute(PROCESS_SESSION_ATTRIBUTES) != null)
            removeProcessSessionAttributes(session, "");
    }
    
    protected void removeProcessSessionAttributes(HttpSession session, String extra) {
        
        String keep = extra + (String)session.getAttribute(PROCESS_SESSION_ATTRIBUTES);
        cleanupSessionAttributes(session, keep);
    }
    
    protected String getDefaultUrl(HttpServletRequest request) {
        String url = request.getScheme() + "://" + request.getServerName();
        if (request.getScheme().equals("http") && (request.getServerPort() == 80));
        else if (request.getScheme().equals("https") && (request.getServerPort() == 443));
        else
            url += ":" + request.getServerPort();

        url += request.getContextPath() + "/managerWizard.do";
        
        return url;
    }

    protected void initializeRequester(RequestType xmlRequest, Long requesterId) {
        xmlRequest.addNewRequester().addNewAddress();
        
        Adult requester = null;
        if (requesterId != null)
            try {
                requester = BusinessManager.getInstance().findAdult(requesterId);
            } catch (CvqException e) {
                e.getMessage();
            }
            
        if (requester != null) {
            xmlRequest.setRequester(Adult.modelToXml(requester));
            
        } else {
            xmlRequest.getRequester().setNameOfUse("");
            xmlRequest.getRequester().setFirstName("");
            xmlRequest.getRequester().setHomePhone("");
            xmlRequest.getRequester().setMaidenName("");
            xmlRequest.getRequester().setOfficePhone("");
            xmlRequest.getRequester().setLastName("");
//          xmlRequest.getRequester().setBirthDate("");
            xmlRequest.getRequester().setMobilePhone("");
            xmlRequest.getRequester().setEmail("");

            xmlRequest.getRequester().getAddress().setAdditionalDeliveryInformation("");
            xmlRequest.getRequester().getAddress().setAdditionalGeographicalInformation("");
            xmlRequest.getRequester().getAddress().setStreetNumber("");
            xmlRequest.getRequester().getAddress().setStreetName("");
            xmlRequest.getRequester().getAddress().setPlaceNameOrService("");
            xmlRequest.getRequester().getAddress().setPostalCode("");
            xmlRequest.getRequester().getAddress().setCity("");
        }        
    }
    
    protected void initializeBean(XmlObject o, SchemaType st) {
		SchemaProperty[] sp = st.getAttributeProperties();
		XmlCursor c = o.newCursor();
		for (int i = 0; i < sp.length; ++i) {
			if (sp[i].hasDefault() == SchemaProperty.CONSISTENTLY) {
				c.setAttributeText(sp[i].getName(), sp[i].getDefaultText());
			}
		}
		c.dispose();
		sp = st.getElementProperties();
		for (int i = 0; i < sp.length; ++i) {
			SchemaProperty se = sp[i];
			try {
				if (se.getJavaTypeCode() == SchemaProperty.XML_OBJECT) {
					Method m = o.getClass()
							.getMethod("addNew" + se.getJavaPropertyName(), new Class[0]);
					
					for (int n = 0; n < se.getMinOccurs().intValue(); n++) {
						Object val = m.invoke(o, new Object[0]);
						if (val instanceof XmlObject) {
                            if (!st.equals(se.getType()))
                                initializeBean((XmlObject) val, se.getType());
                            
                            if (se.getDefaultText() != null)
								((XmlAnySimpleType) val).setStringValue(se.getDefaultText());
						}
					}
				} else if (se.getDefaultText() != null) {
					Object value = defaultValueType(se);
					if (value != null)
						MethodUtils.invokeMethod(o, "set" + se.getJavaPropertyName(), value);
				}
			} catch (Exception e) {
				logger.warn(e);
			}
		}
	}

	protected String getRequestType(Request request) {
		return BusinessManager.getInstance().getRequestService().getLabel();
	}
	
	private Object defaultValueType(SchemaProperty se) {
		if (se.getJavaTypeCode() == SchemaProperty.JAVA_BOOLEAN)
			return new Boolean(se.getDefaultText());

		if (se.getJavaTypeCode() == SchemaProperty.JAVA_STRING)
			return se.getDefaultText();
		
		if (se.getJavaTypeCode() == SchemaProperty.JAVA_INT)
			return new Integer(se.getDefaultText());

		if (se.getJavaTypeCode() == SchemaProperty.JAVA_LONG)
			return new Long(se.getDefaultText());
		
		if (se.getJavaTypeCode() == SchemaProperty.JAVA_ENUM)
			return se.getType().enumForString(se.getDefaultText());

		return null;
	}

}
