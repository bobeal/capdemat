<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Abonnee" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row_inline">
			<label for="isSubscriber" class="">Etes vous abonnée<span class="required">*</span></label>
          <cvqf:radio name="isSubscriber" mode="inline" label="[Oui,Non]" />
		  </li>
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="text_row">
			<label for="subscriberNumber" class="label">Numéro d'abonné</label>
            <cvqf:text name="subscriberNumber" mode=""/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.isSubscriber = new Function("key","this.label='Etes vous abonnée'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.subscriberNumber = new Function("key","this.label='Numéro d&quote;abonné'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=0; this.transform='uppercase'; this.type=null; return this[key];");
  		}
        updateDisplay("isSubscriber");
  		setFocus("Abonnee");
	</script>
