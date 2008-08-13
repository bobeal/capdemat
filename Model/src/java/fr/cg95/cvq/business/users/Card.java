package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 * @hibernate.class
 *  table="card"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private Date cardDeliveryDate;
    private Date cardValidityDate;
    private String cardType;
    private String identifier;
    private String certificate;
    private String pin;
    private CardState cardState;

    /** full constructor */
    public Card(Date cardDeliveryDate, Date cardValidityDate, String cardType, String identifier, String certificate, String pin, CardState cardState) {
        this.cardDeliveryDate = cardDeliveryDate;
        this.cardValidityDate = cardValidityDate;
        this.cardType = cardType;
        this.identifier = identifier;
	this.certificate = certificate;
	this.pin = pin;
	this.cardState = cardState;
    }

    /** default constructor */
    public Card() {
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="card_delivery_date"
     */
    public Date getCardDeliveryDate() {
        return this.cardDeliveryDate;
    }

    public void setCardDeliveryDate(Date cardDeliveryDate) {
        this.cardDeliveryDate = cardDeliveryDate;
    }

    /**
     * @hibernate.property
     *  column="card_validity_date"
     */
    public Date getCardValidityDate() {
        return this.cardValidityDate;
    }

    public void setCardValidityDate(Date cardValidityDate) {
        this.cardValidityDate = cardValidityDate;
    }

    /**
     * @hibernate.property
     *  column="card_type"
     */
    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * @hibernate.property
     *  column="identifier"
     */
    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @hibernate.property
     *  column="certificate"
     *  length="4096"
     */
    public String getCertificate() {
        return this.certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * @hibernate.property
     *  column="pin"
     *  length="32"
     */
    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @hibernate.property
     *  column="card_state"
     *  length="16"
     */
    public CardState getCardState() {
        return this.cardState;
    }

    public void setCardState(CardState cardState) {
        this.cardState = cardState;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
