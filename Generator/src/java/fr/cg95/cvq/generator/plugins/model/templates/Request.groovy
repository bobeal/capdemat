<%
  import org.apache.commons.lang.StringUtils
  fr.cg95.cvq.generator.plugins.model.ElementModelProperties.metaClass.type = {
    if (delegate.simpleType) {
        if (delegate.enumValues) {
            return delegate.javaPackageName + delegate.xmlSchemaType
        } else {
            return delegate.javaType
        }
    } else {
        if (delegate.maxOccurs == 1) {
            return delegate.javaPackageName + StringUtils.removeEnd(delegate.xmlSchemaType, "Type")
        } else {
            return "List<${delegate.javaPackageName + delegate.modelClassName}>"
        }
    }
  }
  def returnInstance = StringUtils.uncapitalize(requestName)
  def displayModelToXmlWidget = { element, wrapper ->
    def widgets = [
      "long" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(get${element.elementName}().longValue());
      """,
      "double" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(get${element.elementName}().doubleValue());
      """,
        "short" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(get${element.elementName}());
      """,
      "string" : """
        ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(get${element.elementName}());
      """,
        "enum" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(${element.xmlBeansPackageName}.${element.xmlSchemaType}.Enum.forString(get${element.elementName}().getLegacyLabel()));
      """,
        "date" : """
        date = get${element.elementName}();
        if (date != null) {
            calendar.setTime(date);
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(calendar);
        }
      """,
        "time" : """
        localTime = get${element.elementName}();
        if (localTime != null) {
            calendar.set(Calendar.HOUR_OF_DAY,localTime.getHourOfDay());
            calendar.set(Calendar.MINUTE, localTime.getMinuteOfHour());
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(calendar);
        }
      """,
        "boolean" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(get${element.elementName}().booleanValue());
      """,
        "positiveInteger" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(new BigInteger(get${element.elementName}().toString()));
      """,
        "complex" : """
        if (get${element.elementName}() != null)
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}(${element.modelClassName}.modelToXml(get${element.elementName}()));
      """,
        "referentialList" : """
        i = 0;
        if (get${element.elementName}() != null) {
            ${element.xmlBeansPackageName}.${element.xmlSchemaType}[] ${element.nameAsParam}TypeTab = new ${element.xmlBeansPackageName}.${element.xmlSchemaType}[get${element.elementName}().size()];
            for (${element.modelClassName} object : get${element.elementName}()) {
              ${element.nameAsParam}TypeTab[i++] = ${element.modelClassName}.modelToXml(object);
            }
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}Array(${element.nameAsParam}TypeTab);
        }
      """,
        "complexList" : """
        i = 0;
        if (get${element.elementName}() != null) {
            ${element.xmlBeansPackageName}.${element.xmlSchemaType}[] ${element.nameAsParam}TypeTab = new ${element.xmlBeansPackageName}.${element.xmlSchemaType}[get${element.elementName}().size()];
            for (${element.modelClassName} object : get${element.elementName}()) {
              ${element.nameAsParam}TypeTab[i++] = object.modelToXml();
            }
            ${wrapper}.set${StringUtils.capitalize(element.nameAsParam)}Array(${element.nameAsParam}TypeTab);
        }
      """
    ]
    widgets["referential"] = widgets["complex"]
    def output = widgets[element.widget]
    if (output != null) print output
  }
  def displayXmlToModelWidget = { element, wrapper ->
    def widgets = [
      "long" : """
        if (${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}() != 0)
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(new Long(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}()));
      """,
        "double" : """
        ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(new Double(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}()));
      """,
        "short" : """
        if (${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}() != null)
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}());
      """,
        "string" : """
        ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}());
      """,
        "enum" : """
        if (${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}() != null)
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${element.javaPackageName}${element.xmlSchemaType}.forString(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}().toString()));
        else
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${element.javaPackageName}${element.xmlSchemaType}.getDefault${element.xmlSchemaType}());
      """,
        "date" : """
        calendar = ${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}();
        if (calendar != null) {
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(calendar.getTime());
        }
      """,
        "time" : """
        calendar = ${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}();
        if (calendar != null) {
            localTime = new LocalTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(localTime);
        }
      """,
        "boolean" : """
        ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(Boolean.valueOf(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}()));
      """,
        "positiveInteger" : """
        ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}());
      """,
        "complex" : """
        if (${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}() != null)
            ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${element.modelClassName}.xmlToModel(${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}()));
      """,
        "complexList" : """
        List<${element.javaPackageName}${element.modelClassName}> ${element.nameAsParam}List = new ArrayList<${element.javaPackageName}${element.modelClassName}>(${wrapper}.sizeOf${StringUtils.capitalize(element.nameAsParam)}Array());
        for (${element.modelClassName}Type object : ${wrapper}.get${StringUtils.capitalize(element.nameAsParam)}Array()) {
            ${element.nameAsParam}List.add(${element.javaPackageName}${element.modelClassName}.xmlToModel(object));
        }
        ${returnInstance}.set${StringUtils.capitalize(element.nameAsParam)}(${element.nameAsParam}List);
      """
    ]
    widgets["referential"] = widgets["complex"]
    widgets["referentialList"] = widgets["complexList"]
    def output = widgets[element.widget]
    if (output != null) print output
  }
