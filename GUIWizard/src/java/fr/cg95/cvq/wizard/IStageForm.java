/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2006 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and René le Clercq 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.wizard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.wizard.process.ProcessStageAction;
import fr.cg95.cvq.xml.common.LocalReferentialDataType;
import fr.cg95.cvq.xml.common.PlaceReservationDataType;
import fr.cg95.cvq.xml.common.TicketTypeSelectionType;

/**
 * @author René le CLERCQ
 */
public abstract class IStageForm {
    public abstract void reset(String state);

    public abstract void save(HttpSession session, Object xmlbRequest);

    public abstract void load(HttpSession session, Object xmlbRequest);
    
    public abstract boolean isComplete();

    public static IStageForm getStageForm(HttpSession session) {
        return ProcessStageAction.getStageForm(session);
    }
    
    protected String loadForm(String returnType, Collection repData, LocalReferentialDataType[] xmlData) {
        LocalReferentialDataType refData = xmlData[0];
        while (refData.sizeOfChildrenArray() > 0)
            refData = refData.getChildrenArray(0);
        
        return refData.getName();
    }

    protected boolean[] loadForm(boolean[] returnType, Collection repData, LocalReferentialDataType[] xmlData) {
        boolean[] formData = new boolean[repData.size()];

        if (xmlData != null) {
            int i = 0;
            Iterator data = repData.iterator();
            while (data.hasNext())
                formData[i++] = contains(xmlData, (ReferentialData)data.next());
        }
        return formData;
    }

//    protected LocalReferentialDataType[] saveForm(String formData, Collection repData) {
//        LocalReferentialDataType[] xmlData = new LocalReferentialDataType[1];
//        xmlData[0] = LocalReferentialDataType.Factory.newInstance();
//        xmlData[0].setName(formData);
//        
//        return xmlData;
//    }
//    private LocalReferentialDataType[] saveForm(String formData, Collection repData) {
//        
//        LocalReferentialDataType[] xmlData = new LocalReferentialDataType[1];
//        xmlData[0] = LocalReferentialDataType.Factory.newInstance();
//
//        Iterator it = repData.iterator();
//        while (it.hasNext()) {
//            ReferentialData refData = (ReferentialData) it.next();
//            // found selected means of contact on a first level element
//            if (refData.getKey().equals(formData)) {
//                xmlData[0].setName(formData);
//                return xmlData;
//            } 
//            // search through second level elements
//            if (refData.getChildren() != null) {
//                Collection childrenRefData = refData.getChildren();
//                Iterator childrenRefDataIt = childrenRefData.iterator();
//                while (childrenRefDataIt.hasNext()) {
//                    ReferentialData childRefData = (ReferentialData) childrenRefDataIt.next();
//                    if (childRefData.getKey().equals(formData)) {
//                        xmlData[0].setName(refData.getKey());
//                        LocalReferentialDataType lrdType = xmlData[0].addNewChildren();
//                        lrdType.setName(formData);
//                        return xmlData;
//                    }
//                }
//            }
//        }
//        
//        return xmlData;
//    }
    
    protected LocalReferentialDataType[] saveForm(String formData, Collection repData) {
        
        LocalReferentialDataType[] xmlData = new LocalReferentialDataType[1];
        xmlData[0] = LocalReferentialDataType.Factory.newInstance();

        Iterator it = repData.iterator();
        while (it.hasNext()) {
            ReferentialData refData = (ReferentialData) it.next();
            // found selected means of contact on a first level element
            if (refData.getKey().equals(formData)) {
                xmlData[0].setName(formData);
                return xmlData;
            } 
            // search through second level elements
            if (saveSubLevel(xmlData[0], formData, refData))
                return xmlData;
        }
        return xmlData;
    }
    
    private boolean saveSubLevel(LocalReferentialDataType parent, 
                                String formData, 
                                ReferentialData refData) {

        if (refData.getChildren() != null) {
            parent.setName(refData.getKey());
            for (ReferentialData referentialData : refData.getChildren()) {
                // Construct referential tree
                LocalReferentialDataType lrdType = parent.addNewChildren();
                if (referentialData.getKey().equals(formData)) {
                    lrdType.setName(formData);
                    return true;
                }
                if (saveSubLevel(lrdType, formData, referentialData))
                    return true;
                
                // key not found in sublevel tree, remove child node
                parent.removeChildren(0);
            }
            parent.setName(null);
        }
        return false;
    }
    
    protected LocalReferentialDataType[] saveForm(boolean[] formData, Collection repData) {
        ArrayList xmlList = new ArrayList();
        int i = 0;

        Iterator iter = repData.iterator();
        while (iter.hasNext()) {
            ReferentialData data = (ReferentialData)iter.next();
            if (formData[i++]) {
                LocalReferentialDataType xmlData = LocalReferentialDataType.Factory.newInstance();
                xmlData.setName(data.getKey());
                xmlList.add(xmlData);
            }
        }
        return (LocalReferentialDataType[])xmlList.toArray(new LocalReferentialDataType[xmlList.size()]);
    }

    protected PlaceReservationDataType[] saveForm(ReservationNode node) {
        ArrayList xmlList = new ArrayList();
        Iterator iter =  node.getChildren().iterator();
        while (iter.hasNext()) {
            ReservationNode reservation = (ReservationNode)iter.next();

            if (reservation.getAllReserved() > 0) {
                PlaceReservationDataType xmlData = PlaceReservationDataType.Factory.newInstance();
                xmlData.setName(reservation.getKey());
    
                int nbTickets = reservation.getChildren().size();
                for (int j = 0; j < nbTickets; j++) {
                    ReservationNode ticket = (ReservationNode)reservation.getChildren().get(j);
                    
                    if (ticket.getAllReserved() > 0) {
                        TicketTypeSelectionType ticketType = xmlData.addNewTicketTypeSelection();
                        ticketType.setName(ticket.getKey());
                        ticketType.setNumber(ticket.getAllReserved());
                    }
                }
                xmlList.add(xmlData);
            }
        }
        return (PlaceReservationDataType[])xmlList.toArray(new PlaceReservationDataType[xmlList.size()]);
    }
    
    protected LocalReferentialDataType[] saveForm(ReferentialData node) {
        ArrayList xmlList = new ArrayList();

        Iterator iter =  node.getChildren().iterator();
        while (iter.hasNext()) {
            ReferentialData data = (ReferentialData)iter.next();

            if (data.isSelected()) {
                LocalReferentialDataType xmlData = LocalReferentialDataType.Factory.newInstance();
                xmlData.setName(data.getKey());
                xmlData.setAdditionalInformationValue(data.getPrecision());
                
                if (data.getPriority() == null)
                    xmlData.setPriority(null);

                else try {
                    xmlData.setPriority(BigInteger.valueOf(Long.parseLong(data.getPriority())));
                } catch (NumberFormatException nfe) {
                    xmlData.setPriority(BigInteger.valueOf(0));
                }
                xmlData.setChildrenArray(saveForm(data));
                
                xmlList.add(xmlData);
            }
        }
        return (LocalReferentialDataType[])xmlList.toArray(new LocalReferentialDataType[xmlList.size()]);
    }
    
    private boolean contains(LocalReferentialDataType[] list, ReferentialData data) {
        if ((list != null) && (data != null)) {
            int i = 0;
            while (i < list.length) {
                if ((list[i].getName() != null) && (list[i].getName().equals(data.getKey())))
                    return true;
                i++;
            }
        }
        return false;
    }

}
