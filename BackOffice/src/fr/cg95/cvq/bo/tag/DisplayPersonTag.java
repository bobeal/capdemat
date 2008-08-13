/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
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
package fr.cg95.cvq.bo.tag;

import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.citizen.VoCardRequestRecord;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.wizard.StringUtils;

public class DisplayPersonTag extends BaseTag {

	private static final long serialVersionUID = -6996606696098341759L;

	private String type;

	public int doEndTag() {
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			VoCardRequestRecord record = 
				(VoCardRequestRecord) RequestUtils.lookup(pageContext, name, property, getScope());
				
			if (record != null) {
				boolean first = true;
				FamilyRecord familyRecord = record.getFamily();

				Iterator iter = null;
				if (type.equals("adults"))
					iter = familyRecord.getAdults().iterator();

				else if (type.equals("children"))
					iter = familyRecord.getChildren().iterator();

				if (iter != null)
					while (iter.hasNext()) {
						IndividualRecord person = (IndividualRecord)iter.next();
						if (!first)
							out.print(" / ");
						else
							first = false;
						out.print(StringUtils.truncate(person.getName(), 27));
					}
			}
		} catch (Exception ignored) {
			ignored.getMessage();
		}
		return EVAL_PAGE;
	}

	/**
	 * @return
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @return
	 */
	public String getScope() {
		if (scope == null)
			scope="session";
			
		return scope;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param string
	 */
	public void setProperty(String string) {
		property = string;
	}

	/**
	 * @param string
	 */
	public void setScope(String string) {
		scope = string;
	}

	/**
	 * @param string
	 */
	public void setType(String string) {
		type = string;
	}

}
