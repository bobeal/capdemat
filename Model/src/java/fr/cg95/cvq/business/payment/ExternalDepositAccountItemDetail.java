package fr.cg95.cvq.business.payment;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class
 *  table="external_deposit_account_item_detail"
 *  lazy="false"
 */
public class ExternalDepositAccountItemDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date date;
    private String holderName;
    private String holderSurname;
    private Integer value;
    private String paymentType;
    private String paymentId;
    private String bankReference;
    private ExternalDepositAccountItem externalDepositAccountItem;

    public ExternalDepositAccountItemDetail() {
    }

    public ExternalDepositAccountItemDetail(final Date date, final String holderName, final String holderSurname,
            final Integer value, final String paymentType, final String paymentId, final String bankReference) {
        this.date = date;
        this.holderName = holderName;
        this.holderSurname = holderSurname;
        this.value = value;
        this.paymentType = paymentType;
        this.paymentId = paymentId;
        this.bankReference = bankReference;
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

    /**
     * @hibernate.property
     *  column="date"
     */
    public final Date getDate() {
        return date;
    }

    public final void setDate(Date date) {
        this.date = date;
    }

    /**
     * @hibernate.property
     *  column="holder_name"
     */
    public final String getHolderName() {
        return holderName;
    }

    public final void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * @hibernate.property
     *  column="holder_surname"
     */
    public final String getHolderSurname() {
        return holderSurname;
    }

    public final void setHolderSurname(String holderSurname) {
        this.holderSurname = holderSurname;
    }

    /**
     * @hibernate.property
     *  column="payment_id"
     */
    public final String getPaymentId() {
        return paymentId;
    }

    public final void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @hibernate.property
     *  column="payment_type"
     */
    public final String getPaymentType() {
        return paymentType;
    }

    public final void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @hibernate.property
     *  column="value"
     */
    public final Integer getValue() {
        return value;
    }

    public final void setValue(Integer value) {
        this.value = value;
    }

    /**
     * @hibernate.property
     *  column="bank_reference"
     */
    public final String getBankReference() {
        return bankReference;
    }

    public final void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    /**
     * @hibernate.many-to-one
     *  column="external_deposit_account_item_id"
     *  not-null="true"
     *  class="fr.cg95.cvq.business.payment.ExternalDepositAccountItem"
     */
    public ExternalDepositAccountItem getExternalDepositAccountItem() {
        return externalDepositAccountItem;
    }

    public void setExternalDepositAccountItem(ExternalDepositAccountItem externalDepositAccountItem) {
        this.externalDepositAccountItem = externalDepositAccountItem;
    }

}
