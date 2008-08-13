<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE web-app PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN" "http://java.sun.com/dtd/web-app_2_3.dtd">
<web-app>
  <display-name>FrontOffice</display-name>

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
    <param-value>cvq.front_office.root</param-value>
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
      <param-value>frontOffice</param-value>
    </init-param>
  </filter>

  <filter>
    <filter-name>SiteAssetsFilter</filter-name>
    <filter-class>fr.cg95.cvq.fo.dispatcher.DispatchFilter</filter-class>
  </filter>

  <filter-mapping>
    <filter-name>hibernateFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  
  <filter-mapping>
    <filter-name>SiteAssetsFilter</filter-name>
    <url-pattern>/assets/common/*</url-pattern>
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWARD</dispatcher>
  </filter-mapping>
  
  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>

  <listener>
  	<listener-class>fr.cg95.cvq.fo.dispatcher.SessionManager</listener-class>
  </listener>

  <servlet>
    <servlet-name>context</servlet-name>
    <servlet-class>org.springframework.web.context.ContextLoaderServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet>
    <servlet-name>init</servlet-name>
    <servlet-class>fr.cg95.cvq.fo.dispatcher.StartupServlet</servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>lp7download</servlet-name>
    <servlet-class>fr.cg95.cvq.fo.dispatcher.Lp7Download</servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>action</servlet-name>
    <servlet-class>org.apache.struts.action.ActionServlet</servlet-class>
    <init-param>
      <param-name>config</param-name>
      <param-value>/WEB-INF/struts-config.xml</param-value>
    </init-param>
    <init-param>
      <param-name>debug</param-name>
      <param-value>2</param-value>
    </init-param>
    <init-param>
      <param-name>detail</param-name>
      <param-value>2</param-value>
    </init-param>
    <load-on-startup>3</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>debugjsp</servlet-name>
    <description>Ajouté pour compiler les JSP avec les informations de débogage</description>
    <servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
    <init-param>
      <param-name>classdebuginfo</param-name>
      <param-value>true</param-value>
    </init-param>
    <load-on-startup>4</load-on-startup>
  </servlet>

  <servlet>
    <servlet-name>plpass</servlet-name>
    <servlet-class>fr.cg95.cvq.fo.util.plpass</servlet-class>
    <load-on-startup>5</load-on-startup>
  </servlet>

<!-- Url retour is managed by a CGI script on the Apache server
  <servlet>
    <servlet-name>Payline_urlretour</servlet-name>
    <servlet-class>fr.cg95.cvq.fo.util.Payline_urlretour</servlet-class>
    <load-on-startup>6</load-on-startup>
  </servlet>
-->

<!--
  <servlet>
    <servlet-name>lasso</servlet-name>
    <servlet-class>fr.cg95.cvq.fo.util.LassoServlet</servlet-class>
    <load-on-startup>5</load-on-startup>
  </servlet>
-->
  <servlet-mapping>
    <servlet-name>lp7download</servlet-name>
    <url-pattern>/lp7/download</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>action</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>jsp</servlet-name>
    <url-pattern>*.jsp</url-pattern>
  </servlet-mapping>

  <servlet-mapping>
    <servlet-name>plpass</servlet-name>
    <url-pattern>/plpass</url-pattern>
  </servlet-mapping>

<!-- Url retour is managed by a CGI script on the Apache server
  <servlet-mapping>
    <servlet-name>Payline_urlretour</servlet-name>
    <url-pattern>/Payline_urlretour</url-pattern>
  </servlet-mapping>
-->
<!--
  <servlet-mapping>
    <servlet-name>lasso</servlet-name>
    <url-pattern>/lasso</url-pattern>
  </servlet-mapping>
-->
  <!-- 
  session-timeout defines in minutes the time that sessions will last at max.
  A number of 0 or less defines endless sessions.
  So here, the session timeout is 1 hour.
  -->

<!-- the timeout defined here should reflect the timeout defined in the process.xml and manager.xml -->
  <session-config>
    <session-timeout>60</session-timeout>
  </session-config>

  <welcome-file-list>
    <welcome-file>assets/common/jsp/welcome.jsp</welcome-file>
  </welcome-file-list>
  
  
    <error-page>
        <error-code>500</error-code>
        <location>/error.jsp</location>
    </error-page>
	
    <error-page>
        <error-code>400</error-code>
        <location>/error.jsp</location>
    </error-page>
	
	<error-page>
        <error-code>404</error-code>
        <location>/error.jsp</location>
    </error-page>

  <!-- The page to catch all the Exceptions which are not caught -->
  <error-page>
    <exception-type>java.lang.Throwable</exception-type>
    <location>/error.jsp</location>
  </error-page>

  <taglib>
    <taglib-uri>/tags/struts-bean</taglib-uri>
    <taglib-location>/WEB-INF/tld/struts-bean.tld</taglib-location>
  </taglib>

  <taglib>
    <taglib-uri>/tags/struts-html</taglib-uri>
    <taglib-location>/WEB-INF/tld/struts-html.tld</taglib-location>
  </taglib>

  <taglib>
    <taglib-uri>/tags/struts-logic</taglib-uri>
    <taglib-location>/WEB-INF/tld/struts-logic.tld</taglib-location>
  </taglib>

  <taglib>
    <taglib-uri>/tags/struts-cvq</taglib-uri>
    <taglib-location>/WEB-INF/tld/struts-cvq.tld</taglib-location>
  </taglib>

<!--
  <security-constraint>
    <web-resource-collection>
      <web-resource-name>All pages</web-resource-name>
      <url-pattern>*.do</url-pattern>
      <url-pattern>*.jsp</url-pattern>
      <url-pattern>*.generic</url-pattern>
    </web-resource-collection>
    <user-data-constraint>
      <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
  </security-constraint> 
-->

</web-app>
