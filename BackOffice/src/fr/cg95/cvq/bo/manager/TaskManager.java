/*
 * Cartevaloise 
 *
 * Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Developed by René le Clercq. 
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
package fr.cg95.cvq.bo.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.IBusinessConstants;
import fr.cg95.cvq.bo.record.TaskRecord;

/**
 */
public class TaskManager implements Serializable {
	
	private static final long serialVersionUID = -6917014809539598509L;
	
	public static final Long TASK_DATA = new Long(1);
	public static final Long TASK_DOCUMENTS = new Long(2);
	public static final Long TASK_REQUEST = new Long(3);
	public static final Long TASK_CERTIFICATE = new Long(4);
	 
	TreeMap<Long,TaskRecord> tasks = new TreeMap<Long,TaskRecord>();
	
	public TaskManager() {
	}

	public void addTask(TaskRecord task) {
		tasks.put(task.getId(),task);
	}
		
	public TaskRecord addTask(Long id, String label, int state, String observations) {
		TaskRecord task = new TaskRecord(id, label, state, observations);
		
		addTask(task);
		
		return task;
	}
	
	public TaskRecord getTask(Long id) {
		return (TaskRecord)tasks.get(id);
	}
	
	public TaskRecord removeTask(Integer id) {
		return (TaskRecord)tasks.remove(id);
	}
	
	public ArrayList<TaskRecord> getAll() {
		return new ArrayList<TaskRecord>(tasks.values());
	}
	
	public int size() {
		return tasks.size();
	}
	
	public void updateTask(Long id, String state) {
		TaskRecord task = getTask(id);
		if (task != null) {
			if (id.equals(TASK_CERTIFICATE)) {
				task.setState(1);
				task.setObservations(state);
			}	else if (!display(state)) {
				task.setState(0);
				task.setObservations("");
			} else {
				task.setState(1);
				task.setObservations(state);
			}
		}
	}
	
	public void updateTask(Long id, String state, String detail, int total) {
		TaskRecord task = getTask(id);
		if (task != null) {
			if (!display(state))
				task.removeDetail(detail);
			else
				task.addDetail(detail, state);

			if (task.getDetails().size() == total)
				task.setState(1);
			else
				task.setState(0);
			
			if ((task.getDetails().size() == 0) || (task.getDetails().size() == total))
				task.setObservations("");
			else
				task.setObservations(task.getDetails().size() + " sur " + total);
		}
	}
	
	private boolean display(String state) {
		if (state == null)
			return false;
			
		if (state.equals(IBusinessConstants.STATE_PENDING))
			return false;
			
		if (BusinessDictionary.getRequestState(state) != null)
			return true;
			
		if (BusinessDictionary.getDocumentState(state) != null)
			return true;
			
		if (BusinessDictionary.getDataState(state) != null)
			return true;
			
		return false;
	}
	
}
