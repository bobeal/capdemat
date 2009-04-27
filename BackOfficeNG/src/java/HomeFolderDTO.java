import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import java.util.List;

/*
 * Home Folder DTO usefull to ease data binding 
 * in VO Card Request and HomeFolder Modification Request 
 */
public class HomeFolderDTO {

    private List<Adult> adults;
    private List<Child> children;

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
