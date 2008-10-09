/*
 * Cartevaloise
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
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

package fr.cg95.cvq.fo.personal.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.RequestManager;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.action.BasePersonalAction;
import fr.cg95.cvq.fo.common.form.ChildCountForm;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

public class ShowChildCountsAction extends BasePersonalAction {

    static Logger logger = Logger.getLogger(ShowChildCountsAction.class);

    protected ActionForward doExecute(ActionMapping pMapping, ActionForm pForm,
                                      HttpServletRequest pRequest, HttpServletResponse pResponse)
        throws Exception {

        FamilyHome familyHome = SessionManager.getFamilyHome(pRequest);
        RequestManager requestManager = SessionManager.getRequestManager(pRequest);

        // Set the ChildCountForm in the session
        ChildCountForm childCountForm = (ChildCountForm) pRequest.getSession().getAttribute(CHILDCOUNT_FORM);
        if (childCountForm == null) {
            childCountForm = new ChildCountForm();
            pRequest.getSession().setAttribute(CHILDCOUNT_FORM, childCountForm);
        }
        ChildForm child = null;

        if (pRequest.getParameter(ManagerWizardState.INDEX_REQUEST_PARAMETER) != null) {
            // we are coming from child selection

            // reset any previous result
            pRequest.getSession().removeAttribute("consumptionYears");
            pRequest.getSession().removeAttribute("requests");
            childCountForm.reset();

            // get the index of the element from the children list from the HTTP request
            int index = 0;
            try {
                index = Integer.parseInt(pRequest.getParameter(ManagerWizardState.INDEX_REQUEST_PARAMETER));
                childCountForm.setIndex(index);
            } catch (Exception e) {
                index = childCountForm.getIndex();
            }

            // get the child form from the children list
            child = (ChildForm) familyHome.getChildren().toArray()[index];

            // retrieve all requests with consumptions for this child
            IRequestService requestService = BusinessManager.getInstance().getRequestService();
            Set childRequests = requestService.getBySubjectId(child.getId());
            Iterator childRequestsIt = childRequests.iterator();
            ArrayList selectList = new ArrayList();
            while (childRequestsIt.hasNext()) {
                Request request = (Request) childRequestsIt.next();
                // FIXME : is it a good place to do that ??
                if (request.getState().equals(RequestState.ARCHIVED)) {
                    logger.debug("Filtering archived request");
                    continue;
                }
                IRequestService currentRequestService =
                    BusinessManager.getInstance().getRequestService(request);
                try {
                    if (requestService.hasMatchingExternalService(request.getRequestType().getLabel())) {
                        ReferentialData refData = new ReferentialData(currentRequestService.getLabel(), 
                                requestManager.getRequestTypeLabel(request.getRequestType().getLabel()));
                        selectList.add(refData);
                    }
                } catch (CvqException e) {
                    logger.error("Error retrieve consumptions associated to request");
                    childCountForm.setError(e);
                }
            }

            if (selectList.size() > 0) {
                ReferentialData refData = new ReferentialData("", _messageResources.getMessage("request.choose"));
                selectList.add(0, refData);
                childCountForm.setAssociatedToConsumptions(true);
                pRequest.getSession().setAttribute("requests", selectList);
            } else {
                childCountForm.setAssociatedToConsumptions(false);
            }
            pRequest.getSession().setAttribute("consumptionYears", getConsumptionsYears());

        } else if (pRequest.getParameter("navigate") != null
                   && !pRequest.getParameter("navigate").equals("")) {
            // we are navigating through the results

            logger.warn("Navigation");

            // get the child form from the children list
            child = (ChildForm) familyHome.getChildren().toArray()[childCountForm.getIndex()];

            Calendar fromDate =
                new GregorianCalendar(Integer.parseInt(childCountForm.getYear()),
                                      Integer.parseInt(childCountForm.getMonth()),
                                      childCountForm.getIntFirstDay());

            // Adjust starting date to have monday first in display
            int offSet = (fromDate.get(Calendar.DAY_OF_WEEK) + 7 - fromDate.getFirstDayOfWeek()) % 7;
            fromDate.add(Calendar.DAY_OF_YEAR, -offSet);

            String navigate = pRequest.getParameter("navigate");
            if (navigate.equals("next")) {
                fromDate.add(Calendar.DAY_OF_YEAR, 7);
            } else {
                fromDate.add(Calendar.DAY_OF_YEAR, -7);
            }
            childCountForm.setYear(String.valueOf(fromDate.get(Calendar.YEAR)));
            childCountForm.setMonth(String.valueOf(fromDate.get(Calendar.MONTH)));
            childCountForm.setFirstDay(String.valueOf(fromDate.get(Calendar.DAY_OF_MONTH)));

            Calendar toDate =
                new GregorianCalendar(fromDate.get(Calendar.YEAR),
                                      fromDate.get(Calendar.MONTH),
                                      fromDate.get(Calendar.DATE));

            toDate.add(Calendar.DAY_OF_YEAR, 7);

            performConsumptionsSearch(requestManager, childCountForm, child.getId(),
                                      pRequest.getParameter("requestLabel"), fromDate, toDate);
        } else {
            // we are issuing a consumptions search

            // get the child form from the children list
            child = (ChildForm) familyHome.getChildren().toArray()[childCountForm.getIndex()];

            String requestLabel = pRequest.getParameter("requestLabel");
            childCountForm.setRequestLabel(requestLabel);
            childCountForm.resetRequestConsumptions();
            childCountForm.setFirstDay("1");

            int month = Integer.parseInt(pRequest.getParameter("month"));
            int year = Integer.parseInt(pRequest.getParameter("year"));

            String format = pRequest.getParameter("format");
            childCountForm.setFormat(format);

            if (requestLabel == null || requestLabel.equals("")) {
                pRequest.setAttribute(CHILD_FORM, child);
                pRequest.setAttribute(CHILDCOUNT_FORM, childCountForm);
                return null;
            }

            Calendar fromDate = new GregorianCalendar(year, month, childCountForm.getIntFirstDay());
            Calendar toDate = new GregorianCalendar(year, month, childCountForm.getIntFirstDay());
// To initialize consumptions for a given month, look at the whole month, not just the first week
            toDate.add(Calendar.MONTH, 1);
            childCountForm.setYear(String.valueOf(fromDate.get(Calendar.YEAR)));
            childCountForm.setMonth(String.valueOf(fromDate.get(Calendar.MONTH)));

//            if (format.equals(ChildCountForm.SHORT_FORMAT)) {
//                toDate.add(Calendar.MONTH, 1);
//            } else if (format.equals(ChildCountForm.FULL_FORMAT)) {
//                toDate.add(Calendar.DAY_OF_YEAR, 7);
//            }

            performConsumptionsSearch(requestManager, childCountForm, child.getId(),
                                      requestLabel, fromDate, toDate);
            childCountForm.setIssuedSearch(true);
        }

        pRequest.setAttribute(CHILD_FORM, child);
        pRequest.setAttribute(CHILDCOUNT_FORM, childCountForm);

        return null;
    }

    private void performConsumptionsSearch(RequestManager requestManager, ChildCountForm childCountForm,
                                           final Long childId, final String requestLabel,
                                           final Calendar fromDate, final Calendar toDate)
        throws Exception {

        // retrieve all consumptions from child's associated requests
        IRequestService requestService = BusinessManager.getInstance().getRequestService();
        Set childRequests = requestService.getBySubjectId(childId);
        Iterator childRequestsIt = childRequests.iterator();
        while (childRequestsIt.hasNext()) {
            Request request = (Request) childRequestsIt.next();
            IRequestService currentRequestService =
                BusinessManager.getInstance().getRequestService(request);
            if (currentRequestService.getLabel().equals(requestLabel)) {
                try {
                    Map requestConsumptions =
                        requestService.getConsumptionsByRequest(request.getId(),
                                                                fromDate.getTime(),
                                                                toDate.getTime());
                    if (requestConsumptions != null && requestConsumptions.size() > 0) {
                        logger.debug("adding request " + currentRequestService.getLabel()
                                     + " with translation "
                                     + requestManager.getRequestTypeLabel(request.getRequestType().getLabel()));
                        childCountForm.addRequestConsumptions(currentRequestService.getConsumptionsField(),
                                                              requestConsumptions);
                    }
                } catch (CvqException e) {
                    logger.error("Error retrieve consumptions associated to request");
                    childCountForm.setError(e);
                }
            }
        }
    }

    private Collection getConsumptionsYears() {
        Collection consumptionsYears = new ArrayList();
        String year = null;
        Calendar calendar = new GregorianCalendar();
        Date now = new Date();
        
        calendar.setTime(now);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        consumptionsYears.add(new ReferentialData(year, year));

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        consumptionsYears.add(new ReferentialData(year, year));

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        year = String.valueOf(calendar.get(Calendar.YEAR));
        consumptionsYears.add(new ReferentialData(year, year));

        return consumptionsYears;
    }
}
