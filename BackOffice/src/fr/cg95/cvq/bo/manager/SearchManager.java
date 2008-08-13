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
package fr.cg95.cvq.bo.manager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.form.SearchBaseForm;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.record.IPaperHolder;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.ReportRecord;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.service.users.IRequestStatisticsService;

/**
 * @author René le CLERCQ
 */
public class SearchManager {
	
	public SearchManager() {
		super();
	}

	public static IResultRecord search(RequestManager requestManager, SearchForm searchForm, String key, Object value) {
        if (key.equals("familyid")) {
            return searchFamily(requestManager, (Long)value);
            
        } else if (key.equals("requestid")) {
            return BusinessManager.findRequestById(requestManager, (Long)value);

        } else if (key.equals("cardid")) {
            if ((searchForm != null) && searchForm.getSearch().equals("card")) {
                Iterator iter = searchForm.getWholeResultsList().iterator();
                while (iter.hasNext()) {
                    IndividualRecord record = (IndividualRecord)iter.next();
                    if ((record.getCardId()!= null) && record.getCardId().equals(value))
                        return record;
                }
            }
        }
		return null;
	}

	public static IResultRecord search(IPaperHolder record, String string, String type) {
		Iterator iter = record.getPapers().iterator();
		while (iter.hasNext()) {
			PaperRecord paper = (PaperRecord)iter.next();
			if (paper.getType().equals(type))
				return paper;
		}
		return null;
	}
	
	public static ArrayList searchStateTransitionRequests(RequestManager requestManager, String state) {
		return BusinessManager.findStateTransitionRequests(requestManager, state);
	}
	
	public static ArrayList searchRequest(RequestManager requestManager, SearchForm searchForm) {
		return BusinessManager.findRequests(requestManager, searchForm, null);
	}

	public static ArrayList searchIndividual(SearchForm searchForm) {
		return BusinessManager.findIndividuals(searchForm);
	}

	public static IResultRecord searchFamily(RequestManager requestManager, Long id) {
		return BusinessManager.findFamily(requestManager, id);
	}

	public static ArrayList searchReportRecords(RequestManager requestManager, SearchForm filterForm, String reportType) {
		ArrayList results = new ArrayList();
		
		if (reportType.equals("state")) {
            Iterator iter = BusinessDictionary.getRequestStates().iterator();
            while (iter.hasNext()) {
                String state = (String)iter.next();
                results.add(new ReportRecord(state,
                        BusinessManager.findNbRequestsByState(requestManager, state, filterForm), null));
            }

        } else if (reportType.equals("type")) {
            String category = filterForm.getService();
            String type = filterForm.getType();

            if ((category != null) && (category.length() > 0) && !category.equals("Indifférent")) {
                Iterator iter = requestManager.getRequestTypeLabels(category).iterator();
                while (iter.hasNext()) {
                    String label = requestManager.getRequestTypeLabel((String)iter.next());
                    results.add(new ReportRecord(label, BusinessManager.findNbRequestsByType(requestManager, label, filterForm), null));
                }

            } else if ((type != null) && (type.length() > 0) && !type.equals("Indifférent")) {
                results.add(new ReportRecord(type, BusinessManager.findNbRequestsByType(requestManager, type, filterForm), null));

            } else {
                Iterator iter = requestManager.getRequestTypeLabels().iterator();
    			while (iter.hasNext()) {
    				String label = (String)iter.next();
    				results.add(new ReportRecord(label,	BusinessManager.findNbRequestsByType(requestManager, label, filterForm), null));
    			}
            }
        
        } else if (reportType.equals("month")) {
            Calendar month = Calendar.getInstance();
            Calendar end = Calendar.getInstance();
            
            Date startDate = Utils.getStringAsDate(filterForm.getPeriodBegin());
            Date endDate = Utils.getStringAsDate(filterForm.getPeriodEnd());
            if (startDate == null) {
                endDate = month.getTime();
                month.set(Calendar.YEAR, month.get(Calendar.YEAR) - 1);
                startDate = month.getTime();
            }
            if (end == null) {
                endDate = month.getTime();
            }
            month.setTime(startDate);
            month.set(Calendar.DATE, 1);

            end = Calendar.getInstance();
            if (endDate != null)
                end.setTime(endDate);
            
            String state = filterForm.getState();
            if ((state == null) || (state.length() == 0) || state.equals("Indifférent"))
                state = IBusinessConstants.STATE_VALIDATED;

            while (month.before(end)) {
                String monthName = Utils.getDateAsMonthYearString(month.getTime());
                results.add(new ReportRecord(monthName,
                    BusinessManager.findNbRequestsByMonth(requestManager, month, null, filterForm),
                    state,
                    BusinessManager.findNbRequestsByMonth(requestManager, month, state, filterForm)));
                month.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
            }

        } else if (reportType.equals("quality")) {
			results.add(new ReportRecord("Vert", 
					BusinessManager.findNbRequestsByQuality(requestManager, 
					        Request.QUALITY_TYPE_OK, filterForm), null, Color.GREEN));
			results.add(new ReportRecord("Orange", 
					BusinessManager.findNbRequestsByQuality(requestManager, 
					        Request.QUALITY_TYPE_ORANGE, filterForm), null, Color.ORANGE));
			results.add(new ReportRecord("Rouge", 
					BusinessManager.findNbRequestsByQuality(requestManager, 
					        Request.QUALITY_TYPE_RED, filterForm), null, Color.RED));
        
        } else if (reportType.equals("reporting")) {
            filterForm.setDataType(SearchForm.CREATION_DATE);
            results = BusinessManager.findRequests(requestManager, filterForm, null);
		} else {
		    results = null;
        }
		
		return results;
	}

	public static ArrayList searchPaymentRecords(SearchForm filterForm) {
		ArrayList payments = BusinessManager.findPayments(filterForm);
		return payments;
	}
	
    public static void sortResults(RequestManager requestManager, SearchForm searchForm, String field, Collection list) {
        if ((list == null) && 
                searchForm.getSearch().equals("request") && (BusinessManager.getRequestOrderBy(field) != null)) {
            list = searchForm.getWholeResultsList();
            
            ArrayList sortedList = BusinessManager.findRequests(requestManager, searchForm, field);
            list.clear();
            if (searchForm.initSortEnv(field) == SearchBaseForm.ASC_SORT) {
                list.addAll(sortedList);
            } else {
                for (int i = sortedList.size()-1; i >= 0; i--)
                    list.add(sortedList.get(i));
            }
        } else {
            searchForm.sortBy(field, list);
        }
    }
}
