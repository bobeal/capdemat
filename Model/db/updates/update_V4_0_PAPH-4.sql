-- Remove Handicap allowance request    
    alter table handicap_allowance_request 
        drop constraint FKF20630A182587E99;

    alter table har_care_assistant 
        drop constraint FK173D3D96E5852A38;

    alter table har_carer 
        drop constraint FKCE62C65BE5852A38;

    alter table har_disability_related_cost 
        drop constraint FKE037E63EE5852A38;

    alter table har_family_carer 
        drop constraint FK911D22CCE5852A38;

    alter table har_family_dependent 
        drop constraint FK6EEA28CAE5852A38;

    alter table har_other_files 
        drop constraint FKD5F7E3E2E5852A38;

    drop table har_care_assistant;

    drop table har_carer;

    drop table har_disability_related_cost;

    drop table har_family_carer;

    drop table har_family_dependent;

    drop table har_other_files;

    drop table har_professional;
    
    drop table handicap_allowance_request;
    
	delete from forms where request_type_id in (select id from request_type where label = 'Handicap Allowance');
    delete from requirement where request_type_id = (select id  FROM request_type where label = 'Handicap Allowance');
	delete from request_type where label = 'Handicap Allowance';
	
-- Remove Remote Support request 	

--    alter table remote_support_request 
--        drop constraint FKEAA6DC2682587E99;

--    alter table remote_support_request 
--        drop constraint FKEAA6DC26413637F3;
        
    drop table remote_support_request;
    
-- Create Remote Support request 
	create table remote_support_request (
        id int8 not null,
        trustee_phone varchar(10),
        spouse_is_disabled_person bool,
        subject_birth_date timestamp,
        subject_is_a_p_a_beneficiary bool,
        subject_reside_with varchar(255),
        spouse_birth_date timestamp,
        contact_phone varchar(10),
        spouse_last_name varchar(38),
        request_information_emergency bool,
        request_information_request_kind varchar(255),
        subject_is_disabled_person bool,
        second_contact_last_name varchar(38),
        request_information_emergency_motive varchar(180),
        contact_last_name varchar(38),
        spouse_title varchar(255),
        subject_title varchar(255),
        spouse_first_name varchar(38),
        contact_first_name varchar(38),
        trustee_first_name varchar(38),
        contact_kind varchar(255),
        second_contact_first_name varchar(38),
        subject_is_taxable bool,
        trustee_last_name varchar(38),
        second_contact_phone varchar(10),
        primary key (id)
    );
    
    alter table remote_support_request 
        add constraint FKEAA6DC2682587E99 
        foreign key (id) 
        references request;
           
