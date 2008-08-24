package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestSeason implements Serializable {

    private static final long serialVersionUID = 1L;

    /** the associated (parent) request type */
    private RequestType requestType;
    /** display purposes only */
    private String label;
    /** an unique identifier for association with requests */
    private String uuid;
    /** date from which users can issue new requests */
    private Date registrationStart;
    /** date until which users can issue new requests */
    private Date registrationEnd;
    /** 
     * can block validations for a given season until associated external services
     * are ready to deal with them.
     */
    private Date validationAuthorizationStart;
    /** date from which registration will be considered as active */
    private Date effectStart;
    /** date to which registration will be considered as active */
    private Date effectEnd;
    
    public RequestSeason() {
    }
    
    /**
     * @hibernate.parent
     */
    public final RequestType getRequestType() {
        return requestType;
    }

    public final void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * @hibernate.property
     *  column="uuid"
     */
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @hibernate.property
     *  column="effect_end"
     */
    public final Date getEffectEnd() {
        return effectEnd;
    }
    
    public final void setEffectEnd(Date effectEnd) {
        this.effectEnd = effectEnd;
    }
    
    /**
     * @hibernate.property
     *  column="effect_start"
     */
    public final Date getEffectStart() {
        return effectStart;
    }
    
    public final void setEffectStart(Date effectStart) {
        this.effectStart = effectStart;
    }
    
    /**
     * @hibernate.property
     *  column="label"
     */
    public final String getLabel() {
        return label;
    }
    
    public final void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * @hibernate.property
     *  column="registration_end"
     */
    public final Date getRegistrationEnd() {
        return registrationEnd;
    }

    public final void setRegistrationEnd(Date registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    /**
     * @hibernate.property
     *  column="registration_start"
     */
    public final Date getRegistrationStart() {
        return registrationStart;
    }
    
    public final void setRegistrationStart(Date registrationStart) {
        this.registrationStart = registrationStart;
    }
    
    /**
     * @hibernate.property
     *  column="validation_authorization_start"
     */
    public final Date getValidationAuthorizationStart() {
        return validationAuthorizationStart;
    }

    public final void setValidationAuthorizationStart(Date validationAuthorizationStart) {
        this.validationAuthorizationStart = validationAuthorizationStart;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof RequestSeason)) return false;

        final RequestSeason requestSeason = (RequestSeason) other;

        if (!getUuid().equals(requestSeason.getUuid()))
            return false;
        
        return true;
    }
    
    public int hashCode() {
        int result;
        result = getLabel().hashCode();
        result = 29 * result;
        if (getRequestType()!= null)
            result += getRequestType().hashCode();
        return result;
    }
}
