import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean
import fr.cg95.cvq.dao.hibernate.HibernateUtil
import javax.servlet.ServletException
import org.hibernate.SessionFactory

public class PerformanceSessionFilters {
    def filters = {
        openSessions (controller: '(performance)', action: '*') {
            before = {
                ILocalAuthorityRegistry localAuthorityRegistry =
                applicationContext.getBean("localAuthorityRegistry")
                LocalAuthority la = localAuthorityRegistry.getLocalAuthorityByServerName(request.serverName)
                if (la == null)
                    throw new ServletException("No local authority found !")
                LocalAuthorityConfigurationBean lacb =
                    localAuthorityRegistry.getLocalAuthorityBeanByName(la.name)
                if (lacb == null)
                    throw new ServletException("No local authority found !")
                SessionFactory sessionFactory = lacb.getSessionFactory()
                HibernateUtil.setSessionFactory(sessionFactory)

                HibernateUtil.beginTransaction()

                try {
                    SecurityContext.setCurrentSite(lacb.getName(),
                            SecurityContext.BACK_OFFICE_CONTEXT)
                    SecurityContext.setCurrentLocale(request.getLocale())
                } catch (CvqException ce) {
                    ce.printStackTrace()
                    throw new ServletException()
                }

                session.setAttribute("currentSiteName", lacb.getName().toLowerCase())
                session.setAttribute("doRollback", false)
            }
            after = {
                def doRollback = session.getAttribute("doRollback")
                if (doRollback)
                    HibernateUtil.rollbackTransaction();
                else
                    HibernateUtil.commitTransaction();
                // No matter what happens, close the Session.
                HibernateUtil.closeSession();

                SecurityContext.resetCurrentSite();
            }
        }
    }
}