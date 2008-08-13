/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.fo.dispatcher;

import java.io.File;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;

import fr.cg95.cvq.fo.util.FileManager;

/**
 * This servlet actually serves nothing - it is just a bootstrap so that we can
 * load our startup code before any request is served.
 */
public class StartupServlet extends GenericServlet {

	public static final String WEBAPP_TEMP_DIR = "temp";
	public static final String WEBAPP_MODEL_DIR = "xsl";

	private static final Category _logger = Category.getInstance(StartupServlet.class);

	private static StartupServlet _instance;

	/**
	 * Returns the unique _instance of this class.
	 */
	public static StartupServlet getInstance() {
		return _instance;
	}

	/**
	 * Starts up the web environment for CVQ by loading the specified
	 * initializer script. May only be run once.
	 * <p>
	 * Cleanup temp directory, eg. remove files that may have been left after a
	 * "wild" shutdown
	 */
	public void init() throws ServletException {

		_logger.debug("init()");
		if (_instance != null) {
			_logger.fatal("Initializer executing multiple times.  Aborting.");
			return;
		} else {
			_instance = this;
		}

		// Remove temporary files created for all session
		FileManager.removeDir(getTempAppDir(getServletContext()));
	}

	/**
	 * Cleanup temp directory
	 */
	public void destroy() {
		_logger.debug("destroy()");

		// Remove temporary files created for all session
		FileManager.removeDir(getTempAppDir(getServletContext()));
	}

	/**
	 * This servlet serves nothing.
	 */
	public void service(ServletRequest pRequest, ServletResponse pResponse) {
	}

	public static File getModelAppDir() {
		
		String dir = getInstance().getServletContext().getRealPath(WEBAPP_MODEL_DIR);
		File modelAppDir = new File(dir);

		return modelAppDir;
	}

	public static File getModelAppFile(String fileName) {
		
		return new File(getModelAppDir(),fileName);
	}

	public static File getAppFile(String fileName) {
		String file = getInstance().getServletContext().getRealPath(fileName);
		return new File(file);
	}

	public static File getTempAppDir(ServletContext servletContext) {
		String dir = servletContext.getRealPath(StartupServlet.WEBAPP_TEMP_DIR);
		return new File(dir);
	}

	public static File getTempContextDir(HttpSession session) {
		String dir = session.getServletContext().getRealPath(StartupServlet.WEBAPP_TEMP_DIR);
		dir = dir + File.separator + session.getId();
		return new File(dir);
	}

	public static File getTempContextFile(HttpSession session, String prefix) throws IOException {
		return getTempContextFile(session, prefix, "");
	}

	public static File getTempContextFile(HttpSession session, String prefix, String suffix) throws IOException {
		File tempDir = getTempContextDir(session);

		tempDir.mkdirs();

		return File.createTempFile(prefix, suffix, tempDir);
	}

	public static String getFileContextName(HttpServletRequest request, File file) {
		return request.getContextPath()
			+ "/"
			+ StartupServlet.WEBAPP_TEMP_DIR
			+ "/"
			+ request.getSession().getId()
			+ "/"
			+ file.getName();
	}

}