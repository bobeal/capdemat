<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import = "fr.cg95.cvq.fo.util.Constants" %>

<script for=window event=onload>
redirectUrl="<%=(String) request.getAttribute(Constants.URL)%>";
popup=<%=(request.getAttribute(Constants.POPUP) == null)? false : true%>
href="<%=(String) request.getAttribute(Constants.HREF)%>";
if (popup) {
	window.open(redirectUrl,'print','resizable=yes,top=30,left=140,width=820,height=740');
	self.location.href=href;
} else {
alert(self + " <--> " + window.top);
	window.top.location.href=redirectUrl;
}
</script>

 