%>
package ${baseNS}.request.${lastParticle};

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import ${XMLBeansBaseNS}.common.*;
import ${XMLBeansBaseNS}.request.${lastParticle}.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class ${requestName} extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = ${requestName}Data.conditions;

    @AssertValid(message = "")
    private ${requestName}Data ${returnInstance}Data;

    public ${requestName}(RequestData requestData, ${requestName}Data ${returnInstance}Data) {
        super(requestData);
        this.${returnInstance}Data = ${returnInstance}Data;
    }

    public ${requestName}() {
        super();
        this.${returnInstance}Data = new ${requestName}Data();
        Map<String, Object> stepState;
        <% request.steps.eachWithIndex { it, i -> %>
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "${i == 0 ? "uncomplete" : "unavailable"}");
          stepState.put("required", ${it.required});
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("${it.name}", stepState);
        <% } %>
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public ${requestName}Data getSpecificData() {
        return ${returnInstance}Data;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(${requestName}Data ${returnInstance}Data) {
        this.${returnInstance}Data = ${returnInstance}Data;
    }

    @Override
    public final String modelToXmlString() {
        ${requestName}Document object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final ${requestName}Document modelToXml() {
        <% def localComplexTypesSet = new HashSet<String>() %>
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        ${requestName}Document ${returnInstance}Doc = ${requestName}Document.Factory.newInstance();
        ${requestName}Document.${requestName} ${returnInstance} = ${returnInstance}Doc.addNew${requestName}();
        super.fillCommonXmlInfo(${returnInstance});
        int i = 0;
        <%
          elements.each {
            def container
            if (it.complexContainerElementName) {
              complexTypeName = it.complexContainerElementTypeName
              complexTypeInstanceName = StringUtils.uncapitalize(complexTypeName) + it.complexContainerElementName
              if (!localComplexTypesSet.contains(complexTypeInstanceName)) {
                localComplexTypesSet.add(complexTypeInstanceName)
                  print "  $complexTypeName $complexTypeInstanceName = ${returnInstance}.addNew${it.complexContainerElementName}();"
              }
              container = complexTypeInstanceName
            } else {
              container = returnInstance
            }
            displayModelToXmlWidget(it, container)
          }
        %>
        return ${returnInstance}Doc;
    }

    @Override
    public final ${requestName}Document.${requestName} modelToXmlRequest() {
        return modelToXml().get${requestName}();
    }

    public static ${requestName} xmlToModel(${requestName}Document ${returnInstance}Doc) {
        ${requestName}Document.${requestName} ${returnInstance}Xml = ${returnInstance}Doc.get${requestName}();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        ${requestName} ${returnInstance} = new ${requestName}();
        ${returnInstance}.fillCommonModelInfo(${returnInstance}, ${returnInstance}Xml);
        <%
          elements.each {
            def container = "${returnInstance}Xml"
            if (it.complexContainerElementName) {
              container += ".get${it.complexContainerElementName}()"
            }
            displayXmlToModelWidget(it, container)
          }
        %>
        return ${returnInstance};
    }

    @Override
    public ${requestName} clone() {
        ${requestName} clone = new ${requestName}(getRequestData().clone(), ${returnInstance}Data.clone());
        Map<String, Object> stepState;
        <% request.steps.eachWithIndex { it, i -> %>
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "${i == 0 ? "uncomplete" : "unavailable"}");
          stepState.put("required", ${it.required});
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("${it.name}", stepState);
        <% } %>
        return clone;
    }

  <% elements.each { %>
    public final void set${it.elementName}(final ${it.type()} ${it.nameAsParam}) {
        ${returnInstance}Data.set${it.elementName}(${it.nameAsParam});
    }

    ${it.xmlSchemaType == 'AcceptanceType' ? '@IsRulesAcceptance' : ''}
    public final ${it.type()} get${it.elementName}() {
        return ${returnInstance}Data.get${it.elementName}();
    }
  <% } %>
}
