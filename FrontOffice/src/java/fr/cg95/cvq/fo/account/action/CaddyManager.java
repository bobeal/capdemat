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

import java.text.DecimalFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentMode;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;


public abstract class CaddyManager extends BasePersonalAction {

    private DecimalFormat formatter = new DecimalFormat("#,##0.00"); 

    protected void addPurchaseItem(HttpServletRequest request, ExternalAccountItem item) 
        throws CvqException {
        
		Payment payment = 
            (Payment) request.getSession().getAttribute(Constants.CADDY);

        IPaymentService paymentService = BusinessManager.getInstance().getPaymentService();
		if (payment == null) {
            PaymentMode paymentMode = null;
            if (isOnTerminal(request))
                paymentMode = PaymentMode.CARD;
            else
                paymentMode = PaymentMode.INTERNET;
            payment = paymentService.createPaymentContainer(item, paymentMode);
			request.getSession().setAttribute(Constants.CADDY, payment);
		} else {
            ExternalAccountItem purchaseItem = findPurchase(payment, item); 
            if (purchaseItem != null)
                paymentService.removePurchaseItemFromPayment(payment, purchaseItem);
            
		    paymentService.addPurchaseItemToPayment(payment, item);
        }
		setCaddyCaption(request.getSession());
    }
	
    protected void removePurchaseItem(HttpSession session, int line) {
        Payment payment = (Payment) session.getAttribute(Constants.CADDY);
        IPaymentService paymentService = BusinessManager.getInstance().getPaymentService();
        if (payment != null) {
            int i = 0;
            Iterator iter = payment.getPurchaseItems().iterator();
            while (iter.hasNext()) {
                PurchaseItem purchaseItem = (PurchaseItem)iter.next();
                if (i == line) {
                    paymentService.removePurchaseItemFromPayment(payment, purchaseItem);
                    break;
                }
                i++;
            }
            if (payment.getPurchaseItems().size() == 0)
                session.removeAttribute(Constants.CADDY);
        }
        setCaddyCaption(session);
    }
    
	protected void removePurchaseItems(HttpSession session) {
	    Payment payment = (Payment) session.getAttribute(Constants.CADDY);
		if (payment != null) {
			session.removeAttribute(Constants.CADDY);
		}
        setCaddyCaption(session);
	}
	
    static public ExternalAccountItem findPurchase(Payment payment, ExternalAccountItem account) {
        for (Iterator i = payment.getPurchaseItems().iterator(); i.hasNext();) {
            ExternalAccountItem purchaseItem = (ExternalAccountItem)i.next();
            if (account.getClass() == purchaseItem.getClass()) {
                if (account.getExternalItemId().equals(purchaseItem.getExternalItemId()))
                    return purchaseItem;
            }
        }
        return null;
    }
    
    private void setCaddyCaption(HttpSession session) {
        String caddyCaption = "0 Paiements en attente : <strong>00,00 &euro;</strong>";

        Payment caddy = (Payment) session.getAttribute(Constants.CADDY);
        if (caddy != null) {
            caddyCaption = "<span class=\"caution\">" + caddy.getPurchaseItems().size() + 
                           "</span> Paiement(s) en attente : <strong class=\"caution\">" + 
                           formatter.format(caddy.getEuroAmount()) + "&euro;</strong>"; 
        }
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(session, 0);
        wizardState.setMenuCaption("0 Paiements en attente : <strong>00,00 &euro;</strong>", caddyCaption);
    }

    protected String getPaymentMessage(PaymentResultStatus status) {
        if (status.equals(PaymentResultStatus.UNKNOWN))
            return "Résultat du paiement inconnu.";
        else if (status.equals(PaymentResultStatus.OK))
            return "Paiement effectué.";
        else if (status.equals(PaymentResultStatus.CANCELLED))
            return "Paiement annulé.";
        else if (status.equals(PaymentResultStatus.REFUSED))
            return "Paiement refusé.";
        else 
            return "Erreur lors du paiement.";
    }
    
}
