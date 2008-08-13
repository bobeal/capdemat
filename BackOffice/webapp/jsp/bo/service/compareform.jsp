<%@ page contentType="text/html; charset=UTF-8" %>

<!-- <%= (String)request.getSession().getAttribute("url1") %> -->
<%
			String baseref = request.getScheme() + "://" + request.getServerName();
			if (request.getScheme().equals("http") && (request.getServerPort() == 80));
			else if (request.getScheme().equals("https") && (request.getServerPort() == 443));
			else
				baseref += ":" + request.getServerPort();
			baseref += request.getContextPath() +"/";
%>

<head>
	<base href="<%=baseref%>"/>
	<title>CVQ - Ville de Conseil Général de Val d'Oise</title>

	<style type="text/css" media="all">
      @import "css/layout.css";
      @import "css/common.css";
      @import "css/content.css";

	</style>
</head>

  <div class="form_block">

    <div class="grid_cell">
      <div class="block004">
    <hr class="hr001" />
        <jsp:include page="<%= (String)request.getSession().getAttribute("url1") %>"/>
      </div>
    </div>

  </div>
