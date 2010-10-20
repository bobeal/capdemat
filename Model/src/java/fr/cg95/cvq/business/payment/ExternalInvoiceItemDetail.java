package fr.cg95.cvq.business.payment;

import java.math.BigDecimal;

public class ExternalInvoiceItemDetail {

    private String subjectName;
    private String subjectSurname;
    private String label;
    private Integer unitPrice;
    private BigDecimal quantity;
    private Integer value;
    
    public ExternalInvoiceItemDetail() {
    }

    public ExternalInvoiceItemDetail(String subjectName, String subjectSurname, String label,
            Integer unitPrice, BigDecimal quantity, Integer value) {
        this.subjectName = subjectName;
        this.subjectSurname = subjectSurname;
        this.label = label;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.value = value;
    }

    /**
     * @hibernate.property
     *  column="subject_name"
     */
    public final String getSubjectName() {
        return subjectName;
    }

    public final void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @hibernate.property
     *  column="label"
     */
    public final String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    /**
     * @hibernate.property
     *  column="quatity"
     */
    public final BigDecimal getQuantity() {
        return quantity;
    }

    public final void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * @hibernate.property
     *  column="subject_surname"
     */
    public final String getSubjectSurname() {
        return subjectSurname;
    }

    public final void setSubjectSurname(String subjectSurname) {
        this.subjectSurname = subjectSurname;
    }

    /**
     * @hibernate.property
     *  column="unit_price"
     */
    public final Integer getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @hibernate.property
     *  column="value"
     */
    public final Integer getValue() {
        return value;
    }

    public final void setValue(Integer value) {
        this.value = value;
    }
}
