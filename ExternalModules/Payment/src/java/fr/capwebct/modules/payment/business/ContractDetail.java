package fr.capwebct.modules.payment.business;

public class ContractDetail {

    private long id;

    private int quantity;
    private int price;
    private int amount;

    private Payment payment;

    public ContractDetail() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof ContractDetail))
            return false;
        ContractDetail contractDetail = (ContractDetail) object;
        return this.id == contractDetail.id;
    }

    @Override
    public int hashCode() {
        return (new Long(this.id)).hashCode();
    }
}
