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

public class BulkyWasteCollectionRequestRecord extends RequestRecord {

	private String collectionAddress;
	private String requesterFirstName;
	private String requesterLastName;
	private String otherWaste;
	private boolean[] bulkyWasteType;
   	private List bulkyWasteTypeList;

	public BulkyWasteCollectionRequestRecord() {
		super();
	}
	
	protected Object clone() throws CloneNotSupportedException {
		BulkyWasteCollectionRequestRecord clonedRecord = (BulkyWasteCollectionRequestRecord)super.clone();
		clonedRecord.bulkyWasteType = (boolean[])this.bulkyWasteType.clone();
		return clonedRecord;
	}
	
	public BaseRecord getDataRecord(Long id) {

		if (id.equals(this.getId()))
			return this;
			
		return super.getDataRecord(id);
	}

    public void load(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BulkyWasteCollectionRequest)) {
            BulkyWasteCollectionRequest request = (BulkyWasteCollectionRequest)xmlRequest; 

			this.collectionAddress = request.getCollectionAddress();
            if ((request.getRequester() != null))
			this.requesterFirstName = request.getRequester().getFirstName();
            if ((request.getRequester() != null))
			this.requesterLastName = request.getRequester().getLastName();
			this.otherWaste = request.getOtherWaste();
            this.setBulkyWasteType(this.getList("BulkyWasteType"), request.getBulkyWasteType());
        }
    }
    
    public void saveRequest(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BulkyWasteCollectionRequest)) {
            BulkyWasteCollectionRequest request = (BulkyWasteCollectionRequest)xmlRequest; 
        }
    }
    
    public void saveData(Object xmlRequest) {
        if ((xmlRequest != null) && (xmlRequest instanceof BulkyWasteCollectionRequest)) {
            BulkyWasteCollectionRequest request = (BulkyWasteCollectionRequest)xmlRequest; 

			request.setCollectionAddress(this.collectionAddress);
			request.setOtherWaste(this.otherWaste);
			request.setBulkyWasteType(this.getBulkyWasteTypeKeys());
        }
    }
    
	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}
	
	public String getCollectionAddress() {
		return this.collectionAddress;
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

	public void setOtherWaste(String otherWaste) {
		this.otherWaste = otherWaste;
	}
	
	public String getOtherWaste() {
		return this.otherWaste;
	}

	public void setBulkyWasteType(List referential, Set values) {
		if (referential != null) {
			this.bulkyWasteType = new boolean[referential.size()];
			this.bulkyWasteTypeList = referential;
			
			if (values != null) {
				for (int i = 0; i < bulkyWasteType.length; i++) {
					String key = ((ReferentialData)bulkyWasteTypeList.get(i)).getKey();
					bulkyWasteType[i] = containsRefData(values, key);
				}
			}
		}
	}
	
	public List getBulkyWasteTypeList() {
		return this.bulkyWasteTypeList;
	}
	
	public Set getBulkyWasteTypeKeys() {
		return getRefDataSet(bulkyWasteType, bulkyWasteTypeList);
	}

	public String[] getBulkyWasteType() {
		Vector values = new Vector();
		
		for (int i = 0; i < bulkyWasteType.length; i++) {
			if (bulkyWasteType[i]) {
				values.add(((ReferentialData)bulkyWasteTypeList.get(i)).getValue());
			}
		}

		String[] value = new String[values.size()];
		for (int i = 0; i < values.size(); i++)
			value[i] = (String)values.get(i);

		return value;
	}

	public void setBulkyWasteType(String[] value) {
		String values = "";
		for (int i = 0; i < value.length; i++)
			values += "<" + value[i] + ">";
		
		for (int i = 0; i < bulkyWasteType.length; i++) {
			bulkyWasteType[i] = values.indexOf("<" + ((ReferentialData)bulkyWasteTypeList.get(i)).getValue() + ">") != -1;
		}
	}
}

