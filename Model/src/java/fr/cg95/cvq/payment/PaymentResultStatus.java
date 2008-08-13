package fr.cg95.cvq.payment;

public enum PaymentResultStatus {

    UNKNOWN, OK, CANCELLED, REFUSED, OTHER;
    
    /**
     * Kept for compatibility with Front Office.
     * 
     * @deprecated
     */
    public static int asInt(PaymentResultStatus status) {
        if (status.equals(UNKNOWN))
            return -1;
        else if (status.equals(OK))
            return 0;
        else if (status.equals(CANCELLED))
            return 1;
        else if (status.equals(REFUSED))
            return 1;
        else 
            return 2;
    }
}
