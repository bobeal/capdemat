<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:aop="http://www.springframework.org/schema/aop"
     xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">

  <!--
  <bean id="configurer"
    class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="location">
      <value>@deploy_properties_file@</value>
    </property>
  </bean>
  -->
  
  <bean id="abstractSessionFactory" abstract="true">

    <property name="mappingResources">
      <list>
        <value>fr/cg95/cvq/business/request/Request.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestType.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestSeason.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/DisplayGroup.hbm.xml</value>
        <value>fr/cg95/cvq/business/authority/LocalAuthority.hbm.xml</value>
        <value>fr/cg95/cvq/business/users/HomeFolder.hbm.xml</value>
        <value>fr/cg95/cvq/business/users/Individual.hbm.xml</value>
        <value>fr/cg95/cvq/business/document/Document.hbm.xml</value>
        <value>fr/cg95/cvq/business/document/DocumentBinary.hbm.xml</value>
        <value>fr/cg95/cvq/business/document/DocumentType.hbm.xml</value>
        <value>fr/cg95/cvq/business/authority/School.hbm.xml</value>
        <value>fr/cg95/cvq/business/authority/RecreationCenter.hbm.xml</value>
        <value>fr/cg95/cvq/business/users/Address.hbm.xml</value>
        <value>fr/cg95/cvq/business/authority/Agent.hbm.xml</value>
        <value>fr/cg95/cvq/business/document/DocumentAction.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestAction.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestLock.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestNote.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestForm.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/Category.hbm.xml</value>
        <value>fr/cg95/cvq/business/users/HistoryEntry.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/LocalReferentialData.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/PlaceReservationData.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/TicketTypeSelection.hbm.xml</value>
        <value>fr/cg95/cvq/business/payment/Payment.hbm.xml</value>
        <value>fr/cg95/cvq/business/payment/PurchaseItem.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/school/PerischoolAuthorizedIndividual.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/school/PerischoolContactIndividual.hbm.xml</value>   
        <value>fr/cg95/cvq/business/request/school/RecreationAuthorizedIndividual.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/school/RecreationContactIndividual.hbm.xml</value>                 
        <value>fr/cg95/cvq/business/request/social/DhrRealAsset.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/DhrNotRealAsset.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/DhrPreviousDwelling.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarAdditionalFee.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarCareService.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarFamilyAssistanceMember.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarFamilyDependent.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarHomeIntervenant.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarOtherFolder.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarOtherBenefit.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HcarProfessional.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrAdditionalFee.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrCareService.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrFamilyAssistanceMember.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrFamilyDependent.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrHomeIntervenant.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrOtherFolder.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrOtherBenefit.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/social/HccrProfessional.hbm.xml</value>        
        <value>fr/cg95/cvq/business/request/MeansOfContact.hbm.xml</value>
        <value>fr/cg95/cvq/business/external/ExternalServiceTrace.hbm.xml</value>
        <value>fr/cg95/cvq/business/external/ExternalServiceIdentifierMapping.hbm.xml</value>
        <value>fr/cg95/cvq/business/request/RequestDocument.hbm.xml</value>
        <value>fr/cg95/cvq/business/users/IndividualRole.hbm.xml</value>
      </list>
    </property>

    <property name="hibernateProperties">
      <props>
        <prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</prop>
        <prop key="hibernate.show_sql">false</prop>
        <prop key="hibernate.bytecode.use_reflection_optimizer">true</prop>
        <prop key="hibernate.use_outer_join">false</prop>
        <prop key="hibernate.cache.use_query_cache">false</prop>
      </props>
    </property>

    <property name="entityInterceptor">
      <ref bean="historyInterceptor" />
    </property>

  </bean>

  <bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
    <!-- the SMTP host responsible for sending mail messages -->
    <property name="host">
      <value>${mail.sender_host}</value>
    </property>
    <property name="port">
      <value>${mail.sender_port}</value>
    </property>
  </bean>

  <bean id="localAuthorityRegistry"
    class="fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry" init-method="init">
    <property name="localAuthorityDAO" ref="localAuthorityDAO" />
    <property name="performDbUpdates" value="@perform_db_updates@" />
    <property name="referentialBase" value="${referential.properties.path}" />
    <property name="assetsBase" value="${assets.properties.path}" />
    <property name="includes" value="${assets.included_authorities}" />
    <property name="localAuthoritiesListFilename" value="local_authorities_list.txt" />
  </bean>

  <!-- ================================================================ -->
  <!-- ================== FAKE SERVICES DEFINITION ==================== -->
  <!-- ================================================================ -->

  <bean id="fakePaymentProviderService" 
    class="fr.cg95.cvq.service.payment.impl.FakePaymentProviderService">
    <property name="paymentUrl" value="${fake_payment.url}" />  
    <property name="callbackUrl" value="${fake_payment.callbackUrl}" />  
  </bean>

  <bean id="fakeExternalService" class="fr.cg95.cvq.external.impl.FakeExternalService">
    <property name="label" value="Fake External Service" />
    <property name="authorizingRequestLabel" value="VO Card" />
    <property name="requestServiceRegistry">
      <ref bean="requestServiceRegistry" />
    </property>
    <property name="homeFolderService">
      <ref bean="homeFolderService" />
    </property>
    <property name="xmlDirectory" value="external_service"/>
    <property name="consumptionsFile" value="consumptions.xml"/>
    <property name="accountsFile" value="accounts.xml"/>
    <property name="depositAccountDetailsFile" value="depositAccountDetails.xml" />
    <property name="invoiceDetailsFile" value="invoiceDetails.xml" />
    <property name="testDataDirectory" value="${data.properties.path}"/>
  </bean>
  
  
  
  <!-- ================================================================ -->
  <!-- ================= XSARNET SERVICES DEFINITION ================== -->
  <!-- ================================================================ -->
  
  <bean id="xsarnetExternalService" class="fr.cg95.cvq.external.impl.EntryPointExternalService">
    <property name="label" value="Xsarnet External Service" />
  </bean>
  
  <bean id="fakePointExternalService" class="fr.cg95.cvq.external.impl.EntryPointExternalService">
    <property name="label" value="Fake Point External Service" />
  </bean>

  <bean id="translationService" class="fr.cg95.cvq.util.translation.impl.TranslationService" />

</beans>
