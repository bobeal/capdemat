<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<p class="paragraph"><strong>Cette étape vous permet de fournir des justificatifs numérisés, elle n'est pas obligatoire.</strong></p>
<ul class="list">
  <li class="paragraph classic_item"><strong>Les documents que vous allez numériser</strong> seront utilisés pour vos différentes procédures administratives et vous feront gagner du temps. Vous devez toutefois présenter les originaux en mairie.</li>
  <li class="paragraph classic_item"><strong>Les justificatifs que vous n'ajoutez pas ici</strong> seront à remettre en mairie.</li>
  <li class="paragraph classic_item"><strong>Si un changement de situation survient,</strong> il est impératif de fournir à nouveau les justificatifs de votre nouvelle situation.</li>
  <li class="paragraph classic_item">Il est rappelé que les justificatifs fournis ont un caractère confidentiel.</li>
</ul>
<form method="get" action="selectDocuments.do">
  <input type="hidden" name="action" value="select">
  <p class="large_notice_txt">Cochez les justificatifs à ajouter et appuyez sur le bouton "validez votre choix"</p>
  <p class="large_notice_bg"></p>
  <fieldset class="dbl_column">
    <ul class="list">
      <li class="subtitle">Justificatif(s) à fournir :</li>
	  <cvq:selectDocuments name="fr.cg95.cvq.fo.common.Request" property="missingDocuments" scope="session" />
    </ul>
    <ul class="list">
      <li class="subtitle">Justificatif(s) déjà  fourni(s) :</li>
	  <cvq:selectDocuments name="fr.cg95.cvq.fo.common.Request" property="availableDocuments" mode="disabled" scope="session" />
    </ul>
  </fieldset>
  <fieldset class="fieldset_zone">
    <ul class="actions_list">
      <li class="validation"><span class="custom_color"></span><input type="submit" id="submit_form" value="VALIDEZ VOTRE CHOIX" /></li>
    </ul>
  </fieldset>
</form>
