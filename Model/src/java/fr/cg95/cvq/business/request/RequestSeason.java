package fr.cg95.cvq.business.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.DateMidnight;

import fr.cg95.cvq.xml.common.RequestSeasonType;

@Entity
@Table(name="request_season")
public class RequestSeason implements Serializable, Comparable<RequestSeason> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /** the associated (parent) request type */
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="request_type_id",nullable=false)
    private RequestType requestType;

    /** display purposes only */
    @Column(nullable=false)
    private String label;

    /** date from which users can issue new requests */
    @Column(name="registration_start", nullable=false)
    @Type(type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight")
    private DateMidnight registrationStart;

    /** date until which users can issue new requests */
    @Column(name="registration_end",nullable=false)
    @Type(type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight")
    private DateMidnight registrationEnd;

    /**
     * can block validations for a given season
     * until associated external services are ready to deal with them.
     */
    @Column(name="validation_authorization_start")
    @Type(type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight")
    private DateMidnight validationAuthorizationStart;

    /** date from which registration will be considered as active */
    @Column(name="effect_start", nullable=false)
    @Type(type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight")
    private DateMidnight effectStart;

    /** date to which registration will be considered as active */
    @Column(name="effect_end", nullable=false)
    @Type(type="fr.cg95.cvq.dao.hibernate.PersistentDateMidnight")
    private DateMidnight effectEnd;

    public final RequestType getRequestType() {
        return requestType;
    }

    public final void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public final DateMidnight getEffectEnd() {
        return effectEnd;
    }

    public final void setEffectEnd(DateMidnight effectEnd) {
        this.effectEnd = effectEnd;
    }

    public final DateMidnight getEffectStart() {
        return effectStart;
    }

    public final void setEffectStart(DateMidnight effectStart) {
        this.effectStart = effectStart;
    }

    public final String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    public final DateMidnight getRegistrationEnd() {
        return registrationEnd;
    }

    public final void setRegistrationEnd(DateMidnight registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

    public final DateMidnight getRegistrationStart() {
        return registrationStart;
    }

    public final void setRegistrationStart(DateMidnight registrationStart) {
        this.registrationStart = registrationStart;
    }

    public final DateMidnight getValidationAuthorizationStart() {
        return validationAuthorizationStart;
    }

    public final void setValidationAuthorizationStart(DateMidnight validationAuthorizationStart) {
        this.validationAuthorizationStart = validationAuthorizationStart;
    }

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
