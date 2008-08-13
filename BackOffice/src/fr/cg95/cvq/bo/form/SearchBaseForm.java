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
package fr.cg95.cvq.bo.form;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.record.IResultRecord;

/**
 * Base class for all search forms Defines fields and methods that help managing
 * the display of search results Also implements some sorting methods
 * 
 * @author René le CLERCQ
 */
public class SearchBaseForm extends ActionForm {

	private static final long serialVersionUID = -654488529709431512L;

	private static org.apache.log4j.Category cat = org.apache.log4j.Category
			.getInstance(SearchBaseForm.class);

	public static int ASC_SORT = 0;

	public static int DEC_SORT = 1;

	/**
	 * total nb of records returned by the query used for display purposes
	 */
	private long totalRecordNb;

	/**
	 * current position in the result records used for display purposes
	 */
	private long currentRecord;

	/**
	 * current page result displayed used for display purposes only
	 */
	private int displayedPage;

	/**
	 * last field on which a sort has been asked used to invert sort order
	 * (ascending, descending)
	 */
	private String lastSortedField;

	/** last sort order used */
	private int sortOrder = ASC_SORT;

	/** search results array */
	protected ArrayList wholeResultsList;

	public SearchBaseForm() {
		totalRecordNb = 0;
		currentRecord = 0;
		displayedPage = 1;
	}

	/**
	 * Make a sort on the given field
	 */
	public void sortBy(String field) {
		sortBy(field, wholeResultsList);
	}

	public void sortBy(String field, Collection list) {
		initSortEnv(field);
		if (list == null)
			list = wholeResultsList;

		Object[] objs = list.toArray();
		sort(objs, field);
		// put objects back in the array list
		if (objs != null) {
			list.clear();
            if (sortOrder == ASC_SORT) {
    			for (int i = 0; i < objs.length; i++)
    				list.add(objs[i]);
            } else {
                for (int i = objs.length - 1; i >= 0; i--)
                    list.add(objs[i]);
            }
		}
	}

	/**
	 * Keep a trace of last sorted field and revert sort if needed (two
	 * consecutive calls on the same field reverts the sort)
	 */
	public int initSortEnv(String field) {
		// the very first search
		if (lastSortedField == null) {
			// sorting on a new field, re-init values
			lastSortedField = field;
			sortOrder = ASC_SORT;
		} else if (lastSortedField.equals(field)) {
			// previous sort was on this field, just invert order
			if (sortOrder == ASC_SORT)
				sortOrder = DEC_SORT;
			else
				sortOrder = ASC_SORT;
		} else {
			// sorting on a new field, re-init values
			lastSortedField = field;
			sortOrder = ASC_SORT;
		}
        return sortOrder;
	}

	/**
	 * sort the results set using the given method name
	 * 
	 * @param objs
	 *            results array
	 * @param methodName
	 *            method name (usually, a getXXX() method), supposed to have a
	 *            non-void return type on which we can do the comparison
	 * @return the ordered results array
	 */
	protected Object[] sort(Object[] objs, String methodName) {
		if (objs == null || objs.length == 0)
			return objs;

		Method meth = null;
		try {
			PropertyDescriptor p = PropertyUtils.getPropertyDescriptor(objs[0],
					methodName);

			meth = p.getReadMethod();
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}

		// do the sort
		Arrays.sort(objs, new MyComparator(meth));
		return objs;
	}

	/**
	 * our own comparison class
	 */
	private class MyComparator implements Comparator {
		private Method comparisonMethod;

		private Class returnTypeClass;

		public MyComparator(Method m) {
			this.comparisonMethod = m;
			this.returnTypeClass = m.getReturnType();
			if (cat.isDebugEnabled())
				cat.debug("Created a new comparator for method " + m.getName()
						+ " with return type of " + returnTypeClass.getName());
		}

