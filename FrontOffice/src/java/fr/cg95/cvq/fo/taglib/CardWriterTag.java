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

package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.util.Constants;

/**
 * @author René le CLERCQ
 */
public class CardWriterTag extends BaseTag {
	String validate;
	String action;
	String left;
	String top;
		
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

			appletTag(out,foreground, background);
			
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
			"archive=\"LPApplets.jar,bcprov.jar,lp-applet-util.jar,iaik_jce.jar,iaikPkcs11Provider.jar\" " +
			"code=\"com.lexpersona.applet.lpgencert.LPGenCert\" " +
			"codebase=\"applets\" " +
			"name=\"LPGenCert\" " +
			"width=\"340\" " +
			"height=\"150\">");

		HttpSession session = pageContext.getSession();

		String cookieSessionId = "JSESSIONID=" + session.getId();
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		URL url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/cardAction.do?action=write");
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
		String tokenRsaKeySize = "1024";
		String tokenRsaExponent = "65537";
		String tokenSoPin = "11111111";

		AdultForm adult = (AdultForm)session.getAttribute(Constants.ADULT_FORM);
		String certificateCommonName = adult.getFullName("");
		String certificateOrganization = "";
		String certificateState = "France";
		String certificateCity = adult.getCity();
		String certificateMail = adult.getEmail();

        int fg = Integer.parseInt(foreground.substring(1), 16);
        foreground = String.valueOf(fg);
		int bg = Integer.parseInt(background.substring(1), 16);
		background = String.valueOf(bg);
		
		long startDate = System.currentTimeMillis();
		long endDate = startDate + 365 * 24 * 60 * 60 * 1000;

		out.println("  <param name=\"keystore_type\" value=\"pkcs11\">");
		out.println("  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
		out.println("  <param name=\"url_next_page\" value=\"" + urlNextPage + "\">");
		out.println("  <param name=\"url_post_request\" value=\"" + urlPostRequest + "\">");
		out.println("  <param name=\"token_alias\" value=\"" + tokenAlias + "\">");
		out.println("  <param name=\"token_key_identifier\" value=\"" + tokenKeyIdentifier + "\">");
		out.println("  <param name=\"token_pkcs11_library\" value=\"" + tokenPkcs11Library + "\">");
		out.println("  <param name=\"token_rsa_key_size\" value=\"" + tokenRsaKeySize + "\">");
		out.println("  <param name=\"token_rsa_exponent\" value=\"" + tokenRsaExponent + "\">");
		out.println("  <param name=\"token_so_pin\" value=\"" + tokenSoPin + "\">");
		out.println("  <param name=\"token_generate_new_so_pin\" value=\"false\">");

		out.println("  <param name=\"certificate_common_name\" value=\"" + certificateCommonName + "\">");
		if ((certificateOrganization != null) && (certificateOrganization.length() > 0))
			out.println("  <param name=\"certificate_organization\" value=\"" + certificateOrganization + "\">");
		out.println("  <param name=\"certificate_state\" value=\"" + certificateState + "\">");
		if ((certificateCity != null) && (certificateCity.length() > 0))
			out.println("  <param name=\"certificate_city\" value=\"" + certificateCity + "\">");
		if ((certificateMail != null) && (certificateMail.length() > 0))
			out.println("  <param name=\"certificate_mail\" value=\"" + certificateMail + "\">");
		out.println("  <param name=\"certificate_validity_not_before\" value=\""+ startDate +"\">");
		out.println("  <param name=\"certificate_validity_not_after\" value=\""+ endDate +"\">");
		out.println("  <param name=\"certificate_country_code\" value=\"FR\">");

        out.println("  <param name=\"foreground_color\" value=\"" + foreground + "\">");
		out.println("  <param name=\"background_color\" value=\"" + background + "\">");
		out.println("  <param name=\"password_label_width\" value=\"200\">");
		out.println("  </applet>");
		out.println("</div>");
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String string) {
		action = string;
	}

	public String getLeft() {
		return left;
	}

	public String getTop() {
		return top;
	}

	public void setLeft(String string) {
		left = string;
	}

	public void setTop(String string) {
		top = string;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String string) {
		validate = string;
	}

}
