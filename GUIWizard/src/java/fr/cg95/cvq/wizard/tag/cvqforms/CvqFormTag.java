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

import java.io.StringWriter;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import fr.cg95.cvq.wizard.DateUtils;
import fr.cg95.cvq.wizard.StringUtils;
import fr.cg95.cvq.wizard.VelocityUtils;
import fr.cg95.cvq.wizard.process.xmlbean.ConfirmType;

/**
 * @author René le CLERCQ
 */
public class CvqFormTag extends TagSupport implements ICvqFormTag {

    protected static Logger log = Logger.getLogger(CvqFormTag.class);

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###.00");

    private String name = null;
	private String mode = null;
    private String scope = null;
    private Integer events = null;

    protected boolean writeTag(String widget, String action, Object tag) {
        Template tagTemplate = VelocityUtils.getTagTemplate(pageContext.getSession());        
        VelocityContext context = getVelocityContext();
        context.put("widget", widget);
        context.put("action", action);
        context.put("tag", tag);
        
        try {
            StringWriter out = new StringWriter();
            tagTemplate.merge(context, out);
            
            if (out.toString().trim().length() > 0) {
                pageContext.getOut().print(out.toString().trim());
                return true;
            }

        } catch (ResourceNotFoundException e) {
            log.error("wizardPage", e);
        } catch (ParseErrorException e) {
            log.error("wizardPage", e);
        } catch (MethodInvocationException e) {
            log.error("wizardPage", e);
        } catch (Exception e) {
            log.error("wizardPage", e);
        }
        return false;
    }

    private VelocityContext getVelocityContext() {
        VelocityContext context = 
            (VelocityContext)pageContext.getRequest().getAttribute(CvqFormTag.class.getName() + ".velocityContext");
        
        if (context == null) {
            context = new VelocityContext();
            pageContext.getRequest().setAttribute(CvqFormTag.class.getName() + ".velocityContext", context);
        }
        return context;
    }
    
    protected boolean display() {
        Boolean display = new Boolean(true);
        if (getParent() instanceof FormTag) {
            FormTag formTag = (FormTag)getParent();
            
            try {
                Object data = pageContext.getSession().getAttribute(formTag.getName());
                if (data != null) {
                    String method = getName();
                    String first = method.substring(0,1);
                    method = "check" + first.toUpperCase() + method.substring(1);
                    
                    display = (Boolean)MethodUtils.invokeMethod(data, method, null);
                }

            } catch (Exception e) {
                e.getMessage();
            }
            
        }
//        return display.booleanValue();
        return true;
    }

    protected String getHref(ConfirmType[] confirmArray, String action, String name) {
        String prefix = "";
        String postfix = "";
        
        if (confirmArray != null) {
            for (int i = 0; i < confirmArray.length; i++) {
                ConfirmType confirm = confirmArray[i];
                if (confirm.getCheck() != null) {
                    Object condition = null;
                    if (confirm.getCheck().length() > 0) {
                        try {
                            condition = RequestUtils.lookup(pageContext, confirm.getName(), confirm.getCheck(), "session");
                        } catch (JspException e) {
                        }
                    }
                    
                    boolean displayAlert = true;
                    if (condition != null) {
                        if (condition instanceof Boolean)
                            // Condition object is a boolean, we display according to the boolean value
                            displayAlert = !((Boolean)condition).booleanValue();
                        else
                        // Condition object avalable and not a boolean, we display
                            displayAlert = false;
                    }
                    if (displayAlert) { 
                        return "javascript:alert('" + formatScriptText(confirm.getStringValue()) + "');";
                    }
                } else {
                    prefix = "javascript:processConfirm('" + formatScriptText(confirm.getStringValue()) + "','";
                    postfix = "')";
                }
            }
        }
        if (action.indexOf('?') != -1)
            return prefix + action + "&name=" + name + postfix;

        return prefix + action + "?name=" + name + postfix;
    }

    private String formatScriptText(String text) {
        String result = text.replaceAll("'","\\\\'");
        return result;
    }

    public String getEvents() {
        if (events == null)
            events = CHANGE_EVENT | KEYPRESS_EVENT;
        
        return getEvents(events);
    }

    public String getChangeEvent() {
        if (events == null)
            events = CHANGE_EVENT | KEYPRESS_EVENT;
        
        return getEvents(events & CHANGE_EVENT);
    }

    public String getEvents(int eventSet) {
        String events = "";

        if ((eventSet & CHANGE_EVENT) == CHANGE_EVENT)
            events += " onchange=\"javascript:validateField(this);\"";

        if ((eventSet & KEYPRESS_EVENT) == KEYPRESS_EVENT)
            events += " onkeypress=\"javascript:return processDefaultButton(event);\"";

        return events;
    }

	public Object getValue() {
		Object value = null;
        
        Tag parent = getParent();
        while ((parent != null) && !(parent instanceof FormTag))
            parent = parent.getParent();
        
		if (parent instanceof FormTag) {
			FormTag formTag = (FormTag)parent;
			
			try {
				value = RequestUtils.lookup(pageContext, formTag.getName(), getName(), getScope());

			} catch (Exception e) {
			}
			
		}
		return value;
	}
	
    public String getStringValue() {
        return  getStringValue(0);
    }
    
    public String getStringValue(int maxChars) {
		Object value = getValue();
		
        if (value == null)
            return "";
        
        if (value instanceof Calendar)
            return DateUtils.parseDate((Calendar)value);
        
        if (value instanceof Double) {
            return DECIMAL_FORMAT.format(((Double)value).doubleValue());
        }
        
        if (maxChars > 0)
            return StringUtils.split(value.toString(), maxChars);
        
		return value.toString();
	}
	
	public boolean getBooleanValue() {
		Object value = getValue();
		return ((value != null) && (value instanceof Boolean) && ((Boolean)value).booleanValue());
	}
	
	public String getMode() {
        if (mode == null)
            return "";
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getScope() {
        if (scope == null)
            return "session";
        
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getValidEvents() {
        return events;
    }

    public void setValidEvents(Integer events) {
        this.events = events;
    }

}
