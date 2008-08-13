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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import fr.cg95.cvq.bo.manager.StateManager;
import fr.cg95.cvq.bo.record.PaperRecord;
import fr.cg95.cvq.bo.record.RequestRecord;

/**
 * @author René le CLERCQ
 */
public class SaveForm extends ActionForm {
	
	private static final long serialVersionUID = -7604471918758218208L;

	RequestRecord record = null;

	private String check;
	private String deliver;
	private String send;
	private String print;
	
	private String state;
	private String expirationDate;
	private String notify;
	private String instructionInternal;
	private String instructionExternal;
	private String deliveryInternal;
	private String deliveryExternal;
	private String certificat;
	private String contact;
	private String mail;
	private FormFile file;

    private String mobilePhone;
    private boolean sendSms;
    
    private String lp7 = null;
    private String attachment = null;
    
    private boolean enabled = false;
    private boolean archived = false;
    private String familyQuotient;
    
    public SaveForm() {
		super();
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setExpirationDate(String string) {
		expirationDate = string;
	}

	public void setState(String string) {
		state = string;
	}

	public String getPrint() {
		return print;
	}

	public void setPrint(String string) {
		print = string;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		StateManager stateManager = (StateManager)request.getSession().getAttribute(StateManager.STATE_MANAGER);

        print = null;
        send = null;
        if (stateManager.getSelectedRecord() instanceof RequestRecord) {
    		this.record = (RequestRecord)stateManager.getSelectedRecord();
    		
    		PaperRecord paper = (PaperRecord)record.getSelectedPaper();
    		if (paper != null)
    			expirationDate = paper.getExpirationDate();
    			 
    		print = record.getNotify();
    		instructionInternal = record.getInstructionInternal();
    		instructionExternal = record.getInstructionExternal();
    		deliveryInternal = record.getDeliveryInternal();
    		deliveryExternal = record.getDeliveryExternal();
    		mail = record.getEMail();
            mobilePhone = record.getMobilePhone();
        }		
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String string) {
		notify = string;
	}

	public String getDeliveryExternal() {
		return deliveryExternal;
	}

	public String getDeliveryInternal() {
		return deliveryInternal;
	}

	public String getInstructionExternal() {
		return instructionExternal;
	}

	public String getInstructionInternal() {
		return instructionInternal;
	}

	public void setDeliveryExternal(String string) {
		deliveryExternal = string;
	}

	public void setDeliveryInternal(String string) {
		deliveryInternal = string;
	}

	public void setInstructionExternal(String string) {
		instructionExternal = string;
	}

	public void setInstructionInternal(String string) {
		instructionInternal = string;
	}

	public String getCertificat() {
		return certificat;
	}

	public String getContact() {
		return contact;
	}

	public void setCertificat(String string) {
		certificat = string;
	}

	public void setContact(String string) {
		contact = string;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String string) {
		mail = string;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String string) {
		send = string;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

    public String getLp7() {
        return lp7;
    }

    public void setLp7(String lp7) {
        this.lp7 = lp7;
        if ((lp7 != null) && (lp7.length() > 0))
            this.attachment = lp7;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFamilyQuotient() {
        return familyQuotient;
    }

    public void setFamilyQuotient(String familyQuotient) {
        this.familyQuotient = familyQuotient;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean isSendSms() {
        return sendSms;
    }

    public void setSendSms(boolean sendSms) {
        this.sendSms = sendSms;
    }

}
