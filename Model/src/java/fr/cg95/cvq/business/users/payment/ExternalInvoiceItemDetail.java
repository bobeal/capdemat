package fr.cg95.cvq.business.users.payment;

public class ExternalInvoiceItemDetail {

    private String subjectName;
    private String subjectSurname;
    private String label;
    private Integer unitPrice;
    private Integer quantity;
    private Integer value;
    
    public ExternalInvoiceItemDetail() {
    }

    public final String getSubjectName() {
        return subjectName;
    }

    public final void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public final String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    public final Integer getQuantity() {
        return quantity;
    }

    public final void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public final String getSubjectSurname() {
        return subjectSurname;
    }

    public final void setSubjectSurname(String subjectSurname) {
        this.subjectSurname = subjectSurname;
    }

    public final Integer getUnitPrice() {
        return unitPrice;
    }

    public final void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public final Integer getValue() {
        return value;
    }

    public final void setValue(Integer value) {
        this.value = value;
    }
}
