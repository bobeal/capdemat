/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Gï¿œnï¿œral du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by Renï¿œ le Clercq. 
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

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.bo.record.BaseRecord;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.ReservationNode;
import fr.cg95.cvq.wizard.StringUtils;

/**
 */
public class ToggleInputTag extends BaseBodyTag {

    private static final NumberFormat DECIMAL_FORMAT = DecimalFormat.getCurrencyInstance();

    private static final long serialVersionUID = -4743384994720310719L;

    private static final String ID = "fr.cg95.cvq.bo.tag.ToggleInputTag";

    private String id;

    private String type;

    private String action;

    private String indent;

    private ArrayList displayItems = new ArrayList();

    private class DisplayItem {
        String name = null;

        String label = null;
    }

    public int doStartTag() throws JspException {

        displayItems.clear();

        return EVAL_BODY_BUFFERED;
    }

    public int doAfterBody() throws JspException {
        BodyContent body = getBodyContent();
        StringTokenizer definitions = new StringTokenizer(body.getString(), "\n");

        while (definitions.hasMoreTokens()) {
            String definition = definitions.nextToken();
            definition = definition.replaceAll("\r", "").trim();

            if (definition.length() > 0) {
                DisplayItem item = new DisplayItem();
                int pos = definition.indexOf(',');

                item.name = definition.substring(1, pos);
                item.label = definition.substring(pos + 1, definition.length() - 1);

                displayItems.add(item);
            }
        }

        return SKIP_BODY;
    }

    public int doEndTag() {
        try {
            setWindowIndex();

            JspWriter out = pageContext.getOut();

            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

            ProfileManager profileManager = getProfileManager();
            boolean readOnly = (profileManager == null) || profileManager.isReadonly();

            if (request.getParameter("compare") != null)
                readOnly = true;

            Object result = RequestUtils.lookup(pageContext, name, property, getScope());
            if (result instanceof ReservationNode)
                readOnly = true;

            else if (result instanceof ReferentialData)
                readOnly = true;

            else if (result instanceof List)
                readOnly = true;

            String value = getRequestValue(result);
            if ((value == null) || (value.length() == 0))
                value = "&nbsp;";

            if (!readOnly) {
                if (request.getAttribute(ToggleInputTag.ID) == null) {
                    // For the first time we include the Javascript library
                    out.println("<script language=\"javaScript\" src=\"" + request.getContextPath()
                            + "/js/toggleinput.js\">");
                    out.println("</script>");
                }
                request.setAttribute(ToggleInputTag.ID, "set");

                String strutsAction = getAction();
                String strutsForm = getStrutsForm(strutsAction);

                if (!strutsAction.startsWith("/")) {
                    strutsAction = request.getContextPath() + "/" + strutsAction;
                }

                String identifier = getProperty();
                if (id != null)
                    identifier = identifier + "_"
                            + RequestUtils.lookup(pageContext, name, id, getScope());

                String clazz = (getStyleClass() != null) ? getStyleClass() : "toggle_field";

                BaseRecord record = (BaseRecord) RequestUtils.lookup(pageContext, name, getScope());
                String color = (record.isModified(getProperty())) ? "color:#ff0000;" : "";
                String style = " style=\"" + color + "width:150px;cursor:pointer;\"";

                out.println("<div id=\"" + identifier + "\" class=\"" + clazz
                        + "\" onclick=\"javascript:toggleInput('" + identifier + "', '" + getType()
                        + "', '" + clazz + "', '" + strutsAction + "', '" + strutsForm + "'"
                        + getValuesList() + ")\"" + style + ">");

                out.println(value);

                out.println("</div>");

            } else {
                out.println(value);
            }

        } catch (Exception ignored) {
            ignored.getMessage();
        }
        return EVAL_PAGE;
    }

    public String getScope() {
        if (scope == null)
            scope = "page";
        return scope;
    }

