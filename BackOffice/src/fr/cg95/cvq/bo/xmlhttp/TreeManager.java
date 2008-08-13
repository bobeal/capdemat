package fr.cg95.cvq.bo.xmlhttp;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.form.RequestForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.PlaceReservationType.TicketSelection;

public class TreeManager extends Action {

    private static final int REQUEST_NODE = 0;
    private static final int DATA_NODE = 1;
    private static final int ENTRY_NODE = 2;
    private static final int SPECTACLE_NODE = 3;
    private static final int RESERVATION_NODE = 4;
    private static final int TICKET_NODE = 5;
    
    private TreeNode treeRoot = null;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        StateManager stateManager = getStateManager(request);
        if (request.getParameter("load") != null) {

            treeRoot = new TreeNode(null, 0, "", "Type de demandes", null);

            RequestForm requestForm = (RequestForm)request.getSession().getAttribute("RequestForm");
            
            if ((requestForm == null) || (requestForm.getRequestType() == null)) {
                treeRoot.setLabel("Paramètres");
                String id = "All";
                String label = "Paramètres globaux";
                TreeNode node = treeRoot.addChild(new TreeNode(treeRoot, REQUEST_NODE, id, label, null));
                node.setExpand(true);

                Set data = BusinessManager.getReferentialRequestData(id);
                if (data != null) {
                    Iterator iterData = data.iterator();
                    while (iterData.hasNext())
                        addData(node, (LocalReferentialType) iterData.next());
                }
//                
//                Iterator iter = stateManager.getRequestManager().getRequestTypeLabels().iterator();
//                while (iter.hasNext()) {
//                    label = (String)iter.next();
//                    id = (String) stateManager.getRequestManager().getRequestTypeLabel(label);
//                    node = treeRoot.addChild(new TreeNode(treeRoot, REQUEST_NODE, id, label, null));
//    
//                    data = BusinessManager.getReferentialRequestData(id);
//                    if (data != null) {
//                        Iterator iterData = data.iterator();
//                        while (iterData.hasNext())
//                            addData(node, (LocalReferentialType) iterData.next());
//                    }
//    
//                    data = BusinessManager.getReservationData(id, true);
//                    if (data != null) {
//                        id = "PlaceReservation";
//                        label = "Spectacles";
//                        TreeNode child = node.addChild(new TreeNode(node, SPECTACLE_NODE, id, label, null));
//    
//                        ArrayList reservationTypes = new ArrayList(data);
//                        Collections.sort(reservationTypes, new ReservationComparator());
//                        
//                        Iterator iterData = reservationTypes.iterator();
//                        while (iterData.hasNext())
//                            addData(child, (PlaceReservationType) iterData.next());
//                    }
//                }
            } else {
                treeRoot.setLabel("Type de demande");
                String label = requestForm.getRequestType().getLabel();
                String id = requestForm.getRequestType().getType();
                TreeNode node = treeRoot.addChild(new TreeNode(treeRoot, REQUEST_NODE, id, label, null));
                node.setExpand(true);
                
                Set data = BusinessManager.getReferentialRequestData(id);
                if (data != null) {
                    Iterator iterData = data.iterator();
                    while (iterData.hasNext())
                        addData(node, (LocalReferentialType) iterData.next());
                }

                data = BusinessManager.getReservationData(id, true);
                if (data != null) {
                    id = "PlaceReservation";
                    label = "Spectacles";
                    TreeNode child = node.addChild(new TreeNode(node, SPECTACLE_NODE, id, label, null));

                    ArrayList reservationTypes = new ArrayList(data);
                    Collections.sort(reservationTypes, new ReservationComparator());
                    
                    Iterator iterData = reservationTypes.iterator();
                    while (iterData.hasNext())
                        addData(child, (PlaceReservationType) iterData.next());
                }
           }
            writeResponse(treeRoot, response.getWriter());
            response.setContentType("text/xml; charset=UTF-8");
            response.setStatus(200);
                
        } else if (request.getParameter("savexml") != null) { 
            try {
                Document xmlDocument = parseXmlStream(request.getInputStream());
                
                Node child = xmlDocument.getFirstChild();
                child = child.getFirstChild();
                
                TreeNode dataNode = synchronizeTreeNode(treeRoot, child);
                
                saveReferentialType(dataNode);

                RequestForm requestForm = (RequestForm)request.getSession().getAttribute("RequestForm");

                
                requestForm.getRequestType().setConfigurable(false);
                Set data = BusinessManager.getReferentialRequestData(requestForm.getRequestType().getType());
                if (data == null) {
                    data = BusinessManager.getReservationData(requestForm.getRequestType().getType(), true);
                    requestForm.getRequestType().setConfigurable(data != null);
                    
                } else {
                    requestForm.getRequestType().setConfigurable((data !=null) && !data.isEmpty());
                }
                
                
//                Set data = BusinessManager.getReferentialRequestData(requestForm.getRequestType().getType());
//                if (data == null)
//                    data = BusinessManager.getReservationData(requestForm.getRequestType().getType(), true);
                
                int state = requestForm.getRequestType().getParameterState();
                
                requestForm.getRequestType().setParameters(data);
                requestForm.getRequestType().setParameterState();

                int newState = requestForm.getRequestType().getParameterState();
                
                if ((newState == RequestTypeRecord.PARAMETERS) && requestForm.getRequestType().isActivated()) {
                    requestForm.getRequestType().setActivated(false);
                    BusinessManager.saveRequestType(requestForm.getRequestType());
                }
                writeResponseData(response.getWriter(), newState != state, dataNode);
                
                response.setStatus(200);
                
            } catch (Exception e) {
                e.printStackTrace(response.getWriter());
                response.setStatus(500);
            }

        } else {
            Enumeration names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                String value = request.getParameter(name);

                if (value != null) {

                }
            }
            response.setStatus(200);
        }

        return null;
    }

    protected StateManager getStateManager(HttpServletRequest request) {
        StateManager stateManager = (StateManager) request.getSession().getAttribute(
                StateManager.STATE_MANAGER);

        return stateManager;
    }

    private void writeResponse(TreeNode tree, Writer out) throws IOException {
        if (tree != null) {
            out.write(tree.write("tree"));
        }
    }

    private void addData(TreeNode parent, LocalReferentialType data) {
        String id = data.getDataName();
        String label = (String) data.getLabelsMap().get("fr");
        TreeNode node = new TreeNode(parent, DATA_NODE, id, label, data);

        node.addProperty(new NodeProperty("message", "", "text"));
        node.addProperty(new NodeProperty("supportMultiple", String.valueOf(data.getEntriesSupportMultiple()), "checkbox"));
        node.addProperty(new NodeProperty("supportQuota", String.valueOf(data.getEntriesSupportQuota()), "checkbox"));
        node.addProperty(new NodeProperty("supportPriority", String.valueOf(data.getEntriesSupportPriority()), "checkbox"));
        node.addProperty(new NodeProperty("labelPriority", "Priorité", "text"));
        node.addProperty(new NodeProperty("supportPrecision", String.valueOf(data.getEntriesSupportPrecision()), "checkbox"));
        node.addProperty(new NodeProperty("labelPrecision", "", "text"));

        if (data.getEntries() != null) {
            Iterator iter = data.getEntries().iterator();
            while (iter.hasNext())
                addNode(node, (LocalReferentialEntry) iter.next());
        }
        parent.addChild(node);
    }

    private void addNode(TreeNode parent, LocalReferentialEntry entry) {
        String id = entry.getKey();
        String label = (String) entry.getLabelsMap().get("fr");
        TreeNode node = new TreeNode(parent, ENTRY_NODE, id, label, entry);

        if ((entry.getMessagesMap() != null) && !entry.getMessagesMap().isEmpty())
            node.addProperty(new NodeProperty("message", (String) entry.getMessagesMap().get("fr"), "text"));
        else
            node.addProperty(new NodeProperty("message", "", "text"));

        node.addProperty(new NodeProperty("supportMultiple", String.valueOf(entry.getEntriesSupportMultiple()), "checkbox"));
        node.addProperty(new NodeProperty("supportPriority", String.valueOf(entry.getEntriesSupportPriority()), "checkbox"));
        node.addProperty(new NodeProperty("labelPriority", "Priorité", "text"));
        node.addProperty(new NodeProperty("supportPrecision", String.valueOf(entry.getEntriesSupportPrecision()), "checkbox"));

        if ((entry.getPrecisionsMap() != null) && !entry.getPrecisionsMap().isEmpty())
            node.addProperty(new NodeProperty("labelPrecision", (String) entry.getPrecisionsMap().get("fr"), "text"));
        else
            node.addProperty(new NodeProperty("labelPrecision", "", "text"));

        if ((entry.getEntries() != null) && !entry.getEntries().isEmpty()) {
            Iterator iter = entry.getEntries().iterator();
            while (iter.hasNext())
                addNode(node, (LocalReferentialEntry) iter.next());
        }
        parent.addChild(node);
    }

    private void addData(TreeNode parent, PlaceReservationType data) {
        String id = data.getKey();
        String label = (String) data.getLabelsMap().get("fr");
        
        TreeNode node = parent.setChild(id, label, RESERVATION_NODE, false);
        
        node.setData(data);

        node.setProperty("message", notNull(data.getMessage()), "text");
        node.setProperty("eventDate", Utils.getDateAsTimeString(data.getEventDate()), "datetime");
        node.setProperty("reservationStartDate", Utils.getDateAsString(data.getReservationStartDate()), "date");
        node.setProperty("reservationEndDate", Utils.getDateAsString(data.getReservationEndDate()), "date");
        node.setProperty("quota", String.valueOf(data.getQuota()), "text");
        node.setProperty("remainingPlaces", String.valueOf(data.getRemainingPlaces()), "none");

        try { //if (data.getTicketsSelection() != null) {
            Iterator iter = data.getTicketsSelection().iterator();
            while (iter.hasNext())
                addNode(node, (TicketSelection) iter.next());
        } catch (NullPointerException npe) {
            npe.getMessage();
        }
    }

    private void addNode(TreeNode parent, TicketSelection data) {
        String id = data.getName();
        String label = (String) data.getLabelsMap().get("fr");
        TreeNode node = parent.setChild(id, label, TICKET_NODE, false);
        
        node.setData(data);

        node.setProperty("price", String.valueOf(data.getPrice()), "text");
        node.setProperty("subscriber", String.valueOf(data.isSubscriberPrice()), "checkbox");
    }

    private TreeNode synchronizeTreeNode(TreeNode treeNode, Node xmlNode) {
        String id = xmlNode.getAttributes().getNamedItem("id").getNodeValue();
        String label = xmlNode.getAttributes().getNamedItem("label").getNodeValue();
        boolean remove = (xmlNode.getAttributes().getNamedItem("remove") != null);
        
        int topNodeType = 0;
        int type = 0;
        switch(treeNode.getType()) {
            case REQUEST_NODE: 
                type = DATA_NODE;
                break;
                
            case DATA_NODE: 
                type = ENTRY_NODE;
                break;
                
            case ENTRY_NODE: 
                type = ENTRY_NODE;
                break;
                
            case SPECTACLE_NODE: 
                type = RESERVATION_NODE;
                break;
                
            case RESERVATION_NODE: 
                type = TICKET_NODE;
                break;
        }

        TreeNode treeChild = treeNode.setChild(id, label, type, remove);
        TreeNode topNode = treeChild;
        
        if (treeChild.getType() == SPECTACLE_NODE) 
            topNodeType = SPECTACLE_NODE;

        Node xmlChild = xmlNode.getFirstChild();
        while (xmlChild != null) {
            if (xmlChild.getNodeName().equals("node")) {
                TreeNode child = synchronizeTreeNode(treeChild, xmlChild);
                if (topNode.getType() == topNodeType)
                    topNode = child;
            
            } else if (xmlChild.getNodeName().equals("property")) {
                treeChild.setProperty(xmlChild.getAttributes().getNamedItem("key").getNodeValue(),
                                      xmlChild.getAttributes().getNamedItem("value").getNodeValue(),
                                      xmlChild.getAttributes().getNamedItem("type").getNodeValue());
            }
            xmlChild = xmlChild.getNextSibling();
        }
        return topNode;
    }
    
    private void saveReferentialType(TreeNode treeNode) throws Exception {
        if (treeNode.getType() == DATA_NODE) {
            LocalReferentialType data = toReferentialType(treeNode);
            
            BusinessManager.saveReferentialData(data);

        } else if (treeNode.getType() == SPECTACLE_NODE) {
            Set data = toReservationSet(treeNode);
            
            BusinessManager.saveReservationData(treeNode.getParent().getId(), data);

        } else if (treeNode.getType() == RESERVATION_NODE) {
            PlaceReservationType data = toReservationType(treeNode);
            
            BusinessManager.setReservationData(treeNode.getParent().getParent().getId(), data, treeNode.isRemoved());

        }
    }
    
    private void writeResponseData(Writer out, boolean refresh, TreeNode treeNode) throws IOException {
        if (treeNode.getType() == RESERVATION_NODE) {
            PlaceReservationType data = BusinessManager.getReservationData(treeNode.getParent().getParent().getId(), treeNode.getId());
            
            if (data != null)
                addData(treeNode.getParent(),data);
            
            out.write(writeReservationData(treeNode, refresh));
        } else {
            out.write(refreshPage(refresh));
        }
    }
    
    private String refreshPage(boolean refresh) {
        if (refresh)
            return "<node refresh=\"true\"/>";
        
        return "<node refresh=\"false\"/>";
    }
    
    private String writeReservationData(TreeNode treeNode, boolean refresh) {
        String id = treeNode.getId();
        String quota = treeNode.getProperty("quota");
        String remaining = treeNode.getProperty("remainingPlaces");
        String reset = (refresh)? "true" : "false";
        String data = "<node refresh=\"" + reset + "\" id=\"" + id + "\" quota=\"" + quota + "\" remaining=\"" + remaining + "\" />";
        
        return data;
    }
    
    private LocalReferentialType toReferentialType(TreeNode node) {
        LocalReferentialType refData = null;
        
        if (node.getType() == DATA_NODE) {
            refData = (LocalReferentialType)node.getData();
            if (refData == null) {
                refData = new LocalReferentialType();
                refData.setDataName(node.getId());
            }
            refData.addLabel("fr", node.getLabel());
            refData.setEntriesSupportMultiple(Boolean.getBoolean(node.getProperty("supportMultiple")));
            refData.setEntriesSupportPrecision(Boolean.getBoolean(node.getProperty("supportPrecision")));
            refData.setEntriesSupportPriority(Boolean.getBoolean(node.getProperty("supportPriority")));
            refData.setEntriesSupportQuota(Boolean.getBoolean(node.getProperty("supportQuota")));
            
            if (refData.getEntries() != null)
                refData.getEntries().clear();
            
            for (int i = 0; i < node.nbChildren(); i++)
                refData.addEntry(toReferentialEntry(node.getChild(i)));
        }
        return refData;
    }
    
    private LocalReferentialEntry toReferentialEntry(TreeNode node) {
        LocalReferentialEntry refEntry = null;
        
        if (node.getType() == ENTRY_NODE) {
            refEntry = (LocalReferentialEntry)node.getData();
            if (refEntry == null) {
                refEntry = new LocalReferentialEntry();
                refEntry.setKey(node.getId());
            }
            refEntry.addLabel("fr", node.getLabel());
            refEntry.addMessage("fr", node.getProperty("message"));
//            refEntry.addPrecision("fr", node.getProperty("labelPrecision"));
            refEntry.setEntriesSupportMultiple(Boolean.valueOf(node.getProperty("supportMultiple")).booleanValue());
            refEntry.setEntriesSupportPrecision(Boolean.valueOf(node.getProperty("supportPrecision")).booleanValue());
            refEntry.setEntriesSupportPriority(Boolean.valueOf(node.getProperty("supportPriority")).booleanValue());
            
            if (refEntry.getEntries() != null)
                refEntry.getEntries().clear();
            
            for (int i = 0; i < node.nbChildren(); i++)
                refEntry.addEntry(toReferentialEntry(node.getChild(i)));
        }
        return refEntry;
    }
    
    private Set toReservationSet(TreeNode node) {
        HashSet data = new HashSet();
        
        if (node.getType() == SPECTACLE_NODE) {
            for (int i = 0; i < node.nbChildren(); i++) {
                    data.add(toReservationType(node.getChild(i)));
            }
        }
        return data;
    }
    
    private PlaceReservationType toReservationType(TreeNode node) {
        PlaceReservationType data = null;
        if (node.getType() == RESERVATION_NODE) {
            data = (PlaceReservationType)node.getData();
            if (data == null) {
                data = new PlaceReservationType();
                data.setKey(node.getId());
            }
            data.addLabel("fr", node.getLabel());
            data.setMessage(node.getProperty("message"));
            data.setEventDate(Utils.getTimeStringAsDate(node.getProperty("eventDate")));
            data.setReservationEndDate(Utils.getStringAsDate(node.getProperty("reservationEndDate")));
            data.setReservationStartDate(Utils.getStringAsDate(node.getProperty("reservationStartDate")));
            data.setQuota(getInteger(node.getProperty("quota")));
            
            if (data.getTicketsSelection() != null)
                data.getTicketsSelection().clear();

            for (int i = 0; i < node.nbChildren(); i++) {
                data.addTicketSelection(toTicketSelection(data, node.getChild(i)));
            }
        }
        return data;
    }
    
    private TicketSelection toTicketSelection(PlaceReservationType reservation, TreeNode node) {
        TicketSelection data = null;
        if (node.getType() == TICKET_NODE) {
            data = reservation.new TicketSelection(node.getId(), Float.valueOf(node.getProperty("price")));
            data.addLabel("fr", node.getLabel());
            data.setIsSubscriberPrice(Boolean.valueOf(node.getProperty("subscriber")).booleanValue());
        }
        return data;
    }

    private Integer getInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException nfe) {
            return new Integer(0);
        }
    }
    
    private String notNull(String value) {
        if (value == null)
            return "";
        
        return value;
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

class ReservationComparator implements Comparator {

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