package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.cg95.cvq.xml.common.LocalReferentialDataType;


/**
 * @hibernate.class
 *  table="local_referential_data"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class LocalReferentialData implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;

    private String name;
    private Integer priority;
    private String additionalInformationLabel;
    private String additionalInformationValue;
    private Set children;
    private LocalReferentialData parent;

    public LocalReferentialData() {}

    public static LocalReferentialDataType modelToXml(LocalReferentialData localReferentialData) {

        LocalReferentialDataType localReferentialDataType =
            LocalReferentialDataType.Factory.newInstance();
        if (localReferentialData.getId() != null)
            localReferentialDataType.setId(localReferentialData.getId().longValue());
        localReferentialDataType.setName(localReferentialData.getName());
        if (localReferentialData.getPriority() != null)
            localReferentialDataType.setPriority(new BigInteger(localReferentialData.getPriority().toString()));
        if (localReferentialData.getAdditionalInformationLabel() != null)
            localReferentialDataType.setAdditionalInformationLabel(localReferentialData.getAdditionalInformationLabel());
        if (localReferentialData.getAdditionalInformationValue() != null)
            localReferentialDataType.setAdditionalInformationValue(localReferentialData.getAdditionalInformationValue());
        if (localReferentialData.getChildren() != null) {
            LocalReferentialDataType[] lrdTab =
                new LocalReferentialDataType[localReferentialData.getChildren().size()];
            int i = 0;
            Iterator childrenIt = localReferentialData.getChildren().iterator();
            while (childrenIt.hasNext()) {
                LocalReferentialData lrd = (LocalReferentialData) childrenIt.next();
                lrdTab[i] = LocalReferentialData.modelToXml(lrd);
                i++;
            }
            localReferentialDataType.setChildrenArray(lrdTab);
        }
        return localReferentialDataType;
    }

    public static LocalReferentialData xmlToModel(LocalReferentialDataType localReferentialDataType) {

        LocalReferentialData localReferentialData = new LocalReferentialData();
        if (localReferentialDataType.getId() != 0)
            localReferentialData.setId(new Long(localReferentialDataType.getId()));
        localReferentialData.setName(localReferentialDataType.getName());
        if (localReferentialDataType.getPriority() != null)
            localReferentialData.setPriority(new Integer(localReferentialDataType.getPriority().intValue()));
        if (localReferentialDataType.getAdditionalInformationLabel() != null)
            localReferentialData.setAdditionalInformationLabel(localReferentialDataType.getAdditionalInformationLabel());
        if (localReferentialDataType.getAdditionalInformationValue() != null)
            localReferentialData.setAdditionalInformationValue(localReferentialDataType.getAdditionalInformationValue());
        HashSet<LocalReferentialData> childrenSet = new HashSet<LocalReferentialData>();
        if (localReferentialDataType.sizeOfChildrenArray() > 0) {
            for (int i = 0; i < localReferentialDataType.getChildrenArray().length; i++) {
                LocalReferentialData tempData =
                    LocalReferentialData.xmlToModel(localReferentialDataType.getChildrenArray(i));
                tempData.setParent(localReferentialData);
                childrenSet.add(tempData);
            }
        }
        localReferentialData.setChildren(childrenSet);

        return localReferentialData;
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
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="priority"
     */
    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * @hibernate.property
     *  column="additional_information_label"
     */
    public String getAdditionalInformationLabel() {
        return this.additionalInformationLabel;
    }

    public void setAdditionalInformationLabel(String additionalInformationLabel) {
        this.additionalInformationLabel = additionalInformationLabel;
    }

    /**
     * @hibernate.property
     *  column="additional_information_value"
     */
    public String getAdditionalInformationValue() {
        return this.additionalInformationValue;
    }

    public void setAdditionalInformationValue(String additionalInformationValue) {
        this.additionalInformationValue = additionalInformationValue;
    }

    /**
     * @hibernate.set
     *  table="local_referential_association"
     *  inverse="false"
     *  lazy="true"
     *  cascade="all-delete-orphan"
     * @hibernate.key
     *  column="local_referential_parent_data_id"
     * @hibernate.many-to-many
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     *  column="local_referential_child_data_id"
     */
    public Set getChildren() {
        return this.children;
    }

    public void setChildren(Set children) {
        this.children = children;
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     *  column="local_referential_parent_data_id"
     */
    public LocalReferentialData getParent() {
        return this.parent;
    }

    public void setParent(LocalReferentialData parent) {
        this.parent = parent;
    }
    
    public boolean equals(Object object) {
        if (object == null)
            return false;
        if (!(object instanceof LocalReferentialData))
            return false;

        LocalReferentialData toCompareWith = (LocalReferentialData) object;
        if (id != null) {
            return id.equals(toCompareWith.getId());
        } else {
            if (toCompareWith.getId() != null)
                return false;
            else {
                if (name != null)
                    return name.equals(toCompareWith.getName());
                else {
                    if (toCompareWith.getName() != null)
                        return false;
                    else
                        return true;
                }
            }
                
        }
    }
    
    public int hashCode() {
        if (id != null)
            return 42 * id.hashCode();
        return 42 * name.hashCode();
    }
}
