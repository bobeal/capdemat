<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="configurationBean_blainville"
    class="fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean"
    init-method="init">
    <property name="name" value="blainville"/>
    <property name="defaultServerName" value="localhost"/>
    <property name="displayTutorsInAccountCreation" value="false" />
    <property name="sessionFactory">
      <ref bean="sessionFactory_blainville" />
    </property>
    <property name="paymentServices">
      <map>
        <entry>
          <key>
            <ref bean="fakePaymentProviderService" />
          </key>
          <bean class="fr.cg95.cvq.service.payment.PaymentServiceBean">
            <property name="broker" value="Régie démo de Blainville"></property>
            <property name="friendlyLabel" value="Services autres que restauration scolaire"></property>
            <property name="requestTypes">
              <list>
                <value>Place Reservation</value>
                <value>VO Card</value>
                <value>Perischool Activity Registration</value>
              </list>
            </property>
          </bean>
        </entry>
      </map>
    </property>
    <property name="externalServices">
      <map>
        <entry>
          <key>
            <ref bean="fakeExternalService" />
          </key>
          <bean class="fr.cg95.cvq.external.ExternalServiceBean">
            <property name="requestTypes">
              <list>
                <value>School Canteen Registration</value>
                <value>Perischool Activity Registration</value>
                <value>Recreation Activity Registration</value>
              </list>
            </property>
            <property name="supportAccountsByHomeFolder">
              <value>true</value>
            </property>
            <property name="supportAccountsByRequest">
              <value>false</value>
            </property>
          </bean>
        </entry>
      </map>
    </property>
    <property name="ecitizenCreationNotifications">
      <map>
        <entry key="mailData" value="RequestCreationConfirmation"/>
        <entry key="mailSubject" value="Notification de création de votre demande"/>
        <entry key="attachPdf" value="true"/>
      </map>
    </property>
    <property name="ecitizenValidationNotifications">
      <map>
        <entry>
          <key><value>Place Reservation</value></key>
          <map>
            <entry key="mailData" value="PlaceReservationMailConfirmation"/>
            <entry key="attachPdf" value="true"/>
          </map>
        </entry>
      </map>
    </property>
     <property name="agentNotifications">
      <map>
        <entry>
          <key><value>NotCommitPaymentAlert</value></key>
          <map>
            <entry key="mailSendTo" value="administrateur@blainville.fr"/>
            <entry key="mailSubject" value="[CapDémat] Alerte Paiement"/>
            <entry key="mailData" value="NotCommitedPaymentsAlert"/>
          </map>
        </entry>
      </map>
    </property>
    <property name="paymentNotifications">
      <map>
        <entry>
          <key><value>CommitPaymentConfirmation</value></key>
          <map>
            <entry key="mailSubject" value="[CapDémat] Confirmation de paiement"/>
            <entry key="mailData" value="CommitPaymentNotification"/>
          </map>
        </entry>
      </map>
    </property>
  </bean>

  <bean id="sessionFactory_blainville"
    class="org.springframework.orm.hibernate3.LocalSessionFactoryBean"
    parent="abstractSessionFactory">
    <property name="dataSource">
      <ref bean="pgDataSource_blainville" />
    </property>
  </bean>

  <bean id="pgDataSource_blainville"
    class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass">
      <value>org.postgresql.Driver</value>
    </property>
    <property name="jdbcUrl">
      <value>jdbc:postgresql://localhost:5432/capdemat_blainville_${branch}</value>
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
