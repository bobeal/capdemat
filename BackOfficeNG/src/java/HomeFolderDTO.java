import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/*
 * Home Folder DTO usefull to ease data binding 
 * in VO Card Request and HomeFolder Modification Request
 *
 * FIXME - move business code in buisiness layer !
 */
public class HomeFolderDTO {

    private List<Adult> adults;
    private List<Child> children;
    
    public Map<Integer, Map<String, Object>> getRoleOwnersOnIndividual (String fullName) {
        Map<Integer, Map<String, Object>> individuals = new HashMap<Integer, Map<String, Object>>();
        if (adults == null)
            return individuals;
        
        for (Individual individual : adults) {
            Set<IndividualRole> individualRoles = individual.getIndividualRoles()!= null ?
                    individual.getIndividualRoles() : new HashSet<IndividualRole>();
            for (IndividualRole role : individualRoles) {
                if (role.getIndividualName() != null && role.getIndividualName().equals(fullName)) {
                    Map<String, Object> roles = new HashMap<String, Object>();
                    roles.put("role", role.getRole());
                    roles.put("owner", individual);
                    individuals.put(adults.indexOf(individual), roles);
                }
            }
        }
        return individuals;
    }

    public Map<Integer, Map<String, Object>> getRoleOwnersOnHomeFolder() {
        Map<Integer, Map<String, Object>> individuals = new HashMap<Integer, Map<String, Object>>();
        if (adults == null)
            return individuals;
              
        for (Individual individual : adults) {
            Set<IndividualRole> individualRoles = individual.getIndividualRoles()!= null ?
                    individual.getIndividualRoles() : new HashSet<IndividualRole>();
            for (IndividualRole role : individualRoles) {
                if (role.getRole().equals(RoleType.TUTOR)
                        && role.getHomeFolderId() == null
                        && role.getIndividualId() == null
                        && role.getIndividualName() == null) {
                    Map<String, Object> roles = new HashMap<String, Object>();
                    roles.put("role", role.getRole());
                    roles.put("owner", individual);
                    individuals.put(adults.indexOf(individual), roles);
                }
            }
        }
        return individuals;
    }

    public boolean isLegalsResponsible (Individual individual) {
        if (individual.getIndividualRoles() != null)
            for (IndividualRole role : individual.getIndividualRoles())
                if (role.getRole().equals(RoleType.HOME_FOLDER_RESPONSIBLE))
                    return true;

        return false;
    }
    
    
    public RoleType[] getAllRoleTypes () {
        return RoleType.allRoleTypes;
    }
    
    public RoleType[] getChildRoleTypes () {
        return RoleType.childRoleTypes;
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
