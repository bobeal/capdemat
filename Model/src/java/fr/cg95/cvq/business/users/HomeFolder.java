package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MinSize;
import net.sf.oval.constraint.NotNull;

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

    @NotNull(message = "adress")
    @AssertValid(message = "adress")
    private Address adress;

    private Boolean enabled;
    /** home folders created along a request are considered to be temporary */
    private boolean temporary = false;
    private String familyQuotient;

    @AssertValid(message = "individuals")
    @MinSize(value = 1, message = "individuals")
    private List<Individual> individuals;

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
        int i = 0;
        for (Individual individual : individuals) {
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
        Arrays.asList(individualsArray);
        List<Individual> individualsSet = new ArrayList<Individual>();
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
     *  column="adress_id"
     */
    public Address getAdress() {
        return this.adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
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
}
