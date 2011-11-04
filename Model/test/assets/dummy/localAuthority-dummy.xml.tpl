<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="configurationBean_dummy"
    class="fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean" init-method="init">
    <property name="name" value="dummy" />
        <property name="jpaConfigurations">
        <props>
          <% if (databaseType == 'pgsql') { %>
          <prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
          <prop key="hibernate.connection.driver_class">org.postgresql.Driver</prop>
          <prop key="hibernate.connection.url">jdbc:postgresql://localhost:5432/capdemat_dummy</prop>
          <prop key="hibernate.connection.username">capdemat</prop>
          <prop key="hibernate.connection.password">capdematpass</prop>
            <prop key="initialPoolSize">0</prop>
            <prop key="minPoolSize">0</prop>
            <prop key="maxPoolSize">24</prop>
            <prop key="maxStatements">0</prop>
            <prop key="maxIdleTime">300</prop>
          <% } %>

            <prop key="hibernate.show_sql">false</prop>
            <prop key="hibernate.bytecode.use_reflection_optimizer">true</prop>
            <prop key="hibernate.use_outer_join">false</prop>
            <prop key="hibernate.cache.use_query_cache">false</prop>
            <prop key="hibernate.auto_import">true</prop>
<!--        <prop key="hibernate.hbm2ddl.auto">create-drop</prop>-->
            <prop key="hibernate.format_sql">false</prop>
        </props>
    </property>
    <property name="paymentServices">
      <map>
        <entry>
          <key>
            <ref bean="fakePaymentProviderService" />
          </key>
          <bean class="fr.cg95.cvq.service.payment.PaymentServiceBean">
            <property name="broker" value="Régie de la ville de Dummy"></property>
            <property name="requestTypes">
              <list>
                <value>School Canteen Registration</value>
                <value>Perischool Activity Registration</value>
                <value>Recreation Activity Registration</value>
              </list>
            </property>
          </bean>
        </entry>
      </map>
    </property>
    <property name="externalServices">
      <map></map>
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
          	<entry key="mailSendTo" value="bor@zenexity.fr"/>
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

</beans>
