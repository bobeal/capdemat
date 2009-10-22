package fr.cg95.cvq.business.request;

import java.io.Serializable;

import org.joda.time.DateMidnight;

import fr.cg95.cvq.xml.common.RequestSeasonType;

/**
 * @hibernate.class
 *  table="request_season"
 *  lazy="false"
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestSeason implements Serializable, Comparable<RequestSeason> {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** the associated (parent) request type */
    private RequestType requestType;

    /** display purposes only */
    private String label;

    /** date from which users can issue new requests */
    private DateMidnight registrationStart;

    /** date until which users can issue new requests */
    private DateMidnight registrationEnd;

    /**
     * can block validations for a given season
     * until associated external services are ready to deal with them.
     */
    private DateMidnight validationAuthorizationStart;

    /** date from which registration will be considered as active */
    private DateMidnight effectStart;

    /** date to which registration will be considered as active */
    private DateMidnight effectEnd;

    /**
     * @hibernate.many-to-one
     *  column="request_type_id"
     *  class="fr.cg95.cvq.business.request.RequestType"
     *  not-null="true"
     */
    public final RequestType getRequestType() {
        return requestType;
    }

    public final void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * @hibernate.property
     *  column="effect_end"
     *  type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight"
     *  not-null="true"
     */
    public final DateMidnight getEffectEnd() {
        return effectEnd;
    }

    public final void setEffectEnd(DateMidnight effectEnd) {
        this.effectEnd = effectEnd;
    }

    /**
     * @hibernate.property
     *  column="effect_start"
     *  type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight"
     *  not-null="true"
     */
    public final DateMidnight getEffectStart() {
        return effectStart;
    }

    public final void setEffectStart(DateMidnight effectStart) {
        this.effectStart = effectStart;
    }

    /**
     * @hibernate.property
     *  column="label"
     *  not-null="true"
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
     *  type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight"
     *  not-null="true"
     */
    public final DateMidnight getRegistrationEnd() {
        return registrationEnd;
    }

    public final void setRegistrationEnd(DateMidnight registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    /**
     * @hibernate.property
     *  column="registration_start"
     *  type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight"
     *  not-null="true"
     */
    public final DateMidnight getRegistrationStart() {
        return registrationStart;
    }

    public final void setRegistrationStart(DateMidnight registrationStart) {
        this.registrationStart = registrationStart;
    }

    /**
     * @hibernate.property
     *  column="validation_authorization_start"
     *  type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight"
     */
    public final DateMidnight getValidationAuthorizationStart() {
        return validationAuthorizationStart;
    }

    public final void setValidationAuthorizationStart(DateMidnight validationAuthorizationStart) {
        this.validationAuthorizationStart = validationAuthorizationStart;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int compareTo(RequestSeason o) {
        int dateComparison = getEffectStart().compareTo(o.getEffectStart());
        return
            dateComparison != 0 ? dateComparison : getId().compareTo(o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RequestSeason)) {
            return false;
        }
        return getId().equals(((RequestSeason)obj).getId());
    }

    @Override
    public int hashCode() {
        if (getId() == null) return new Long(0).hashCode();
        return new Long(getId()).hashCode();
    }

    public static RequestSeasonType modelToXml(RequestSeason requestSeason) {
        if (requestSeason == null) return null;
        RequestSeasonType requestSeasonType = RequestSeasonType.Factory.newInstance();
        if (requestSeason.getId() != null)
            requestSeasonType.setId(requestSeason.getId().longValue());
        requestSeasonType.setLabel(requestSeason.getLabel());
        if (requestSeason.getRegistrationStart() != null)
            requestSeasonType.setRegistrationStart(requestSeason.getRegistrationStart().toGregorianCalendar());
        if (requestSeason.getRegistrationEnd() != null)
            requestSeasonType.setRegistrationEnd(requestSeason.getRegistrationEnd().toGregorianCalendar());
        if (requestSeason.getValidationAuthorizationStart() != null)
            requestSeasonType.setValidationAuthorizationStart(requestSeason.getValidationAuthorizationStart().toGregorianCalendar());
        if (requestSeason.getEffectStart() != null)
            requestSeasonType.setEffectStart(requestSeason.getEffectStart().toGregorianCalendar());
        if (requestSeason.getEffectEnd() != null)
            requestSeasonType.setEffectEnd(requestSeason.getEffectEnd().toGregorianCalendar());
        return requestSeasonType;
    }

    public static RequestSeason xmlToModel(RequestSeasonType requestSeasonType) {
        if (requestSeasonType == null) return null;
        RequestSeason requestSeason = new RequestSeason();
        requestSeason.setId(requestSeasonType.getId());
        requestSeason.setLabel(requestSeasonType.getLabel());
        requestSeason.setRegistrationStart(new DateMidnight(requestSeasonType.getRegistrationStart()));
        requestSeason.setRegistrationEnd(new DateMidnight(requestSeasonType.getRegistrationEnd()));
        requestSeason.setValidationAuthorizationStart(new DateMidnight(requestSeasonType.getValidationAuthorizationStart()));
        requestSeason.setEffectStart(new DateMidnight(requestSeasonType.getEffectStart()));
        requestSeason.setEffectEnd(new DateMidnight(requestSeasonType.getEffectEnd()));
        return requestSeason;
    }
}
