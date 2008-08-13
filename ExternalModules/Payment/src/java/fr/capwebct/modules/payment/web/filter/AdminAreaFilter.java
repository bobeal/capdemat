package fr.capwebct.modules.payment.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.GenericFilterBean;

public class AdminAreaFilter extends GenericFilterBean {

    private static Log log = LogFactory.getLog(AdminAreaFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain fc) throws IOException, ServletException {

        // make sure we've got an HTTP request
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            log.error("doFilter() called on a request or response that was not an HttpServletRequest or response.");
            throw new ServletException("AdminAreaFilter only deals with HTTP resources");
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        String isAdmin = (String) session.getAttribute(UserExtractionFilter.IS_ADMIN);
        if (Boolean.valueOf(isAdmin)) {
            log.debug("doFilter() user is authorized to access admin area");
            fc.doFilter(request, response);
        } else {
            throw new ServletException("You are not authorized to access this resource !");
        }
    }
}
