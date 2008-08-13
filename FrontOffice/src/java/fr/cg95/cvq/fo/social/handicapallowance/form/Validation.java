package fr.cg95.cvq.fo.social.handicapallowance.form;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import fr.cg95.cvq.wizard.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import fr.cg95.cvq.xml.social.HandicapAllowanceRequestDocument.HandicapAllowanceRequest;

public class Validation extends IStageForm {

	private String subjectIndividualLastName;
  	private String legalRepresentativeAddressAdditionalDeliveryInformation;
	private String legalRepresentativeAddressAdditionalGeographicalInformation;
	private String legalRepresentativeAddressStreetNumber;
	private String legalRepresentativeAddressStreetName;
	private String legalRepresentativeAddressPlaceNameOrService;
	private String legalRepresentativeAddressPostalCode;
	private String legalRepresentativeAddressCity;
  	private String subjectIndividualAddressAdditionalDeliveryInformation;
	private String subjectIndividualAddressAdditionalGeographicalInformation;
	private String subjectIndividualAddressStreetNumber;
	private String subjectIndividualAddressStreetName;
	private String subjectIndividualAddressPlaceNameOrService;
	private String subjectIndividualAddressPostalCode;
	private String subjectIndividualAddressCity;
	private String needs;
	private boolean writingHelp;
	private boolean legalRepresentative;
	private boolean hopesAndNeeds;
	private String helperResponsability;
	private String legalRepresentativeFamilyRelationship;
	private String helperName;
	private String legalRepresentativeName;
	private String subjectIndividualFirstName;
	private String comments;
	private String legalRepresentativeFirstame;
	private String hopes;
	private String legalRepresentativePhone;

