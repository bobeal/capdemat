package fr.cg95.cvq.bo.tag;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class TwainTag extends BaseTag {
    
    String post = null;
    String next = null;
    String width = null;
    String height = null;
    String label = null;

    public int doEndTag() throws JspException {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();
            
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

            String cookieSessionId = "JSESSIONID=" + request.getSession().getId();

            URL url = null;
            if (getPost() == null) {
                url = new URL(
                        request.getScheme(),
                        request.getServerName(),
                        request.getServerPort(),
                        request.getContextPath() + "/document/save");
            } else {
                url = new URL(
                        request.getScheme(),
                        request.getServerName(),
                        request.getServerPort(),
                        request.getContextPath() + "/" + getPost());
            }
            String urlPostData = url.toString();

            String twainSource = request.getParameter("twainsource");
            String queryString = request.getQueryString();
            if (twainSource != null) {
                int start = queryString.indexOf("twainsource");
                int end = queryString.indexOf('&',start);
                end = (end == -1) ? queryString.length() : start + end;
                
                if (start > 0)
                    start--;
                queryString = queryString.substring(0,start) + queryString.substring(end);
            }
            String urlNextPage = request.getRequestURL().toString() + "?" + queryString;
            if (getNext() != null) {
                url = new URL(
                        request.getScheme(),
                        request.getServerName(),
                        request.getServerPort(),
                        request.getContextPath() + "/" + getNext());
                urlNextPage = url.toString();
            }
            out.println("<applet name=\"JTwainApplet\"");
            out.println("    archive=\"JTwain.jar,");
            out.println("    lib/commons-httpclient-3.0.1.jar,");
            out.println("    lib/commons-logging-1.0.4.jar,");
            out.println("    lib/commons-codec.jar\"");
            out.println("    code=\"fr.cg95.cvq.applet.JTwainApplet\"");
            out.println("    codebase=\"applets\"");
            out.println("    width=\"" + getWidth() + "\"");
            out.println("    height=\"" + getHeight() + "\">");
            out.println("  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
            out.println("  <param name=\"url_post_data\" value=\"" + urlPostData + "\">");
            out.println("  <param name=\"url_next_page\" value=\"" + urlNextPage + "\">");
            if (getLabel() != null)
                out.println("  <param name=\"button_label\" value=\"" + getLabel() + "\">");
            if (twainSource != null)
                out.println("  <param name=\"twain_source\" value=\"" + twainSource + "\">");
            out.println("</applet>");

        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getHeight() {
        if (height == null)
            return "300";
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        if (width == null)
            return "400";
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
