package fr.cg95.cvq.fo.environment.compostablewaste.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.environment.*;
import fr.cg95.cvq.xml.environment.CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest;

public class Validation extends IStageForm {

	private String collectionAddress;
	private boolean[] compostableWasteType;
	private String otherWaste;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof CompostableWasteCollectionRequest)) {
			CompostableWasteCollectionRequest request = (CompostableWasteCollectionRequest)xmlbRequest;
			this.collectionAddress = request.getCollectionAddress();
			this.compostableWasteType = loadForm(this.compostableWasteType,(Collection)session.getAttribute("compostablewaste"),request.getCompostableWasteTypeArray());
			this.otherWaste = request.getOtherWaste();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof CompostableWasteCollectionRequest)) {
			CompostableWasteCollectionRequest request = (CompostableWasteCollectionRequest)xmlbRequest;
			request.setCollectionAddress(this.collectionAddress);
			request.setCompostableWasteTypeArray(saveForm(this.compostableWasteType,(Collection)session.getAttribute("compostablewaste")));
			request.setOtherWaste(this.otherWaste);
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

	public void setCompostableWasteType(boolean[] compostableWasteType) {
		this.compostableWasteType = compostableWasteType;
	}
	
	public boolean[] getCompostableWasteType() {
		return this.compostableWasteType;
	}
	
	public boolean checkCompostableWasteType() {
		return true;
	}

	public void setCompostableWasteType(int i, boolean compostableWasteType) {
		this.compostableWasteType[i] = compostableWasteType;
	}
	
	public boolean getCompostableWasteType(int i) {
		return this.compostableWasteType[i];
	}
	
	public int getSizeOfCompostableWasteType() {
        return this.compostableWasteType.length;
    }
    
    public void setSizeOfCompostableWasteType(int size) {
        this.compostableWasteType = new boolean[size];
    }
    
    public int getNbSelectedCompostableWasteType() {
        int count = 0;
        for (int i = 0; i < compostableWasteType.length; i++)
            if (compostableWasteType[i])
                count++;
        return count;
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

}
