package fr.cg95.cvq.bo.form;

import org.apache.struts.action.ActionForm;

public class MessageForm extends ActionForm {
    
    private boolean blockPayment;
    private String message;
    
    public boolean isBlockPayment() {
        return blockPayment;
    }
    public void setBlockPayment(boolean blockPayment) {
        this.blockPayment = blockPayment;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
