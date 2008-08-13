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
package fr.cg95.cvq.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 */
public class TwoWayMap extends HashMap {

    /**
     * 
     */
    private static final long serialVersionUID = -8117914182235940976L;

    private Vector values = new Vector();
    
    /**
	 */
	public TwoWayMap() {
		super();
	}

	/**
	 */
	public TwoWayMap(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 */
	public TwoWayMap(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 */
	public TwoWayMap(Map m) {
		super(m);
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public Object put(Object key, Object value) {
	    values.add(value);
		super.put(value, key);
		
		return super.put(key, value);
	}

    public Collection getOneWayValues() {
        return values;
    }

}
