package fr.cg95.cvq.business.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @hibernate.class
 *  table="display_group"
 *  lazy="false"
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
    
    public DisplayGroup(String name, String label) {
        this.name = name;
        this.label = label;
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
     *  inverse="true"
     *  lazy="true"
     * @hibernate.key
     *  column="display_group_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.RequestType"
     */
    public Set<RequestType> getRequestTypes() {
        if (requestTypes == null)
            return new HashSet<RequestType>();
        return requestTypes;
    }

    public void setRequestTypes(Set<RequestType> requestTypes) {
        this.requestTypes = requestTypes;
    }
}
