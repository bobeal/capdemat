/*
 * Cartevaloise 
 *
 * Copyright (C) 2004, 2005 Conseil Gï¿œnï¿œral du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by 
 *        Bruno Perrin, Philippe Usclade and Renï¿œ le Clercq 
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.bo.AmountFormatterHelper;

/**
 * @author Renï¿œ le CLERCQ
 */
public class PaymentRecord implements IResultRecord, Comparable {

    private static final long serialVersionUID = 1L;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("'le' dd/MM/yy 'à' HH:mm");

	private Date initializationDate;
	private String formattedInitializationDate;
    private Date commitDate;
    private String formattedCommitDate;
    private String state;
    private String cvqReference;
    private String bankReference;
    private String broker;
    private Long homeFolderId;
	private String value;

    private DisplayColumn paymentColumns[] =
    {
        new DisplayColumn("initializationDate", "Date d'initialisation", false, null),
        new DisplayColumn("commitDate", "Date de terminaison", false, null),
        new DisplayColumn("state", "Etat", false, null),
        new DisplayColumn("cvqReference", "Référence CapDémat", false, null),
        new DisplayColumn("bankReference", "Référence bancaire", false, null),
        new DisplayColumn("broker", "Régie", false, null),
        new DisplayColumn("homeFolderId", "Foyer", false, null),
        new DisplayColumn("value", "Montant", false, null)
    };


    public PaymentRecord(Date initializationDate, Date commitDate, String state, 
            String cvqReference, String bankReference, String broker, Long homeFolderId,
            int value) {
		this.initializationDate = initializationDate;
		this.formattedInitializationDate = dateFormat.format(initializationDate);
		this.commitDate = commitDate;
        this.formattedCommitDate = (commitDate == null) ? "" : dateFormat.format(commitDate);
        this.state = state; 
        this.cvqReference = cvqReference;
        this.bankReference = bankReference;
        this.broker = broker;
        this.homeFolderId = homeFolderId;
		this.value = AmountFormatterHelper.formatPrice(value);
	}

	public String getInitializationDate() {
		return formattedInitializationDate;
	}

    public String getCommitDate() {
        return formattedCommitDate;
    }
    
    public final String getBankReference() {
        return bankReference;
    }

    public final String getBroker() {
        return broker;
    }

    public final String getCvqReference() {
        return cvqReference;
    }

    public final Long getHomeFolderId() {
        return homeFolderId;
    }

    public final String getState() {
        return state;
    }

    public String getValue() {
		return value;
	}

	public int compareTo(Object o) {
		if (o instanceof PaymentRecord)
			return -initializationDate.compareTo(((PaymentRecord) o).initializationDate);
		return 0;
	}

    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        return paymentColumns;
    }

    public String getNavigateAction(PageContext pageContext) {
        return "paymentsAction";
    }

    public Long getResultId() {
        return null;
    }
    
    public void load() {
    }

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

}
