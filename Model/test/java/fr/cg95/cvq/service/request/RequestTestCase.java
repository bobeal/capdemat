package fr.cg95.cvq.service.request;

import java.util.ArrayList;
import java.util.List;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class RequestTestCase extends ServiceTestCase {

    protected static IDocumentService iDocumentService;
    protected static IDocumentTypeService iDocumentTypeService;

    /**
     * Utility method used to easily get an home folder and individuals while running services
     * related tests
     */
    public CreationBean gimmeAnHomeFolderWithRequest()
        throws CvqException {

        // keep current context to reset it after home folder creation
        String currentContext = SecurityContext.getCurrentContext();
        Agent currentAgent = SecurityContext.getCurrentAgent();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        VoCardRequest request = new VoCardRequest();

        address = BusinessObjectsFactory.gimmeAdress("12","Rue d'Aligre", "Paris", "75012");

        homeFolderResponsible =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "responsible", address,
                    FamilyStatusType.MARRIED);
        iHomeFolderService.addHomeFolderRole(homeFolderResponsible, RoleType.HOME_FOLDER_RESPONSIBLE);
        homeFolderResponsible.setPassword("toto");

        homeFolderWoman =
            BusinessObjectsFactory.gimmeAdult(TitleType.MADAM, "LASTNAME", "wife", address,
                    FamilyStatusType.MARRIED);
        homeFolderUncle =
            BusinessObjectsFactory.gimmeAdult(TitleType.MISTER, "LASTNAME", "uncle", address,
                    FamilyStatusType.SINGLE);
        List<Adult> adultSet = new ArrayList<Adult>();
        adultSet.add(homeFolderResponsible);
        adultSet.add(homeFolderWoman);
        adultSet.add(homeFolderUncle);

        child1 = BusinessObjectsFactory.gimmeChild("LASTNAME", "childone");
        child1.setSex(SexType.MALE);
        iHomeFolderService.addIndividualRole(homeFolderResponsible, child1, RoleType.CLR_FATHER);
        iHomeFolderService.addIndividualRole(homeFolderWoman, child1, RoleType.CLR_MOTHER);
        iHomeFolderService.addIndividualRole(homeFolderUncle, child1, RoleType.CLR_TUTOR);
        
        child2 = BusinessObjectsFactory.gimmeChild("LASTNAME", "childtwo");
        child2.setSex(SexType.MALE);
        iHomeFolderService.addIndividualRole(homeFolderResponsible, child2, RoleType.CLR_FATHER);

        List<Child> childSet = new ArrayList<Child>();
        childSet.add(child1);
        childSet.add(child2);

        iVoCardRequestService.create(request, adultSet, childSet, null, address, null);

        CreationBean cb = new CreationBean();
        cb.setRequestId(request.getId());
        voCardRequestId = request.getId();
        cb.setHomeFolderId(request.getHomeFolderId());
        cb.setLogin(homeFolderResponsible.getLogin());
        
        homeFolderVoCardRequestIds.put(request.getHomeFolderId(), voCardRequestId);

        if (currentContext != null)
            SecurityContext.setCurrentContext(currentContext);
        if (currentAgent != null)
            SecurityContext.setCurrentAgent(currentAgent);
        
        return cb;
    }

    public void setDocumentService(IDocumentService documentService) {
        iDocumentService = documentService;
    }
    
    public void setDocumentTypeService(IDocumentTypeService documentTypeService) {
        iDocumentTypeService = documentTypeService;
    }
}
