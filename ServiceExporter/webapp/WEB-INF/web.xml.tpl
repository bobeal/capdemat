<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE web-app
    PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
    "http://java.sun.com/dtd/web-app_2_3.dtd">

<web-app>

  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
      /WEB-INF/applicationContext.xml,
      /WEB-INF/applicationContext-deployment.xml,
      /WEB-INF/applicationContext-serviceexporter.xml,
      classpath*:pluginContext.xml
    </param-value>
  </context-param>

  <context-param>
    <param-name>webAppRootKey</param-name>
    <param-value>cvq.service_exporter.root</param-value>
  </context-param>

  <context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>/WEB-INF/log4j.properties</param-value>
  </context-param>

  <filter>
    <filter-name>Hibernate Back Office Filter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.CvqOpenSessionInViewFilter</filter-class>
    <init-param>
      <param-name>context</param-name>
      <param-value>backOffice</param-value>
    </init-param>
  </filter>

  <filter>
    <filter-name>User Extraction Filter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.UserExtractionFilter</filter-class>
  </filter>

  <filter>
    <filter-name>Hibernate Front Office Filter</filter-name>
    <filter-class>fr.cg95.cvq.util.web.filter.CvqOpenSessionInViewFilter</filter-class>
    <init-param>
      <param-name>context</param-name>
      <param-value>frontOffice</param-value>
    </init-param>
  </filter>
	
  <filter>
    <filter-name>CAS Filter</filter-name>
    <filter-class>fr.cg95.cvq.exporter.filter.CASFilter</filter-class>
    <init-param>
      <param-name>validateUrl</param-name>
      <param-value>@cas_validate_url@</param-value>
    </init-param>
    <init-param>
      <param-name>serverNames</param-name>
      <param-value>@cas_server_names@</param-value>
    </init-param>
    <init-param>
      <param-name>authorizedProxies</param-name>
      <param-value>@cas_authorized_proxies@</param-value>
    </init-param>
  </filter>

  <filter-mapping>
    <filter-name>CAS Filter</filter-name>
    <url-pattern>/backoffice/*</url-pattern>
  </filter-mapping>

  <filter-mapping>
    <filter-name>Hibernate Back Office Filter</filter-name>
    <url-pattern>/backoffice/*</url-pattern>
  </filter-mapping>

  <filter-mapping>
    <filter-name>User Extraction Filter</filter-name>
    <url-pattern>/backoffice/*</url-pattern>
  </filter-mapping>

  <filter-mapping>
    <filter-name>Hibernate Front Office Filter</filter-name>
    <url-pattern>/frontoffice/*</url-pattern>
  </filter-mapping>
	
  <filter-mapping>
    <filter-name>Hibernate Back Office Filter</filter-name>
    <url-pattern>/external/*</url-pattern>
  </filter-mapping>

  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>

  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <servlet>
    <servlet-name>external</servlet-name>
    <servlet-class>org.springframework.ws.transport.http.MessageDispatcherServlet</servlet-class>
    <load-on-startup>2</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>external</servlet-name>
    <url-pattern>/external/*</url-pattern>
  </servlet-mapping>
    
</web-app>
