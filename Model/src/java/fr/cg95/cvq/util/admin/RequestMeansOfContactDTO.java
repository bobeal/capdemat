package fr.cg95.cvq.util.admin;

import java.math.BigInteger;

public class RequestMeansOfContactDTO {
    
    private Long requestId;
    private Long meansOfContactId;
    private String name;
    
    public RequestMeansOfContactDTO(){
    }
    
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(BigInteger requestId) {
        this.requestId = requestId.longValue();
    }

    public Long getMeansOfContactId() {
        return meansOfContactId;
    }

    public void setMeansOfContactId(BigInteger meansOfContactId) {
        this.meansOfContactId = meansOfContactId.longValue();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}