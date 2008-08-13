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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.jsp.PageContext;

/**
 * @author René le CLERCQ
 */
public class TaskRecord implements IResultRecord {

	private static final long serialVersionUID = 3713098202626888391L;
	
	private Long id;
	private String label;
	private int state;
	private String observations;
	
	private TreeMap<String, TaskRecord> details = new TreeMap<String, TaskRecord>();
	private long detailId = 1;
	
	public TaskRecord(Long id, String label, int state, String observations) {
		this.id = id;
		this.label = label;
		this.state = state;
		this.observations = observations;
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

	public void addDetail(String label, String observations) {
		details.put(label,new TaskRecord(detailId++, label, 0, observations));
	}
	
	public void removeDetail(String label) {
		details.remove(label);
	}
	
	public List<TaskRecord> getDetails() {
		List<TaskRecord> list = new ArrayList<TaskRecord>(details.values());
		Collections.sort(list, new CompareTasks<TaskRecord>());
		return list;
	}
	
	/**
	 */
	public Long getId() {
		return id;
	}

	/**
	 */
	public String getLabel() {
		return label;
	}

	/**
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 */
	public int getState() {
		return state;
	}

	/**
	 */
	public void setId(long i) {
		id = i;
	}

	/**
	 */
	public void setLabel(String string) {
		label = string;
	}

	/**
	 */
	public void setObservations(String string) {
		observations = string;
	}

	/**
	 */
	public void setState(int i) {
		state = i;
	}

	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return null;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

}

class CompareTasks<T> implements Comparator<T> {
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object o1, Object o2) {
		TaskRecord task1 = null;
		TaskRecord task2 = null;

		if (o1 instanceof TaskRecord)
			task1 = (TaskRecord)o1;
			
		if (o2 instanceof TaskRecord)
			task2 = (TaskRecord)o2;
			
		if ((task1 == null) || (task2 == null))
			throw new ClassCastException("Object not a TaskRecord");
			
		if (task1.getId() < task2.getId())
			return -1;
						
		if (task1.getId() == task2.getId())
			return 0;
						
		return 1;
	}

}
