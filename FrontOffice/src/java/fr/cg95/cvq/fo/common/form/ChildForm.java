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

package fr.cg95.cvq.fo.common.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class ChildForm extends IndividualForm {

	private String _sex;

	private Collection _adultResponsibles = new Vector();

	/**
	 * @return Returns the sex.
	 */
	public String getSex() {
		return _sex;
	}

	/**
	 * @param pSex
	 *            The sex to set.
	 */
	public void setSex(String pSex) {
		_sex = pSex;
	}

	public int addAdultResponsible(AdultForm pAdultResponsible) {
		if (!_adultResponsibles.contains(pAdultResponsible))
			_adultResponsibles.add(pAdultResponsible);
        
        return ((Vector)_adultResponsibles).indexOf(pAdultResponsible);
	}

	public void removeAdultResponsible(AdultForm pAdultResponsible) {
		_adultResponsibles.remove(pAdultResponsible);
	}

	public void removeAllAdultResponsibles() {
		_adultResponsibles.clear();
	}

	public Collection getAdultResponsibles() {
		return _adultResponsibles;
	}

	public void setAdultResponsibles(Collection adultResponsibles) {
		_adultResponsibles = adultResponsibles;
	}

	public List getInternalAdultResponsibles() {

		List internalAdultResponsibles = new ArrayList();

		Iterator it = _adultResponsibles.iterator();

		while (it.hasNext()) {
			AdultForm adult = (AdultForm) it.next();
			if (!adult.isExternalToHomeFolder()) {
				internalAdultResponsibles.add(adult);
			}
		}
		return internalAdultResponsibles;
	}

	public List getExternalAdultResponsibles() {

		List externalAdultResponsibles = new ArrayList();

		Iterator it = _adultResponsibles.iterator();

		while (it.hasNext()) {
			AdultForm adult = (AdultForm) it.next();
			if (adult.isExternalToHomeFolder()) {
				externalAdultResponsibles.add(adult);
			}
		}
		return externalAdultResponsibles;
	}

	public String[] getAdultResponsibleIds() {

		String[] ids = new String[_adultResponsibles.size()];
		Iterator it = _adultResponsibles.iterator();
		int i = 0;
		while (it.hasNext()) {
			AdultForm adult = (AdultForm) it.next();
			Long id = adult.getId();
			if (null != id) {
				ids[i] = id.toString();
			}
			i++;
		}

		return ids;
	}

	public int getAdultResponsiblesNumber() {
		return _adultResponsibles.size();
	}

	public int getInternalAdultResponsiblesNumber() {
		return getInternalAdultResponsibles().size();
	}

	public int getExternalAdultResponsiblesNumber() {
		return getExternalAdultResponsibles().size();
	}

	/**
	 * @return Returns the adultResponsibleDefined.
	 */
	public boolean isAdultResponsibleDefined() {
		return !_adultResponsibles.isEmpty();
	}

	public AdultForm getAdultResponsible(AdultForm adult) {
		Iterator it = _adultResponsibles.iterator();
		while (it.hasNext()) {
			AdultForm responsible = (AdultForm) it.next();
			if (responsible.getLastName().equals(adult.getLastName()) &&
				responsible.getFirstName().equals(adult.getFirstName()))
				return responsible;
		}
		return null;
	}
	
}