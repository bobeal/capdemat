package fr.cg95.cvq.business.authority;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeSet;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.LocalAuthorityType;

/**
 * @hibernate.class
 *  table="local_authority"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class LocalAuthority implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String name;
    private String postalCode = "00000";
    private String displayTitle;
    private String adminEmail;
    private Integer draftLiveDuration = 20;
    private Integer draftNotificationBeforeDelete = 7;

    /**
     * Whether an email alert is sent to notify of newly created requests, defaults to false.
     */
    private boolean requestsCreationNotificationEnabled = false;

    /**
     * Whether document digitalization is enabled for this local authority, defaults to true.
     */
    private boolean documentDigitalizationEnabled = true;

    /**
     * Whether an email alert is sent to notify of requests whose instruction is in late, 
     * defaults to false.
     */
    private boolean instructionAlertsEnabled = false;

    /**
     * Whether, if instruction alerts are enabled, the email sent displays a detailed resume of 
     * requests to instruct, defaults to false.
     */
    private boolean instructionAlertsDetailed = false;

    private int instructionDefaultMaxDelay = 10;
    private int instructionDefaultAlertDelay = 3;

    /** using an explicit ArrayList instead of List interface to allow Hibernate to instantiate it */
    private TreeSet<String> serverNames = new TreeSet<String>();

    private Date paymentDeactivationStartDate;
    private Date paymentDeactivationEndDate;

    private boolean displayInProgressPayments;

    /** full constructor */
    public LocalAuthority(String name, String displayTitle) {
        this.name = name;
        this.displayTitle = displayTitle;
    }

    /** default constructor */
    public LocalAuthority() {
    }

    public static LocalAuthorityType modelToXml(LocalAuthority localAuthority) {

        LocalAuthorityType localAuthorityType = LocalAuthorityType.Factory.newInstance();
        localAuthorityType.setId(localAuthority.getId().longValue());
        localAuthorityType.setName(localAuthority.getName());
        localAuthorityType.setPostalCode(localAuthority.getPostalCode());
        return localAuthorityType;
    }

    public static LocalAuthority xmlToModel(LocalAuthorityType localAuthorityType) {

        LocalAuthority localAuthority = new LocalAuthority();
        localAuthority.setId(new Long(localAuthorityType.getId()));
        localAuthority.setName(localAuthorityType.getName());
        localAuthority.setPostalCode(localAuthorityType.getPostalCode());

        return localAuthority;
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
     *  column="name"
     *  not-null="true"
     *  length="32"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="display_title"
     *  not-null="true"
     *  length="100"
     */
    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    /**
     * @hibernate.property
     *  column="postal_code"
     *  not-null="true"
     *  length="5"
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @hibernate.property
     *  column="server_names"
     */
    public TreeSet<String> getServerNames() {
        return serverNames;
    }

    public void setServerNames(TreeSet<String> serverNames) {
        this.serverNames = serverNames;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    /**
     * @hibernate.property
     *  column="draft_live_duration"
     *  not-null="true"
     */
    public Integer getDraftLiveDuration() {
        return draftLiveDuration;
    }

    public void setDraftLiveDuration(Integer draftLiveDuration) {
        this.draftLiveDuration = draftLiveDuration;
    }

    /**
     * @hibernate.property
     *  column="draft_notification_before_delete"
     *  not-null="true"
     */
    public Integer getDraftNotificationBeforeDelete() {
        return draftNotificationBeforeDelete;
    }

    public void setDraftNotificationBeforeDelete(Integer draftNotificationBeforeDelete) {
        this.draftNotificationBeforeDelete = draftNotificationBeforeDelete;
    }

    /**
     * @hibernate.property
     *  column="requests_creation_notification_enabled"
     *  not-null="true"
     */
    public boolean isRequestsCreationNotificationEnabled() {
        return requestsCreationNotificationEnabled;
    }

    public void setRequestsCreationNotificationEnabled(boolean requestsCreationNotificationEnabled) {
        this.requestsCreationNotificationEnabled = requestsCreationNotificationEnabled;
    }

    /**
     * @hibernate.property
     *  column="document_digitalization_enabled"
     *  not-null="true"
     */
    public boolean isDocumentDigitalizationEnabled() {
        return documentDigitalizationEnabled;
    }

    public void setDocumentDigitalizationEnabled(boolean documentDigitalizationEnabled) {
        this.documentDigitalizationEnabled = documentDigitalizationEnabled;
    }

    /**
     * @hibernate.property
     *  column="instruction_alerts_enabled"
     *  not-null="true"
     */
    public boolean isInstructionAlertsEnabled() {
        return instructionAlertsEnabled;
    }

    public void setInstructionAlertsEnabled(boolean instructionAlertsEnabled) {
        this.instructionAlertsEnabled = instructionAlertsEnabled;
    }

    /**
     * @hibernate.property
     *  column="instruction_alerts_detailed"
     *  not-null="true"
     */
    public boolean isInstructionAlertsDetailed() {
        return instructionAlertsDetailed;
    }

    public void setInstructionAlertsDetailed(boolean instructionAlertsDetailed) {
        this.instructionAlertsDetailed = instructionAlertsDetailed;
    }

    /**
     * @hibernate.property
     *  column="instruction_default_max_delay"
     *  not-null="true"
     */
    public int getInstructionDefaultMaxDelay() {
        return instructionDefaultMaxDelay;
    }

    public void setInstructionDefaultMaxDelay(int instructionDefaultMaxDelay) {
        this.instructionDefaultMaxDelay = instructionDefaultMaxDelay;
    }

    /**
     * @hibernate.property
     *  column="instruction_default_alert_delay"
     *  not-null="true"
     */
    public int getInstructionDefaultAlertDelay() {
        return instructionDefaultAlertDelay;
    }

    public void setInstructionDefaultAlertDelay(int instructionDefaultAlertDelay) {
        this.instructionDefaultAlertDelay = instructionDefaultAlertDelay;
    }

    /**
     * @hibernate.property
     *  column="admin_email"
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    /**
     * @hibernate.property
     *  column="payment_deactivation_start_date"
     */
    public Date getPaymentDeactivationStartDate() {
        return paymentDeactivationStartDate;
    }

    public void setPaymentDeactivationStartDate(Date paymentDeactivationStartDate) {
        this.paymentDeactivationStartDate = paymentDeactivationStartDate;
    }

    /**
     * @hibernate.property
     *  column="payment_deactivation_end_date"
     */
    public Date getPaymentDeactivationEndDate() {
        return paymentDeactivationEndDate;
    }

    public void setPaymentDeactivationEndDate(Date paymentDeactivationEndDate) {
        this.paymentDeactivationEndDate = paymentDeactivationEndDate;
    }

    /**
     * @hibernate.property
     *  column="display_in_progress_payments"
     *  not-null="true"
     */
    public boolean isDisplayInProgressPayments() {
        return displayInProgressPayments;
    }

    public void setDisplayInProgressPayments(boolean displayInProgressPayments) {
        this.displayInProgressPayments = displayInProgressPayments;
    }
}
