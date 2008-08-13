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
package fr.cg95.cvq.fo.taglib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.util.Constants;

/**
 */

public class DocumentExplainationTag extends BaseTag {
	static Logger logger = Logger.getLogger(DocumentExplainationTag.class);

	private static HashMap _documentTypePaths = null;

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();

			DocumentForm document = null;
			try {
				document = (DocumentForm) RequestUtils.lookup(pageContext,
						name, property, getScope());
			} catch (Exception e) {
			}
			BufferedReader in = null;

			if (document.getType().equals(
					Constants.DOMICILE_RECEIPT_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.DOMICILE_RECEIPT_DOCUMENT_TYPE)));
			}
			if (document.getType().equals(
					Constants.IDENTITY_RECEIPT_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.IDENTITY_RECEIPT_DOCUMENT_TYPE)));
			}

			if (document.getType().equals(
					Constants.FAMILY_NOTEBOOK_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.FAMILY_NOTEBOOK_DOCUMENT_TYPE)));
			}

			if (document.getType().equals(
					Constants.MEDICAL_CERTIFICATE_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.MEDICAL_CERTIFICATE_DOCUMENT_TYPE)));
			}

			if (document.getType().equals(
					Constants.HEALTH_NOTEBOOK_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.HEALTH_NOTEBOOK_DOCUMENT_TYPE)));
			}

			if (document.getType().equals(
					Constants.VACATING_CERTIFICATE_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.VACATING_CERTIFICATE_DOCUMENT_TYPE)));
			}

			if (document.getType().equals(
					Constants.BIRTH_CERTIFICATE_DOCUMENT_TYPE)) {
				in = new BufferedReader(new FileReader(
						(String) getDocumentTypePaths(pageContext).get(
								Constants.BIRTH_CERTIFICATE_DOCUMENT_TYPE)));
			}

			if (null != in) {
				String str;
				while ((str = in.readLine()) != null) {
					out.println(str);
				}
				in.close();
			}

		} catch (Exception ignored) {
			logger.debug(ignored.toString());
		}
		return EVAL_PAGE;
	}

	private HashMap getDocumentTypePaths(PageContext pPageContext) {
		if (_documentTypePaths == null) {
			_documentTypePaths = new HashMap();

			String basePath = pPageContext.getSession().getServletContext()
					.getRealPath("");

			_documentTypePaths.put(Constants.DOMICILE_RECEIPT_DOCUMENT_TYPE,
					basePath + Constants.DOMICILE_RECEIPT_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(IDENTITY_RECEIPT_DOCUMENT_TYPE, basePath
					+ Constants.IDENTITY_RECEIPT_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(FAMILY_NOTEBOOK_DOCUMENT_TYPE, basePath
					+ Constants.FAMILY_NOTEBOOK_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(MEDICAL_CERTIFICATE_DOCUMENT_TYPE, basePath
					+ Constants.MEDICAL_CERTIFICATE_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(HEALTH_NOTEBOOK_DOCUMENT_TYPE, basePath
					+ Constants.HEALTH_NOTEBOOK_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(VACATING_CERTIFICATE_DOCUMENT_TYPE, basePath
					+ Constants.VACATING_CERTIFICATE_DOCUMENT_TYPE_PATH);

			_documentTypePaths.put(BIRTH_CERTIFICATE_DOCUMENT_TYPE, basePath
					+ Constants.BIRTH_CERTIFICATE_DOCUMENT_TYPE_PATH);
		}
		return _documentTypePaths;
	}
}