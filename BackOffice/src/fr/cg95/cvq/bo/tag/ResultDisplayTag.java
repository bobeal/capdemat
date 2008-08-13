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
package fr.cg95.cvq.bo.tag;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.Localization;
import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.form.SearchForm;
import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.DisplayColumn;
import fr.cg95.cvq.bo.record.IResultRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.wizard.StringUtils;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;

/**
 * @author René le CLERCQ
 */
public class ResultDisplayTag extends BaseTag {

    /** Commons Logging instance. */
    private static Logger log = Logger.getLogger(ResultDisplayTag.class);
    
    private static final long serialVersionUID = 2249843325571914913L;

    private static final int DISPLAY_HIDE = 1;

    private static final int DISPLAY_SHOW = 2;

    private static final int DISPLAY_SELECT = 3;

    /** number of results per page */
    public static int RESULTS_PER_PAGE = 12;

    public static int PAGES_PER_RANGE = 5; //10

    public static int PAGES_PER_DISPLAY = 30;
    
    
    private static String DEFAULT_TABLE_CSS_CLASS = "table001";

    private SearchForm searchForm = null;

    private String type = null;

    public String disabled = null;

    public String onclick = null;
    
    public String force = null;
    
    public String height = null;

    public int doEndTag() {
        try {
            log.debug("Start result display");
            
            setWindowIndex();
            
            JspWriter out = pageContext.getOut();

            Object obj = RequestUtils.lookup(pageContext, name, property, getScope());
            ArrayList results = null;

            if (obj instanceof SearchForm) {
                searchForm = (SearchForm) obj;
                results = searchForm.getWholeResultsList();
            } else if (obj instanceof ArrayList) {
                searchForm = null;
                results = (ArrayList) obj;
            }

            if (results != null) {
                if (results.size() == 0) {
                    out.println("<div class=\"block_head\"><div class=\"left\"></div><div class=\"center\"></div><div class=\"right\"></div></div>");
                    out.println("<div class=\"block003\"><span class=\"text001\">Aucun enregistrement trouvé</span></div>");
                } else if (results.get(0) instanceof IResultRecord) {
                    IResultRecord record = (IResultRecord) results.get(0);

                    DisplayColumn[] columns = record.getDisplayColumns(pageContext, type);
                    if (columns != null) {
                        String navigateAction = record.getNavigateAction(pageContext);
                        if (navigateAction != null) {
                            if (searchForm == null) {
                                searchForm = new SearchForm();
                                searchForm.setTotalRecordNb(results.size());
                            }
                            displayPageNavigation(out, navigateAction, true);
                        }
                        
                        out.println(" <table id=\"" + property + "\" class=\"table_default " + getTableCssClass() + "\">");
                        displayHeader(out, columns);
                        if (getHeight() != null) {
                            out.println(" <tbody class=\"" + getHeight() + "\">");
                        }
                        displayTable(out, columns, results);
                        if (getHeight() != null) {
                            out.println("</tbody>");
                        }
                        out.println(" </table>");
                        if (navigateAction != null) {
                            displayPageNavigation(out, navigateAction, false);
                        }
                    }
                }
            }
        } catch (Exception ignored) {
            ignored.getMessage();
        }
        log.debug("End result display");
        return EVAL_PAGE;
    }

