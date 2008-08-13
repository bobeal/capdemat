<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/cas.tld" prefix="cas"%>
<cas:logout var="netID" scope="session" logoutUrl="https://cvq1:8443/cas-cg95/logout" />

<logic:redirect href="index.jsp"/>