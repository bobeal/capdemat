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


import java.util.HashMap;

import javax.servlet.jsp.PageContext;

/**
 * @author René le CLERCQ
 */
public class CategoryRecord implements IResultRecord {

        private static final long serialVersionUID = -7172307582650455026L;

        private Long id;
        private String name;
        private String eMail;
        private boolean RO = false;
        private boolean RW = false;
        private boolean manager = false;

        private DisplayColumn adminServiceColumns[] =
                {
                        new DisplayColumn("name", "Nom de la catégorie", false, null),
                        new DisplayColumn("RO", "R", "check", false, null),
                        new DisplayColumn("RW", "R/W", "check", false, null),
                        new DisplayColumn("manager", "M", "check", false, null)};

        /**
         */
        public CategoryRecord() {
                super();
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

        public void reset() {
                RO = false;
                RW = false;
                manager = false;
        }

        public String getName() {
                return name;
        }

        public void setName(String string) {
                name = string;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long long1) {
                id = long1;
        }

        public boolean isRO() {
                return RO;
        }

        public boolean isRW() {
                return RW;
        }

        public void setRO(boolean b) {
                RO = b;
        }

        public void setRW(boolean b) {
                RW = b;
        }

        public String getEMail() {
                return eMail;
        }

        public void setEMail(String string) {
                eMail = string;
        }

        public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
                return adminServiceColumns;
        }

        public String getNavigateAction(PageContext pageContext) {
                return null;
        }

        public boolean isManager() {
            return manager;
        }

        public void setManager(boolean manage) {
            this.manager = manage;
        }

}
