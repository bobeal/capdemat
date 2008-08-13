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

package fr.cg95.cvq.bo.record;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.util.localization.ILocalizationService;
import fr.cg95.cvq.wizard.manager.ManagerWizardState;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.impl.RequestTypeImpl;

/**
 * @author René le CLERCQ
 */
public class XsdRequestRecord
        extends RequestTypeImpl
        implements IXsdRequestRecord, RequestType, InvocationHandler, IResultRecord, IImportExportRequest {


		private static long nextid = 1;

        private RequestType xsdDemand = null;

        private Long id = null;
        private boolean selected = false;
        private String message = null;
        private String type = null;

        private DisplayColumn importColumns[] =
                {
                        new DisplayColumn("selected", "", "check", "currentSearch.wholeResultsList"),
                        new DisplayColumn("requestId", "N° de la demande", true, null),
                        new DisplayColumn("type", "Type de la demande", true, null),
                        new DisplayColumn("requester.lastName", "Nom du demandeur", true, null),
                        new DisplayColumn("message", "Etat de l'import", true, null)};

        // Get a proxy instance of the xsd demand
        public static Object newInstance(RequestType xsdDemand) {
            XsdRequestRecord xsdRequestRecord = new XsdRequestRecord(xsdDemand);

                return Proxy.newProxyInstance(
                        xsdRequestRecord.getClass().getClassLoader(),
                        xsdRequestRecord.getClass().getInterfaces(),
                        xsdRequestRecord);
        }

        private XsdRequestRecord(RequestType xsdDemand) {
                super(null);
                this.xsdDemand = xsdDemand;

                id = new Long(nextid++);
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                        return method.invoke(this, args);
                } catch (Exception e) {
                        return method.invoke(xsdDemand, args);
                }
        }

        public Long getResultId() {
            return id;
        }
        
        public void load() {
        }

        public void loadPage(HashMap<Long,IResultRecord> results) {
        }

        public boolean isLoaded() {
            return false;
        }

        public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
                return importColumns;
        }

        public String getNavigateAction(PageContext pageContext) {
                ManagerWizardState wizardState = 
                    ManagerWizardState.getWizardState((HttpServletRequest)pageContext.getRequest());

                if (wizardState.getTabId() == null)
                        return "searchAction";

                else if (wizardState.getTabId().equals("import"))
                        return "importAction";

                return null;
        }

        public String getMessage() {
                return message;
        }

        public boolean isSelected() {
                return selected;
        }

        public void setMessage(String string) {
                message = string;
        }

        public void setSelected(boolean b) {
                selected = b;
        }

        public String getType() {
            ILocalizationService service = 
                (ILocalizationService)BusinessManager.getAc().getBean(ILocalizationService.SERVICE_NAME);
            String name = xsdDemand.getClass().getName();
            name = name.substring(0,name.indexOf("DocumentImpl"));
            name = name.replaceAll(".impl", "");
            type = service.getRequestLabelTranslation(name,"fr");
            if (type == null)
                    type = "Inconnue";

            return type;
        }

        public void setType(String string) {
                type = string;
        }

        public Long getRequestId() {
                return id;
        }

        public void setId(Long long1) {
                id = long1;
        }

        public RequestType getDemand() {
                return xsdDemand;
        }

}
