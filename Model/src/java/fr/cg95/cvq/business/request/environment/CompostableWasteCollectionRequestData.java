
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

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="compostable_waste_collection_request"
 *  lazy="false"
 */
public class CompostableWasteCollectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public CompostableWasteCollectionRequestData() {
      
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @LocalReferential(
        
        
        profiles = {"waste"},
        message = "compostableWasteType"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> compostableWasteType;

    public final void setCompostableWasteType(final List<fr.cg95.cvq.business.request.LocalReferentialData> compostableWasteType) {
        this.compostableWasteType = compostableWasteType;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="compostable_waste_collection_request_compostable_waste_type"
        * @hibernate.key
        *  column="compostable_waste_collection_request_id"
        * @hibernate.list-index
        *  column="compostable_waste_type_index"
        * @hibernate.many-to-many
        *  column="compostable_waste_type_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getCompostableWasteType() {
        return this.compostableWasteType;
    }
  
    
      @AssertValid(
        
        
        profiles = {"waste"},
        message = "collectionAddress"
      )
    
    private fr.cg95.cvq.business.users.Address collectionAddress;

    public final void setCollectionAddress(final fr.cg95.cvq.business.users.Address collectionAddress) {
        this.collectionAddress = collectionAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="collection_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getCollectionAddress() {
        return this.collectionAddress;
    }
  
    
    private String otherWaste;

    public final void setOtherWaste(final String otherWaste) {
        this.otherWaste = otherWaste;
    }

    /**
 
        * @hibernate.property
        *  column="other_waste"
        
      
    */
    public final String getOtherWaste() {
        return this.otherWaste;
    }
  
}
