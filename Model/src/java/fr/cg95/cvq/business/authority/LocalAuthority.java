package fr.cg95.cvq.business.authority;

import java.io.Serializable;

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
    private String postalCode;
    private Integer draftLiveDuration;
    private Integer draftNotificationBeforeDelete;

    /** full constructor */
    public LocalAuthority(String name, String postalCode) {
        this.name = name;
        this.postalCode = postalCode;
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
}
