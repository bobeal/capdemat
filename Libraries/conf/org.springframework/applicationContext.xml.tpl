<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:aop="http://www.springframework.org/schema/aop"
     xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd">

    <aop:config>
      <aop:pointcut id="daoMethod"
        expression="execution(* fr.cg95.cvq.dao.*.hibernate.*DAO.*(..))" />
      <aop:aspect ref="hibernateExceptionTranslator">
        <aop:after-throwing throwing="hibernateEx" pointcut-ref="daoMethod"
          method="translateException" />
      </aop:aspect>
    </aop:config>

  <bean id="hibernateExceptionTranslator" 
    class="fr.cg95.cvq.dao.hibernate.HibernateExceptionTranslator"/>
  
  <!-- ======================================================= -->
  <!-- ========== GENERAL SERVICES DEFINITION ================ -->  
  <!-- ======================================================= -->

  <bean id="authenticationService" 
    class="fr.cg95.cvq.authentication.impl.AuthenticationService">
    <property name="individualDAO">
      <ref local="individualDAO"/>
    </property>
  </bean>

  <bean id="mailService" class="fr.cg95.cvq.util.mail.impl.MailService">
    <property name="mailSender">
      <ref bean="mailSender"/>
    </property>
    <property name="systemEmail" value="${mail.admin_address}"/> 
  </bean>

  <bean id="smsService" class="fr.cg95.cvq.util.sms.impl.SmsService">
    <property name="endportpath" value="${plugins.externalservices.clever.endportpath}"/> 
    <property name="username" value="${plugins.externalservices.clever.username}"/> 
    <property name="password" value="${plugins.externalservices.clever.password}"/>
    <property name="enabled" value="${plugins.externalservices.clever.enabled}" />
  </bean>

  <bean id="certificateService" 
    class="fr.cg95.cvq.service.users.impl.CertificateService">
    <property name="localAuthorityRegistry">
      <ref bean="localAuthorityRegistry"/>
    </property>
    <property name="localizationService" ref="localizationService" />
    <property name="requestFormDAO" ref="requestFormDAO" />
  </bean>

  <bean id="localizationService" 
    class="fr.cg95.cvq.util.localization.impl.LocalizationService"
  	init-method="init"/>

  <!-- history interceptor that logs all changes made on home folders -->
  <bean id="historyInterceptor" class="fr.cg95.cvq.dao.hibernate.HistoryInterceptor">
  </bean>

  <bean id="localAuthoritiesLoader"
    class="fr.cg95.cvq.service.authority.LocalAuthoritiesLoader"
    init-method="init" depends-on="securityContext">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>

  <bean id="cvqPolicy" class="fr.cg95.cvq.security.CvqPolicy" init-method="init"/>
  
  <bean id="securityContext" class="fr.cg95.cvq.security.SecurityContext">
    <property name="localAuthorityRegistry">
      <ref bean="localAuthorityRegistry"/>
    </property>
    <property name="agentDAO">
      <ref bean="agentDAO"/>
    </property>
    <property name="adultDAO">
      <ref bean="adultDAO"/>
    </property>
    <property name="administratorGroups">
      <list>
       <value>${agent.administrator_group}</value>
      </list>
    </property>
    <property name="agentGroups">
      <list>
       <value>${agent.contributor_group}</value>
      </list>
    </property>
  </bean>

  <!-- *******************************************************************  -->
  <!-- ******************** AUTHORITIES SERVICES**************************  -->
  <!-- *******************************************************************  -->

  <bean id="localReferentialService"
    class="fr.cg95.cvq.service.authority.impl.LocalReferentialService">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>

  <bean id="placeReservationService" 
    class="fr.cg95.cvq.service.authority.impl.PlaceReservationService">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>
  
  <bean id="categoryService" class="fr.cg95.cvq.service.authority.impl.CategoryService">
    <property name="categoryDAO">
      <ref local="categoryDAO"/>
    </property>
    <property name="requestTypeDAO">
      <ref local="requestTypeDAO"/>
    </property>
    <property name="agentService" ref="agentService" />
  </bean>

  <bean id="agentService" class="fr.cg95.cvq.service.authority.impl.AgentService">
    <property name="DAO">
      <ref local="agentDAO"/>
    </property>
    <property name="categoryDAO">
      <ref local="categoryDAO"/>
    </property>
    <property name="requestDAO">
      <ref local="requestDAO"/>
    </property>
    <property name="ldapService">
      <ref bean="ldapService"/>
    </property>
    <property name="requestService">
      <ref bean="defaultRequestService"/>
    </property>
  </bean>

  <bean id="schoolService" class="fr.cg95.cvq.service.authority.impl.SchoolService">
    <property name="DAO">
      <ref local="schoolDAO"/>
    </property>
  </bean>

  <bean id="recreationCenterService" 
    class="fr.cg95.cvq.service.authority.impl.RecreationCenterService">
    <property name="DAO">
      <ref local="recreationCenterDAO"/>
    </property>
  </bean>

  <!-- ******************** GENERIC REQUEST SERVICE **********************  -->
  <bean id="requestService" class="fr.cg95.cvq.service.request.impl.RequestService"
    abstract="true" init-method="init">
    <property name="requestDAO">
      <ref local="requestDAO"/>
    </property>
    <property name="requestTypeDAO">
      <ref local="requestTypeDAO"/>
    </property>
    <property name="genericDAO">
      <ref local="genericDAO"/>
    </property>
    <property name="individualDAO">
      <ref local="individualDAO"/>
    </property>
    <property name="documentDAO">
      <ref local="documentDAO"/>
    </property>
    <property name="requestActionDAO">
      <ref local="requestActionDAO"/>
    </property>
    <property name="requestNoteDAO">
      <ref local="requestNoteDAO"/>
    </property>
    <property name="requestFormDAO">
      <ref local="requestFormDAO"/>
    </property>
    <property name="documentService">
      <ref local="documentService"/>
    </property>
    <property name="homeFolderService">
      <ref local="homeFolderService"/>
    </property>
    <property name="certificateService">
      <ref local="certificateService"/>
    </property>
    <property name="mailService">
	  <ref local="mailService"/>
    </property>
    <property name="categoryService" ref="categoryService" />
    <property name="localizationService" ref="localizationService"/>
    <property name="requestServiceRegistry">
      <ref local="requestServiceRegistry"/>
    </property>
    <property name="localAuthorityRegistry">
      <ref bean="localAuthorityRegistry"/>
    </property>
    <property name="requestWorkflowService">
      <bean class="fr.cg95.cvq.service.request.impl.RequestWorkflowService">
        <property name="requestDAO" ref="requestDAO" />
        <property name="requestActionDAO" ref="requestActionDAO" />
        <property name="certificateService" ref="certificateService"></property>
      </bean>
    </property>
    <!-- must be put somewhere on the using application's classpath -->
    <property name="fopConfig">
      <value>fop-config.xml</value>
    </property>
  </bean>
  
  <bean id="defaultRequestService" class="fr.cg95.cvq.service.request.impl.DefaultRequestService" 
    parent="requestService"/>
  
  <bean id="requestServiceRegistry" class="fr.cg95.cvq.service.request.impl.RequestServiceRegistry"
    init-method="init">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="requestFormDAO" ref="requestFormDAO"/>
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="performDbUpdates" value="@perform_db_updates@"/>
  </bean>

  <bean id="requestStatisticsService" class="fr.cg95.cvq.service.request.impl.RequestStatisticsService">
    <property name="requestDAO" ref="requestDAO"/>
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="categoryService" ref="categoryService" />
  </bean>

  <!-- *******************************************************************  -->
  <!-- *********************** USERS SERVICES*****************************  -->
  <!-- *******************************************************************  -->

  <bean id="voCardRequestService" class="fr.cg95.cvq.service.ecitizen.impl.VoCardRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="VO Card Request"/>
    <property name="xslFoFilename" value="voCardRequest.xsl"/>
  </bean>

  <bean id="individualService" class="fr.cg95.cvq.service.users.impl.IndividualService">
    <property name="individualDAO">
      <ref local="individualDAO"/>
    </property>
    <property name="documentDAO">
      <ref local="documentDAO"/>
    </property>
    <property name="authenticationService">
      <ref bean="authenticationService"/>
    </property>
  </bean>

  <bean id="adultService" class="fr.cg95.cvq.service.users.impl.AdultService"
    parent="individualService">
    <property name="adultDAO">
      <ref local="adultDAO"/>
    </property>
    <property name="childService">
      <ref local="childService"/>
    </property>
  </bean>

  <bean id="childService" class="fr.cg95.cvq.service.users.impl.ChildService" 
    parent="individualService">
    <property name="childDAO">
      <ref local="childDAO"/>
    </property>
    <property name="genericDAO">
      <ref local="genericDAO"/>
    </property>
    <property name="adultService">
      <ref local="adultService"/>
    </property>
  </bean>

  <bean id="homeFolderService" class="fr.cg95.cvq.service.users.impl.HomeFolderService">
  	 <property name="localAuthorityRegistry"> 
  	 	<ref bean="localAuthorityRegistry"/>
  	 </property>
	 <property name="mailService">
	  <ref local="mailService"/>
    </property>
    <property name="individualService">
      <ref local="individualService"/>
    </property>
    <property name="adultService">
      <ref local="adultService"/>
    </property>
    <property name="childService">
      <ref local="childService"/>
    </property>
    <property name="requestService">
      <ref local="defaultRequestService"/>
    </property>
    <property name="paymentService">
      <ref local="paymentService"/>
    </property>
    <property name="genericDAO">
      <ref local="genericDAO"/>
    </property>
    <property name="homeFolderDAO">
      <ref local="homeFolderDAO"/>
    </property>
    <property name="documentDAO">
      <ref local="documentDAO"/>
    </property>
    <property name="childDAO">
      <ref local="childDAO"/>
    </property>
    <property name="adultDAO">
      <ref local="adultDAO"/>
    </property>
  </bean>
  
  <bean id="meansOfContactService" class="fr.cg95.cvq.service.request.impl.MeansOfContactService">
    <property name="meansOfContactDAO" ref="meansOfContactDAO" />
    <property name="performDbUpdates" value="@perform_db_updates@" />
    <property name="mailService" ref="mailService" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="smsService" ref="smsService" />
  </bean>

  <!-- ************************ DOCUMENTS RELATED SERVICES ********************* -->

  <bean id="documentDigitalizationAllowedBeforeAdvice"
    class="fr.cg95.cvq.service.document.DocumentDigitalizationAllowedBeforeAdvice">
    <property name="localAuthorityRegistry">
      <ref bean="localAuthorityRegistry"/>
    </property>
  </bean>

  <bean id="documentDigitalizationAllowedBeforeAdviceAdvisor"
    class="org.springframework.aop.support.RegexpMethodPointcutAdvisor">
    <property name="advice">
      <ref local="documentDigitalizationAllowedBeforeAdvice"/>
    </property>
    <property name="patterns">
      <list>
	    <value>.*DocumentService.addPage</value>
	    <value>.*DocumentService.modifyPage</value>
	    <value>.*DocumentService.deletePage</value>
      </list>
    </property>
  </bean>

  <bean id="documentService" 
    class="org.springframework.aop.framework.ProxyFactoryBean">
    <property name="proxyInterfaces"><value>fr.cg95.cvq.service.document.IDocumentService</value></property>
    <property name="target"><ref local="documentServiceTarget"/></property>
    <property name="interceptorNames">
      <list>
        <value>documentDigitalizationAllowedBeforeAdviceAdvisor</value>
      </list>
    </property>
  </bean>

  <bean id="documentServiceTarget" class="fr.cg95.cvq.service.document.impl.DocumentService">
    <property name="cvqPolicy">
      <ref bean="cvqPolicy"/>
    </property>
    <property name="documentDAO">
      <ref local="documentDAO"/>
    </property>
    <property name="documentTypeDAO">
      <ref local="documentTypeDAO"/>
    </property>
    <property name="documentBinaryDAO">
      <ref local="documentBinaryDAO"/>
    </property>
    <property name="genericDAO">
      <ref local="genericDAO"/>
    </property>
    <property name="homeFolderDAO">
      <ref local="homeFolderDAO"/>
    </property>
    <property name="individualDAO">
      <ref local="individualDAO"/>
    </property>
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="performDbUpdates" value="@perform_db_updates@"/>
    <property name="documentBootstrapper">
      <bean class="fr.cg95.cvq.service.document.impl.DocumentBootstrapper">
        <property name="documentTypeDAO" ref="documentTypeDAO" />
      </bean>
    </property>
  </bean>

  <bean id="cardService" class="fr.cg95.cvq.service.users.impl.CardService">
    <property name="DAO">
      <ref local="genericDAO"/>
    </property>
    <property name="individualDAO">
      <ref local="individualDAO"/>
    </property>
  </bean>

  <bean id="homeFolderModificationRequestService" 
    class="fr.cg95.cvq.service.request.impl.HomeFolderModificationRequestService" 
    parent="requestService">
    <property name="homeFolderService" ref="homeFolderService"/>
    <property name="label" value="Home Folder Modification"/>
    <property name="xslFoFilename" value="homeFolderModificationRequest.xsl"/>
    <!-- service specifics -->

    <property name="historyEntryDAO">
      <ref local="historyEntryDAO"/>
    </property>
    <property name="historyInterceptor">
      <ref local="historyInterceptor"/>
    </property>
    <property name="individualService">
      <ref bean="individualService"/>
    </property>
    <!-- end service specifics -->
  </bean>

  <bean id="schoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.school.impl.SchoolRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="School Registration"/>
    <property name="xslFoFilename" value="schoolRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="perischoolActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.school.impl.PerischoolActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_parr.xml"/>
    <property name="label" value="Perischool Activity Registration"/>
    <property name="xslFoFilename" value="perischoolActivityRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="recreationActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.school.impl.RecreationActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_rarr.xml"/>
    <property name="label" value="Recreation Activity Registration"/>
    <property name="xslFoFilename" value="recreationActivityRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="schoolCanteenRegistrationRequestService" 
    class="fr.cg95.cvq.service.school.impl.SchoolCanteenRegistrationRequestService" 
    parent="requestService">
    <!-- Service specific -->
    <property name="schoolRegistrationRequestService">
      <ref bean="schoolRegistrationRequestService"/>
    </property>
    <property name="localReferentialFilename" value="local_referential_scrr.xml"/>
    <property name="label" value="School Canteen Registration"/>
    <property name="xslFoFilename" value="schoolCanteenRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="vacationsRegistrationRequestService" 
    class="fr.cg95.cvq.service.school.impl.VacationsRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="Vacations Registration"/>
    <property name="xslFoFilename" value="vacationsRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="personalDetailsRequestService" 
    class="fr.cg95.cvq.service.civil.impl.PersonalDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Personal Details"/>
    <property name="xslFoFilename" value="personalDetailsRequest.xsl"/>
  </bean>

 <bean id="birthDetailsRequestService" 
    class="fr.cg95.cvq.service.civil.impl.BirthDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Birth Details"/>
    <property name="xslFoFilename" value="birthDetailsRequest.xsl"/>
 </bean>
  
  <bean id="marriageDetailsRequestService" 
    class="fr.cg95.cvq.service.civil.impl.MarriageDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Marriage Details" />
    <property name="xslFoFilename" value="marriageDetailsRequest.xsl"/>
  </bean>
  
  <bean id="deathDetailsRequestService" 
    class="fr.cg95.cvq.service.civil.impl.DeathDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Death Details" />
    <property name="xslFoFilename" value="deathDetailsRequest.xsl"/>
   </bean>

  <bean id="electoralRollRegistrationRequestService" 
    class="fr.cg95.cvq.service.election.impl.ElectoralRollRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="Electoral Roll Registration"/>
    <property name="xslFoFilename" value="electoralRollRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="alignmentCertificateRequestService" 
    class="fr.cg95.cvq.service.urbanism.impl.AlignmentCertificateRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Alignment Certificate"/>
    <property name="xslFoFilename" value="alignmentCertificateRequest.xsl"/>
  </bean>

  <bean id="sewerConnectionRequestService" 
    class="fr.cg95.cvq.service.urbanism.impl.SewerConnectionRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Sewer Connection"/>
    <property name="xslFoFilename" value="sewerConnectionRequest.xsl"/>
  </bean>

  <bean id="libraryRegistrationRequestService" 
    class="fr.cg95.cvq.service.leisure.culture.impl.LibraryRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_lrr.xml"/>
    <property name="label" value="Library Registration"/>
    <property name="xslFoFilename" value="libraryRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="musicSchoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.leisure.music.impl.MusicSchoolRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_msrr.xml"/>
    <property name="label" value="Music School Registration"/>
    <property name="xslFoFilename" value="musicSchoolRegistrationRequest.xsl"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="placeReservationRequestService" 
    class="fr.cg95.cvq.service.reservation.impl.PlaceReservationRequestService" 
    parent="requestService">
    <property name="label" value="Place Reservation"/>
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="placeReservationFilename" value="place_reservation_prr.xml"/>
    <property name="externalReferentialFilename" value="external_referential_prr.txt"/>
    <property name="placeReservationService" ref="placeReservationService" />
    <property name="xslFoFilename" value="placeReservationRequest.xsl"/>
  </bean>
  
  <bean id="remoteSupportRequestService" 
    class="fr.cg95.cvq.service.social.impl.RemoteSupportRequestService" 
    parent="requestService">
    <property name="label" value="Remote Support"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="remoteSupportRequest.xsl"/>
  </bean>
  
  <bean id="domesticHelpRequestService" 
    class="fr.cg95.cvq.service.social.impl.DomesticHelpRequestService" 
    parent="requestService">
    <property name="label" value="Domestic Help"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="domesticHelpRequest.xsl"/>
  </bean>

  <bean id="handicapAllowanceRequestService" 
    class="fr.cg95.cvq.service.social.impl.HandicapAllowanceRequestService" 
    parent="requestService">
    <property name="label" value="Handicap Allowance"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="xslFoFilename" value="handicapAllowanceRequest.xsl"/>
  </bean>

  <bean id="militaryCensusRequestService" 
    class="fr.cg95.cvq.service.military.impl.MilitaryCensusRequestService" 
    parent="requestService">
    <property name="label" value="Military Census"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="xslFoFilename" value="militaryCensusRequest.xsl"/>
  </bean>
  
   <bean id="smsNotificationRequestService" 
    class="fr.cg95.cvq.service.leisure.impl.SmsNotificationRequestService" 
    parent="requestService">
    <property name="label" value="Sms Notification"/>
    <property name="localReferentialFilename" value="local_referential_sms.xml"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="smsNotificationRequest.xsl"/>
  </bean>

  <bean id="bulkyWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.environment.impl.BulkyWasteCollectionRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="false"/>
    <property name="label" value="Bulky Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_bwc.xml"/>
    <property name="xslFoFilename" value="bulkyWasteCollectionRequest.xsl"/>
  </bean>

  <bean id="compostableWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.environment.impl.CompostableWasteCollectionRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="false"/>
    <property name="label" value="Compostable Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_cwc.xml"/>
    <property name="xslFoFilename" value="compostableWasteCollectionRequest.xsl"/>
  </bean>

  <bean id="holidaySecurityRequestService"
    class="fr.cg95.cvq.service.localpolice.impl.HolidaySecurityRequestService"
    parent="requestService">
    <property name="label" value="Holiday Security" />
    <property name="xslFoFilename" value="holidaySecurityRequest.xsl" />
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
  </bean>

  <bean id="technicalInterventionRequestService"
    class="fr.cg95.cvq.service.technical.impl.TechnicalInterventionRequestService"
    parent="requestService">
    <property name="label" value="Technical Intervention" />
    <property name="localReferentialFilename" value="local_referential_tir.xml"/>
    <property name="xslFoFilename" value="technicalInterventionRequest.xsl" />
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
  </bean>

  <bean id="paymentService" class="fr.cg95.cvq.payment.impl.PaymentService">
    <property name="paymentDAO" ref="paymentDAO" />
    <property name="requestService" ref="defaultRequestService" />
    <property name="homeFolderService" ref="homeFolderService" />
  </bean>

  <!-- ======================================================= -->
  <!-- ================ EXTENSIONS POINTS ==================== -->  
  <!-- ======================================================= -->

  <!-- extension for external data importation -->
  <bean id="csvParserService" 
    class="fr.cg95.cvq.service.importer.impl.CsvParserService">
    <property name="importers">
      <list>
        <!-- properties added via plug-in mechanism -->
      </list>
    </property>
  </bean>

  <!-- ======================================================= -->
  <!-- =================== DAO DEFINITION ==================== -->  
  <!-- ======================================================= -->

  <bean id="genericDAO" class="fr.cg95.cvq.dao.hibernate.GenericDAO">
    <property name="cvqPolicy">
      <ref bean="cvqPolicy"/>
	</property>
  </bean>	

  <bean id="requestDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestDAO" parent="genericDAO"/>

  <bean id="requestTypeDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestTypeDAO" parent="genericDAO"/>

  <bean id="requestFormDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestFormDAO" parent="genericDAO"/>

  <bean id="documentTypeDAO" class="fr.cg95.cvq.dao.document.hibernate.DocumentTypeDAO" parent="genericDAO"/>

  <bean id="requestActionDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestActionDAO" parent="genericDAO"/>

  <bean id="requestNoteDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestNoteDAO" parent="genericDAO"/>

  <bean id="localAuthorityDAO" class="fr.cg95.cvq.dao.authority.hibernate.LocalAuthorityDAO" parent="genericDAO"/>

  <bean id="categoryDAO" class="fr.cg95.cvq.dao.authority.hibernate.CategoryDAO" parent="genericDAO"/>

  <bean id="agentDAO" class="fr.cg95.cvq.dao.authority.hibernate.AgentDAO" parent="genericDAO"/>

  <bean id="schoolDAO" class="fr.cg95.cvq.dao.authority.hibernate.SchoolDAO" parent="genericDAO"/>

  <bean id="recreationCenterDAO" class="fr.cg95.cvq.dao.authority.hibernate.RecreationCenterDAO" parent="genericDAO"/>

  <bean id="individualDAO" class="fr.cg95.cvq.dao.users.hibernate.IndividualDAO" parent="genericDAO"/>

  <bean id="adultDAO" class="fr.cg95.cvq.dao.users.hibernate.AdultDAO" parent="genericDAO"/>

  <bean id="childDAO" class="fr.cg95.cvq.dao.users.hibernate.ChildDAO" parent="genericDAO"/>

  <bean id="homeFolderDAO" class="fr.cg95.cvq.dao.users.hibernate.HomeFolderDAO" parent="genericDAO"/>

  <bean id="historyEntryDAO" class="fr.cg95.cvq.dao.users.hibernate.HistoryEntryDAO" parent="genericDAO"/>

  <bean id="documentDAO" class="fr.cg95.cvq.dao.document.hibernate.DocumentDAO" parent="genericDAO"/>

  <bean id="documentBinaryDAO" class="fr.cg95.cvq.dao.document.hibernate.DocumentBinaryDAO" parent="genericDAO"/>

  <bean id="paymentDAO" class="fr.cg95.cvq.dao.users.hibernate.PaymentDAO" parent="genericDAO"/>

  <bean id="meansOfContactDAO" class="fr.cg95.cvq.dao.request.hibernate.MeansOfContactDAO" parent="genericDAO"/>

</beans>
