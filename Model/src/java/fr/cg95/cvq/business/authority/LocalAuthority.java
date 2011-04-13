package fr.cg95.cvq.business.authority;

import java.io.Serializable;
import java.util.Date;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.LocalAuthorityType;

@Entity
@Table(name="local_authority")
public class LocalAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="name", length=32,nullable=false)
    private String name;

    @Column(name="postal_code", length=5,nullable=false)
    private String postalCode = "00000";

    @Column(name="display_title", length=100, nullable=false)
    private String displayTitle;

    @Column(name="admin_email")
    private String adminEmail;

    @Column(name="token")
    private String token;

    /**
     * Whether document digitalization is enabled for this local authority, defaults to true.
     */
    @Column(name="document_digitalization_enabled", nullable=false)
    private boolean documentDigitalizationEnabled = true;

    /* using an explicit ArrayList instead of List interface to allow Hibernate to instantiate it */
    @Column(name="server_names")
    private TreeSet<String> serverNames = new TreeSet<String>();

    @Column(name="payment_deactivation_start_date")
    private Date paymentDeactivationStartDate;

    @Column(name="payment_deactivation_end_date")
    private Date paymentDeactivationEndDate;

    @Column(name="display_in_progress_payments", nullable=false)
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

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

    public boolean isDocumentDigitalizationEnabled() {
        return documentDigitalizationEnabled;
    }

    public void setDocumentDigitalizationEnabled(boolean documentDigitalizationEnabled) {
        this.documentDigitalizationEnabled = documentDigitalizationEnabled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }


    public Date getPaymentDeactivationStartDate() {
        return paymentDeactivationStartDate;
    }

    public void setPaymentDeactivationStartDate(Date paymentDeactivationStartDate) {
        this.paymentDeactivationStartDate = paymentDeactivationStartDate;
    }

    public Date getPaymentDeactivationEndDate() {
        return paymentDeactivationEndDate;
    }

    public void setPaymentDeactivationEndDate(Date paymentDeactivationEndDate) {
        this.paymentDeactivationEndDate = paymentDeactivationEndDate;
    }

    public boolean isDisplayInProgressPayments() {
        return displayInProgressPayments;
    }

    public void setDisplayInProgressPayments(boolean displayInProgressPayments) {
        this.displayInProgressPayments = displayInProgressPayments;
    }
}
