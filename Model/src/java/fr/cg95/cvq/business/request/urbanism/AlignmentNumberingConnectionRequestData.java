
package fr.cg95.cvq.business.request.urbanism;

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
 *  table="alignment_numbering_connection_request"
 *  lazy="false"
 */
public class AlignmentNumberingConnectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public AlignmentNumberingConnectionRequestData() {
      
        requesterQuality = fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.OWNER;
      
        isAccountAddress = Boolean.valueOf(true);
      
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

  
    private Boolean isNumbering;

    public final void setIsNumbering(final Boolean isNumbering) {
        this.isNumbering = isNumbering;
    }

    /**
 
        * @hibernate.property
        *  column="is_numbering"
        
      
    */
    public final Boolean getIsNumbering() {
        return this.isNumbering;
    }
  
    private fr.cg95.cvq.business.users.Address otherAddress;

    public final void setOtherAddress(final fr.cg95.cvq.business.users.Address otherAddress) {
        this.otherAddress = otherAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="other_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getOtherAddress() {
        return this.otherAddress;
    }
  
    private String ownerFirstNames;

    public final void setOwnerFirstNames(final String ownerFirstNames) {
        this.ownerFirstNames = ownerFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="owner_first_names"
        
      
    */
    public final String getOwnerFirstNames() {
        return this.ownerFirstNames;
    }
  
    private java.math.BigInteger number;

    public final void setNumber(final java.math.BigInteger number) {
        this.number = number;
    }

    /**
 
        * @hibernate.property
        *  column="number"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getNumber() {
        return this.number;
    }
  
    private java.math.BigInteger area;

    public final void setArea(final java.math.BigInteger area) {
        this.area = area;
    }

    /**
 
        * @hibernate.property
        *  column="area"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getArea() {
        return this.area;
    }
  
    private Boolean moreThanTwoYears;

    public final void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        this.moreThanTwoYears = moreThanTwoYears;
    }

    /**
 
        * @hibernate.property
        *  column="more_than_two_years"
        
      
    */
    public final Boolean getMoreThanTwoYears() {
        return this.moreThanTwoYears;
    }
  
    private fr.cg95.cvq.business.users.Address ownerAddress;

    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="owner_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return this.ownerAddress;
    }
  
    private fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality"
        
      
    */
    public final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }
  
    private String section;

    public final void setSection(final String section) {
        this.section = section;
    }

    /**
 
        * @hibernate.property
        *  column="section"
        
      
    */
    public final String getSection() {
        return this.section;
    }
  
    private String transportationRoute;

    public final void setTransportationRoute(final String transportationRoute) {
        this.transportationRoute = transportationRoute;
    }

    /**
 
        * @hibernate.property
        *  column="transportation_route"
        
      
    */
    public final String getTransportationRoute() {
        return this.transportationRoute;
    }
  
    private String locality;

    public final void setLocality(final String locality) {
        this.locality = locality;
    }

    /**
 
        * @hibernate.property
        *  column="locality"
        
      
    */
    public final String getLocality() {
        return this.locality;
    }
  
    private Boolean isConnection;

    public final void setIsConnection(final Boolean isConnection) {
        this.isConnection = isConnection;
    }

    /**
 
        * @hibernate.property
        *  column="is_connection"
        
      
    */
    public final Boolean getIsConnection() {
        return this.isConnection;
    }
  
    private Boolean isAccountAddress;

    public final void setIsAccountAddress(final Boolean isAccountAddress) {
        this.isAccountAddress = isAccountAddress;
    }

    /**
 
        * @hibernate.property
        *  column="is_account_address"
        
      
    */
    public final Boolean getIsAccountAddress() {
        return this.isAccountAddress;
    }
  
    private Boolean isAlignment;

    public final void setIsAlignment(final Boolean isAlignment) {
        this.isAlignment = isAlignment;
    }

    /**
 
        * @hibernate.property
        *  column="is_alignment"
        
      
    */
    public final Boolean getIsAlignment() {
        return this.isAlignment;
    }
  
    private String ownerLastName;

    public final void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    /**
 
        * @hibernate.property
        *  column="owner_last_name"
        *  length="38"
      
    */
    public final String getOwnerLastName() {
        return this.ownerLastName;
    }
  
}
