package fr.cg95.cvq.business.users.payment;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;


/** 
 * @hibernate.class
 *  table="payment"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 * @author rdj@zenexity.fr
 */
public class Payment implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;

    private Long id;
    /** the broker ("régie" in french) to which this payment is made */
    private String broker;
    /** internal reference */
    private String cvqReference;
    /** bank transaction reference */
    private String bankReference;
    private Date initializationDate;
    private Date commitDate;
    private Double amount;
    private PaymentState state;
    private HomeFolder homeFolder;
    private Adult requester;
    private PaymentMode paymentMode;
    private Set purchaseItems;
    private boolean commitAlert;
    
    /** 
     * Used to pass payment providers specific information, eg the "borne" from which
     * a payment is initiated. These informations won't be persisted.
     */
    private Map<String, String> paymentSpecificData = new HashMap<String, String>();
    
    public Payment() {
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
     *  column="broker"
     */
    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
     * @hibernate.property
     *  column="cvq_reference"
     */
    public final String getCvqReference() {
        return this.cvqReference;
    }

    public final void setCvqReference(final String cvqReference) {
        this.cvqReference = cvqReference;
    }

    /**
     * @hibernate.property
     *  column="bank_reference"
     */
    public final String getBankReference() {
        return this.bankReference;
    }

    public final void setBankReference(final String bankReference) {
        this.bankReference = bankReference;
    }

    /**
     * @hibernate.property
     *  column="initialization_date"
     */
    public final Date getInitializationDate() {
        return initializationDate;
    }

    public final void setInitializationDate(final Date initializationDate) {
        this.initializationDate = initializationDate;
    }

    /**
     * @hibernate.property
     *  column="commit_date"
     */
    public final Date getCommitDate() {
        return this.commitDate;
    }

    public final void setCommitDate(final Date validationDate) {
        this.commitDate = validationDate;
    }

    /**
     * @hibernate.property
     *  column="amount"
     */
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

    /**
     * @hibernate.property
     *  column="state"
     *  length="15"
     */
    public final PaymentState getState() {
        return state;
    }

    public final void setState(final PaymentState state) {
        this.state = state;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.HomeFolder"
     *  column="home_folder_id"
     *  not-null="true"
     */
    public HomeFolder getHomeFolder() {
        return this.homeFolder;
    }

    public void setHomeFolder(HomeFolder homeFolder) {
        this.homeFolder = homeFolder;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Adult"
     *  column="requester_id"
     *  not-null="true"
     */
    public final Adult getRequester() {
        return requester;
    }

    public final void setRequester(final Adult requester) {
        this.requester = requester;
    }

    /**
     * @hibernate.property
     *  column="payment_mode"
     *  length="10"
     */
    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="all"
     * @hibernate.key
     *  column="payment_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.payment.PurchaseItem"
     */
    public final Set getPurchaseItems() {
        return purchaseItems;
    }

    public final void setPurchaseItems(Set purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    /**
     * @hibernate.property
     *  column="commit_alert"
     */
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
    
    public int compareTo(Object o) {
        if (o instanceof Payment)
            return -commitDate.compareTo(((Payment) o).commitDate);
        return 0;
    }

    public final Map<String, String> getPaymentSpecificData() {
        return paymentSpecificData;
    }

    public final void setPaymentSpecificData(Map<String, String> paymentSpecificData) {
        this.paymentSpecificData = paymentSpecificData;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
