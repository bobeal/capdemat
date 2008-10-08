package fr.cg95.cvq.fo.civil.birth.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.BirthDetailsRequestDocument.BirthDetailsRequest;

public class Type extends IStageForm {

	private String format;
	private java.math.BigInteger copies;
	private String fatherLastName;
	private String comment;
	private String motherFirstNames;
	private String fatherFirstNames;
	private String motive;
	private String motherMaidenName;

	public Type() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("parents")) {
		}
		if (state.equals("type")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
			this.copies = request.getCopies();
			this.fatherLastName = request.getFatherLastName();
			this.comment = request.getComment();
			this.motherFirstNames = request.getMotherFirstNames();
			this.fatherFirstNames = request.getFatherFirstNames();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
			this.motherMaidenName = request.getMotherMaidenName();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof BirthDetailsRequest)) {
			BirthDetailsRequest request = (BirthDetailsRequest)xmlbRequest;
			request.setFormat(BirthCertificateFormatType.Enum.forString(this.format));
			request.setCopies(this.copies);
			request.setFatherLastName(this.fatherLastName);
			request.setComment(this.comment);
			request.setMotherFirstNames(this.motherFirstNames);
			request.setFatherFirstNames(this.fatherFirstNames);
			request.setMotive(BirthCertificateMotiveType.Enum.forString(this.motive));
			request.setMotherMaidenName(this.motherMaidenName);
		}
	}
	
	public boolean isComplete() {
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
			return false;
		if (this.checkFatherLastName() &&
			((this.fatherLastName == null) || (this.fatherLastName.length() == 0)))
			return false;
		if (this.checkMotherFirstNames() &&
			((this.motherFirstNames == null) || (this.motherFirstNames.length() == 0)))
			return false;
		if (this.checkFatherFirstNames() &&
			((this.fatherFirstNames == null) || (this.fatherFirstNames.length() == 0)))
			return false;
		if (this.checkMotherMaidenName() &&
			((this.motherMaidenName == null) || (this.motherMaidenName.length() == 0)))
			return false;
		return true;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return this.format;
	}
	
	public boolean checkFormat() {
		return true;
	}

	public void setCopies(java.math.BigInteger copies) {
		this.copies = copies;
	}
	
	public java.math.BigInteger getCopies() {
		return this.copies;
	}
	
	public boolean checkCopies() {
		return true;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}
	
	public String getFatherLastName() {
		return this.fatherLastName;
	}
	
	public boolean checkFatherLastName() {
		return format.equals("ExtractWithRelationship");
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public boolean checkComment() {
		return true;
	}

	public void setMotherFirstNames(String motherFirstNames) {
		this.motherFirstNames = motherFirstNames;
	}
	
	public String getMotherFirstNames() {
		return this.motherFirstNames;
	}
	
	public boolean checkMotherFirstNames() {
		return format.equals("ExtractWithRelationship");
	}

	public void setFatherFirstNames(String fatherFirstNames) {
		this.fatherFirstNames = fatherFirstNames;
	}
	
	public String getFatherFirstNames() {
		return this.fatherFirstNames;
	}
	
	public boolean checkFatherFirstNames() {
		return format.equals("ExtractWithRelationship");
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}
	
	public String getMotive() {
		return this.motive;
	}
	
	public boolean checkMotive() {
		return true;
	}

	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	
	public String getMotherMaidenName() {
		return this.motherMaidenName;
	}
	
	public boolean checkMotherMaidenName() {
		return format.equals("ExtractWithRelationship");
	}

}
