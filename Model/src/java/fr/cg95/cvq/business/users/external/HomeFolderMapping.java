package fr.cg95.cvq.business.users.external;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


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
    
    private Set<IndividualMapping> individualsMappings;

    
    public HomeFolderMapping() {
    }

    public HomeFolderMapping(String externalServiceLabel, Long homeFolderId,
            String externalCapDematId, String externalId) {
        this.externalServiceLabel = externalServiceLabel;
        this.homeFolderId = homeFolderId;
        this.externalCapDematId = externalCapDematId;
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
     * @hibernate.set
     *  lazy="true"
     *  table="individual_mapping"
     *  cascade="all"
     * @hibernate.key
     *  column="mapping_id"
     * @hibernate.composite-element
     *  class="fr.cg95.cvq.business.users.external.IndividualMapping"
     */
    public Set<IndividualMapping> getIndividualsMappings() {
        return individualsMappings;
    }

    public void setIndividualsMappings(Set<IndividualMapping> individualsMappings) {
        this.individualsMappings = individualsMappings;
    }
    
    public void addIndividualMapping(final Long individualId, final String externalCapDematId, 
            final String externalId) {
        IndividualMapping esim = 
            new IndividualMapping(individualId, externalCapDematId, externalId);

        if (this.individualsMappings == null)
            this.individualsMappings = new HashSet<IndividualMapping>();
        
        this.individualsMappings.add(esim);
    }
}
