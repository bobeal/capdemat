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

    private String token;

    /**
     * Whether document digitalization is enabled for this local authority, defaults to true.
     */
    private boolean documentDigitalizationEnabled = true;

    /* using an explicit ArrayList instead of List interface to allow Hibernate to instantiate it */
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
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
     *  column="token"
     */
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
