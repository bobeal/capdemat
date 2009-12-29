package fr.cg95.cvq.business.external;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @hibernate.class
 *  table="external_service_identifier_mapping"
 *
 * @author bor@zenexity.fr
 */
public class ExternalServiceIdentifierMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String externalServiceLabel;
    private Long homeFolderId;
    private String externalCapDematId;
    private String externalId;
    
    private Set<ExternalServiceIndividualMapping> individualsMappings;

    
    public ExternalServiceIdentifierMapping() {
    }

    public ExternalServiceIdentifierMapping(String externalServiceLabel, Long homeFolderId,
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
     *  table="external_service_individual_mapping"
     *  cascade="all"
     * @hibernate.key
     *  column="mapping_id"
     * @hibernate.composite-element
     *  class="fr.cg95.cvq.business.external.ExternalServiceIndividualMapping"
     */
    public Set<ExternalServiceIndividualMapping> getIndividualsMappings() {
        return individualsMappings;
    }

    public void setIndividualsMappings(Set<ExternalServiceIndividualMapping> individualsMappings) {
        this.individualsMappings = individualsMappings;
    }
    
    public void addIndividualMapping(final Long individualId, final String externalCapDematId, 
            final String externalId) {
        ExternalServiceIndividualMapping esim = new ExternalServiceIndividualMapping();
        esim.setIndividualId(individualId);
        esim.setExternalCapDematId(externalCapDematId);
        esim.setExternalId(externalId);
        
        if (this.individualsMappings == null)
            this.individualsMappings = new HashSet<ExternalServiceIndividualMapping>();
        
        this.individualsMappings.add(esim);
    }
}
