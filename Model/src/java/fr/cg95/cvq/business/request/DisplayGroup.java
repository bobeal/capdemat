package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.Set;
import java.util.List;

/**
 * @hibernate.class
 *  table="display_group"
 *  lazy="true"
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DisplayGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String label;
    private Set<RequestType> requestTypes;

    
    public DisplayGroup() {
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
     *  column="name"
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     *  inverse="false"
     * @hibernate.key
     *  column="display_group_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestType"
     */
    public Set<RequestType> getRequestTypes() {
        return requestTypes;
    }

    public void setRequestTypes(Set<RequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }
}
