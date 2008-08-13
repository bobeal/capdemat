package fr.cg95.cvq.wizard;

import java.util.ArrayList;
import java.util.Date;

public class ReservationNode {

    private String key;
    private String text;
    private String message;
    private String date;
    private int available = 0;
    private int reserved = 0;
    private int lastReserved = 0;
    private float price = 0;
    private boolean subsrcriberPrice = false;
    private boolean fullPrice = false;
    private boolean halfPrice = false;
    
    private ArrayList children = new ArrayList();
    
    public ReservationNode() {
        super();
    }

    public ReservationNode addDetail(String key, String text, String message, Date date, Integer available) {
        String stringDate = DateUtils.parseDateTime(date); 
        return addDetail(key, text, message, stringDate, available.intValue(), 0, 0);
    }
    
    public ReservationNode addDetail(String key, String text, Float price) {
        return addDetail(key, text, "", "", 0, 0, price.floatValue());
    }
    
    public ReservationNode addDetail(String key, String text, Float price, int reserved) {
        return addDetail(key, text, "", "", 0, reserved, price.floatValue());
    }
    
    private ReservationNode addDetail(String key, String text, String message, String date, int available, int reserved, float price) {
        ReservationNode child = new ReservationNode();
        
        child.setKey(key);
        child.setText(text);
        child.setMessage(message);
        child.setDate(date);
        child.setAvailable(available);
        child.setReserved(reserved);
        child.setPrice(price);
        
        children.add(child);
        
        return child;
    }
    
    public ReservationNode getDetail(String key) {
        for (int i = 0; i < children.size(); i++) 
            if (((ReservationNode)children.get(i)).getKey().equals(key))
                return (ReservationNode)children.get(i);

        return null;
    }
    
    public int getRemaining() {
        return getAllAvailable() - getAllReserved();
    }
    
    public int getAllAvailable() {
        int count = getAvailable();
        for (int i = 0; i < children.size(); i++) 
            count += ((ReservationNode)children.get(i)).getAllAvailable();

        return count;
    }
    
    public int getAllReserved() {
        int count = getReserved();
        for (int i = 0; i < children.size(); i++) 
            count += ((ReservationNode)children.get(i)).getAllReserved();

        return count;
    }
    
    public float getTotalPrice() {
        float total = getPrice() * getReserved();
        for (int i = 0; i < children.size(); i++) 
            total += ((ReservationNode)children.get(i)).getTotalPrice();

        return total;
    }
    
    public String write(String indent) {
        String tag = "";
        boolean writeNode = (indent != null);
        if (writeNode) {
            tag = indent + "<node ";
            
            tag += "key=\"" + key + "\" ";
            tag += "text=\"" + text + "\" ";
            if (message != null)
                tag += "message=\"" + message + "\" ";
            tag += "date=\"" + date + "\" ";
            tag += "available=\"" + available + "\" ";
            tag += "reserved=\"" + reserved + "\" ";
            tag += "price=\"" + price + "\" ";
            if (subsrcriberPrice)
                tag += "subscriber=\"true\" ";
            if (fullPrice)
                tag += "full=\"true\" ";
            if (halfPrice)
                tag += "half=\"true\" ";
            tag += ">";
        } else {
            indent = "";
        }

        for (int i = 0; i < children.size(); i++) 
            tag += ((ReservationNode)children.get(i)).write(indent + "  ");

        if (writeNode)
            tag += indent + "</node>";
        
        return tag;
    }
    
    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList getChildren() {
        return children;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }

    public int getLastReserved() {
        return lastReserved;
    }

    public void setLastReserved(int lastReserved) {
        this.lastReserved = lastReserved;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSubsrcriberPrice() {
        return subsrcriberPrice;
    }

    public void setSubsrcriberPrice(boolean subsrcriberPrice) {
        this.subsrcriberPrice = subsrcriberPrice;
    }

    public boolean isFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(boolean fullPrice) {
        this.fullPrice = fullPrice;
    }

    public boolean isHalfPrice() {
        return halfPrice;
    }

    public void setHalfPrice(boolean halfPrice) {
        this.halfPrice = halfPrice;
    }

}
