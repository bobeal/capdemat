package fr.cg95.cvq.util.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;

/**
 * A servlet filter that opens and closes a Hibernate Session for each request.
 * <p>
 * This filter guarantees a sane state, committing any pending database
 * transaction once all other filters (and servlets) have executed. It also
 * guarantees that the Hibernate <tt>Session</tt> of the current thread will
 * be closed before the response is send to the client.
 * <p>
 * Use this filter for the <b>session-per-request</b> pattern and if you are
 * using <i>Detached Objects</i>.
 *
 * @see HibernateUtil
 * @author Christian Bauer <christian@hibernate.org>
 */
public class CvqOpenSessionInViewFilter extends GenericFilterBean {

	private static Logger logger = Logger.getLogger(CvqOpenSessionInViewFilter.class);

    private String context;

    /**
     * To keep trace of the tx rollback status
     */
    private static ThreadLocal<Boolean> txRollback = new ThreadLocal<Boolean>();

    public CvqOpenSessionInViewFilter() {
        addRequiredProperty("context");
    }
    
	public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain) throws IOException, ServletException {
		
        try {
            
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");

            logger.debug("doFilterInternal() got server name : " + request.getServerName());
            WebApplicationContext wac = 
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
            ILocalAuthorityRegistry localAuthRegistry = 
                (ILocalAuthorityRegistry) wac.getBean("localAuthorityRegistry");
            LocalAuthority la = localAuthRegistry.getLocalAuthorityByServerName(request.getServerName());
            if (la == null)
                throw new ServletException("No local authority found !");
            LocalAuthorityConfigurationBean lacb =
                localAuthRegistry.getLocalAuthorityBeanByName(la.getName());
            if (lacb == null)
                throw new ServletException("No local authority found !");
            SessionFactory sessionFactory = lacb.getSessionFactory();
            HibernateUtil.setSessionFactory(sessionFactory);
            
            HibernateUtil.beginTransaction();
            
            txRollback.set(Boolean.FALSE);

            try {
                SecurityContext.setCurrentSite(lacb.getName(), context);
                SecurityContext.setCurrentLocale(request.getLocale());
                
                if (context.equals(SecurityContext.FRONT_OFFICE_CONTEXT)) {
                    if (((HttpServletRequest) request).getHeader("ecitizenName") != null) {
                        SecurityContext.setCurrentEcitizen(((HttpServletRequest)request).getHeader("ecitizenName"));
                    }
                }
            } catch (CvqException ce) {
                logger.error("Error while setting current site");
                ce.printStackTrace();
                throw new ServletException();
            }

            // set in session to be used by GUIWizard and webapps
            ((HttpServletRequest) request).getSession().setAttribute("currentSiteName", lacb.getName().toLowerCase());

			chain.doFilter(request, response);

            Boolean doRollback = (Boolean) txRollback.get();
            logger.debug("doFilter() Tx rollback status : " + doRollback.booleanValue());
            if (doRollback.booleanValue()) {
                HibernateUtil.rollbackTransaction();
            } else {
                HibernateUtil.commitTransaction();
            }
		} finally {

            txRollback.set(null);
            
			// No matter what happens, close the Session.
            HibernateUtil.closeSession();

            SecurityContext.resetCurrentSite();
		}
	}

	public void destroy() {}

    /**
     * Set the rollback status of the transaction. Called by
     * {@link fr.cg95.cvq.util.web.struts.CvqExceptionHandler} when an exception is raised during the
     * processing of a (HTTP) request
     */
    public static void setRollbackTx(boolean rb) {
        logger.debug("setRollbackTx() setting rollback status to " + rb);
        txRollback.set(Boolean.valueOf(rb));
    }

    public void setContext(final String context) {
        this.context = context;
    }
}