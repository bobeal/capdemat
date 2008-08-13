/*
 * Cartevaloise
 * 
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 * 
 * Managed and developed by 
 *      Bruno Perrin, Philippe Usclade and René le Clercq
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

package fr.cg95.cvq.fo.common.form;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.struts.validator.ValidatorForm;

import fr.cg95.cvq.fo.dispatcher.DispatchFilter;

public class RulesForm extends ValidatorForm {

	static Logger logger = Logger.getLogger(RulesForm.class);

	private String _content;
	private String _title;

	/**
	 * @return Returns the content.
	 */
	public String getContent() {
		return _content;
	}
	/**
	 * @param pContent The content to set.
	 */

	public void setContent(String fileName) {
		File file = DispatchFilter.getAssetsFile(fileName);
		if (file.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				int length = fis.available();
				byte buffer[] = new byte[length];
				fis.read(buffer);
				_content = new String(buffer);
				fis.close();
			} catch (IOException ioe) {
				logger.error("setContent", ioe);
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException io) {
					}
				}
			}
		}
	}
	
	public String getTitle() {
		return _title;
	}
	
	public void setTitle(String title) {
		_title = title;
	}

}