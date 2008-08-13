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

package fr.cg95.cvq.fo.common.form;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChildCountForm {

    public static String SHORT_FORMAT = "short";
    public static String FULL_FORMAT = "full";

    private boolean associatedToConsumptions;
    private boolean issuedSearch;

    private String requestLabel;

    private int index;

    private String month;
    private String year;
    private String firstDay;
    private String format;

    private Throwable error;
    private Map requestConsumptions = new LinkedHashMap();

    public ChildCountForm() {
        super();
    }

    public void reset() {
        format = FULL_FORMAT;
        requestConsumptions.clear();
        requestLabel = "";
        issuedSearch = false;

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        month = String.valueOf(calendar.get(Calendar.MONTH));
        year = String.valueOf(calendar.get(Calendar.YEAR));
        firstDay = "1";
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int i) {
        index = i;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public int getIntFirstDay() {
        return Integer.parseInt(firstDay);
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable throwable) {
        error = throwable;
    }

    public void addRequestConsumptions(final String requestLabel, final Map consumptionsByActivity) {
        requestConsumptions.put(requestLabel, consumptionsByActivity);
    }

    public Map getConsumptionsByRequest(final String requestLabel) {
        return (Map) requestConsumptions.get(requestLabel);
    }

    public Map getRequestConsumptions() {
        return requestConsumptions;
    }

    public boolean isAssociatedToConsumptions() {
        return associatedToConsumptions;
    }

    public void setAssociatedToConsumptions(boolean value) {
        associatedToConsumptions = value;
    }

    public boolean isIssuedSearch() {
        return issuedSearch;
    }

    public void setIssuedSearch(boolean value) {
        issuedSearch = value;
    }

    public void resetRequestConsumptions() {
        requestConsumptions.clear();
    }

    public void setRequestLabel(final String requestLabel) {
        this.requestLabel = requestLabel;
    }

    public String getRequestLabel() {
        return this.requestLabel;
    }

    public String getFormat() {
        if (format == null)
            return FULL_FORMAT;
        else
            return this.format;
    }

    public void setFormat(final String format) {
        this.format = format;
    }
}
