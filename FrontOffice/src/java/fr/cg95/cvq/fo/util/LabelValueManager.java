/*
 * Cartevaloise
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights Reserved.
 *
 * Developed by Laurent Marquez (ARTAL Technologies) and René le Clercq
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cg95.cvq.fo.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.struts.util.LabelValueBean;
import org.apache.struts.util.MessageResources;

import fr.cg95.cvq.wizard.ReferentialData;

/**
 * @author Laurent MARQUEZ
 */
public class LabelValueManager implements Constants {

        private static LabelValueManager _labelValueManager = null;

        protected MessageResources _messageResources = null;

        private static Collection consumptionsMonths = new ArrayList();
        static {
            consumptionsMonths.add(new LabelValueBean("Janvier", String.valueOf(Calendar.JANUARY)));
            consumptionsMonths.add(new LabelValueBean("Février", String.valueOf(Calendar.FEBRUARY)));
            consumptionsMonths.add(new LabelValueBean("Mars", String.valueOf(Calendar.MARCH)));
            consumptionsMonths.add(new LabelValueBean("Avril", String.valueOf(Calendar.APRIL)));
            consumptionsMonths.add(new LabelValueBean("Mai", String.valueOf(Calendar.MAY)));
            consumptionsMonths.add(new LabelValueBean("Juin", String.valueOf(Calendar.JUNE)));
            consumptionsMonths.add(new LabelValueBean("Juillet", String.valueOf(Calendar.JULY)));
            consumptionsMonths.add(new LabelValueBean("Août", String.valueOf(Calendar.AUGUST)));
            consumptionsMonths.add(new LabelValueBean("Septembre", String.valueOf(Calendar.SEPTEMBER)));
            consumptionsMonths.add(new LabelValueBean("Octobre", String.valueOf(Calendar.OCTOBER)));
            consumptionsMonths.add(new LabelValueBean("Novembre", String.valueOf(Calendar.NOVEMBER)));
            consumptionsMonths.add(new LabelValueBean("Décembre", String.valueOf(Calendar.DECEMBER)));
        }

        private LabelValueManager() {
                super();
                if (null == _messageResources) {
                        _messageResources = MessageResources.getMessageResources(FILE_PROPERTY_NAME);
                }
        }

        public static LabelValueManager getInstance() {

                if (null == _labelValueManager) {
                        _labelValueManager = new LabelValueManager();
                }

                return _labelValueManager;

        }

    public Collection getNationalities(boolean choose) {

        Collection countries = new ArrayList();

        if (choose)
            countries.add(new ReferentialData("", _messageResources.getMessage(COUNTRY_CHOOSE)));

        countries.add(new ReferentialData(COUNTRY_CODE_FRANCE, _messageResources.getMessage(NATIONALITY_FRANCE)));
        countries.add(new ReferentialData(COUNTRY_CODE_EEC, _messageResources.getMessage(COUNTRY_EEC)));
        countries.add(new ReferentialData(COUNTRY_CODE_OUTSIDE_EEC, _messageResources.getMessage(COUNTRY_OUTSIDE_EEC)));
        return countries;
    }

    public String getMessage(final String key) {
        return _messageResources.getMessage(key);
    }

    public Collection getConsumptionsMonths() {
                return consumptionsMonths;
    }

    public Collection getConsumptionsYears() {
                Collection consumptionsYears = new ArrayList();
                String year = null;
                Calendar calendar = new GregorianCalendar();
                Date now = new Date();
                
                calendar.setTime(now);
                year = String.valueOf(calendar.get(Calendar.YEAR));
                consumptionsYears.add(new LabelValueBean(year, year));

                calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
                year = String.valueOf(calendar.get(Calendar.YEAR));
                consumptionsYears.add(new LabelValueBean(year, year));

                calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
                year = String.valueOf(calendar.get(Calendar.YEAR));
                consumptionsYears.add(new LabelValueBean(year, year));

                return consumptionsYears;
    }
}
