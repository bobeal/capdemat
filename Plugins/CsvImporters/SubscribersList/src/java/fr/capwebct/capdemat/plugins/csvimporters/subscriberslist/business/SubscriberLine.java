package fr.capwebct.capdemat.plugins.csvimporters.subscriberslist.business;

public class SubscriberLine {
    
    private String idSubscriber;
    private Integer fullPriceSubscriber;
    private Integer reducedPriceSubscriber;
    
    public String getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(String idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Integer getFullPriceSubscriber() {
        return fullPriceSubscriber;
    }

    public void setFullPriceSubscriber(Integer fullPriceSubscriber) {
        this.fullPriceSubscriber = fullPriceSubscriber;
    }

    public Integer getReducedPriceSubscriber() {
        return reducedPriceSubscriber;
    }

    public void setReducedPriceSubscriber(Integer reducedPriceSubscriber) {
        this.reducedPriceSubscriber = reducedPriceSubscriber;
    }
}