    private String getValuesList() {
        String valuesList = "";
        try {
            List values = (List) RequestUtils.lookup(pageContext, name, property + "List",
                    getScope());
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                ReferentialData data = (ReferentialData) iter.next();
                if (valuesList.length() == 0)
                    valuesList = ", new Array('" + data.getValue() + "'";
                else
                    valuesList += ",'" + data.getValue() + "'";
            }
            if (valuesList.length() > 0)
                valuesList += ")";

        } catch (JspException e) {
        }
        return valuesList;
    }

    private String getRequestValue(Object result) throws JspException {
        String value = "";

        if (result instanceof Boolean) {
            if (((Boolean) result).booleanValue())
                return "Oui";
            else
                return "Non";
        } else if (result instanceof String[]) {
            String[] values = (String[]) result;

            for (int i = 0; i < values.length - 1; i++)
                value += StringUtils.split(values[i], 25) + ", ";

            if (values.length > 0)
                value += values[values.length - 1];

            return value;
        } else if (result instanceof Calendar)
            return formatDate(((Calendar) result).getTime(), "dd/MM/yyyy");

        else if (result instanceof Date)
            return formatDate((Date) result, "dd/MM/yyyy");

        else if (result instanceof ReservationNode)
            return formatReservationNode((ReservationNode) result);

        else if (result instanceof ReferentialData)
            return formatReferentialData((ReferentialData) result);

        else if ((result instanceof List) && !displayItems.isEmpty())
            return formatListData((List) result);

        value = (result != null) ? result.toString() : "";

        return StringUtils.split(value, 25);
    }

    private String formatDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format, Locale.FRANCE);

        return df.format(date);
    }

    private String getStrutsForm(String strutsAction) throws JspException {
        // Look up the module configuration information we need
        ModuleConfig moduleConfig = RequestUtils.getModuleConfig(pageContext);

        if (moduleConfig == null) {
            JspException e = new JspException("Strust config not found");
            throw e;
        }
        // Look up the action mapping we will be submitting to
        String mappingName = RequestUtils.getActionMappingName(strutsAction);
        ActionMapping mapping = (ActionMapping) moduleConfig.findActionConfig(mappingName);
        if (mapping == null) {
            JspException e = new JspException("Struts action " + mappingName + " not found.");
            throw e;
        }
        return mapping.getName();
    }

    private String formatReservationNode(ReservationNode reservations) {
        String value = "";
        if (reservations != null) {
            for (int i = 0; i < reservations.getChildren().size(); i++) {
                ReservationNode reservation = (ReservationNode) reservations.getChildren().get(i);
                if (reservation.getAllReserved() > 0) {
                    value += "<div class=\"reservation\"  style=\"margin-bottom:5px;margin-left:10%;\">\n";
                    value += "  <div class=\"reservation-header\" >\n";
                    value += "    <div class=\"title\" >\n";
                    value += "      " + reservation.getText() + "\n";
                    value += "    </div>\n";
                    value += "    <div class=\"available\" >\n";
                    value += "      " + reservation.getDate() + "\n";
                    value += "    </div>\n";
                    value += "  </div>\n";
                    value += "  <div class=\"detail\" >\n";

                    for (int j = 0; j < reservation.getChildren().size(); j++) {
                        ReservationNode place = (ReservationNode) reservation.getChildren().get(j);
                        value += "    <div class=\"detail-field\" >\n";
                        value += "      <label>\n";
                        value += "        " + place.getText() + ": " + reservedPlaces(place) + "\n";
                        value += "      </label>\n";
                        value += "      <div class=\"price\" >\n";
                        value += "        à " + place.getPrice() + " &euro;\n";
                        value += "      </div>\n";
                        value += "      <div class=\"field\" >\n";
                        value += "        " + place.getTotalPrice() + " &euro;\n";
                        value += "      </div>\n";
                        value += "    </div>\n";
                    }
                    value += "  </div>\n";
                    value += "</div>\n";
                }
            }
            value += "<div class=\"header\" >\n";
            value += "   Total de la commande: " + reservations.getTotalPrice() + " &euro;\n";
            value += "</div>\n";
        }
        return value;
    }

    private String reservedPlaces(ReservationNode place) {
        if (place.getReserved() == 1)
            return "1 place";

        return place.getReserved() + " places";
    }

    private String formatReferentialData(ReferentialData referential) {
//      String value = "</br>";
        String value = "";
        if (referential != null) {
            value += "<ul class=\"list005\">";
            
            Iterator iter = referential.getChildren().iterator();
            while (iter.hasNext()) {
                value += displayStaticReferential((ReferentialData) iter.next(), getIndent());
            }
            value += "</ul>";
        }
        return value;
    }

    private String displayStaticReferential(ReferentialData data, String indent) {
        String value = "";
        if ((data != null) && data.isSelected()) {
            if (data.getChildren().size() > 0) {
                String precision = (data.getPrecisionLabel() != null) ? 
                        data.getPrecisionLabel() : "&nbsp;";
                String priority = (data.getPriorityLabel() != null) ? 
                        data.getPriorityLabel() : "&nbsp;";

                value += "<li class=\"element element_full\">";
                value += "<span class=\"item detail\">" + priority + "</span>";
                value += "<span class=\"item detail\">" + precision + "</span>";
                value += "<span class=\"item\">" + data.getValue() + "</span>\n";
                value += "<ul class=\"list\">\n";
                Iterator iter = data.getChildren().iterator();
                while (iter.hasNext()) {
                    value += displayStaticReferential((ReferentialData)iter.next(), "20px");
                }
              value += "</ul></li>\n";
            } else {
                String precision = 
                    (data.getParent().getPrecisionLabel() != null) ? 
                            getStringValue(data.getPrecision()) : "&nbsp;";
                String priority = 
                    (data.getParent().getPriorityLabel() != null) ? 
                            getStringValue(data.getPriority()) : "&nbsp;";

                value += "<li class=\"element element_empty\">";
                value += "<span class=\"item detail\">" + priority + "</span>";
                value += "<span class=\"item detail\">" + precision + "</span>";
                value += "<span class=\"item\">" + data.getValue() + "</span></li>\n";
            }
        }
        return value;
    }

    // private String displayStaticReferential(ReferentialData data, String
    // indent) {
    // String value = "";
    // if ((data != null) && data.isSelected()) {
    //            
    // if (data.getChildren().size() > 0) {
    // value += "<div class=\"reservation\"
    // style=\"margin-bottom:5px;margin-left:" + indent + ";\">\n";
    // value += " <div class=\"reservation-header\">\n";
    // value += " <div class=\"title\">" + data.getValue() + "</div>\n";
    // if (data.getPrecisionLabel() != null) {
    // value += " <div class=\"precision\" >\n";
    // value += " " + data.getPrecisionLabel() + "\n";
    // value += " </div>\n";
    // }
    // if (data.getPriorityLabel() != null) {
    // value += " <div class=\"priority\" >\n";
    // value += " " + data.getPriorityLabel() + "\n";
    // value += " </div>\n";
    // }
    // value += " </div>\n";
    // Iterator iter = data.getChildren().iterator();
    // while (iter.hasNext()) {
    // value += displayStaticReferential((ReferentialData)iter.next(), "20px");
    // }
    // value += "</div>\n";
    // } else {
    // value += " <div class=\"detail\">\n";
    // value += " <div class=\"detail-field\">\n";
    // value += " <label>\n";
    // value += " " + data.getValue() + "\n";
    // value += " </label>\n";
    // if (data.getParent().getPrecisionLabel() != null) {
    // value += " <div class=\"precision\">\n";
    // value += " " + getStringValue(data.getPrecision()) + "\n";
    // value += " </div>\n";
    // }
    // if (data.getParent().getPriorityLabel() != null) {
    // value += " <div class=\"priority\">\n";
    // value += " " + getStringValue(data.getPriority()) + "\n";
    // value += " </div>\n";
    // }
    // value += " </div>\n";
    // value += " </div>\n";
    // }
    // }
    // return value;
    // }

    private String formatListData(List list) {
        if ((list != null) && !list.isEmpty()) {
            String value = "</span><span class=\"list\"><table class=\"tabcontenu\" cellspacing=\"5\" width=\"100%\">";
//            value += displayHeader();
            for (int i = 0; i < list.size(); i++)
                value += displayItem(list.get(i), (i % 2) + 1);

            return value + "</table><br/>";
        }
        return "";
    }

    private String displayHeader() {
        String display = "<tr class=\"casecontenuentete\">";
        for (int i = 0; i < displayItems.size(); i++) {
            DisplayItem displayItem = (DisplayItem) displayItems.get(i);

            display += "<td class=\"label-field\">";
            display += displayItem.label;
            display += "</td>";
        }
        display += "</tr>";

        return display;
    }

    private String displayItem(Object item, long styleIndice) {
        String display = "<tr>";
        for (int i = 0; i < displayItems.size(); i++) {
            DisplayItem displayItem = (DisplayItem) displayItems.get(i);

            String value = getDisplayValue(item, displayItem.name);

            display += "<td class=\"casecontenu" + styleIndice + "\" align=\"left\">";
            display += value.toString();
            display += "</td>";
        }
        display += "</tr>";

        return display;
    }

    private String getDisplayValue(Object item, String property) {
        String display = "";
        Object value = null;
        try {
            value = PropertyUtils.getProperty(item, property);
            if (value != null) {
                display = value.toString();

                if (value instanceof Double) {
                    display = DECIMAL_FORMAT.format(((Double) value).doubleValue());
                    display = display.substring(0, display.length() - 1) + "&euro;";
                } else if (value instanceof Calendar) {
                    display = Utils.getDateAsString(((Calendar) value).getTime());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return display;
    }

    private String getStringValue(String value) {
        if (value == null)
            return "";

        return value;
    }

    public String getType() {
        if (type == null)
            return getProperty();
        return type;
    }

    public void setType(String string) {
        type = string;
    }

    public String getId() {
        return id;
    }

    public void setId(String string) {
        id = string;
    }

    public String getAction() {
        if (action == null)
            action = "saveFieldAction.do";
        return action;
    }

    public void setAction(String string) {
        action = string;
    }

    public String getIndent() {
        if (indent == null)
            return "10%";

        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

}
