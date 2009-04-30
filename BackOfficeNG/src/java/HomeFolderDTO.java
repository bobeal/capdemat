import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;
import java.util.List;
import java.util.ArrayList;

/*
 * Home Folder DTO usefull to ease data binding 
 * in VO Card Request and HomeFolder Modification Request
 *
 * FIXME - move business code in buisiness layer !
 */
public class HomeFolderDTO {

    private List<Adult> adults;
    private List<Child> children;
    
    public List<IndividualRole> getRolesOnIndividual (String fullName) {
        List<IndividualRole> roles = new ArrayList<IndividualRole>();
        for (Individual individual : adults) {
            for (IndividualRole role : individual.getIndividualRoles()) {
                if (role.getIndividualName().equals(fullName))
                    roles.add(role);
            }
        }
        return roles;
    }

    public List<IndividualRole> getRolesOnHomeFolder () {
        List<IndividualRole> roles = new ArrayList<IndividualRole>();
        for (Individual individual : adults) {
            for (IndividualRole role : individual.getIndividualRoles()) {
                if (role.getRole().equals(RoleType.TUTOR)
                        && role.getHomeFolderId() == 0
                        && role.getIndividualId() == 0
                        && role.getIndividualName() == null)
                    roles.add(role);
            }
        }
        return roles;
    }

    public boolean isLegalsResponsible (Individual individual) {
        for (IndividualRole role : individual.getIndividualRoles()) {
            if (role.getRole().equals(RoleType.HOME_FOLDER_RESPONSIBLE))
                return true;
        }
        return false;
    }
    
    
    public RoleType[] getAllRoleTypes () {
        return RoleType.allRoleTypes;
    }
    
    public List<Adult> getAdults() {
        return adults;
    }

    public void setAdults(List<Adult> adults) {
        this.adults = adults;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
