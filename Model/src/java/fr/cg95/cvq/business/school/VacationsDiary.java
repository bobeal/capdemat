package fr.cg95.cvq.business.school;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.school.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="vacations_diary"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class VacationsDiary implements Serializable {

    private static final long serialVersionUID = 1L;



    public VacationsDiary() {
        super();
        afternoon = Boolean.valueOf(true);
        noon = Boolean.valueOf(true);
        morning = Boolean.valueOf(true);
        evening = Boolean.valueOf(true);
    }


    public final String modelToXmlString() {

        VacationsDiaryType object = (VacationsDiaryType) this.modelToXml();
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
        VacationsDiaryType vacationsDiary = VacationsDiaryType.Factory.newInstance();
        date = this.day;
        if (date != null) {
            calendar.setTime(date);
            vacationsDiary.setDay(calendar);
        }
        if (this.afternoon != null)
            vacationsDiary.setAfternoon(this.afternoon.booleanValue());
        if (this.noon != null)
            vacationsDiary.setNoon(this.noon.booleanValue());
        if (this.morning != null)
            vacationsDiary.setMorning(this.morning.booleanValue());
        if (this.evening != null)
            vacationsDiary.setEvening(this.evening.booleanValue());
        return vacationsDiary;
    }

    public static VacationsDiary xmlToModel(VacationsDiaryType vacationsDiaryDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        VacationsDiary vacationsDiary = new VacationsDiary();
        calendar = vacationsDiaryDoc.getDay();
        if (calendar != null) {
            vacationsDiary.setDay(calendar.getTime());
        }
        vacationsDiary.setAfternoon(Boolean.valueOf(vacationsDiaryDoc.getAfternoon()));
        vacationsDiary.setNoon(Boolean.valueOf(vacationsDiaryDoc.getNoon()));
        vacationsDiary.setMorning(Boolean.valueOf(vacationsDiaryDoc.getMorning()));
        vacationsDiary.setEvening(Boolean.valueOf(vacationsDiaryDoc.getEvening()));
        return vacationsDiary;
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

    private java.util.Date day;

    public final void setDay(final java.util.Date day) {
        this.day = day;
    }


    /**
     * @hibernate.property
     *  column="day"
     */
    public final java.util.Date getDay() {
        return this.day;
    }

    private Boolean afternoon;

    public final void setAfternoon(final Boolean afternoon) {
        this.afternoon = afternoon;
    }


    /**
     * @hibernate.property
     *  column="afternoon"
     */
    public final Boolean getAfternoon() {
        return this.afternoon;
    }

    private Boolean noon;

    public final void setNoon(final Boolean noon) {
        this.noon = noon;
    }


    /**
     * @hibernate.property
     *  column="noon"
     */
    public final Boolean getNoon() {
        return this.noon;
    }

    private Boolean morning;

    public final void setMorning(final Boolean morning) {
        this.morning = morning;
    }


    /**
     * @hibernate.property
     *  column="morning"
     */
    public final Boolean getMorning() {
        return this.morning;
    }

    private Boolean evening;

    public final void setEvening(final Boolean evening) {
        this.evening = evening;
    }


    /**
     * @hibernate.property
     *  column="evening"
     */
    public final Boolean getEvening() {
        return this.evening;
    }

}
