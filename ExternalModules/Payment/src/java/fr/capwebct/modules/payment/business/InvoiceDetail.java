package fr.capwebct.modules.payment.business;

import java.math.BigDecimal;

import fr.capwebct.modules.payment.schema.inv.InvoiceDetailType;

public class InvoiceDetail {

	private long id;

	private String childName;
	private String childSurname;
	private String label;
	private int unitPrice;
	private BigDecimal quantity;
	private int value;

	public InvoiceDetail() {
	}
    
	public static InvoiceDetailType modelToXml(InvoiceDetail invoiceDetail) {
		if (invoiceDetail == null)
			return null;
		
		InvoiceDetailType invoiceDetailType = InvoiceDetailType.Factory.newInstance();
		
		if (invoiceDetail.getChildName() != null)
			invoiceDetailType.setChildName(invoiceDetail.getChildName());
		if (invoiceDetail.getChildSurname() != null)
			invoiceDetailType.setChildSurname(invoiceDetail.getChildSurname());
		invoiceDetailType.setLabel(invoiceDetail.getLabel());
		invoiceDetailType.setQuantity(invoiceDetail.getQuantity());
		invoiceDetailType.setUnitPrice(invoiceDetail.getUnitPrice());
		invoiceDetailType.setValue(invoiceDetail.getValue());
		
		return invoiceDetailType;
	}
	
	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getChildSurname() {
		return childSurname;
	}

	public void setChildSurname(String childSurname) {
		this.childSurname = childSurname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (!(object instanceof InvoiceDetail))
			return false;
		InvoiceDetail invoiceDetail = (InvoiceDetail) object;
		return this.id == invoiceDetail.id;
	}

	@Override
	public int hashCode() {
		return (new Long(this.id)).hashCode();
	}

}
