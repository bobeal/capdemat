package fr.cg95.cvq.fo.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.users.IRequestService;
import fr.cg95.cvq.wizard.ListListener;
import fr.cg95.cvq.wizard.process.ProcessWizardState;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.SubjectType;

public abstract class IPersistence implements ListListener {
    private String message = null;
    
    public abstract String getServiceName(String definitionName);

    public abstract RequestType createRequest(HttpServletRequest request, Request cvqRequest);

    public abstract Long validateRequest(HttpServletRequest request, Request cvqRequest, Object xmlRequestData)
            throws Exception;

    public String getMessage() {
        String result = message;
        message = null;
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void terminateRequest(HttpServletRequest request, ProcessWizardState wizardState,
            Request cvqRequest) {
    }
    
    public void onAdd(Object data, Object stageForm) {
    }

    public void onSelect(Object data, Object stageForm) {
    }

    public void onNew(Object data, Object stageForm) {
    }

    public void onRemove(Object data, Object stageForm) {
    }

    public void onSave(Object data, Object stageForm) {
    }

    protected Request getCvqRequest(HttpServletRequest request) {
        return getCvqRequest(request.getSession());
    }
    
    protected Request getCvqRequest(HttpSession session) {
        return (Request)session.getAttribute(Request.class.getName());
    }
    
    protected void setAuthorizedSubjects(FamilyHome familyHome) {
        try {
            Set people = ((IRequestService)BusinessManager.getInstance().getAc().getBean(getServiceName("")))
                    .getAuthorizedSubjects(familyHome.getId()).keySet();
            familyHome.setSelectionList(familyHome.getIndividuals(people));
            
        } catch (CvqObjectNotFoundException e) {
        } catch (CvqException e) {
        }
    }
    
    protected Node initializeRequest(HttpServletRequest request, IndividualForm subject) {
        try {
            FamilyHome familyHome = SessionManager.getFamilyHome(request);
    
            Long homeFolderId = null;
            if (familyHome != null) {
                homeFolderId = familyHome.getId();
                familyHome.setIndividualToRegister(subject);
            }

            Long subjectId = null;
            if (subject != null)
                subjectId = subject.getId();
            
            Request cvqRequest = (Request)request.getSession().getAttribute(Request.class.getName());

            return BusinessManager.getInstance().getRequestService().
                        getRequestClone(subjectId, homeFolderId, cvqRequest.getType());

        } catch (CvqException e) {
        }
        return null;
    }

    protected void initializeSubject(RequestType xmlRequest, Long subjectId) {
        Individual subject = null;
        if (subjectId != null)
            try {
                subject = BusinessManager.getInstance().findIndividual(subjectId);
            } catch (CvqException e) {
                e.getMessage();
            }
            
        if (subject != null) {
            if ((subject instanceof Adult) && (subject.getSex() == null ||subject.getSex().equals(SexType.UNKNOWN))) {
                if (((Adult)subject).getTitle().equals(TitleType.MISTER)) {
                    subject.setSex(SexType.MALE);
                } else {
                    subject.setSex(SexType.FEMALE);
                }
            }
            SubjectType xmlSubject = xmlRequest.addNewSubject();
            IndividualType individual = Individual.modelToXml(subject); 
            
            String policy = 
                ((IRequestService)BusinessManager.getInstance().getAc().getBean(getServiceName(""))).getSubjectPolicy();
            if (policy.equals("SUBJECT_POLICY_INDIVIDUAL"))
                xmlSubject.setIndividual(individual);

            else if (individual instanceof AdultType)
                xmlSubject.setAdult((AdultType)individual);

            else if (individual instanceof ChildType)
                xmlSubject.setChild((ChildType)individual);
        }
    }
    
    protected void writeXml(OutputStream out, Object xmlRequest) {
        if (xmlRequest instanceof XmlObject) {
            XmlOptions xmlOptions = new XmlOptions();
            xmlOptions.setSavePrettyPrint();
            xmlOptions.setSavePrettyPrintIndent(4);
            try {
                ((XmlObject)xmlRequest).save(out, xmlOptions);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
