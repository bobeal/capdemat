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
 package fr.cg95.cvq.bo.business;

/**
 * @author René le CLERCQ
 */
public interface IBusinessConstants {
	public final static String SCHOOL_UNKNOWN = "Inconnue";
	
	public final static String STATE_ARCHIVED = "Archivé";
	public final static String STATE_PENDING = "En attente";
	public final static String STATE_REFUSED = "Refusé";
	public final static String STATE_VALIDATED = "Validé";
	public final static String STATE_ABSENT = "Non fourni";
	public final static String STATE_CHECKED = "Verifié";
    public final static String STATE_OUTDATED = "Périmé";
    public final static String STATE_CERTIFIED = "Certifié";
    public final static String STATE_ENABLED = "Active";
    public final static String STATE_DISABLED = "Desactivé";
	
	public final static String TASK_DATA_LABEL = "Valider les données";
	public final static String TASK_DOCUMENTS_LABEL = "Valider les PJ";
	public final static String TASK_REQUEST_LABEL = "Valider la demande";
	public final static String TASK_CERTIFICATE_LABEL = "Envoyer l'attestation";
	
	public final static int USER_OK = 0;
	public final static int USER_UNKNOWN = 1;
	public final static int USER_ILLEGAL_PASSWORD = 2;
	
}
