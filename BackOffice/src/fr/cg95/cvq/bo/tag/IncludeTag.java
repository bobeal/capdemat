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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

/**
 * IncludeTag
 */
public class IncludeTag extends BaseTag {

	private static final long serialVersionUID = 5811627988011021858L;

	private String href = null;

	public IncludeTag() {
		super();
	}

	public String getHref() {
		return href;
	}

	public void setHref(String string) {
		href = string;
	}

	public int doEndTag() {
		InputStream in = null;
		try {
            setWindowIndex();
            
			JspWriter out = pageContext.getOut();

			Long id = null;
			try {
					id = (Long) RequestUtils.lookup(pageContext, name, property, getScope());
			} catch (Exception e) {
			}
			
			if (id != null) {
				URL externalUrl =
					new URL(
						"http",
						"127.0.0.1",
						pageContext.getRequest().getServerPort(),
						href + id);
	
				in = externalUrl.openStream();
	
				int bit = in.read();
				while (bit != -1) {
					out.write(bit);
					bit = in.read();
				}
				in.close();
			}
		} catch (IOException ioe) {
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ioe) {
			}
		}
		return EVAL_PAGE;
	}

}
