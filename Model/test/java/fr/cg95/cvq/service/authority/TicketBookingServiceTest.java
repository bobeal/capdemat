package fr.cg95.cvq.service.authority;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.request.ticket.Entertainment;
import fr.cg95.cvq.business.request.ticket.Event;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.ITicketBookingService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

public class TicketBookingServiceTest extends ServiceTestCase {

    @Autowired
    protected ITicketBookingService ticketBookingService;
    
    @Override
    public void onTearDown() throws Exception {
        for(Entertainment et : ticketBookingService.getAllEntertainments())
            ticketBookingService.deleteEntertainment(et.getId());
        continueWithNewTransaction();
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();
        for(Entertainment et : ticketBookingService.getAllEntertainments())
            ticketBookingService.deleteEntertainment(et.getId());
        continueWithNewTransaction();
    }

    @Test
    public void testCrud()throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Entertainment et = new Entertainment();
        et.setName("Zenexity show");
        et.setCategory("Comique");
        ticketBookingService.createEntertainment(et);
        et = new Entertainment();
        et.setName("CapDemat show");
        et.setCategory("Fiction");
        ticketBookingService.createEntertainment(et);
        assertEquals(2, ticketBookingService.getAllEntertainments().size());
        
        continueWithNewTransaction();
        
        ticketBookingService.deleteEntertainment(et.getId());
        assertEquals(1, ticketBookingService.getAllEntertainments().size());
        
        continueWithNewTransaction();
        
        et = ticketBookingService.getAllEntertainments().get(0);
        et.setName("Super Zeneexity Show");
        ticketBookingService.updateEntertainment(et);
        assertNotSame("Zenexity show", et.getName());
    }

    @Test
    public void testPaginateEvents() throws CvqException {
       SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
       CreationBean cb = gimmeAnHomeFolder();
       SecurityContext.setCurrentEcitizen(cb.getLogin());
       
       Entertainment et = new Entertainment();
       et.setName("Zenexity show");
       et.setCategory("Comique");
       
       Event ev;
       int hourOffset = 0;
       for (int i = 0; i < 10; i++) {
           ev = new Event();
           ev.setDate(new DateTime().plusHours(hourOffset).toDate());
           ev.setPlace("Salle de reunion " + hourOffset);
           ev.setEntertainment(et);
           et.getEvents().add(ev);
           hourOffset += 2;
       }
       ticketBookingService.createEntertainment(et);
       
       et = new Entertainment();
       et.setName("CapDemat show");
       et.setCategory("Fiction");
       hourOffset = 0;
       for (int i = 0; i < 10; i++) {
           ev = new Event();
           ev.setDate(new DateTime().plusHours(hourOffset).toDate());
           ev.setPlace("Salle de conference " + hourOffset);
           ev.setEntertainment(et);
           et.getEvents().add(ev);
           hourOffset ++;
       }
       ticketBookingService.createEntertainment(et);
       continueWithNewTransaction();
       
       assertEquals(20, ticketBookingService.getEvents(new HashSet<Critere>(), null, null, -1, 0).size());
       assertEquals(10, ticketBookingService.getEvents(new HashSet<Critere>(), null, null, 10, 0).size());

       List<Event> sortedEvents = ticketBookingService.getEvents(
               new HashSet<Critere>(), Entertainment.SEARCH_BY_NAME, null, -1, 0);
       assertEquals(20, sortedEvents.size());
       assertEquals("CapDemat show", sortedEvents.get(0).getEntertainment().getName());
       assertTrue("0 must be little than 10", 
               sortedEvents.get(0).getEntertainment().getName().compareTo(
                       sortedEvents.get(10).getEntertainment().getName()) < 0);
       
       sortedEvents = ticketBookingService.getEvents(
               new HashSet<Critere>(), Event.SEARCH_BY_DATE, null, -1, 0);
       assertTrue("0 must be little than 1", 
               sortedEvents.get(0).getDate().compareTo(sortedEvents.get(1).getDate()) < 0);
   }
}
