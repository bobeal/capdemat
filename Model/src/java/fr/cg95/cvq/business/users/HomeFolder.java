package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.oval.constraint.AssertValid;
import net.sf.oval.constraint.MinSize;
import net.sf.oval.constraint.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.HomeFolderType;
import fr.cg95.cvq.xml.common.IndividualType;

/**
 * @author bor@zenexity.fr
 */
@Entity
@Table(name="home_folder")
public class HomeFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    /**
     * the external identifier that is dynamically set for external services
     * that provide us this information.
     */
    @Transient
    private String externalId;
    
    /**
     * the external CapDemat identifier that is dynamically set before
     * talking to an external service.
     */
    @Transient
    private String externalCapDematId;
    
    @Enumerated(EnumType.STRING)
    @Column(length=16,nullable=false)
    private UserState state;

    @NotNull(message = "address")
    @AssertValid(message = "address")
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    private Boolean enabled;

    /** home folders created along a request are considered to be temporary */
    @Column(name="is_temporary")
    private boolean temporary = false;

    @Column(name="family_quotient")
    private String familyQuotient;

    @AssertValid(message = "individuals")
    @MinSize(value = 1, message = "individuals")
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="home_folder_id")
    @OrderColumn(name="home_folder_index")
    private List<Individual> individuals;

    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="home_folder_id")
    @OrderColumn(name="home_folder_index")
    private List<UserAction> actions;

    @OneToMany(mappedBy="linkedHomeFolder")
    private List<Document> documents;

    /** default constructor */
    public HomeFolder() {
        individuals = new ArrayList<Individual>();
        actions = new ArrayList<UserAction>();
        documents = new ArrayList<Document>();
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
            homeFolderType.setState(fr.cg95.cvq.xml.common.UserStateType.Enum.forString(this.state.toString()));
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
            homeFolder.setState(UserState.forString(homeFolderType.getState().toString()));
        if (homeFolderType.getFamilyQuotient() != null)
            homeFolder.setFamilyQuotient(homeFolderType.getFamilyQuotient());
        
        return homeFolder;
    }

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

    public UserState getState() {
        return this.state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = UserState.forString(state);
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Individual> getIndividuals() {
        return this.individuals;
    }

    public void setIndividuals(List<Individual> individuals) {
        this.individuals = individuals;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

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

    public List<UserAction> getActions() {
        return actions;
    }

    public void setActions(List<UserAction> actions) {
        this.actions = actions;
    }

    public List<Document> getDocuments() {
        return documents;
    }
}
