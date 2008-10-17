package fr.cg95.cvq.business.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="dhr_real_asset"
 *  lazy="false"
 *
 * Generated class file, do not edit!
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

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        DhrRealAssetType dhrRealAsset = DhrRealAssetType.Factory.newInstance();
        if (this.realAssetValue != null)
            dhrRealAsset.setRealAssetValue(new BigInteger(this.realAssetValue.toString()));
        if (this.realAssetNetFloorArea != null)
            dhrRealAsset.setRealAssetNetFloorArea(new BigInteger(this.realAssetNetFloorArea.toString()));
        if (this.realAssetAddress != null)
            dhrRealAsset.setRealAssetAddress(Address.modelToXml(this.realAssetAddress));
        return dhrRealAsset;
    }

    public static DhrRealAsset xmlToModel(DhrRealAssetType dhrRealAssetDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrRealAsset dhrRealAsset = new DhrRealAsset();
        dhrRealAsset.setRealAssetValue(dhrRealAssetDoc.getRealAssetValue());
        dhrRealAsset.setRealAssetNetFloorArea(dhrRealAssetDoc.getRealAssetNetFloorArea());
        if (dhrRealAssetDoc.getRealAssetAddress() != null)
            dhrRealAsset.setRealAssetAddress(Address.xmlToModel(dhrRealAssetDoc.getRealAssetAddress()));
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

    private java.math.BigInteger realAssetValue;

    public final void setRealAssetValue(final java.math.BigInteger realAssetValue) {
        this.realAssetValue = realAssetValue;
    }


    /**
     * @hibernate.property
     *  column="real_asset_value"
     *  type="serializable"
     */
    public final java.math.BigInteger getRealAssetValue() {
        return this.realAssetValue;
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

    private fr.cg95.cvq.business.users.Address realAssetAddress;

    public final void setRealAssetAddress(final fr.cg95.cvq.business.users.Address realAssetAddress) {
        this.realAssetAddress = realAssetAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="real_asset_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getRealAssetAddress() {
        return this.realAssetAddress;
    }

}
