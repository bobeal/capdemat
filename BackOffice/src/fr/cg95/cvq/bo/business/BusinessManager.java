/*
 * Cartevaloise
 *
 * Copyright (C) 2004, 2005 Conseil Gï¿œnï¿œral du Val d'Oise. All Rights
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
package fr.cg95.cvq.bo.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.w3c.dom.Node;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.form.AdminForm;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.record.AccountRecord;
import fr.cg95.cvq.bo.record.CategoryRecord;
import fr.cg95.cvq.bo.record.DocumentTypeRecord;
import fr.cg95.cvq.bo.record.FamilyRecord;
import fr.cg95.cvq.bo.record.HistoryRecord;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.LetterTypeRecord;
import fr.cg95.cvq.bo.record.MeansOfContactRecord;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.PaymentRecord;
import fr.cg95.cvq.bo.record.ReferentialDataRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.bo.record.SeasonRecord;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentState;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestNoteType;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.CardState;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.users.payment.PaymentState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.ILocalReferentialService;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.importer.ICsvParserService;
import fr.cg95.cvq.service.request.IMeansOfContactService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.request.IRequestStatisticsService;
import fr.cg95.cvq.service.users.ICardService;
import fr.cg95.cvq.service.users.ICertificateService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.sms.ISmsService;
import fr.cg95.cvq.wizard.ReferentialData;

/**
 * @author René le CLERCQ
 */
public class BusinessManager implements IBusinessConstants {

    static Logger logger = Logger.getLogger(BusinessManager.class);

    private static WebApplicationContext ac = null;

    private BusinessManager() {
        super();
    }

    public static void setApplicationContext(WebApplicationContext wac) {
        ac = wac;

    }

    // util