    private void displayPageNavigation(JspWriter out, String action, boolean top) throws IOException {
        long currRecStart = 0;
        long currRecStop = 0;

        if (searchForm != null && searchForm.getTotalRecordNb() > 0) {
            String currPage = pageContext.getRequest().getParameter("page");
            if ((currPage != null) && (currPage.length() != 0))
                try {
                    searchForm.setDisplayedPage(Integer.parseInt(currPage));
                } catch (NumberFormatException nfe) {
                }

            long currentPage = searchForm.getDisplayedPage();

            searchForm.setCurrentRecord((currentPage - 1) * RESULTS_PER_PAGE);

            currRecStart = searchForm.getCurrentRecord() + 1;
            currRecStop = searchForm.getCurrentRecord() + RESULTS_PER_PAGE;
            if (currRecStop > searchForm.getTotalRecordNb())
                currRecStop = searchForm.getTotalRecordNb();

            if (top) {
                // Write script and form tag
                out.println("<div class=\"block_head\"><div class=\"left\"></div><div class=\"center\"><span class=\"element first "+ "XXX" +"\">Résultats " + currRecStart + " à " + currRecStop
                        + " sur un total de " + searchForm.getTotalRecordNb() + "</span></div><div class=\"right\"></div></div>");
                out.println("<form name=\"resultForm\" method=\"post\" action=\"" + action + ".do\">");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("function navigate(formname,pagenumber) {");
                out.println("  var sf = document.forms[formname];");
                out.println("  sf.elements[\"page\"].value = pagenumber;");
                out.println("  sf.submit();");
                out.println("}");
                out.println("</script>");
                
                
                out.println("<input type=hidden name=page>");

                out.println("<div class=\"pagination\">");
                out.println("<ul>");
                out.println("<li class=\"element\"><span class=\"title\">Nombre de pages : " + getPagesNb() + "</span></li>");

                long prev_page = currentPage - 1;
                long next_page = currentPage + 1;
                long prev_ref_page = currentPage - 2;
                long next_ref_page = currentPage + 2;
                long referencePage = currentPage - ((currentPage - 1) % PAGES_PER_RANGE);
//                 long firstPage = Math.max(1, referencePage - PAGES_PER_DISPLAY / 2);
//                 long lastPage = Math.min(getPagesNb(), referencePage + PAGES_PER_DISPLAY / 2);
                long firstPage = 1;
                long lastPage = getPagesNb();
                
                // first page
                if ((firstPage > 0) && (firstPage != currentPage))
                    out.print("<li class=\"element\"><a " + navigateHref(firstPage) + " class=\"link first\" title=\"Aller vers : première page\">&nbsp;</a></li>");
                else
                    out.print("<li class=\"element\"><span class=\"link first\">&nbsp;</span></li>");
                // previous page
                if ((prev_page > 0) && (prev_page != currentPage) && (prev_page != firstPage))
                    out.print("<li class=\"element\"><a " + navigateHref(prev_page) + " class=\"link previous\" title=\"Aller vers : page précédente\">&nbsp;</a></li>");
                else
                    out.print("<li class=\"element\"><span class=\"link previous\">&nbsp;</span></li>");

                for (long i = firstPage; i <= lastPage; i++) {
                    if (i == currentPage) {
                        out.print("<li class=\"element\"><span class=\"link current\">" + currentPage + "</span></li>");
                    } else if((i >= prev_ref_page) && (i <= next_ref_page)) {
                        out.print("<li class=\"element\"><a " + navigateHref(i) + " class=\"link\">" + i + "</a></li>");
                    }
                }
                // next page
                if ((next_page > 0) && (next_page != currentPage) && (next_page != lastPage) && (next_page < lastPage))
                    out.print("<li class=\"element\"><a " + navigateHref(next_page) + " class=\"link next\" title=\"Aller vers : page suivante\">&nbsp;</a></li>");
                else
                    out.print("<li class=\"element\"><span class=\"link next\" >&nbsp;</span></li>");
                // last page
                if ((lastPage > 0) && (lastPage != currentPage))
                    out.print("<li class=\"element\"><a " + navigateHref(lastPage) + " class=\"link last\" title=\"Aller vers : dernière page\">&nbsp;</a></li>");
                else
                    out.print("<li class=\"element\"><span class=\"link last\" >&nbsp;</span></li>");

                out.println("<li class=\"last\">&nbsp;</li>");
                out.println("</ul>");
                out.println("</div>");
                
            }
             if (!top)
                 out.println("</form>");
        }
    }

    private String navigateHref(long page) {
        return "href=\"#\" onclick=\"navigate('resultForm'," + page + ");return false;\"";
    }
    
