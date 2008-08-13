package fr.cg95.cvq.business.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.social.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="handicap_allowance_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class HandicapAllowanceRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public HandicapAllowanceRequest() {
        super();
    }


    public final String modelToXmlString() {

        HandicapAllowanceRequestDocument object = (HandicapAllowanceRequestDocument) this.modelToXml();
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
        HandicapAllowanceRequestDocument handicapAllowanceRequestDoc = HandicapAllowanceRequestDocument.Factory.newInstance();
        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequest = handicapAllowanceRequestDoc.addNewHandicapAllowanceRequest();
        super.fillCommonXmlInfo(handicapAllowanceRequest);
        if (this.legalRepresentativeAddress != null)
            handicapAllowanceRequest.setLegalRepresentativeAddress(Address.modelToXml(this.legalRepresentativeAddress));
        if (this.legalRepresentative != null)
            handicapAllowanceRequest.setLegalRepresentative(this.legalRepresentative.booleanValue());
        if (this.hopesAndNeeds != null)
            handicapAllowanceRequest.setHopesAndNeeds(this.hopesAndNeeds.booleanValue());
        if (this.writingHelp != null)
            handicapAllowanceRequest.setWritingHelp(this.writingHelp.booleanValue());
        handicapAllowanceRequest.setNeeds(this.needs);
        handicapAllowanceRequest.setHelperResponsability(this.helperResponsability);
        handicapAllowanceRequest.setLegalRepresentativePhone(this.legalRepresentativePhone);
        handicapAllowanceRequest.setLegalRepresentativeFamilyRelationship(this.legalRepresentativeFamilyRelationship);
        handicapAllowanceRequest.setHelperName(this.helperName);
        handicapAllowanceRequest.setLegalRepresentativeName(this.legalRepresentativeName);
        handicapAllowanceRequest.setLegalRepresentativeFirstame(this.legalRepresentativeFirstame);
        handicapAllowanceRequest.setComments(this.comments);
        handicapAllowanceRequest.setHopes(this.hopes);
        return handicapAllowanceRequestDoc;
    }

    public static HandicapAllowanceRequest xmlToModel(HandicapAllowanceRequestDocument handicapAllowanceRequestDoc) {

        HandicapAllowanceRequestDocument.HandicapAllowanceRequest handicapAllowanceRequestXml = handicapAllowanceRequestDoc.getHandicapAllowanceRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HandicapAllowanceRequest handicapAllowanceRequest = new HandicapAllowanceRequest();
        handicapAllowanceRequest.fillCommonModelInfo(handicapAllowanceRequest,handicapAllowanceRequestXml);
        if (handicapAllowanceRequestXml.getLegalRepresentativeAddress() != null)
            handicapAllowanceRequest.setLegalRepresentativeAddress(Address.xmlToModel(handicapAllowanceRequestXml.getLegalRepresentativeAddress()));
        handicapAllowanceRequest.setLegalRepresentative(Boolean.valueOf(handicapAllowanceRequestXml.getLegalRepresentative()));
        handicapAllowanceRequest.setHopesAndNeeds(Boolean.valueOf(handicapAllowanceRequestXml.getHopesAndNeeds()));
        handicapAllowanceRequest.setWritingHelp(Boolean.valueOf(handicapAllowanceRequestXml.getWritingHelp()));
        handicapAllowanceRequest.setNeeds(handicapAllowanceRequestXml.getNeeds());
        handicapAllowanceRequest.setHelperResponsability(handicapAllowanceRequestXml.getHelperResponsability());
        handicapAllowanceRequest.setLegalRepresentativePhone(handicapAllowanceRequestXml.getLegalRepresentativePhone());
        handicapAllowanceRequest.setLegalRepresentativeFamilyRelationship(handicapAllowanceRequestXml.getLegalRepresentativeFamilyRelationship());
        handicapAllowanceRequest.setHelperName(handicapAllowanceRequestXml.getHelperName());
        handicapAllowanceRequest.setLegalRepresentativeName(handicapAllowanceRequestXml.getLegalRepresentativeName());
        handicapAllowanceRequest.setLegalRepresentativeFirstame(handicapAllowanceRequestXml.getLegalRepresentativeFirstame());
        handicapAllowanceRequest.setComments(handicapAllowanceRequestXml.getComments());
        handicapAllowanceRequest.setHopes(handicapAllowanceRequestXml.getHopes());
        return handicapAllowanceRequest;
    }

    private fr.cg95.cvq.business.users.Address legalRepresentativeAddress;

    public final void setLegalRepresentativeAddress(final fr.cg95.cvq.business.users.Address legalRepresentativeAddress) {
        this.legalRepresentativeAddress = legalRepresentativeAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="legal_representative_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getLegalRepresentativeAddress() {
        return this.legalRepresentativeAddress;
    }

    private Boolean legalRepresentative;

    public final void setLegalRepresentative(final Boolean legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }


    /**
     * @hibernate.property
     *  column="legal_representative"
     */
    public final Boolean getLegalRepresentative() {
        return this.legalRepresentative;
    }

    private Boolean hopesAndNeeds;

    public final void setHopesAndNeeds(final Boolean hopesAndNeeds) {
        this.hopesAndNeeds = hopesAndNeeds;
    }


    /**
     * @hibernate.property
     *  column="hopes_and_needs"
     */
    public final Boolean getHopesAndNeeds() {
        return this.hopesAndNeeds;
    }

    private Boolean writingHelp;

    public final void setWritingHelp(final Boolean writingHelp) {
        this.writingHelp = writingHelp;
    }


    /**
     * @hibernate.property
     *  column="writing_help"
     */
    public final Boolean getWritingHelp() {
        return this.writingHelp;
    }

    private String needs;

    public final void setNeeds(final String needs) {
        this.needs = needs;
    }


    /**
     * @hibernate.property
     *  column="needs"
     */
    public final String getNeeds() {
        return this.needs;
    }

    private String helperResponsability;

    public final void setHelperResponsability(final String helperResponsability) {
        this.helperResponsability = helperResponsability;
    }


    /**
     * @hibernate.property
     *  column="helper_responsability"
     */
    public final String getHelperResponsability() {
        return this.helperResponsability;
    }

    private String legalRepresentativePhone;

    public final void setLegalRepresentativePhone(final String legalRepresentativePhone) {
        this.legalRepresentativePhone = legalRepresentativePhone;
    }


    /**
     * @hibernate.property
     *  column="legal_representative_phone"
     *  length="10"
     */
    public final String getLegalRepresentativePhone() {
        return this.legalRepresentativePhone;
    }

    private String legalRepresentativeFamilyRelationship;

    public final void setLegalRepresentativeFamilyRelationship(final String legalRepresentativeFamilyRelationship) {
        this.legalRepresentativeFamilyRelationship = legalRepresentativeFamilyRelationship;
    }


    /**
     * @hibernate.property
     *  column="legal_representative_family_relationship"
     */
    public final String getLegalRepresentativeFamilyRelationship() {
        return this.legalRepresentativeFamilyRelationship;
    }

    private String helperName;

    public final void setHelperName(final String helperName) {
        this.helperName = helperName;
    }


    /**
     * @hibernate.property
     *  column="helper_name"
     *  length="38"
     */
    public final String getHelperName() {
        return this.helperName;
    }

    private String legalRepresentativeName;

    public final void setLegalRepresentativeName(final String legalRepresentativeName) {
        this.legalRepresentativeName = legalRepresentativeName;
    }


    /**
     * @hibernate.property
     *  column="legal_representative_name"
     *  length="38"
     */
    public final String getLegalRepresentativeName() {
        return this.legalRepresentativeName;
    }

    private String legalRepresentativeFirstame;

    public final void setLegalRepresentativeFirstame(final String legalRepresentativeFirstame) {
        this.legalRepresentativeFirstame = legalRepresentativeFirstame;
    }


    /**
     * @hibernate.property
     *  column="legal_representative_firstame"
     *  length="38"
     */
    public final String getLegalRepresentativeFirstame() {
        return this.legalRepresentativeFirstame;
    }

    private String comments;

    public final void setComments(final String comments) {
        this.comments = comments;
    }


    /**
     * @hibernate.property
     *  column="comments"
     */
    public final String getComments() {
        return this.comments;
    }

    private String hopes;

    public final void setHopes(final String hopes) {
        this.hopes = hopes;
    }


    /**
     * @hibernate.property
     *  column="hopes"
     */
    public final String getHopes() {
        return this.hopes;
    }

}
