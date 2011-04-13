package fr.cg95.cvq.business.payment;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="payment")
public class Payment implements Serializable, Comparable<Payment> {

	private static final long serialVersionUID = 1L;
	
    public static final String SEARCH_BY_HOME_FOLDER_ID = "homeFolderId";
    public static final String SEARCH_BY_REQUESTER_LASTNAME = "requesterLastName";
    public static final String SEARCH_BY_CVQ_REFERENCE = "cvqReference";
    public static final String SEARCH_BY_BANK_REFERENCE = "bankReference";
    public static final String SEARCH_BY_INITIALIZATION_DATE = "initializationDate";
    public static final String SEARCH_BY_PAYMENT_STATE = "paymentState";
    public static final String SEARCH_BY_BROKER = "broker";
    public static final String SEARCH_BY_PAYMENT_MODE = "paymentMode";

    /**
     * Specific data automatically added to any payment container.
     */
    public static final String SPECIFIC_DATA_DOMAIN_NAME = "domainName";

    /**
     * Specific data automatically added to any payment container.
     */
    public static final String SPECIFIC_DATA_EMAIL = "email";

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /** the broker ("régie" in french) to which this payment is made */
    private String broker;

    /** internal reference */
    @Column(name="cvq_reference")
    private String cvqReference;
    
    /** bank transaction reference */
    @Column(name="bank_reference")
    private String bankReference;

    @Column(name="initialization_date")
    private Date initializationDate;

    @Column(name="commit_date")
    private Date commitDate;

    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name="state", length=15)
    private PaymentState state;

    @Column(name="home_folder_id",nullable=false)
    private Long homeFolderId;

    @Column(name="requester_id",nullable=false)
    private Long requesterId;

    @Column(name="requester_last_name",length=38,nullable=false)
    private String requesterLastName;

    @Column(name="requester_first_name",length=38,nullable=false)
    private String requesterFirstName;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_mode",length=10)
    private PaymentMode paymentMode;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="payment_id")
    private Set<PurchaseItem> purchaseItems;

    @Column(name="commit_alert")
    private boolean commitAlert;

    /** 
     * Used to pass payment providers specific information, eg the "borne" from which
     * a payment is initiated. These informations won't be persisted.
     */
    @Transient private Map<String, String> paymentSpecificData = new HashMap<String, String>();

    public Payment() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public final String getCvqReference() {
        return this.cvqReference;
    }

    public final void setCvqReference(final String cvqReference) {
        this.cvqReference = cvqReference;
    }

    public final String getBankReference() {
        return this.bankReference;
    }

    public final void setBankReference(final String bankReference) {
        this.bankReference = bankReference;
    }

    public final Date getInitializationDate() {
        return initializationDate;
    }

    public final void setInitializationDate(final Date initializationDate) {
        this.initializationDate = initializationDate;
    }

    public final Date getCommitDate() {
        return this.commitDate;
    }

    public final void setCommitDate(final Date validationDate) {
        this.commitDate = validationDate;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final Float getEuroAmount() {
        return (amount.floatValue()) / 100;
    }

    public final void setAmount(final Double amount) {
        this.amount = amount;
    }

    /**
     * Return the value of the bill formated in euros instead of cents.
     */
    public final String getFormatedAmount() {
        return String.valueOf(amount.doubleValue()/100);
    }

    public final PaymentState getState() {
        return state;
    }

    public final void setState(final PaymentState state) {
        this.state = state;
    }

    public Long getHomeFolderId() {
        return this.homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    public final Long getRequesterId() {
        return requesterId;
    }

    public final void setRequesterId(final Long requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterLastName() {
        return requesterLastName;
    }

    public void setRequesterLastName(String requesterLastName) {
        this.requesterLastName = requesterLastName;
    }

    public String getRequesterFirstName() {
        return requesterFirstName;
    }

    public void setRequesterFirstName(String requesterFirstName) {
        this.requesterFirstName = requesterFirstName;
    }

    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public final Set<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public final void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

	public boolean isCommitAlert() {
		return commitAlert;
	}

	public void setCommitAlert(boolean commitAlert) {
		this.commitAlert = commitAlert;
	}
	
    public void addPaymentSpecificData(final String key, final String value) {
        this.paymentSpecificData.put(key, value);
    }
    
    public void removePaymentSpecificData(final String key) {
        this.paymentSpecificData.remove(key);
    }
    
    public final Map<String, String> getPaymentSpecificData() {
        return paymentSpecificData;
    }

    public final String getPaymentSpecificDataByKey(String key) {
        return paymentSpecificData.get(key);
    }

    public final void setPaymentSpecificData(Map<String, String> paymentSpecificData) {
        this.paymentSpecificData = paymentSpecificData;
    }

    public int compareTo(Payment o) {
        return -commitDate.compareTo(o.commitDate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }
}
