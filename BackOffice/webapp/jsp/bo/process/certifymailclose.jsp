<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
<head>
    <cvqw:baseref/>
</head>

<script language="javaScript">
	var sf = window.opener.document.forms[0];
	sf['lp7'].value = "<%=request.getParameter("file")%>";
	sf.submit();
	window.close();
</script>