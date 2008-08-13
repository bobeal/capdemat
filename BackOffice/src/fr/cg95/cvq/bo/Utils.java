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

package fr.cg95.cvq.bo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Various utility functions to handle the presentation layer oddities (escaping quotes, etc.)
 */
public class Utils {

    /**
     * Converts problem characters to JavaScript Escaped values.
     */
    public static String convJS(Object s) {
        if (s == null) {
            return "";
        }

        String t = (String) s;
        t = replace(t, "\\", "\\\\"); // replace backslash with \\
        t = replace(t, "'", "\\\'"); // replace an single quote with \'
        t = replace(t, "\"", "\\\""); // replace a double quote with \"
        t = replace(t, "\r", "\\r"); // replace CR with \r;
        t = replace(t, "\n", "\\n"); // replace LF with \n;

        return t;
    }

    public static String convJSandHTML(Object s) {
        if (s == null) {
            return "";
        }

        String t = (String) s;
        t = replace(t, "\\", "\\\\"); // replace backslash with \\
        t = replace(t, "'", "\\\'"); // replace an single quote with \'
        // t = replace(t,"\"","\\\""); // replace a double quote with \"
        t = replace(t, "\"", "&quot;");
        t = replace(t, "\r", "\\r"); // replace CR with \r;
        t = replace(t, "\n", "\\n"); // replace LF with \n;

        return t;
    }

    public static String decodeDoubleQuotes(Object s) {
        if (s == null) {
            return "";
        }

        String t = (String) s;
        t = replace(t, "&quot;", "\"");

        return t;
    }

    /**
     * Replaces in a string one substring with another.
     */
    private static String replace(String s, String one, String another) {
        if (s.equals(""))
            return "";
        String res = "";
        int i = s.indexOf(one, 0);
        int lastpos = 0;
        while (i != -1) {
            res += s.substring(lastpos, i) + another;
            lastpos = i + one.length();
            i = s.indexOf(one, lastpos);
        }
        res += s.substring(lastpos); // the rest
        return res;
    }

    /**
     * Returns the given date as a string using the application default date formatter which is supposed to be
     * localized.
     */
    public static String getDateAsString(Date date) {
        String dateAsString;

        try {
            if (date == null) {
                return "";
            } else {
                dateAsString = Localization.getDateFormatter().format(date);
                return dateAsString;
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return "";
    }

    /**
     * Returns the given date as a date time string using the application default date formatter which is
     * supposed to be localized.
     */
    public static String getDateAsTimeString(Date date) {
        String dateAsString;

        try {
            if (date == null) {
                return "";
            } else {
                dateAsString = Localization.getDateTimeFormatter().format(date);
                return dateAsString;
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return "";
    }

    /**
     * Returns the given date as a string using the application default date formatter which is supposed to be
     * localized.
     */
    public static Date getStringAsDate(String date) {
        Date stringAsDate;

        try {
            if (date == null) {
                return null;
            } else {
                stringAsDate = Localization.getDateFormatter().parse(date);
                return stringAsDate;
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the given date as a string using the application default date formatter which is supposed to be
     * localized.
     */
    public static Date getTimeStringAsDate(String date) {
        Date stringAsDate;

        try {
            if (date == null) {
                return null;
            } else {
                stringAsDate = Localization.getDateTimeFormatter().parse(date);
                return stringAsDate;
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    public static String getDateAsMonthYearString(Date date) {
        String dateAsString;

        try {
            if (date == null) {
                return "";
            } else {
                dateAsString = Localization.getMonthYearFormatter().format(date);
                return dateAsString;
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return "";
    }
    
    public static boolean removeDir(File dir) {
        boolean ok = true;

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                ok = ok && removeDir(files[i]);
            }
        }
        return ok && dir.delete();
    }

    private static final Class[] parameters = new Class[]{URL.class};
     
    public static void addFileToClasspath(String s) throws IOException {
        File f = new File(s);
        addFileToClasspath(f);
    }
     
    public static void addFileToClasspath(File f) throws IOException {
        addURLToClasspath(f.toURL());
    }
     
    public static void addURLToClasspath(URL u) throws IOException {
            
        URLClassLoader sysloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        Class sysclass = URLClassLoader.class;
     
        try {
            Method method = sysclass.getDeclaredMethod("addURL",parameters);
            method.setAccessible(true);
            method.invoke(sysloader,new Object[]{ u });
        } catch (Throwable t) {
            t.printStackTrace();
            throw new IOException("Error, could not add URL to system classloader");
        }
    }
         

}
