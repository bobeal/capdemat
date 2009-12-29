package fr.cg95.cvq.service.request;

import java.util.Calendar;
import java.util.Map;
import java.util.Date;

import junit.framework.Assert;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;

public class RequestStatisticsServiceTest extends RequestTestCase {

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority localAuthority = SecurityContext.getCurrentSite();
        localAuthority.setInstructionAlertsEnabled(true);
        continueWithNewTransaction();
    }
    
    @Override
    public void onTearDown() throws Exception {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        LocalAuthority localAuthority = SecurityContext.getCurrentSite();
        localAuthority.setInstructionAlertsEnabled(false);
        continueWithNewTransaction();
        
        super.onTearDown();
    }
    
    public void testRequestStatistic() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MINUTE, -10);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MINUTE, 1);

        Map<RequestState, Long> stateStats =
            iRequestStatisticsService.getStateStats(startDate.getTime(), endDate.getTime(),
                requestTypeService.getRequestTypeByLabel(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST).getId(),
                null);
        Long initialCancelledNb = stateStats.get(RequestState.CANCELLED);
        Long initialCompleteNb = stateStats.get(RequestState.COMPLETE);
        Long initialPendingNb = stateStats.get(RequestState.PENDING);

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        CreationBean cb = gimmeAnHomeFolderWithRequest();
        Request request = requestSearchService.getById(cb.getRequestId());

        Long requestTypeId = request.getRequestType().getId();
        Long categoryId = request.getRequestType().getCategory().getId();

        requestWorkflowService.updateRequestState(request.getId(), RequestState.COMPLETE, null);
        requestWorkflowService.updateRequestState(request.getId(), RequestState.CANCELLED, null);

        continueWithNewTransaction();
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Map<String, Long> qualityStats = null;
        try {
            qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                    endDate.getTime(), requestTypeId, categoryId);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                endDate.getTime(), requestTypeId, categoryId);
        assertEquals(Long.valueOf(1), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(Long.valueOf(0),
            qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(Long.valueOf(0), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_RED));

        qualityStats = iRequestStatisticsService.getQualityStats(startDate.getTime(),
                endDate.getTime(), requestTypeId, null);
        assertEquals(Long.valueOf(1), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(Long.valueOf(0),
            qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(Long.valueOf(0), qualityStats.get(IRequestStatisticsService.QUALITY_TYPE_RED));

        Map<Long, Map<String, Long>> qualityByTypeMap =
            iRequestStatisticsService.getQualityStatsByType(startDate.getTime(), endDate.getTime(),
            null, null);
        assertNotNull(qualityByTypeMap.get(request.getRequestType().getId()));
        Map<String,Long> qualityForVocr = qualityByTypeMap.get(request.getRequestType().getId());
        assertEquals(Long.valueOf(1),
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_OK));
        assertEquals(null,
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_ORANGE));
        assertEquals(null,
            qualityForVocr.get(IRequestStatisticsService.QUALITY_TYPE_RED));
        
        // By resultingState
        stateStats =
            iRequestStatisticsService.getStateStats(startDate.getTime(), endDate.getTime(),
                requestTypeId, null);
        Assert.assertEquals(Long.valueOf(initialCancelledNb + 1), stateStats.get(RequestState.CANCELLED));
        Assert.assertEquals(Long.valueOf(initialCompleteNb), stateStats.get(RequestState.COMPLETE));
        Assert.assertEquals(Long.valueOf(initialPendingNb), stateStats.get(RequestState.PENDING));

        // By type
        Map<Long, Long> typeStats =
            iRequestStatisticsService.getTypeStats(startDate.getTime(), endDate.getTime(),
            requestTypeId, null);
        Assert.assertEquals(1, typeStats.size());

        startDate.add(Calendar.DAY_OF_YEAR, -10);
        Map<Date, Long> periodStats =
            iRequestStatisticsService.getTypeStatsByPeriod(startDate.getTime(),
            endDate.getTime(), requestTypeId, null);
        Assert.assertNotNull(periodStats);
    }
}
