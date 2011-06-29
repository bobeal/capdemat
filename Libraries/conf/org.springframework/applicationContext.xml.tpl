<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns:aop="http://www.springframework.org/schema/aop"
     xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">

  <aop:aspectj-autoproxy/>

  <bean id="loggingAspect" class="fr.cg95.cvq.util.development.LoggingAspect" />
  <bean id="contextAspect" class="fr.cg95.cvq.security.aspect.ContextAspect" />
  <bean id="hibernateExceptionTranslatorAspect" 
    class="fr.cg95.cvq.dao.hibernate.HibernateExceptionTranslatorAspect" />
  <bean id="requestCompositionEnforcingAspect"
    class="fr.cg95.cvq.dao.request.RequestCompositionEnforcingAspect" />

  <!-- ======================================================= -->
  <!-- ========== GENERAL SERVICES DEFINITION ================ -->  
  <!-- ======================================================= -->

  <bean id="authenticationService" 
    class="fr.cg95.cvq.authentication.impl.AuthenticationService">
    <property name="individualDAO" ref="individualDAO"/>
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
  
  <bean id="requestPdfService" class="fr.cg95.cvq.service.request.impl.RequestPdfService">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="translationService" ref="translationService"/>
    <property name="individualService" ref="individualService"/>
    <property name="homeFolderService" ref="homeFolderService" />
    <property name="localReferentialService" ref="localReferentialService"/>
    <property name="requestSearchService" ref="requestSearchService"/>
    <property name="agentService" ref="agentService"/>
    <property name="externalService" ref="externalService"/>
    <property name="documentService" ref="documentService"/>
  </bean>

  <!-- history interceptor that logs all changes made on home folders -->
  <bean id="historyInterceptor" class="fr.cg95.cvq.dao.hibernate.HistoryInterceptor">
  </bean>

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
  
  <bean id="externalService" class="fr.cg95.cvq.external.impl.ExternalService">
    <property name="externalServiceTraceDAO" ref="externalServiceTraceDAO" />
    <property name="externalServiceMappingDAO" ref="externalServiceMappingDAO" />
  </bean>

  <!-- *******************************************************************  -->
  <!-- ******************** AUTHORITY SERVICES ***************************  -->
  <!-- *******************************************************************  -->

  <bean id="localAuthoritiesLoader"
    class="fr.cg95.cvq.service.authority.LocalAuthoritiesLoader"
    init-method="init" depends-on="securityContext">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>

  <bean id="agentService" class="fr.cg95.cvq.service.authority.impl.AgentService">
    <property name="agentDAO" ref="agentDAO"/>
  </bean>

  <bean id="schoolService" class="fr.cg95.cvq.service.authority.impl.SchoolService">
    <property name="DAO" ref="schoolDAO"/>
  </bean>

  <bean id="recreationCenterService" 
    class="fr.cg95.cvq.service.authority.impl.RecreationCenterService">
    <property name="DAO" ref="recreationCenterDAO"/>
  </bean>

  <!-- ******************** REQUEST SERVICES **********************  -->
  
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

  <bean id="localReferentialService"
    class="fr.cg95.cvq.service.request.impl.LocalReferentialService">
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
  </bean>
  <bean id="localReferentialServiceToLocalReferentialCheckInjector"
    class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod"
      value="fr.cg95.cvq.service.request.LocalReferentialCheck.setLocalReferentialService" />
    <property name="arguments">
      <list>
        <ref local="localReferentialService" />
      </list>
    </property>
  </bean>
  
  <bean id="categoryService" class="fr.cg95.cvq.service.request.impl.CategoryService">
    <property name="categoryDAO" ref="categoryDAO"/>
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="agentService" ref="agentService" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
  </bean>

  <bean id="requestService" class="fr.cg95.cvq.service.request.impl.RequestService"
    abstract="true" init-method="init">
    <property name="genericDAO" ref="genericDAO" />
    <property name="filingDelay" value="6"/>
    <property name="archiveDocuments" value="false"/>
  </bean>
  
  <bean id="requestServiceRegistry" class="fr.cg95.cvq.service.request.impl.RequestServiceRegistry">
    <property name="requestDAO" ref="requestDAO"/>
  </bean>

  <bean id="requestServiceRegistryToSubjectIdCheckInjector"
    class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod"
      value="fr.cg95.cvq.service.request.SubjectIdCheck.setRequestServiceRegistry" />
    <property name="arguments">
      <list>
        <ref local="requestServiceRegistry" />
      </list>
    </property>
  </bean>

  <bean id="requestWorkflowService" class="fr.cg95.cvq.service.request.impl.RequestWorkflowService">
    <property name="requestDAO" ref="requestDAO" />
    <property name="requestActionService" ref="requestActionService" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="requestExternalService" ref="requestExternalService" />
    <property name="documentService" ref="documentService" />
    <property name="homeFolderService" ref="homeFolderService" />
    <property name="individualService" ref="individualService" />
    <property name="requestDocumentService" ref="requestDocumentService" />
    <property name="requestTypeService" ref="requestTypeService" />
    <property name="requestPdfService" ref="requestPdfService" />
  </bean>

  <bean id="requestWorkflowServiceToSubjectIdCheckInjector"
    class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod"
      value="fr.cg95.cvq.service.request.SubjectIdCheck.setRequestWorkflowService" />
    <property name="arguments">
      <list>
        <ref local="requestWorkflowService" />
      </list>
    </property>
  </bean>

  <bean id="autofillService" class="fr.cg95.cvq.service.request.impl.AutofillService">
    <property name="individualService" ref="individualService"/>
  </bean>

  <bean id="conditionService" class="fr.cg95.cvq.service.request.impl.ConditionService">
    <property name="requestServiceRegistry" ref="requestServiceRegistry"/>
  </bean>

  <bean id="requestTypeService" class="fr.cg95.cvq.service.request.impl.RequestTypeService"
    init-method="init">
    <property name="performDbUpdates" value="@perform_db_updates@"/>
    <property name="genericDAO" ref="genericDAO"/>
    <property name="requestDAO" ref="requestDAO"/>
    <property name="requestTypeDAO" ref="requestTypeDAO"/>
    <property name="requestFormDAO" ref="requestFormDAO"/>
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="documentTypeService" ref="documentTypeService" />
    <property name="categoryService" ref="categoryService" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
    <property name="requestSearchService" ref="requestSearchService" />
    <property name="authenticationService" ref="authenticationService" />
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
    <property name="requestTypeService" ref="requestTypeService" />
  </bean>

  <bean id="requestExternalService" class="fr.cg95.cvq.service.request.impl.RequestExternalService">
    <property name="requestDAO" ref="requestDAO" />
    <property name="externalService" ref="externalService" />
    <property name="requestExportService" ref="requestExportService" />
  </bean>

  <bean id="requestExportService" class="fr.cg95.cvq.service.request.impl.RequestExportService">
    <property name="homeFolderService" ref="homeFolderService" />
    <property name="individualService" ref="individualService" />
  </bean>
  
  <bean id="requestSearchService" class="fr.cg95.cvq.service.request.impl.RequestSearchService">
    <property name="requestDAO" ref="requestDAO" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
  </bean>

  <bean id="requestSearchServiceToSubjectIdCheckInjector"
    class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
    <property name="staticMethod"
      value="fr.cg95.cvq.service.request.SubjectIdCheck.setRequestSearchService" />
    <property name="arguments">
      <list>
        <ref local="requestSearchService" />
      </list>
    </property>
  </bean>

  <bean id="requestDocumentService" class="fr.cg95.cvq.service.request.impl.RequestDocumentService">
    <property name="documentService" ref="documentService" />
    <property name="requestDAO" ref="requestDAO" />
  </bean>
  
  <bean id="requestLockService" class="fr.cg95.cvq.service.request.impl.RequestLockService">
    <property name="requestDAO" ref="requestDAO" />  
    <property name="requestTypeService" ref="requestTypeService" />
  </bean>
  
  <bean id="requestNoteService" class="fr.cg95.cvq.service.request.impl.RequestNoteService">
    <property name="requestDAO" ref="requestDAO" />
    <property name="requestNoteDAO" ref="requestNoteDAO" />
    <property name="agentService" ref="agentService" />
  </bean>
  
  <bean id="requestPaymentsListener" class="fr.cg95.cvq.service.request.impl.RequestPaymentsListener">
    <property name="requestDAO" ref="requestDAO" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
    <property name="requestWorkflowService" ref="requestWorkflowService" />
  </bean>

   <bean id="ticketBookingService" class="fr.cg95.cvq.service.request.impl.TicketBookingService">
    <property name="ticketBookingDAO" ref="ticketBookingDAO" />
    <property name="localReferentialService" ref="localReferentialService" />
  </bean>

  <!-- *************************************************************************  -->
  <!-- ************************ DOCUMENTS RELATED SERVICES *********************  -->
  <!-- *************************************************************************  -->

  <bean id="documentContextCheckAspect" 
    class="fr.cg95.cvq.service.document.aspect.DocumentContextCheckAspect">
    <property name="documentDAO" ref="documentDAO" />  
  </bean>

  <bean id="documentService" class="fr.cg95.cvq.service.document.impl.DocumentService">
    <property name="documentDAO" ref="documentDAO"/>
    <property name="documentTypeDAO" ref="documentTypeDAO"/>
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="translationService" ref="translationService"/>
  </bean>

  <bean id="documentTypeService" class="fr.cg95.cvq.service.document.impl.DocumentTypeService">
    <property name="documentTypeDAO" ref="documentTypeDAO"/>
    <property name="performDbUpdates" value="@perform_db_updates@"/>
    <property name="documentBootstrapper">
      <bean class="fr.cg95.cvq.service.document.impl.DocumentBootstrapper">
        <property name="documentTypeDAO" ref="documentTypeDAO" />
      </bean>
    </property>
  </bean>

  <!-- *******************************************************************  -->
  <!-- *********************** USERS SERVICES*****************************  -->
  <!-- *******************************************************************  -->

  <bean id="usersContextCheckAspect" 
    class="fr.cg95.cvq.service.users.aspect.UsersContextAspect">
  </bean>

  <bean id="individualService" class="fr.cg95.cvq.service.users.impl.IndividualService">
    <property name="individualDAO" ref="individualDAO"/>
    <property name="adultDAO" ref="adultDAO" />
    <property name="childDAO" ref="childDAO" />
    <property name="authenticationService" ref="authenticationService"/>
  </bean>

  <bean id="homeFolderService" class="fr.cg95.cvq.service.users.impl.HomeFolderService">
    <property name="localAuthorityRegistry"> 
  	 	<ref bean="localAuthorityRegistry"/>
  	</property>
    <property name="mailService">
	   <ref local="mailService"/>
    </property>
    <property name="individualService" ref="individualService"/>
    <property name="genericDAO" ref="genericDAO" />
    <property name="homeFolderDAO" ref="homeFolderDAO"/>
    <property name="childDAO" ref="childDAO"/>
    <property name="adultDAO" ref="adultDAO"/>
    <property name="individualDAO" ref="individualDAO" />
    <property name="historyInterceptor">
      <ref local="historyInterceptor"/>
    </property>
  </bean>
  
  <bean id="meansOfContactService" class="fr.cg95.cvq.service.request.impl.MeansOfContactService">
    <property name="meansOfContactDAO" ref="meansOfContactDAO" />
    <property name="performDbUpdates" value="@perform_db_updates@" />
    <property name="mailService" ref="mailService" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry"/>
    <property name="smsService" ref="fakeSmsService" />
  </bean>

  <bean id="voCardRequestService" class="fr.cg95.cvq.service.request.ecitizen.impl.VoCardRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="VO Card"/>
  </bean>

  <bean id="homeFolderModificationRequestService" 
    class="fr.cg95.cvq.service.request.ecitizen.impl.HomeFolderModificationRequestService" 
    parent="requestService">
    <property name="label" value="Home Folder Modification"/>
    <!-- service specifics -->
    <property name="historyEntryDAO" ref="historyEntryDAO" />
    <property name="homeFolderService" ref="homeFolderService" />
    <property name="individualService" ref="individualService" />
    <property name="requestDAO" ref="requestDAO" />
    <!-- end service specifics -->
  </bean>

  <bean id="schoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.SchoolRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="School Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="perischoolActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.PerischoolActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_parr"/>
    <property name="label" value="Perischool Activity Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="recreationActivityRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.RecreationActivityRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_rarr"/>
    <property name="label" value="Recreation Activity Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="schoolCanteenRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.SchoolCanteenRegistrationRequestService" 
    parent="requestService">
    <!-- Service specific -->
    <property name="localReferentialFilename" value="local_referential_scrr"/>
    <property name="label" value="School Canteen Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="studyGrantRequestService"
    class="fr.cg95.cvq.service.request.school.impl.StudyGrantRequestService"
    parent="requestService">
    <!-- Service specific -->
    <property name="label" value="Study Grant"/>
    <property name="localReferentialFilename" value="local_referential_sgr"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="requestDAO" ref="requestDAO"/>
    <property name="filingDelay" value="12"/>
  </bean>

 <bean id="birthDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.BirthDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Birth Details"/>
    <property name="defaultDisplayGroup" value="civil" />
 </bean>
  
  <bean id="marriageDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.MarriageDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Marriage Details" />
    <property name="defaultDisplayGroup" value="civil" />
  </bean>
  
  <bean id="deathDetailsRequestService" 
    class="fr.cg95.cvq.service.request.civil.impl.DeathDetailsRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true" />
    <property name="label" value="Death Details" />
    <property name="defaultDisplayGroup" value="civil" />
   </bean>

  <bean id="electoralRollRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.election.impl.ElectoralRollRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="Electoral Roll Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="election" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="alignmentCertificateRequestService" 
    class="fr.cg95.cvq.service.request.urbanism.impl.AlignmentCertificateRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Alignment Certificate"/>
    <property name="defaultDisplayGroup" value="urbanism" />
  </bean>

  <bean id="alignmentNumberingConnectionRequestService"
    class="fr.cg95.cvq.service.request.urbanism.impl.AlignmentNumberingConnectionRequestService"
    parent="requestService">
    <property name="label" value="Alignment Numbering Connection"/>
    <property name="defaultDisplayGroup" value="urbanism" />
  </bean>

  <bean id="sewerConnectionRequestService" 
    class="fr.cg95.cvq.service.request.urbanism.impl.SewerConnectionRequestService" 
    parent="requestService">
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="label" value="Sewer Connection"/>
    <property name="defaultDisplayGroup" value="urbanism" />
  </bean>

  <bean id="libraryRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.culture.impl.LibraryRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_lrr"/>
    <property name="label" value="Library Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="culture" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="musicSchoolRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.music.impl.MusicSchoolRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_msrr"/>
    <property name="label" value="Music School Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="leisure" />
    <property name="filingDelay" value="12"/>
  </bean>

  <bean id="ticketBookingRequestService"
    class="fr.cg95.cvq.service.request.reservation.impl.TicketBookingRequestService"
    parent="requestService">
    <property name="label" value="Ticket Booking"/>
    <property name="localReferentialFilename" value="local_referential_tbr"/>
    <property name="externalReferentialFilename" value="external_referential_tor"/>
    <property name="supportUnregisteredCreation" value="true"/>
    <property name="defaultDisplayGroup" value="culture" />
    <property name="ticketBookingService" ref="ticketBookingService" />
  </bean>
  
  <bean id="remoteSupportRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.RemoteSupportRequestService" 
    parent="requestService">
    <property name="label" value="Remote Support"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="defaultDisplayGroup" value="social" />
  </bean>
  
  <bean id="domesticHelpRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.DomesticHelpRequestService" 
    parent="requestService">
    <property name="label" value="Domestic Help"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="defaultDisplayGroup" value="social" />
  </bean>
  
  <bean id="handicapCompensationAdultRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.HandicapCompensationAdultRequestService" 
    parent="requestService">
    <property name="label" value="Handicap Compensation Adult"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="defaultDisplayGroup" value="social" />
  </bean>
  
  <bean id="handicapCompensationChildRequestService" 
    class="fr.cg95.cvq.service.request.social.impl.HandicapCompensationChildRequestService" 
    parent="requestService">
    <property name="label" value="Handicap Compensation Child"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="defaultDisplayGroup" value="social" />
  </bean>  

  <bean id="militaryCensusRequestService" 
    class="fr.cg95.cvq.service.request.military.impl.MilitaryCensusRequestService" 
    parent="requestService">
    <property name="label" value="Military Census"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="defaultDisplayGroup" value="civil" />
  </bean>
  
   <bean id="smsNotificationRequestService" 
    class="fr.cg95.cvq.service.request.leisure.impl.SmsNotificationRequestService" 
    parent="requestService">
    <property name="label" value="Sms Notification"/>
    <property name="localReferentialFilename" value="local_referential_snr"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="defaultDisplayGroup" value="leisure" />
  </bean>

  <bean id="bulkyWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.request.environment.impl.BulkyWasteCollectionRequestService" 
    parent="requestService">
    <property name="label" value="Bulky Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_bwcr"/>
    <property name="defaultDisplayGroup" value="environment" />
  </bean>

  <bean id="compostableWasteCollectionRequestService" 
    class="fr.cg95.cvq.service.request.environment.impl.CompostableWasteCollectionRequestService" 
    parent="requestService">
    <property name="label" value="Compostable Waste Collection"/>
    <property name="localReferentialFilename" value="local_referential_cwcr"/>
    <property name="defaultDisplayGroup" value="environment" />
  </bean>

  <bean id="holidaySecurityRequestService"
    class="fr.cg95.cvq.service.request.localpolice.impl.HolidaySecurityRequestService"
    parent="requestService">
    <property name="label" value="Holiday Security" />
    <property name="subjectPolicy" value="SUBJECT_POLICY_ADULT" />
    <property name="defaultDisplayGroup" value="security" />
  </bean>

  <bean id="technicalInterventionRequestService"
    class="fr.cg95.cvq.service.request.technical.impl.TechnicalInterventionRequestService"
    parent="requestService">
    <property name="label" value="Technical Intervention" />
    <property name="localReferentialFilename" value="local_referential_tir"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_NONE" />
    <property name="defaultDisplayGroup" value="technical" />
  </bean>
 <!-- school registration simplify request-->
  
  <bean id="schoolRegistrationSimplifyRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.SchoolRegistrationSimplifyRequestService" 
    parent="requestService">
    <property name="label" value="School Registration Simplify"/>
    <property name="localReferentialFilename" value="local_referential_srsr"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="school" />
    <property name="filingDelay" value="12"/>
  </bean>
  
  	<!-- Multi Cerfa Electoral Roll Registration Request -->

	<bean id="multiCerfaElectoralRollRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.election.impl.MultiCerfaElectoralRollRegistrationRequestService" 
    parent="requestService">
    <property name="label" value="Multi Cerfa Electoral Roll Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_INDIVIDUAL" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="defaultDisplayGroup" value="election" />
    <property name="filingDelay" value="12"/>
  </bean> 

	<!-- Recreation Center Poly Registration Request -->

	<bean id="recreationActivityPolyRegistrationRequestService" 
    class="fr.cg95.cvq.service.request.school.impl.RecreationActivityPolyRegistrationRequestService" 
    parent="requestService">
    <property name="localReferentialFilename" value="local_referential_raprr"/>
    <property name="label" value="Recreation Activity Poly Registration"/>
    <property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
    <property name="defaultDisplayGroup" value="school" />
    <property name="isOfRegistrationKind" value="true"/>
    <property name="filingDelay" value="12"/>
  </bean>
  

	<!-- Child Care Center Registration Request -->
	<bean id="childCareCenterRegistrationRequestService"
	  class="fr.cg95.cvq.service.request.school.impl.ChildCareCenterRegistrationRequestService" 
	  parent="requestService">
	<property name="homeFolderService" ref="homeFolderService" />
    <property name="individualService" ref="individualService" />
	  <property name="localReferentialFilename" value="local_referential_cccrr"/>
    	<property name="label" value="Child Care Center Registration"/>
    	<property name="subjectPolicy" value="SUBJECT_POLICY_CHILD" />
  	  <property name="defaultDisplayGroup" value="childCare" />
    	<property name="filingDelay" value="12"/>
	</bean>
  
  
  <bean id="paymentFilterAspect"
    class="fr.cg95.cvq.service.payment.aspect.PaymentFilterAspect" />

  <bean id="paymentService" class="fr.cg95.cvq.service.payment.impl.PaymentService">
    <property name="paymentDAO" ref="paymentDAO" />
    <property name="localAuthorityRegistry" ref="localAuthorityRegistry" />
    <property name="mailService" ref="mailService" />
    <property name="individualService" ref="individualService" />
  </bean>

  <bean id="displayGroupService" class="fr.cg95.cvq.service.request.impl.DisplayGroupService">
    <property name="genericDAO" ref="genericDAO" />
    <property name="requestTypeDAO" ref="requestTypeDAO" />
    <property name="requestServiceRegistry" ref="requestServiceRegistry" />
  </bean>

  <!-- ======================================================= -->
  <!-- ================ EXTENSIONS POINTS ==================== -->  
  <!-- ======================================================= -->

  <!-- extension for external data importation -->
  <bean id="csvParserService" 
    class="fr.cg95.cvq.service.importer.impl.CsvParserService">
    <property name="importers">
      <set>
        <!-- properties added via plug-in mechanism -->
      </set>
    </property>
  </bean>

  <!-- ======================================================= -->
  <!-- =================== DAO DEFINITION ==================== -->  
  <!-- ======================================================= -->

  <bean id="genericDAO" class="fr.cg95.cvq.dao.hibernate.GenericDAO" />

  <bean id="requestDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestDAO" parent="genericDAO"/>

  <bean id="requestStatisticsDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestStatisticsDAO" parent="genericDAO"/>

  <bean id="requestTypeDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestTypeDAO" parent="genericDAO"/>

  <bean id="requestFormDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestFormDAO" parent="genericDAO"/>

  <bean id="documentTypeDAO" class="fr.cg95.cvq.dao.document.hibernate.DocumentTypeDAO" parent="genericDAO"/>

  <bean id="requestActionDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestActionDAO" parent="genericDAO"/>

  <bean id="requestNoteDAO" class="fr.cg95.cvq.dao.request.hibernate.RequestNoteDAO" parent="genericDAO"/>

  <bean id="localAuthorityDAO" class="fr.cg95.cvq.dao.authority.hibernate.LocalAuthorityDAO" parent="genericDAO"/>

  <bean id="categoryDAO" class="fr.cg95.cvq.dao.request.hibernate.CategoryDAO" parent="genericDAO"/>

  <bean id="agentDAO" class="fr.cg95.cvq.dao.authority.hibernate.AgentDAO" parent="genericDAO"/>

  <bean id="schoolDAO" class="fr.cg95.cvq.dao.authority.hibernate.SchoolDAO" parent="genericDAO"/>

  <bean id="recreationCenterDAO" class="fr.cg95.cvq.dao.authority.hibernate.RecreationCenterDAO" parent="genericDAO"/>

  <bean id="individualDAO" class="fr.cg95.cvq.dao.users.hibernate.IndividualDAO" parent="genericDAO"/>

  <bean id="adultDAO" class="fr.cg95.cvq.dao.users.hibernate.AdultDAO" parent="genericDAO"/>

  <bean id="childDAO" class="fr.cg95.cvq.dao.users.hibernate.ChildDAO" parent="genericDAO"/>

  <bean id="homeFolderDAO" class="fr.cg95.cvq.dao.users.hibernate.HomeFolderDAO" parent="genericDAO"/>

  <bean id="historyEntryDAO" class="fr.cg95.cvq.dao.users.hibernate.HistoryEntryDAO" parent="genericDAO"/>

  <bean id="documentDAO" class="fr.cg95.cvq.dao.document.hibernate.DocumentDAO" parent="genericDAO"/>

  <bean id="paymentDAO" class="fr.cg95.cvq.dao.payment.hibernate.PaymentDAO" parent="genericDAO"/>

  <bean id="meansOfContactDAO" class="fr.cg95.cvq.dao.request.hibernate.MeansOfContactDAO" parent="genericDAO"/>

  <bean id="externalServiceTraceDAO" class="fr.cg95.cvq.dao.external.hibernate.ExternalServiceTraceDAO" parent="genericDAO" />

  <bean id="externalServiceMappingDAO" class="fr.cg95.cvq.dao.external.hibernate.ExternalServiceMappingDAO" parent="genericDAO" />
  
  <bean id="ticketBookingDAO" class="fr.cg95.cvq.dao.request.hibernate.TicketBookingDAO" parent="genericDAO" />

</beans>
