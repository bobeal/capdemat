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
package fr.cg95.cvq.bo.form;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.manager.ProfileManager;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.bo.record.CategoryRecord;
import fr.cg95.cvq.bo.record.RequestTypeRecord;
import fr.cg95.cvq.bo.record.UserRecord;
import fr.cg95.cvq.wizard.StringUtils;

/**
 * @author René le CLERCQ
 */
public class AdminForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = -5033288782489080634L;

    private ArrayList<CategoryRecord> categories;

    private ArrayList<UserRecord> users;

    private ArrayList<RequestTypeRecord> rtypes;

    private CategoryRecord category = null;

    private UserRecord user = null;

    private Long categoryId;

    private String categoryName;

    private String categoryEmail;

    private Long userId;

    private String login;

    private String firstName;

    private String lastName;

    private String profile;

    private String password;

    private String saveChoice;

    private String deleteChoice;

    private String createChoice;

    /**
     */
    public AdminForm() {
        super();
    }

    public void init(RequestManager requestManager) {
        if (categories == null) {
            categories = BusinessManager.getCategories(true);
            users = BusinessManager.getUsers();
            rtypes = BusinessDictionary.getRequestTypeRecords(requestManager, false);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        if (rtypes != null)
            for (int i = 0; i < rtypes.size(); i++)
                rtypes.get(i).reset();

        if (categories != null)
            for (int i = 0; i < categories.size(); i++)
                categories.get(i).reset();

        super.reset(mapping, request);
    }

    private void reset() {
        saveChoice = null;
        deleteChoice = null;
        if (category != null) {
            categoryId = category.getId();
            categoryName = category.getName();
            categoryEmail = category.getEMail();
        } else {
            categoryId = new Long(0);
            categoryName = "";
            categoryEmail = "";
            updateCategoryTypes(category);
            updateCategoryUsers(category);
        }

        if (user != null) {
            userId = user.getId();
            login = user.getLogin();
            firstName = user.getFirstName();
            lastName = user.getLastName();
            password = user.getPassword();
            profile = user.getProfile();
        } else {
            userId = new Long(0);
            login = "";
            firstName = "";
            lastName = "";
            password = "";
            profile = "";
            updateUserCategories(user);
        }
    }

    public void setSelection(String state, String index) {
        int id = (index == null) ? 0 : Integer.parseInt(index);

        if ((state == null)) {
            if ((index == null) && (state == null)) {
                category = null;
                user = null;
            }
        } else if (state.equals("categories")) {
            if ((index != null) || (category == null))
                if (id < categories.size())
                    category = categories.get(id);

            updateCategoryTypes(category);
            updateCategoryUsers(category);
        } else if (state.equals("users")) {
            if ((index != null) || (user == null))
                if (id < users.size())
                    user = users.get(id);

            updateUserCategories(user);
        }
        reset();
    }

    private void updateUserCategories(UserRecord user) {
        for (int i = 0; i < categories.size(); i++) {
            CategoryRecord categoryRecord = categories.get(i);

            if (user != null) {
                categoryRecord
                        .setRO(user.getCategoryProfile(categoryRecord.getId()) == ProfileManager.PROFILE_RO);
                categoryRecord
                        .setRW(user.getCategoryProfile(categoryRecord.getId()) == ProfileManager.PROFILE_RW);
                categoryRecord
                        .setManager(user.getCategoryProfile(categoryRecord.getId()) == ProfileManager.PROFILE_MANAGER);
            } else {
                categoryRecord.setRO(false);
                categoryRecord.setRW(false);
                categoryRecord.setManager(false);
            }
        }
    }

    private void updateCategoryUsers(CategoryRecord category) {
        for (int i = 0; i < users.size(); i++) {
            UserRecord userRecord = users.get(i);

            if (category != null) {
                userRecord
                        .setRO(userRecord.getCategoryProfile(category.getId()) == ProfileManager.PROFILE_RO);
                userRecord
                        .setRW(userRecord.getCategoryProfile(category.getId()) == ProfileManager.PROFILE_RW);
                userRecord
                        .setManager(userRecord.getCategoryProfile(category.getId()) == ProfileManager.PROFILE_MANAGER);
            } else {
                userRecord.setRO(false);
                userRecord.setRW(false);
                userRecord.setManager(false);
            }
        }
    }

    private void updateCategoryTypes(CategoryRecord category) {
        for (int i = 0; i < rtypes.size(); i++) {
            RequestTypeRecord typeRecord = rtypes.get(i);

            if (category != null)
                typeRecord.setTreated(category.getId().equals(typeRecord.getCategoryId()));
            else
                typeRecord.setTreated(false);
        }
    }

    public void addUser(UserRecord userRecord) {
        users.add(userRecord);
        user = userRecord;
    }

    public void addCategory(CategoryRecord categoryRecord) {
        categories.add(categoryRecord);
        category = categoryRecord;
    }

    public void updateCategory(CategoryRecord categoryRecord) {
        int indexToRemove = -1;
        for (int i = 0; i < categories.size(); i++) {
            CategoryRecord tempCategory = categories.get(i);
            if (tempCategory.getId().intValue() == categoryRecord.getId().intValue()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove >= 0) {
            categories.remove(indexToRemove);
            categories.add(indexToRemove, categoryRecord);
        } else {
            categories.add(categoryRecord);
        }

        category = categoryRecord;
        categoryId = categoryRecord.getId();
        categoryName = categoryRecord.getName();
        categoryEmail = categoryRecord.getEMail();
    }

    public void deleteSelectedCategory() {
        int indexToRemove = -1;
        for (int i = 0; i < categories.size(); i++) {
            CategoryRecord tempCategory = categories.get(i);
            if (tempCategory.getId().intValue() == categoryId.intValue()) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove >= 0) {
            categories.remove(indexToRemove);
        }

        category = null;
        reset();
    }

    public ArrayList<CategoryRecord> getCategories() {
        return categories;
    }

    public ArrayList<UserRecord> getUsers() {
        return users;
    }

    public void setCategories(ArrayList<CategoryRecord> list) {
        categories = list;
    }

    public void setUsers(ArrayList<UserRecord> list) {
        users = list;
    }

    public CategoryRecord getCategory() {
        return category;
    }

    public UserRecord getUser() {
        return user;
    }

    public void setCategory(CategoryRecord record) {
        category = record;
    }

    public void setUser(UserRecord record) {
        user = record;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getProfile() {
        if ((profile == null) || (profile.length() == 0))
            profile = ProfileManager.PROFILE_STRING_RW;
        return profile;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryEmail() {
        return categoryEmail;
    }

    public void setFirstName(String string) {
        firstName = string;
    }

    public void setLastName(String string) {
        lastName = string;
    }

    public void setProfile(String string) {
        profile = string;
    }

    public void setCategoryName(String string) {
        categoryName = string;
    }

    public void setCategoryEmail(String categoryEmail) {
        this.categoryEmail = categoryEmail;
    }

    public ArrayList<RequestTypeRecord> getRtypes() {
        return rtypes;
    }

    public void setRtypes(ArrayList<RequestTypeRecord> list) {
        rtypes = list;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setCategoryId(Long long1) {
        categoryId = long1;
    }

    public void setUserId(Long long1) {
        userId = long1;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String string) {
        password = string;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayLogin(String maxDisplayLength) {
        try {
            int maxChars = Integer.parseInt(maxDisplayLength);
            return StringUtils.split(login, maxChars);
        } catch (NumberFormatException e) {
        } 
        return login;
    }

    public void setLogin(String string) {
        login = string;
    }

    public String getDeleteChoice() {
        return deleteChoice;
    }

    public void setDeleteChoice(String delete) {
        this.deleteChoice = delete;
    }

    public String getSaveChoice() {
        return saveChoice;
    }

    public void setSaveChoice(String save) {
        this.saveChoice = save;
    }

    public final String getCreateChoice() {
        return createChoice;
    }

    public final void setCreateChoice(String createChoice) {
        this.createChoice = createChoice;
    }

}
