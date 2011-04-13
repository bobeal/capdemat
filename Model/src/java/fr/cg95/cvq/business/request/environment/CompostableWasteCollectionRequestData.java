

package fr.cg95.cvq.business.request.environment;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="compostable_waste_collection_request")
public class CompostableWasteCollectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public CompostableWasteCollectionRequestData() {
      
    }

    @Override
    public CompostableWasteCollectionRequestData clone() {
        CompostableWasteCollectionRequestData result = new CompostableWasteCollectionRequestData();
        
          
            
        if (collectionAddress != null)
            result.setCollectionAddress(collectionAddress.clone());
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> compostableWasteTypeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : compostableWasteType) {
            compostableWasteTypeList.add(object.clone());
        }
        result.setCompostableWasteType(compostableWasteTypeList);
      
          
        
          
            
        result.setOtherWaste(otherWaste);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
      @AssertValid(
        
        
        profiles = {"waste"},
        message = "collectionAddress"
      )
    
    private fr.cg95.cvq.business.users.Address collectionAddress;

    public void setCollectionAddress(final fr.cg95.cvq.business.users.Address collectionAddress) {
        this.collectionAddress = collectionAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="collection_address_id")
      
    public fr.cg95.cvq.business.users.Address getCollectionAddress() {
        return this.collectionAddress;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"waste"},
        message = "compostableWasteType"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"waste"},
        message = "compostableWasteType"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> compostableWasteType;

    public void setCompostableWasteType(final List<fr.cg95.cvq.business.request.LocalReferentialData> compostableWasteType) {
        this.compostableWasteType = compostableWasteType;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="compostable_waste_collection_request_compostable_waste_type",
            joinColumns=
                @JoinColumn(name="compostable_waste_collection_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="compostable_waste_type_id"))
    @OrderColumn(name="compostable_waste_type_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getCompostableWasteType() {
        return this.compostableWasteType;
    }
  
    
    private String otherWaste;

    public void setOtherWaste(final String otherWaste) {
        this.otherWaste = otherWaste;
    }

 
    @Column(name="other_waste"  )
      
    public String getOtherWaste() {
        return this.otherWaste;
    }
  
}
