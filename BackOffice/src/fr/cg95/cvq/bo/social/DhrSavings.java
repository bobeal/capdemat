package fr.cg95.cvq.bo.social;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.social.*;

public class DhrSavings extends RequestRecord {

	private java.math.BigInteger savingsPaybookAmount;
	private String savingsPaybookNumber;

	public DhrSavings() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		DhrSavings clonedRecord = (DhrSavings)super.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(DhrPersonalEstateAndSaving request) {
    	if (request != null) {

			this.savingsPaybookAmount = request.getPaybookAmount();
			this.savingsPaybookNumber = request.getPaybookNumber();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof DomesticHelpRequest)) {
            DomesticHelpRequest request = (DomesticHelpRequest)xmlRequest; 

        }
    }
    
	public void setSavingsPaybookAmount(java.math.BigInteger savingsPaybookAmount) {
		this.savingsPaybookAmount = savingsPaybookAmount;
	}
	
	public java.math.BigInteger getSavingsPaybookAmount() {
		return this.savingsPaybookAmount;
	}

	public void setSavingsPaybookNumber(String savingsPaybookNumber) {
		this.savingsPaybookNumber = savingsPaybookNumber;
	}
	
	public String getSavingsPaybookNumber() {
		return this.savingsPaybookNumber;
	}

}

