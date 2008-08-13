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
package fr.cg95.cvq.fo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;

import com.entrouvert.lasso.Defederation;
import com.entrouvert.lasso.Identity;
import com.entrouvert.lasso.LibAuthnRequest;
import com.entrouvert.lasso.LibLogoutResponse;
import com.entrouvert.lasso.Login;
import com.entrouvert.lasso.Logout;
import com.entrouvert.lasso.SamlpStatus;
import com.entrouvert.lasso.Server;
import com.entrouvert.lasso.Session;
import com.entrouvert.lasso.StringList;
import com.entrouvert.lasso.lasso;

/**
 * @author René le CLERCQ
 */
public class LassoServlet extends HttpServlet {

    public static final String LASSO_ID = "lassoid";

    private static final String LASSO_CREATE = "lassocreate";
    private static final String LASSO_LOGIN = "lassologin";
    
    private static final Category _logger = Category.getInstance(LassoServlet.class);

    private static LassoServlet _instance = null;

    private static Server lassoServer = null;
    private static HashMap lassoRequests = new HashMap();
    
    /**
     * Returns the unique _instance of this class.
     */
    public static LassoServlet getInstance() {
        return _instance;
    }

    /**
     */
    public void init() throws ServletException {

        if (_instance != null) {
            _logger.fatal("Initializer executing multiple times.  Aborting.");
            return;
        } else {
            _instance = this; 
        }

        // Initialise Liberty Alliance Single Sign-On (Lasso)
        if (lassoServer == null) {
            lasso.init();
    
            lassoServer = new Server(getServletContext().getRealPath("lasso/fo-metadata.xml"), 
                                    getServletContext().getRealPath("lasso/pem/fo-sign-private-key.pem"), 
                                    getServletContext().getRealPath("lasso/pem/fo-sign-public-key.pem"), null);
            lassoServer.addProvider(lasso.PROVIDER_ROLE_IDP, getServletContext().getRealPath("lasso/metadata.xml.idp"),
                    getServletContext().getRealPath("lasso/idppub.pem.idp"), null);
        }
    }

    /**
     */
    public void destroy() {
        // Shutdown Liberty Alliance (Lasso)
        lasso.shutdown();

    }

    protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) 
            throws ServletException, IOException {

        System.out.println("IDP response: " + pRequest.getSession().getId());
        
        String idpMessage = pRequest.getQueryString();
        Login spLogin = new Login(lassoServer);
        spLogin.initRequest(idpMessage, lasso.HTTP_METHOD_REDIRECT);
        spLogin.buildRequestMsg();

        try {
            String soapResponse = sendSoapRequest(spLogin.getMsgUrl(), spLogin.getMsgBody());

            spLogin.processResponseMsg(soapResponse);

            spLogin.acceptSso();

            String nameIdentifier = spLogin.getNameIdentifier().getContent();

            pRequest.getSession().setAttribute(Session.class.getName(), spLogin.getSession().dump());
            pRequest.getSession().setAttribute(Identity.class.getName(), spLogin.getIdentity().dump());

            String requestId = getAssertionResponseToValue(soapResponse);
            String action = (requestId == null) ? null : (String)lassoRequests.remove(requestId);

            if ((action != null) && (action.equals(LASSO_CREATE)))
                pResponse.sendRedirect("citizen_validationAction.do?" + LASSO_ID + "=" + nameIdentifier);
            else //if (action.equals(LASSO_LOGIN))
                pResponse.sendRedirect("personal_loginAction.do?" + LASSO_ID + "=" + nameIdentifier);

        } catch (Exception e) {
            _logger.error("", e);
        }
    }

    public static void createAccount(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        
        int httpMethod = lasso.HTTP_METHOD_REDIRECT;
        String nameIdPolicy = lasso.LIB_NAMEID_POLICY_TYPE_FEDERATED;
        String consent = lasso.LIB_CONSENT_OBTAINED;
        boolean isPassive = false;
        
        /* SP with Liberty Artifact method */
        Login spLogin = new Login(lassoServer);
        StringList remoteProviderIds = lassoServer.getProviderIds();
        spLogin.initAuthnRequest(remoteProviderIds.getItem(0), httpMethod);

        LibAuthnRequest authnRequest;
        authnRequest = (LibAuthnRequest) spLogin.getRequest();

        if (nameIdPolicy != null) {
            authnRequest.setNameIdPolicy(nameIdPolicy);
        }
        if (consent != null) {
            authnRequest.setConsent(consent);
        }
        if (isPassive == false) {
            authnRequest.setIsPassive(isPassive);
        }

        spLogin.buildAuthnRequestMsg();

        String spMessage = spLogin.getMsgUrl();
        String requestId = spLogin.getRequest().getRequestId();
        lassoRequests.put(requestId, LASSO_CREATE);

        try {
            pResponse.sendRedirect(spMessage);
        } catch (IOException e) {
            _logger.error("singleSignOn",e);
        }
    }

    public static void singleSignOn(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        
        System.out.println("SignOn demand: " + pRequest.getSession().getId());
        
        int httpMethod = lasso.HTTP_METHOD_REDIRECT;
        String nameIdPolicy = lasso.LIB_NAMEID_POLICY_TYPE_FEDERATED;
        String consent = lasso.LIB_CONSENT_OBTAINED;
        boolean isPassive = false;
        
        /* SP with Liberty Artifact method */
        Login spLogin = new Login(lassoServer);
        StringList remoteProviderIds = lassoServer.getProviderIds();
        spLogin.initAuthnRequest(remoteProviderIds.getItem(0), httpMethod);

        LibAuthnRequest authnRequest;
        authnRequest = (LibAuthnRequest) spLogin.getRequest();

        if (nameIdPolicy != null) {
            authnRequest.setNameIdPolicy(nameIdPolicy);
        }
        if (consent != null) {
            authnRequest.setConsent(consent);
        }
        if (isPassive == false) {
            authnRequest.setIsPassive(isPassive);
        }
        spLogin.buildAuthnRequestMsg();

        // String spMessage = spLogin.getMsgBody();
        String spMessage = spLogin.getMsgUrl();
        String requestId = spLogin.getRequest().getRequestId();
        lassoRequests.put(requestId, LASSO_LOGIN);

        try {
            pResponse.sendRedirect(spMessage);
        } catch (IOException e) {
            _logger.error("singleSignOn",e);
        }
    }

    public static void singleSignOff(HttpSession httpSession, int httpMethod) {
        System.out.println("SignOff demand: " + httpSession.getId());

        String sessionDump = (String)httpSession.getAttribute(Session.class.getName());
        String identityDump = (String)httpSession.getAttribute(Identity.class.getName());
        
        Logout spLogout = new Logout(lassoServer);
        spLogout.setSessionFromDump(sessionDump);
        spLogout.setIdentityFromDump(identityDump);
        try {
            spLogout.initRequest(lassoServer.getProviderIds().getItem(0), httpMethod);
            spLogout.buildRequestMsg();
            String url = spLogout.getMsgUrl();
            String spMessage = spLogout.getMsgBody();
    
            String soapReponse = sendSoapRequest(url, spMessage);

            spLogout.processResponseMsg(soapReponse);
            LibLogoutResponse response = (LibLogoutResponse) spLogout.getResponse();
            SamlpStatus status = response.getStatus();
            System.out.println("Response status code : " + status.getStatusCode().getValue());

        } catch (Exception e) {
            _logger.error("singleSignOff",e);
        }
    }

    public static void defederate(HttpSession httpSession, int httpMethod) {
        /* SP */
        try {
            Defederation spDefederation = new Defederation(lassoServer);
            String identityDump = (String)httpSession.getAttribute(Identity.class.getName());
            
            Logout spLogout = new Logout(lassoServer);
            spDefederation.setIdentityFromDump(identityDump);
            spDefederation.initNotification(lassoServer.getProviderIds().getItem(0), httpMethod);
            spDefederation.buildNotificationMsg();
            String url = spDefederation.getMsgUrl();
            String spMessage = spDefederation.getMsgBody();
            
            String soapReponse = sendSoapRequest(url, spMessage);
    
            /* SP - IDP returns OK 204 without SOAP response */
        } catch (Exception e) {
            _logger.error("defederate",e);
        }
    }

    private static String sendSoapRequest(String soapUrl, String soapMessage) throws Exception {
        // String SOAPUrl = args[0];
        // String xmlFile2Send = args[1];

        String soapAction = "";

        // Create the connection where we're going to send the file.
        URL url = new URL(soapUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

        // Init SOAP connection and send the SOAP request message.
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String.valueOf(soapMessage.length()));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", soapAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.connect();

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(soapMessage.getBytes());
        out.close();

        int responseCode = httpConn.getResponseCode();
        
        // Read the response and write it to standard out.
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        String soapResponseMessage = "";

//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            soapResponseMessage = soapResponseMessage + inputLine;
//            System.out.println(inputLine);
//        }

        char cbuf[] = new char[1024];
        int len = 0;
        while ((len = in.read(cbuf,0,1024)) > 0) {
            soapResponseMessage += new String(cbuf, 0, len); 
        }
        in.close();

        httpConn.disconnect();
        return soapResponseMessage;
    }

    private String getAssertionResponseToValue(String soapResponse) {
        String requestId = null;
        int pos = soapResponse.indexOf("<saml:Assertion");
        if (pos > 0) {
            requestId = soapResponse.substring(pos);
            pos = requestId.indexOf("InResponseTo");
            if (pos > 0) {
	            requestId = requestId.substring(pos);
	            pos = requestId.indexOf('"');
	            requestId = requestId.substring(pos+1);
	            pos = requestId.indexOf('"');
	            requestId = requestId.substring(0,pos);
            } else {
            	requestId = null;
            }
        }
        return requestId;
    }
}