
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="dhr_real_asset"
 *  lazy="false"
 */
public class DhrRealAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    public DhrRealAsset() {
        super();
      
    }

    public final String modelToXmlString() {
        DhrRealAssetType object = (DhrRealAssetType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final DhrRealAssetType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DhrRealAssetType dhrRealAsset = DhrRealAssetType.Factory.newInstance();
        int i = 0;
    
        if (this.realAssetNetFloorArea != null)
            dhrRealAsset.setRealAssetNetFloorArea(new BigInteger(this.realAssetNetFloorArea.toString()));
      
        if (this.dhrRealAssetAddress != null)
            dhrRealAsset.setDhrRealAssetAddress(Address.modelToXml(this.dhrRealAssetAddress));
      
        if (this.dhrRealAssetValue != null)
            dhrRealAsset.setDhrRealAssetValue(new BigInteger(this.dhrRealAssetValue.toString()));
      
        return dhrRealAsset;
    }

    public static DhrRealAsset xmlToModel(DhrRealAssetType dhrRealAssetDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrRealAsset dhrRealAsset = new DhrRealAsset();
    
        dhrRealAsset.setRealAssetNetFloorArea(dhrRealAssetDoc.getRealAssetNetFloorArea());
      
        if (dhrRealAssetDoc.getDhrRealAssetAddress() != null)
            dhrRealAsset.setDhrRealAssetAddress(Address.xmlToModel(dhrRealAssetDoc.getDhrRealAssetAddress()));
      
        dhrRealAsset.setDhrRealAssetValue(dhrRealAssetDoc.getDhrRealAssetValue());
      
        return dhrRealAsset;
    }

    private Long id;

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

  
    private java.math.BigInteger realAssetNetFloorArea;

    public final void setRealAssetNetFloorArea(final java.math.BigInteger realAssetNetFloorArea) {
        this.realAssetNetFloorArea = realAssetNetFloorArea;
    }

    /**
  
        * @hibernate.property
        *  column="real_asset_net_floor_area"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getRealAssetNetFloorArea() {
        return this.realAssetNetFloorArea;
    }
  
    private fr.cg95.cvq.business.users.Address dhrRealAssetAddress;

    public final void setDhrRealAssetAddress(final fr.cg95.cvq.business.users.Address dhrRealAssetAddress) {
        this.dhrRealAssetAddress = dhrRealAssetAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_real_asset_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrRealAssetAddress() {
        return this.dhrRealAssetAddress;
    }
  
    private java.math.BigInteger dhrRealAssetValue;

    public final void setDhrRealAssetValue(final java.math.BigInteger dhrRealAssetValue) {
        this.dhrRealAssetValue = dhrRealAssetValue;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_real_asset_value"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrRealAssetValue() {
        return this.dhrRealAssetValue;
    }
  
}
