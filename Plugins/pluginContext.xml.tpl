<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="${pluginBeanName}"
    class="fr.capwebct.capdemat.plugins.${pluginType.toLowerCase()}.${pluginName.toLowerCase()}.service.${pluginName}Service"
    init-method="init">
    <property name="label" value="${pluginName}"></property>
    <!-- Insert services you need here -->
  </bean>

  <% if (pluginType == 'CsvImporters') { %>
  <bean class="fr.cg95.cvq.platform.PluginBeanFactoryPostProcessor">
    <property name="extensionBeanName" value="${extensionBeanName}" />
    <property name="propertyName" value="${propertyName}" />
    <property name="pluginBeanName" value="${pluginBeanName}" />
  </bean>
  <% } %>
  
</beans>
