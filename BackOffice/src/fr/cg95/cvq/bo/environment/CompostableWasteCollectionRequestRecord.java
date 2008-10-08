package fr.cg95.cvq.bo.environment;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.environment.*;

public class CompostableWasteCollectionRequestRecord extends RequestRecord {

	private String requesterFirstName;
	private String requesterLastName;
	private String collectionAddress;
	private boolean[] compostableWasteType;
   	private List compostableWasteTypeList;
	private String otherWaste;

	public CompostableWasteCollectionRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		CompostableWasteCollectionRequestRecord clonedRecord = (CompostableWasteCollectionRequestRecord)super.clone();
		clonedRecord.compostableWasteType = (boolean[])this.compostableWasteType.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof CompostableWasteCollectionRequest)) {
            CompostableWasteCollectionRequest request = (CompostableWasteCollectionRequest)xmlRequest; 

            if ((request.getRequester() != null))
			this.requesterFirstName = request.getRequester().getFirstName();
            if ((request.getRequester() != null))
			this.requesterLastName = request.getRequester().getLastName();
			this.collectionAddress = request.getCollectionAddress();
            this.setCompostableWasteType(this.getList("CompostableWasteType"), request.getCompostableWasteType());
			this.otherWaste = request.getOtherWaste();
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof CompostableWasteCollectionRequest)) {
            CompostableWasteCollectionRequest request = (CompostableWasteCollectionRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof CompostableWasteCollectionRequest)) {
            CompostableWasteCollectionRequest request = (CompostableWasteCollectionRequest)xmlRequest; 

			request.setCollectionAddress(this.collectionAddress);
			request.setCompostableWasteType(this.getCompostableWasteTypeKeys());
			request.setOtherWaste(this.otherWaste);
        }
    }
    
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}

	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}

	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}
	
	public String getCollectionAddress() {
		return this.collectionAddress;
	}

	public void setCompostableWasteType(List referential, Set values) {
		if (referential != null) {
			this.compostableWasteType = new boolean[referential.size()];
			this.compostableWasteTypeList = referential;
			
			if (values != null) {
				for (int i = 0; i < compostableWasteType.length; i++) {
					String key = ((ReferentialData)compostableWasteTypeList.get(i)).getKey();
					compostableWasteType[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getCompostableWasteTypeList() {
		return this.compostableWasteTypeList;
	}
	
	public Set getCompostableWasteTypeKeys() {
		return getRefDataSet(compostableWasteType, compostableWasteTypeList);
	}

	public String[] getCompostableWasteType() {
		Vector values = new Vector();
		
		for (int i = 0; i < compostableWasteType.length; i++) {
			if (compostableWasteType[i]) {
				values.add(((ReferentialData)compostableWasteTypeList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setCompostableWasteType(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < compostableWasteType.length; i++) {
			compostableWasteType[i] = values.indexOf("<" + ((ReferentialData)compostableWasteTypeList.get(i)).getValue() + ">") != -1;
		}
	}
	public void setOtherWaste(String otherWaste) {
		this.otherWaste = otherWaste;
	}
	
	public String getOtherWaste() {
		return this.otherWaste;
	}

}