    /**
     * Returns the number of pages in the results set
     */
    private long getPagesNb() {
        long l = (long) searchForm.getTotalRecordNb() / RESULTS_PER_PAGE;
        if (searchForm.getTotalRecordNb() % RESULTS_PER_PAGE == 0)
            return l;
        else
            return l + 1;
    }

    private void displayHeader(JspWriter out, DisplayColumn[] columns) throws IOException {
        out.println("<tr>");

        for (int i = 0; i < columns.length; i++) {
            out.print("<th class=\"th\">");

            if (columns[i].isSort()) {
                out.print("<a class=\"link\" href=\"searchAction.do?action=sortBy&field="
                        + columns[i].getField() 
                        + windowIndexParameter("&"));

                out.print("&list=" + getProperty());
                out.print("\"><span>");
            }

            out.print(columns[i].getLabel());

            if (columns[i].isSort())
                out.print("</span></a>");
            out.print("</th>");
        }
        out.println("</tr>");
    }

    private void displayTable(JspWriter out, DisplayColumn[] columns, ArrayList results) throws IOException {

        log.debug("Start display table");

        StateManager stateManager = (StateManager)pageContext.getSession().getAttribute(StateManager.STATE_MANAGER);
        IResultRecord record = stateManager.getSelectedRecord();
        String selectId = ((record != null) && (record instanceof RequestRecord)) ? displayData(record,"id",null) : "";
        
        long currRecStart = 0;
        long currRecStop = results.size();

        if (searchForm != null) {
            currRecStart = searchForm.getCurrentRecord();
            currRecStop = searchForm.getCurrentRecord() + RESULTS_PER_PAGE;

            if (currRecStop > searchForm.getTotalRecordNb())
                currRecStop = searchForm.getTotalRecordNb();
        }
        
        loadPage(results, currRecStart, currRecStop);
        
        for (long r = currRecStart; r < currRecStop; r++) {
            log.debug("Loading record");

            record = (IResultRecord) results.get((int) r);
            if ((record instanceof RequestRecord) && selectId.equals(displayData(record,"id", null)))
                ((RequestRecord)record).unLoad();
            try {
                record.load();
            } catch (Exception e) {
                e.getMessage();
            }
            log.debug("Display record");
            String line = displayRecord(record, columns, r);
            if (line != null)
                out.println(line);
        }
        log.debug("End display table");
    }

    private void loadPage(ArrayList<IResultRecord> results, long currRecStart, long currRecStop) {
        HashMap<Long,IResultRecord> pageResults = new HashMap<Long,IResultRecord>();
        
        for (long r = currRecStart; r < currRecStop; r++) {
            IResultRecord record = results.get((int) r); 
            if (!record.isLoaded())
                pageResults.put(record.getResultId(), record);
        }
        if (!pageResults.isEmpty())
            results.get((int)currRecStart).loadPage(pageResults);
    }
    
    private String displayRecord(IResultRecord record, DisplayColumn[] columns, long index) {
        StringWriter outString = new StringWriter();
        PrintWriter out = new PrintWriter(outString);

        long styleIndice = (index % 2) + 1;

        String trSelect = "";
        if (onclick != null) {
            trSelect = " id=\"tr" + index + "\" onclick=\"javascript:" + onclick + "('tr" + index + "'," + index + ");\"";
        }
        out.println("<tr " + trSelect + ">");

        for (int i = 0; i < columns.length; i++) {

            try {
                if (columns[i].getType().equals("text")) {
                    out.println("<td class=\"td row" + styleIndice + "\">");
                    displayText(out, record, columns[i]);

                } else if (columns[i].getType().equals("check")) {
                    out.println("<td class=\"td row" + styleIndice + "\">");
                    displayCheck(out, record, columns[i], index);

                } else if (columns[i].getType().equals("check+text")) {
                    out.println("<td class=\"td row" + styleIndice + "\">");
                    displayCheck(out, record, columns[i], index);
//                     out.print(" ");
                    displayText(out, record, columns[i]);

                } else if (columns[i].getType().equals("indicator")) {
                    out.println("<td class=\"td row" + styleIndice + "\">");
                    displayIndicator(out, record, columns[i]);
                }

            } catch (Exception e) {
                out.print(e.getMessage());
            }
            out.println("</td>");
        }
        out.println("</tr>");

        return outString.toString();
    }

