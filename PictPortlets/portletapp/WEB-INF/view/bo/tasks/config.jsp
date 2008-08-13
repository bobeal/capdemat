<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<portlet:actionURL var="actionURL"/>

<h1 class="portlet-section-header"><fmt:message key="cvq.tasks.config.legend"/></h1>

<form method="POST" action="${actionURL}" accept-charset="UTF-8">
  <fieldset>
    <p>
      <label class="portlet-form-field-label"><fmt:message key="cvq.tasks.config.title"/> :</label>
      <input type="text" name="title" value="${title}" class="portlet-form-input-field" />
    </p>
  </fieldset>
  <input class="portlet-form-button" type="submit" name="submitConfig" value="<fmt:message key='cvq.common.action.save'/>" class="button" />
  <input class="portlet-form-button" type="submit" name="cancelConfig" value="<fmt:message key='cvq.common.action.cancel'/>" class="button" />
</form>
