<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>

<cvqf:form name="fr.cg95.cvq.fo.common.form.Validation" action="#">

    <!-- MOYEN DE CONTACT -->
    <fieldset class="fieldset_zone">
      <div class="fieldset_title_standard">
        <h3 class="fieldset_title">Moyen de contact</h3>
      </div>
      <ul class="insert_list">
        <h3 class="fieldset_subtitle">Veuillez choisir un moyen de contact<span class="required">*</span> :</h3>
        <li class="select_row">
		  <label></label>
      
          <cvq:meansOfContact name="meansOfContact"/>
          
        </li>
      </ul>
    </fieldset>
    <!-- / MOYEN DE CONTACT -->

    <!-- CAPTCHA -->
  <logic:notPresent name="BaseAction.authentification" scope="session">
    <fieldset class="fieldset_zone">
      <div class="fieldset_title_standard">
        <h3 class="fieldset_title">Suivi de la demande</h3>
      </div>
      <div class="captcha_block">
        <p class="captcha_img">	  
          <cvq:codeimage name="fr.cg95.cvq.fo.common.Request" property="controlId" scope="session"/>
		</p>
        <ul class="insert_list">
          <li class="text_row">
            <label for="controlId">Saisissez ensuite le code de contrle de l'image puis validez. Vous pouvez galement annuler votre demande ou revenir  l'tape prcdente.<span class="required">*</span></label>
          </li>
          <li class="text_row">
            <cvqf:text name="controlId" mode=""/>
          </li>
		<logic:present name="CodeError" scope="request">
          <li class="text_row">
            <label><span class="required">Le code que vous tapez doit correspondre  celui de l'image. Ressayez.</span></label>
          </li>
        </logic:present>  
        </ul>
        <ul class="insert_list" style="display:none;">
          <li class="text_row">
   			<cvqf:text name="dummy" mode=""/>
          </li>
        </ul>
		<br class="clear-both" />
      </div>
    </fieldset>
	<br class="clear-both" />
    <!-- / CAPTCHA -->

  <logic:notEmpty name="fr.cg95.cvq.wizard.process.ProcessStageAction.request" property="requester.lastName" scope="session">
	<logic:empty name="fr.cg95.cvq.wizard.process.ProcessStageAction.request" property="requester.password" scope="session">
    <!-- SUIVI -->
    <fieldset class="fieldset_zone">
      <ul class="insert_list">
        <li class="text_row">
          <p class="paragraph">
			Vous pouvez suivre le traitement de votre demande en crant un compte personnel provisoire, 
			conserv le temps du traitement de la demande.
          </p>
          <p class="paragraph">
			Choisissez loption oui et renseignez les informations qui vous sont demandes.
          </p>
        </li>
      </ul>
    </fieldset>
    <fieldset class="fieldset_zone">
      <ul class="insert_list">
        <li class="radio_row_inline">
          <label for="trace" class="radio_label">Suivi de la demande<span class="required">*</span> :</label>
		  <cvqf:radio name="trace" mode="inline" label="[Oui,Non]" />
        </li>
      </ul>
    </fieldset>
    <!-- / SUIVI -->
	</logic:empty>
   </logic:notEmpty>
  </logic:notPresent>
</cvqf:form>
<script type="text/javascript">
	function validationData() {
	  this.meansOfContact = new Function("key","this.label='Moyen de contact'; this.msg=null; this.required=true;  this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
	  this.controlId = new Function("key","this.label='Code de contrle'; this.msg=null; this.required=true;  this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
	}
	setFocus("fr.cg95.cvq.fo.common.form.Validation");
</script>





  		