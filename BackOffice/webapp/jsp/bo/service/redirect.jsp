<%@ page contentType="text/html; charset=UTF-8" %>

<script for=window event=onload>
redirectUrl="<%=(String) request.getAttribute("url")%>";
popup=<%=(request.getAttribute("popup") == null)? false : true%>;
empty=<%=(request.getAttribute("empty") == null)? "''" : "'?empty'"%>;
if (popup) {
	window.open(redirectUrl,'redirect','resizable=yes,scrollbars=yes,top=0,left=110,width=860,height=710');
	self.location.href='managerWizard.do' + empty;
} else {
	self.location.href=redirectUrl;
}
</script>

 