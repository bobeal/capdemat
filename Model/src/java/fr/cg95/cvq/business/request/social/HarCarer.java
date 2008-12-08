package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="har_carer"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarCarer implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarCarer() {
        super();
    }


    public final String modelToXmlString() {

        HarCarerType object = (HarCarerType) this.modelToXml();
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
        HarCarerType harCarer = HarCarerType.Factory.newInstance();
        harCarer.setHarOtherCarerDetails(this.harOtherCarerDetails);
        if (this.harCarerKind != null)
            harCarer.setHarCarerKind(fr.cg95.cvq.xml.request.social.HarCarerKindType.Enum.forString(this.harCarerKind.toString()));
        return harCarer;
    }

    public static HarCarer xmlToModel(HarCarerType harCarerDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarCarer harCarer = new HarCarer();
        harCarer.setHarOtherCarerDetails(harCarerDoc.getHarOtherCarerDetails());
        if (harCarerDoc.getHarCarerKind() != null)
            harCarer.setHarCarerKind(fr.cg95.cvq.business.request.social.HarCarerKindType.forString(harCarerDoc.getHarCarerKind().toString()));
        else
            harCarer.setHarCarerKind(fr.cg95.cvq.business.request.social.HarCarerKindType.getDefaultHarCarerKindType());
        return harCarer;
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

    private String harOtherCarerDetails;

    public final void setHarOtherCarerDetails(final String harOtherCarerDetails) {
        this.harOtherCarerDetails = harOtherCarerDetails;
    }


    /**
     * @hibernate.property
     *  column="har_other_carer_details"
     *  length="38"
     */
    public final String getHarOtherCarerDetails() {
        return this.harOtherCarerDetails;
    }

    private fr.cg95.cvq.business.request.social.HarCarerKindType harCarerKind;

    public final void setHarCarerKind(final fr.cg95.cvq.business.request.social.HarCarerKindType harCarerKind) {
        this.harCarerKind = harCarerKind;
    }


    /**
     * @hibernate.property
     *  column="har_carer_kind"
     */
    public final fr.cg95.cvq.business.request.social.HarCarerKindType getHarCarerKind() {
        return this.harCarerKind;
    }

}