-- Create Handicap Compensation Adult request    

	create table handicap_compensation_adult_request (
        id int8 not null,
        health_followed_by_professional bool,
        professional_support_professionals bool,
        is_family_assistance bool,
        project_comments varchar(600),
        folders_mdph_department varchar(2),
        folders_cdes bool,
        project_needs varchar(600),
        benefits_education_allocation_of_disabled_children bool,
        home_intervention_home_intervenant bool,
        folders_mdph_number varchar(30),
        project_requests_housing_facilities bool,
        subject_birth_date timestamp,
        benefits_disability_pension bool,
        legal_access_presence bool,
        subject_maiden_name varchar(38),
        project_requests_disabled_worker_recognition bool,
        benefits_unemployment_benefits bool,
        professional_status_kind varchar(255),
        family_family_dependents bool,
        formation_previous_formation varchar(180),
        benefits_education_of_disabled_children_details varchar(60),
        project_requests_vocational_training bool,
        facilities_custom_car bool,
        legal_access_representative_kind_detail varchar(80),
        professional_status_indemnified bool,
        benefits_disabled_adult_allocation bool,
        benefits_third_party_compensatory_allowance bool,
        professional_status_date timestamp,
        project_requests_transport_cost_allocation bool,
        benefits_professional_orientation bool,
        benefits_disability_recognition bool,
        professional_status_register_as_unemployed bool,
        dwelling_social_reception_naming varchar(80),
        professional_status_indemnified_date timestamp,
        family_status varchar(255),
        benefits_painful_standing_card bool,
        benefits_professional_orientation_details varchar(60),
        folders_cdes_department varchar(2),
        facilities_specialized_transport bool,
        benefits_parking_card bool,
        facilities_specialized_transport_details varchar(60),
        professional_support_social_service_support bool,
        social_security_number varchar(13),
        benefits_work_accident_annuity_ratio varchar(3),
        benefits_work_accident_annuity bool,
        care_care_services bool,
        benefits_disability_ratio varchar(3),
        benefits_daily_allowances bool,
        project_requests_custom_car bool,
        payment_agency_beneficiary_number varchar(20),
        folders_cotorep_number varchar(30),
        project_requests_a_c_t_p_renewal bool,
        dwelling_social_reception_address_id int8,
        folders_mdph bool,
        benefits_supported_by_an_institution_details varchar(60),
        professional_support_deals_with_same_professional bool,
        dwelling_establishment_reception bool,
        folders_cotorep_department varchar(2),
        project_requests_ordinary_working bool,
        legal_access_representative_first_name varchar(38),
        dwelling_social_reception bool,
        benefits_disabled_worker_recognition bool,
        project_requests_european_parking_card bool,
        health_followed_by_doctor bool,
        project_requests_free_pension_membership bool,
        health_followed_by_hospital bool,
        professional_status_employer_name varchar(38),
        project_requests_institution_support bool,
        benefits_social_welfare bool,
        project_requests_handicap_recognition bool,
        project_wish varchar(600),
        dwelling_kind varchar(255),
        health_professional_last_name varchar(38),
        formation_studies_level varchar(30),
        project_requests_professional_orientation bool,
        health_doctor_last_name varchar(38),
        legal_access_kind varchar(255),
        facilities_housing_details varchar(60),
        benefits_supplement_for_single_parents bool,
        project_requests_increase_for_independent_living bool,
        benefits_disability_pension_category varchar(60),
        benefits_third_party_supplement bool,
        studies_high_school_grade varchar(60),
        subject_birth_city varchar(32),
        legal_access_representative_name varchar(38),
        project_requests_assistance bool,
        professional_status_environment varchar(255),
        benefits_supported_by_an_institution bool,
        project_requests_third_party_help bool,
        project_requests_disabled_adult_allowance bool,
        payment_agency_beneficiary varchar(255),
        folders_other_folders bool,
        facilities_animal_aid_details varchar(60),
        studies_assistance_under_disability_details varchar(60),
        payment_agency_address_id int8,
        project_requests_other bool,
        benefits_third_person_compensatory_allowance bool,
        project_requests_disability_cost_allocation bool,
        social_security_agency_address_id int8,
        dwelling_reception_address_id int8,
        professional_status_profession varchar(60),
        professional_status_address_id int8,
        formation_diploma varchar(120),
        subject_title varchar(255),
        professional_status_elective_function bool,
        folders_cotorep bool,
        benefits_increase_for_independent_living bool,
        subject_birth_country varchar(50),
        project_requests_disability_card bool,
        studies_high_school_name varchar(60),
        dwelling_reception_type varchar(255),
        professional_status_register_as_unemployed_date timestamp,
        payment_agency_name varchar(50),
        dwelling_reception_naming varchar(80),
        social_security_agency_name varchar(50),
        benefits_education_of_disabled_children bool,
        facilities_technical_assistance_details varchar(60),
        benefits_other_benefits bool,
        folders_cdes_number varchar(30),
        benefits_disability_compensation bool,
        health_doctor_first_name varchar(38),
        project_requests_technical_help bool,
        facilities_technical_assistance bool,
        benefits_compensatory_allowance_for_expenses bool,
        facilities_housing bool,
        health_hospital_name varchar(60),
        project_requests_disabled_priority_card bool,
        project_requests_education_allocation_of_disabled_children bool,
        project_requests_other_details varchar(60),
        legal_access_representative_kind varchar(255),
        project_requests_sheltered_work bool,
        formation_current_formation varchar(120),
        studies_assistance_under_disability bool,
        professional_support_social_service_address_id int8,
        studies_high_school bool,
        health_professional_first_name varchar(38),
        professional_support_social_service_name varchar(60),
        facilities_custom_car_details varchar(60),
        dwelling_precision varchar(120),
        benefits_disability_card bool,
        social_security_member_ship_kind varchar(255),
        professional_status_elective_function_details varchar(60),
        facilities_animal_aid bool,
        studies_high_school_address_id int8,
        primary key (id)
    );

