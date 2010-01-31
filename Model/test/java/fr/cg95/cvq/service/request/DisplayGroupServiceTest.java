package fr.cg95.cvq.service.request;

import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;

public class DisplayGroupServiceTest extends RequestTestCase {

    @Override
    protected void onTearDown() throws Exception {
        for(DisplayGroup dg:iDisplayGroupService.getAll())
            iDisplayGroupService.delete(dg.getId());
        continueWithNewTransaction();
    }

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        for(DisplayGroup dg:iDisplayGroupService.getAll())
            iDisplayGroupService.delete(dg.getId());
        continueWithNewTransaction();
    }

    /* 
     * i18n error code:
     * - displayGroup.error.notProvided
     * - displayGroup.error.nameAlreadyExists
     * - displayGroup.error.labelAlreadyExists  
     */
    public void testCrud() throws CvqException {

        try {
            iDisplayGroupService.create(null);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals("displayGroup.error.notProvided", cme.getMessage());
        }

        DisplayGroup displayGroup = new DisplayGroup();
        displayGroup.setName("dg1");
        displayGroup.setLabel("d g 1");
        iDisplayGroupService.create(displayGroup);
        continueWithNewTransaction();

        assertEquals(1, iDisplayGroupService.getAll().size());

        continueWithNewTransaction();

        DisplayGroup dg = iDisplayGroupService.getById(displayGroup.getId());
        assertEquals(displayGroup.getId(), dg.getId());

        DisplayGroup displayGroup2 = new DisplayGroup();
        displayGroup2.setName("dg1");
        displayGroup2.setLabel("d g 2");

        try {
            iDisplayGroupService.create(displayGroup2);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals("displayGroup.error.nameAlreadyExists", cme.getMessage());
        }

        displayGroup2.setName("dg2");
        iDisplayGroupService.create(displayGroup2);
        assertEquals(2, iDisplayGroupService.getAll().size());

        continueWithNewTransaction();

        dg = iDisplayGroupService.getById(displayGroup.getId());
        dg.setLabel("d g 2");
        try {
            iDisplayGroupService.modify(dg);
            fail("should have thrown an exception");
        } catch (CvqModelException cme) {
            assertEquals("displayGroup.error.labelAlreadyExists", cme.getMessage());
        }

        dg.setLabel("d g 3");
        iDisplayGroupService.modify(dg);

        iDisplayGroupService.delete(displayGroup.getId());
        continueWithNewTransaction();
        assertEquals(1, iDisplayGroupService.getAll().size());
    }

    public void testRequestTypeAssociation() throws CvqException {

        DisplayGroup dg = new DisplayGroup();
        dg.setName("dg1");
        dg.setLabel("d g 1");
        iDisplayGroupService.create(dg);

        DisplayGroup dg2 = new DisplayGroup();
        dg2.setName("dg2");
        dg2.setLabel("d g 2");
        iDisplayGroupService.create(dg2);

        RequestType voRt = null;
        RequestType hfmRt = null;

        for (RequestType rt : iRequestTypeService.getAllRequestTypes()) {
            if ("Home Folder Modification".equals(rt.getLabel()))
                hfmRt = rt;
            if ("VO Card".equals(rt.getLabel()))
                voRt = rt;
        }

        continueWithNewTransaction();

        iDisplayGroupService.addRequestType(dg.getId(), voRt.getId());
        iDisplayGroupService.addRequestType(dg.getId(), hfmRt.getId());

        continueWithNewTransaction();

        dg = iDisplayGroupService.getById(dg.getId());
        assertEquals(2, dg.getRequestTypes().size());

        continueWithNewTransaction();

        iDisplayGroupService.addRequestType(dg2.getId(), hfmRt.getId());

        continueWithNewTransaction();

        dg = iDisplayGroupService.getById(dg.getId());
        assertEquals(1, dg.getRequestTypes().size());

        dg2 = iDisplayGroupService.getById(dg2.getId());
        assertEquals(1, dg2.getRequestTypes().size());
    }
}
