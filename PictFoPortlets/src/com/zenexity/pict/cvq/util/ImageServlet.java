package com.zenexity.pict.cvq.util;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zenexity.pict.cvq.fo.util.FoHttpInvoker;

import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.exception.CvqException;

public class ImageServlet extends HttpServlet {

	private Log logger = LogFactory.getLog(ImageServlet.class);
	private FoHttpInvoker foHttpInvoker;
	
	public void init() throws ServletException {
	    logger.debug("init() Image servlet is initializing");

		WebApplicationContext wac = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		foHttpInvoker = (FoHttpInvoker) wac.getBean("foHttpInvoker");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws javax.servlet.ServletException, java.io.IOException {

		logger.debug("doGet() called with " + req.getQueryString());
		
		if (req.getParameter("documentId") != null) {
			logger.debug("doGet() search a document image : ");
			String name = req.getParameter("name");
			String documentId = req.getParameter("documentId");
//			String pageId = req.getParameter("pageId");
			Set<DocumentBinary> data;
			try {
				data = foHttpInvoker.getDocumentData(name, Long.valueOf(documentId));
			} catch (NumberFormatException e) {
	
				throw new ServletException("Invalid document id provided");
			} catch (CvqException e) {
				throw new ServletException("CVQ Exception");
			}
			
			ServletOutputStream output = resp.getOutputStream();
			if (data.size() > 0) {
				DocumentBinary docBinary = data.iterator().next();
				output.write(docBinary.getData());
			} else {
				return;
			}
		}
	}
}
