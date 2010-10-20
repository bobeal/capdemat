package fr.cg95.cvq.business.payment.external;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.business.users.external.MappingState;

/**
 * @hibernate.class
 *  table="external_home_folder"
 *  lazy="false"
 */
public class ExternalHomeFolder {

    /** identifier field */
    private Long id;

    private MappingState mappingState;
    private String externalId;
    private ExternalApplication externalApplication;
    private String address;
    private List<ExternalIndividual> individuals = new ArrayList<ExternalIndividual>();

    public ExternalHomeFolder() {
    }

    public ExternalHomeFolder(String externalId, ExternalApplication externalApplication,
            String address) {
        this.externalId = externalId;
        this.externalApplication = externalApplication;
        this.address = address;
        this.mappingState = MappingState.FREE;
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
     *  column="mapping_state"
     *  not-null="true"
     */
    public MappingState getMappingState() {
        return mappingState;
    }

    public void setMappingState(MappingState mappingState) {
        this.mappingState = mappingState;
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
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.payment.external.ExternalApplication"
     *  column="external_application_id"
     */
    public ExternalApplication getExternalApplication() {
        return externalApplication;
    }

    public void setExternalApplication(ExternalApplication externalApplication) {
        this.externalApplication = externalApplication;
    }

    /**
     * @hibernate.property
     *  column="address"
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = StringUtils.upperCase(address);
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="external_individual"
     * @hibernate.key
     *  column="external_home_folder_id"
     * @hibernate.list-index
     *  column="external_home_folder_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.payment.external.ExternalIndividual"
     */
    public List<ExternalIndividual> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<ExternalIndividual> individuals) {
        this.individuals = individuals;
    }

    public ExternalIndividual getResponsible() {
        for(ExternalIndividual ei : individuals)
            if (ei.isResponsible())
                return ei;
        return null;
    }

    public String getCompositeIdForMapping() {
        return externalApplication.getLabel() + ":"+externalId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ExternalHomeFolder))
            return false;
        ExternalHomeFolder eh = (ExternalHomeFolder) object;
        return (this.externalApplication.getLabel().equals(eh.getExternalApplication().getLabel())
                && (this.externalId.equals(eh.getExternalId())));
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

}
