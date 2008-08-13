package fr.cg95.cvq.fo.referential;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.wizard.ReferentialData;

public class ReferentialAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String repository = request.getParameter("repository");
        ReferentialData referential = getReferentialData(repository, request.getSession());
        if (request.getParameter("load") != null) {
            response.setContentType("text/xml; charset=UTF-8");
            loadReferential(referential, response.getOutputStream());
            response.setStatus(200);

        } else if (request.getParameter("savexml") != null) { 
            resetSelection(referential);
            int status = updateReferential(repository, referential, request.getInputStream(), response.getOutputStream());
            response.setContentType("text/xml; charset=UTF-8");
            response.setStatus(status);

        } else {
            response.setStatus(200);
        }

        return null;
    }

    private ReferentialData getReferentialData(String data, HttpSession session) {
        
        ReferentialData referential = (ReferentialData)session.getAttribute(data);
        if (referential == null) {
            Collection referentialEntries = BusinessManager.getReferentialData(data);
            
            referential = new ReferentialData();
            Iterator iter = referentialEntries.iterator();
            while (iter.hasNext()) {
                addReferentialData(referential, (LocalReferentialEntry)iter.next());
            }
            session.setAttribute(data, referential);
        }
        return referential;
    }
    
    private ReferentialData addReferentialData(ReferentialData data, LocalReferentialEntry entry) {
        ReferentialData refData = data.addDetail(entry.getKey(), entry.getLabelsMap().get("fr").toString());
        if (entry.getMessagesMap() != null)
            refData.setMessage(entry.getMessagesMap().get("fr").toString());
        refData.setPrecision("");
        if (entry.getEntriesSupportPrecision())
            refData.setPrecisionLabel("Niveau");
        refData.setPriority("");
        if (entry.getEntriesSupportPriority())
            refData.setPriorityLabel("Priorité");
        
        if (entry.getEntries() != null) {
            Iterator iter = entry.getEntries().iterator();
            while (iter.hasNext()) {
                addReferentialData(refData, (LocalReferentialEntry)iter.next());
            }
        }
        return refData;
    }
    
    private void loadReferential(ReferentialData referential, ServletOutputStream out) throws IOException {
        out.print("<referential type=\"referential\">");
        
        out.print(referential.write(null));
        out.print("</referential>");
    }

    private int updateReferential(String data, ReferentialData referential, 
                                        ServletInputStream input, ServletOutputStream output) throws IOException {
        Document xmlDocument = parseXmlStream(input);
        
        updateReferentialData(referential, xmlDocument.getFirstChild().getFirstChild());
        
        return 200;
    }
    
    private void updateReferentialData(ReferentialData parent, Node xmlNode) {
        while (xmlNode != null) {
            if (xmlNode.getNodeName().equals("data")) {
                String key = xmlNode.getAttributes().getNamedItem("key").getNodeValue();
                ReferentialData data = parent.getDetail(key);  
                boolean selected = getBooleanValue(xmlNode.getAttributes().getNamedItem("selected"));
                String precision = getValue(xmlNode.getAttributes().getNamedItem("precision"));
                String priority = getValue(xmlNode.getAttributes().getNamedItem("priority"));

                data.setSelected(selected);
                data.setPrecision(precision);
                data.setPriority(priority);
                
                updateReferentialData(data, xmlNode.getFirstChild());
            }
            xmlNode = xmlNode.getNextSibling();
        }
    }
    
    private void resetSelection(ReferentialData parent) {
        parent.setSelected(false);
        for (int i = 0; i < parent.getChildren().size(); i++)
            resetSelection((ReferentialData)parent.getChildren().get(i));
    }
    
    private String getValue(Node attribute) {
        if (attribute != null)
            return attribute.getNodeValue();
        
        return null;
    }
    
    private boolean getBooleanValue(Node attribute) {
        if (attribute != null)
            return Boolean.valueOf(attribute.getNodeValue()).booleanValue();
        
        return false;
    }
    
    private Document parseXmlStream(InputStream is) {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(is);

        } catch (SAXParseException spe) {
            // Error generated by the parser
            System.out.println("\n** Parsing error" + ", line " + spe.getLineNumber() + ", uri " + spe.getSystemId());
            System.out.println("   " + spe.getMessage());

            // Use the contained exception, if any
            Exception x = spe;
            if (spe.getException() != null)
                x = spe.getException();
            x.printStackTrace();

        } catch (SAXException sxe) {
            // Error generated during parsing)
            Exception x = sxe;
            if (sxe.getException() != null)
                x = sxe.getException();
            x.printStackTrace();

        } catch (ParserConfigurationException pce) {
            // Parser with specified options can't be built
            pce.printStackTrace();

        } catch (IOException ioe) {
            // I/O error
            ioe.printStackTrace();
        }
        return document;
    }

}

class ReferentialComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        PlaceReservationType place1 = (PlaceReservationType)o1;
        PlaceReservationType place2 = (PlaceReservationType)o2;
        
        if (place1 != null) {
            if (place2 == null) {
                // place2 is null so place1 is after place2
                return 1;
            }
            return place1.getEventDate().compareTo(place2.getEventDate());
            
        } if (place2 != null) {
            // place1 is null so place1 is before place2
            return -1;
        }
        return 0;
    }
    
}