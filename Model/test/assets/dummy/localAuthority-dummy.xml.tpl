<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN" "http://www.springframework.org/dtd/spring-beans.dtd">

<beans>

  <bean id="configurationBean_dummy"
    class="fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean" init-method="init">
    <property name="name" value="dummy" />
    <!--<property name="documentDigitalizationEnabled"><value>true</value></property>-->
    <property name="sessionFactory">
      <ref bean="sessionFactory_dummy" />
    </property>
    <property name="paymentServices">
      <map>
        <entry>
          <key>
            <ref bean="fakePaymentProviderService" />
          </key>
          <bean class="fr.cg95.cvq.payment.PaymentServiceBean">
            <property name="broker" value="Régie de la ville de Dummy"></property>
            <property name="requestTypes">
              <list>
                <value>Place Reservation</value>
                <value>VO Card</value>
              </list>
            </property>
          </bean>
        </entry>
        <!--
        <entry>
          <key>
            <ref bean="wynidPaymentProvider" />
          </key>
          <bean class="fr.cg95.cvq.payment.PaymentServiceBean">
            <property name="broker" value="Wynid"></property>
            <property name="serviceProperties">
              <map>
                <entry>
                  <key>
                    <value>wynidBaseUrl</value>
                  </key>
                  <value>https://cartevaloise.dummy.fr/FrontOffice/pay.do?transition=payment</value>
                </entry>
                <entry>
                  <key>
                    <value>wynidCaisses</value>
                  </key>
                  <props>
                    <prop key="Dummy-borne1">5</prop>
                  </props>
                </entry>
              </map>
            </property>
          </bean>
        </entry>
        <entry>
          <key>
            <ref bean="spplusPaymentProvider" />
          </key>
          <bean class="fr.cg95.cvq.payment.PaymentServiceBean">
            <property name="broker" value="Spplus"></property>
            <property name="serviceProperties">
              <map>
                <entry>
                  <key>
                    <value>spplusMerchkey</value>
                  </key>
                  <value>aa 33 37 c2 6a 58 da cc bc 3c 09 7e aa 07 e2 a5 da 7f df 6d 13 23 4c 0c</value>
                </entry>
                <entry>
                  <key>
                    <value>spplusSiret</value>
                  </key>
                  <value>00000000000095-99</value>
                </entry>
                <entry>
                  <key>
                    <value>spplusUserCallbackUrl</value>
                  </key>
                  <value>https://cartevaloise.dummy.fr/FrontOffice/placePaymentResult.do</value>
                </entry>
              </map>
            </property>
          </bean>
        </entry>
        -->
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
  
  <bean id="sessionFactory_dummy"
    class="org.springframework.orm.hibernate3.LocalSessionFactoryBean"
    parent="abstractSessionFactory">
    <property name="dataSource">
      <ref bean="${databaseType}DataSource_dummy" />
    </property>
    
     <property name="hibernateProperties">
      <props>
        <% if (databaseType == 'hsqldb') { %>
          <prop key="hibernate.dialect">org.hibernate.dialect.HSQLDialect</prop>
        <% } else if (databaseType == 'pgsql') { %>
          <prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
        <% } %>
        <prop key="hibernate.show_sql">false</prop>
        <prop key="hibernate.bytecode.use_reflection_optimizer">true</prop>
        <prop key="hibernate.use_outer_join">false</prop>
        <prop key="hibernate.cache.use_query_cache">false</prop>
        <prop key="hibernate.auto_import">true</prop>
   <!-- <prop key="hibernate.hbm2ddl.auto">create-drop</prop> -->
      </props>
    </property>
    
  </bean>

  <% if (databaseType == 'pgsql') { %>
  <bean id="pgsqlDataSource_dummy" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass">
      <value>org.postgresql.Driver</value>
    </property>
    <property name="jdbcUrl">
      <value>jdbc:postgresql://localhost:5432/cartevaloise_dummy</value>
    </property>
    <property name="user">
      <value>cvq95</value>
    </property>
    <property name="password">
      <value>cvq95pass</value>
    </property>
    <property name="acquireIncrement" value="3" />
    <property name="initialPoolSize" value="3" />
    <property name="minPoolSize" value="3" />
    <property name="maxPoolSize" value="12" />
    <property name="maxStatements" value="0"/>
  </bean>
  <% } %>
  
  <% if (databaseType == 'hsqldb') { %>
  <bean id="hsqldbDataSource_dummy" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass">
      <value>org.hsqldb.jdbcDriver</value>
    </property>
    <property name="jdbcUrl">
      <value>jdbc:hsqldb:file:/tmp/cartevaloise_dummy;shutdown=true</value>
    </property>
    <property name="user">
      <value>sa</value>
    </property>
    <property name="password">
      <value></value>
    </property>
    <property name="acquireIncrement" value="3" />
    <property name="initialPoolSize" value="1" />
    <property name="minPoolSize" value="1" />
    <property name="maxPoolSize" value="12" />
  </bean>
  <% } %>

</beans>
