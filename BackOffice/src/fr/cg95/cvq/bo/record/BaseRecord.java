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
 package fr.cg95.cvq.bo.record;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;

import fr.cg95.cvq.bo.Utils;

/**
 * @author René le CLERCQ
 */
public class BaseRecord implements IResultRecord, Cloneable {

	private static final long serialVersionUID = -2428737286200198876L;
	
	private BaseRecord original = null;
	private int modifyCount = 0; 
	
	/**
	 */
	public BaseRecord() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
    public Long getResultId() {
        return null;
    }
    
	public void load() {
	}

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

	public void reset() {
		try {
			original = (BaseRecord)clone();
		} catch (CloneNotSupportedException e) {
		}
		modifyCount = 0;
	}
	
	public void modify(String field, String[] val) {

		String value = (val == null) ? "" : trim(val[0]);

		// First modification, clone original object
		if (original == null)
			reset();
			
		try {
			Object orgValue = PropertyUtils.getProperty(original, field);
			Object curValue = PropertyUtils.getProperty(this, field);
			Object newValue = null;
			
            Class clazz = PropertyUtils.getPropertyType(this, field);
            String className = clazz.getName();
            
            if (curValue instanceof String[])
				newValue = (val == null) ? new String[0] : val;
			
			else if (value.length() == 0)
			;
            else if (className.equals(String.class.getName()))
				newValue = value;
				
            else if (className.equals(Long.class.getName()))
				newValue = new Long(value);
				
            else if (className.equals(Integer.class.getName()))
				newValue = new Integer(value);
				
            else if (className.equals(BigInteger.class.getName()))
				newValue = new BigInteger(value);
				
            else if (className.equals(Date.class.getName()))
                newValue = Utils.getStringAsDate(value);
                
            else if (className.equals(Calendar.class.getName())) {
                newValue = Calendar.getInstance();
                ((Calendar)newValue).setTime(Utils.getStringAsDate(value));
            }
            else if (className.equals(Boolean.class.getName()) ||
                    className.equals("boolean")) {
				if (value.equalsIgnoreCase("Oui"))
					newValue = Boolean.TRUE;

				else if (value.equalsIgnoreCase("Non"))
					newValue = Boolean.FALSE;
					
				else
					newValue = new Boolean(value);
			}
			else 
				newValue = value;				
				
			if (!equal(newValue, curValue)) {
				PropertyUtils.setProperty(this, field, newValue);

				// First modification: increment count
				if (equal(curValue,orgValue))
					modifyCount++;
					
				// We return to original value: decrement count
				else if (equal(newValue,orgValue))
					modifyCount--;
					
			}
						
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}
	}
	
	private boolean equal(Object o1, Object o2) {
		if (o1 == o2)
			return true;

		if ((o1 instanceof Object[]) && (o2 instanceof Object[]))
			return Arrays.equals((Object[])o1,(Object[])o2);
		
		if (o1 != null)
			return o1.equals(o2);

		return false;			
	}
	
	private String trim(String value) {
		int len = value.length();
		int st = 0;
		int off = 0;
		char[] val = value.toCharArray();

		while ((st < len) && ((val[off + st] <= ' ') || (val[off + st] == 160))) {
			st++;
		}
		while ((st < len) && ((val[off + len - 1] <= ' ') || (val[off + len - 1] == 160))) {
			len--;
		}
		return ((st > 0) || (len < value.length())) ? value.substring(st, len) : value;
	}
	
	public boolean isModified() {
		return modifyCount > 0;
	}

	public boolean isModified(String field) {
		// No modifycations have been made
		if (original == null)
			return false;
			
		// Check value difference
		try {
			Object orgValue = PropertyUtils.getProperty(original, field);
			Object curValue = PropertyUtils.getProperty(this, field);
			
			return !equal(curValue,orgValue); 
			
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}
		return false;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return null;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

}
