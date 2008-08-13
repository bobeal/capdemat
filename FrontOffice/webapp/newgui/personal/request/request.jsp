<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<div class="col_type5">
  <div class="block_type3">
    <p class="paragraph custom_color">Cliquez sur un des éléments<br />ci-dessous pour le voir.</p>
  </div>
  <div class="block_type5">
    <p class="paragraph caution">Liste des demandes.</p>
    <p class="paragraph">Vous accédez ici à l'ensemble des demandes que vous avez effectuées.</br>
	Pour visualiser le détail d'une demande, cliquez sur son numéro.</p>
  </div>
</div>
<div class="col_type5">
	<cvq:displayRequests name="familyHome" property="requestsDone" scope="session" mode="all"/>
</div>
