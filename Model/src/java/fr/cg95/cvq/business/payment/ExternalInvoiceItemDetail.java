package fr.cg95.cvq.business.payment;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="external_invoice_item_detail")
public class ExternalInvoiceItemDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="subject_name")
    private String subjectName;

    @Column(name="subject_surname")
    private String subjectSurname;

    private String label;

    @Column(name="unit_price")
    private Integer unitPrice;

    private BigDecimal quantity;

    private Integer value;

    @ManyToOne(optional=false,fetch=FetchType.EAGER)
    @JoinColumn(name="external_invoice_item_id")
    private ExternalInvoiceItem externalInvoiceItem;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public final BigDecimal getQuantity() {
        return quantity;
    }

    public final void setQuantity(BigDecimal quantity) {
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

    public ExternalInvoiceItem getExternalInvoiceItem() {
        return externalInvoiceItem;
    }

    public void setExternalInvoiceItem(ExternalInvoiceItem externalInvoiceItem) {
        this.externalInvoiceItem = externalInvoiceItem;
    }

}
