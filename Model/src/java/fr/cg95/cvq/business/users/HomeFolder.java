package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.HomeFolderType;
import fr.cg95.cvq.xml.common.IndividualType;

/**
 * @hibernate.class
 *  table="home_folder"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class HomeFolder implements fr.cg95.cvq.business.Historizable,Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private ActorState state;
    private Address adress;
    private Boolean enabled;
    private String familyQuotient;
    
    private Long originRequestId;
    private Boolean boundToRequest;
    
    private Set documents;
    private Set payments;
    private Set individuals;
    private Set requests;

    /** default constructor */
    public HomeFolder() {
    }

    public HomeFolderType modelToXml() {

        HomeFolderType homeFolderType = HomeFolderType.Factory.newInstance();
        if (this.id != null)
            homeFolderType.setId(this.id.longValue());
        if (this.adress != null)
            homeFolderType.setAddress(Address.modelToXml(this.adress));

        IndividualType[] individualsArray = new IndividualType[individuals.size()];
        Iterator individualsIt = individuals.iterator();
        int i = 0;
        while (individualsIt.hasNext()) {
            Individual individual = (Individual) individualsIt.next();
            if (individual instanceof Adult) {
                Adult adult = (Adult) individual;
                individualsArray[i] = Adult.modelToXml(adult);
            } else if (individual instanceof Child) {
                Child child = (Child) individual;
                individualsArray[i] = Child.modelToXml(child);
            }
            i++;
        }
        homeFolderType.setIndividualsArray(individualsArray);
        
        if (this.state != null)
            homeFolderType.setState(fr.cg95.cvq.xml.common.ActorStateType.Enum.forString(this.state.toString()));
        if (this.familyQuotient != null)
            homeFolderType.setFamilyQuotient(this.familyQuotient);
        
        return homeFolderType;
    }

    public static HomeFolder xmlToModel(fr.cg95.cvq.xml.common.HomeFolderType homeFolderType) {

        HomeFolder homeFolder = new HomeFolder();
        homeFolder.setId(new Long(homeFolderType.getId()));
        homeFolder.setAdress(Address.xmlToModel(homeFolderType.getAddress()));

        IndividualType[] individualsArray = homeFolderType.getIndividualsArray();
        Set individualsSet = new HashSet();
        for (int i=0; i < individualsArray.length; i++) {
            individualsSet.add(Individual.xmlToModel(individualsArray[i]));
        }
        homeFolder.setIndividuals(individualsSet);
        if (homeFolderType.getState() != null)
            homeFolder.setState(ActorState.forString(homeFolderType.getState().toString()));
        if (homeFolderType.getFamilyQuotient() != null)
            homeFolder.setFamilyQuotient(homeFolderType.getFamilyQuotient());
        
        return homeFolder;
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

    public Adult getHomeFolderResponsible() {
        Iterator individualsIt = individuals.iterator();
        while (individualsIt.hasNext()) {
            Object obj = individualsIt.next();
            if (obj instanceof Adult) {
                Adult tempAdult = (Adult) obj;
                if (tempAdult.isHomeFolderResponsible())
                    return tempAdult;
            }
        }

        return null;
    }

    /**
     * @hibernate.property
     *  column="state"
     *  length="16"
     *  not-null="true"
     */
    public ActorState getState() {
        return this.state;
    }

    public void setState(ActorState state) {
        this.state = state;
    }

    public void setState(String state) {
    	this.state = ActorState.forString(state);
    }

    /**
     * @hibernate.many-to-one
     *  class="fr.cg95.cvq.business.users.Address"
     *  column="adress_id"
     */
    public Address getAdress() {
        return this.adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="all-delete-orphan"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.document.Document"
     */
    public Set getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set documents) {
        this.documents = documents;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="delete"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.payment.Payment"
     */
    public Set getPayments() {
        return this.payments;
    }

    public void setPayments(Set payments) {
        this.payments = payments;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     *  cascade="delete"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.Individual"
     */
    public Set getIndividuals() {
        return this.individuals;
    }

    public void setIndividuals(Set individuals) {
        this.individuals = individuals;
    }

    /**
     * @hibernate.set
     *  inverse="true"
     *  lazy="true"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.request.Request"
     */
    public Set getRequests() {
        return this.requests;
    }

    public void setRequests(Set requests) {
        this.requests = requests;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    /**
     * @hibernate.property
     *  column="bound_to_request"
     */
	public Boolean getBoundToRequest() {
		return boundToRequest;
	}

	public void setBoundToRequest(Boolean boundToRequest) {
		this.boundToRequest = boundToRequest;
	}

    /**
     * @hibernate.property
     *  column="origin_request_id"
     */
	public Long getOriginRequestId() {
		return originRequestId;
	}

	public void setOriginRequestId(Long originRequestId) {
		this.originRequestId = originRequestId;
	}

    /**
     * @hibernate.property
     *  column="enabled"
     */
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @hibernate.property
     *  column="family_quotient"
     */
    public final String getFamilyQuotient() {
        return familyQuotient;
    }

    public final void setFamilyQuotient(String familyQuotient) {
        this.familyQuotient = familyQuotient;
    }
}
