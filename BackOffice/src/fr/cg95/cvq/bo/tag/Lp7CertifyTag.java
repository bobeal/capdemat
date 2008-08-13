package fr.cg95.cvq.bo.tag;

import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.bo.LP7CertifyProperties;
import fr.cg95.cvq.security.SecurityContext;

public class Lp7CertifyTag extends BaseTag {
    private String next = null;
    
    public int doEndTag() throws JspException {
        try {
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();
            
            HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

            LP7CertifyProperties lp7Properties = new LP7CertifyProperties();
            lp7Properties.init(SecurityContext.getCurrentSite().getName());
            
            String cookieSessionId = "JSESSIONID=" + request.getSession().getId();

            URL url =
                new URL(
                    request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    request.getContextPath() + "/lp7/create");
            String urlCreateLP7 = url.toString();

            url =
                new URL(
                    request.getScheme(),
                    request.getServerName(),
                    request.getServerPort(),
                    request.getContextPath() + "/lp7/save");
            String urlSigned = url.toString();

            String urlNextPage = "";
            if (getNext() == null) {
                url =
                    new URL(
                        request.getScheme(),
                        request.getServerName(),
                        request.getServerPort(),
                        request.getContextPath() + "/saveAction.do?paper");
                urlNextPage = url.toString();
            } else {
                url =
                    new URL(
                        request.getScheme(),
                        request.getServerName(),
                        request.getServerPort(),
                        request.getContextPath() + "/" + getNext());
                urlNextPage = url.toString();
            }
            String fileName = request.getParameter("file"); 
            if (fileName != null) {
                fileName = URLEncoder.encode(fileName,"utf-8");;
                String lp7File = fileName.substring(0,fileName.indexOf("."))+".lp7";
                urlCreateLP7 += "?file=" + fileName;
                urlSigned += "?file=" + lp7File;
                urlNextPage += "?file=" + lp7File;
            }

            String mention = "Certifié conforme";

            out.println("<applet name=\"LP7Certify\"");
            out.println("    archive=\"lp7certify.jar,");
            out.println("    lib/bcprov.jar,");
            out.println("    lib/lp-applet-util.jar,");
            out.println("    lib/iaik_jce.jar,");
            out.println("    lib/iaikPkcs11Provider.jar,");
            out.println("    lib/iaikPkcs11Wrapper.jar,");
            out.println("    lib/xalan.jar,");
            out.println("    lib/xml-apis.jar,");
            out.println("    lib/xercesImpl.jar,");
            out.println("    lib/xmlsec-1.3.0.jar,");
            out.println("    lib/xlp7.jar\"");
            out.println("    code=\"com.lexpersona.applet.lp7certify.LP7Certify\"");
            out.println("    codebase=\"applets\"");
            out.println("    width=\"250\"");
            out.println("    height=\"150\">");
            out.println("  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
            out.println("  <param name=\"url_next_page\" value=\"" + urlNextPage + "\">");
            out.println("  <param name=\"url_get_lp7document\" value=\"" + urlCreateLP7 + "\">");
            out.println("  <param name=\"url_post_lp7document\" value=\"" + urlSigned + "\">");
            out.println("  <param name=\"token_pkcs11_library\" value=\"" + lp7Properties.getLp7CertifyPkcs11Library() + "\">");

            if (lp7Properties.getTsaClientUrl() != null)
                out.println("  <param name=\"url_timestamp\" value=\"" + lp7Properties.getTsaClientUrl() + "\">");

            out.println("  <param name=\"signature_country_name\" value=\"" + lp7Properties.getAppellationSppCountryName() + "\">");
            out.println("  <param name=\"signature_city\" value=\"" + lp7Properties.getAppellationSppCity() + "\">");
            out.println("  <param name=\"signature_postal_code\" value=\"" + lp7Properties.getAppellationSppPostalCode() + "\">");
            out.println("  <param name=\"signature_state_or_province\" value=\"" + lp7Properties.getAppellationSppStateOrProvince() + "\">");
            out.println("  <param name=\"special_mention\" value=\"" + mention + "\">");

            out.println("  <param name=\"foreground_color\" value=\"16102144\">");
            out.println("  <param name=\"font_family\" value=\"Verdana\">");
            out.println("  <param name=\"font_size\" value=\"10\">");
            out.println("  <param name=\"password_field_width\" value=\"150\">");
            out.println("  <param name=\"password_field_height\" value=\"25\">");
            out.println("  <param name=\"ok_button_width\" value=\"120\">");
            out.println("  <param name=\"ok_button_height\" value=\"30\">");
            out.println("  <param name=\"ok_button_layout\" value=\"left\">"); // (tu peux aussi mettre "center" ou "right")
            out.println("</applet>");
        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
}
