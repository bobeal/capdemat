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
 * Object : Display the list of request in the personal space
 */
package fr.cg95.cvq.fo.taglib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.common.form.ChildCountForm;
import fr.cg95.cvq.wizard.ReferentialData;

/**
 * A tag used to display a list of the consumptions made within the context
 * of a specific request.
 *
 * @author bor@zenexity.fr
 */
public class DisplayRequestConsumptionsTag extends BaseTag {

    private String _title;

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();

            ChildCountForm childCountForm = null;
            try {
                childCountForm =
                    (ChildCountForm) RequestUtils.lookup(pageContext, name, getScope());
            } catch (Exception e) {
                e.printStackTrace();
            }

            Map requestConsumptions = childCountForm.getRequestConsumptions();
            if (requestConsumptions != null && requestConsumptions.size() > 0) {
                if (childCountForm.getFormat().equals(ChildCountForm.SHORT_FORMAT)) {
                    String consumptionsField = (String) requestConsumptions.keySet().iterator().next();
                    // retrieve translations associated to this field
                    Collection fieldList = BusinessManager.getReferentialList(consumptionsField);

                    Map resultsMap = new LinkedHashMap();
                    Map consumptionsMap = (Map) requestConsumptions.get(consumptionsField);
                    Iterator consumptionsIt = consumptionsMap.keySet().iterator();
                    while (consumptionsIt.hasNext()) {
                        Date date = (Date) consumptionsIt.next();
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        if (calendar.get(Calendar.MONTH) == Integer.parseInt(childCountForm.getMonth())) {
                            String activity = (String) consumptionsMap.get(date);
                            // do activity translation if one available
                            if (fieldList != null) {
                                Iterator fieldListIt = fieldList.iterator();
                                while (fieldListIt.hasNext()) {
                                    ReferentialData refData = (ReferentialData) fieldListIt.next();
                                    if (refData.getKey().equals(activity))
                                        activity = refData.getValue();
                                }
                            }
                            if (resultsMap.get(activity) == null) {
                                resultsMap.put(activity, new Integer(1));
                            } else {
                                Integer currentCount = (Integer) resultsMap.get(activity);
                                Integer newCount = new Integer(currentCount.intValue() + 1);
                                resultsMap.put(activity, newCount);
                            }
                        }
                    }
                    writeNewShort(out, resultsMap);
                    
                } else {
                    Calendar calendar = new GregorianCalendar();
                    //calendar.setTime(new Date());
                    calendar.set(Calendar.YEAR, Integer.parseInt(childCountForm.getYear()));
                    calendar.set(Calendar.MONTH, Integer.parseInt(childCountForm.getMonth()));
                    calendar.set(Calendar.DAY_OF_MONTH, childCountForm.getIntFirstDay());

                    String consumptionsField = (String) requestConsumptions.keySet().iterator().next();
                    // retrieve translations associated to this field
                    Collection fieldList = BusinessManager.getReferentialList(consumptionsField);

                    Map resultsMap = new LinkedHashMap();
                    Map consumptionsMap = (Map) requestConsumptions.get(consumptionsField);
                    Iterator consumptionsIt = consumptionsMap.keySet().iterator();

                    Calendar tempCalendar = Calendar.getInstance();
                    while (consumptionsIt.hasNext()) {
                        Date date = (Date) consumptionsIt.next();
                        tempCalendar.setTime(date);
                        String activity = (String) consumptionsMap.get(date);
                        // do activity translation if one available
                        if (fieldList != null) {
                            Iterator fieldListIt = fieldList.iterator();
                            while (fieldListIt.hasNext()) {
                                ReferentialData refData = (ReferentialData) fieldListIt.next();
                                if (refData.getKey().equals(activity)) {
                                    activity = refData.getValue();
                                    break;
                                }
                            }
                        }
                        if (resultsMap.get(activity) == null) {
                            Set daySet = new TreeSet();
                            daySet.add(String.valueOf(tempCalendar.get(Calendar.DAY_OF_YEAR)));
                            resultsMap.put(activity, daySet);
                        } else {
                            Set daySet = (Set) resultsMap.get(activity);
                            daySet.add(String.valueOf(tempCalendar.get(Calendar.DAY_OF_YEAR)));
                        }
                    }
                    out.println("<script language=\"JavaScript\">");
                    out.println("function navigate(form,direction) {");
                    out.println("  document.getElementById('navigate').value = direction;");
                    out.println("  document.forms[form].submit();");
                    out.println("}");
                    out.println("</script>");

                    writeNewFull(out, resultsMap, calendar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    private void writeNewShort(JspWriter out, Map resultsMap) throws IOException {
        out.println("<table class=\"table_type2\">");
        out.println("  <tr>");
        out.println("    <th class=\"th th1\"><h1 class=\"title\">ACTIVITE</h1></th>");
        out.println("    <th class=\"th th2\"><h1 class=\"title\">Nombre de consommations</h1></th>");
        out.println("  </tr>");
        out.println("</table>");
        out.println("<div class=\"overflow\">");
        out.println("  <table class=\"table_type3\">");

        String trClass = null;
        Iterator resultsIt = resultsMap.keySet().iterator();
        while (resultsIt.hasNext()) {
            String activity = (String) resultsIt.next();
            Integer count = (Integer) resultsMap.get(activity);

//          Hack for translation  of "Meal" to "Repas"
            if ((activity != null) && activity.equals("Meal"))
                activity = "Repas";
//End Hack                        
            if (trClass == null)
                trClass = " class=\"tr_first\"";
            else if (resultsIt.hasNext())
                trClass = "";
            else
                trClass = " class=\"tr_last\"";
                
            out.println("    <tr" + trClass + ">");
            out.println("      <td class=\"td td1\"><p class=\"paragraph\">" + activity + "</p></td>");
            out.println("      <td class=\"td td2\"><p class=\"paragraph\">" + count + "</p></td>");
            out.println("    </tr>");
        }
        out.println("  </table>");
        out.println("</div>");
    }
    
    private void writeOldShort(JspWriter out, Map resultsMap) throws IOException {
        out.print("<table width=\"100%\" border=\"0\">");
        out.print("<tr class=\"table-header\">");
        out.print("<td width=\"15%\"><b>Activité</b></td>");
        out.print("<td width=\"25%\"><b>Nombre de consommations</b></td>");
        out.print("</tr>");

        int parity = 0;
        Iterator resultsIt = resultsMap.keySet().iterator();
        while (resultsIt.hasNext()) {
            String activity = (String) resultsIt.next();
            Integer count = (Integer) resultsMap.get(activity);

//          Hack for translation  of "Meal" to "Repas"
            if ((activity != null) && activity.equals("Meal"))
                activity = "Repas";
//End Hack                        
            parity++;
            String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";

            out.println("<tr class=\"" + clazz + "\">");
            out.println("<td>" + activity + "</td>");
            out.println("<td>" + count + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        
    }

    private void writeNewFull(JspWriter out, Map resultsMap, Calendar calendar) throws IOException {
        
        out.println("<table class=\"table_type2\">");
        out.println("  <tr>");
        out.println("    <th class=\"th th1\"><h1 class=\"title\">ACTIVITE</h1></th>");

        // Adjust starting date to have monday first in display
        int offSet = (calendar.get(Calendar.DAY_OF_WEEK) + 7 - calendar.getFirstDayOfWeek()) % 7;

        for (int i = 0; i < offSet; i++) {
            out.println("    <th class=\"th\"><h1 class=\"title\">&nbsp;</h1></th>");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.FRANCE);

        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTime(calendar.getTime());
        for (int i = offSet; i < 7; i++) {
            out.println("    <th class=\"th\"><h1 class=\"title\">"
                      + simpleDateFormat.format(tempCalendar.getTime())
                      + tempCalendar.get(Calendar.DAY_OF_MONTH) + "</h1></th>");

            tempCalendar.set(Calendar.DAY_OF_YEAR, tempCalendar.get(Calendar.DAY_OF_YEAR) + 1);
        }
        out.println("  </tr>");
        out.println("</table>");
        out.println("<div class=\"overflow\">");
        out.println("  <table class=\"table_type3\">");

        String trClass = null;
        Iterator resultsIt = resultsMap.keySet().iterator();
        while (resultsIt.hasNext()) {
            String activity = (String) resultsIt.next();
            Set daySet = (Set) resultsMap.get(activity);

//Hack for translation  of "Meal" to "Repas"
            if ((activity != null) && activity.equals("Meal"))
                activity = "Repas";
//End Hack                        

            if (trClass == null)
                trClass = " class=\"tr_first\"";
            else if (resultsIt.hasNext())
                trClass = "";
            else
                trClass = " class=\"tr_last\"";
                
            out.println("    <tr" + trClass + ">");
            out.println("      <td class=\"td td1\"><p class=\"paragraph\">" + activity + "</p></td>");

            // use original calendar to its initial value
            for (int i = 0; i < offSet; i++) {
                out.println("      <td class=\"td\"></td>");
            }
            tempCalendar.setTime(calendar.getTime());
            for (int i = offSet; i < 7; i++) {
                int dayOfYear = tempCalendar.get(Calendar.DAY_OF_YEAR);
                if (daySet.contains(String.valueOf(dayOfYear)))
                    out.println("      <td class=\"td\"><span class=\"custom_color\">&nbsp;</span></td>");
                else
                    out.println("      <td class=\"td\"></td>");

                tempCalendar.set(Calendar.DAY_OF_YEAR,
                        tempCalendar.get(Calendar.DAY_OF_YEAR) + 1);
            }
            out.println("    </tr>");
        }
        out.println("  </table>");
        out.println("</div>");
        out.println("<ul class=\"list_type9\">");
        out.println("  <li class=\"item_type1\"><a href=\"javascript:navigate('" + name + "', 'prev');\" title=\"\">semaine précédente</a></li>");
        out.println("  <li class=\"item_type2\"><a href=\"javascript:navigate('" + name + "', 'next');\" title=\"\">semaine suivante</a></li>");
        out.println("</ul>");
    }
    
    private void writeOldFull(JspWriter out, Map resultsMap, Calendar calendar) throws IOException {

        // Adjust starting date to have monday first in display
        int offSet = (calendar.get(Calendar.DAY_OF_WEEK) + 7 - calendar.getFirstDayOfWeek()) % 7;

        out.print("<table width=\"100%\" border=\"0\">");

        out.print("<tr class=\"table-header\">");
        out.print("<td width=\"30%\"><b>Activité</b></td>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.FRANCE);
        for (int i = 0; i < offSet; i++) {
            out.print("<td width=\"10%\">&nbsp;</td>");
        }

        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTime(calendar.getTime());
        for (int i = offSet; i < 7; i++) {
            out.print("<td width=\"10%\"><b><center>"
                      + simpleDateFormat.format(tempCalendar.getTime())
                      + " " + tempCalendar.get(Calendar.DAY_OF_MONTH) + "</center></b></td>");

            tempCalendar.set(Calendar.DAY_OF_YEAR, tempCalendar.get(Calendar.DAY_OF_YEAR) + 1);
        }
        out.print("</tr>");

        int parity = 0;
        Iterator resultsIt = resultsMap.keySet().iterator();
        while (resultsIt.hasNext()) {
            String activity = (String) resultsIt.next();
            Set daySet = (Set) resultsMap.get(activity);

//Hack for translation  of "Meal" to "Repas"
            if ((activity != null) && activity.equals("Meal"))
                activity = "Repas";
//End Hack                        

            parity++;
            String clazz = (parity % 2 == 0) ? "table-evenrow" : "table-oddrow";

            out.println("<tr class=\"" + clazz + "\">");
            out.println("<td>" + activity + "</td>");

            // use original calendar to its initial value
            for (int i = 0; i < offSet; i++) {
                out.print("<td width=\"10%\">&nbsp;</td>");
            }
            for (int i = offSet; i < 7; i++) {
                int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
                if (daySet.contains(String.valueOf(dayOfYear)))
                    out.print("<td width=\"10%\"><b><center>X</center></b></td>");
                else
                    out.println("<td width=\"10%\">&nbsp;</td>");

                calendar.set(Calendar.DAY_OF_YEAR,
                             calendar.get(Calendar.DAY_OF_YEAR) + 1);
            }
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<div id=\"resultsnav\">");
        out.println("<div class=\"previous\" onclick=\"javascript:navigate('" + name + "', 'prev');\">Semaine préc.</div>");
        out.println("<div class=\"next\" onclick=\"javascript:navigate('" + name + "', 'next');\">Semaine suiv.</div>");
        out.println("</div>");
    }
    
    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return _title;
    }

    /**
     * @param pTitle
     *            The title to set.
     */
    public void setTitle(String pTitle) {
        _title = pTitle;
    }
}
