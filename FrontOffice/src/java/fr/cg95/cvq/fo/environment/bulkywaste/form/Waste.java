package fr.cg95.cvq.fo.environment.bulkywaste.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.environment.*;
import fr.cg95.cvq.xml.environment.BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest;

public class Waste extends IStageForm {

	private String collectionAddress;
	private String otherWaste;
	private boolean[] bulkyWasteType;

	public Waste() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("display")) {
		}
		if (state.equals("waste")) {
			for (int i = 0; i < this.bulkyWasteType.length; i++)
				this.bulkyWasteType[i] = false;
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BulkyWasteCollectionRequest)) {
			BulkyWasteCollectionRequest request = (BulkyWasteCollectionRequest)xmlbRequest;
			this.collectionAddress = request.getCollectionAddress();
			this.otherWaste = request.getOtherWaste();
			this.bulkyWasteType = loadForm(this.bulkyWasteType,(Collection)session.getAttribute("bulkywaste"),request.getBulkyWasteTypeArray());
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BulkyWasteCollectionRequest)) {
			BulkyWasteCollectionRequest request = (BulkyWasteCollectionRequest)xmlbRequest;
			request.setCollectionAddress(this.collectionAddress);
			request.setOtherWaste(this.otherWaste);
			request.setBulkyWasteTypeArray(saveForm(this.bulkyWasteType,(Collection)session.getAttribute("bulkywaste")));
		}
	}
	
	public boolean isComplete() {
		return true;
	}
	
	public void setCollectionAddress(String collectionAddress) {
		this.collectionAddress = collectionAddress;
	}
	
	public String getCollectionAddress() {
		return this.collectionAddress;
	}
	
	public boolean checkCollectionAddress() {
		return true;
	}

	public void setOtherWaste(String otherWaste) {
		this.otherWaste = otherWaste;
	}
	
	public String getOtherWaste() {
		return this.otherWaste;
	}
	
	public boolean checkOtherWaste() {
		return true;
	}

	public void setBulkyWasteType(boolean[] bulkyWasteType) {
		this.bulkyWasteType = bulkyWasteType;
	}
	
	public boolean[] getBulkyWasteType() {
		return this.bulkyWasteType;
	}
	
	public boolean checkBulkyWasteType() {
		return true;
	}

	public void setBulkyWasteType(int i, boolean bulkyWasteType) {
		this.bulkyWasteType[i] = bulkyWasteType;
	}
	
	public boolean getBulkyWasteType(int i) {
		return this.bulkyWasteType[i];
	}
	
	public int getSizeOfBulkyWasteType() {
        return this.bulkyWasteType.length;
    }
    
    public void setSizeOfBulkyWasteType(int size) {
        this.bulkyWasteType = new boolean[size];
    }
    
    public int getNbSelectedBulkyWasteType() {
        int count = 0;
        for (int i = 0; i < bulkyWasteType.length; i++)
            if (bulkyWasteType[i])
                count++;
        return count;
    }

}
