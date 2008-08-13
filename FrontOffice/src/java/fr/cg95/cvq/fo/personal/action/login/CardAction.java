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

package fr.cg95.cvq.fo.personal.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.CardState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.card.LPAuthServer;
import fr.cg95.cvq.fo.common.action.BaseAction;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.util.Constants;

/**
 * @author René le CLERCQ
 */
public class CardAction extends BaseAction {
	private static final String CARD_BLOCKED = null;
	
	protected ActionForward doExecute (
		ActionMapping pMapping,
		ActionForm pForm,
		HttpServletRequest pRequest,
		HttpServletResponse pResponse)
		throws Exception {

		try {
			String action = pRequest.getParameter("action");

			String certificate64 = pRequest.getParameter("certificate");
			String signature64 = pRequest.getParameter("signature");
			String pin = pRequest.getParameter("so_pin");
			String state = pRequest.getParameter("state");

            if ((action == null) || action.equalsIgnoreCase("write")) {
                AdultForm adult = (AdultForm) pRequest.getSession().getAttribute(Constants.ADULT_FORM);

                BusinessManager.getInstance().updateCard(adult.getId(), certificate64, pin);

                return pMapping.findForward("write");

            } else if ((action == null) || action.equalsIgnoreCase("deblock")) {
                deBlockCard(certificate64);
                pRequest.getSession().removeAttribute("authentify.username");
                
			} else if ((state != null) && state.equals("1")) {
			    String login = blockCard(certificate64);
                if (login != CARD_BLOCKED) {
                    pRequest.getSession().setAttribute("authentify.username", login);
                    String url = pRequest.getScheme() + "://" + pRequest.getServerName();
                    if (pRequest.getScheme().equals("http") && (pRequest.getServerPort() == 80));
                    else if (pRequest.getScheme().equals("https") && (pRequest.getServerPort() == 443));
                    else
                        url += ":" + pRequest.getServerPort();

                    url += pRequest.getContextPath() + "/personal/authentify.jsp";
                    
					pResponse.sendRedirect(url);
                }
				
			} else if (action.equals("read")) {

				Adult adult = getCardLogin(pRequest, signature64, certificate64);

				if (adult.getCard().getCardState() != CardState.ACTIVE)
					throw new CvqException("Card is not active");
				
				LoginForm login = new LoginForm();
				login.setPassword(adult.getPassword());
				login.setUserName(adult.getLogin());
                pRequest.getSession().setAttribute(BaseAction.AUTHENTIFICATION, login);
                
				return pMapping.findForward("read");
			}

		} catch (CvqException ce) {
			pResponse.sendError(500);
		}
		return null;
	}

	private Adult getCardLogin(HttpServletRequest request, String signature64, String certificate64) throws CvqException {
		HttpSession session = request.getSession();

		// Get session parameters
		String challengeValue = (String) session.getAttribute("challenge");
		String challengeDigestAlgorithm = (String) session.getAttribute("challengeDigestAlgorithm");

		if (challengeValue == null) {
			throw new CvqException("Unauthorized access.");
		}

		if (signature64 == null || certificate64 == null) {
			throw new CvqException("Missing parameters");
		}

		// Decode base64 parameters
		byte[] signature = Base64.decodeBase64(signature64.getBytes());
		byte[] certificate = Base64.decodeBase64(certificate64.getBytes());
		byte[] challenge = Base64.decodeBase64(challengeValue.getBytes());

		// Verify signature
		try {
			LPAuthServer.verifyChallengeSignature(signature, challengeDigestAlgorithm, certificate, challenge);
	
		} catch (Exception exception) {
			throw new CvqException(exception.getMessage());
		}

		return BusinessManager.getInstance().findAdult(certificate64);
	}
	
    private String blockCard(String certificate64) throws CvqException {
        Adult adult = BusinessManager.getInstance().findAdult(certificate64);
        Card card = adult.getCard();

        if (card.getCardState() == CardState.DEBLOCKED)
            return adult.getLogin();
        
        card.setCardState(CardState.BLOCKED);
        
        BusinessManager.getInstance().updateCard(card);
        
        return CARD_BLOCKED;
    }

    private void deBlockCard(String certificate64) throws CvqException {
        Adult adult = BusinessManager.getInstance().findAdult(certificate64);
        Card card = adult.getCard();

        if (card.getCardState() == CardState.DEBLOCKED) {
            card.setCardState(CardState.ACTIVE);
            BusinessManager.getInstance().updateCard(card);
        }
    }

}