create table hcar_additional_fee (
        id int8 not null,
        additional_fee_kind varchar(30),
        additional_fee_periodicity varchar(30),
        additional_fee_cost varchar(6),
        handicap_compensation_adult_request_id int8,
        additional_fee_index int4,
        primary key (id)
    );

    create table hcar_care_service (
        id int8 not null,
        care_service_care_service_employer bool,
        care_service_kind varchar(255),
        care_service_provider_name varchar(38),
        care_service_provider_address_id int8,
        handicap_compensation_adult_request_id int8,
        care_services_index int4,
        primary key (id)
    );

    create table hcar_family_assistance_member (
        id int8 not null,
        family_assistance_member_last_name varchar(38),
        family_assistance_member_relationship varchar(60),
        family_assistance_member_first_name varchar(38),
        handicap_compensation_adult_request_id int8,
        family_assistance_members_index int4,
        primary key (id)
    );

    create table hcar_family_dependent (
        id int8 not null,
        family_dependent_actual_situation varchar(255),
        family_dependent_last_name varchar(38),
        family_dependent_first_name varchar(38),
        family_dependent_birth_date timestamp,
        handicap_compensation_adult_request_id int8,
        family_dependents_index int4,
        primary key (id)
    );

    create table hcar_home_intervenant (
        id int8 not null,
        home_intervenant_kind varchar(255),
        home_intervenant_details varchar(60),
        handicap_compensation_adult_request_id int8,
        home_intervenants_index int4,
        primary key (id)
    );

    create table hcar_other_benefit (
        id int8 not null,
        other_benefit_name varchar(60),
        handicap_compensation_adult_request_id int8,
        other_benefits_index int4,
        primary key (id)
    );

    create table hcar_other_folder (
        id int8 not null,
        other_folder_department varchar(2),
        other_folder_name varchar(60),
        other_folder_number varchar(30),
        handicap_compensation_adult_request_id int8,
        other_folders_index int4,
        primary key (id)
    );

    create table hcar_professional (
        id int8 not null,
        professional_last_name varchar(38),
        professional_first_name varchar(38),
        professional_address_id int8,
        handicap_compensation_adult_request_id int8,
        professionals_index int4,
        primary key (id)
    );
    