	public Validation() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("summary")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			this.subjectIndividualLastName = request.getSubject().getIndividual().getLastName();
  			this.legalRepresentativeAddressAdditionalDeliveryInformation = request.getLegalRepresentativeAddress().getAdditionalDeliveryInformation();
			this.legalRepresentativeAddressAdditionalGeographicalInformation = request.getLegalRepresentativeAddress().getAdditionalGeographicalInformation();
			this.legalRepresentativeAddressStreetNumber = request.getLegalRepresentativeAddress().getStreetNumber();
			this.legalRepresentativeAddressStreetName = request.getLegalRepresentativeAddress().getStreetName();
			this.legalRepresentativeAddressPlaceNameOrService = request.getLegalRepresentativeAddress().getPlaceNameOrService();
			this.legalRepresentativeAddressPostalCode = request.getLegalRepresentativeAddress().getPostalCode();
			this.legalRepresentativeAddressCity = request.getLegalRepresentativeAddress().getCity();
  			this.subjectIndividualAddressAdditionalDeliveryInformation = request.getSubject().getIndividual().getAddress().getAdditionalDeliveryInformation();
			this.subjectIndividualAddressAdditionalGeographicalInformation = request.getSubject().getIndividual().getAddress().getAdditionalGeographicalInformation();
			this.subjectIndividualAddressStreetNumber = request.getSubject().getIndividual().getAddress().getStreetNumber();
			this.subjectIndividualAddressStreetName = request.getSubject().getIndividual().getAddress().getStreetName();
			this.subjectIndividualAddressPlaceNameOrService = request.getSubject().getIndividual().getAddress().getPlaceNameOrService();
			this.subjectIndividualAddressPostalCode = request.getSubject().getIndividual().getAddress().getPostalCode();
			this.subjectIndividualAddressCity = request.getSubject().getIndividual().getAddress().getCity();
			this.needs = request.getNeeds();
			this.writingHelp = request.getWritingHelp();
			this.legalRepresentative = request.getLegalRepresentative();
			this.hopesAndNeeds = request.getHopesAndNeeds();
			this.helperResponsability = request.getHelperResponsability();
			this.legalRepresentativeFamilyRelationship = request.getLegalRepresentativeFamilyRelationship();
			this.helperName = request.getHelperName();
			this.legalRepresentativeName = request.getLegalRepresentativeName();
			this.subjectIndividualFirstName = request.getSubject().getIndividual().getFirstName();
			this.comments = request.getComments();
			this.legalRepresentativeFirstame = request.getLegalRepresentativeFirstame();
			this.hopes = request.getHopes();
			this.legalRepresentativePhone = request.getLegalRepresentativePhone();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof HandicapAllowanceRequest)) {
			HandicapAllowanceRequest request = (HandicapAllowanceRequest)xmlbRequest;
			request.getSubject().getIndividual().setLastName(this.subjectIndividualLastName);
  			request.getLegalRepresentativeAddress().setAdditionalDeliveryInformation(this.legalRepresentativeAddressAdditionalDeliveryInformation);
			request.getLegalRepresentativeAddress().setAdditionalGeographicalInformation(this.legalRepresentativeAddressAdditionalGeographicalInformation);
			request.getLegalRepresentativeAddress().setStreetNumber(this.legalRepresentativeAddressStreetNumber);
			request.getLegalRepresentativeAddress().setStreetName(this.legalRepresentativeAddressStreetName);
			request.getLegalRepresentativeAddress().setPlaceNameOrService(this.legalRepresentativeAddressPlaceNameOrService);
			request.getLegalRepresentativeAddress().setPostalCode(this.legalRepresentativeAddressPostalCode);
			request.getLegalRepresentativeAddress().setCity(this.legalRepresentativeAddressCity);
  			request.getSubject().getIndividual().getAddress().setAdditionalDeliveryInformation(this.subjectIndividualAddressAdditionalDeliveryInformation);
			request.getSubject().getIndividual().getAddress().setAdditionalGeographicalInformation(this.subjectIndividualAddressAdditionalGeographicalInformation);
			request.getSubject().getIndividual().getAddress().setStreetNumber(this.subjectIndividualAddressStreetNumber);
			request.getSubject().getIndividual().getAddress().setStreetName(this.subjectIndividualAddressStreetName);
			request.getSubject().getIndividual().getAddress().setPlaceNameOrService(this.subjectIndividualAddressPlaceNameOrService);
			request.getSubject().getIndividual().getAddress().setPostalCode(this.subjectIndividualAddressPostalCode);
			request.getSubject().getIndividual().getAddress().setCity(this.subjectIndividualAddressCity);
			request.setNeeds(this.needs);
			request.setWritingHelp(this.writingHelp);
			request.setLegalRepresentative(this.legalRepresentative);
			request.setHopesAndNeeds(this.hopesAndNeeds);
			request.setHelperResponsability(this.helperResponsability);
			request.setLegalRepresentativeFamilyRelationship(this.legalRepresentativeFamilyRelationship);
			request.setHelperName(this.helperName);
			request.setLegalRepresentativeName(this.legalRepresentativeName);
			request.getSubject().getIndividual().setFirstName(this.subjectIndividualFirstName);
			request.setComments(this.comments);
			request.setLegalRepresentativeFirstame(this.legalRepresentativeFirstame);
			request.setHopes(this.hopes);
			request.setLegalRepresentativePhone(this.legalRepresentativePhone);
		}
	}
	
	public boolean isComplete() {
		if (this.checkSubjectIndividualLastName() &&
			((this.subjectIndividualLastName == null) || (this.subjectIndividualLastName.length() == 0)))
			return false;
  		if (this.checkLegalRepresentativeAddressStreetName() &&
			((this.legalRepresentativeAddressStreetName == null) || (this.legalRepresentativeAddressStreetName.length() == 0)))
			return false;
		if (this.checkLegalRepresentativeAddressPostalCode() &&
			((this.legalRepresentativeAddressPostalCode == null) || (this.legalRepresentativeAddressPostalCode.length() == 0)))
			return false;
		if (this.checkLegalRepresentativeAddressCity() &&
			((this.legalRepresentativeAddressCity == null) || (this.legalRepresentativeAddressCity.length() == 0)))
			return false;
  		if (this.checkSubjectIndividualAddressStreetName() &&
			((this.subjectIndividualAddressStreetName == null) || (this.subjectIndividualAddressStreetName.length() == 0)))
			return false;
		if (this.checkSubjectIndividualAddressPostalCode() &&
			((this.subjectIndividualAddressPostalCode == null) || (this.subjectIndividualAddressPostalCode.length() == 0)))
			return false;
		if (this.checkSubjectIndividualAddressCity() &&
			((this.subjectIndividualAddressCity == null) || (this.subjectIndividualAddressCity.length() == 0)))
			return false;
		if (this.checkSubjectIndividualFirstName() &&
			((this.subjectIndividualFirstName == null) || (this.subjectIndividualFirstName.length() == 0)))
			return false;
		return true;
	}
	
	public void setSubjectIndividualLastName(String subjectIndividualLastName) {
		this.subjectIndividualLastName = subjectIndividualLastName;
	}
	
	public String getSubjectIndividualLastName() {
		return this.subjectIndividualLastName;
	}
	
	public boolean checkSubjectIndividualLastName() {
		return true;
	}

  	public void setLegalRepresentativeAddressAdditionalDeliveryInformation(String legalRepresentativeAddressAdditionalDeliveryInformation) {
		this.legalRepresentativeAddressAdditionalDeliveryInformation = legalRepresentativeAddressAdditionalDeliveryInformation;
	}
	
	public String getLegalRepresentativeAddressAdditionalDeliveryInformation() {
		return this.legalRepresentativeAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkLegalRepresentativeAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setLegalRepresentativeAddressAdditionalGeographicalInformation(String legalRepresentativeAddressAdditionalGeographicalInformation) {
		this.legalRepresentativeAddressAdditionalGeographicalInformation = legalRepresentativeAddressAdditionalGeographicalInformation;
	}
	
	public String getLegalRepresentativeAddressAdditionalGeographicalInformation() {
		return this.legalRepresentativeAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkLegalRepresentativeAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setLegalRepresentativeAddressStreetNumber(String legalRepresentativeAddressStreetNumber) {
		this.legalRepresentativeAddressStreetNumber = legalRepresentativeAddressStreetNumber;
	}
	
	public String getLegalRepresentativeAddressStreetNumber() {
		return this.legalRepresentativeAddressStreetNumber;
	}
	
	public boolean checkLegalRepresentativeAddressStreetNumber() {
		return true;
	}

	public void setLegalRepresentativeAddressStreetName(String legalRepresentativeAddressStreetName) {
		this.legalRepresentativeAddressStreetName = legalRepresentativeAddressStreetName;
	}
	
	public String getLegalRepresentativeAddressStreetName() {
		return this.legalRepresentativeAddressStreetName;
	}
	
	public boolean checkLegalRepresentativeAddressStreetName() {
		return true;
	}

	public void setLegalRepresentativeAddressPlaceNameOrService(String legalRepresentativeAddressPlaceNameOrService) {
		this.legalRepresentativeAddressPlaceNameOrService = legalRepresentativeAddressPlaceNameOrService;
	}
	
	public String getLegalRepresentativeAddressPlaceNameOrService() {
		return this.legalRepresentativeAddressPlaceNameOrService;
	}
	
	public boolean checkLegalRepresentativeAddressPlaceNameOrService() {
		return true;
	}

	public void setLegalRepresentativeAddressPostalCode(String legalRepresentativeAddressPostalCode) {
		this.legalRepresentativeAddressPostalCode = legalRepresentativeAddressPostalCode;
	}
	
	public String getLegalRepresentativeAddressPostalCode() {
		return this.legalRepresentativeAddressPostalCode;
	}
	
	public boolean checkLegalRepresentativeAddressPostalCode() {
		return true;
	}

	public void setLegalRepresentativeAddressCity(String legalRepresentativeAddressCity) {
		this.legalRepresentativeAddressCity = legalRepresentativeAddressCity;
	}
	
	public String getLegalRepresentativeAddressCity() {
		return this.legalRepresentativeAddressCity;
	}
	
	public boolean checkLegalRepresentativeAddressCity() {
		return true;
	}

  	public void setSubjectIndividualAddressAdditionalDeliveryInformation(String subjectIndividualAddressAdditionalDeliveryInformation) {
		this.subjectIndividualAddressAdditionalDeliveryInformation = subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalDeliveryInformation() {
		return this.subjectIndividualAddressAdditionalDeliveryInformation;
	}
	
	public boolean checkSubjectIndividualAddressAdditionalDeliveryInformation() {
		return true;
	}

	public void setSubjectIndividualAddressAdditionalGeographicalInformation(String subjectIndividualAddressAdditionalGeographicalInformation) {
		this.subjectIndividualAddressAdditionalGeographicalInformation = subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public String getSubjectIndividualAddressAdditionalGeographicalInformation() {
		return this.subjectIndividualAddressAdditionalGeographicalInformation;
	}
	
	public boolean checkSubjectIndividualAddressAdditionalGeographicalInformation() {
		return true;
	}

	public void setSubjectIndividualAddressStreetNumber(String subjectIndividualAddressStreetNumber) {
		this.subjectIndividualAddressStreetNumber = subjectIndividualAddressStreetNumber;
	}
	
	public String getSubjectIndividualAddressStreetNumber() {
		return this.subjectIndividualAddressStreetNumber;
	}
	
	public boolean checkSubjectIndividualAddressStreetNumber() {
		return true;
	}

	public void setSubjectIndividualAddressStreetName(String subjectIndividualAddressStreetName) {
		this.subjectIndividualAddressStreetName = subjectIndividualAddressStreetName;
	}
	
	public String getSubjectIndividualAddressStreetName() {
		return this.subjectIndividualAddressStreetName;
	}
	
	public boolean checkSubjectIndividualAddressStreetName() {
		return true;
	}

	public void setSubjectIndividualAddressPlaceNameOrService(String subjectIndividualAddressPlaceNameOrService) {
		this.subjectIndividualAddressPlaceNameOrService = subjectIndividualAddressPlaceNameOrService;
	}
	
	public String getSubjectIndividualAddressPlaceNameOrService() {
		return this.subjectIndividualAddressPlaceNameOrService;
	}
	
	public boolean checkSubjectIndividualAddressPlaceNameOrService() {
		return true;
	}

	public void setSubjectIndividualAddressPostalCode(String subjectIndividualAddressPostalCode) {
		this.subjectIndividualAddressPostalCode = subjectIndividualAddressPostalCode;
	}
	
	public String getSubjectIndividualAddressPostalCode() {
		return this.subjectIndividualAddressPostalCode;
	}
	
	public boolean checkSubjectIndividualAddressPostalCode() {
		return true;
	}

	public void setSubjectIndividualAddressCity(String subjectIndividualAddressCity) {
		this.subjectIndividualAddressCity = subjectIndividualAddressCity;
	}
	
	public String getSubjectIndividualAddressCity() {
		return this.subjectIndividualAddressCity;
	}
	
	public boolean checkSubjectIndividualAddressCity() {
		return true;
	}

	public void setNeeds(String needs) {
		this.needs = needs;
	}
	
	public String getNeeds() {
		return this.needs;
	}
	
	public boolean checkNeeds() {
		return true;
	}

	public void setWritingHelp(boolean writingHelp) {
		this.writingHelp = writingHelp;
	}
	
	public boolean getWritingHelp() {
		return this.writingHelp;
	}
	
	public boolean checkWritingHelp() {
		return true;
	}

	public void setLegalRepresentative(boolean legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	public boolean getLegalRepresentative() {
		return this.legalRepresentative;
	}
	
	public boolean checkLegalRepresentative() {
		return true;
	}

	public void setHopesAndNeeds(boolean hopesAndNeeds) {
		this.hopesAndNeeds = hopesAndNeeds;
	}
	
	public boolean getHopesAndNeeds() {
		return this.hopesAndNeeds;
	}
	
	public boolean checkHopesAndNeeds() {
		return true;
	}

	public void setHelperResponsability(String helperResponsability) {
		this.helperResponsability = helperResponsability;
	}
	
	public String getHelperResponsability() {
		return this.helperResponsability;
	}
	
	public boolean checkHelperResponsability() {
		return true;
	}

	public void setLegalRepresentativeFamilyRelationship(String legalRepresentativeFamilyRelationship) {
		this.legalRepresentativeFamilyRelationship = legalRepresentativeFamilyRelationship;
	}
	
	public String getLegalRepresentativeFamilyRelationship() {
		return this.legalRepresentativeFamilyRelationship;
	}
	
	public boolean checkLegalRepresentativeFamilyRelationship() {
		return true;
	}

	public void setHelperName(String helperName) {
		this.helperName = helperName;
	}
	
	public String getHelperName() {
		return this.helperName;
	}
	
	public boolean checkHelperName() {
		return true;
	}

	public void setLegalRepresentativeName(String legalRepresentativeName) {
		this.legalRepresentativeName = legalRepresentativeName;
	}
	
	public String getLegalRepresentativeName() {
		return this.legalRepresentativeName;
	}
	
	public boolean checkLegalRepresentativeName() {
		return true;
	}

	public void setSubjectIndividualFirstName(String subjectIndividualFirstName) {
		this.subjectIndividualFirstName = subjectIndividualFirstName;
	}
	
	public String getSubjectIndividualFirstName() {
		return this.subjectIndividualFirstName;
	}
	
	public boolean checkSubjectIndividualFirstName() {
		return true;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getComments() {
		return this.comments;
	}
	
	public boolean checkComments() {
		return true;
	}

	public void setLegalRepresentativeFirstame(String legalRepresentativeFirstame) {
		this.legalRepresentativeFirstame = legalRepresentativeFirstame;
	}
	
	public String getLegalRepresentativeFirstame() {
		return this.legalRepresentativeFirstame;
	}
	
	public boolean checkLegalRepresentativeFirstame() {
		return true;
	}

	public void setHopes(String hopes) {
		this.hopes = hopes;
	}
	
	public String getHopes() {
		return this.hopes;
	}
	
	public boolean checkHopes() {
		return true;
	}

	public void setLegalRepresentativePhone(String legalRepresentativePhone) {
		this.legalRepresentativePhone = legalRepresentativePhone;
	}
	
	public String getLegalRepresentativePhone() {
		return this.legalRepresentativePhone;
	}
	
	public boolean checkLegalRepresentativePhone() {
		return true;
	}

}
