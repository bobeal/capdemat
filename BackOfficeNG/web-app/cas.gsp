<%
if (org.codehaus.groovy.grails.commons.ConfigurationHolder.config.cas_mocking) {
%>
<html>
	<head>
	<title>Page d'authentification CAS "mock"</title>
	</head>
	<body>
    <div style="float:left;display:inline;">
     <img alt="Zenexity Lab" src="${createLinkTo(dir:'fong/images',file:'logo_zen_200.png')}"/>
    </div>
    <span style="float:right;">
      <img alt="Conseil Général du Val d'Oise" src="${createLinkTo(dir:'images',file:'logoBoVo.gif')}" />
    </span>
    <div style="clear:both;">&nbsp;</div>
    <h1>Bienvenue sur le site de démonstration des nouvelles interfaces de CapDémat</h1>
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
      out.println("<h2><a href='./request'>Accéder au Back Office</a></h2>")
    } else {
    %>
   		<h2>Merci de choisir un profil d'utilisateur :</h2>
      <ul>
        <li><a href='./cas.gsp?login=admin.valdoise'>Suivez ce lien</a> pour vous connecter en tant qu'administrateur</li>
        <li><a href='./cas.gsp?login=agent.valdoise'>Suivez ce lien</a> pour vous connecter en tant qu'agent</li>
      </ul>
      <g:render template="/shared/news" />
    <%
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