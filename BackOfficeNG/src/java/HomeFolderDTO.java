import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.exception.CvqModelException;

import java.util.Arrays;
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
    private List<Adult> tutors;
    
    private Long homeFolderId;
    
    public HomeFolderDTO () {}
    
    public HomeFolderDTO (HomeFolder homeFolder, Set<Individual> roleOwners) {
        homeFolderId = homeFolder.getId();
        for (Individual individual : homeFolder.getIndividuals()) {
            if (individual instanceof Adult)
                addAdult((Adult)individual);
            else if (individual instanceof Child)
                addChild((Child)individual);
        }
        
        for (Individual owner : roleOwners) {
            if (!homeFolder.getIndividuals().contains(owner))
                addTutor((Adult)owner);
        }
    }
    
    public Map<Integer, Map<String, Object>> getRoleOwnersOnIndividual (Individual individual, List<Adult> owners) {
        Map<Integer, Map<String, Object>> individuals = new HashMap<Integer, Map<String, Object>>();
        if (owners == null)
            return individuals;
        
        for (Individual owner : owners) {
            Set<IndividualRole> individualRoles = owner.getIndividualRoles()!= null ?
                    owner.getIndividualRoles() : new HashSet<IndividualRole>();
            for (IndividualRole role : individualRoles) {
                if ((role.getIndividualName() != null 
                        && role.getIndividualName().equals(individual.getFullName()))
                    || (role.getIndividualId() != null 
                        && role.getIndividualId().equals(individual.getId()))) {
                    Map<String, Object> roles = new HashMap<String, Object>();
                    roles.put("role", role.getRole());
                    roles.put("owner", owner);
                    individuals.put(owners.indexOf(owner), roles);
                }
            }
        }
        return individuals;
    }

    public Map<Integer, Map<String, Object>> getRoleOwnersOnHomeFolder(List<Adult> owners) {
        Map<Integer, Map<String, Object>> individuals = new HashMap<Integer, Map<String, Object>>();
        if (owners == null)
            return individuals;
              
        for (Individual owner : owners) {
            Set<IndividualRole> individualRoles = owner.getIndividualRoles()!= null ?
                    owner.getIndividualRoles() : new HashSet<IndividualRole>();
            for (IndividualRole role : individualRoles) {
                if ((role.getHomeFolderId() != null 
                        && role.getHomeFolderId().equals(homeFolderId)) 
                    || (role.getHomeFolderId() == null
                        && role.getIndividualId() == null
                        && role.getIndividualName() == null)) {
                    Map<String, Object> roles = new HashMap<String, Object>();
                    roles.put("role", role.getRole());
                    roles.put("owner", owner);
                    individuals.put(owners.indexOf(owner), roles);
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
    
    /*
     * - Homefolder must one and  only one homeFolderResponsible
     * - Children must have between one and tree legal responsibles
     */
    public void checkRoles() throws CvqModelException {
        List<RoleType> homeFolderRoleTypes = new ArrayList<RoleType>();
        for (Map<String, Object> rMap : getRoleOwnersOnHomeFolder(adults).values()){
            RoleType rt = (RoleType)rMap.get("role");
            if (rt.equals(RoleType.HOME_FOLDER_RESPONSIBLE))
                homeFolderRoleTypes.add(rt);
        }
        if (homeFolderRoleTypes.size() < 1)
            throw new CvqModelException("homeFolder.error.responsibleIsRequired");
        else if (homeFolderRoleTypes.size() > 1)
            throw new CvqModelException("homeFolder.error.onlyOneResponsibleIsAllowed");
        
        if (children == null)
            return;
        for (Child child : children) {
            List<RoleType> childRoleTypes = new ArrayList<RoleType>();
            for (Map<String, Object> rMap : getRoleOwnersOnIndividual(child, adults).values()){
                RoleType rt = (RoleType)rMap.get("role");
                if (Arrays.asList(RoleType.childRoleTypes).contains(rt))
                    childRoleTypes.add(rt);
            }
            if (childRoleTypes.size() < 1 || childRoleTypes.size() > 3)
                throw new CvqModelException("homeFolder.error.illegalLegalResponsiblesNumber", new String[]{child.getFirstName()});
        }
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
    
    private void addAdult(Adult adult) {
        if (adults == null)
            adults = new ArrayList<Adult>();
        adults.add(adult);
    }
    
    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
    
    private void addChild(Child child) {
        if (children == null)
            children = new ArrayList<Child>();
        children.add(child);
    }
    
    public List<Adult> getTutors() {
        return tutors;
    }

    public void setTutors(List<Adult> tutors) {
        this.tutors = tutors;
    }
    
    private void addTutor(Adult tutor) {
        if (tutors == null)
            tutors = new ArrayList<Adult>();
        tutors.add(tutor);
    }
    
}
