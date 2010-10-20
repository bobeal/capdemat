package fr.cg95.cvq.business.users.external;

import java.io.Serializable;
import java.util.UUID;

/**
 * @hibernate.class
 *  table="individual_mapping"
 *  lazy="false"
 */
public class IndividualMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    private Long id;

    private Long individualId;
    private String externalCapDematId;
    private String externalId;
    private HomeFolderMapping homeFolderMapping;

    public IndividualMapping() {
    }

    public IndividualMapping(Long individualId, String externalId, HomeFolderMapping homeFolderMapping) {
        this.externalCapDematId = UUID.randomUUID().toString();
        this.individualId = individualId;
        this.externalId = externalId;
        this.homeFolderMapping = homeFolderMapping;
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
     *  column="individual_id"
     */
    public Long getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Long individualId) {
        this.individualId = individualId != null ? individualId : 0L;
    }

    /**
     * @hibernate.property
     *  column="external_capdemat_id"
     */
    public String getExternalCapDematId() {
        return externalCapDematId;
    }

    public void setExternalCapDematId(String externalCapDematId) {
        this.externalCapDematId =
            externalCapDematId != null ? externalCapDematId : "";
    }

    /**
     * @hibernate.property
     *  column="external_id"
     */
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId != null ? externalId : "";
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.external.HomeFolderMapping"
     *  column="home_folder_mapping_id"
     */
    public HomeFolderMapping getHomeFolderMapping() {
        return homeFolderMapping;
    }

    public void setHomeFolderMapping(HomeFolderMapping homeFolderMapping) {
        this.homeFolderMapping = homeFolderMapping;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IndividualMapping))
            return false;
        if (this == object)
            return true;
        IndividualMapping mapping = (IndividualMapping) object;
        if (this.id == null && mapping.id == null)
            return (this.externalId.equals(mapping.externalId));
        else
            return this.id == mapping.id;
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }
}
