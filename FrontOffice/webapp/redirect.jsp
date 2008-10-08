<%@ page import = "fr.cg95.cvq.fo.util.Constants" %>

<script for=window event=onload>
redirectUrl="<%=(String) request.getAttribute(Constants.URL)%>";
statusmessage="<%=(String) request.getAttribute("statusmessage")%>";
popup=<%=(request.getAttribute(Constants.POPUP) == null)? false : true%>
href="<%=(String) request.getAttribute(Constants.HREF)%>";
if (popup) {
	window.open(redirectUrl,'print','resizable=yes,top=30,left=140,width=820,height=740');
	self.location.href=href;
} else {
	if (redirectUrl == "null") {
		redirectUrl = "managerWizard.do?transition=caddy";
	}
	window.top.location.href=redirectUrl;
}
</script>


 