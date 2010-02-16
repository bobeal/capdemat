
package fr.cg95.cvq.business.request.environment;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="bulky_waste_collection_request"
 *  lazy="false"
 */
public class BulkyWasteCollectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public BulkyWasteCollectionRequestData() {
      
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
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> bulkyWasteType;

    public final void setBulkyWasteType(final List<fr.cg95.cvq.business.request.LocalReferentialData> bulkyWasteType) {
        this.bulkyWasteType = bulkyWasteType;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="bulky_waste_collection_request_bulky_waste_type"
        * @hibernate.key
        *  column="bulky_waste_collection_request_id"
        * @hibernate.list-index
        *  column="bulky_waste_type_index"
        * @hibernate.many-to-many
        *  column="bulky_waste_type_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getBulkyWasteType() {
        return this.bulkyWasteType;
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
