<html>
  <head>
    <title>Welcome to Grails</title>
	 <meta name="layout" content="main" />
  </head>
  <body>
	 	<% 
    if (org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_mocking
      && session?.getAttribute(fr.cg95.cvq.util.web.filter.CASFilter.CAS_FILTER_USER) == null) {
      response.sendRedirect("./cas.gsp");
    } else {
      response.sendRedirect("request"); 
    }  
    %>
  </body>
</html>
