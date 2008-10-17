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
 *  table="dhr_not_real_asset"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class DhrNotRealAsset implements Serializable {

    private static final long serialVersionUID = 1L;



    public DhrNotRealAsset() {
        super();
    }


    public final String modelToXmlString() {

        DhrNotRealAssetType object = (DhrNotRealAssetType) this.modelToXml();
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
        DhrNotRealAssetType dhrNotRealAsset = DhrNotRealAssetType.Factory.newInstance();
        if (this.assetValue != null)
            dhrNotRealAsset.setAssetValue(new BigInteger(this.assetValue.toString()));
        dhrNotRealAsset.setAssetBeneficiaryFirstName(this.assetBeneficiaryFirstName);
        if (this.assetNotaryAddress != null)
            dhrNotRealAsset.setAssetNotaryAddress(Address.modelToXml(this.assetNotaryAddress));
        dhrNotRealAsset.setAssetNotaryName(this.assetNotaryName);
        if (this.assetBeneficiaryAddress != null)
            dhrNotRealAsset.setAssetBeneficiaryAddress(Address.modelToXml(this.assetBeneficiaryAddress));
        if (this.assetAddress != null)
            dhrNotRealAsset.setAssetAddress(Address.modelToXml(this.assetAddress));
        if (this.assetType != null)
            dhrNotRealAsset.setAssetType(fr.cg95.cvq.xml.social.DhrAssetTypeType.Enum.forString(this.assetType.toString()));
        date = this.assetDate;
        if (date != null) {
            calendar.setTime(date);
            dhrNotRealAsset.setAssetDate(calendar);
        }
        dhrNotRealAsset.setAssetBeneficiaryName(this.assetBeneficiaryName);
        if (this.assetKind != null)
            dhrNotRealAsset.setAssetKind(fr.cg95.cvq.xml.social.DhrAssetKindType.Enum.forString(this.assetKind.toString()));
        return dhrNotRealAsset;
    }

    public static DhrNotRealAsset xmlToModel(DhrNotRealAssetType dhrNotRealAssetDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrNotRealAsset dhrNotRealAsset = new DhrNotRealAsset();
        dhrNotRealAsset.setAssetValue(dhrNotRealAssetDoc.getAssetValue());
        dhrNotRealAsset.setAssetBeneficiaryFirstName(dhrNotRealAssetDoc.getAssetBeneficiaryFirstName());
        if (dhrNotRealAssetDoc.getAssetNotaryAddress() != null)
            dhrNotRealAsset.setAssetNotaryAddress(Address.xmlToModel(dhrNotRealAssetDoc.getAssetNotaryAddress()));
        dhrNotRealAsset.setAssetNotaryName(dhrNotRealAssetDoc.getAssetNotaryName());
        if (dhrNotRealAssetDoc.getAssetBeneficiaryAddress() != null)
            dhrNotRealAsset.setAssetBeneficiaryAddress(Address.xmlToModel(dhrNotRealAssetDoc.getAssetBeneficiaryAddress()));
        if (dhrNotRealAssetDoc.getAssetAddress() != null)
            dhrNotRealAsset.setAssetAddress(Address.xmlToModel(dhrNotRealAssetDoc.getAssetAddress()));
        if (dhrNotRealAssetDoc.getAssetType() != null)
            dhrNotRealAsset.setAssetType(fr.cg95.cvq.business.social.DhrAssetTypeType.forString(dhrNotRealAssetDoc.getAssetType().toString()));
        else
            dhrNotRealAsset.setAssetType(fr.cg95.cvq.business.social.DhrAssetTypeType.getDefaultDhrAssetTypeType());
        calendar = dhrNotRealAssetDoc.getAssetDate();
        if (calendar != null) {
            dhrNotRealAsset.setAssetDate(calendar.getTime());
        }
        dhrNotRealAsset.setAssetBeneficiaryName(dhrNotRealAssetDoc.getAssetBeneficiaryName());
        if (dhrNotRealAssetDoc.getAssetKind() != null)
            dhrNotRealAsset.setAssetKind(fr.cg95.cvq.business.social.DhrAssetKindType.forString(dhrNotRealAssetDoc.getAssetKind().toString()));
        else
            dhrNotRealAsset.setAssetKind(fr.cg95.cvq.business.social.DhrAssetKindType.getDefaultDhrAssetKindType());
        return dhrNotRealAsset;
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

    private java.math.BigInteger assetValue;

    public final void setAssetValue(final java.math.BigInteger assetValue) {
        this.assetValue = assetValue;
    }


    /**
     * @hibernate.property
     *  column="asset_value"
     *  type="serializable"
     */
    public final java.math.BigInteger getAssetValue() {
        return this.assetValue;
    }

    private String assetBeneficiaryFirstName;

    public final void setAssetBeneficiaryFirstName(final String assetBeneficiaryFirstName) {
        this.assetBeneficiaryFirstName = assetBeneficiaryFirstName;
    }


    /**
     * @hibernate.property
     *  column="asset_beneficiary_first_name"
     *  length="38"
     */
    public final String getAssetBeneficiaryFirstName() {
        return this.assetBeneficiaryFirstName;
    }

    private fr.cg95.cvq.business.users.Address assetNotaryAddress;

    public final void setAssetNotaryAddress(final fr.cg95.cvq.business.users.Address assetNotaryAddress) {
        this.assetNotaryAddress = assetNotaryAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="asset_notary_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAssetNotaryAddress() {
        return this.assetNotaryAddress;
    }

    private String assetNotaryName;

    public final void setAssetNotaryName(final String assetNotaryName) {
        this.assetNotaryName = assetNotaryName;
    }


    /**
     * @hibernate.property
     *  column="asset_notary_name"
     *  length="38"
     */
    public final String getAssetNotaryName() {
        return this.assetNotaryName;
    }

    private fr.cg95.cvq.business.users.Address assetBeneficiaryAddress;

    public final void setAssetBeneficiaryAddress(final fr.cg95.cvq.business.users.Address assetBeneficiaryAddress) {
        this.assetBeneficiaryAddress = assetBeneficiaryAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="asset_beneficiary_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAssetBeneficiaryAddress() {
        return this.assetBeneficiaryAddress;
    }

    private fr.cg95.cvq.business.users.Address assetAddress;

    public final void setAssetAddress(final fr.cg95.cvq.business.users.Address assetAddress) {
        this.assetAddress = assetAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="asset_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getAssetAddress() {
        return this.assetAddress;
    }

    private fr.cg95.cvq.business.social.DhrAssetTypeType assetType;

    public final void setAssetType(final fr.cg95.cvq.business.social.DhrAssetTypeType assetType) {
        this.assetType = assetType;
    }


    /**
     * @hibernate.property
     *  column="asset_type"
     */
    public final fr.cg95.cvq.business.social.DhrAssetTypeType getAssetType() {
        return this.assetType;
    }

    private java.util.Date assetDate;

    public final void setAssetDate(final java.util.Date assetDate) {
        this.assetDate = assetDate;
    }


    /**
     * @hibernate.property
     *  column="asset_date"
     */
    public final java.util.Date getAssetDate() {
        return this.assetDate;
    }

    private String assetBeneficiaryName;

    public final void setAssetBeneficiaryName(final String assetBeneficiaryName) {
        this.assetBeneficiaryName = assetBeneficiaryName;
    }


    /**
     * @hibernate.property
     *  column="asset_beneficiary_name"
     *  length="38"
     */
    public final String getAssetBeneficiaryName() {
        return this.assetBeneficiaryName;
    }

    private fr.cg95.cvq.business.social.DhrAssetKindType assetKind;

    public final void setAssetKind(final fr.cg95.cvq.business.social.DhrAssetKindType assetKind) {
        this.assetKind = assetKind;
    }


    /**
     * @hibernate.property
     *  column="asset_kind"
     */
    public final fr.cg95.cvq.business.social.DhrAssetKindType getAssetKind() {
        return this.assetKind;
    }

}