		public int compare(Object o1, Object o2) {
			// Check the objects are loaded
			if (o1 instanceof IResultRecord)
				((IResultRecord) o1).load();

			if (o2 instanceof IResultRecord)
				((IResultRecord) o2).load();

			// get the values to compare
			Object res1 = "";
			Object res2 = "";
			try {
				res1 = comparisonMethod.invoke(o1, null);
				res2 = comparisonMethod.invoke(o2, null);
			} catch (Exception e) {
				if (cat.isDebugEnabled())
					cat.debug("Got exception when comparing objects : " + e);
				return 0;
			}
			if (returnTypeClass.getName().equals("java.lang.String")) {
				if (res1 == null || res1.equals("")) {
					if (res2 == null || res2.equals(""))
						// both null so they are equals
						return 0;
					else
						// res2 not null so it's greater than res1
						return 1;
				} else if (res2 == null || res2.equals("")) {
					// res1 not null so it's greater than res2
					return -1;
				} else {
						return ((String) res1)
								.compareToIgnoreCase((String) res2);
				}
			} else if (returnTypeClass.getName().equals("java.util.Date")) {
				if (res1 == null) {
					if (res2 == null)
						// both null so they are equals
						return 0;
					else
						// res2 not null so it's greater than res1
						return 1;
				} else if (res2 == null) {
					// res1 not null so it's greater than res2
					return -1;
				} else {
						return ((Date) res1).compareTo((Date) res2);
				}
			} else if (returnTypeClass.getName().equals("[Ljava.lang.String;")) {
				String[] resStr1 = (String[]) res1;
				String[] resStr2 = (String[]) res2;
				String test1 = null;
				String test2 = null;
				if (resStr1 != null)
					test1 = resStr1[0];
				if (resStr2 != null)
					test2 = resStr2[0];
				if (test1 == null || test1.equals("")) {
					if (test2 == null || test2.equals(""))
						// both null, return equals
						return 0;
					else
						// whatever the value of resStr2, it must appear before
						// resStr2 coz' it's non null
						return 1;
				} else if (test2 == null || test2.equals("")) {
					// we want non null values first
					return -1;
				} else {
					// we only compare the first value of the array ...
						return test1.compareToIgnoreCase(test2);
				}
			} else if (returnTypeClass.getName().equals("java.lang.Integer")) {
					return ((Integer) res1).compareTo((Integer) res2);
			} else if (returnTypeClass.getName().equals("java.lang.Long")) {
				if (res1 == null) {
					if (res2 == null)
						// both null, return equals
						return 0;
					else
						// whatever the value of res2, it must appear before res
						// coz' it's non null
						return 1;
				} else if (res2 == null) {
					// we want non null values first
					return -1;
				} else {
						return ((Long) res1).compareTo((Long) res2);
				}
			} else if (returnTypeClass.getName().equals("boolean")) {
				Boolean bRes1 = (Boolean) res1;
				Boolean bRes2 = (Boolean) res2;
				if (bRes1.equals(bRes2))
					return 0;

					if (bRes1.booleanValue() == true)
						return 1;
					else
						return -1;
			} else {
				if (res1 != null) {
					if (cat.isDebugEnabled())
						cat.debug("Unsupported comparison type : "
								+ res1.getClass().getName());
				} else {
					if (cat.isDebugEnabled())
						cat
								.debug("Unsupported comparison type on a null result");
				}
				return 0;
			}
		}
	}

	public void setWholeResultsList(ArrayList results) {
		if (results == null)
			totalRecordNb = 0;
		else
			totalRecordNb = results.size();

		this.wholeResultsList = results;
	}

	public ArrayList getWholeResultsList() {
		return this.wholeResultsList;
	}

	public long getTotalRecordNb() {
		return totalRecordNb;
	}

	public void setTotalRecordNb(long totalRecordNb) {
		this.totalRecordNb = totalRecordNb;
	}

	public long getCurrentRecord() {
		return currentRecord;
	}

	public void setCurrentRecord(long currentRecord) {
		this.currentRecord = currentRecord;
	}

	public int getDisplayedPage() {
		return displayedPage;
	}

	public void setDisplayedPage(int displayedPage) {
		this.displayedPage = displayedPage;
	}

	/**
	 * Method reset
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

}
