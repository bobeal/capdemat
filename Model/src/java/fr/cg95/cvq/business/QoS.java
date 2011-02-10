package fr.cg95.cvq.business;

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum;

public class QoS extends PersistentStringEnum {

    private static final long serialVersionUID = 1L;

    public static final QoS GOOD = new QoS("Good");
    public static final QoS URGENT = new QoS("Urgent");
    public static final QoS LATE = new QoS("Late");

    private QoS(String name) {
        super(name);
    }

    public QoS() { /* empty constructor for Hibernate */ }

    public static final QoS[] allQoS = {
        GOOD, URGENT, LATE
    };

    public static QoS forString(String enumAsString) {
        if (enumAsString == null)
            return GOOD;
        for (QoS qoS : allQoS)
            if (qoS.toString().equals(enumAsString)) return qoS;
        return GOOD;
    }
}
