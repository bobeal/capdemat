<%
  import org.apache.commons.lang.StringUtils
  import fr.cg95.cvq.generator.common.Condition.RoleType
  import fr.cg95.cvq.generator.plugins.model.ModelPluginUtils
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
  def displayAnnotation = { element, wrapper ->
    def sqlName = ModelPluginUtils.getSQLName(element.elementName)
    def wrapperSQLName = ModelPluginUtils.getSQLName(wrapper)
    def widgets = [
      "simple" : """
        * @hibernate.property
        *  column="${sqlName}"
        ${element.maxLength > 0 ? '*  length="' + element.maxLength + '"' : element.length > 0 ? '*  length="' + element.length + '"' : ""}
      """,
      "positiveInteger" : """
        * @hibernate.property
        *  column="${sqlName}"
        *  type="serializable"
        ${element.maxLength > 0 ? '*  length="' + element.maxLength + '"' : element.length > 0 ? '*  length="' + element.length + '"' : ""}
      """,
      "one-to-many" : """
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        * @hibernate.key
        *  column="${wrapperSQLName}_id"
        * @hibernate.list-index
        *  column="${sqlName}_index"
        * @hibernate.one-to-many
        *  class="${element.javaPackageName}${element.modelClassName}"
      """,
      "many-to-one" : """
        * @hibernate.many-to-one
        ${element.tiedToRequest ? '*  cascade="all"' : ""}
        *  column="${sqlName}_id"
        *  class="${element.javaPackageName}${element.modelClassName}"
      """,
      "many-to-many" : """
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        ${element.tiedToRequest ? '*  cascade="all"' : ""}
        *  table="${wrapperSQLName}_${sqlName}"
        * @hibernate.key
        *  column="${wrapperSQLName}_id"
        * @hibernate.list-index
        *  column="${sqlName}_index"
        * @hibernate.many-to-many
        *  column="${sqlName}_id"
        *  class="${element.javaPackageName}${element.modelClassName}"
      """
    ]
    widgets["long"] = widgets["simple"]
    widgets["double"] = widgets["simple"]
    widgets["short"] = widgets["simple"]
    widgets["string"] = widgets["simple"]
    widgets["enum"] = widgets["simple"]
    widgets["date"] = widgets["simple"]
    widgets["time"] = widgets["simple"]
    widgets["boolean"] = widgets["simple"]
    widgets["referential"] = widgets["many-to-one"]
    widgets["referentialList"] = widgets["many-to-many"]
    widgets["complex"] = widgets["one-to-many"]
    widgets["complexList"] = widgets["one-to-many"]
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

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="${sqlName}"
 *  lazy="false"
 */
public class ${requestName}Data implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public ${requestName}Data() {
      <% constructorAttributes.each { %>
        ${it.key} = ${it.value};
      <% } %>
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  <% elements.each { element -> %>
    <% element.validationAnnotations.each { %>
      @${it.key}(
        <% it.value.each { %>
          ${it.key} = ${it.value},
        <% } %>
        <%
          if (element.elementCommon.conditionListener != null
            || element.complexContainerConditionListener != null) {
        %>
          when = "groovy:def active = true;" +
          <%
            [element.elementCommon.conditionListener, element.complexContainerConditionListener].each { listener ->
              if (listener != null) {
                def trigger = request.getField(listener.condition.trigger.name)
                if ("LocalReferentialData".equals(trigger.modelClassName)) {
          %>
            "if (_this.${trigger.nameAsParam} == null || _this.${trigger.nameAsParam}.isEmpty()) return false; _this.${trigger.nameAsParam}.each { active &= <% if (RoleType.unfilled.equals(listener.role)) { %>!<% } %>_this.conditions['${trigger.nameAsParam}'].test(it.name) };" +
                <% } else { %>
            "active &= <% if (RoleType.unfilled.equals(listener.role)) { %>!<% } %>_this.conditions['${trigger.nameAsParam}'].test(_this.${trigger.nameAsParam}.toString());" +
                <% } %>
              <% } %>
            <% } %>
            "return active",
        <% } %>
        profiles = {"${element.elementCommon.step.name}"},
        message = "${element.nameAsParam}"
      )
    <% } %>
    private ${element.type()} ${element.nameAsParam};

    public final void set${element.elementName}(final ${element.type()} ${element.nameAsParam}) {
        this.${element.nameAsParam} = ${element.nameAsParam};
    }

    /**
 <% displayAnnotation(element, requestName) %>
    */
    public final ${element.type()} get${element.elementName}() {
        return this.${element.nameAsParam};
    }
  <% } %>
}
