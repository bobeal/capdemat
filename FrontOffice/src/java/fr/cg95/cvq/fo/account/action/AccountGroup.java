package fr.cg95.cvq.fo.account.action;

import java.util.ArrayList;

import fr.cg95.cvq.business.users.payment.ExternalAccountItem;

public class AccountGroup {
    private static int globalId = 1;

    private String name;
    private String label;
    private ArrayList<ExternalAccountItem> accounts = new ArrayList<ExternalAccountItem>();
    
    public AccountGroup() {
        super();
        name = "Group" + globalId++;
    }

    public void addAccount(ExternalAccountItem account) {
        accounts.add(account);
    }
    
    public ArrayList<ExternalAccountItem> getAccounts() {
        return accounts;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

}
