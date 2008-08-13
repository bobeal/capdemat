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

import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class PayAllAction extends CaddyManager {

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

        String action = pRequest.getParameter("action");

        if (action == null)
            return null;

        Payment payment = (Payment) pRequest.getSession().getAttribute(Constants.CADDY);
        if (payment != null) {
            if (action.equals("pay")) {
                // init payment
                IPaymentService paymentService = BusinessManager.getInstance().getPaymentService();

                if (isOnTerminal(pRequest))
                    payment.addPaymentSpecificData("terminal", getTerminal(pRequest));
                
                URL paymentUrl = paymentService.initPayment(payment);

                if (paymentUrl != null)
                    pResponse.sendRedirect(paymentUrl.toString());
 
                else if (ManagerWizardState.getWizardState(pRequest) != null) {
                    ManagerWizardState wizardState = ManagerWizardState.getWizardState(pRequest);
                    wizardState.setAlert("Le service de paiement n'est pas disponible.");
                }
            }

            if (action.equals("cancel")) {
                removePurchaseItems(pRequest.getSession());
            }
        }
        pRequest.setAttribute(ManagerWizardState.TRANSITION_REQUEST_PARAMETER, "caddy");

        return null;
    }

}
