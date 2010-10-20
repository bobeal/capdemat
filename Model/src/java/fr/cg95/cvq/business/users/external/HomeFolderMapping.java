package fr.cg95.cvq.business.users.external;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @hibernate.class
 *  table="home_folder_mapping"
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String externalServiceLabel;
    private Long homeFolderId;
    private String externalCapDematId;
    private String externalId;
    private List<IndividualMapping> individualsMappings;

    
    public HomeFolderMapping() {
    }

    public HomeFolderMapping(String externalServiceLabel, Long homeFolderId,  String externalId) {
        this.externalServiceLabel = externalServiceLabel;
        this.homeFolderId = homeFolderId;
        this.externalCapDematId = UUID.randomUUID().toString();
        this.externalId = externalId;
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
     *  column="external_service_label"
     */
    public String getExternalServiceLabel() {
        return externalServiceLabel;
    }

    public void setExternalServiceLabel(String externalServiceLabel) {
        this.externalServiceLabel = externalServiceLabel;
    }

    /**
     * @hibernate.property
     *  column="home_folder_id"
     */
    public Long getHomeFolderId() {
        return homeFolderId;
    }

    public void setHomeFolderId(Long homeFolderId) {
        this.homeFolderId = homeFolderId;
    }

    /**
     * @hibernate.property
     *  column="external_capdemat_id"
     */
    public String getExternalCapDematId() {
        return externalCapDematId;
    }

    public void setExternalCapDematId(String externalCapDematId) {
        this.externalCapDematId = externalCapDematId;
    }

    /**
     * @hibernate.property
     *  column="external_id"
     */
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  table="individual_mapping"
     *  cascade="all"
     * @hibernate.key
     *  column="home_folder_mapping_id"
     * @hibernate.list-index
     *  column="home_folder_mapping_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.external.IndividualMapping"
     */
    public List<IndividualMapping> getIndividualsMappings() {
        if (individualsMappings == null)
            individualsMappings = new ArrayList<IndividualMapping>();
        return individualsMappings;
    }

    public void setIndividualsMappings(List<IndividualMapping> individualsMappings) {
        this.individualsMappings = individualsMappings;
    }

}
