/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq 
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

package fr.cg95.cvq.wizard;

import java.util.StringTokenizer;


public class StringUtils {

    public static String truncate(String value, Integer maxChars) {
        String result = "";
        StringTokenizer tokens = new StringTokenizer(value, " ");

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            
            if (token.length() > maxChars)
                token = token.substring(0,maxChars-3) + "...";

            result += token + " ";
        }
        if (result.length() > 0)
            return result.substring(0, result.length()-1);
        
        return result;
    }

    public static String truncateLine(String value, int maxChars) {
        if (value.length() > maxChars)
            return value.substring(0,maxChars-3) + "...";

        return value;
    }
    

    public static String split(String value, Integer maxChars) {
        final String BREAK_CHARACTER = "<wbr>";
        
        String result = "";
        StringTokenizer tokens = new StringTokenizer(value, " ");

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            
            while (token.length() > maxChars) {
                result += token.substring(0,maxChars) + BREAK_CHARACTER;
                token = token.substring(maxChars);
            }
            result += token + " ";
        }
        if (result.length() > 0)
            return result.substring(0, result.length()-1);
        
        return result;
    }

}
