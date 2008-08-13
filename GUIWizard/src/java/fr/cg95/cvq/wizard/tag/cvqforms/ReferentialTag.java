package fr.cg95.cvq.wizard.tag.cvqforms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.wizard.ReferentialData;

public class ReferentialTag extends CvqFormTag {

    private String repository = null;
    
    public int doEndTag() throws JspException {
        
        if (!writeTag("referential","end",this)) {
            if (display()) try {
                JspWriter out = pageContext.getOut();
    
                if ((getMode() == null) || !getMode().equalsIgnoreCase("static")) {
                    out.println("<div id=\"" + getName() + "\">&nbsp;</div>");
                    out.println("<script language=\"JavaScript\">");
                    out.println("    initXmlReservation('referentialAction.do?repository=" + getRepository() + "', '" + getName() + "');");
                    out.println("</script>");
                } else {
                    ReferentialData referential = (ReferentialData)pageContext.getSession().getAttribute(getRepository());
                    Iterator iter = referential.getChildren().iterator();
                    while (iter.hasNext()) {
                        ReferentialData child = (ReferentialData)iter.next();;
                        displayStaticReferential(out, child);
                    }
                }
            } catch (Exception ignored) {
            }
        }
        return EVAL_PAGE;
    }

    private void displayStaticReferential(JspWriter out, ReferentialData data) throws IOException {
        if ((data != null) && data.isSelected()) {

            if (data.getChildren().size() > 0) {
                out.println("<div class=\"reservation\">");
                out.println("  <div class=\"reservation-header\">");
                out.println("    <div class=\"title\">" + data.getValue() + "</div>");
                if (data.getPrecisionLabel() != null) {
                    out.println("    <div class=\"precision\" >");
                    out.println("      " + data.getPrecisionLabel());
                    out.println("    </div>");
                }
                if (data.getPriorityLabel() != null) {
                    out.println("    <div class=\"priority\" >");
                    out.println("      " + data.getPriorityLabel());
                    out.println("    </div>");
                }
                out.println("  </div>");
                Iterator iter = data.getChildren().iterator();
                while (iter.hasNext()) {
                    ReferentialData child = (ReferentialData)iter.next();;
                    displayStaticReferential(out, child);
                }
                out.println("</div>");
            } else {
                out.println("  <div class=\"detail\">");
                out.println("    <div class=\"detail-field\">");
                out.println("      <label>");
                out.println("        <input type=checkbox checked disabled/> " + data.getValue());
                out.println("      </label>");
                if (data.getParent().getPrecisionLabel() != null) {
                    out.println("      <div class=\"precision\">");
                    out.println("        " + getStringValue(data.getPrecision()));
                    out.println("      </div>");
                }
                if (data.getParent().getPriorityLabel() != null) {
                    out.println("      <div class=\"priority\">");
                    out.println("        " + getStringValue(data.getPriority()));
                    out.println("      </div>");
                }
                out.println("    </div>");
                out.println("  </div>");
            }
        }
    }
    
    private String getStringValue(String value) {
        if (value == null)
            return "";
        
        return value;
    }
    
    public ArrayList getCheckedItems() {
        ReferentialData refData = (ReferentialData)pageContext.getSession().getAttribute(getRepository());
        ArrayList<ReferentialData> checkedList = new ArrayList<ReferentialData>();
        
        checkChildren(null, "", checkedList, refData.getChildren());
        
        return checkedList;
    }
    
    private void checkChildren(String top, String prefix, ArrayList<ReferentialData> checkedList, ArrayList<ReferentialData> children) {
        for (ReferentialData child : children) {
            String parent = (top != null) ? top : child.getValue();
            if (child.isSelected() && child.getChildren().isEmpty()) {
                ReferentialData item = new ReferentialData("key",prefix + child.getValue());
                item.setLabel(parent);
                checkedList.add(item);
                
                if ((child.getPrecision() != null) && (child.getPrecision().length() > 0)) {
                    item = new ReferentialData("key","Niveau : " + child.getPrecision());
                    item.setLabel("");
                    checkedList.add(item);
                }
                if ((child.getPriority() != null) && (child.getPriority().length() > 0)) {
                    item = new ReferentialData("key","Priorité : " + child.getPriority());
                    item.setLabel("");
                    checkedList.add(item);
                }
            }
            String childPrefix = "";
            if (top != null) {
                if (prefix.length() == 0)
                    childPrefix = child.getValue() + " - ";
                else
                    childPrefix = prefix + child.getValue() + " - ";
            }
            checkChildren(parent, childPrefix, checkedList, child.getChildren());
        }
    }
    
    public String getRepository() {
        if (repository != null)
            return repository;
        
        return "";
    }

    public void setRepository(String data) {
        this.repository = data;
    }

}
