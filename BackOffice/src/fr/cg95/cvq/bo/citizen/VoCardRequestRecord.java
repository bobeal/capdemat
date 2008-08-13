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
 package fr.cg95.cvq.bo.citizen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.ReferentialData;

/**
 * @author René le CLERCQ
 */
public class VoCardRequestRecord extends RequestRecord {

	private FamilyRecord family;
	private String publicKey;
	
	/**
	 */
	public VoCardRequestRecord() {
		super();
	}

	public FamilyRecord getFamily() {
		if (family == null)
			family = BusinessManager.findFamilyMembers(getFamilyId());
		return family;
	}


	/* (non-Javadoc)
	 * @see fr.cg95.cvq.bo.record.RequestRecord#getDataRecord(java.lang.Long)
	 */
	public BaseRecord getDataRecord(Long id) {

		ArrayList individuals = getFamily().getAdults();
		
		for (int i = 0; i < individuals.size(); i++) {
			if (((IndividualRecord)individuals.get(i)).getId().equals(id))
				return (BaseRecord)individuals.get(i);
		}

		individuals = getFamily().getChildren();
		
		for (int i = 0; i < individuals.size(); i++) {
			if (((IndividualRecord)individuals.get(i)).getId().equals(id))
				return (BaseRecord)individuals.get(i);
		}

		return super.getDataRecord(id);
	}

    public boolean isModified() {

        ArrayList individuals = getFamily().getAdults();
        
        for (int i = 0; i < individuals.size(); i++) {
            if (((IndividualRecord)individuals.get(i)).isModified())
                return true;
        }

        individuals = getFamily().getChildren();
        
        if (individuals != null) {
            for (int i = 0; i < individuals.size(); i++) {
                if (((IndividualRecord)individuals.get(i)).isModified())
                    return true;
            }
        }
        return super.isModified();
    }
    
	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String string) {
		if ((string != null) && (string.length() == 0))
			publicKey = null;
		else
			publicKey = string;
	}

}
