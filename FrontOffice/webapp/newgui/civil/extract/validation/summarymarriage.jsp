<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Validation" action="#" mode="static">
      <ul class="validation_list">
        <li class="text_row">
          <p class="label">
            Nom de l'époux : 
          </p>
          <p class="text">
            <cvqf:text name="marriageHusbandLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) de l'époux : 
          </p>
          <p class="text">
            <cvqf:text name="marriageHusbandFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Nom de l'épouse : 
          </p>
          <p class="text">
            <cvqf:text name="marriageWifeLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Prénom(s) de l'épouse : 
          </p>
          <p class="text">
            <cvqf:text name="marriageWifeFirstNames" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Date de mariage : 
          </p>
          <p class="text">
            <cvqf:text name="marriageDate" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Ville de mariage : 
          </p>
          <p class="text">
            <cvqf:text name="marriageCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
            Département de mariage : 
          </p>
          <p class="text">
            <cvqf:text name="marriagePostalCode" mode="static" maxlength="2"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Validation");
	</script>
