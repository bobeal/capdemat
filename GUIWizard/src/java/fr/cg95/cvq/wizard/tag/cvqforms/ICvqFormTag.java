package fr.cg95.cvq.wizard.tag.cvqforms;

public interface ICvqFormTag {
    static final int CHANGE_EVENT = 1;
    static final int KEYPRESS_EVENT = 2;

	public String getMode();
	public void setMode(String mode);
	public String getName();
	public void setName(String name);

}
