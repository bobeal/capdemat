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
package fr.cg95.cvq.generator.plugins.gui;

/**
 * @author René le CLERCQ
 */
public class FoPluginException extends Exception {

	private static final long serialVersionUID = 8471656331416735434L;

	public FoPluginException() {
		super();
	}

	public FoPluginException(String message) {
		super(message);
	}

	public FoPluginException(Throwable cause) {
		super(cause);
	}

	public FoPluginException(String message, Throwable cause) {
		super(message, cause);
	}

}
