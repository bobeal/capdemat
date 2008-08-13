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
package fr.cg95.cvq.fo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class TimeHandler implements Constants {

	/**
	 * parse Date to String
	 * 
	 * @param pDate
	 * 
	 * @param pFormat
	 * 
	 * @return String value
	 *  
	 */
	public static String parseDate(Date pDate, String pFormat) {
	    if (pDate == null)
            return "";
        
        // create a date formatter
		DateFormat df = new SimpleDateFormat(pFormat, Locale.FRANCE);

		return df.format(pDate);
	}

	/**
	 * parse string to Date
	 * 
	 * @param strDate
	 * 
	 * @param pFormat
	 * 
	 * @return Date value
	 *  
	 */
	public static Date parseDate(String pStrDate, String pFormat)
			throws ParseException {
		// create a date formatter
		DateFormat df = new SimpleDateFormat(pFormat, Locale.FRANCE);
		Date date = null;

		date = df.parse(pStrDate);

		return date;
	}

	public static String convertDateJJMMAAAA(String pDay, String pMonth,
			String pYear) {

		String dateString = pDay + "/" + pMonth + "/" + pYear;
		return dateString;
	}
	
	
}