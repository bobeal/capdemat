package fr.cg95.cvq.business;

public enum QoS {

    GOOD("Good"),
    URGENT("Urgent"),
    LATE("Late");

    private static final long serialVersionUID = 1L;
    private String name;

    private QoS(String name) {
        this.name = name;
    }

    /**
     * @deprecated only for backward, use values() instead
     */
    public static final QoS[] allQoS = QoS.values();

    public static QoS forString(String enumAsString) {
        if (enumAsString == null)
            return GOOD;
        for (QoS qoS : allQoS)
            if (qoS.toString().equals(enumAsString)) return qoS;
        return GOOD;
    }

    @Override
    public String toString() {
        return name;
    }
}