    private String getCheckProperty(DisplayColumn column) {
        if (column.getCheck() != null)
            return column.getCheck();

        return property;
    }

    private void displayCheck(PrintWriter out, IResultRecord record, DisplayColumn column, long index) {
        out.println("<input type=\"checkbox\" name=\"" + getCheckProperty(column) + "[" + index + "]."
                + column.getField() + "\" value=\"yes\" "
                + (displayData(record, column.getField(), null).equals("Oui") ? "checked=\"checked\"" : "")
                + ((getDisabled() != null) ? " disabled=\"disabled\"" : "") + ">");
    }

    private void displayIndicator(PrintWriter out, IResultRecord record, DisplayColumn column) {
        String data = displayData(record, column.getField(), null);
        if ((data != null) && !data.equals(oneBlank(null)))
            out.println("<img src=\"" + data + "\"/>");
        else
            out.println("&nbsp;");
    }

    private void displayText(PrintWriter out, IResultRecord record, DisplayColumn column) {
        switch (canDisplay(record, column.getSelect(), column.getValid())) {
        case DISPLAY_HIDE:
            return;

        case DISPLAY_SELECT:
            out.print("<a class=\"link\" href=\"selectAction.do?select=" + column.getSelect()
                    + windowIndexParameter("&")
                    + "&id=" + displayData(record, column.getField(), null) + "\"><span>");
        }
        out.print(displayData(record, column.getField(), column.getMaxChars()));

        if (column.getSelect() != null)
            out.print("</span></a>");
    }

    private int canDisplay(IResultRecord record, String select, String valid) {
        if (select != null) {
            if (valid != null) {
                String data = null;
                try {
                    data = (String) PropertyUtils.getProperty(record, valid);
                } catch (Exception e) {
                }
                if (data == null)
                    return DISPLAY_SHOW;

                if (data.equals("hide"))
                    return DISPLAY_HIDE;

                if (data.equals("show"))
                    return DISPLAY_SHOW;

                if (data.equals("select") && canNavigate())
                    return DISPLAY_SELECT;
            }
            if (canNavigate())
                return DISPLAY_SELECT;
        }
        return DISPLAY_SHOW;
    }

    private String displayData(IResultRecord record, String field, Integer maxChar) {
        Object data = null;
        try {
            data = PropertyUtils.getProperty(record, field);
        } catch (Exception e) {
        }
        if (data == null)
            return "&nbsp;";

        if (data instanceof Date)
            return Utils.getDateAsString((Date) data);

        if (data instanceof Boolean)
            return Localization.toString(data);
        
        String value = data.toString();
        if (maxChar != null)
            value = StringUtils.truncate(value, maxChar);
        
        return oneBlank(value);
    }

    private boolean canNavigate() {
        if ((force != null) && (force.equals("navigation")))
            return true;
                
        ManagerWizardState wizardState = 
            ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());
        
        return wizardState.getNavigate();
    }
    
    private String windowIndexParameter(String seperator) {
        return seperator + ManagerWizardState.WIZARD_REQUEST_PARAMETER + "=" + getWindowIndex();

    }
    
    private String oneBlank(String value) {
        if ((value == null) || (value.length() == 0))
            return "&nbsp;";

        return value;
    }
    
    private String getTableCssClass() {
        if ( styleClass == null || styleClass.length() == 0)
            return DEFAULT_TABLE_CSS_CLASS;
        return styleClass;
    }
    public String getType() {
        return type;
    }

    public void setType(String string) {
        type = string;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String string) {
        disabled = string;
    }

    public String getOnclick() {
        return onclick;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

}
