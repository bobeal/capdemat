package fr.cg95.cvq.business.payment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="external_deposit_account_item_detail")
public class ExternalDepositAccountItemDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private Date date;

    @Column(name="holder_name")
    private String holderName;

    @Column(name="holder_surname")
    private String holderSurname;
    private Integer value;

    @Column(name="payment_type")
    private String paymentType;

    @Column(name="payment_id")
    private String paymentId;

    @Column(name="bank_reference")
    private String bankReference;

    @ManyToOne(optional=false,fetch=FetchType.EAGER)
    @JoinColumn(name="external_deposit_account_item_id")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public final Date getDate() {
        return date;
    }

    public final void setDate(Date date) {
        this.date = date;
    }

    public final String getHolderName() {
        return holderName;
    }

    public final void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public final String getHolderSurname() {
        return holderSurname;
    }

    public final void setHolderSurname(String holderSurname) {
        this.holderSurname = holderSurname;
    }

    public final String getPaymentId() {
        return paymentId;
    }

    public final void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public final String getPaymentType() {
        return paymentType;
    }

    public final void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public final Integer getValue() {
        return value;
    }

    public final void setValue(Integer value) {
        this.value = value;
    }

    public final String getBankReference() {
        return bankReference;
    }

    public final void setBankReference(String bankReference) {
        this.bankReference = bankReference;
    }

    public ExternalDepositAccountItem getExternalDepositAccountItem() {
        return externalDepositAccountItem;
    }

    public void setExternalDepositAccountItem(ExternalDepositAccountItem externalDepositAccountItem) {
        this.externalDepositAccountItem = externalDepositAccountItem;
    }

}
