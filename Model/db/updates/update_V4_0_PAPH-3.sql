-- Handicap allowance request
alter table handicap_allowance_request 
    drop constraint FKF20630A1EEEA103C;

alter table handicap_allowance_request 
    drop constraint FKF20630A1A933FB6F;

alter table handicap_allowance_request 
    drop constraint FKF20630A182587E99;

alter table handicap_allowance_request 
    drop constraint FKF20630A1A82C7464;

alter table handicap_allowance_request 
    drop constraint FKF20630A12AF072D5;

alter table handicap_allowance_request 
    drop constraint FKF20630A15AB58CC4;

alter table handicap_allowance_request 
    drop constraint FKF20630A15447DA69;

alter table handicap_allowance_request 
    drop constraint FKF20630A12633BF01;

alter table handicap_allowance_request 
    drop constraint FKF20630A1F813ECA3;

alter table handicap_allowance_request 
    drop constraint FKF20630A11D8D402B;

alter table handicap_allowance_request 
    drop constraint FKF20630A19121BC2A;

alter table handicap_allowance_request 
    drop constraint FKF20630A1B02B91D4;
    
alter table har_family_dependent 
    drop constraint FK6EEA28CAE5852A38;
    
drop table handicap_allowance_request;

drop table har_family_dependent;


