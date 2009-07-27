package fr.capwebct.modules.payment.business;

import java.util.Calendar;
import java.util.Date;

import fr.capwebct.modules.payment.schema.ban.PaymentType;

public class Payment {

    private long id;

    private String paymentType;
    private Date paymentDate;
    private int paymentAmount;
    private String paymentAck;
    private String cvqAck;
    private long cfaId;
    private String broker;
    private boolean exported;
    
    public Payment() {
    }
    
    public static PaymentType modelToXml(Payment payment) {
        if (payment == null)
            return null;
        
        PaymentType paymentType = PaymentType.Factory.newInstance();
        if (payment.getPaymentAck() != null)
            paymentType.setPaymentAck(payment.getPaymentAck());
        if (payment.getCvqAck() != null)
            paymentType.setCvqAck(payment.getCvqAck());
        if (payment.getPaymentDate() != null) {
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(payment.getPaymentDate());
            paymentType.setPaymentDate(calendar);
        }
        paymentType.setPaymentType(payment.getPaymentType());
        paymentType.setPaymentAmount(payment.getPaymentAmount());
        
        return paymentType;
    }

    public static Payment xmlToModel(PaymentType paymentType, long cfaId) {
        if (paymentType == null)
            return null;

        Payment payment = new Payment();
        if (paymentType.getPaymentAck() != null)
            payment.setPaymentAck(paymentType.getPaymentAck());
        if (paymentType.getCvqAck() != null)
            payment.setCvqAck(paymentType.getCvqAck());
        if (paymentType.getPaymentDate() != null)
            payment.setPaymentDate(paymentType.getPaymentDate().getTime());
        payment.setPaymentType(paymentType.getPaymentType());
        payment.setPaymentAmount(paymentType.getPaymentAmount());  
        payment.setBroker(paymentType.getPaymentBroker());
        payment.setCfaId(cfaId);
        return payment;
    }

    public String getCvqAck() {
        return cvqAck;
    }

    public void setCvqAck(String cvqAck) {
        this.cvqAck = cvqAck;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentAck() {
        return paymentAck;
    }

    public void setPaymentAck(String paymentAck) {
        this.paymentAck = paymentAck;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public long getCfaId() {
        return cfaId;
    }

    public void setCfaId(long cfaId) {
        this.cfaId = cfaId;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

	public boolean isExported() {
		return exported;
	}

	public void setExported(boolean exported) {
		this.exported = exported;
	}

	@Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Payment))
            return false;
        Payment payment = (Payment) object;
        if (this.paymentAck != null)
            return this.paymentAck.equals(payment.paymentAck);
        else
            return this.id == payment.id;
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
