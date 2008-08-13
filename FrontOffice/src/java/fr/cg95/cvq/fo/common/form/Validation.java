package fr.cg95.cvq.fo.common.form;

public class Validation {

    private String meansOfContact;
    
    private String controlId;

    private boolean trace = false;
    private String password;
    private String passwordConfirm;
    private String question;
    private String answer;

    public Validation() {
        super();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public String getMeansOfContact() {
        return meansOfContact;
    }

    public void setMeansOfContact(String meansOfContact) {
        this.meansOfContact = meansOfContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isTrace() {
        return trace;
    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }

}
