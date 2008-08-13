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
 *  table="dhr_donation"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class DhrDonation implements Serializable {

    private static final long serialVersionUID = 1L;



    public DhrDonation() {
        super();
    }


    public final String modelToXmlString() {

        DhrDonationType object = (DhrDonationType) this.modelToXml();
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
        DhrDonationType dhrDonation = DhrDonationType.Factory.newInstance();
        date = this.donationDate;
        if (date != null) {
            calendar.setTime(date);
            dhrDonation.setDonationDate(calendar);
        }
        dhrDonation.setDonationNotaryFirstName(this.donationNotaryFirstName);
        dhrDonation.setDonationBeneficiaryName(this.donationBeneficiaryName);
        dhrDonation.setDonationBeneficiaryFirstName(this.donationBeneficiaryFirstName);
        if (this.donationValue != null)
            dhrDonation.setDonationValue(new BigInteger(this.donationValue.toString()));
        dhrDonation.setDonationNotaryName(this.donationNotaryName);
        if (this.donationNotaryAddress != null)
            dhrDonation.setDonationNotaryAddress(Address.modelToXml(this.donationNotaryAddress));
        dhrDonation.setDonationAssetPlace(this.donationAssetPlace);
        if (this.donationAsset != null)
            dhrDonation.setDonationAsset(fr.cg95.cvq.xml.social.DhrDonationAssetType.Enum.forString(this.donationAsset.toString()));
        return dhrDonation;
    }

    public static DhrDonation xmlToModel(DhrDonationType dhrDonationDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrDonation dhrDonation = new DhrDonation();
        calendar = dhrDonationDoc.getDonationDate();
        if (calendar != null) {
            dhrDonation.setDonationDate(calendar.getTime());
        }
        dhrDonation.setDonationNotaryFirstName(dhrDonationDoc.getDonationNotaryFirstName());
        dhrDonation.setDonationBeneficiaryName(dhrDonationDoc.getDonationBeneficiaryName());
        dhrDonation.setDonationBeneficiaryFirstName(dhrDonationDoc.getDonationBeneficiaryFirstName());
        dhrDonation.setDonationValue(dhrDonationDoc.getDonationValue());
        dhrDonation.setDonationNotaryName(dhrDonationDoc.getDonationNotaryName());
        if (dhrDonationDoc.getDonationNotaryAddress() != null)
            dhrDonation.setDonationNotaryAddress(Address.xmlToModel(dhrDonationDoc.getDonationNotaryAddress()));
        dhrDonation.setDonationAssetPlace(dhrDonationDoc.getDonationAssetPlace());
        if (dhrDonationDoc.getDonationAsset() != null)
            dhrDonation.setDonationAsset(fr.cg95.cvq.business.social.DhrDonationAssetType.forString(dhrDonationDoc.getDonationAsset().toString()));
        else
            dhrDonation.setDonationAsset(fr.cg95.cvq.business.social.DhrDonationAssetType.getDefaultDhrDonationAssetType());
        return dhrDonation;
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

    private java.util.Date donationDate;

    public final void setDonationDate(final java.util.Date donationDate) {
        this.donationDate = donationDate;
    }


    /**
     * @hibernate.property
     *  column="donation_date"
     */
    public final java.util.Date getDonationDate() {
        return this.donationDate;
    }

    private String donationNotaryFirstName;

    public final void setDonationNotaryFirstName(final String donationNotaryFirstName) {
        this.donationNotaryFirstName = donationNotaryFirstName;
    }


    /**
     * @hibernate.property
     *  column="donation_notary_first_name"
     *  length="38"
     */
    public final String getDonationNotaryFirstName() {
        return this.donationNotaryFirstName;
    }

    private String donationBeneficiaryName;

    public final void setDonationBeneficiaryName(final String donationBeneficiaryName) {
        this.donationBeneficiaryName = donationBeneficiaryName;
    }


    /**
     * @hibernate.property
     *  column="donation_beneficiary_name"
     *  length="38"
     */
    public final String getDonationBeneficiaryName() {
        return this.donationBeneficiaryName;
    }

    private String donationBeneficiaryFirstName;

    public final void setDonationBeneficiaryFirstName(final String donationBeneficiaryFirstName) {
        this.donationBeneficiaryFirstName = donationBeneficiaryFirstName;
    }


    /**
     * @hibernate.property
     *  column="donation_beneficiary_first_name"
     *  length="38"
     */
    public final String getDonationBeneficiaryFirstName() {
        return this.donationBeneficiaryFirstName;
    }

    private java.math.BigInteger donationValue;

    public final void setDonationValue(final java.math.BigInteger donationValue) {
        this.donationValue = donationValue;
    }


    /**
     * @hibernate.property
     *  column="donation_value"
     *  type="serializable"
     */
    public final java.math.BigInteger getDonationValue() {
        return this.donationValue;
    }

    private String donationNotaryName;

    public final void setDonationNotaryName(final String donationNotaryName) {
        this.donationNotaryName = donationNotaryName;
    }


    /**
     * @hibernate.property
     *  column="donation_notary_name"
     *  length="38"
     */
    public final String getDonationNotaryName() {
        return this.donationNotaryName;
    }

    private fr.cg95.cvq.business.users.Address donationNotaryAddress;

    public final void setDonationNotaryAddress(final fr.cg95.cvq.business.users.Address donationNotaryAddress) {
        this.donationNotaryAddress = donationNotaryAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="donation_notary_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getDonationNotaryAddress() {
        return this.donationNotaryAddress;
    }

    private String donationAssetPlace;

    public final void setDonationAssetPlace(final String donationAssetPlace) {
        this.donationAssetPlace = donationAssetPlace;
    }


    /**
     * @hibernate.property
     *  column="donation_asset_place"
     *  length="200"
     */
    public final String getDonationAssetPlace() {
        return this.donationAssetPlace;
    }

    private fr.cg95.cvq.business.social.DhrDonationAssetType donationAsset;

    public final void setDonationAsset(final fr.cg95.cvq.business.social.DhrDonationAssetType donationAsset) {
        this.donationAsset = donationAsset;
    }


    /**
     * @hibernate.property
     *  column="donation_asset"
     */
    public final fr.cg95.cvq.business.social.DhrDonationAssetType getDonationAsset() {
        return this.donationAsset;
    }

}
