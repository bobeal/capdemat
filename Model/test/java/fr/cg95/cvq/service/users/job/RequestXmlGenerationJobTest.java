package fr.cg95.cvq.service.users.job;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;

import fr.cg95.cvq.business.external.ExternalServiceTrace;
import fr.cg95.cvq.business.external.TraceStatusEnum;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.IExternalProviderService;
import fr.cg95.cvq.external.IExternalService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.job.RequestXmlGenerationJob;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class RequestXmlGenerationJobTest extends ServiceTestCase {
    private IRequestService                requestService;
    private IExternalService           externalService;
    private RequestXmlGenerationJob        generationJob;
    private ConfigurableApplicationContext context;
    private CreationBean                   creationBean;
    private ILocalAuthorityRegistry        localAuthorityRegistry;
    private IExternalProviderService fakeExternalService;

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        this.context = getContext(getConfigLocations());
        this.requestService = (IRequestService) context.getBean("defaultRequestService");
        this.externalService = 
            (IExternalService) context.getBean("externalService");
        this.generationJob = (RequestXmlGenerationJob) context.getBean("requestXmlGenerationJob");
        this.localAuthorityRegistry = 
            (ILocalAuthorityRegistry) context.getBean("localAuthorityRegistry");
        fakeExternalService = (IExternalProviderService) getBean("fakeExternalService");

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);

        ExternalServiceBean esb = new ExternalServiceBean();
        esb.setGenerateTracedRequest(true);
        List<String> requestTypes = new ArrayList<String>();
        requestTypes.add(IRequestService.VO_CARD_REGISTRATION_REQUEST);
        esb.setRequestTypes(requestTypes);
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        lacb.registerExternalService(fakeExternalService, esb);
    }
    
    public void testXmlDataGeneration() throws Exception {
        try {
            Long id1, id2, id3;
            this.createDummyEntities();
            this.validateRequest();
            id1 = this.creationBean.getRequestId();
            this.createDummyEntities();
            this.validateRequest();
            id2 = this.creationBean.getRequestId();
            this.createDummyEntities();
            this.validateRequest();
            id3 = this.creationBean.getRequestId();
            SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
            
            this.externalService.addTrace(new ExternalServiceTrace(null, null, id1,null, null, 
                    "MyName",TraceStatusEnum.SENT));
            this.externalService.addTrace(new ExternalServiceTrace(null, null, id2, null, null, 
                    "MyName", TraceStatusEnum.ACKNOWLEDGED));
            this.continueWithNewTransaction();
            
            this.generationJob.launchJob();
            this.remakeSecurityContext();
            
            File file = this.localAuthorityRegistry.getRequestXmlResource(id3);
            assertTrue(file.exists());
            file = this.localAuthorityRegistry.getRequestXmlResource(id1);
            assertTrue(file.exists());
            file = this.localAuthorityRegistry.getRequestXmlResource(id2);
            assertFalse(file.exists());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void testXmlDataErasing() throws Exception {
        try {
            this.createDummyEntities();
            this.validateRequest();
            
            SecurityContext.setCurrentContext(SecurityContext.ADMIN_CONTEXT);
            this.generationJob.performGeneration(localAuthorityName);
            
            File file = this.localAuthorityRegistry.getRequestXmlResource(creationBean.getRequestId());
            assertTrue(file.exists());
            
            ExternalServiceTrace trace = new ExternalServiceTrace();
            trace.setKey(this.creationBean.getRequestId());
            trace.setKeyOwner("capdemat");
            trace.setName("MyName");
            trace.setStatus(TraceStatusEnum.ACKNOWLEDGED);
            this.externalService.addTrace(trace);
            
            this.generationJob.eraseAcknowledgedRequests(localAuthorityName);
            assertFalse(file.exists());
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    protected String getXmlOutputFolder() {
        return String.format("%1$s/%2$s/%3$s/", 
                this.localAuthorityRegistry.getAssetsBase(),
                this.localAuthorityRegistry.getCurrentLocalAuthorityName(),
                ILocalAuthorityRegistry.REQUEST_XML_RESOURCE_TYPE);
    }
    
    protected void createDummyEntities() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.ADMIN_CONTEXT);
        this.creationBean = this.gimmeAnHomeFolder();
        this.continueWithNewTransaction();
    }
    
    protected void validateRequest() throws CvqInvalidTransitionException, CvqException {
        SecurityContext.setCurrentSite(localAuthorityName,SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestService.complete(creationBean.getRequestId());
        requestService.validate(creationBean.getRequestId());
        this.continueWithNewTransaction();
    }
    
    protected void onTearDown() throws Exception {
        this.externalService.deleteTraces("MyName");
        this.eraseTestFiles();
        super.onTearDown();
    }
    
    protected void remakeSecurityContext() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
    }
    
    protected void eraseTestFiles() {
        File dir = new File(this.getXmlOutputFolder());
        List<File> files = new ArrayList<File>();
        
        files = Arrays.asList(dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (new File(dir, name).isDirectory()) {
                    return false;
                }
                name = name.toLowerCase();
                return name.endsWith(".xml");
            }
        }));
        
        for (File file : files) {
            file.delete();
        }
    }
}