create table handicap_allowance_request (
    id int8 not null,
    har_less_than20_requester_gender varchar(255),
    har_payment_agency_beneficiary_number varchar(255),
    har_previous_formation varchar(255),
    har_follow_up bool,
    har_legal_access_presence bool,
    har_social_security_agency_name varchar(255),
    har_requester_city varchar(32),
    har_disability_recognition bool,
    har_additional_allocation_for_education_of_disabled_children bool,
    har_less_than20_requester_representative_first_name varchar(38),
    har_disability_pension bool,
    har_disability_card bool,
    har_free_pension_membership_request bool,
    har_less_than20_requester_authority_holder varchar(255),
    har_housing_facilities_details varchar(255),
    har_specialized_transport bool,
    har_social_security_agency_postal_code varchar(5),
    har_school_address varchar(255),
    har_attended_grade varchar(255),
    har_housing_facilities bool,
    har_home_schooling bool,
    har_followed_by_physician bool,
    har_dwelling_social_reception_city varchar(32),
    har_other_request bool,
    har_parking_card bool,
    family_status varchar(255),
    har_less_than20_requester_representative_department varchar(2),
    har_specialized_transport_details varchar(255),
    har_less_than20_requester_representative_city varchar(32),
    har_requester_birth_city varchar(32),
    har_professional_status_profession varchar(255),
    har_c_d_e_s_department varchar(255),
    har_compensatory_allowance_for_expenses bool,
    har_payment_agency_address varchar(255),
    har_less_than20_requester_representative_street_name varchar(255),
    har_c_d_e_s_file bool,
    har_followed_by_physician_details varchar(255),
    har_less_than20_requester_city varchar(32),
    har_current_formation varchar(255),
    har_less_than20_requester_representative_name varchar(38),
    har_less_than20_requester_parent_first_name varchar(38),
    har_c_o_t_o_r_e_p_number varchar(255),
    har_disabled_worker_recognition bool,
    har_high_school_city varchar(32),
    har_technical_help_request bool,
    har_followed_by_hospital_details varchar(255),
    har_project_needs varchar(255),
    har_technical_assistance_details varchar(255),
    har_c_d_e_s_number varchar(255),
    har_high_school_grade varchar(255),
    har_high_school bool,
    har_school_name varchar(255),
    har_less_than20_requester_name varchar(38),
    har_legal_access_representative_kind_detail varchar(255),
    har_home_schooling_accompanist_first_name varchar(38),
    har_high_school_postal_code varchar(5),
    har_request_information_profile varchar(255),
    har_indemnified bool,
    har_other_request_details varchar(255),
    har_high_school_address varchar(255),
    har_is_care_assistant bool,
    har_legal_access_representative_postal_code varchar(5),
    har_c_o_t_o_r_e_p_file bool,
    har_daily_allowances bool,
    har_less_than20_requester_birth_city varchar(32),
    har_social_security_member_ship_kind varchar(255),
    har_social_security_number varchar(13),
    har_legal_access_representative_mobile_phone varchar(10),
    har_p_t_c_a_renewal_request bool,
    har_schooling_enrolment bool,
    har_specialized_grade bool,
    har_dwelling_social_reception bool,
    har_requester_street_name varchar(255),
    har_less_than20_requester_parent_city varchar(32),
    har_supported_by_an_institution bool,
    har_studies_level varchar(255),
    har_vocational_training_request bool,
    har_disabled_worker_recognition_request bool,
    har_legal_access_representative_street_name varchar(255),
    har_transport_cost_allocation_request bool,
    har_disability_compensation bool,
    har_dwelling_kind varchar(255),
    har_is_family_carer bool,
    har_custom_car bool,
    har_is_carer bool,
    har_legal_access_representative_phone varchar(10),
    har_assistance_under_disability_details varchar(255),
    har_less_than20_requester_parent_mobile_phone varchar(10),
    har_legal_access_representative_name varchar(38),
    har_dwelling_reception_postal_code varchar(5),
    har_c_o_t_o_r_e_p_department varchar(255),
    har_professional_orientation bool,
    har_payment_agency_postal_code varchar(5),
    har_legal_access_kind varchar(255),
    har_dwelling_establishment_reception bool,
    har_less_than20_requester_first_name varchar(38),
    har_requester_birth_date timestamp,
    har_requester_first_name varchar(38),
    har_extra_curricular varchar(255),
    har_legal_access_representative_email varchar(255),
    har_professional_status_environment varchar(255),
    har_elective_function_details bool,
    har_ordinaryworking_request bool,
    har_increase_for_independent_living_request bool,
    har_social_professional_postal_code varchar(5),
    har_legal_access_representative_city varchar(32),
    har_school_city varchar(32),
    har_disabled_priority_card_request bool,
    har_less_than20_requester_representative_postal_code varchar(5),
    har_schooling_kind varchar(255),
    har_professional_status_address varchar(255),
    family_has_family_dependents bool,
    har_less_than20_requester_phone varchar(10),
    har_supplement_for_single_parents bool,
    har_less_than20_requester_representative_reduction_ratio bytea,
    har_dwelling_social_reception_address varchar(255),
    har_dwelling_reception_city varchar(32),
    har_followed_by_professional bool,
    har_sheltered_work_request bool,
    har_less_than20_requester_mobile_phone varchar(10),
    har_indemnified_date timestamp,
    har_animal_aid_details varchar(255),
    har_elective_function bool,
    har_home_schooling_accompanist_last_name varchar(38),
    har_disability_pension_category varchar(255),
    har_requester_name varchar(38),
    har_professional_status_kind varchar(255),
    har_social_security_agency_address varchar(255),
    har_payment_agency_name varchar(255),
    har_requester_maiden_name varchar(38),
    har_less_than20_requester_parent_phone varchar(10),
    har_work_accident_annuity_ratio int2,
    har_social_professional_city varchar(32),
    har_technical_assistance bool,
    har_less_than20_requester_parent_job varchar(255),
    har_less_than20_requester_birth_date timestamp,
    har_m_d_p_h_number varchar(255),
    har_dwelling_reception_type varchar(255),
    har_disabled_adult_allowance_request bool,
    har_dwelling_social_reception_postal_code varchar(5),
    har_disabled_adult_allocation bool,
    har_disability_ratio int2,
    har_requester_phone varchar(10),
    har_thrid_party_supplement bool,
    har_disability_card_request bool,
    har_legal_access_representative_kind varchar(255),
    har_professional_status_postal_code varchar(5),
    har_professional_evaluation bool,
    har_education_allocation_of_disabled_children_request bool,
    har_school_postal_code varchar(5),
    har_dwelling_reception_address varchar(255),
    har_requester_postal_code varchar(5),
    har_followed_by_professional_details varchar(255),
    har_schooling_time bytea,
    har_payment_agency_beneficiary varchar(255),
    har_send_to_school bool,
    har_specialized_grade_details varchar(255),
    har_social_professional_last_name varchar(255),
    har_payment_agency_city varchar(32),
    har_supported_by_an_institution_details varchar(255),
    har_home_schooling_kind varchar(255),
    har_less_than20_requester_representative_activity_reduction bool,
    har_less_than20_requester_representative_mobile_phone varchar(10),
    har_dwelling_precision varchar(255),
    har_register_as_unemployed bool,
    har_project_comments varchar(255),
    har_requester_mobile_phone varchar(10),
    har_requester_title varchar(255),
    har_less_than20_requester_parent_street_name varchar(255),
    har_social_professional_address varchar(255),
    har_custom_car_details varchar(255),
    har_less_than20_requester_email varchar(255),
    har_thrid_party_compensatory_allowance bool,
    har_m_d_p_h_file bool,
    har_additional_allocation_for_education_of_disabled_children_details varchar(255),
    har_education_allocation_of_disabled_children bool,
    har_thrid_person_compensatory_allowance bool,
    har_custom_car_request bool,
    har_animal_aid bool,
    har_register_as_unemployed_date timestamp,
    har_professional_orientation_request bool,
    har_requester_email varchar(255),
    har_followed_by_hospital bool,
    har_increase_for_independent_living bool,
    har_less_than20_requester_parent_postal_code varchar(5),
    har_legal_access_representative_first_name varchar(38),
    har_disability_cost_allocation_request bool,
    dwelling_reception_naming varchar(255),
    har_project_wish varchar(255),
    har_social_security_agency_city varchar(32),
    har_less_than20_requester_parent_name varchar(38),
    har_less_than20_requester_street_name varchar(255),
    har_diploma varchar(255),
    har_european_parking_card_request bool,
    har_requester_birth_country varchar(255),
    har_professional_status_city varchar(32),
    har_less_than20_requester_postal_code varchar(5),
    har_m_d_p_h_department varchar(255),
    har_less_than20_requester_representative_phone varchar(10),
    har_assistance_under_disability bool,
    har_work_accident_annuity bool,
    har_unemployment_benefits bool,
    har_professional_orientation_details varchar(255),
    har_housing_facilities_request bool,
    har_home_schooling_accompanist_city varchar(32),
    har_dwelling_social_reception_naming varchar(255),
    har_personalized_schooling_plan bool,
    har_assistance_request bool,
    har_social_welfare bool,
    har_home_schooling_accompanist_address varchar(255),
    har_institution_support_request bool,
    har_third_party_help_request bool,
    har_home_schooling_accompanist_postal_code varchar(5),
    har_professional_status_date timestamp,
    har_disability_recognition_request bool,
    har_request_deal_with_same_professional bool,
    har_less_than20_requester_birth_country varchar(255),
    har_high_school_name varchar(255),
    har_painful_standing_card bool,
    primary key (id)
);


