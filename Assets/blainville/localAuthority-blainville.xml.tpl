<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="configurationBean_blainville"
    class="fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean"
    init-method="init">
    <property name="name" value="blainville"/>
    <property name="authorizations">
      <map>
        <entry key="login" value="password"/>
      </map>
    </property>
    <property name="defaultServerName" value="localhost"/>
    <property name="defaultEmail" value="sansmail@blainville.fr"/>
    <property name="autotransition" value="true"/>
    <property name="jpaConfigurations">
        <props>
            <prop key="hibernate.show_sql">false</prop>
            <prop key="hibernate.format_sql">false</prop>
            <prop key="hibernate.connection.driver_class">org.postgresql.Driver</prop>
            <prop key="hibernate.connection.url">jdbc:postgresql://localhost:5432/capdemat_blainville_${branch}</prop>
            <prop key="hibernate.connection.username">capdemat</prop>
            <prop key="hibernate.connection.password">capdematpass</prop>
            <prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
            <prop key="acquireIncrement">3</prop>
            <prop key="initialPoolSize">0</prop>
            <prop key="minPoolSize">0</prop>
            <prop key="maxStatements">24</prop>
            <prop key="maxIdleTime">300</prop>
        </props>
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
                <value>Ticket Booking</value>
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
                <value>School Transport Registration</value>
                <value>Global School Registration</value>
              </list>
            </property>
            <property name="serviceProperties">
              <map>
                <entry>
                  <key><value>sendHomeFolderCreation</value></key>
                  <value>true</value>
                </entry>
              </map>
            </property>
          </bean>
        </entry>
        <entry>
          <key>
            <ref bean="fakePointExternalService" />
          </key>
          <bean class="fr.cg95.cvq.external.ExternalServiceBean">
            <property name="requestTypes">
              <list>
                <value>Technical Intervention</value>
                <value>School Canteen Registration</value>
              </list>
            </property>
           <property name="password" value="abcd"/>
          </bean>
        </entry>
        <entry>
          <key>
            <ref bean="restExternalService" />
          </key>
          <bean class="fr.cg95.cvq.external.ExternalServiceBean">
            <property name="requestTypes">
              <list>
                <value>Compostable Waste Collection</value>
              </list>
            </property>
           <property name="login" value="BlainVilleRest"/>
           <property name="password" value="abcd"/>
          </bean>
        </entry>
        <entry>
          <key>
            <ref bean="externalApplicationProviderService" />
          </key>
          <bean class="fr.cg95.cvq.external.ExternalServiceBean">
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
          <key><value>All</value></key>
          <map>
            <entry key="mailData" value="RequestValidationNotification"/>
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
            <entry key="mailSendTo" value="capdemat-dev@zenexity.fr"/>
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
