package fr.capwebct.modules.payment.business;

public class CapwebctAssociationSummary {

    private long externalApplicationId;
    private String state;
    
    public long getExternalApplicationId() {
        return externalApplicationId;
    }
    
    public void setExternalApplicationId(long externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + (int) (externalApplicationId ^ (externalApplicationId >>> 32));
        result = PRIME * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CapwebctAssociationSummary other = (CapwebctAssociationSummary) obj;
        if (externalApplicationId != other.externalApplicationId)
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }
}
