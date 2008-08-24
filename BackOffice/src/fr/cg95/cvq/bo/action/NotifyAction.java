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

package fr.cg95.cvq.bo.action;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.LP7CertifyProperties;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class NotifyAction extends BaseAction {

    /*
     * (non-Javadoc)
     * 
     * @see fr.cg95.cvq.bo.action.BaseAction#executeLogic(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Get the session variables
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        StateManager stateManager = getStateManager(request);

        SaveForm saveForm = (SaveForm) form;

        File attach = createPdfFile(request, saveForm);

        if ((attach != null) && LP7CertifyProperties.isConfigured()) {
            String url = request.getContextPath() + "/jsp/bo/process/certifymail.jsp?file=" + URLEncoder.encode(attach.getName(),"utf-8");
    
            request.setAttribute("url", url);
            request.setAttribute("popup", "");
    
            return mapping.findForward("certify");
        }

        if ((saveForm.getMail() == null) || (saveForm.getMail().length() == 0))
            if (stateManager.getSelectedRecord() instanceof RequestRecord)
                saveForm.setMail(((RequestRecord)stateManager.getSelectedRecord()).getEMail());
            
        String enumKey = BusinessDictionary.getMeansOfContactKey(saveForm.getContact());
        if (enumKey != null) {
            String from = null;
            String to = null;
            String subject = null;
            String content = null;
            
            if (enumKey.equals(MeansOfContactEnum.EMAIL.toString())) {
                RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
                from = record.getCategory().getEMail();
                to = saveForm.getMail();
                subject = record.getTypeLabel();
                content = "Bonjour,\n\nVeuillez trouver ci-joint le document concernant votre "
                    + liason("demande", "de", record.getTypeLabel());

            } else if (enumKey.equals(MeansOfContactEnum.SMS.toString())) {
                to = saveForm.getMobilePhone();
                if ((wizardState.getTabId() != null) && wizardState.getTabId().equals("delivery"))
                    content = saveForm.getDeliveryExternal();
                else
                    content = saveForm.getInstructionExternal();
                // FIXME : textareas have an unexpected and unwanted initial "\r\n"
                content = content.replaceFirst("\r\n", "");
                if (content == null || content.trim().length() == 0) {
                    throw new CvqException("sms.message_required");
                }
            }
            if (to != null)
                BusinessManager.notifyRequester(enumKey, from, to, subject, content, attach);
        }
        return null;
    }

    private String liason(String prefix, String article, String subject) {

        if (subject.toLowerCase().startsWith(prefix.toLowerCase()))
            return subject;

        String vowels = "aeiou";

        if (vowels.indexOf(subject.toLowerCase().charAt(0)) != -1)
            article = article.substring(0, article.length() - 1) + "'";
        else
            article += " ";

        return prefix + " " + article + subject;
    }

}
