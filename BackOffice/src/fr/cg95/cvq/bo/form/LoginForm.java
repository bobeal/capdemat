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

package fr.cg95.cvq.bo.form;

import org.apache.struts.action.ActionForm;

/**
 * This class encapsulates login information keyed in on the login screen
 * 
 * @author René le Clercq
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = -6963611788186900839L;

	/** username */
	private String username;
	/** user's password */
	private String password;
	private String cancel;

	/**
	 * Constructor
	 */
	public LoginForm() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCancel() {
		return cancel;
	}

	public void setCancel(String string) {
		cancel = string;
	}

}