    public static IRequestService getDefaultRequestService() {
        return ((IRequestServiceRegistry) ac.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getDefaultRequestService();
    }

    public static IRequestService getRequestService(Long id) throws CvqObjectNotFoundException, CvqException {
        return ((IRequestServiceRegistry) ac.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getRequestService(getDefaultRequestService().getById(id));
    }

    public static IRequestService getRequestService(String label) throws CvqObjectNotFoundException, CvqException {
        return ((IRequestServiceRegistry) ac.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getRequestService(label);
    }

    public static ICsvParserService getCsvParserService() {
        return (ICsvParserService) ac.getBean(ICsvParserService.SERVICE_NAME);
    }
    
    public static Map getNbAgentsTasks(String agentLogin) {
        if (ac != null) {
            IAgentService service = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);

            try {
                return service.getAgentTasks(agentLogin);

            } catch (CvqException ce) {
                logger.error("findNbAgentsTasks", ce);
            }
        }
        return null;
    }

    public static Long findNbRequestsByState(RequestManager requestManager, String state, SearchForm filterForm) {
        if (ac != null) {
            IRequestStatisticsService statisticsService = (IRequestStatisticsService) ac
                    .getBean(IRequestStatisticsService.SERVICE_NAME);

//            try {
//                String filterState = filterForm.getState();
//
//                if ((filterState == null) || (filterState.length() == 0) || filterState.equals("Indifférent")
//                        || filterState.equals(state)) {
//
//                    if ((state != null) && (state.length() > 0))
//                        state = BusinessDictionary.getRequestState(state).toString();
//                    
//                    String type = filterForm.getType();
//
//                    if ((type != null) && (type.length() > 0) && !type.equals("Indifférent")) 
//                        type = requestManager.getRequestTypeLabel(type);
//                    else
//                        type = null;
//                    
//                    return statisticsService.getCountByResultingState(
//                            state,
//                            Utils.getStringAsDate(filterForm.getPeriodBegin()),
//                            Utils.getStringAsDate(filterForm.getPeriodEnd()),
//                            type,
//                            filterForm.getService());
//                }
//
//            } catch (CvqException ce) {
//                logger.warn("findNbRequestsByState", ce);
//            }
        }
        return new Long(0);
    }

    public static Long findNbRequestsByType(RequestManager requestManager, String type, SearchForm filterForm) {
        if (ac != null) {
            IRequestStatisticsService statisticsService = (IRequestStatisticsService) ac
                    .getBean(IRequestStatisticsService.SERVICE_NAME);

//            try {
//                String requestType = filterForm.getType();
//
//                if ((requestType == null) || (requestType.length() == 0) || requestType.equals("Indifférent")
//                        || requestType.equals(type)) {
//
//                    if ((type != null) && (type.length() > 0))
//                        type = requestManager.getRequestTypeLabel(type);
//                    
//                    String state = filterForm.getState();
//
//                    if ((state != null) && (state.length() > 0) && !state.equals("Indifférent")) 
//                        state = BusinessDictionary.getRequestState(state).toString();
//                    else
//                        state = null;
//                    
//                    return statisticsService.getCountByResultingState(
//                            state,
//                            Utils.getStringAsDate(filterForm.getPeriodBegin()),
//                            Utils.getStringAsDate(filterForm.getPeriodEnd()),
//                            type,
//                            filterForm.getService());
//                }
//            } catch (CvqException ce) {
//                logger.warn("findNbRequestsByType", ce);
//            }
        }
        return new Long(0);
    }

    public static Long findNbRequestsByMonth(RequestManager requestManager, Calendar month, String state, SearchForm filterForm) {
        if (ac != null) {
            IRequestStatisticsService statisticsService = (IRequestStatisticsService) ac
                    .getBean(IRequestStatisticsService.SERVICE_NAME);

            try {
                Calendar cal = Calendar.getInstance();
                cal.set(month.get(Calendar.YEAR), month.get(Calendar.MONTH), 1);
                
                Date dateBegin = cal.getTime();
                cal.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
                Date dateEnd = cal.getTime();
            
                if (state == null) {
                    // Take creation date, save filter parameters and restore afterwards
                    String periodBegin = filterForm.getPeriodBegin();
                    String periodEnd = filterForm.getPeriodEnd();
                    String filterState = filterForm.getState();
                    
                    filterForm.setPeriodBegin(Utils.getDateAsString(dateBegin));
                    filterForm.setPeriodEnd(Utils.getDateAsString(dateEnd));
                    filterForm.setState(null);
                    
                    Long count = statisticsService.getCount(getCriteria(requestManager, filterForm, true));
                    
                    filterForm.setPeriodBegin(periodBegin);
                    filterForm.setPeriodEnd(periodEnd);
                    filterForm.setState(filterState);
                    
                    return count;
                    
                } else { // Use resulting state in request action
                    String type = filterForm.getType();
                    if ((type != null) && (type.length() > 0))
                        type = requestManager.getRequestTypeLabel(type);
                    
                    if ((state != null) && (state.length() > 0) && !state.equals("Indifférent")) 
                        state = BusinessDictionary.getRequestState(state).toString();
                    else
                        state = null;
                    
//                    return statisticsService.getCountByResultingState(
//                            state,
//                            dateBegin,
//                            dateEnd,
//                            type,
//                            filterForm.getService());
                }
            } catch (CvqException ce) {
                logger.warn("findNbRequestsByMonth", ce);
            }
        }
        return new Long(0);
    }
    
    public static Long findNbRequestsByQuality(RequestManager requestManager, String qualityType, SearchForm filterForm) {

        if (ac != null) {
            IRequestStatisticsService statisticsService = (IRequestStatisticsService) ac
                    .getBean(IRequestStatisticsService.SERVICE_NAME);

            String requestTypeLabel = requestManager.getRequestTypeLabel(filterForm.getType());
            if (requestTypeLabel.equals("Pas disponible"))
            		requestTypeLabel = "";
//            try {
//				return statisticsService.getCountByQuality(Utils.getStringAsDate(filterForm.getPeriodBegin()), 
//						Utils.getStringAsDate(filterForm.getPeriodEnd()), qualityType,
//						requestTypeLabel, filterForm.getService());
//				
//			} catch (CvqException e) {
//				logger.warn("findNbRequestsByQuality", e);
//				e.printStackTrace();
//			}
            return null;
        }

		return new Long(0);
	}

    public static RequestRecord findRequestById(RequestManager requestManager, Long id) {
        if (ac != null) {
            IRequestService requestService = getDefaultRequestService();

            try {
                return BusinessFactory.loadRequestRecord(requestManager, requestService.getById(id));

            } catch (CvqException ce) {
                logger.error("findAllRequests", ce);
            }
        }
        return null;
    }

    public static RequestRecord getRequestRecord(RequestManager requestManager, RequestRecord record) {
        if (ac != null) {
            IRequestService requestService = getDefaultRequestService();

            try {
                logger.debug("Start loading from DB");
                return BusinessFactory.getRequestRecord(requestManager, record, requestService.getById(record.getId()));

            } catch (CvqException ce) {
                logger.error("findAllRequests", ce);
            }
        }
        return null;
    }

    public static void getRequestRecords(RequestManager requestManager, HashMap<Long, IResultRecord> records) {
        if (ac != null) {
            IRequestService requestService = getDefaultRequestService();

            try {
                Long [] ids = new Long[(int)(records.size())];
                int i = 0;
                for (Long id : records.keySet()) {
                    ids[i++] = id;
                }
                Set demands = requestService.getByIds(ids);

                Iterator iter = demands.iterator();
                while (iter.hasNext()) {
                    Request demand = (Request)iter.next();
                    RequestRecord record = 
                        BusinessFactory.getRequestRecord(requestManager, 
                                (RequestRecord)records.get(demand.getId()), demand);
                    record.setLoaded();
                }

            } catch (CvqException ce) {
                logger.error("getRequestRecords", ce);
            }
        }
    }

    public static ArrayList findStateTransitionRequests(RequestManager requestManager, String state) {
        if (ac != null) {
            SearchForm searchForm = new SearchForm();
            ArrayList result = new ArrayList();
            Iterator iter = getRequestStates(state).iterator();
            while (iter.hasNext()) {
                searchForm.setState((String) iter.next());
                result.addAll(findRequests(requestManager, searchForm, null));
            }

            return result;
        }
        return null;
    }

    public static ArrayList findRequests(RequestManager requestManager, SearchForm searchForm, String orderBy) {
        if (ac != null) {
            IRequestService requestService = getDefaultRequestService();
            ArrayList results = new ArrayList();

            try {
                Set set = requestService.get(getCriteria(requestManager, searchForm, true), 
                                                getRequestOrderBy(orderBy), true);
                if (set != null && set.size() > 0) {
                    Iterator iter = set.iterator();

                while (iter.hasNext())
                    results.add(0, new RequestRecord(requestManager, (Long) iter.next()));
                }
            } catch (CvqException ce) {
                logger.warn("findRequests", ce);
            }
            return results;
        }
        return null;
    }

    private static Set getCriteria(RequestManager requestManager, SearchForm searchForm, boolean noArchives) {
        Date date = null;
        HashSet criteria = new HashSet();

        if ((searchForm.getFamilyId() != null) && (searchForm.getFamilyId().longValue() > 0)) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(String.valueOf(searchForm.getFamilyId()));
            criteria.add(crit);
        }
        if ((searchForm.getDemandId() != null) && (searchForm.getDemandId().longValue() > 0)) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_REQUEST_ID);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(String.valueOf(searchForm.getDemandId()));
            criteria.add(crit);
        }
        if (searchForm.getPeriodBegin() != null) {
            date = Utils.getStringAsDate(searchForm.getPeriodBegin());
            if (date != null) {
                Critere crit = new Critere();
                if (searchForm.getDataType() == SearchForm.CREATION_DATE)
                    crit.setAttribut(Request.SEARCH_BY_CREATION_DATE);
                else
                    crit.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
                    
                crit.setComparatif(Critere.GTE);
                crit.setValue(date);
                criteria.add(crit);
            }
        }
        if (searchForm.getPeriodEnd() != null) {
            date = Utils.getStringAsDate(searchForm.getPeriodEnd());
            if (date != null) {
                Critere crit = new Critere();
                if (searchForm.getDataType() == SearchForm.CREATION_DATE)
                    crit.setAttribut(Request.SEARCH_BY_CREATION_DATE);
                else
                    crit.setAttribut(Request.SEARCH_BY_MODIFICATION_DATE);
                crit.setComparatif(Critere.LTE);
                crit.setValue(date);
                criteria.add(crit);
            }
        }
        if ((searchForm.getLastName() != null) && searchForm.getLastName().length() > 0) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
            crit.setComparatif(Critere.STARTSWITH);
            crit.setValue(searchForm.getLastName());
            criteria.add(crit);
        }
        if ((searchForm.getFirstName() != null) && (searchForm.getFirstName().length() > 0)) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_REQUESTER_FIRSTNAME);
            crit.setComparatif(Critere.STARTSWITH);
            crit.setValue(searchForm.getFirstName());
            criteria.add(crit);
        }
        String service = searchForm.getService();

        if ((service != null) && (service.length() > 0) && !service.equals("Indifférent")) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_CATEGORY_NAME);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(service);
            criteria.add(crit);
        }

        String type = searchForm.getType();

        if ((type != null) && (type.length() > 0) && !type.equals("Indifférent")) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_REQUEST_TYPE_LABEL);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(String.valueOf(requestManager.getRequestTypeLabel(type)));
            criteria.add(crit);
        }
        String state = searchForm.getState();

        if ((state != null) && (state.length() > 0) && !state.equals("Indifférent")) {
            Critere crit = new Critere();
            if (searchForm.getDataType() == SearchForm.CREATION_DATE)
                crit.setAttribut(Request.SEARCH_BY_STATE);
            else
                crit.setAttribut(Request.SEARCH_BY_RESULTING_STATE);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(BusinessDictionary.getRequestState(state).toString());
            criteria.add(crit);
        } else if (noArchives){
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_STATE);
            crit.setComparatif(Critere.NEQUALS);
            crit.setValue(RequestState.ARCHIVED);
            criteria.add(crit);
        }
        if (searchForm.getLastAgentId() != null) {
            Critere crit = new Critere();
            crit.setAttribut(Request.SEARCH_BY_LAST_INTERVENING_AGENT_ID);
            crit.setComparatif(Critere.EQUALS);
            crit.setValue(searchForm.getLastAgentId());
            criteria.add(crit);
        }
        return criteria;
    }
    
    public static String getRequestOrderBy(String orderBy) {
        if ( orderBy != null) {
            if (orderBy.equals("id"))
                return Request.SEARCH_BY_REQUEST_ID;
            
            if (orderBy.equals("date"))
                return Request.SEARCH_BY_CREATION_DATE;
            
            if (orderBy.equals("type"))
              return Request.SEARCH_BY_REQUEST_TYPE_LABEL;
          
            if (orderBy.equals("typeLabel"))
//              return Request.SEARCH_BY_REQUEST_TYPE_LABEL;
              return null;
          
            if (orderBy.equals("demanderName"))
                return Request.SEARCH_BY_REQUESTER_LASTNAME;
            
            if (orderBy.equals("familyId"))
                return Request.SEARCH_BY_HOME_FOLDER_ID;
            
            if (orderBy.equals("state"))
//                return Request.SEARCH_BY_STATE;
                return null;
            
            if (orderBy.equals("modificationDate"))
                return null;
            
            if (orderBy.equals("lastAgent"))
                return null;
        }

        return null;
    }

    public static Collection getRequestStates(String state) {
        if (ac != null) {
            IRequestService requestService = getDefaultRequestService();

            RequestState requestState = BusinessDictionary.getRequestState(state);

            RequestState states[] = requestService.getPossibleTransitions(requestState);

            ArrayList requestStates = new ArrayList();
            for (int i = 0; i < states.length; i++) {
                requestStates.add(BusinessDictionary.getRequestState(states[i]));
            }
            Collections.sort(requestStates);

            return requestStates;

        }
        
        return null;
    }

    public static void setRequestState(RequestRecord record, String state, String motif) throws Exception {
        if (ac != null) {
            try {
                IRequestService requestService = getRequestService(record.getId());

                RequestState requestState = BusinessDictionary.getRequestState(state);

                if (requestState.equals(RequestState.ARCHIVED))
                    requestService.archive(record.getId());

                else if (requestState.equals(RequestState.CANCELLED))
                    requestService.cancel(record.getId());

                else if (requestState.equals(RequestState.CLOSED))
                    requestService.close(record.getId());

                else if (requestState.equals(RequestState.COMPLETE))
                    requestService.complete(record.getId());

                else if (requestState.equals(RequestState.UNCOMPLETE))
                    requestService.specify(record.getId(), motif);

                else if (requestState.equals(RequestState.REJECTED))
                    requestService.reject(record.getId(), motif);

                else if (requestState.equals(RequestState.VALIDATED))
                    requestService.validate(record.getId());

                else if (requestState.equals(RequestState.NOTIFIED))
                    requestService.notify(record.getId(), motif);

                // Step information may have been changed update record with demand value from DB
                Request demand = requestService.getById(record.getId());
                record.setStep(demand.getStep().toString());

                requestService.addNote(record.getId(), RequestNoteType.INSTRUCTION_INTERNAL, record
                        .getInstructionInternal());
                requestService.addNote(record.getId(), RequestNoteType.INSTRUCTION_EXTERNAL, record
                        .getInstructionExternal());
                requestService.addNote(record.getId(), RequestNoteType.DELIVERY_INTERNAL, record
                        .getDeliveryInternal());
                requestService.addNote(record.getId(), RequestNoteType.DELIVERY_EXTERNAL, record
                        .getDeliveryExternal());

            } catch (CvqInvalidTransitionException e) {
                logger.error("setRequestState", e);
                throw e;
            } catch (CvqException e) {
                logger.error("setRequestState", e);
                throw e;
            }
        }
    }

    public static void setDataState(RequestRecord record, String state, String motif) {
        if (ac != null) {
            try {
                IRequestService requestService = getRequestService(record.getId());

                Request demand = requestService.getById(record.getId());

                demand.setDataState(BusinessDictionary.getDataState(state));

                requestService.modify(demand);

            } catch (CvqInvalidTransitionException e) {
                logger.error("setDataState", e);
            } catch (CvqException e) {
                logger.error("setDataState", e);
            }
        }
    }

    public static List<MeansOfContactRecord> getMeansOfContact() {
        if (ac != null) {
            try {
                IMeansOfContactService service = (IMeansOfContactService) ac
                        .getBean(IMeansOfContactService.SERVICE_NAME);

                ArrayList<MeansOfContactRecord> meansOfContact = new ArrayList<MeansOfContactRecord>();

                List<MeansOfContact> availableMeansOfContact = service.getAvailableMeansOfContact();
                
                for (MeansOfContact means : availableMeansOfContact) {
                    meansOfContact.add(BusinessFactory.getMeansOfContactRecord(means));
                }
                return meansOfContact;

            } catch (CvqException ce) {
                logger.error("getMeansOfContact", ce);
            }
        }
        return null;
    }

    public static void saveMeansOfContact(List<MeansOfContactRecord> meansOfContact) throws CvqException {
        if (ac != null) {
            IMeansOfContactService service = (IMeansOfContactService) ac
                .getBean(IMeansOfContactService.SERVICE_NAME);

            for (MeansOfContactRecord record : meansOfContact) {
                MeansOfContact means = service.getMeansOfContactByType(record.getType());
                if (record.isEnabled())
                    service.enableMeansOfContact(means);
                else
                    service.disableMeansOfContact(means);
            }
        }
    }

    public static void saveRequestTypes(List requestTypes) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();

            for (int i = 0; i < requestTypes.size(); i++) {
                RequestTypeRecord record = (RequestTypeRecord)requestTypes.get(i);

                RequestType requestType = service.getRequestTypeById(record.getId());

                requestType.setActive(new Boolean(record.isActivated()));
                service.modifyRequestType(requestType);
            }
        }
    }

    public static void saveRequestType(RequestTypeRecord record) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();

            RequestType requestType = service.getRequestTypeById(record.getId());

            requestType.setActive(new Boolean(record.isActivated()));
            service.modifyRequestType(requestType);
        }
    }

    public static Set getRequirements(Long requestTypeId) {
        if (ac != null) {
            try {
                IRequestService requestService = getDefaultRequestService();

                RequestType requestType = requestService.getRequestTypeById(requestTypeId);

                return requestType.getRequirements();

            } catch (CvqInvalidTransitionException e) {
                logger.error("getRequirements", e);
            } catch (CvqException e) {
                logger.error("getRequirements", e);
            }
        }
        return null;
    }

    public static void saveRequirements(RequestTypeRecord requestTypeRecord, List documents) throws CvqException {
        if (ac != null) {
            IDocumentService documentService = (IDocumentService) ac.getBean(IDocumentService.SERVICE_NAME);
            IRequestService service = getDefaultRequestService();
            RequestType requestType = service.getRequestTypeById(requestTypeRecord.getId());

            HashSet requirements = new HashSet();
            for (int i = 0; i < documents.size(); i++) {
                DocumentTypeRecord record = (DocumentTypeRecord)documents.get(i);
                if (record.isUsed()) {
                    DocumentType documentType = documentService.getDocumentTypeById(record.getType());

                    Requirement requirement = new Requirement();
                    requirement.setRequestType(requestType);
                    requirement.setDocumentType(documentType);
                    requirement.setMultiplicity(new Integer(1));

                    requirements.add(requirement);
                }
            }
            service.modifyRequestTypeRequirements(requestType, requirements);
        }
    }

    public static Collection getDocumentStates(String state) {
        if (ac != null) {
            try {
                ArrayList documentStates = new ArrayList();
                if (state.equals(IBusinessConstants.STATE_CERTIFIED)) {
                    documentStates.add(IBusinessConstants.STATE_OUTDATED);
                    
                } else {
                    IDocumentService documentService = (IDocumentService) ac
                            .getBean(IDocumentService.SERVICE_NAME);
    
                    DocumentState documentState = BusinessDictionary.getDocumentState(state);
    
                    DocumentState states[] = documentService.getPossibleTransitions(documentState);
                    for (int i = 0; i < states.length; i++) {
                        documentStates.add(BusinessDictionary.getDocumentState(states[i]));
                    }
                }

                return documentStates;

            } catch (CvqException ce) {
                logger.error("getDocumentStates", ce);
            }
        }
        return null;
    }

    public static List<DocumentTypeRecord> getDocumentTypes() {
        if (ac != null) {
            try {
                IDocumentService documentService = (IDocumentService) ac
                        .getBean(IDocumentService.SERVICE_NAME);

                ArrayList<DocumentTypeRecord> documentTypes = new ArrayList<DocumentTypeRecord>();

                Iterator iter = documentService.getAllDocumentTypes().iterator();

                while (iter.hasNext()) {
                    documentTypes.add(BusinessFactory.getDocumentTypeRecord((DocumentType)iter.next()));
                }

                return documentTypes;

            } catch (CvqException ce) {
                logger.error("getDocumentTypes", ce);
            }
        }
        return null;
    }

    public static Date saveDocument(RequestRecord request, PaperRecord record, String state, Date validity,
            String motif) {
        Date valid = null;

        if (ac != null) {
            try {
                IDocumentService documentService = (IDocumentService) ac
                        .getBean(IDocumentService.SERVICE_NAME);

                Document document = null;
                if (record.getId() == null) {
                    document = new Document();
                    DocumentType documentType = documentService.getDocumentTypeById(record.getTypeId());
                    document.setDocumentType(documentType);

                    // create the "administrative" part of the document
                    Long personId = (request.getSubject() == null) ? null : request.getSubject().getId();
                    Long id = documentService.create(document, request.getFamilyId(), personId);
                    record.setId(id);
                    record.setPerson(request.getSubject());

                    // add the documents to the request
                    IRequestService requestService = getRequestService(request.getId());

                    Set documentSet = new HashSet();
                    documentSet.add(id);

                    requestService.addDocuments(request.getId(), documentSet);
                } else {
                    document = documentService.getById(record.getId());
                }

                DocumentState documentState = BusinessDictionary.getDocumentState(state);

                if (state.equals(IBusinessConstants.STATE_CERTIFIED)) {
                    if (!record.isCertified()) {
                        byte data[] = record.getCertifiedData();
                        if (data != null) {
                            DocumentBinary docBin = new DocumentBinary();
                            docBin.setData(data);
                            docBin.setPageNumber(new Integer(0));
                            documentService.addPage(record.getId(), docBin);
                            document.setCertified(new Boolean(true));
                            
                            record.setCertified(true);
                        }
                    }
                    
                } else if (documentState.equals(DocumentState.CHECKED))
                    documentService.check(record.getId(), motif);

                else if (documentState.equals(DocumentState.OUTDATED))
                    documentService.outDated(record.getId());

                else if (documentState.equals(DocumentState.REFUSED))
                    documentService.refuse(record.getId(), motif);

                else if (documentState.equals(DocumentState.VALIDATED)) {
                    documentService.validate(record.getId(), validity, motif);
                    valid = new Date();
                    document.setValidationDate(valid);
                }

                document.setEndValidityDate(validity);
                documentService.modify(document);

                // add the new pages to the document
                for (int i = 0; i < record.getNbPages(); i++) {
                    byte data[] = getFileData(record.getNewDocumentFile(i));
                    if (data != null) {
                        DocumentBinary docBin = new DocumentBinary();
                        docBin.setData(data);
                        docBin.setPageNumber(new Integer(i + 1));
                        documentService.addPage(record.getId(), docBin);
                        record.updateDataAction(i);
                    }
                }

            } catch (CvqObjectNotFoundException e) {
                logger.error("setDocumentState", e);
            } catch (CvqException e) {
                logger.error("setDocumentState", e);
            }
        }
        return valid;
    }
    
    public static void setScanDocumentData(boolean scanData) {
    }

    public static boolean scanDocumentData(String site) {
        if (ac != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)ac.getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            LocalAuthorityConfigurationBean localAuthority = registry.getLocalAuthorityBeanByName(site);
            return localAuthority.isDocumentDigitalizationEnabled().booleanValue();
        }       
        return true;
    }

    public static List getSeasonableRequestTypes() {
        if (ac != null) {
            IRequestServiceRegistry service = 
                ((IRequestServiceRegistry) ac.getBean(IRequestServiceRegistry.SERVICE_NAME));

            return service.getServicesSupportingSeasons();
        }
        return null;
    }
    
    public static List<SeasonRecord> getSeasons(Long requestTypeId) {
        if (ac != null) {
            try {
                IRequestService requestService = getDefaultRequestService();

                RequestType requestType = requestService.getRequestTypeById(requestTypeId);
                ArrayList<SeasonRecord> seasons = new ArrayList<SeasonRecord>();
                
                Iterator<RequestSeason> iter = requestType.getSeasons().iterator();
                while (iter.hasNext()) {
                    RequestSeason season = iter.next();
                    
                    SeasonRecord record = new SeasonRecord();
                    record .setUuid(season.getUuid());
                    record.setLabel(season.getLabel());
                    record.setStartDate(season.getEffectStart());
                    record.setEndDate(season.getEffectEnd());
                    record.setStartInscription(season.getRegistrationStart());
                    record.setEndInscription(season.getRegistrationEnd());
                    record.setValidationDate(season.getValidationAuthorizationStart());
                    
                    seasons.add(record);
                }
                return seasons;

            } catch (CvqException e) {
                logger.error("getSeasons", e);
            }
        }
        return null;
    }

    public static void saveSeason(Long requestTypeId, SeasonRecord record) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();
            RequestType requestType = service.getRequestTypeById(requestTypeId);

            RequestSeason requestSeason = new RequestSeason();
            requestSeason.setRequestType(requestType);

            requestSeason.setUuid(record.getUuid());
            requestSeason.setLabel(record.getLabel());
            requestSeason.setEffectStart(record.getStartDate());
            requestSeason.setEffectEnd(record.getEndDate());
            requestSeason.setRegistrationStart(record.getStartInscription());
            requestSeason.setRegistrationEnd(record.getEndInscription());
            requestSeason.setValidationAuthorizationStart(record.getValidationDate());

            if (requestSeason.getUuid() == null)
                service.createRequestTypeSeasons(requestType, requestSeason);
            else
                service.modifyRequestTypeSeasons(requestType, requestSeason);
        }
    }
    
    public static void deleteSeason(Long requestTypeId, SeasonRecord record) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();
            RequestType requestType = service.getRequestTypeById(requestTypeId);

            RequestSeason requestSeason = new RequestSeason();
            requestSeason.setRequestType(requestType);

            requestSeason.setUuid(record.getUuid());
            requestSeason.setLabel(record.getLabel());
            requestSeason.setEffectStart(record.getStartDate());
            requestSeason.setEffectEnd(record.getEndDate());
            requestSeason.setRegistrationStart(record.getStartInscription());
            requestSeason.setRegistrationEnd(record.getEndInscription());
            requestSeason.setValidationAuthorizationStart(record.getValidationDate());

            service.removeRequestTypeSeasons(requestType, requestSeason);
        }
    }
    
    public static void saveAlert(RequestTypeRecord record) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();

            RequestType requestType = service.getRequestTypeById(record.getId());

            requestType.setInstructionMaxDelay(record.getMaxDelay());
            requestType.setInstructionAlertDelay(record.getAlertDelay());

            service.modifyRequestType(requestType);
        }
    }

    public static void saveLetterType(Long requestTypeId, LetterTypeRecord letterType, byte[] data) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();

            if (letterType.getId() != null)
                service.modifyRequestTypeForm(
                        requestTypeId, 
                        letterType.getId(), 
                        letterType.getLabel(), 
                        letterType.getShortLabel(), 
                        letterType.getFilename(), 
                        data);
            else
                service.addRequestTypeForm(
                        requestTypeId, 
                        RequestFormType.REQUEST_MAIL_TEMPLATE, 
                        letterType.getLabel(), 
                        letterType.getShortLabel(), 
                        letterType.getFilename(), 
                        data);
        }
    }
    
    public static void deleteLetterType(Long requestTypeId, LetterTypeRecord letterType) throws CvqException {
        if (ac != null) {
            IRequestService service = getDefaultRequestService();

            service.removeRequestTypeForm(requestTypeId, letterType.getId());
        }
    }
    
    public static void printRequest(File pdf, Long id) {

        Request request;
        try {
            request = getDefaultRequestService().getById(id);
            ICertificateService service = (ICertificateService) ac.getBean(ICertificateService.SERVICE_NAME);

            byte[] data = service.generateRequestCertificate(request, null);

            if (data != null) {
                FileOutputStream fos = new FileOutputStream(pdf);
                fos.write(data);
                fos.close();
            }
        } catch (CvqObjectNotFoundException e) {
        } catch (CvqException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static byte[] generateXslFo(Node node, File xslFoFile) {
        try {
            ICertificateService service = (ICertificateService) ac.getBean(ICertificateService.SERVICE_NAME);
            byte[] data = service.generateRequestCertificate(node, xslFoFile);

            return data;
        } catch (CvqException e) {
            return null;
        }
    }
    
    private static byte[] getFileData(File file) {
        byte[] data = null;
        if (file != null) {
            int size = new Long(file.length()).intValue();

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);

                data = new byte[size];
                fis.read(data);

            } catch (FileNotFoundException fnfe) {
                fnfe.getMessage();
            } catch (IOException ioe) {
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                } catch (IOException e) {
                }
            }
        }
        return data;
    }

    public static ArrayList findIndividuals(SearchForm searchForm) {
        if (ac != null) {
            IIndividualService individualService = (IIndividualService) ac
                    .getBean(IIndividualService.SERVICE_NAME);
            ArrayList results = new ArrayList();

            try {
                HashSet criteria = new HashSet();

                if ((searchForm.getLastName() != null) && searchForm.getLastName().length() > 0) {
                    Critere crit = new Critere();
                    crit.setAttribut(Individual.SEARCH_BY_LASTNAME);
                    crit.setComparatif(Critere.STARTSWITH);
                    crit.setValue(searchForm.getLastName());
                    criteria.add(crit);
                }
                if ((searchForm.getFirstName() != null) && (searchForm.getFirstName().length() > 0)) {
                    Critere crit = new Critere();
                    crit.setAttribut(Individual.SEARCH_BY_FIRSTNAME);
                    crit.setComparatif(Critere.STARTSWITH);
                    crit.setValue(searchForm.getFirstName());
                    criteria.add(crit);
                }
                if (searchForm.getBirthDate() != null) {
                    Date date = Utils.getStringAsDate(searchForm.getBirthDate());
                    if (date != null) {
                        Critere crit = new Critere();
                        crit.setAttribut(Individual.SEARCH_BY_BIRTHDATE);
                        crit.setComparatif(Critere.EQUALS);
                        crit.setValue(date);
                        criteria.add(crit);
                    }
                }
                if ((searchForm.getFamilyId() != null) && (searchForm.getFamilyId().longValue() > 0)) {
                    Critere crit = new Critere();
                    crit.setAttribut(Individual.SEARCH_BY_HOME_FOLDER_ID);
                    crit.setComparatif(Critere.EQUALS);
                    crit.setValue(String.valueOf(searchForm.getFamilyId()));
                    criteria.add(crit);
                }

                boolean archivedAccounts = false;
                String cardState = null;
                if ((searchForm.getSearch() != null) && searchForm.getSearch().equals("card"))
                    cardState = searchForm.getState();
                else {
                    String state = searchForm.getState();

                    if ((state != null) && (state.length() > 0) && !state.equals("Indifférent")) {
                        Critere crit = new Critere();
                        crit.setAttribut(Request.SEARCH_BY_STATE);
                        crit.setComparatif(Critere.EQUALS);
                        crit.setValue(state);
                        criteria.add(crit);
                        archivedAccounts = true;
                    }
                }

                // FIXME : cardState and onlyIds ... is there a link ??!
                Iterator iter = individualService.get(criteria, null, cardState == null, archivedAccounts).iterator();

                while (iter.hasNext()) {
                    IndividualRecord individual = null;
                    if (cardState != null)
                        individual = BusinessFactory.getIndividualRecord(iter.next(), cardState);
                    else
                        individual = new IndividualRecord((Long)iter.next());

                    if (individual != null)
                        results.add(individual);
                }
            } catch (CvqException ce) {
                logger.error("findIndividuals", ce);
            }
            return results;
        }
        return null;
    }

    public static void getIndividualRecord(IndividualRecord record) {
        if (ac != null) {
            try {
                IIndividualService service = (IIndividualService) ac.getBean(IIndividualService.SERVICE_NAME);

                BusinessFactory.setIndividualRecord(record, service.getById(record.getId()));

            } catch (CvqException ce) {
                logger.error("findIndividuals", ce);
            }
        }
    }

    public static FamilyRecord findFamilyMembers(Long id) {
        FamilyRecord record = null;
        if ((record == null) && (ac != null)) {
            IHomeFolderService homeFolderService = (IHomeFolderService) ac
                    .getBean(IHomeFolderService.SERVICE_NAME);

            try {
                record = BusinessFactory.getFamilyRecord(homeFolderService.getById(id));

            } catch (CvqException ce) {
                logger.error("findFamily", ce);
            }
        }
        return record;
    }

    public static FamilyRecord findFamily(RequestManager requestManager, Long id) {
        FamilyRecord record = findFamilyMembers(id);
        getFamilyDocuments(record);
        getFamilyDemands(requestManager, record);
        return record;
    }

    public static boolean saveFamilyRecord(FamilyRecord record) {
        if ((record != null) && (ac != null)) {
            IHomeFolderService homeFolderService = (IHomeFolderService) ac
                    .getBean(IHomeFolderService.SERVICE_NAME);
            try {
                HomeFolder homeFolder = homeFolderService.getById(record.getId());
                if (!homeFolder.getState().equals(ActorState.ARCHIVED)) {
                    if (record.isArchived()) {
                        homeFolderService.archive(homeFolder);
                    } else {
                        homeFolder.setEnabled(new Boolean(record.isEnabled()));
                        homeFolder.setFamilyQuotient(record.getFamilyQuotient());
                        homeFolderService.modify(homeFolder);
                    }
                    return true;
                }
            } catch (CvqException ce) {
                logger.error("saveFamilyRecord", ce);
            }
        }
        return false;
    }
    
    public static CategoryRecord getCategory(Long id) {
        if (ac != null) {
            ICategoryService service = (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);
            try {
                return BusinessFactory.getCategoryRecord(service.getById(id));
            } catch (CvqException ce) {
                logger.error("getCategory", ce);
            }
        }
        return null;
    }

    public static void getFamilyDocuments(FamilyRecord record) {
        if (ac != null) {
            try {
                IHomeFolderService homeFolderService = (IHomeFolderService) ac
                        .getBean(IHomeFolderService.SERVICE_NAME);
                Iterator iter = homeFolderService.getAssociatedDocuments(record.getId()).iterator();
                while (iter.hasNext()) {
                    Document document = (Document) iter.next();

                    Integer type = IDocumentService.NO_TYPE;
                    if (document.getDocumentType() != null)
                        type = document.getDocumentType().getType();

                    PaperRecord paperRecord = new PaperRecord(BusinessDictionary.getDocumentType(type),
                            BusinessDictionary.getDocumentState(document.getState()), Utils
                                    .getDateAsString(document.getEndValidityDate()), Utils
                                    .getDateAsString(document.getValidationDate()), Utils
                                    .getDateAsString(document.getCreationDate()));
                    paperRecord.setId(document.getId());
                    paperRecord.setPerson(document.getIndividual());

                    // getDocumentData(paperRecord);
                    record.addPaper(paperRecord);
                }
            } catch (CvqObjectNotFoundException ce) {
                logger.error("getFamilyDocuments", ce);
            } catch (CvqException ce) {
                logger.error("getFamilyDocuments", ce);
            }
        }
    }

    public static void getDocumentData(HttpSession session, PaperRecord paperRecord) {
        if (ac != null) {
            try {
                IDocumentService documentService = (IDocumentService) ac
                        .getBean(IDocumentService.SERVICE_NAME);
                if (paperRecord.getId() != null) {
                    paperRecord.setData(session, documentService.getAllPages(paperRecord.getId()));
                    paperRecord.setNbPages(documentService.getPagesNumber(paperRecord.getId()));
                }
            } catch (CvqObjectNotFoundException ce) {
                logger.error("getDocumentData", ce);
            } catch (CvqException ce) {
                logger.error("getDocumentData", ce);
            }
        }
    }

    public static void getFamilyDemands(RequestManager requestManager, FamilyRecord record) {
        if (ac != null) {
            try {
                ArrayList<RequestRecord> results = new ArrayList<RequestRecord>();
                
                IRequestService requestService = getDefaultRequestService();
                Set<Request> homeFolderRequests = 
                    requestService.getByHomeFolderId(record.getId());
                if (homeFolderRequests != null) {
                    for (Request request : homeFolderRequests)
                        results.add(requestManager.getRequestRecord(request, null));
                }

                record.setDemands(results);

            } catch (CvqObjectNotFoundException ce) {
                logger.error("getFamilyDemands", ce);
            } catch (CvqException ce) {
                logger.error("getFamilyDemands", ce);
            }
        }
    }

    public static void updateHistory(ArrayList history, RequestRecord record) {
        if (ac != null) {
            try {
                IRequestService requestService = getDefaultRequestService();
                Iterator iter = requestService.getActions(record.getId()).iterator();
                while (iter.hasNext()) {
                    RequestAction action = (RequestAction) iter.next();

                    if (!action.getLabel().equals(IRequestService.REQUEST_CREATION_NOTIFICATION)) {
                        HistoryRecord historyRecord = new HistoryRecord();

                        if (action.getAgentId() == -1) {
                            if (action.getLabel().equals(IRequestService.REQUEST_RED_ALERT_NOTIFICATION))
                                historyRecord.setState("Rouge");
                            else if (action.getLabel().equals(IRequestService.REQUEST_ORANGE_ALERT_NOTIFICATION))
                                historyRecord.setState("Orange");
                            
                            historyRecord.setAuthor("Système");
                            historyRecord.setAction("Alerte");

                        } else {
                            historyRecord.setState(BusinessDictionary.getRequestState(action.getResultingState()));
        
                            String actorName = getActor(action.getAgentId());
        
                            historyRecord.setAuthor(actorName);
                            historyRecord.setAction(BusinessDictionary.getActionType(action.getLabel()));
                        }
                        historyRecord.setDate(Utils.getDateAsString(action.getDate()));
                        historyRecord.setNote(action.getNote());
    
                        history.add(historyRecord);
                    }
                }
            } catch (CvqObjectNotFoundException ce) {
                logger.error("updateHistory", ce);
            } catch (CvqException ce) {
                logger.error("updateHistory", ce);
            }
        }
    }

    public static WebApplicationContext getAc() {
        return ac;
    }

    public static ArrayList<CategoryRecord> getCategories(boolean all) {
        if (ac != null) {
            ICategoryService categoryService = (ICategoryService) ac
                    .getBean(ICategoryService.SERVICE_NAME);
            ArrayList<CategoryRecord> results = new ArrayList<CategoryRecord>();

            try {
                List categoriesList = null;
                if (all)
                    categoriesList = categoryService.getAll();
//                else
//                    categoriesList = categoryService.getAgentManagedCategories(SecurityContext.getCurrentAgent());

                for (int i = 0; i < categoriesList.size(); i++) {
                    CategoryRecord record = BusinessFactory.getCategoryRecord(categoriesList.get(i));
                    results.add(record);
                }
            } catch (CvqException ce) {
                logger.warn("getCategories", ce);
            }
            return results;
        }
        return null;
    }

    public static boolean hasManagerProfile(String name) {
//        if (ac != null) {
//            ICategoryService service = 
//                (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);
//            
//            try {
//                return service.hasManagerProfileOnCategory(SecurityContext.getCurrentAgent(), name);
//            } catch (CvqException ce) {
//                logger.warn("hasManagerProfile", ce);
//            }
//        }
        return false;
    }

    public static CategoryRecord getCategoryByName(String name) {
        if (ac != null) {
            ICategoryService categoryService = 
                (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);
            
            try {
                Category category = categoryService.getByName(name);
                if (category != null)
                    return BusinessFactory.getCategoryRecord(category);
            } catch (CvqException ce) {
                logger.warn("getCategories", ce);
            }
        }
        return null;
    }

    public static void saveCategory(AdminForm adminForm) {
        if (ac != null) {
            ICategoryService categoryService = (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);

            HashSet requestTypes = new HashSet();
            // Get the request types treated by this service
            for (int i = 0; i < adminForm.getRtypes().size(); i++) {
                RequestTypeRecord rtypeRecord = (RequestTypeRecord) adminForm.getRtypes().get(i);

                if (rtypeRecord.isTreated()) { // Selected RequestType for this service
                    requestTypes.add(rtypeRecord.getId());
                    rtypeRecord.setCategoryId(adminForm.getCategoryId());
                }
                // Category is NOT selected, so if the RequestType belonged to the category remove
                else if (adminForm.getCategoryId().equals(rtypeRecord.getCategoryId()))
                    rtypeRecord.setCategoryId(null);
            }

            try {

                Category category = categoryService.getById(adminForm.getCategoryId());
                category.setName(adminForm.getCategoryName());
                category.setPrimaryEmail(adminForm.getCategoryEmail());
                categoryService.modify(category);

                // Modify the existing service entry
                categoryService.updateCategoryRequestsAssociation(adminForm.getCategoryId(), requestTypes);

                category = categoryService.getById(adminForm.getCategoryId());
                CategoryRecord newCategory = BusinessFactory.getCategoryRecord(category);
                adminForm.updateCategory(newCategory);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveCategory", e);
            } catch (CvqException e) {
                logger.error("saveCategory", e);
            }
        }
    }

    public static void deleteCategory(AdminForm adminForm) {
        if (ac != null) {
            ICategoryService categoryService = (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);

            try {

                categoryService.delete(adminForm.getCategoryId());

                adminForm.deleteSelectedCategory();

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveCategory", e);
            } catch (CvqException e) {
                logger.error("saveCategory", e);
            }
        }
    }

    public static void createCategory(AdminForm adminForm) {
        if (ac != null) {
            ICategoryService categoryService = (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);

            try {
                Category category = new Category();
                category.setName(adminForm.getCategoryName());
                category.setPrimaryEmail(adminForm.getCategoryEmail());
                categoryService.create(category);

                CategoryRecord newCategory = BusinessFactory.getCategoryRecord(category);
                adminForm.addCategory(newCategory);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveCategory", e);
            } catch (CvqException e) {
                logger.error("saveCategory", e);
            }
        }
    }

    public static ArrayList<UserRecord> getUsers() {
        if (ac != null) {
            IAgentService agentService = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);
            ArrayList<UserRecord> results = new ArrayList<UserRecord>();

            try {
                Iterator iter = agentService.getAll().iterator();

                while (iter.hasNext()) {
                    UserRecord record = BusinessFactory.getUserRecord(iter.next());
                    if (record.isActive())
                        results.add(record);
                }
            } catch (CvqException ce) {
                logger.warn("getUsers", ce);
            }
            return results;
        }
        return null;
    }

    public static HashMap getAgents() {
        HashMap agents = new HashMap();
        if (BusinessManager.getAc() != null) {
            try {
                IAgentService agentService = (IAgentService) BusinessManager.getAc().getBean(
                        IAgentService.SERVICE_NAME);
                Iterator iter = agentService.getAll().iterator();
                while (iter.hasNext()) {
                    Agent agent = (Agent) iter.next();

                    if ((agent.getFirstName() != null) && (agent.getLastName() != null))
                        agents.put(agent.getFirstName() + " " + agent.getLastName(), agent.getId());
                    else
                        agents.put(agent.getLogin(), agent.getId());

                }
            } catch (CvqException ce) {
            }
        }
        return agents;
    }

    public static School getSchool(String name) {
        if (ac != null) {
            try {
                ISchoolService service = (ISchoolService) ac.getBean(ISchoolService.SERVICE_NAME);
                return service.getByName(name);
            } catch (CvqException ce) {
                logger.warn("getSchool", ce);
            }
        }
        return null;
    }

    public static List getSchools() {
        if (ac != null) {
            try {
                ISchoolService service = (ISchoolService) ac.getBean(ISchoolService.SERVICE_NAME);
                Iterator iter = service.getAll().iterator();
                ArrayList schools = new ArrayList();
                while (iter.hasNext()) {
                    School school = (School) iter.next();
                    schools.add(school.getName());
                }
                return schools;

            } catch (CvqException ce) {
                logger.warn("getSchool", ce);
            }
        }
        return null;
    }

    public static List getRecreationcenters() {
        if (ac != null) {
            try {
                IRecreationCenterService service = (IRecreationCenterService) ac.getBean(IRecreationCenterService.SERVICE_NAME);
                Iterator iter = service.getAll().iterator();
                ArrayList centers = new ArrayList();
                while (iter.hasNext()) {
                    RecreationCenter center = (RecreationCenter) iter.next();
                    centers.add(center.getName());
                }
                return centers;

            } catch (CvqException ce) {
                logger.warn("getRecreationcenters", ce);
            }
        }
        return null;
    }

    public static boolean managesCategories() {
        ICategoryService service = (ICategoryService) ac.getBean(ICategoryService.SERVICE_NAME);
//        try {
//            List managerCategories = service.getAgentManagedCategories(SecurityContext.getCurrentAgent());
//            return ((managerCategories != null) && !managerCategories.isEmpty());
//
//        } catch (CvqException e) {
//            logger.warn("managesCategories", e);
//        }
        return false;
    }

    public static UserRecord getCurrentUser() {
        try {
            return BusinessFactory.getUserRecord(SecurityContext.getCurrentAgent());
        } catch (CvqException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static UserRecord getUser(Long id) {
        if (ac != null) {
            IAgentService agentService = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);

            try {
                Agent agent = agentService.getById(id);
                if (agent != null) {
                    UserRecord userRecord = BusinessFactory.getUserRecord(agent);
                    return userRecord;
                }
            } catch (CvqException ce) {
                logger.warn("getUser", ce);
            }
        }
        return null;
    }

    public static String getActor(Long id) {
        if ((id != null) && (ac != null)) {
            IAgentService agentService = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);
            IIndividualService individualService = (IIndividualService) ac
                    .getBean(IIndividualService.SERVICE_NAME);

            try {
                if (agentService.exists(id)) {
                    Agent agent = agentService.getById(id);
                    if (agent != null) {
                        if ((agent.getFirstName() != null) && (agent.getLastName() != null))
                            return agent.getFirstName() + " " + agent.getLastName();
                        else
                            return agent.getLogin();
                    }
                } else if (id.intValue() != 0) {
                    Individual individual = (Individual) individualService.getById(id);
                    if (individual != null) {
                        return individual.getFirstName() + " " + individual.getLastName();
                    }
                }
            } catch (CvqException ce) {
                logger.warn("getActor", ce);
            } catch(Exception e) {
                logger.warn("getActor", e);
            }
        }
        return "";
    }

    public static void saveUser(AdminForm adminForm) {
        if (ac != null) {
            IAgentService agentService = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);

            HashMap<Long,CategoryProfile> categoryProfiles = new HashMap<Long,CategoryProfile>();

            UserRecord user = adminForm.getUser();
            user.clearCategoryProfile();

            // Get the rights for each service in the system
            for (int i = 0; i < adminForm.getCategories().size(); i++) {
                CategoryRecord categoryRecord = (CategoryRecord) adminForm.getCategories().get(i);

                if (categoryRecord.isRW()) {
                    categoryProfiles.put(categoryRecord.getId(), CategoryProfile.READ_WRITE);
                    user.addCategoryProfile(categoryRecord.getId(), ProfileManager.PROFILE_RW);
                }
                if (categoryRecord.isRO()) {
                    categoryProfiles.put(categoryRecord.getId(), CategoryProfile.READ_ONLY);
                    user.addCategoryProfile(categoryRecord.getId(), ProfileManager.PROFILE_RO);
                }
                if (categoryRecord.isManager()) {
                    categoryProfiles.put(categoryRecord.getId(), CategoryProfile.MANAGER);
                    user.addCategoryProfile(categoryRecord.getId(), ProfileManager.PROFILE_MANAGER);
                }
//                if (!categoryRecord.isRW() && !categoryRecord.isRO() && !categoryRecord.isManager()) {
//                    categoryProfiles.put(categoryRecord.getId(), CategoryProfile.NONE);
//                    user.addCategoryProfile(categoryRecord.getId(), ProfileManager.PROFILE_NONE);
//                }
            }

            try {
                // modify the existing user entry
                agentService.modifyRights(adminForm.getUserId(), categoryProfiles);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveUser", e);
            } catch (CvqException e) {
                logger.error("saveUser", e);
            }
        }
    }

    public static UserRecord checkUser(String name) {
        if (ac != null) {
            IAgentService agentService = (IAgentService) ac.getBean(IAgentService.SERVICE_NAME);

            try {
                String lastName = name;
                String firstName = "";

                int split = lastName.indexOf(' ');
                if (split != -1) {
                    firstName = lastName.substring(0, split) + ".";
                    lastName = lastName.substring(split + 1);
                }
                Agent agent = agentService.getByLogin(firstName + lastName);
                if (agent != null) {
                    UserRecord userRecord = BusinessFactory.getUserRecord(agent);
                    return userRecord;
                }

            } catch (CvqObjectNotFoundException e) {
                logger.error("checkUser", e);
            } catch (CvqException e) {
                logger.error("checkUser", e);
            }
        }
        return null;
    }

    public static List getReferentialGroups() {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            ArrayList groupList = new ArrayList();
            Set allData = service.getAllLocalReferentialData();

            Iterator iter = allData.iterator();

            while (iter.hasNext()) {
                LocalReferentialType data = (LocalReferentialType)iter.next();
                String key = data.getDataName();
                Map value = data.getLabelsMap();
                groupList.add(new ReferentialDataGroup(data, key, (String) value.get("fr")));
            }
            return groupList;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static Set getAllReferentialData() {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            return service.getAllLocalReferentialData();

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static Set getReferentialRequestData(String requestType) {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            return service.getLocalReferentialDataByRequestType(requestType);

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static LocalReferentialType getReferentialData(String dataName) {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            return service.getLocalReferentialDataByName(dataName);

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static List getReferentialList(String type) {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            LocalReferentialType data = service.getLocalReferentialDataByName(type);
            
            return addReferentialChildren(new ArrayList(), data.getEntries());

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    private static List addReferentialChildren(List list, Set children) {
        if (children != null) {
            Iterator iter = children.iterator();
            while (iter.hasNext()) {
                LocalReferentialEntry entry = (LocalReferentialEntry)iter.next();
                Map value = entry.getLabelsMap();
                list.add(new ReferentialData(entry.getKey(), (String) value.get("fr")));
                addReferentialChildren(list, entry.getEntries());
            }
        }
        return list;
    }

    public static List getReferentialDataList(String type) {
        try {
            ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

            ArrayList referentialList = new ArrayList();
            LocalReferentialType data = service.getLocalReferentialDataByName(type);
            Iterator iter = data.getEntries().iterator();
            while (iter.hasNext()) {
                LocalReferentialEntry entry = (LocalReferentialEntry)iter.next();
                referentialList.add(new ReferentialDataRecord(entry.getKey(), entry.getLabelsMap()));
            }
            return referentialList;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static void saveReferentialData(LocalReferentialType data) throws Exception{
        ILocalReferentialService service = (ILocalReferentialService) ac.getBean(ILocalReferentialService.SERVICE_NAME);

        service.setLocalReferentialData(data);

    }

    public static Set getReservationData(String typeLabel, boolean forSubscriber) {
        try {
            IPlaceReservationService service = (IPlaceReservationService)ac.getBean(IPlaceReservationService.SERVICE_NAME);
            
            return service.getPlaceReservationForRequestType(typeLabel,forSubscriber);
            
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public static void saveReservationData(String typeLabel, Set data) throws Exception {
        IPlaceReservationService service = (IPlaceReservationService)ac.getBean(IPlaceReservationService.SERVICE_NAME);
        
        service.setPlaceReservationForRequestType(typeLabel, data);
            
    }
    
    public static PlaceReservationType getReservationData(String typeLabel, String reservationKey) {
        try {
            IPlaceReservationService service = (IPlaceReservationService)ac.getBean(IPlaceReservationService.SERVICE_NAME);
            
            return service.getPlaceReservationForRequestType(typeLabel,reservationKey, false);
            
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public static PlaceReservationType setReservationData(String typeLabel, PlaceReservationType reservation,
            boolean remove) {
        try {
            IPlaceReservationService service = (IPlaceReservationService) ac
                    .getBean(IPlaceReservationService.SERVICE_NAME);

            if (remove)
                service.removePlaceReservationForRequestType(typeLabel, reservation.getKey());
            else
                service.setPlaceReservationForRequestType(typeLabel, reservation);

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public static void sendMail(String serviceMail, String mail, String cc[], String object, String contents,
            File attachment) {
        if (ac != null) {
            IMailService service = (IMailService) ac.getBean(IMailService.SERVICE_NAME);

            try {
                service.send(serviceMail, mail, cc, object, contents, attachment);
            } catch (CvqException e) {
                logger.error("sendMail", e);
            }
        }
    }

    public static void sendSms(String number, String message) throws CvqException {
        if (ac != null) {
            ISmsService smsService = (ISmsService) ac.getBean(ISmsService.SERVICE_NAME);
            smsService.send(number, message);
        }
    }
    
    public static void notifyRequester(String meansOfContact, 
            String from, String to, String subject, String body, File attachment) 
        throws CvqException {

        IMeansOfContactService service = 
            (IMeansOfContactService)BusinessManager.getAc().getBean(IMeansOfContactService.SERVICE_NAME);
        
        MeansOfContactEnum meansOfContactEnum = MeansOfContactEnum.forString(meansOfContact);
        
        byte[] data = null;
        if (attachment != null) {
            if (!attachment.exists())
                throw new CvqException("attachement " + attachment.getName() + " not found");
            data = new byte[(int) attachment.length()];
            try {
                FileInputStream fis = new FileInputStream(attachment);
                fis.read(data);
            } catch (FileNotFoundException e) {
                // unlikely to happen since we already checked that
            } catch (IOException ioe) {
                throw new CvqException("error reading data from file " + attachment.getName());
            }
        }
        if (meansOfContactEnum != null) {
            if (meansOfContactEnum.equals(MeansOfContactEnum.EMAIL))
                service.notifyRequesterByEmail(from, to, subject, body, data);
            
            else if (meansOfContactEnum.equals(MeansOfContactEnum.SMS))
                service.notifyRequesterBySms(to, body);
        }
    }
    
    public static ArrayList getExternalAccounts(Long id) {
        ArrayList<AccountRecord> results = new ArrayList<AccountRecord>();
        if (ac != null) {
            IHomeFolderService service = (IHomeFolderService) ac.getBean(IHomeFolderService.SERVICE_NAME);
            try {
                Map<Individual,Map<String, String>> individuals = 
                    service.getIndividualExternalAccountsInformation(id);
                
                Iterator<Entry<Individual,Map<String,String>>> iter = individuals.entrySet().iterator();
                while (iter.hasNext()) {
                    AccountRecord record = new AccountRecord();
                    Entry<Individual,Map<String,String>> individual = iter.next(); 

                    record.setExternalLabel(individual.getValue().get("child-csn"));
                    record.setLastName(individual.getKey().getLastName());
                    record.setFirstName(individual.getKey().getFirstName());
                    
                    results.add(record);
                }
                
            } catch (CvqException e) {
                logger.error("getAccounts", e);
            }
        }
        return results;
    }
    
    public static ArrayList findPayments(SearchForm filter) {
        ArrayList results = new ArrayList();
        if (ac != null) {
            IPaymentService service = (IPaymentService) ac.getBean(IPaymentService.SERVICE_NAME);

            Date startDate = null;
            Date endDate = null;
            String broker = null;
            String bankReference = null;
            String lastName = null;
            Long homeFolderId = null;
            String dateType = IPaymentService.DATE_TYPE_INITIALIZATION;
            PaymentState state = null;
            
            // Do not forget to test that filter field are different from empty string
            
            if (filter.getState() != null && filter.getState().length() > 0) {
                state = BusinessDictionary.getPaymentState(filter.getState());
            }
            if (filter.getPeriodBegin() != null
                    && !filter.getPeriodBegin().equals(""))
                startDate = Utils.getStringAsDate(filter.getPeriodBegin());

            if (filter.getPeriodEnd() != null 
                    && !filter.getPeriodEnd().equals(""))
                endDate = Utils.getStringAsDate(filter.getPeriodEnd());

            if (endDate != null && startDate != null && endDate.compareTo(startDate) <= 0) {
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(startDate);
                calendar.add(Calendar.DATE, 1);
                endDate = calendar.getTime();
            }
            if ((state != null) && ((startDate != null) || (endDate != null))) {
                if (state.equals(PaymentState.VALIDATED))
                    dateType = IPaymentService.DATE_TYPE_COMMIT;
            }
            
            if (filter.getBroker() != null && filter.getBroker().length() > 0)
                broker = filter.getBroker();
            
            if (filter.getBankReference() != null && filter.getBankReference().length() > 0)
                bankReference = filter.getBankReference();
            
            // LastNames are stored as upper case string
            if (filter.getLastName() != null && filter.getLastName().length() > 0)
                lastName = filter.getLastName().toUpperCase();
            
            if (filter.getFamilyId() != null )
                homeFolderId = filter.getFamilyId();
    
            Collection payments = 
                (Collection) service.get(startDate, endDate, dateType, state, null, bankReference, broker, homeFolderId, lastName);

            for (Iterator i = payments.iterator(); i.hasNext();) {
                Payment payment = (Payment) i.next();
                PaymentRecord paymentRecord =
                    new PaymentRecord(
                            payment.getInitializationDate(),
                            payment.getCommitDate(),
                            payment.getState() == null ? "" : BusinessDictionary.getPaymentState(payment.getState()),
                            payment.getCvqReference(),
                            payment.getBankReference(),
                            payment.getBroker(),
                            payment.getHomeFolder().getId(),
                            payment.getAmount().intValue());
                results.add(paymentRecord);
            }
        }
        
        return results;
    }

    public static void updateCard(Long cardId, CardState state) {

        if (ac != null) {
            ICardService service = (ICardService) ac.getBean(ICardService.SERVICE_NAME);

            try {
                Card card = service.getById(cardId);
                card.setCardState(state);

                service.modify(card);

            } catch (CvqObjectNotFoundException e) {
                logger.error("updateCard", e);
            } catch (CvqException e) {
                logger.error("updateCard", e);
            }
        }
    }

    public static LocalAuthorityConfigurationBean getCurrentSiteData(String host) {
        if (ac != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)BusinessManager.getAc().getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            if (SecurityContext.getCurrentSite() != null) {
                String site = SecurityContext.getCurrentSite().getName();
                LocalAuthorityConfigurationBean localAuthority = registry.getLocalAuthorityBeanByName(site);
                return localAuthority;
            } else {
                LocalAuthorityConfigurationBean localAuthority = registry.getLocalAuthorityBeanByUrl(host);
                return localAuthority;
            }
        }
        return null;
    }

    public static Collection getEnabledMeansOfContact() throws CvqException {
        if (ac != null) {
            IMeansOfContactService service = 
                (IMeansOfContactService)BusinessManager.getAc().getBean(IMeansOfContactService.SERVICE_NAME);
            
            return meansOfContactList(service.getEnabledMeansOfContact());
        }
        return null;
    }
    
    private static Collection meansOfContactList(List<MeansOfContact> mocList){
        Collection<String> list = new ArrayList<String>();
        
        for (MeansOfContact moc : mocList) {
            list.add(BusinessDictionary.getMeansOfContactLabel(moc.getType()));
        }
        if (list.size() == 0)
            list.add("Pas de données");

        return list;
    }

    public static String getAssetsBase() {
        if (ac != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)ac.getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            return registry.getAssetsBase();
        }
        return null;
    }

    public static void testTransactionLazyInitialization() throws CvqException {

        logger.debug("testTransactionLazyInitialization() Entering");

        if (ac != null) {
            IHomeFolderService homeFolderService = (IHomeFolderService) ac
                    .getBean(IHomeFolderService.SERVICE_NAME);
            Set homeFoldersSet = homeFolderService.getAll();
            logger
                    .debug("testTransactionLazyInitialization() Got " + homeFoldersSet.size()
                            + " home folders");
            Iterator homeFoldersIt = homeFoldersSet.iterator();
            while (homeFoldersIt.hasNext()) {
                HomeFolder homeFolder = (HomeFolder) homeFoldersIt.next();
                Set homeFolderDocs = homeFolder.getDocuments();
                logger.debug("testTransactionLazyInitialization() Got " + homeFolderDocs.size()
                        + " documents for home folder " + homeFolder.getId());

            }
        }
    }

    public static void testTransactionRollback() throws CvqException {

        logger.debug("testTransactionRollback() Entering");

        if (ac != null) {
            IHomeFolderService homeFolderService = (IHomeFolderService) ac
                    .getBean(IHomeFolderService.SERVICE_NAME);
            Set homeFoldersSet = homeFolderService.getAll();
            logger.debug("testTransactionRollback() Got " + homeFoldersSet.size() + " home folders");
            if (homeFoldersSet.size() > 0) {
                HomeFolder homeFolder = (HomeFolder) homeFoldersSet.iterator().next();
                logger.debug("testTransactionRollback() Playing with home folder id : " + homeFolder.getId());
                Document doc = new Document();
                doc.setAgentNote("Paris est magique");
                IDocumentService documentService = (IDocumentService) ac
                        .getBean(IDocumentService.SERVICE_NAME);
                doc.setDocumentType(documentService
                        .getDocumentTypeById(IDocumentService.TAXES_NOTIFICATION_TYPE));
                Long docId = documentService.create(doc, homeFolder.getId(), null);
                logger.debug("testTransactionRollback() Created document with id : " + docId);
                DocumentBinary docBin = new DocumentBinary();
                int wrongDocId = docId.intValue() + 1;
                try {
                    documentService.addPage(new Long(wrongDocId), docBin);
                } catch (CvqException ce) {
                    logger.warn("testTransactionRollback() Got long awaited exception");
                }
            } else {
                logger
                        .warn("testTransactionRollback() No home folder available, can't test transaction rollback :-(");
            }
        }
    }
}
