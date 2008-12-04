-- Domestic help request

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC6D5B4A55;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC79D85259;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC1F99E36F;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1ECD6AE1BE8;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E274AF76B3A;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E27D6AE1BE8;

    alter table dhr_real_asset 
        drop constraint FK6AA7D9809D2A9E41;

    alter table dhr_real_asset 
        drop constraint FK6AA7D980D6AE1BE8;

    alter table domestic_help_request 
        drop constraint FK3C00811289BB4925;

    alter table domestic_help_request 
        drop constraint FK3C00811282587E99;

    alter table domestic_help_request 
        drop constraint FK3C0081123044483F;

    alter table domestic_help_request 
        drop constraint FK3C008112D045047B;

    alter table domestic_help_request 
        drop constraint FK3C008112D6EC023A;

    drop table dhr_not_real_asset;

    drop table dhr_previous_dwelling;

    drop table dhr_real_asset;

    drop table domestic_help_request;

    create table dhr_not_real_asset (
        id int8 not null,
        dhr_not_real_asset_value bytea,
        dhr_not_real_asset_address_id int8,
        dhr_not_real_asset_date timestamp,
        dhr_not_real_asset_notary_name varchar(38),
        dhr_not_real_asset_beneficiary_name varchar(38),
        dhr_not_real_asset_beneficiary_first_name varchar(38),
        dhr_not_real_asset_type varchar(255),
        dhr_not_real_asset_beneficiary_address_id int8,
        dhr_not_real_asset_notary_address_id int8,
        dhr_not_real_asset_kind varchar(255),
        domestic_help_request_id int8,
        dhr_not_real_asset_index int4,
        primary key (id)
    );

    create table dhr_previous_dwelling (
        id int8 not null,
        dhr_previous_dwelling_status varchar(255),
        dhr_previous_dwelling_kind varchar(255),
        dhr_previous_dwelling_comment varchar(255),
        dhr_previous_dwelling_departure_date timestamp,
        dhr_previous_dwelling_address_id int8,
        dhr_previous_dwelling_arrival_date timestamp,
        domestic_help_request_id int8,
        dhr_previous_dwelling_index int4,
        primary key (id)
    );

    create table dhr_real_asset (
        id int8 not null,
        real_asset_net_floor_area bytea,
        dhr_real_asset_address_id int8,
        dhr_real_asset_value bytea,
        domestic_help_request_id int8,
        dhr_real_asset_index int4,
        primary key (id)
    );

    alter table dhr_not_real_asset 
        add constraint FK2BA9F1EC6D5B4A55 
        foreign key (dhr_not_real_asset_address_id) 
        references address;

    alter table dhr_not_real_asset 
        add constraint FK2BA9F1EC79D85259 
        foreign key (dhr_not_real_asset_notary_address_id) 
        references address;

    alter table dhr_not_real_asset 
        add constraint FK2BA9F1EC1F99E36F 
        foreign key (dhr_not_real_asset_beneficiary_address_id) 
        references address;

    alter table dhr_not_real_asset 
        add constraint FK2BA9F1ECD6AE1BE8 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E274AF76B3A 
        foreign key (dhr_previous_dwelling_address_id) 
        references address;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E27D6AE1BE8 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_real_asset 
        add constraint FK6AA7D9809D2A9E41 
        foreign key (dhr_real_asset_address_id) 
        references address;

    alter table dhr_real_asset 
        add constraint FK6AA7D980D6AE1BE8 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table domestic_help_request 
        add constraint FK3C00811289BB4925 
        foreign key (dhr_referent_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C00811282587E99 
        foreign key (id) 
        references request;

    alter table domestic_help_request 
        add constraint FK3C0081123044483F 
        foreign key (dhr_guardian_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C008112D045047B 
        foreign key (dhr_spouse_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C008112D6EC023A 
        foreign key (dhr_current_dwelling_address_id) 
        references address;

-- Remote support request

    alter table remote_support_request 
        drop constraint FKEAA6DC2682587E99;

    alter table remote_support_request 
        drop constraint FKEAA6DC26413637F3;

    drop table remote_support_request;

    create table remote_support_request (
        id int8 not null,
        rsr_requester_birth_date timestamp,
        rsr_spouse_is_disabled_person bool,
        rsr_contact_phone varchar(10),
        rsr_spouse_name varchar(38),
        rsr_second_contact_first_name varchar(38),
        rsr_contact_name varchar(38),
        rsr_requester_address_id int8,
        rsr_is_emergency bool,
        rsr_trustee_name varchar(38),
        rsr_contact_kind varchar(255),
        rsr_second_requester_first_name varchar(38),
        rsr_trustee_phone varchar(10),
        rsr_requester_floor bytea,
        rsr_requester_flat_number bytea,
        rsr_second_contact_name varchar(38),
        rsr_second_spouse_first_name varchar(38),
        rsr_requester_first_name varchar(38),
        rsr_spouse_gender varchar(255),
        rsr_requester_is_a_p_a_beneficiary bool,
        rsr_contact_first_name varchar(38),
        rsr_requester_is_taxable bool,
        rsr_requester_marital_status varchar(255),
        rsr_requester_name varchar(38),
        rsr_requester_personal_phone varchar(10),
        rsr_trustee_first_name varchar(38),
        rsr_second_contact_phone varchar(10),
        rsr_emergency_motive varchar(255),
        rsr_requester_is_disabled_person bool,
        rsr_spouse_first_name varchar(38),
        rsr_spouse_birth_date timestamp,
        rsr_request_kind varchar(255),
        rsr_requester_residence_kind varchar(255),
        rsr_requester_gender varchar(255),
        primary key (id)
    );

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
        adult_requester_first_name varchar(38),
        less_than20_referent_birth_place_city varchar(32),
        less_than20_father_mobile_phone varchar(10),
        less_than20_referent_home_phone varchar(10),
        less_than20_referent_address_id int8,
        writing_help bool,
        family_has_family_dependents bool,
        less_than20_parental_authority_department varchar(255),
        less_than20_legal_representative_home_phone varchar(10),
        adult_requester_last_name varchar(38),
        helper_responsability varchar(255),
        payment_agency_beneficiary varchar(255),
        less_than20_father_job varchar(255),
        adult_requester_birth_date timestamp,
        request_information_requester_profile varchar(255),
        request_information_kind varchar(255),
        payment_agency_address_id int8,
        less_than20_father_address_id int8,
        adult_requester_birth_place_city varchar(32),
        comments varchar(255),
        adult_requester_email varchar(255),
        social_security_agency_address_id int8,
        dwelling_reception_address_id int8,
        adult_requester_mobile_phone varchar(10),
        less_than20_referent_mobile_phone varchar(10),
        adult_legal_access_representative_last_name varchar(38),
        adult_legal_access_kind varchar(255),
        less_than20_referent_first_name varchar(38),
        less_than20_legal_representative_first_name varchar(38),
        less_than20_father_first_name varchar(38),
        adult_legal_access_representative_mobile_phone varchar(10),
        less_than20_mother_reduction_ratio varchar(255),
        less_than20_requester_mobile_phone varchar(10),
        less_than20_father_home_phone varchar(10),
        dwelling_reception_type varchar(255),
        less_than20_father_reduction_ratio varchar(255),
        adult_requester_address_id int8,
        payment_agency_name varchar(255),
        dwelling_social_reception_naming varchar(255),
        family_status varchar(255),
        less_than20_mother_address_id int8,
        less_than20_requester_id int8,
        less_than20_parental_authority_name varchar(38),
        adult_legal_access_representative_precision varchar(50),
        less_than20_legal_representative_address_id int8,
        social_security_agency_name varchar(255),
        dwelling_reception_naming varchar(255),
        less_than20_mother_first_name varchar(38),
        social_security_number varchar(13),
        less_than20_mother_mobile_phone varchar(10),
        less_than20_mother_activity_reduction bool,
        less_than20_referent_last_name varchar(38),
        adult_legal_access_representative_email varchar(255),
        less_than20_referent_birth_place_country varchar(255),
        payment_agency_beneficiary_number varchar(255),
        less_than20_legal_representative bool,
        adult_legal_access_representative_home_phone varchar(10),
        adult_requester_birth_place_country varchar(255),
        dwelling_social_reception_address_id int8,
        request_information_expiration_date timestamp,
        adult_requester_title varchar(255),
        adult_legal_access_representative_address_id int8,
        less_than20_requester_home_phone varchar(10),
        adult_legal_access_representative_kind varchar(255),
        less_than20_referent_birth_date timestamp,
        adult_legal_access_presence bool,
        dwelling_establishment_reception bool,
        less_than20_requester_email varchar(255),
        dwelling_social_reception bool,
        hopes_and_needs bool,
        less_than20_father_activity_reduction bool,
        less_than20_father_last_name varchar(38),
        less_than20_mother_last_name varchar(38),
        less_than20_mother_home_phone varchar(10),
        dwelling_precision varchar(255),
        less_than20_parental_authority_holder varchar(255),
        less_than20_legal_representative_mobile_phone varchar(10),
        social_security_member_ship_kind varchar(255),
        less_than20_referent_title varchar(255),
        needs varchar(255),
        less_than20_referent_email varchar(255),
        less_than20_mother_job varchar(255),
        adult_legal_access_representative_first_name varchar(38),
        less_than20_legal_representative_last_name varchar(38),
        helper_name varchar(38),
        dwelling_kind varchar(255),
        adult_requester_home_phone varchar(10),
        hopes varchar(255),
        primary key (id)
    );

    create table har_family_dependent (
        id int8 not null,
        family_dependent_actual_situation varchar(255),
        family_dependent_last_name varchar(38),
        family_dependent_first_name varchar(38),
        family_dependent_birth_date timestamp,
        handicap_allowance_request_id int8,
        family_dependents_index int4,
        primary key (id)
    );

    alter table handicap_allowance_request 
        add constraint FKF20630A1EEEA103C 
        foreign key (less_than20_referent_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A1A933FB6F 
        foreign key (social_security_agency_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A182587E99 
        foreign key (id) 
        references request;

    alter table handicap_allowance_request 
        add constraint FKF20630A1A82C7464 
        foreign key (less_than20_mother_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A12AF072D5 
        foreign key (dwelling_social_reception_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A15AB58CC4 
        foreign key (less_than20_legal_representative_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A15447DA69 
        foreign key (less_than20_requester_id) 
        references individual;

    alter table handicap_allowance_request 
        add constraint FKF20630A12633BF01 
        foreign key (dwelling_reception_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A1F813ECA3 
        foreign key (payment_agency_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A11D8D402B 
        foreign key (less_than20_father_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A19121BC2A 
        foreign key (adult_requester_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A1B02B91D4 
        foreign key (adult_legal_access_representative_address_id) 
        references address;

    alter table har_family_dependent 
        add constraint FK6EEA28CAE5852A38 
        foreign key (handicap_allowance_request_id) 
        references handicap_allowance_request;


