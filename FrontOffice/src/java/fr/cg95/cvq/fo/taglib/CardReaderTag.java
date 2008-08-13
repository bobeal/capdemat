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


public class CardReaderTag extends BaseTag {
	String validate;
	String action;
	String left;
	String top;
	String control = null;
		
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
//            String background = ProcessWizardPlugin.getColor(site, ProcessWizardPlugin.STATE_COLOR_BACKGROUND);
            String foreground = "#7593b9";
            String background = "#fbe38b";

			if ((control != null) && control.equalsIgnoreCase("applet"))
				appletTag(out,foreground, background);
			else			
				activeXTag(out, background);	
			
		} catch (Exception ignored) {
		}
		return EVAL_PAGE;
	}
	
	private void appletTag(JspWriter out, String foreground, String background) throws IOException {
		String style = "";
		if (getStyleClass() != null)
			style = "class=\"" + getStyleClass() + "\" "; 
		out.println("<div " + style + "style=\"position:relative;left:" + left + "px;top:" + top + "px\">");

		out.println("		<div id=\"info\">");
//		out.println("		  Lecture de la carte en cours...");
		out.println("		</div>");
		out.println("		<br/>");
		out.println("	  <applet " +
			"archive=\"LPApplets.jar,bcprov.jar,lp-applet-util.jar,iaik_jce.jar,iaikPkcs11Provider.jar\" " +
			"code=\"com.lexpersona.applet.lpauth.LPAuth\" " +
			"codebase=\"applets\" " +
			"width=\"300\" " +
			"height=\"110\" " +
			"name=\"LPAuth\">");
		
		HttpSession session = pageContext.getSession();
		String cookieSessionId = "JSESSIONID=" + session.getId();
		String challenge = (String)session.getAttribute("challenge");
		String challengeDigestAlgorithm = (String)session.getAttribute("challengeDigestAlgorithm");

		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();

		URL url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/cardAction.do?action=read");
		String urlPostRequest = url.toString();

		url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/personal_loginAction.do?userName=user&password=password&method=card");
		String urlNextPage = url.toString();
		url =
			new URL(
				request.getScheme(),
				request.getServerName(),
				request.getServerPort(),
				request.getContextPath() + "/personal_displayLoginAction.do?action=update");
		String urlNoCertificate = url.toString();

        int fg = Integer.parseInt(foreground.substring(1), 16);
        foreground = String.valueOf(fg);
        int bg = Integer.parseInt(background.substring(1), 16);
        background = String.valueOf(bg);
		
		out.println("	  <param name=\"keystore_type\" value=\"pkcs11\">");
		out.println("	  <param name=\"cookie_session_id\" value=\"" + cookieSessionId + "\">");
		out.println("	  <param name=\"url_next_page\" value=\"" + urlNextPage + "\">");
		out.println("	  <param name=\"url_token_certificate_not_found\" value=\"" + urlNoCertificate + "\">");
		out.println("	  <param name=\"url_post_request\" value=\"" + urlPostRequest + "\">");
		out.println("	  <param name=\"challenge\" value=\"" + challenge + "\">");
		out.println("	  <param name=\"challenge_digest_algorithm\" value=\"" + challengeDigestAlgorithm + "\">");
		out.println("	  <param name=\"token_alias\" value=\"CG95\">");
		out.println("	  <param name=\"token_key_identifier\" value=\"1\">");
		out.println("	  <param name=\"token_pkcs11_library\" value=\"slbCk.dll\">");
        out.println("     <param name=\"foreground_color\" value=\"" + foreground + "\">");
        out.println("     <param name=\"background_color\" value=\"" + background + "\">");
		out.println("	  <param name=\"password_label\" value=\"Entrez votre Mot de Passe :\">");
		out.println("	  <param name=\"password_label_width\" value=\"160\">");
		out.println("	  <param name=\"password_width\" value=\"120\">");

		out.println("	  </applet>");
		out.println("</div>");
	}
	
	private void activeXTag(JspWriter out, String background) throws IOException {
		String red = background.substring(1,3);
		String green = background.substring(3,5);
		String blue = background.substring(5);
			
		out.println("<SCRIPT LANGUAGE=\"VBS\">"); 

		out.println("Sub " + validate);
		out.println("Dim xmlhttp");
		out.println("Dim strParams");

		out.println("If AudWebAuth.Validate() <> 0 Then");
		out.println("	Exit Sub");
		out.println("End If");
	
		out.println("Set xmlhttp = CreateObject(\"Microsoft.XMLHTTP\")");

		out.println("Call xmlhttp.open(\"POST\", \"" + action + "\", false)");
		out.println("Call xmlhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\")");
		out.println("strPK = replace(replace(AudWebAuth.ResponseUserPublicKey,\"/\",\"%2F\"),\"+\",\"%2B\")");

		out.println("strParams = " +
			"\"userName=\" + AudWebAuth.ResponseUserFirstName + \".\"  + AudWebAuth.ResponseUserLastName + \"" +
			"&password=******&publicKey=\" + strPK");
		out.println("Call xmlhttp.send(strParams)");
		out.println("If xmlhttp.status <> 200 Then");
		out.println("MsgBox \"Erreur #\" + CStr(xmlhttp.status)");
		out.println("Else");
//		out.println("MsgBox  xmlhttp.getAllResponseHeaders()");
//		out.println("MsgBox  xmlhttp.getResponseHeader(\"CVQ-URL\")");
		
		out.println("Window.location=xmlhttp.getResponseHeader(\"CVQ-URL\")");
		out.println("End If");
    
    
		out.println("End Sub");

		out.println("</SCRIPT>");

		background = "&H00" + blue + green + red;
			
		out.println("<div style=\"position:relative;left:" + left + "px;top:" + top + "px\">");

		out.println("<OBJECT ID=\"AudWebAuth\" CLASSID=\"CLSID:50AF1219-9369-4B10-8DCE-39FF6FF22882\" HEIGHT=\"50\" WIDTH=\"210\">");
		out.println("<PARAM NAME=\"sig_location\" VALUE=\"token-pkcs11\">");
		out.println("<PARAM NAME=\"style_backcolor\" VALUE=\"" + background + "\">");
		out.println("</OBJECT>");

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

	public String getControl() {
		return control;
	}

	public void setControl(String string) {
		control = string;
	}

}
