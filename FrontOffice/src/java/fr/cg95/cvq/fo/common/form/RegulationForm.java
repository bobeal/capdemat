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

import org.apache.struts.validator.ValidatorForm;

/**
 * @author Laurent MARQUEZ
 *  
 */
public class RegulationForm extends ValidatorForm {

    private String _meansOfContact;

    private String _meansOfContactValue;
    
    private boolean _rulesOfProcedureAcceptance = false;
    
    private String _method;
    

    /**
     * @return Returns the meansOfContact.
     */
    public String getMeansOfContact() {
        return _meansOfContact;
    }

    /**
     * @param pMeansOfContact
     *            The meansOfContact to set.
     */
    public void setMeansOfContact(String pMeansOfContact) {
        _meansOfContact = pMeansOfContact;
    }

    /**
     * @return Returns the meansOfContactValue.
     */
    public String getMeansOfContactValue() {
        return _meansOfContactValue;
    }

    /**
     * @param pMeansOfContactValue
     *            The meansOfContactValue to set.
     */
    public void setMeansOfContactValue(String pMeansOfContactValue) {
        _meansOfContactValue = pMeansOfContactValue;
    }
    /**
     * @return Returns the rulesOfProcedureAcceptance.
     */
    public boolean isRulesOfProcedureAcceptance() {
        return _rulesOfProcedureAcceptance;
    }
    /**
     * @param prulesOfProcedureAcceptance The rulesOfProcedureAcceptance to set.
     */
    public void setRulesOfProcedureAcceptance(boolean prulesOfProcedureAcceptance) {
        _rulesOfProcedureAcceptance = prulesOfProcedureAcceptance;
    }
    public String getMethod()
    {
      return _method;
    }
    public void setMethod(String pMethod)
    {
      _method = pMethod;
    }
}