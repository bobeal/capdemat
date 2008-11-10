<%
if (org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_mocking) {
%>
<html>
	<head>
	<title>Page d'authentification CAS "mock"</title>
	</head>
	<body>
    <%
		def login = request.getParameter('login')
		if (login) {
      def userInfo
      if (login == "admin.valdoise")
        userInfo = "username=${login};localAuthority=valdoise;group=CVQ_ADMINISTRATORS"
      else
        userInfo = "username=${login};localAuthority=valdoise;group=CVQ_CONTRIBUTORS"       
			session?.setAttribute(fr.cg95.cvq.util.web.filter.CASFilter.CAS_FILTER_USER, userInfo)
   		out.println("L'utilisateur courant est [${userInfo}].")
      out.println("<h2><a href='./request'>Continuer</a></h2>")
    } else {
   		out.println("Merci de renseigner un paramètre 'login'!<br>")
      out.println("login=admin.valdoise pour se connecter en tant qu'administrateur<br>")
      out.println("login=agent.valdoise pour se connecter en tant qu'agent<br>")
    }
    %>
	</body>
</html>
<%
}
else {
	response.sendError(javax.servlet.http.HttpServletResponse.SC_NOT_FOUND)
}
%>