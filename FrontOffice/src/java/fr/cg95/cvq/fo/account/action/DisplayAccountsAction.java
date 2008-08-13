/*
 * Cartevaloise
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
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
package fr.cg95.cvq.fo.account.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.exception.CvqRemoteException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class DisplayAccountsAction extends BasePersonalAction {

    private static Logger _logger = Logger.getLogger(DisplayAccountsAction.class);

    public ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

        _logger.debug("doExecute");

        try {
            IHomeFolderService homeFolderService = 
                BusinessManager.getInstance().getHomeFolderService();

            ArrayList<AccountGroup> accountGroups = new ArrayList<AccountGroup>();
            
            String type = pRequest.getParameter(ManagerWizardState.TRANSITION_REQUEST_PARAMETER);
            
            if ((type != null) && (type.equals("individuals"))) {
                Map<Long,AccountGroup> subjectsMap = new HashMap<Long,AccountGroup>();
                
                Set ticketingAccounts = 
                    homeFolderService.getExternalAccounts(SessionManager.getFamilyHome(pRequest).getId(), 
                            IPaymentService.EXTERNAL_TICKETING_ACCOUNTS);
    
                for (Iterator i = ticketingAccounts.iterator(); i.hasNext();) {
                    ExternalTicketingContractItem etci = 
                        (ExternalTicketingContractItem) i.next();
                    AccountGroup group = null;
                    if (subjectsMap.get(etci.getSubjectId()) == null) {
                        IIndividualService individualService = BusinessManager.getInstance().getIndividualService();
                        Individual individual = individualService.getById(etci.getSubjectId());
                        group = new AccountGroup();
                        group.setLabel(individual.getFirstName() + " " + individual.getLastName());
                        subjectsMap.put(etci.getSubjectId(), group);
                    } else {
                        group = subjectsMap.get(etci.getSubjectId());
                    }
                    group.addAccount(etci);
                }
                for (Iterator<AccountGroup> i = subjectsMap.values().iterator(); i.hasNext();) {
                    AccountGroup group = i.next();
                    Collections.sort(group.getAccounts(), new AccountsComparator());
                    accountGroups.add(group);
                }
            } else if ((type != null) && (type.equals("invoices"))) {
                Set<ExternalAccountItem> invoices = 
                    homeFolderService.getExternalAccounts(SessionManager.getFamilyHome(pRequest).getId(), 
                            IPaymentService.EXTERNAL_INVOICES);
    
                AccountGroup group = new AccountGroup();
                group.setLabel("Factures à payer");
                accountGroups.add(group);
                
                for (Iterator<ExternalAccountItem> i = invoices.iterator(); i.hasNext();) {
                    ExternalInvoiceItem account = (ExternalInvoiceItem) i.next();
                    if (!account.isPaid())
                        group.addAccount(account);
                }
                Collections.sort(group.getAccounts(), new AccountsComparator());
            
            } else {            
                Set<ExternalAccountItem> depositAccounts = 
                    homeFolderService.getExternalAccounts(SessionManager.getFamilyHome(pRequest).getId(), 
                            IPaymentService.EXTERNAL_DEPOSIT_ACCOUNTS);
    
                AccountGroup group = new AccountGroup();
                group.setLabel("Dépôt");
                accountGroups.add(group);
                
                for (Iterator<ExternalAccountItem> i = depositAccounts.iterator(); i.hasNext();) {
                    group.addAccount(i.next());
                }
                Collections.sort(group.getAccounts(), new AccountsComparator());
            }
            pRequest.getSession().setAttribute("accountGroups", accountGroups);
            
        } catch (CvqRemoteException e) {
            pRequest.setAttribute("error", "Le serveur de paiement est actuellement indisponible");
        }

        // GUI Wizard doesn't use the ActionForward
        return null;
    }

}

class AccountsComparator implements Comparator<ExternalAccountItem> {

    public int compare(ExternalAccountItem o1, ExternalAccountItem o2) {
        if (o1 != null) {
            if (o2 == null) 
                return -1;

            return o1.getExternalItemId().compareTo(o2.getExternalItemId());
            
        } else if (o2 != null) {
            return 1;
        }
        return 0;
    }

}