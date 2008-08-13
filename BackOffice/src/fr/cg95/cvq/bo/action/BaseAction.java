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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.bo.Localization;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.dispatcher.StartupServlet;
import fr.cg95.cvq.bo.form.SaveForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.ChildRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.certificate.CvqTagDataType;
import fr.cg95.cvq.certificate.CvqTagdataDocument;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.wizard.manager.ManagerWizardAction;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * The base class that all the application Struts Action classes should extend.
 * 
 * @author René le CLERCQ
 */
public abstract class BaseAction extends ManagerWizardAction {

    public static final String ACTION_CHOICE = "choice";

    public static final String BUTTON_ACTION_CHOICE = "button_choice";

    public static final String POPUP_ACTION_CHOICE = "popup_choice";

    public static final String LINK_ACTION_CHOICE = "link_choice";

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // This line is here for when the input page is upload-utf8.jsp,
        // it sets the correct character encoding for the response.
        String encoding = request.getCharacterEncoding();
        if ((encoding != null) && (encoding.equalsIgnoreCase("utf-8"))) {
            response.setContentType("text/html; charset=utf-8");
        }

        ActionForward forward = executeLogic(mapping, form, request, response);

        if (forward == null)
            super.execute(mapping, form, request, response);

        return forward;
    }

    protected abstract ActionForward executeLogic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception;

    protected StateManager getStateManager(HttpServletRequest request) {
        StateManager stateManager = (StateManager) request.getSession().getAttribute(
                StateManager.STATE_MANAGER);

        ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState(request);
        
        if ((stateManager != null) && (wizardState != null))
            stateManager.setWindowIndex(wizardState.getWizard());
        
        return stateManager;
    }

    protected void manage(HttpServletRequest request) {
        if (SecurityContext.getCurrentSite() != null) {
            ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
    
            wizardState.setDisplayTemplate(DispatchFilter.getAssetsBaseFile("tpl/manager.vm"));
    
            LocalAuthorityConfigurationBean siteData = BusinessManager.getCurrentSiteData(request.getServerName());
            wizardState.setSiteData("BackOffice", siteData.getName(), siteData.getDisplayTitle(), "logoutAction.do", "Me Déconnecter");
        }
        super.manage(request);
    }

    protected File createPdfFile(HttpServletRequest request, SaveForm saveForm) throws Exception {
        // Get the session variables
        ManagerWizardState wizardState = ManagerWizardState.getWizardState(request);
        StateManager stateManager = getStateManager(request);

        if (saveForm.getCertificat() == null)
            return null;
        
        LetterTypeRecord certificat = stateManager.getDeliveryCertificat(saveForm.getCertificat());

        HttpSession session = request.getSession();

        RequestRecord record = (RequestRecord) stateManager.getSelectedRecord();
        String observations;
        if ((wizardState.getTabId() != null) && wizardState.getTabId().equals("delivery"))
            observations = saveForm.getDeliveryExternal();
        else
            observations = saveForm.getInstructionExternal();

        Request modelRequest = BusinessManager.getDefaultRequestService().getById(record.getId());
        
        ChildRecord child = (record.getSubject() instanceof ChildRecord) ? (ChildRecord)record.getSubject() : null;

        CvqTagdataDocument cvqTagdataDocument = CvqTagdataDocument.Factory.newInstance();
        CvqTagDataType cvqTagDataType = cvqTagdataDocument.addNewCvqTagdata();
        cvqTagDataType.setDate(Localization.getLongDateFormatter().format(new Date()));
        cvqTagDataType.setService(record.getCategory().getName());
        if ((record.getLastAgent() != null) && (record.getLastAgent().length() > 0)) {
            cvqTagDataType.setAgent(record.getLastAgent());
            cvqTagDataType.setCourrielAgent(record.getCategory().getEMail());
        } else {
            cvqTagDataType.setAgent(stateManager.getCurrentUser().getFullName());
            cvqTagDataType.setCourrielAgent(record.getCategory().getEMail());
        }  
        cvqTagDataType.setEnvoi(saveForm.getContact());
        cvqTagDataType.setNumeroFamille(String.valueOf(record.getFamilyId()));
        cvqTagDataType.setCivilite(record.getDemander().getTitle());
        cvqTagDataType.setNom(record.getDemander().getName());
        cvqTagDataType.setPrenom(record.getDemander().getFirstName());
        cvqTagDataType.setLogin(record.getDemander().getLogin());
        cvqTagDataType.setAdresse(record.getDemander().getAddress());
        cvqTagDataType.setCodepostal(record.getDemander().getPostalCode());
        cvqTagDataType.setVille(record.getDemander().getCity());
        cvqTagDataType.setNumeroDemande(record.getId().toString());
        cvqTagDataType.setTypeDemande(record.getTypeLabel());
        cvqTagDataType.setDateDemande(record.getLongDate());
        cvqTagDataType.setQuotientFamilial(modelRequest.getHomeFolder().getFamilyQuotient());
        if (child != null) {
            cvqTagDataType.setEnfant(child.getName());
            cvqTagDataType.setDateNaissanceEnfant(child.getBirthDate());
            cvqTagDataType.setNumeroEnfant(String.valueOf(child.getId()));
            if (modelRequest instanceof SchoolRegistrationRequest) {
                SchoolRegistrationRequest srr = (SchoolRegistrationRequest) modelRequest;
                cvqTagDataType.setEcoleEnfant(srr.getSchool().getName());
                cvqTagDataType.setClasseEnfant(BusinessDictionary.getSection(srr.getSection()));
            }
        }
        StringTokenizer tokens = new StringTokenizer(observations,"\r\n");
        while (tokens.hasMoreTokens())
            cvqTagDataType.addNewObservations().setStringValue(tokens.nextToken());
        
        fillBody(certificat.getBody(), cvqTagDataType);
        
        File pdf = StartupServlet.getTempContextFile(session, "tmp", ".pdf");
        File xsl = certificat.getXsltfo();

//        cat.debug("createPdfFile() sending : " + cvqTagdataDocument.toString());
        byte[] data = BusinessManager.generateXslFo(cvqTagdataDocument.getDomNode(), xsl);
        if (data != null) {
            FileOutputStream fos = new FileOutputStream(pdf);
            fos.write(data);
            fos.close();
        } 

        return pdf;
    }

    private void fillBody(File body, CvqTagDataType cvqTagData) {
        try {
            HashMap tagData = getTagData(cvqTagData);
            
            FileInputStream fip = new FileInputStream(body);
            byte buf[] = new byte[new Long(body.length()).intValue()];
            fip.read(buf);
            StringTokenizer lines = new StringTokenizer(new String(buf), "\n");
            
            while (lines.hasMoreTokens()) {
                cvqTagData.addLine(substituteTags(cvqTagData, tagData, lines.nextToken()));
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    
    private HashMap getTagData(CvqTagDataType cvqTagData) {
        HashMap data = new HashMap();
        XmlObject[] children = cvqTagData.selectChildren(QNameSet.ALL);
        for (int i = 0; i < children.length; i++) {
            XmlCursor child = children[i].newCursor();
            String name = child.getName().getLocalPart();
            String value = child.getTextValue();
            
            name = name.replaceAll("_","");
            name = name.toLowerCase();
            
            if (data.get(name) != null) {
                if (data.get(name) instanceof String) {
                    ArrayList set = new ArrayList();
                    set.add(data.get(name));
                    data.put(name,set);
                }
                ((ArrayList)data.get(name)).add(value);
            } else {
                data.put(name, value);
            }
        }
        return data;
    }
    
    private final static String TAG_PREFIX = "${cap:";
    private final static String TAG_POSTFIX = "}";
    
    private String substituteTags(CvqTagDataType document, HashMap tagData, String line) {
        line = line.trim();
        
        int beginTag = line.indexOf(TAG_PREFIX);
        while (beginTag != -1) {
            
            int endTag = line.indexOf(TAG_POSTFIX, beginTag);
            if (endTag != -1) {
                String name = line.substring(beginTag + TAG_PREFIX.length(), endTag);

                name = name.replaceAll("_","");
                name = name.toLowerCase();
                
                Object data = tagData.get(name); 
                if (data != null) {
                    if (data instanceof String) {
                        String value = (String)data;
                        line = line.substring(0,beginTag) + value + line.substring(endTag+1);
                        endTag = beginTag + value.length();
                        
                    } else if (data instanceof ArrayList) {
                        ArrayList lines = (ArrayList)data;
                        for (int i = 0; i < lines.size()-1; i++) {
                            document.addLine((String)lines.get(i));
                        }
                        return (String)lines.get(lines.size()-1);
                    }
                }
            } else {
                endTag = beginTag + TAG_PREFIX.length();
            }
            beginTag = line.indexOf(TAG_PREFIX, endTag);
        }
        return line;
    }
}
