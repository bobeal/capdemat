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

/*
 */

package fr.cg95.cvq.bo;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This class provides localized labels for many items used in the view part of
 * the application.
 */
public class Localization {

	/**
	 * The formatter used to format all dates to strings.
	 */
	private static SimpleDateFormat simpleDateFormat =
		new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

	/**
	 * The formatter used to format all dates to strings.
	 */
	private static SimpleDateFormat longDateFormat =
		new SimpleDateFormat("d MMMMMM yyyy", Locale.FRANCE);

	/**
	 * The formatter used to format all dates to date and time strings.
	 */
	private static SimpleDateFormat simpleDateTimeFormat =
		new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);

    private static SimpleDateFormat monthYearFormat =
        new SimpleDateFormat("MMM yyyy", Locale.FRANCE);

	/**
	 * Returns the formatter used to format all dates to strings.
	 *
	 * @todo this mecanism should be localized to return a localized formatter.
	 */
	public static SimpleDateFormat getDateFormatter() {
		return simpleDateFormat;
	}

	/**
	 * Returns the formatter used to format all dates to strings.
	 *
	 * @todo this mecanism should be localized to return a localized formatter.
	 */
	public static SimpleDateFormat getLongDateFormatter() {
		return longDateFormat;
	}

	/**
	 * Returns the formatter used to format all dates to date and time strings.
	 *
	 * @todo this mecanism should be localized to return a localized formatter.
	 */
    public static SimpleDateFormat getDateTimeFormatter() {
        return simpleDateTimeFormat;
    }
    
    public static SimpleDateFormat getMonthYearFormatter() {
        return monthYearFormat;
    }
    
	public static String toString(Object object) {
		
		if (object == null)
			return "";
			
		if (object instanceof Boolean) {
			if ( ((Boolean)object).booleanValue())
				return "Oui";
			else
				return "Non";
		}

		return object.toString();
	}

}