create table har_care_assistant (
    id int8 not null,
    har_provider_name varchar(255),
    har_provider_code varchar(5),
    har_employer bool,
    har_carer_kind varchar(255),
    har_provider_city varchar(32),
    har_provider_address varchar(255),
    handicap_allowance_request_id int8,
    har_care_assistant_index int4,
    primary key (id)
);

create table har_carer (
    id int8 not null,
    har_other_carer_details varchar(38),
    har_carer_kind varchar(255),
    handicap_allowance_request_id int8,
    har_carer_index int4,
    primary key (id)
);

create table har_disability_related_cost (
    id int8 not null,
    har_cost int2,
    har_periodicity varchar(255),
    har_cost_kind varchar(255),
    handicap_allowance_request_id int8,
    har_disability_related_cost_index int4,
    primary key (id)
);

create table har_family_carer (
    id int8 not null,
    har_family_carer_relationship varchar(255),
    har_family_carer_last_name varchar(38),
    har_family_carer_first_name varchar(38),
    handicap_allowance_request_id int8,
    har_family_carer_index int4,
    primary key (id)
);

create table har_family_dependent (
    id int8 not null,
    har_family_dependent_actual_situation varchar(255),
    har_family_dependent_first_name varchar(38),
    har_family_dependent_last_name varchar(38),
    har_family_dependent_birth_date timestamp,
    handicap_allowance_request_id int8,
    har_family_dependent_index int4,
    primary key (id)
);

create table har_other_files (
    id int8 not null,
    har_other_number varchar(255),
    har_other_department varchar(255),
    har_other_file varchar(255),
    handicap_allowance_request_id int8,
    har_other_files_index int4,
    primary key (id)
);

create table har_professional (
    id int8 not null,
    har_professional_city varchar(32),
    har_professional_last_name varchar(38),
    har_professional_address varchar(255),
    har_professional_postal_code varchar(5),
    har_professional_first_name varchar(38),
    handicap_allowance_request_id int8,
    har_professional_index int4,
    primary key (id)
);


alter table handicap_allowance_request 
    add constraint FKF20630A182587E99 
    foreign key (id) 
    references request;

alter table har_care_assistant 
    add constraint FK173D3D96E5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_carer 
    add constraint FKCE62C65BE5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_disability_related_cost 
    add constraint FKE037E63EE5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_family_carer 
    add constraint FK911D22CCE5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_family_dependent 
    add constraint FK6EEA28CAE5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_other_files 
    add constraint FKD5F7E3E2E5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;

alter table har_professional 
    add constraint FKFAF1360DE5852A38 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;
