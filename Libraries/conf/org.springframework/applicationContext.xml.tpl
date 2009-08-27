<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:aop="http://www.springframework.org/schema/aop"
     xmlns:context="http://www.springframework.org/schema/context"
     xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd 
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd 
http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">

  <aop:aspectj-autoproxy/>

  <bean id="loggingAspect" class="fr.cg95.cvq.util.development.LoggingAspect" />
  <bean id="contextAspect" class="fr.cg95.cvq.security.aspect.ContextAspect" />
  <bean id="hibernateExceptionTranslatorAspect" 
    class="fr.cg95.cvq.dao.hibernate.HibernateExceptionTranslatorAspect" />

  <!-- 
  <context:component-scan base-package="fr.cg95.cvq.service.request"/>
  -->
  
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

<!-- 
  <bean id="smsService" class="fr.cg95.cvq.util.sms.impl.SmsService">
    <property name="endportpath" value="${plugins.externalservices.clever.endportpath}"/> 
    <property name="username" value="${plugins.externalservices.clever.username}"/> 
    <property name="password" value="${plugins.externalservices.clever.password}"/>
    <property name="enabled" value="${plugins.externalservices.clever.enabled}" />
  </bean>
-->

  <bean id="fakeSmsService" class="fr.cg95.cvq.util.sms.impl.FakeSmsService" />
  
  <bean id="certificateService" class="fr.cg95.cvq.service.users.impl.CertificateService">
    <property name="localAuthorityRegistry">
      <ref bean="localAuthorityRegistry"/>
    </property>
    <property name="localizationService" ref="localizationService" />
    <property name="requestFormDAO" ref="requestFormDAO" />
    <!-- must be put somewhere on the using application's classpath -->
    <property name="fopConfig">
      <value>fop-config.xml</value>
    </property>
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
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
    <property name="agentService" ref="agentService" />
    <property name="individualService" ref="individualService" />
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
  
  <bean id="externalService" class="fr.cg95.cvq.external.impl.ExternalService" init-method="init">
    <property name="genericDAO" ref="genericDAO" />
    <property name="externalServiceTraceDAO" ref="externalServiceTraceDAO" />
    <!-- 
    <property name="homeFolderService" ref="homeFolderService" />
    -->
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
    <property name="agentDAO">
      <ref local="agentDAO"/>
    </property>
    <property name="categoryDAO">
      <ref local="categoryDAO"/>
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
  
  <bean id="requestContextCheckAspect" 
    class="fr.cg95.cvq.service.request.aspect.RequestContextCheckAspect">
    <property name="requestDAO" ref="requestDAO" />  
    <property name="requestTypeDAO" ref="requestTypeDAO" />
    <property name="categoryDAO" ref="categoryDAO" />
  </bean>

  <bean id="requestFilterAspect"
    class="fr.cg95.cvq.service.request.aspect.RequestFilterAspect">
    <property name="categoryService" ref="categoryService" />
  </bean>

  <bean id="requestService" class="fr.cg95.cvq.service.request.impl.RequestService"
    abstract="true" init-method="init">
    <property name="requestDAO" ref="requestDAO" />
    <property name="requestNoteDAO" ref="requestNoteDAO"/>
    <property name="requestFormDAO" ref="requestFormDAO"/>
    <property name="genericDAO" ref="genericDAO" />
    <property name="requestActionService" ref="requestActionService" />
    <property name="individualService" ref="individualService" />
    <property name="documentTypeService" ref="documentTypeService" />
    <property name="documentService" ref="documentService" />
    <property name="certificateService" ref="certificateService" />
    <property name="mailService" ref="mailService" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="requestTypeService" ref="requestTypeService" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
    <property name="agentService" ref="agentService" />
    <property name="requestNotificationService" ref="requestNotificationService" />
  </bean>
  
  <bean id="defaultRequestService" class="fr.cg95.cvq.service.request.impl.DefaultRequestService" 
    parent="requestService" />
  
  <bean id="requestServiceRegistry" class="fr.cg95.cvq.service.request.impl.RequestServiceRegistry"
    init-method="init">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="requestFormDAO" ref="requestFormDAO"/>
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="requestDAO" ref="requestDAO"/>
    <property name="performDbUpdates" value="@perform_db_updates@"/>
  </bean>

  <bean id="requestWorkflowService" class="fr.cg95.cvq.service.request.impl.RequestWorkflowService"
    init-method="init">
    <property name="requestDAO" ref="requestDAO" />
    <property name="requestActionService" ref="requestActionService" />
    <property name="requestNotificationService" ref="requestNotificationService" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="certificateService" ref="certificateService" />
    <property name="documentService" ref="documentService" />
    <!--
    <property name="homeFolderService" ref="homeFolderService" />
    -->
  </bean>

  <bean id="autofillService" class="fr.cg95.cvq.service.request.impl.AutofillService">
    <property name="individualService" ref="individualService"/>
  </bean>

  <bean id="requestTypeService" class="fr.cg95.cvq.service.request.impl.RequestTypeService">
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="requestFormDAO" ref="requestFormDAO"/>
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="documentTypeService" ref="documentTypeService" />
  </bean>

  <bean id="requestActionService" class="fr.cg95.cvq.service.request.impl.RequestActionService">
    <property name="requestDAO" ref="requestDAO"/>
    <property name="requestActionDAO" ref="requestActionDAO"/>
  </bean>

  <bean id="requestNotificationService"
    class="fr.cg95.cvq.service.request.impl.RequestNotificationService">
    <property name="requestDAO" ref="requestDAO" />
    <property name="mailService" ref="mailService" />
    <property name="individualService" ref="individualService"/>
    <property name="localAuthorityRegistry"><ref bean="localAuthorityRegistry"/></property>
    <property name="translationService" ref="translationService"/>
    <property name="agentService" ref="agentService" />
  </bean>

  <bean id="requestStatisticsService" class="fr.cg95.cvq.service.request.impl.RequestStatisticsService">
    <property name="requestStatisticsDAO" ref="requestStatisticsDAO"/>
    <property name="categoryService" ref="categoryService" />
    <property name="requestWorkflowService" ref="requestWorkflowService" />
  </bean>

  <!-- *******************************************************************  -->
  <!-- *********************** USERS SERVICES*****************************  -->
  <!-- *******************************************************************  -->

  <bean id="usersContextCheckAspect" 
    class="fr.cg95.cvq.service.users.aspect.UsersContextAspect">
  </bean>

  <bean id="voCardRequestService" class="fr.cg95.cvq.service.request.ecitizen.impl.VoCardRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="VO Card"/>
    <property name="xslFoFilename" value="voCardRequest"/>
  </bean>

  <bean id="individualService" class="fr.cg95.cvq.service.users.impl.IndividualService">
    <property name="individualDAO" ref="individualDAO"/>
    <property name="adultDAO" ref="adultDAO" />
    <property name="childDAO" ref="childDAO" />
    <property name="authenticationService" ref="authenticationService"/>
  </bean>

  <bean id="homeFolderService" class="fr.cg95.cvq.service.users.impl.HomeFolderService"
    init-method="init">
    <property name="localAuthorityRegistry"> 
  	 	<ref bean="localAuthorityRegistry"/>
  	</property>
	  <property name="mailService">
	   <ref local="mailService"/>
    </property>
    <property name="individualService">
      <ref local="individualService"/>
    </property>
    <property name="documentService" ref="documentService" />
    <!-- 
    <property name="requestService">
      <ref local="defaultRequestService"/>
    </property>
    <property name="requestWorkflowService">
      <ref local="requestWorkflowService"/>
    </property>
    -->
    <property name="paymentService">
      <ref local="paymentService"/>
    </property>
    <property name="externalService" ref="externalService" />
    <property name="genericDAO">
      <ref local="genericDAO"/>
    </property>
    <property name="homeFolderDAO">
      <ref local="homeFolderDAO"/>
    </property>
    <property name="childDAO">
      <ref local="childDAO"/>
    </property>
    <property name="adultDAO">
      <ref local="adultDAO"/>
    </property>
    <property name="individualDAO" ref="individualDAO" />
  </bean>
  
  <bean id="meansOfContactService" class="fr.cg95.cvq.service.request.impl.MeansOfContactService">
    <property name="meansOfContactDAO" ref="meansOfContactDAO" />
    <property name="performDbUpdates" value="@perform_db_updates@" />
    <property name="mailService" ref="mailService" />
    <property name="requestActionService" ref="requestActionService" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="smsService" ref="fakeSmsService" />
  </bean>

  <!-- ************************ DOCUMENTS RELATED SERVICES ********************* -->

  <bean id="documentContextCheckAspect" 
    class="fr.cg95.cvq.service.document.aspect.DocumentContextCheckAspect">
    <property name="documentDAO" ref="documentDAO" />  
  </bean>

  <bean id="documentService" class="fr.cg95.cvq.service.document.impl.DocumentService">
    <property name="documentDAO" ref="documentDAO"/>
    <property name="documentTypeDAO" ref="documentTypeDAO"/>
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>

  <bean id="documentTypeService" class="fr.cg95.cvq.service.document.impl.DocumentTypeService">
    <property name="documentTypeDAO" ref="documentTypeDAO"/>
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="performDbUpdates" value="@perform_db_updates@"/>
    <property name="documentBootstrapper">
      <bean class="fr.cg95.cvq.service.document.impl.DocumentBootstrapper">
        <property name="documentTypeDAO" ref="documentTypeDAO" />
      </bean>
    </property>
  </bean>

  <bean id="homeFolderModificationRequestService" 
    class="fr.cg95.cvq.service.request.ecitizen.impl.HomeFolderModificationRequestService" 
    parent="requestService">
    <property name="label" value="Home Folder Modification"/>
    <property name="xslFoFilename" value="homeFolderModificationRequest"/>
    <!-- service specifics -->
    <property name="historyEntryDAO">
      <ref local="historyEntryDAO"/>
    </property>
    <property name="historyInterceptor">
      <ref local="historyInterceptor"/>
    </property>
    <!-- end service specifics -->
  </bean>

  <bean id="schoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.SchoolRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="School Registration"/>
    <property name="xslFoFilename" value="schoolRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="perischoolActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.PerischoolActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_parr"/>
    <property name="label" value="Perischool Activity Registration"/>
    <property name="xslFoFilename" value="perischoolActivityRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="recreationActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.RecreationActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_rarr"/>
    <property name="label" value="Recreation Activity Registration"/>
    <property name="xslFoFilename" value="recreationActivityRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="schoolCanteenRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.SchoolCanteenRegistrationRequestService" 
    parent="requestService">
    <!-- Service specific -->
    <property name="localReferentialFilename" value="local_referential_scrr"/>
    <property name="label" value="School Canteen Registration"/>
    <property name="xslFoFilename" value="schoolCanteenRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="studyGrantRequestService"
    class="fr.cg95.cvq.service.request.school.impl.StudyGrantRequestService"
    parent="requestService">
    <!-- Service specific -->
    <property name="label" value="Study Grant"/>
    <property name="localReferentialFilename" value="local_referential_sgr"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="xslFoFilename" value="studyGrantRequest"/>
  </bean>

 <bean id="birthDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.BirthDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Birth Details"/>
    <property name="xslFoFilename" value="birthDetailsRequest"/>
 </bean>
  
  <bean id="marriageDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.MarriageDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Marriage Details" />
    <property name="xslFoFilename" value="marriageDetailsRequest"/>
  </bean>
  
  <bean id="deathDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.DeathDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Death Details" />
    <property name="xslFoFilename" value="deathDetailsRequest"/>
   </bean>

  <bean id="electoralRollRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.election.impl.ElectoralRollRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="Electoral Roll Registration"/>
    <property name="xslFoFilename" value="electoralRollRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="alignmentCertificateRequestService" 
    class="fr.cg95.cvq.service.request.urbanism.impl.AlignmentCertificateRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Alignment Certificate"/>
    <property name="xslFoFilename" value="alignmentCertificateRequest"/>
  </bean>

  <bean id="alignmentNumberingConnectionRequestService"
    class="fr.cg95.cvq.service.request.urbanism.impl.AlignmentNumberingConnectionRequestService"
    parent="requestService">
    <property name="label" value="Alignment Numbering Connection"/>
    <property name="xslFoFilename" value="alignmentNumberingConnectionRequest"/>
  </bean>

  <bean id="sewerConnectionRequestService" 
    class="fr.cg95.cvq.service.request.urbanism.impl.SewerConnectionRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Sewer Connection"/>
    <property name="xslFoFilename" value="sewerConnectionRequest"/>
  </bean>

  <bean id="libraryRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.culture.impl.LibraryRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_lrr"/>
    <property name="label" value="Library Registration"/>
    <property name="xslFoFilename" value="libraryRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="musicSchoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.music.impl.MusicSchoolRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_msrr"/>
    <property name="label" value="Music School Registration"/>
    <property name="xslFoFilename" value="musicSchoolRegistrationRequest"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
  </bean>

  <bean id="placeReservationRequestService" 
    class="fr.cg95.cvq.service.request.reservation.impl.PlaceReservationRequestService" 
    parent="requestService">
    <property name="label" value="Place Reservation"/>
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="placeReservationFilename" value="place_reservation_prr"/>
    <property name="externalReferentialFilename" value="external_referential_prr"/>
    <property name="placeReservationService" ref="placeReservationService" />
    <property name="xslFoFilename" value="placeReservationRequest"/>
  </bean>
  
  <bean id="remoteSupportRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.RemoteSupportRequestService" 
    parent="requestService">
    <property name="label" value="Remote Support"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="remoteSupportRequest"/>
  </bean>
  
  <bean id="domesticHelpRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.DomesticHelpRequestService" 
    parent="requestService">
    <property name="label" value="Domestic Help"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="domesticHelpRequest"/>
  </bean>
  
  <bean id="handicapCompensationAdultRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.HandicapCompensationAdultRequestService" 
    parent="requestService">
    <property name="label" value="Handicap Compensation Adult"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="handicapCompensationAdultRequest"/>
  </bean>
  
  <bean id="handicapCompensationChildRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.HandicapCompensationChildRequestService" 
    parent="requestService">
    <property name="label" value="Handicap Compensation Child"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="xslFoFilename" value="handicapCompensationChildRequest"/>
  </bean>  

  <bean id="militaryCensusRequestService" 
    class="fr.cg95.cvq.service.request.military.impl.MilitaryCensusRequestService" 
    parent="requestService">
    <property name="label" value="Military Census"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="xslFoFilename" value="militaryCensusRequest"/>
  </bean>
  
   <bean id="smsNotificationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.impl.SmsNotificationRequestService" 
    parent="requestService">
    <property name="label" value="Sms Notification"/>
    <property name="localReferentialFilename" value="local_referential_snr"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="xslFoFilename" value="smsNotificationRequest"/>
  </bean>

  <bean id="bulkyWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.request.environment.impl.BulkyWasteCollectionRequestService" 
    parent="requestService">
    <property name="label" value="Bulky Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_bwcr"/>
    <property name="xslFoFilename" value="bulkyWasteCollectionRequest"/>
  </bean>

  <bean id="compostableWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.request.environment.impl.CompostableWasteCollectionRequestService" 
    parent="requestService">
    <property name="label" value="Compostable Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_cwcr"/>
    <property name="xslFoFilename" value="compostableWasteCollectionRequest"/>
  </bean>

  <bean id="holidaySecurityRequestService"
    class="fr.cg95.cvq.service.request.localpolice.impl.HolidaySecurityRequestService"
    parent="requestService">
    <property name="label" value="Holiday Security" />
    <property name="xslFoFilename" value="holidaySecurityRequest" />
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
  </bean>

  <bean id="technicalInterventionRequestService"
    class="fr.cg95.cvq.service.request.technical.impl.TechnicalInterventionRequestService"
    parent="requestService">
    <property name="label" value="Technical Intervention" />
    <property name="localReferentialFilename" value="local_referential_tir"/>
    <property name="xslFoFilename" value="technicalInterventionRequest" />
    <property name="subjectPolicy" value="SUBJECT_POLICY_NONE" />
  </bean>

  <bean id="paymentService" class="fr.cg95.cvq.payment.impl.PaymentService" init-method="init">
    <property name="paymentDAO" ref="paymentDAO" />
    <!-- 
    <property name="requestService" ref="defaultRequestService" />
    <property name="homeFolderService" ref="homeFolderService" />
    <property name="externalService" ref="externalService" />
    -->
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

  <bean id="requestStatisticsDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestStatisticsDAO" parent="genericDAO"/>

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

  <bean id="paymentDAO" class="fr.cg95.cvq.dao.users.hibernate.PaymentDAO" parent="genericDAO"/>

  <bean id="meansOfContactDAO" class="fr.cg95.cvq.dao.request.hibernate.MeansOfContactDAO" parent="genericDAO"/>

  <bean id="externalServiceTraceDAO" class="fr.cg95.cvq.dao.external.hibernate.ExternalServiceTraceDAO" parent="genericDAO" />
  
</beans>
