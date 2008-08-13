<%@ page contentType="text/html; charset=UTF-8" %>

<script for=window event=onload>
	window.print();
	window.close();
</script>
<frameset rows="50%">
	<frame src="<%=(String) request.getParameter("url")%>" name="url">
</frameset>
