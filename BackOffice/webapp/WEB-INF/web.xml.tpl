<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<web-app>
  <display-name>Cartevaloise</display-name>
  <description>Cartevaloise Process Instruction</description>

  <!-- path to Spring's application context -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
    		/WEB-INF/applicationContext.xml,
    		/WEB-INF/applicationContext-deployment.xml,
            classpath*:pluginContext.xml
    	</param-value>
  </context-param>

  <context-param>
    <param-name>webAppRootKey</param-name>
    <param-value>cvq.back_office.root</param-value>
  </context-param>

  <context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>/WEB-INF/log4j.properties</param-value>
  </context-param>

  <context-param>
    <param-name>applicationRevision</param-name>
    <param-value>@application.revision@</param-value>
  </context-param>

  <context-param>
    <param-name>applicationVersion</param-name>
    <param-value>@application.version@</param-value>
  </context-param>

  <filter>
    <filter-name>hibernateFilter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.CvqOpenSessionInViewFilter</filter-class>
    <init-param>
      <param-name>context</param-name>
      <param-value>backOffice</param-value>
    </init-param>
  </filter>

  <filter>
    <filter-name>SiteAssetsFilter</filter-name>
    <filter-class>fr.cg95.cvq.bo.dispatcher.DispatchFilter</filter-class>
  </filter>

  <filter>
    <filter-name>User Extraction Filter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.UserExtractionFilter</filter-class>
  </filter>

  <filter>
    <filter-name>CAS Filter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.CASFilter</filter-class>
    <init-param>
      <param-name>edu.yale.its.tp.cas.client.filter.loginUrl</param-name>
      <param-value>@cas_login_url@</param-value>
    </init-param>
    <init-param>
      <param-name>edu.yale.its.tp.cas.client.filter.validateUrl</param-name>
      <param-value>@cas_validate_url@</param-value>
    </init-param>
    <init-param>
      <param-name>edu.yale.its.tp.cas.client.filter.serverName</param-name>
      <param-value>@cas_server_names@</param-value>
    </init-param>
  </filter>

  <filter-mapping>
    <filter-name>CAS Filter</filter-name>
    <url-pattern>*.do</url-pattern>
  </filter-mapping>

  <filter-mapping>
    <filter-name>hibernateFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <filter-mapping>
    <filter-name>SiteAssetsFilter</filter-name>
    <url-pattern>/assets/img/*</url-pattern>
  </filter-mapping>
  
  <filter-mapping>
    <filter-name>User Extraction Filter</filter-name>
    <url-pattern>*.do</url-pattern>
  </filter-mapping>

  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>

  <listener>
  	<listener-class>fr.cg95.cvq.bo.dispatcher.HttpSessionEventListener</listener-class>
  </listener>
  
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <servlet>
    <servlet-name>init</servlet-name>
    <servlet-class>fr.cg95.cvq.bo.dispatcher.StartupServlet</servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>lp7</servlet-name>
    <servlet-class>fr.cg95.cvq.bo.dispatcher.Lp7Dispatcher</servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>logout</servlet-name>
    <servlet-class>fr.cg95.cvq.bo.dispatcher.CASLogoutServlet</servlet-class>
    <init-param>
      <param-name>edu.yale.its.tp.cas.client.servlet.logoutUrl</param-name>
      <param-value>@cas_logout_url@</param-value>
    </init-param>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>struts</servlet-name>
    <servlet-class>org.apache.struts.action.ActionServlet</servlet-class>
    <init-param>
      <param-name>application</param-name>
      <param-value>ApplicationResourcesBO</param-value>
    </init-param>
    <init-param>
      <param-name>config</param-name>
      <param-value>/WEB-INF/struts-config.xml</param-value>
    </init-param>
    <init-param>
      <param-name>debug</param-name>
      <param-value>3</param-value>
    </init-param>
    <init-param>
      <param-name>detail</param-name>
      <param-value>3</param-value>
    </init-param>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>logout</servlet-name>
    <url-pattern>/sso/logoutAction.do</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>struts</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.jsp</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>lp7</servlet-name>
    <url-pattern>/lp7/*</url-pattern>
  </servlet-mapping>

  <!-- 
  session-timeout defines in minutes the time that sessions will last at max.
  A number of 0 or less defines endless sessions.
  So here, the session timeout is 1 hour.
  -->
  <session-config>
    <session-timeout>60</session-timeout>
  </session-config>

  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>


  <!-- The page to catch all the Exceptions which are not caught -->
  <error-page>
    <exception-type>java.lang.Throwable</exception-type>
    <location>/errorAction.do</location>
  </error-page>

  <!-- Defining the different used taglibs -->

  <taglib>
    <taglib-uri>/tags/struts-bean</taglib-uri>
    <taglib-location>/WEB-INF/struts-bean.tld</taglib-location>
  </taglib>

  <taglib>
    <taglib-uri>/tags/struts-html</taglib-uri>
    <taglib-location>/WEB-INF/struts-html.tld</taglib-location>
  </taglib>

  <taglib>
    <taglib-uri>/tags/struts-logic</taglib-uri>
    <taglib-location>/WEB-INF/struts-logic.tld</taglib-location>
  </taglib>

  <security-constraint>
    <web-resource-collection>
      <web-resource-name>All pages</web-resource-name>
      <url-pattern>*.do</url-pattern>
      <url-pattern>*.jsp</url-pattern>
    </web-resource-collection>
    <user-data-constraint>
      <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
  </security-constraint> 

</web-app>
