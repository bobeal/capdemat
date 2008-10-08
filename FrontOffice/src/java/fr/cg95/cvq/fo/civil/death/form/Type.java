package fr.cg95.cvq.fo.civil.death.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.civil.*;
import fr.cg95.cvq.xml.civil.DeathDetailsRequestDocument.DeathDetailsRequest;

public class Type extends IStageForm {

	private String format;
	private java.math.BigInteger copies;
	private String comment;
	private String motive;

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
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			if (request.getFormat() != null)
			this.format = request.getFormat().toString();
			this.copies = request.getCopies();
			this.comment = request.getComment();
			if (request.getMotive() != null)
			this.motive = request.getMotive().toString();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof DeathDetailsRequest)) {
			DeathDetailsRequest request = (DeathDetailsRequest)xmlbRequest;
			request.setFormat(DeathCertificateFormatType.Enum.forString(this.format));
			request.setCopies(this.copies);
			request.setComment(this.comment);
			request.setMotive(DeathCertificateMotiveType.Enum.forString(this.motive));
		}
	}
	
	public boolean isComplete() {
		if (this.checkFormat() &&
			((this.format == null) || (this.format.length() == 0)))
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

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public boolean checkComment() {
		return true;
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

}
