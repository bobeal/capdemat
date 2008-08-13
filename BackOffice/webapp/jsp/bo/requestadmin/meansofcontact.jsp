<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<html:form action="/requestAction.do?save=meansOfContact" styleClass="form_block">
	<div class="grid_cell">
	  <div class="block002">
	    <p class="text002 XXX">Paramètres globaux > Gestion des moyens de contact</p>
	  </div>
	  
	  <div class="block004">
	    <div class="grid_cell">
			  <p class="text001">Les moyens de contacts disponible pour l'habitant sont affichés ci-dessus. Sélectionnez dans la liste les moyens de contact choisies et validez en appuyant sur « enregistrer ».</p>
	    </div>
		<div class="grid_cell">
	      <div class="block011">
				<cvq:resultDisplay name="RequestForm" property="meansOfContact" styleClass="table002"/>
	      </div>
		</div>
	    <div class="grid_cell">
	      <fieldset class="fieldset007">
	        <div class="form_cell">
	          <span class="input"><input type="submit" class="input_submit" name="save" value="<bean:message key='action.save'/>"/></span>
	        </div>
	      </fieldset>
	    </div>
	    <div class="clear-both"></div>
	  </div>
	</div>
</html:form>
