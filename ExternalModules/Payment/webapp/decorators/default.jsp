<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
        
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title><decorator:title default="Service de paiement"/></title>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Conseil Général, Val d'Oise, CapDémat, CapWebCT" />
    <meta name="description"
          content="Page d'administration du module de paiement de CapDémat" />
    
    <!-- Grid and common settings CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/yui/reset-fonts-grids.css"/>" />
    <!-- Panel CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/yui/container.css"/>" />
    <!-- Data Table CSS (default YUI Sam Skin) --> 
	<link href="<c:url value="/css/yui/datatable.css"/>" type="text/css" rel="stylesheet"/>
    <!-- Button CSS -->
    <link href="<c:url value="/css/yui/button.css"/>" rel="stylesheet" type="text/css" />
    <!--  Autocomplete CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/autocomplete.css"/>" />
    <!-- Customized CSS Menu -->
    <link href="<c:url value="/css/menu.css"/>"  rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/css/form.css"/>" type="text/css" rel="stylesheet" />
    <link href="<c:url value="/css/common.css"/>" type="text/css" rel="stylesheet" />
    
    <!-- Panel, Menu, Button and Data Table JS --> 
    <script type="text/javascript" src="<c:url value="/js/yui/yahoo-dom-event.js"/>"></script>
	<!--  Drag&Drop of JS Panel -->
    <script type="text/javascript" src="<c:url value="/js/yui/dragdrop-min.js"/>"></script>
    <!--  Panel and Dialog JS, Dependency for Menu JS -->
    <script type="text/javascript" src="<c:url value="/js/yui/container-min.js"/>"></script>
    <!-- Menu JS -->
    <script type="text/javascript" src="<c:url value="/js/yui/menu-min.js"/>"></script>
    <!--  Button and Data Table JS -->
    <script type="text/javascript" src="<c:url value="/js/yui/element-beta-min.js"/>"></script> 
    <!--  Data Table JS -->
	<script type="text/javascript" src="<c:url value="/js/yui/datasource-beta-min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/yui/datatable-beta-min.js"/>"></script> 
	<!-- Dependency for Event, Connection Manager -->  
	<script type="text/javascript" src="<c:url value="/js/yui/yahoo-min.js"/>"></script> 
	<!-- Event JS (for loading of Data Table and Connection Manager) --> 
	<script type="text/javascript" src="<c:url value="/js/yui/event-min.js"/>"></script>
	<!--  Calendar JS -->
	<script type="text/javascript" src="<c:url value="/js/yui/calendar-min.js"/>"></script>
    <!-- Button JS -->
    <script type="text/javascript" src="<c:url value="/js/yui/button-min.js"/>"></script>
    <!--  Connection Manager for AJAX loading of Panel data -->
    <script type="text/javascript" src="<c:url value="/js/yui/connection-min.js"/>"></script> 
    <!-- safe JSON parsing -->
    <script type="text/javascript" src="<c:url value="/js/yui/json-min.js"/>"></script>
    <!--  Autocomplete -->
    <script type="text/javascript" src="<c:url value="/js/yui/autocomplete-min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/button.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jsvalidate.js"/>"></script>
    <script type="text/javascript">
    	YAHOO.payment_module.currentMenu = "<c:out value='${sessionScope.currentMenu}'/>";
    	YAHOO.payment_module.baseUrl = "<c:url value='/' />";
    </script>
    <decorator:head/>
</head>

<body>
	<div id="doc4" class="yui-t4">
	
		<!-- header -->
		<div id="hd">
			<div style="float:left;margin-top:0.5em;margin-bottom:0.5em;"><img src="<c:url value="/img/logo_capwebct.gif"/>" 
				alt="Logo de la plateforme CapWebCT" /></div>
			<div style="float:right;">
				<c:out value="${sessionScope.username}"/> - 
				<a href="<c:out value='${sessionScope.logoutUrl}'/>"><fmt:message key="action.logout" /></a>
			</div>
			<div id="hd-footer">&nbsp;</div>
		</div>

		<!-- body -->
		<div id="bd">

			<div id="yui-main">
				<div class="yui-b"><decorator:body /></div>
			</div>

			<div class="yui-b">
				<div id="menuwithgroups" class="yuimenu">
					<div class="bd">
					
						<h6 class="first-of-type"><fmt:message key="menu.title.management" /></h6>
						<ul>
							<li id="accountManagementMenuItem" class="yuimenuitem">
								<a href="<c:url value="/management/account.jsp"/>">
									<fmt:message key="menu.management.item.account" />
								</a>
							</li>
							<li id="invoiceManagementMenuItem" class="yuimenuitem">
								<a href="<c:url value="/management/invoice.jsp"/>">
									<fmt:message key="menu.management.item.invoice" />
								</a>
							</li>
							<li id="contractManagementMenuItem" class="yuimenuitem">
								<a href="<c:url value="/management/contract.jsp"/>">
									<fmt:message key="menu.management.item.contract" />
								</a>
							</li>
							<li id="paymentManagementMenuItem" class="yuimenuitem">
								<a href="<c:url value="/management/payment.jsp"/>">
									<fmt:message key="menu.management.item.payment" />
								</a>
							</li>
						</ul>
						
						<h6><fmt:message key="menu.title.homefolder" /></h6>
						<ul>
							<li id="familyaccountAssociateMenuItem" class="yuimenuitem">
								<a href="<c:url value="/familyaccount/associate.jsp"/>">
									<fmt:message key="menu.homefolder.item.associate_capwebct" />
								</a>
							</li>
							<li id="cfaSearchMenuItem" class="yuimenuitem">
								<a href="<c:url value="/familyaccount/search_capwebct.jsp?action=initCapwebct"/>">
									<fmt:message key="menu.homefolder.item.search_capwebct" />
								</a>
							</li>
							<li id="efaSearchMenuItem" class="yuimenuitem">
								<a href="<c:url value="/familyaccount/search_external.jsp?action=initExternal"/>">
									<fmt:message key="menu.homefolder.item.search_external" />
								</a>
							</li>
						</ul>
						
						<c:if test="${sessionScope.isAdmin}">
							<h6><fmt:message key="menu.title.administration" /></h6>
							<ul>
								<li id="externalApplicationMenuItem" class="yuimenuitem">
									<a href="<c:url value="/admin/external_application.jsp"/>">
										<fmt:message key="menu.administration.item.external_application" />
									</a>
								</li>
								<li id="externalImportMenuItem" class="yuimenuitem">
									<a href="<c:url value="/admin/external_import.jsp"/>">
										<fmt:message key="menu.administration.item.external_import" />
									</a>
								</li>
								<!-- 
								<li id="paymentExportMenuItem" class="yuimenuitem">
									<a href="<c:url value="/admin/payment_export.jsp"/>">
										<fmt:message key="menu.administration.item.payment_export" />
									</a>
								</li>
								-->
								<li id="capwebctImportMenuItem" class="yuimenuitem">
									<a href="<c:url value="/admin/capwebct_import.jsp"/>">
										<fmt:message key="menu.administration.item.capwebct_import" />
									</a>
								</li>
								<li id="auditMenuItem" class="yuimenuitem">
									<a href="<c:url value="/admin/audit.jsp"/>">
										<fmt:message key="menu.administration.item.audit" />
									</a>
								</li>
							</ul>
						</c:if>
						
					</div>
				</div>
			</div>
		</div>

		<!-- footer -->
		<div id="ft">
			<a href="http://www.valdoise.fr">CapWebCT &copy; 2004, 2008 Conseil Général du Val d'Oise</a>
		</div>  
    
    </div>
</body>

</html>
