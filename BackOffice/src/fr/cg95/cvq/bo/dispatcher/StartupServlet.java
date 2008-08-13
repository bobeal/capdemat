/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq 
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

package fr.cg95.cvq.bo.dispatcher;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessManager;

/**
 * This servlet actually serves nothing - it is just a bootstrap so that we can
 * load our startup code before any request is served. 
 */
public class StartupServlet extends GenericServlet {

	/**
     * 
     */
    private static final long serialVersionUID = -8117914182235940976L;
    
    public static final String WEBAPP_ASSETS_DIR = "assets";
	public static final String WEBAPP_COMMON_DIR = "common";
	public static final String WEBAPP_MODEL_DIR = "xsl";
	public static final String WEBAPP_TEMP_DIR = "temp";
	
	private static final org.apache.log4j.Category logger =
		org.apache.log4j.Category.getInstance(StartupServlet.class);

	private static StartupServlet instance;

	/**
	 * Returns the unique instance of this class.
	 */
	public static StartupServlet getInstance() {
		if (instance == null)
			instance = new StartupServlet();
			
		return instance;
	}

	/**
	 * Starts up the web environment for CVQ by loading the
	 * specified initializer script. May only be run once.
	 * <p>
	 * Cleanup temp directory, eg. remove files that may have been left after a "wild" shutdown 
	 */
	public void init() throws ServletException {
	    logger.debug("init() Startup servlet is initializing");

		if (instance != null) {
			logger.fatal("Initializer executing multiple times.  Aborting.");
			return;
		} else {
			instance = this;
		}

		Utils.removeDir(getTempAppDir(getServletContext()));

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		BusinessManager.setApplicationContext(wac);
		
		SSLContextInit();
	}

	// In this function we configure our system with a less stringent
	// hostname verifier and X509 trust manager.  This code is
	// executed once, and calls the static methods of HttpsURLConnection
	public void SSLContextInit() {
		// Initialize the TLS SSLContext with our TrustManager
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
			X509TrustManager[] xtmArray = new X509TrustManager[] { new CvqX509TrustManager() };
			sslContext.init(null, xtmArray, new java.security.SecureRandom());
			logger.debug("SSLContext initialized with new TrustManager");
			
		} catch (GeneralSecurityException gse) {
			logger.error("SSLContextInit", gse);
		}
	
		// Set the default SocketFactory and HostnameVerifier for javax.net.ssl.HttpsURLConnection
		if (sslContext != null) {
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		}
		HttpsURLConnection.setDefaultHostnameVerifier(new CvqHostnameVerifier());
		logger.debug("New default HostnameVerifier");
	}


	/**
	 * Cleanup temp directory 
	 */
	public void destroy() {
		Utils.removeDir(getTempAppDir(getServletContext()));
	}

	/**
	 * This servlet serves nothing.
	 */
	public void service(ServletRequest request, ServletResponse response) {
	}

	public static File getModelAppDir(String site) {
		
		String dir = getInstance().getServletContext().getRealPath(WEBAPP_ASSETS_DIR);
		dir += File.separator + site + File.separator + WEBAPP_MODEL_DIR;
		
		File modelAppDir = new File(dir);

		if (!modelAppDir.exists()) {
			dir = getInstance().getServletContext().getRealPath(WEBAPP_ASSETS_DIR);
			dir += File.separator + WEBAPP_COMMON_DIR + File.separator + WEBAPP_MODEL_DIR;
			modelAppDir = new File(dir);
		} 
		return modelAppDir;
	}

	public static File getModelAppFile(String site, String fileName) {
		
		String dir = getInstance().getServletContext().getRealPath(WEBAPP_ASSETS_DIR);
		dir += File.separator + site + File.separator + WEBAPP_MODEL_DIR;
		
		File modelAppFile = new File(dir, fileName);

		if (!modelAppFile.exists()) {
			dir = getInstance().getServletContext().getRealPath(WEBAPP_ASSETS_DIR);
			dir += File.separator + WEBAPP_COMMON_DIR + File.separator + WEBAPP_MODEL_DIR;
			modelAppFile = new File(dir, fileName);
		} 
		return modelAppFile;
	}

	public static File getAppFile(String fileName) {
		String file = getInstance().getServletContext().getRealPath(fileName);
		return new File(file);
	}
    
    public static File getContextFile(HttpSession session, String fileName) {
        File tempDir = getTempContextDir(session);
        
        return new File(tempDir, fileName);
    }

	public static File getTempAppDir(ServletContext servletContext) {
		String dir = servletContext.getRealPath(StartupServlet.WEBAPP_TEMP_DIR);
		return new File(dir);
	}

	public static File getTempContextDir(HttpSession session) {
		String dir = session.getServletContext().getRealPath(StartupServlet.WEBAPP_TEMP_DIR);
		dir = dir + File.separator + session.getId();

        File tempDir = new File(dir);
        
        tempDir.mkdirs();
        
        return tempDir;
	}

	public static File getTempContextFile(HttpSession session, String prefix) throws IOException {
		return getTempContextFile(session, prefix, "");
	}
		
	public static File getTempContextFile(HttpSession session, String prefix, String suffix) throws IOException {
		File tempDir = getTempContextDir(session);

		return File.createTempFile(prefix, suffix, tempDir);
	}
	
    public static String getFileContextName(HttpServletRequest request, File file) {
        return getFileContextName(request, file.getName());
    }
    
    public static String getFileContextName(HttpServletRequest request, String fileName) {
		return 	request.getContextPath()
						+ "/"
						+ StartupServlet.WEBAPP_TEMP_DIR
						+ "/"
						+ request.getSession().getId()
						+ "/"
						+ fileName;
	}
	
	public static String getFileRelativeName(HttpServletRequest request, File file) {
		return 	"/"
						+ StartupServlet.WEBAPP_TEMP_DIR
						+ "/"
						+ request.getSession().getId()
						+ "/"
						+ file.getName();
	}
	
}
