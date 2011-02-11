package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MinSize;
import net.sf.oval.constraint.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.ChildType;
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
    
    /**
     * the external identifier that is dynamically set for external services
     * that provide us this information.
     */
    private String externalId;
    
    /**
     * the external CapDemat identifier that is dynamically set before
     * talking to an external service.
     */
    private String externalCapDematId;
    
    private ActorState state;

    @NotNull(message = "address")
    @AssertValid(message = "address")
    private Address address;

    private Boolean enabled;
    /** home folders created along a request are considered to be temporary */
    private boolean temporary = false;
    private String familyQuotient;

    @AssertValid(message = "individuals")
    @MinSize(value = 1, message = "individuals")
    private List<Individual> individuals;

    private List<UserAction> actions;

    /** default constructor */
    public HomeFolder() {
        individuals = new ArrayList<Individual>();
        actions = new ArrayList<UserAction>();
    }

    public HomeFolderType modelToXml() {

        HomeFolderType homeFolderType = HomeFolderType.Factory.newInstance();
        if (this.id != null)
            homeFolderType.setId(this.id.longValue());
        if (this.address != null)
            homeFolderType.setAddress(Address.modelToXml(this.address));

        IndividualType[] individualsArray = new IndividualType[individuals.size()];
        int i = 0;
        for (Individual individual : individuals) {
            if (individual instanceof Adult) {
                individualsArray[i] = ((Adult)individual).modelToXml();
            } else if (individual instanceof Child) {
                individualsArray[i] = ((Child)individual).modelToXml();
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
        homeFolder.setAddress(Address.xmlToModel(homeFolderType.getAddress()));

        List<Individual> individuals = new ArrayList<Individual>();
        for (IndividualType individual : homeFolderType.getIndividualsArray()) {
            if (individual instanceof AdultType) {
                individuals.add(Adult.xmlToModel((AdultType)individual));
            } else {
                individuals.add(Child.xmlToModel((ChildType)individual));
            }
        }
        homeFolder.setIndividuals(individuals);

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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalCapDematId() {
        return externalCapDematId;
    }

    public void setExternalCapDematId(String externalCapDematId) {
        this.externalCapDematId = externalCapDematId;
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
     *  column="address_id"
     */
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="individual"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.list-index
     *  column="home_folder_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.Individual"
     */
    public List<Individual> getIndividuals() {
        return this.individuals;
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
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
     *  column="is_temporary"
     */
    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="user_action"
     * @hibernate.key
     *  column="home_folder_id"
     * @hibernate.list-index
     *  column="home_folder_index"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.UserAction"
     */
    public List<UserAction> getActions() {
        return actions;
    }

    public void setActions(List<UserAction> actions) {
        this.actions = actions;
    }
}
