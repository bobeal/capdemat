package fr.cg95.cvq.bo.tag;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class Lp7ViewTag extends BaseTag {

    public int doEndTag() throws JspException {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();
            
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

            String cookieSessionId = "JSESSIONID=" + request.getSession().getId();

            URL url =
                new URL(
                    request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    request.getContextPath() + "/lp7/view");
            String urlViewLP7 = url.toString();
            
            url =
                new URL(
                    request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    request.getContextPath() + "/img/pdf.png");
            String urlPdf = url.toString();
            
            out.println("<applet name=\"LP7Viewer\"");
            out.println("    archive=\"lp7viewer.jar,");
            out.println("    lib/lp-crl.jar,");
            out.println("    lib/lp-certviewer.jar,");
            out.println("    lib/bcprov.jar,");
            out.println("    lib/lp-applet-util.jar,");
            out.println("    lib/xalan.jar,");
            out.println("    lib/xml-apis.jar,");
            out.println("    lib/xercesImpl.jar,");
            out.println("    lib/xmlsec-1.3.0.jar,");
            out.println("    lib/xlp7.jar\"");
            out.println("    code=\"com.lexpersona.applet.lp7viewer.LP7Viewer\"");
            out.println("    codebase=\"applets\"");
            out.println("    width=\"320\"");
            out.println("    height=\"40\">");
            out.println("  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
            out.println("  <param name=\"url_get_lp7document\" value=\"" + urlViewLP7 +"\">");
            out.println("  <param name=\"view_content_action\" value=\"true\">");
            out.println("  <param name=\"view_signature_tree_action\" value=\"true\">");
            out.println("  <param name=\"foreground_color\" value=\"16102144\">");
            out.println("  <param name=\"background_color\" value=\"15135471\">");
            out.println("  <param name=\"view_content_button_image_url\" value=\"" + urlPdf + "\">");
            out.println("  <param name=\"view_content_button_width\" value=\"140\">");
            out.println("  <param name=\"view_content_button_height\" value=\"30\">");
            out.println("  <param name=\"view_signature_tree_button_width\" value=\"140\">");
            out.println("  <param name=\"view_signature_tree_button_height\" value=\"30\">");
            out.println("  <param name=\"view_signature_tree_frame_width\" value=\"1000\">");
            out.println("  <param name=\"view_signature_tree_frame_height\" value=\"300\">");
            out.println("</applet>");
         
        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

}
