<html>
  <head>
  <title>CAS Client Plugin Page</title>
  </head>
  <body>
  <h1>
    <%
    session?.removeAttribute(fr.cg95.cvq.util.web.filter.CASFilter.CAS_FILTER_USER)
    session?.removeAttribute(fr.cg95.cvq.util.web.filter.CASFilter.CAS_FILTER_RECEIPT)
    session?.invalidate()
    if (org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_mocking) {
      response.sendRedirect("./cas.gsp")
    } else {
      response.sendRedirect(org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_logout_url)
    }
    %>    
    </h1>
  </body>
</html>
