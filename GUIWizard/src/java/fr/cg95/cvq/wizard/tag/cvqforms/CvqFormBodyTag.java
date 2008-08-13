package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.StringWriter;
import java.util.Calendar;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import fr.cg95.cvq.wizard.DateUtils;
import fr.cg95.cvq.wizard.VelocityUtils;

public class CvqFormBodyTag extends BodyTagSupport implements ICvqFormTag {

    protected static Logger log = Logger.getLogger(CvqFormBodyTag.class);

    private String name = null;
    private String styleClass = null;
    private String mode = null;
    private String scope = null;
    private Integer events = null;

    protected boolean display() {
        Boolean display = new Boolean(true);
        if (getParent() instanceof FormTag) {
            FormTag formTag = (FormTag) getParent();

            try {
                Object data = pageContext.getSession().getAttribute(formTag.getName());
                if (data != null) {
                    String method = getName();
                    String first = method.substring(0, 1);
                    method = "check" + first.toUpperCase() + method.substring(1);

                    display = (Boolean) MethodUtils.invokeMethod(data, method, null);
                }

            } catch (Exception e) {
                e.getMessage();
            }

        }
        // return display.booleanValue();
        return true;
    }

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
        VelocityContext context = (VelocityContext) pageContext.getRequest().getAttribute(
                CvqFormTag.class.getName() + ".velocityContext");

        if (context == null) {
            context = new VelocityContext();
            pageContext.getRequest().setAttribute(CvqFormTag.class.getName() + ".velocityContext", context);
        }
        return context;
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
        Object value = getValue();

        if (value == null)
            return "";

        if (value instanceof Calendar)
            return DateUtils.parseDate((Calendar) value);

        return value.toString();
    }

    public boolean getBooleanValue() {
        Object value = getValue();
        if (value != null) {
            if (value instanceof Boolean)
                return ((Boolean) value).booleanValue();

            if (value instanceof Long)
                return ((Long) value).longValue() == 1;
        }
        return false;
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

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
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
