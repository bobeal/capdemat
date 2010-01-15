<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="configurationBean_@localAuthority@"
    class="fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean"
    init-method="init">
    <property name="name" value="@localAuthority@"/>
    <property name="defaultServerName" value="@localAuthorityDomainName@"/>
    <property name="sessionFactory">
      <ref bean="sessionFactory_@localAuthority@" />
    </property>
    <property name="ecitizenCreationNotifications">
      <map>
        <entry key="mailData" value="RequestCreationConfirmation"/>
        <entry key="mailSubject" value="Notification de création de votre demande"/>
        <entry key="attachPdf" value="true"/>
      </map>
    </property>
  </bean>

  <bean id="sessionFactory_@localAuthority@"
    class="org.springframework.orm.hibernate3.LocalSessionFactoryBean"
    parent="abstractSessionFactory">
    <property name="dataSource">
      <ref bean="pgDataSource_@localAuthority@" />
    </property>
  </bean>

  <bean id="pgDataSource_@localAuthority@"
    class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass">
      <value>org.postgresql.Driver</value>
    </property>
    <property name="jdbcUrl">
      <value>jdbc:postgresql://localhost:5432/capdemat_@localAuthority@</value>
    </property>
    <property name="user">
      <value>capdemat</value>
    </property>
    <property name="password">
      <value>capdematpass</value>
    </property>
    <property name="acquireIncrement" value="3" />
    <property name="initialPoolSize" value="0" />
    <property name="minPoolSize" value="0" />
    <property name="maxPoolSize" value="24" />
    <property name="maxStatements" value="0"/>
    <property name="maxIdleTime" value="300" />
  </bean>

</beans>
