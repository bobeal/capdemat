package fr.cg95.cvq.service.request.job;

import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.mail.IMailService;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Test suite for {@link fr.cg95.cvq.service.request.job.DraftManagementJob }
 *
 * @author Victor Bartel (vba@zenexity.fr)
 */
public class DraftManagementJobTest extends ServiceTestCase {
    
    private IRequestService requestService;
    private Integer liveDuration;
    private Integer notificationBeforeDelete;
    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IMailService mailService;
    private IIndividualService individualService;
    private ConfigurableApplicationContext context;
    private DraftManagementJob draftManagementJob;
    
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        this.liveDuration = 2;
        this.notificationBeforeDelete = 4;
        this.context = getContext(getConfigLocations());
        this.requestService = (IRequestService) context.getBean("defaultRequestService");
        this.individualService = (IIndividualService) context.getBean("individualService");
        this.draftManagementJob = (DraftManagementJob) context.getBean("draftManagementJob");
        this.mailService = (IMailService) context.getBean("mailService");
        this.localAuthorityRegistry = 
            (ILocalAuthorityRegistry)context.getBean("localAuthorityRegistry");
        
    }
    
    public void testRequestDraftRemoval() {
        
    }
    
    public void testDraftMailSending() {
        
    }

    @Override
    protected void onTearDown() throws Exception {
        super.onTearDown();
    }
}
