<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import = "fr.cg95.cvq.fo.util.Constants" %>

<html>
  <head>
    <title>WebCT-Démat</title>
  </head>
  <script for="window" event="onunload">
	  window.opener.f_zoom=null;
  </script>
  <body bgcolor="#ffffff">
    <img src="<%=(String) request.getParameter(Constants.URL)%>" width="420" height="594" />
  </body>
</html>

