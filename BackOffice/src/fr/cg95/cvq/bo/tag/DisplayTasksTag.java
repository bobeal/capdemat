/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil G�n�ral du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by Ren� le Clercq. 
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
package fr.cg95.cvq.bo.tag;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspWriter;

import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.record.TaskRecord;

/**
 */
public class DisplayTasksTag extends BaseTag {

    private static final long serialVersionUID = 7659136722986825077L;

    public int doEndTag() {
        try {
            setWindowIndex();

            JspWriter out = pageContext.getOut();

            ArrayList<TaskRecord> tasks = null;
            try {
                tasks = (ArrayList<TaskRecord>) RequestUtils.lookup(pageContext, name, property, getScope());
            } catch (Exception e) {
            }
            if (tasks != null) {
                out.println("<table class=\"table003\"");
                for (int i = 0; i < tasks.size(); i++) {
                    TaskRecord taskRecord = tasks.get(i);
                    Iterator<TaskRecord> iter = taskRecord.getDetails().iterator();
                    // TD classes :
                    // td3 if has details
                    // td4 for each details except last
                    // td5 for last detail
                    String tdClass = "";
                    if (iter.hasNext()) {
                        tdClass = " td3";
                    }
                    out.println("<tr>");
                    out.println("<td class=\"td" + tdClass + "\">");
                    out.println("<div class=\"text001\">" + taskRecord.getLabel() + "</div>");
                    out.println("</td>");

                    out.println("<td class=\"td td1" + tdClass + "\">"
                            + notEmpty(taskRecord.getObservations()) + "</td>");
                    if (taskRecord.getState() != 0)
                        out.println("<td class=\"td td2" + tdClass + "\">&nbsp;</td>");
                    else
                        out.println("<td class=\"td" + tdClass + "\">&nbsp;</td>");
                    out.println("</tr>");

                    while (iter.hasNext()) {
                        TaskRecord detail = iter.next();
                        String tdDetailClass = null;
                        if (iter.hasNext()) {
                            tdDetailClass = " td4";
                        } else {
                            tdDetailClass = " td5";
                        }
                        out.println("<tr>");
                        out.println("<td class=\"td" + tdDetailClass + "\">");
                        out.println("<div class=\"text009\">" + detail.getLabel() + "</div>");
                        out.println("</td>");
                        out.println("<td class=\"td td1" + tdDetailClass + "\" colspan=\"2\">"
                                + notEmpty(detail.getObservations()) + "</td>");
                        out.println("</tr>");
                    }
                }
                out.println("</table>");
            }
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }

    private String notEmpty(String value) {
        if ((value != null) && (value.length() > 0))
            return value;

        return "&nbsp;";
    }

}
