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
package fr.cg95.cvq.bo.dispatcher;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 */
public class SessionTimeoutFilter implements Filter {

	private String timeoutPage = null;

	/**
	 */
	public SessionTimeoutFilter() {
		super();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		timeoutPage = config.getInitParameter("redirect");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		
			if (request instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest)request;
				if (req.getSession(false) == null) {
					HttpServletResponse res = (HttpServletResponse)response;
					res.sendRedirect("/"); 
				}
			}
			chain.doFilter(request,response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	public String getTimeoutPage() {
		return timeoutPage;
	}

	public void setTimeoutPage(String string) {
		timeoutPage = string;
	}

}