-- Create Handicap Compensation Adult request  
    create table handicap_compensation_child_request (
        id int8 not null,
        health_followed_by_professional bool,
        professional_support_professionals bool,
        referent_family_dependents bool,
        is_family_assistance bool,
        schooling_attended_grade varchar(32),
        referent_title varchar(255),
        project_comments varchar(600),
        folders_cdes bool,
        folders_mdph_department varchar(2),
        project_needs varchar(600),
        home_intervention_home_intervenant bool,
        benefits_education_allocation_of_disabled_children bool,
        folders_mdph_number varchar(30),
        subject_parental_authority_holder varchar(255),
        project_requests_housing_facilities bool,
        schooling_home_schooling bool,
        father_activity_reduction_ratio bytea,
        subject_birth_date timestamp,
        schooling_extra_curricular_details varchar(50),
        schooling_specialized_grade bool,
        benefits_disability_pension bool,
        referent_maiden_name varchar(38),
        project_requests_disabled_worker_recognition bool,
        benefits_unemployment_benefits bool,
        professional_status_kind varchar(255),
        schooling_home_schooling_kind varchar(255),
        benefits_education_of_disabled_children_details varchar(60),
        formation_previous_formation varchar(180),
        project_requests_vocational_training bool,
        facilities_custom_car bool,
        benefits_disabled_adult_allocation bool,
        professional_status_indemnified bool,
        schooling_enrolment bool,
        benefits_third_party_compensatory_allowance bool,
        referent_birth_date timestamp,
        professional_status_date timestamp,
        project_requests_transport_cost_allocation bool,
        benefits_professional_orientation bool,
        schooling_home_schooling_accompanist_last_name varchar(38),
        benefits_disability_recognition bool,
        professional_status_register_as_unemployed bool,
        professional_status_indemnified_date timestamp,
        dwelling_social_reception_naming varchar(80),
        benefits_professional_orientation_details varchar(60),
        benefits_painful_standing_card bool,
        folders_cdes_department varchar(2),
        facilities_specialized_transport bool,
        benefits_parking_card bool,
        facilities_specialized_transport_details varchar(60),
        benefits_work_accident_annuity_ratio varchar(3),
        social_security_number varchar(13),
        benefits_work_accident_annuity bool,
        care_care_services bool,
        benefits_daily_allowances bool,
        benefits_disability_ratio varchar(3),
        father_first_name varchar(38),
        schooling_home_schooling_accompanist_address_id int8,
        project_requests_custom_car bool,
        payment_agency_beneficiary_number varchar(20),
        folders_cotorep_number varchar(30),
        project_requests_a_c_t_p_renewal bool,
        referent_family_status varchar(255),
        schooling_school_name varchar(80),
        dwelling_social_reception_address_id int8,
        benefits_supported_by_an_institution_details varchar(60),
        folders_mdph bool,
        mother_job varchar(60),
        schooling_school_address_id int8,
        schooling_time varchar(4),
        professional_support_deals_with_same_professional bool,
        ase_referent_department varchar(2),
        folders_cotorep_department varchar(2),
        dwelling_establishment_reception bool,
        mother_first_name varchar(38),
        project_requests_ordinary_working bool,
        benefits_disabled_worker_recognition bool,
        dwelling_social_reception bool,
        project_requests_european_parking_card bool,
        health_followed_by_doctor bool,
        schooling_home_schooling_accompanist_first_name varchar(38),
        referent_birth_city varchar(32),
        project_requests_free_pension_membership bool,
        schooling_specialized_grade_details varchar(30),
        referent_birth_country varchar(50),
        health_followed_by_hospital bool,
        professional_status_employer_name varchar(38),
        project_requests_institution_support bool,
        benefits_social_welfare bool,
        project_requests_handicap_recognition bool,
        schooling_extra_curricular bool,
        project_wish varchar(600),
        dwelling_kind varchar(255),
        health_professional_last_name varchar(38),
        formation_studies_level varchar(30),
        project_requests_professional_orientation bool,
        health_doctor_last_name varchar(38),
        social_service_address_id int8,
        facilities_housing_details varchar(60),
        benefits_supplement_for_single_parents bool,
        project_requests_increase_for_independent_living bool,
        benefits_third_party_supplement bool,
        benefits_disability_pension_category varchar(60),
        studies_high_school_grade varchar(60),
        referent_last_name varchar(38),
        subject_birth_city varchar(32),
        project_requests_assistance bool,
        benefits_supported_by_an_institution bool,
        professional_status_environment varchar(255),
        project_requests_third_party_help bool,
        project_requests_disabled_adult_allowance bool,
        folders_other_folders bool,
        payment_agency_beneficiary varchar(255),
        father_job varchar(60),
        facilities_animal_aid_details varchar(60),
        studies_assistance_under_disability_details varchar(60),
        payment_agency_address_id int8,
        project_requests_other bool,
        benefits_third_person_compensatory_allowance bool,
        project_requests_disability_cost_allocation bool,
        social_security_agency_address_id int8,
        professional_status_address_id int8,
        professional_status_profession varchar(60),
        dwelling_reception_address_id int8,
        formation_diploma varchar(120),
        mother_last_name varchar(38),
        folders_cotorep bool,
        professional_status_elective_function bool,
        benefits_increase_for_independent_living bool,
        subject_birth_country varchar(50),
        father_activity_reduction bool,
        project_requests_disability_card bool,
        studies_high_school_name varchar(60),
        dwelling_reception_type varchar(255),
        father_last_name varchar(38),
        mother_activity_reduction_ratio bytea,
        professional_status_register_as_unemployed_date timestamp,
        payment_agency_name varchar(50),
        social_security_agency_name varchar(50),
        dwelling_reception_naming varchar(80),
        schooling_send_to_school bool,
        benefits_education_of_disabled_children bool,
        referent_first_name varchar(38),
        facilities_technical_assistance_details varchar(60),
        benefits_other_benefits bool,
        folders_cdes_number varchar(30),
        social_service_name varchar(60),
        benefits_disability_compensation bool,
        health_doctor_first_name varchar(38),
        project_requests_technical_help bool,
        facilities_technical_assistance bool,
        benefits_compensatory_allowance_for_expenses bool,
        facilities_housing bool,
        health_hospital_name varchar(60),
        project_requests_disabled_priority_card bool,
        project_requests_education_allocation_of_disabled_children bool,
        project_requests_other_details varchar(60),
        social_service_support bool,
        project_requests_sheltered_work bool,
        formation_current_formation varchar(120),
        schooling_schooling_kind varchar(255),
        studies_assistance_under_disability bool,
        studies_high_school bool,
        health_professional_first_name varchar(38),
        mother_activity_reduction bool,
        facilities_custom_car_details varchar(60),
        schooling_personalized_schooling_plan bool,
        dwelling_precision varchar(120),
        benefits_disability_card bool,
        social_security_member_ship_kind varchar(255),
        ase_referent_last_name varchar(38),
        professional_status_elective_function_details varchar(60),
        facilities_animal_aid bool,
        studies_high_school_address_id int8,
        primary key (id)
    );

    create table hccr_additional_fee (
        id int8 not null,
        additional_fee_kind varchar(30),
        additional_fee_periodicity varchar(30),
        additional_fee_cost varchar(6),
        handicap_compensation_child_request_id int8,
        additional_fee_index int4,
        primary key (id)
    );

    create table hccr_care_service (
        id int8 not null,
        care_service_care_service_employer bool,
        care_service_kind varchar(255),
        care_service_provider_name varchar(38),
        care_service_provider_address_id int8,
        handicap_compensation_child_request_id int8,
        care_services_index int4,
        primary key (id)
    );

    create table hccr_family_assistance_member (
        id int8 not null,
        family_assistance_member_last_name varchar(38),
        family_assistance_member_relationship varchar(60),
        family_assistance_member_first_name varchar(38),
        handicap_compensation_child_request_id int8,
        family_assistance_members_index int4,
        primary key (id)
    );

    create table hccr_family_dependent (
        id int8 not null,
        referent_family_dependent_first_name varchar(38),
        referent_family_dependent_birth_date timestamp,
        referent_family_dependent_actual_situation varchar(255),
        referent_family_dependent_last_name varchar(38),
        handicap_compensation_child_request_id int8,
        family_dependents_index int4,
        primary key (id)
    );

    create table hccr_home_intervenant (
        id int8 not null,
        home_intervenant_kind varchar(255),
        home_intervenant_details varchar(60),
        handicap_compensation_child_request_id int8,
        home_intervenants_index int4,
        primary key (id)
    );

    create table hccr_other_benefit (
        id int8 not null,
        other_benefit_name varchar(60),
        handicap_compensation_child_request_id int8,
        other_benefits_index int4,
        primary key (id)
    );

    create table hccr_other_folder (
        id int8 not null,
        other_folder_department varchar(2),
        other_folder_name varchar(60),
        other_folder_number varchar(30),
        handicap_compensation_child_request_id int8,
        other_folders_index int4,
        primary key (id)
    );

    create table hccr_professional (
        id int8 not null,
        professional_last_name varchar(38),
        professional_first_name varchar(38),
        professional_address_id int8,
        handicap_compensation_child_request_id int8,
        professionals_index int4,
        primary key (id)
    );     

-- display groups initialization
UPDATE request_type
    set display_group_id = (select display_group_id from request_type where label = 'Domestic Help')
    where label = 'Handicap Compensation Adult';

UPDATE request_type
    set display_group_id = (select display_group_id from request_type where label = 'Domestic Help')
    where label = 'Handicap Compensation Child';



