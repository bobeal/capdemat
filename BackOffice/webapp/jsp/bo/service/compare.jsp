<%@ page contentType="text/html; charset=UTF-8" %>

<frameset rows="50%,50%">
<%request.getSession().setAttribute("url1",request.getParameter("url1"));%>
	<frame src="compareform.jsp?compare">
	<frame src="<%=(String) request.getParameter("url2")%>" name="url2">
</frameset>
