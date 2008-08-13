<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<div class="block_type11">
  <cvq:timedocuments mode="private"/>
</div>

<div class="block_type11">
  <h2 class="subtitle">LES ETAPES DE LA DEMARCHE</h2>
</div>

<div class="block_type11">
  <cvqf:processPresentation mode="private"/>
</div>

<div class="block_type11">
  <form method="get" action="#">
    <ul class="list_type12">
      <li class="item checkbox">
        <p class="paragraph">&nbsp;</p>
      </li>
      <li class="item submit">
        <p class="paragraph"><span class="custom_color"></span><a href="<cvqf:processHref action="createRequest.do"/>" title="">COMMENCER VOTRE DEMARCHE</a></p>
      </li>
    </ul>
  </form>
</div>
