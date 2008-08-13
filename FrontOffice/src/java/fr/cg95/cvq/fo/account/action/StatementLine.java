package fr.cg95.cvq.fo.account.action;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.cg95.cvq.fo.util.TimeHandler;

public class StatementLine implements Serializable, Comparable {

    private Date date;
    private String type;
    private String label;
    private String value;
    private double amount;
    
    private ArrayList<StatementLine> details = new ArrayList<StatementLine>();
    
    private DecimalFormat formatter = new DecimalFormat("#,##0.00"); 

    public StatementLine() {
        super();
    }

    public void addDetail(StatementLine line) {
        details.add(line);
    }

    public List<StatementLine> getDetail() {
        return details;
    }
    
    public String getAmount() {
        return formatter.format(amount);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate(Date type) {
        return date;
    }
    
    public String getDate() {
        return TimeHandler.parseDate(date ,TimeHandler.SHORT_DATE_FORMAT);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int compareTo(Object o) {
        if (o == null)
            return -1;
        
        return (-1) * date.compareTo(((StatementLine)o).getDate(date));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
