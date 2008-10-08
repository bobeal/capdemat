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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.payment.PaymentResultStatus;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.wizard.process.ProcessWizardState;

public class PaymentResultAction extends CaddyManager {

    private static Logger _logger = Logger.getLogger(PaymentResultAction.class);

    public ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
            HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {

        _logger.debug("doExecute");

        IPaymentService paymentService = BusinessManager.getInstance().getPaymentService();
        Map<String, String> parameters = new HashMap<String, String>();
        Map requestParameters = pRequest.getParameterMap();
        Iterator<String> requestParametersIt = requestParameters.keySet().iterator();
        while (requestParametersIt.hasNext()) {
            String paramKey = requestParametersIt.next();
            String[] paramValues = (String[]) requestParameters.get(paramKey);
            parameters.put(paramKey, paramValues[0]);
        }
        PaymentResultStatus result = paymentService.commitPayment(parameters);

        if (ProcessWizardState.getWizardState(pRequest) != null) {
            // Redirect to Cap Demat from the client, in case the payment
            // provider is calling us directly
            pRequest.setAttribute(URL, "processWizard.do?transition=payed");

        } else if (ManagerWizardState.getWizardState(pRequest) != null) {
            if (result.equals(PaymentResultStatus.OK)
                    || result.equals(PaymentResultStatus.CANCELLED))
                removePurchaseItems(pRequest.getSession());

            ManagerWizardState wizardState = ManagerWizardState.getWizardState(pRequest);
            wizardState.setAlert(getPaymentMessage(result));

            // Redirect to Cap Demat from the client, in case the payment
            // provider is calling us directly
            pRequest.setAttribute(URL, "managerWizard.do?transition=caddy");
        }

        return pMapping.findForward("redirect");
    }

}
