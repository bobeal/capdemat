package fr.cg95.cvq.business.payment.external;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @hibernate.class
 *  table="external_application"
 *  lazy="false"
 */
public class ExternalApplication {

    /** identifier field */
    private Long id;

    private String label;
    private String description;
    private Set<String> brokers = new HashSet<String>();
    private List<ExternalHomeFolder> externalHomeFolders = new ArrayList<ExternalHomeFolder>();

    public ExternalApplication() {
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
     *  column="label"
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @hibernate.set
     *  table="external_application_broker"
     *  lazy="false"
     * @hibernate.key
     *  column="external_application_id"
     * @hibernate.element
     *  column="broker"
     *  type="string"
     */
    public Set<String> getBrokers() {
        return brokers;
    }

    public String getFormattedBrokers() {
        String result = "";
        if (brokers.size() == 0) return result;
        for (String broker : brokers)
            result += broker + " / ";
        return result.substring(0, result.length() - 2);
    }

    public void setBrokers(Set<String> brokers) {
        this.brokers = brokers;
    }

    /**
     * @hibernate.property
     *  column="description"
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="external_home_folder"
     * @hibernate.key
     *  column="external_application_id"
     * @hibernate.list-index
     *  column="external_home_application_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.payment.external.ExternalHomeFolder"
     */
    public List<ExternalHomeFolder> getExternalHomeFolders() {
        return externalHomeFolders;
    }

    public void setExternalHomeFolders(List<ExternalHomeFolder> externalHomeFolders) {
        this.externalHomeFolders = externalHomeFolders;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ExternalApplication))
            return false;
        ExternalApplication externalApplication = (ExternalApplication) object;
        return (this.getLabel().equals(externalApplication.getLabel()));
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }

}
