package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

public class CardUnlockTag extends BaseTag {

    String validate;
    String action;
	String left;
	String top;
	
	public CardUnlockTag() {
		super();
	}

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

//            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
//            String site = null;
//            if (request.getSession().getAttribute("currentSiteName") != null)
//            		site = (String) request.getSession().getAttribute("currentSiteName");
//            else
//            		site = pageContext.getRequest().getServerName();
//            String foreground = ProcessWizardPlugin.getColor(site, ProcessWizardPlugin.STATE_COLOR_BUTTON);
//			String background = ProcessWizardPlugin.getColor(site, ProcessWizardPlugin.STATE_COLOR_BACKGROUND);
            String foreground = "#7593b9";
            String background = "#fbe38b";

			appletTag(out,foreground,background);
			
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}
	
    private void appletTag(JspWriter out, String foreground, String background) throws IOException {

		String style = "";
		if (getStyleClass() != null)
			style = "class=\"" + getStyleClass() + "\" "; 
		out.println("<div " + style + "style=\"position:relative;left:" + left + "px;top:" + top + "px\">");

		out.println("		<br/>");
		out.println("  <applet " +
			"archive=\"LPApplets.jar,lp-applet-util.jar,iaik_jce.jar,iaikPkcs11Provider.jar\" " +
			"code=\"com.lexpersona.applet.unlockcard.LPUnlockCard\" " +
			"codebase=\"applets\" " +
			"name=\"LPUnlockCard\" " +
			"width=\"400\" " +
			"height=\"160\">");

		HttpSession session = pageContext.getSession();

		String cookieSessionId = "JSESSIONID=" + session.getId();
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		URL url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/cardAction.do?action=deblock");
		String urlPostRequest = url.toString();

		url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/personal_loginAction.do?userName=user&password=password&method=card");
		String urlNextPage = url.toString();

		String tokenAlias = "CG95";
		String tokenKeyIdentifier = "1";
		String tokenPkcs11Library = "slbCk.dll";
		String tokenSoPin = "11111111";

        int fg = Integer.parseInt(foreground.substring(1), 16);
        foreground = String.valueOf(fg);
        int bg = Integer.parseInt(background.substring(1), 16);
        background = String.valueOf(bg);
        
		out.println("  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
		out.println("  <param name=\"url_next_page\" value=\"" + urlNextPage + "\">");
		out.println("  <param name=\"url_post_request\" value=\"" + urlPostRequest + "\">");
		out.println("  <param name=\"token_alias\" value=\"" + tokenAlias + "\">");
		out.println("  <param name=\"token_key_identifier\" value=\"" + tokenKeyIdentifier + "\">");
		out.println("  <param name=\"token_pkcs11_library\" value=\"" + tokenPkcs11Library + "\">");
		out.println("  <param name=\"token_so_pin\" value=\"" + tokenSoPin + "\">");
		out.println("  <param name=\"token_generate_new_so_pin\" value=\"false\">");
        out.println("  <param name=\"foreground_color\" value=\"" + foreground + "\">");
		out.println("  <param name=\"background_color\" value=\"" + background + "\">");
		out.println("  <param name=\"password_label_width\" value=\"200\">");
		out.println("  </applet>");
		out.println("</div>");
		
	}
	
	public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

}
