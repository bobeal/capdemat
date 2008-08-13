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
 *  table="dhr_previous_dwelling"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class DhrPreviousDwelling implements Serializable {

    private static final long serialVersionUID = 1L;



    public DhrPreviousDwelling() {
        super();
    }


    public final String modelToXmlString() {

        DhrPreviousDwellingType object = (DhrPreviousDwellingType) this.modelToXml();
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
        DhrPreviousDwellingType dhrPreviousDwelling = DhrPreviousDwellingType.Factory.newInstance();
        date = this.previousDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwelling.setPreviousDwellingArrivalDate(calendar);
        }
        if (this.previousDwellingAddress != null)
            dhrPreviousDwelling.setPreviousDwellingAddress(Address.modelToXml(this.previousDwellingAddress));
        date = this.previousDwellingDepartureDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwelling.setPreviousDwellingDepartureDate(calendar);
        }
        return dhrPreviousDwelling;
    }

    public static DhrPreviousDwelling xmlToModel(DhrPreviousDwellingType dhrPreviousDwellingDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        DhrPreviousDwelling dhrPreviousDwelling = new DhrPreviousDwelling();
        calendar = dhrPreviousDwellingDoc.getPreviousDwellingArrivalDate();
        if (calendar != null) {
            dhrPreviousDwelling.setPreviousDwellingArrivalDate(calendar.getTime());
        }
        if (dhrPreviousDwellingDoc.getPreviousDwellingAddress() != null)
            dhrPreviousDwelling.setPreviousDwellingAddress(Address.xmlToModel(dhrPreviousDwellingDoc.getPreviousDwellingAddress()));
        calendar = dhrPreviousDwellingDoc.getPreviousDwellingDepartureDate();
        if (calendar != null) {
            dhrPreviousDwelling.setPreviousDwellingDepartureDate(calendar.getTime());
        }
        return dhrPreviousDwelling;
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

    private java.util.Date previousDwellingArrivalDate;

    public final void setPreviousDwellingArrivalDate(final java.util.Date previousDwellingArrivalDate) {
        this.previousDwellingArrivalDate = previousDwellingArrivalDate;
    }


    /**
     * @hibernate.property
     *  column="previous_dwelling_arrival_date"
     */
    public final java.util.Date getPreviousDwellingArrivalDate() {
        return this.previousDwellingArrivalDate;
    }

    private fr.cg95.cvq.business.users.Address previousDwellingAddress;

    public final void setPreviousDwellingAddress(final fr.cg95.cvq.business.users.Address previousDwellingAddress) {
        this.previousDwellingAddress = previousDwellingAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="previous_dwelling_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getPreviousDwellingAddress() {
        return this.previousDwellingAddress;
    }

    private java.util.Date previousDwellingDepartureDate;

    public final void setPreviousDwellingDepartureDate(final java.util.Date previousDwellingDepartureDate) {
        this.previousDwellingDepartureDate = previousDwellingDepartureDate;
    }


    /**
     * @hibernate.property
     *  column="previous_dwelling_departure_date"
     */
    public final java.util.Date getPreviousDwellingDepartureDate() {
        return this.previousDwellingDepartureDate;
    }

}
