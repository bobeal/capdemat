package fr.cg95.cvq.fo.common.form;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.TitleType;

public class Requester extends IStageForm {

    private String requesterTitle;
    private String requesterNameOfUse;
	private String requesterFirstName;
	private String requesterHomePhone;
	private String requesterMaidenName;
	private String requesterOfficePhone;
	private String requesterLastName;
	private Calendar requesterBirthDate;
    private String requesterMobilePhone;
    private String requesterEmail;
    private String requesterPassword;
    private String requesterQuestion;
    private String requesterAnswer;
    private String requesterAddressAdditionalDeliveryInformation;
    private String requesterAddressAdditionalGeographicalInformation;
    private String requesterAddressStreetNumber;
    private String requesterAddressStreetName;
    private String requesterAddressPlaceNameOrService;
    private String requesterAddressPostalCode;
    private String requesterAddressCity;

    private boolean requestTrace;
    private String passwordConfirm;

    public Requester() {
		super();
	}
	
	public void reset(String state) {
		if (state.equals("requester")) {
		}
	}
	
	public void load(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RequestType)) {
            RequestType request = (RequestType)xmlbRequest;
            if (request.getRequester().getTitle() != null)
                this.requesterTitle = request.getRequester().getTitle().toString();
			this.requesterNameOfUse = request.getRequester().getNameOfUse();
			this.requesterFirstName = request.getRequester().getFirstName();
			this.requesterHomePhone = request.getRequester().getHomePhone();
			this.requesterMaidenName = request.getRequester().getMaidenName();
			this.requesterOfficePhone = request.getRequester().getOfficePhone();
			this.requesterLastName = request.getRequester().getLastName();
			this.requesterBirthDate = request.getRequester().getBirthDate();
            this.requesterMobilePhone = request.getRequester().getMobilePhone();
            this.requesterEmail = request.getRequester().getEmail();
            this.requesterPassword = request.getRequester().getPassword();
            this.requesterQuestion = request.getRequester().getQuestion();
            this.requesterAnswer = request.getRequester().getAnswer();

            this.requesterAddressAdditionalDeliveryInformation = request.getRequester().getAddress().getAdditionalDeliveryInformation();
            this.requesterAddressAdditionalGeographicalInformation = request.getRequester().getAddress().getAdditionalGeographicalInformation();
            this.requesterAddressStreetNumber = request.getRequester().getAddress().getStreetNumber();
            this.requesterAddressStreetName = request.getRequester().getAddress().getStreetName();
            this.requesterAddressPlaceNameOrService = request.getRequester().getAddress().getPlaceNameOrService();
            this.requesterAddressPostalCode = request.getRequester().getAddress().getPostalCode();
            this.requesterAddressCity = request.getRequester().getAddress().getCity();
            
            this.requestTrace = request.getRequester().isSetPassword();
		}
	}
	
	public void save(HttpSession session, Object xmlbRequest) {
		if ((xmlbRequest != null) && (xmlbRequest instanceof RequestType)) {
            RequestType request = (RequestType)xmlbRequest;
            request.getRequester().setTitle(TitleType.Enum.forString(this.requesterTitle));
            request.getRequester().setNameOfUse(this.requesterNameOfUse);
			request.getRequester().setFirstName(this.requesterFirstName);
			request.getRequester().setHomePhone(this.requesterHomePhone);
			request.getRequester().setMaidenName(this.requesterMaidenName);
			request.getRequester().setOfficePhone(this.requesterOfficePhone);
			request.getRequester().setLastName(this.requesterLastName);
			request.getRequester().setBirthDate(this.requesterBirthDate);
            request.getRequester().setMobilePhone(this.requesterMobilePhone);
            request.getRequester().setEmail(this.requesterEmail);

            request.getRequester().getAddress().setAdditionalDeliveryInformation(this.requesterAddressAdditionalDeliveryInformation);
            request.getRequester().getAddress().setAdditionalGeographicalInformation(this.requesterAddressAdditionalGeographicalInformation);
            request.getRequester().getAddress().setStreetNumber(this.requesterAddressStreetNumber);
            request.getRequester().getAddress().setStreetName(this.requesterAddressStreetName);
            request.getRequester().getAddress().setPostalCode(this.requesterAddressPostalCode);
            request.getRequester().getAddress().setPlaceNameOrService(this.requesterAddressPlaceNameOrService);
            request.getRequester().getAddress().setCity(this.requesterAddressCity);
            
            if (this.requestTrace) {
                request.getRequester().setPassword(this.requesterPassword);
                request.getRequester().setQuestion(this.requesterQuestion);
                request.getRequester().setAnswer(this.requesterAnswer);

            } else if (request.getRequester().isSetPassword()) {
                request.getRequester().unsetPassword();
                request.getRequester().unsetQuestion();
                request.getRequester().unsetAnswer();
            }
		}
	}
	
	public boolean isComplete() {
		if ((this.requesterFirstName == null) || (this.requesterFirstName.length() == 0))
			return false;
		if ((this.requesterHomePhone == null) || (this.requesterHomePhone.length() == 0))
			return false;
		if ((this.requesterAddressPostalCode == null) || (this.requesterAddressPostalCode.length() == 0))
			return false;
        if ((this.requesterAddressStreetName == null) || (this.requesterAddressStreetName.length() == 0))
            return false;
		if ((this.requesterAddressCity == null) || (this.requesterAddressCity.length() == 0))
			return false;
        if ((this.requesterLastName == null) || (this.requesterLastName.length() == 0))
            return false;
        if (this.checkRequesterMaidenName() &&
                ((this.requesterMaidenName == null) || (this.requesterMaidenName.length() == 0)))
                return false;
        if (this.checkRequesterAnswer() &&
                ((this.requesterAnswer == null) || (this.requesterAnswer.length() == 0)))
                return false;
        if (this.checkRequesterPassword() &&
                ((this.requesterPassword == null) || (this.requesterPassword.length() == 0)))
                return false;
        if (this.checkRequesterQuestion() &&
                ((this.requesterQuestion == null) || (this.requesterQuestion.length() == 0)))
                return false;
        if (this.checkPasswordConfirm() &&
                ((this.passwordConfirm == null) || (this.passwordConfirm.length() == 0)))
                return false;
		return true;
	}
	
	public void setRequesterNameOfUse(String requesterNameOfUse) {
		this.requesterNameOfUse = requesterNameOfUse;
	}
	
	public String getRequesterNameOfUse() {
		return this.requesterNameOfUse;
	}
	
	public void setRequesterFirstName(String requesterFirstName) {
		this.requesterFirstName = requesterFirstName;
	}
	
	public String getRequesterFirstName() {
		return this.requesterFirstName;
	}
	
	public void setRequesterHomePhone(String requesterHomePhone) {
		this.requesterHomePhone = requesterHomePhone;
	}
	
	public String getRequesterHomePhone() {
		return this.requesterHomePhone;
	}
	
	public void setRequesterMaidenName(String requesterMaidenName) {
		this.requesterMaidenName = requesterMaidenName;
	}
	
    public String getRequesterMaidenName() {
        return this.requesterMaidenName;
    }
    
    public boolean checkRequesterMaidenName() {
        return this.requesterTitle.equals("Madam");
    }
    
	public void setRequesterOfficePhone(String requesterOfficePhone) {
		this.requesterOfficePhone = requesterOfficePhone;
	}
	
	public String getRequesterOfficePhone() {
		return this.requesterOfficePhone;
	}
	
	public void setRequesterLastName(String requesterLastName) {
		this.requesterLastName = requesterLastName;
	}
	
	public String getRequesterLastName() {
		return this.requesterLastName;
	}
	
	public void setRequesterBirthDate(Calendar requesterBirthDate) {
		this.requesterBirthDate = requesterBirthDate;
	}
	
	public Calendar getRequesterBirthDate() {
		return this.requesterBirthDate;
	}
	
	public void setRequesterMobilePhone(String requesterMobilePhone) {
		this.requesterMobilePhone = requesterMobilePhone;
	}
	
	public String getRequesterMobilePhone() {
		return this.requesterMobilePhone;
	}

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public String getRequesterAnswer() {
        return requesterAnswer;
    }

    public void setRequesterAnswer(String requesterAnswer) {
        this.requesterAnswer = requesterAnswer;
    }

    public boolean checkRequesterAnswer() {
        return requestTrace;
    }
    
    public String getRequesterPassword() {
        return requesterPassword;
    }

    public void setRequesterPassword(String requesterPassword) {
        this.requesterPassword = requesterPassword;
    }

    public boolean checkRequesterPassword() {
        return requestTrace;
    }
    
    public String getRequesterQuestion() {
        return requesterQuestion;
    }

    public void setRequesterQuestion(String requesterQuestion) {
        this.requesterQuestion = requesterQuestion;
    }

    public boolean checkRequesterQuestion() {
        return requestTrace;
    }
    
    public String getRequesterTitle() {
        return requesterTitle;
    }

    public void setRequesterTitle(String requesterTitle) {
        this.requesterTitle = requesterTitle;
    }
    
    public boolean isRequestTrace() {
        return requestTrace;
    }

    public void setRequestTrace(boolean requestTrace) {
        this.requestTrace = requestTrace;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public boolean checkPasswordConfirm() {
        return requestTrace;
    }


    
    public void setRequesterAddressAdditionalDeliveryInformation(String requesterAddressAdditionalDeliveryInformation) {
        this.requesterAddressAdditionalDeliveryInformation= requesterAddressAdditionalDeliveryInformation;
    }
    
    public String getRequesterAddressAdditionalDeliveryInformation() {
        return this.requesterAddressAdditionalDeliveryInformation;
    }
    
    public void setRequesterAddressAdditionalGeographicalInformation(String requesterAddressAdditionalGeographicalInformation) {
        this.requesterAddressAdditionalGeographicalInformation = requesterAddressAdditionalGeographicalInformation;
    }
    
    public String getRequesterAddressAdditionalGeographicalInformation() {
        return this.requesterAddressAdditionalGeographicalInformation;
    }
    
    public void setRequesterAddressStreetNumber(String requesterAddressStreetNumber) {
        this.requesterAddressStreetNumber = requesterAddressStreetNumber;
    }
    
    public String getRequesterAddressStreetNumber() {
        return this.requesterAddressStreetNumber;
    }
    
    public void setRequesterAddressStreetName(String requesterAddressStreetName) {
        this.requesterAddressStreetName = requesterAddressStreetName;
    }
    
    public String getRequesterAddressStreetName() {
        return this.requesterAddressStreetName;
    }
    
    public void setRequesterAddressPlaceNameOrService(String requesterAddressPlaceNameOrService) {
        this.requesterAddressPlaceNameOrService = requesterAddressPlaceNameOrService;
    }
    
    public String getRequesterAddressPlaceNameOrService() {
        return this.requesterAddressPlaceNameOrService;
    }
    
    public void setRequesterAddressPostalCode(String requesterAddressPostalCode) {
        this.requesterAddressPostalCode = requesterAddressPostalCode;
    }
    
    public String getRequesterAddressPostalCode() {
        return this.requesterAddressPostalCode;
    }
    
    public void setRequesterAddressCity(String requesterAddressCity) {
        this.requesterAddressCity = requesterAddressCity;
    }
    
    public String getRequesterAddressCity() {
        return this.requesterAddressCity;
    }
    
}
