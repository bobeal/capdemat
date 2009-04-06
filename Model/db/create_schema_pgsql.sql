
    alter table adult 
        drop constraint FK58621BA71A211CC;

    alter table agent_category_roles 
        drop constraint FKBAFB98B6CE4D7137;

    alter table agent_category_roles 
        drop constraint FKBAFB98B6FB8D007D;

    alter table agent_site_roles 
        drop constraint FK1C3B6D3FFB8D007D;

    alter table alignment_certificate_request 
        drop constraint FK9EBFB38B82587E99;

    alter table alignment_certificate_request 
        drop constraint FK9EBFB38B1F88D72E;

    alter table birth_details_request 
        drop constraint FKB356961282587E99;

    alter table bulky_waste_collection_request 
        drop constraint FK1F104ECB82587E99;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCBD1DA5141;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCB9891C203;

    alter table category_emails 
        drop constraint FKB9136EB8CE4D7137;

    alter table child 
        drop constraint FK5A3F51C71A211CC;

    alter table compostable_waste_collection_request 
        drop constraint FKAFF7287782587E99;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424BC1F23BD7;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424BC116EEE9;

    alter table death_details_request 
        drop constraint FK85B0A9C782587E99;

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

    alter table document 
        drop constraint FK335CD11B8EAF8712;

    alter table document_action 
        drop constraint FKA42545DA7A6C6B5B;

    alter table document_binary 
        drop constraint FKA62BD3A57A6C6B5B;

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

    alter table electoral_roll_registration_request 
        drop constraint FK4562552982587E99;

    alter table electoral_roll_registration_request 
        drop constraint FK45625529F0159453;

    alter table external_service_individual_mapping 
        drop constraint FK5BC5D7E648C97698;

    alter table forms 
        drop constraint FK5D18C2FC5FD0068;

    alter table forms 
        drop constraint FK5D18C2FD06E9C28;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2BC49188;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACCA933FB6F;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC82587E99;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2F7F7877;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2633BF01;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2AF072D5;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACCF813ECA3;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC86312376;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2BC49188;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EA933FB6F;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E82587E99;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2F7F7877;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EE215BDD5;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E356CE3FE;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2633BF01;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2AF072D5;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EF813ECA3;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E489D3DBC;

    alter table hcar_additional_fee 
        drop constraint FKB357C9A19DDD11C5;

    alter table hcar_care_service 
        drop constraint FKD2D3BA7A7AB5BC78;

    alter table hcar_care_service 
        drop constraint FKD2D3BA7A9DDD11C5;

    alter table hcar_family_assistance_member 
        drop constraint FKF63BE3D99DDD11C5;

    alter table hcar_family_dependent 
        drop constraint FK6E4B5579DDD11C5;

    alter table hcar_home_intervenant 
        drop constraint FK6294A7D79DDD11C5;

    alter table hcar_other_benefit 
        drop constraint FKA530B5D59DDD11C5;

    alter table hcar_other_folder 
        drop constraint FK4681FB709DDD11C5;

    alter table hcar_professional 
        drop constraint FK581A111AEB2A3B3A;

    alter table hcar_professional 
        drop constraint FK581A111A9DDD11C5;

    alter table hccr_additional_fee 
        drop constraint FK54AB85A32860A781;

    alter table hccr_care_service 
        drop constraint FK868A8EFC2860A781;

    alter table hccr_care_service 
        drop constraint FK868A8EFC7AB5BC78;

    alter table hccr_family_assistance_member 
        drop constraint FK68DE055B2860A781;

    alter table hccr_family_dependent 
        drop constraint FKA23978D92860A781;

    alter table hccr_home_intervenant 
        drop constraint FKFDE96B592860A781;

    alter table hccr_other_benefit 
        drop constraint FK685471932860A781;

    alter table hccr_other_folder 
        drop constraint FKFA38CFF22860A781;

    alter table hccr_professional 
        drop constraint FKBD0E59C2860A781;

    alter table hccr_professional 
        drop constraint FKBD0E59CEB2A3B3A;

    alter table holiday_security_request 
        drop constraint FKED34C59782587E99;

    alter table holiday_security_request 
        drop constraint FKED34C597E2AF3D30;

    alter table home_folder 
        drop constraint FKDB87BBCE6AB1E860;

    alter table home_folder_modification_request 
        drop constraint FK26ED7ABD82587E99;

    alter table individual 
        drop constraint FKFD3DA2996AB1E860;

    alter table individual 
        drop constraint FKFD3DA29948B0ABD2;

    alter table individual 
        drop constraint FKFD3DA2998BD77771;

    alter table individual_role 
        drop constraint FK3C7D4E5CD4C3A2D8;

    alter table library_registration_request 
        drop constraint FKEA37820D82587E99;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0FD98B4AC2;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0FE383A5FD;

    alter table local_referential_association 
        drop constraint FK6B28F6775AC79CA3;

    alter table local_referential_association 
        drop constraint FK6B28F677DBACE805;

    alter table local_referential_data 
        drop constraint FK49407E74DBACE805;

    alter table marriage_details_request 
        drop constraint FK38315C1D82587E99;

    alter table military_census_request 
        drop constraint FK56137C4782587E99;

    alter table music_school_registration_request 
        drop constraint FK51A399DA82587E99;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD4696ECB;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD440404000;

    alter table payment 
        drop constraint FKD11C32061BC4A960;

    alter table payment 
        drop constraint FKD11C32068BD77771;

    alter table perischool_activity_registration_request 
        drop constraint FK76BAA59A82587E99;

    alter table perischool_activity_registration_request 
        drop constraint FK76BAA59A20540B7;

    alter table perischool_activity_registration_request_other_individual 
        drop constraint FKD6BDD32D96225F9E;

    alter table perischool_activity_registration_request_other_individual 
        drop constraint FKD6BDD32D8071FDD2;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E996225F9E;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E9D633AA6C;

    alter table personal_details_request 
        drop constraint FKDA41259382587E99;

    alter table place_reservation_request 
        drop constraint FK10FCEDE482587E99;

    alter table place_reservation_request_place_reservation 
        drop constraint FK9493CEF912CBA22D;

    alter table place_reservation_request_place_reservation 
        drop constraint FK9493CEF96E5CE64D;

    alter table purchase_item 
        drop constraint FKB113279154BCD4FA;

    alter table purchase_item_specific_data 
        drop constraint FK455E96692BA69830;

    alter table recreation_activity_registration_request 
        drop constraint FKD1F8ECC82587E99;

    alter table recreation_activity_registration_request 
        drop constraint FKD1F8ECCF8EE79C;

    alter table recreation_activity_registration_request_other_individual 
        drop constraint FK8026343B8071FDD2;

    alter table recreation_activity_registration_request_other_individual 
        drop constraint FK8026343B4C4C853A;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA97F2ADC1E;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA94C4C853A;

    alter table remote_support_request 
        drop constraint FKEAA6DC2682587E99;

    alter table request 
        drop constraint FK414EF28FC5FD0068;

    alter table request 
        drop constraint FK414EF28F396D729D;

    alter table request_action 
        drop constraint FK7AC459E6848EB249;

    alter table request_document 
        drop constraint FK712980CB848EB249;

    alter table request_note 
        drop constraint FK4DABB7A2848EB249;

    alter table request_type 
        drop constraint FK4DAE96EACE4D7137;

    alter table request_type 
        drop constraint FK4DAE96EA1D0DF06;

    alter table requirement 
        drop constraint FK15A8DC438EAF8712;

    alter table requirement 
        drop constraint FK15A8DC43C5FD0068;

    alter table school_canteen_registration_request 
        drop constraint FKDC4CBC6982587E99;

    alter table school_canteen_registration_request 
        drop constraint FKDC4CBC6920540B7;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F9AAB3F7;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F990FF23A;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADF9D0BE4E5;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADF90FF23A;

    alter table school_registration_request 
        drop constraint FK7BDFE8F482587E99;

    alter table school_registration_request 
        drop constraint FK7BDFE8F420540B7;

    alter table seasons 
        drop constraint FK7552F1F0C5FD0068;

    alter table sewer_connection_request 
        drop constraint FK50B057BB82587E99;

    alter table sewer_connection_request 
        drop constraint FK50B057BB1F88D72E;

    alter table sms_notification_request 
        drop constraint FK33CA666182587E99;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B756FB911;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B16CF96DE;

    alter table technical_intervention_request 
        drop constraint FKC051B8C974526C97;

    alter table technical_intervention_request 
        drop constraint FKC051B8C982587E99;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79AC7CF39D58;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79ACC8B7518E;

    alter table ticket_type_selection 
        drop constraint FK3B70C45A6592BACC;

    alter table vo_card_request 
        drop constraint FKC295D42682587E99;

    drop table address;

    drop table adult;

    drop table agent;

    drop table agent_category_roles;

    drop table agent_site_roles;

    drop table alignment_certificate_request;

    drop table birth_details_request;

    drop table bulky_waste_collection_request;

    drop table bulky_waste_collection_request_bulky_waste_type;

    drop table card;

    drop table category;

    drop table category_emails;

    drop table child;

    drop table compostable_waste_collection_request;

    drop table compostable_waste_collection_request_compostable_waste_type;

    drop table death_details_request;

    drop table dhr_not_real_asset;

    drop table dhr_previous_dwelling;

    drop table dhr_real_asset;

    drop table display_group;

    drop table document;

    drop table document_action;

    drop table document_binary;

    drop table document_type;

    drop table domestic_help_request;

    drop table electoral_roll_registration_request;

    drop table external_service_identifier_mapping;

    drop table external_service_individual_mapping;

    drop table external_service_traces;

    drop table forms;

    drop table handicap_compensation_adult_request;

    drop table handicap_compensation_child_request;

    drop table hcar_additional_fee;

    drop table hcar_care_service;

    drop table hcar_family_assistance_member;

    drop table hcar_family_dependent;

    drop table hcar_home_intervenant;

    drop table hcar_other_benefit;

    drop table hcar_other_folder;

    drop table hcar_professional;

    drop table hccr_additional_fee;

    drop table hccr_care_service;

    drop table hccr_family_assistance_member;

    drop table hccr_family_dependent;

    drop table hccr_home_intervenant;

    drop table hccr_other_benefit;

    drop table hccr_other_folder;

    drop table hccr_professional;

    drop table history_entry;

    drop table holiday_security_request;

    drop table home_folder;

    drop table home_folder_modification_request;

    drop table individual;

    drop table individual_role;

    drop table library_registration_request;

    drop table library_registration_request_subscription;

    drop table local_authority;

    drop table local_referential_association;

    drop table local_referential_data;

    drop table marriage_details_request;

    drop table means_of_contact;

    drop table military_census_request;

    drop table music_school_registration_request;

    drop table music_school_registration_request_activity;

    drop table other_individual;

    drop table payment;

    drop table perischool_activity_registration_request;

    drop table perischool_activity_registration_request_other_individual;

    drop table perischool_activity_registration_request_perischool_activity;

    drop table personal_details_request;

    drop table place_reservation_data;

    drop table place_reservation_request;

    drop table place_reservation_request_place_reservation;

    drop table purchase_item;

    drop table purchase_item_specific_data;

    drop table recreation_activity_registration_request;

    drop table recreation_activity_registration_request_other_individual;

    drop table recreation_activity_registration_request_recreation_activity;

    drop table recreation_center;

    drop table remote_support_request;

    drop table request;

    drop table request_action;

    drop table request_document;

    drop table request_form;

    drop table request_note;

    drop table request_type;

    drop table requirement;

    drop table school;

    drop table school_canteen_registration_request;

    drop table school_canteen_registration_request_canteen_attending_days;

    drop table school_canteen_registration_request_food_diet;

    drop table school_registration_request;

    drop table seasons;

    drop table sewer_connection_request;

    drop table sms_notification_request;

    drop table sms_notification_request_interests;

    drop table technical_intervention_request;

    drop table technical_intervention_request_intervention_type;

    drop table ticket_type_selection;

    drop table vo_card_request;

    drop sequence hibernate_sequence;

    create table address (
        id int8 not null,
        additional_delivery_information varchar(38),
        additional_geographical_information varchar(38),
        street_number varchar(5),
        street_name varchar(32),
        place_name_or_service varchar(38),
        postal_code varchar(5),
        city varchar(32),
        country_name varchar(38),
        primary key (id)
    );

    create table adult (
        id int8 not null,
        title varchar(16),
        maiden_name varchar(255),
        name_of_use varchar(255),
        family_status varchar(32),
        home_phone varchar(32),
        mobile_phone varchar(32),
        office_phone varchar(32),
        email varchar(50),
        cfbn varchar(8),
        profession varchar(255),
        question varchar(255),
        answer varchar(255),
        password varchar(255),
        primary key (id)
    );

    create table agent (
        id int8 not null,
        login varchar(255),
        last_name varchar(255),
        first_name varchar(255),
        active bool,
        preferences bytea,
        primary key (id)
    );

    create table agent_category_roles (
        agent_id int8 not null,
        profile varchar(16),
        category_id int8
    );

    create table agent_site_roles (
        agent_id int8 not null,
        profile varchar(16)
    );

    create table alignment_certificate_request (
        id int8 not null,
        requester_quality varchar(255),
        section varchar(255),
        transportation_route varchar(255),
        owner_first_names varchar(255),
        locality varchar(255),
        number bytea,
        owner_last_name varchar(38),
        owner_address_id int8,
        primary key (id)
    );

    create table birth_details_request (
        id int8 not null,
        format varchar(255),
        copies bytea,
        birth_postal_code varchar(2),
        comment varchar(255),
        birth_first_names varchar(255),
        motive varchar(255),
        requester_quality_precision varchar(255),
        birth_date timestamp,
        requester_quality varchar(255),
        birth_city varchar(32),
        father_last_name varchar(38),
        birth_marriage_name varchar(38),
        father_first_names varchar(255),
        mother_first_names varchar(255),
        birth_last_name varchar(38),
        mother_maiden_name varchar(38),
        primary key (id)
    );

    create table bulky_waste_collection_request (
        id int8 not null,
        collection_address varchar(255),
        other_waste varchar(255),
        primary key (id)
    );

    create table bulky_waste_collection_request_bulky_waste_type (
        bulky_waste_collection_request_id int8 not null,
        bulky_waste_type_id int8 not null,
        bulky_waste_type_index int4 not null,
        primary key (bulky_waste_collection_request_id, bulky_waste_type_index)
    );

    create table card (
        id int8 not null,
        card_delivery_date timestamp,
        card_validity_date timestamp,
        card_type varchar(255),
        identifier varchar(255),
        certificate varchar(4096),
        pin varchar(32),
        card_state varchar(16),
        primary key (id)
    );

    create table category (
        id int8 not null,
        name varchar(255),
        primary_email varchar(255),
        primary key (id)
    );

    create table category_emails (
        category_id int8 not null,
        email varchar(255)
    );

    create table child (
        id int8 not null,
        note varchar(255),
        badge_number varchar(255),
        primary key (id)
    );

    create table compostable_waste_collection_request (
        id int8 not null,
        collection_address varchar(255),
        other_waste varchar(255),
        primary key (id)
    );

    create table compostable_waste_collection_request_compostable_waste_type (
        compostable_waste_collection_request_id int8 not null,
        compostable_waste_type_id int8 not null,
        compostable_waste_type_index int4 not null,
        primary key (compostable_waste_collection_request_id, compostable_waste_type_index)
    );

    create table death_details_request (
        id int8 not null,
        death_first_names varchar(255),
        death_city varchar(32),
        format varchar(255),
        copies bytea,
        comment varchar(255),
        motive varchar(255),
        death_postal_code varchar(2),
        death_last_name varchar(38),
        death_date timestamp,
        primary key (id)
    );

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

    create table display_group (
        id int8 not null,
        name varchar(255),
        label varchar(255),
        primary key (id)
    );

    create table document (
        id int8 not null,
        creation_date timestamp,
        validation_date timestamp,
        end_validity_date timestamp,
        ecitizen_note varchar(255),
        agent_note varchar(255),
        state varchar(16),
        deposit_type varchar(24),
        deposit_origin varchar(10),
        deposit_from int8,
        home_folder_id int8,
        individual_id int8,
        document_type_id int8,
        certified bool,
        primary key (id)
    );

    create table document_action (
        id int8 not null,
        agent_id int8,
        label varchar(255),
        note varchar(255),
        date timestamp,
        resulting_state varchar(16),
        document_id int8,
        primary key (id)
    );

    create table document_binary (
        id int8 not null,
        data bytea,
        document_id int8,
        document_binary_index int4,
        primary key (id)
    );

    create table document_type (
        id int8 not null,
        name varchar(255) not null unique,
        type int4 not null unique,
        validity_duration_type varchar(16) not null,
        validity_duration int4 not null,
        usage_type varchar(16) not null,
        primary key (id)
    );

    create table domestic_help_request (
        id int8 not null,
        dhr_spouse_principal_pension_plan varchar(255),
        dhr_spouse_profession varchar(255),
        dhr_net_income bytea,
        professional_taxes bytea,
        dhr_is_spouse_retired bool,
        dhr_spouse_title varchar(255),
        dhr_requester_birth_date timestamp,
        dhr_real_estate_investment_income bytea,
        dhr_requester_is_french_resident bool,
        dhr_current_dwelling_address_id int8,
        dhr_spouse_france_arrival_date timestamp,
        dhr_requester_nationality varchar(32),
        dhr_current_dwelling_arrival_date timestamp,
        dhr_referent_first_name varchar(38),
        dhr_incomes_annual_total bytea,
        dhr_requester_have_guardian bool,
        dhr_income_tax bytea,
        dhr_spouse_birth_place varchar(255),
        dhr_spouse_birth_date timestamp,
        dhr_current_dwelling_net_area int2,
        dhr_requester_france_arrival_date timestamp,
        dhr_current_dwelling_status varchar(255),
        dhr_spouse_first_name varchar(38),
        dhr_spouse_family_status varchar(255),
        dhr_furniture_investment_income bytea,
        dhr_guardian_address_id int8,
        dhr_referent_name varchar(38),
        local_rate bytea,
        dhr_spouse_employer varchar(255),
        dhr_request_kind varchar(255),
        dhr_principal_pension_plan varchar(255),
        dhr_complementary_pension_plan varchar(255),
        dhr_referent_address_id int8,
        property_taxes bytea,
        dhr_guardian_name varchar(38),
        pensions bytea,
        dhr_current_dwelling_kind varchar(255),
        dhr_current_dwelling_number_of_room int2,
        dhr_guardian_measure varchar(255),
        dhr_current_dwelling_phone varchar(10),
        dhr_spouse_is_french_resident bool,
        dhr_allowances bytea,
        dhr_spouse_nationality varchar(32),
        dhr_spouse_maiden_name varchar(38),
        dhr_spouse_name varchar(38),
        dhr_spouse_pension_plan_detail varchar(255),
        dhr_requester_birth_place varchar(255),
        dhr_spouse_address_id int8,
        dhr_have_family_referent bool,
        dhr_pension_plan_detail varchar(255),
        dhr_spouse_complementary_pension_plan varchar(255),
        primary key (id)
    );

    create table electoral_roll_registration_request (
        id int8 not null,
        subject_nationality varchar(255),
        subject_old_city varchar(32),
        subject_address_outside_city_id int8,
        polling_station int8,
        polling_school_name varchar(255),
        motive varchar(255),
        electoral_number int8,
        primary key (id)
    );

    create table external_service_identifier_mapping (
        id int8 not null,
        external_service_label varchar(255),
        home_folder_id int8,
        external_capdemat_id varchar(255),
        external_id varchar(255),
        primary key (id)
    );

    create table external_service_individual_mapping (
        mapping_id int8 not null,
        individual_id int8,
        external_capdemat_id varchar(255),
        external_id varchar(255)
    );

    create table external_service_traces (
        id int8 not null,
        date timestamp,
        key int8,
        key_owner varchar(255),
        message varchar(255),
        name varchar(255),
        status varchar(255),
        primary key (id)
    );

    create table forms (
        request_form_id int8 not null,
        request_type_id int8 not null,
        primary key (request_form_id, request_type_id)
    );

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

    create table history_entry (
        id int8 not null,
        user_name varchar(255),
        request_id int8,
        operation varchar(255),
        clazz varchar(255),
        property varchar(255),
        old_value varchar(1024),
        new_value varchar(1024),
        object_id int8,
        primary key (id)
    );

    create table holiday_security_request (
        id int8 not null,
        other_contact_last_name varchar(38),
        absence_end_date timestamp,
        alarm bool,
        other_contact_address_id int8,
        other_contact_first_name varchar(38),
        light bool,
        other_contact_phone varchar(10),
        rules_and_regulations_acceptance bool,
        alert_phone varchar(10),
        absence_start_date timestamp,
        primary key (id)
    );

    create table home_folder (
        id int8 not null,
        state varchar(16) not null,
        adress_id int8,
        bound_to_request bool,
        origin_request_id int8,
        enabled bool,
        family_quotient varchar(255),
        primary key (id)
    );

    create table home_folder_modification_request (
        id int8 not null,
        primary key (id)
    );

    create table individual (
        id int8 not null,
        version int4 not null,
        login varchar(255) unique,
        public_key varchar(50) unique,
        federation_key varchar(64) unique,
        last_name varchar(38),
        first_name varchar(38),
        first_name_2 varchar(38),
        first_name_3 varchar(38),
        birth_date timestamp,
        birth_country varchar(255),
        birth_city varchar(32),
        birth_postal_code varchar(5),
        sex varchar(8),
        creation_date timestamp,
        state varchar(16) not null,
        adress_id int8,
        card_id int8,
        home_folder_id int8,
        home_folder_index int4,
        primary key (id)
    );

    create table individual_role (
        id int8 not null,
        role varchar(255),
        home_folder_id int8,
        individual_id int8,
        owner_id int8,
        primary key (id)
    );

    create table library_registration_request (
        id int8 not null,
        registration_number varchar(255),
        parental_authorization bool,
        subscription_price int2,
        rules_and_regulations_acceptance bool,
        primary key (id)
    );

    create table library_registration_request_subscription (
        library_registration_request_id int8 not null,
        subscription_id int8 not null,
        subscription_index int4 not null,
        primary key (library_registration_request_id, subscription_index)
    );

    create table local_authority (
        id int8 not null,
        name varchar(32) not null,
        display_title varchar(100) not null,
        postal_code varchar(5) not null,
        server_names bytea,
        draft_live_duration int4 not null,
        draft_notification_before_delete int4 not null,
        primary key (id)
    );

    create table local_referential_association (
        local_referential_parent_data_id int8 not null,
        local_referential_child_data_id int8 not null,
        primary key (local_referential_parent_data_id, local_referential_child_data_id)
    );

    create table local_referential_data (
        id int8 not null,
        name varchar(255),
        priority int4,
        additional_information_label varchar(255),
        additional_information_value varchar(255),
        local_referential_parent_data_id int8,
        primary key (id)
    );

    create table marriage_details_request (
        id int8 not null,
        format varchar(255),
        copies bytea,
        marriage_husband_last_name varchar(38),
        marriage_wife_first_names varchar(255),
        comment varchar(255),
        requester_quality_precision varchar(255),
        father_first_names varchar(255),
        marriage_postal_code varchar(2),
        mother_maiden_name varchar(38),
        marriage_husband_first_names varchar(255),
        requester_quality varchar(255),
        marriage_city varchar(32),
        marriage_wife_last_name varchar(38),
        marriage_date timestamp,
        father_last_name varchar(38),
        relationship varchar(255),
        mother_first_names varchar(255),
        motive varchar(255),
        primary key (id)
    );

    create table means_of_contact (
        id int8 not null,
        type varchar(255),
        enabled bool,
        primary key (id)
    );

    create table military_census_request (
        id int8 not null,
        father_birth_department varchar(255),
        child_profession varchar(255),
        child_status varchar(255),
        alive_children bytea,
        affection_or_disease bool,
        state_pupil bool,
        child_title varchar(255),
        child_mail varchar(255),
        child_diploma varchar(255),
        mother_birth_country varchar(255),
        father_birth_city varchar(255),
        father_birth_date timestamp,
        father_first_name varchar(38),
        mother_birth_city varchar(255),
        father_nationality varchar(255),
        mother_birth_date timestamp,
        mother_first_name varchar(38),
        child_birth_country varchar(255),
        mother_nationality varchar(255),
        highly_infirm bool,
        child_speciality varchar(255),
        child_other_country varchar(255),
        children_in_charge bytea,
        japd_exemption bool,
        child_situation varchar(255),
        maiden_name varchar(38),
        child_phone varchar(10),
        mother_last_name varchar(38),
        father_last_name varchar(38),
        prefect_pupil_department varchar(255),
        mother_birth_department varchar(255),
        child_residence_country varchar(255),
        other_situation varchar(255),
        prefect_pupil bool,
        child_country varchar(255),
        child_convention varchar(255),
        father_birth_country varchar(255),
        primary key (id)
    );

    create table music_school_registration_request (
        id int8 not null,
        rules_and_regulations_acceptance bool,
        primary key (id)
    );

    create table music_school_registration_request_activity (
        music_school_registration_request_id int8 not null,
        activity_id int8 not null,
        activity_index int4 not null,
        primary key (music_school_registration_request_id, activity_index)
    );

    create table other_individual (
        id int8 not null,
        last_name varchar(255),
        first_name varchar(255),
        address varchar(255),
        home_phone varchar(32),
        office_phone varchar(32),
        type varchar(16),
        primary key (id)
    );

    create table payment (
        id int8 not null,
        broker varchar(255),
        cvq_reference varchar(255),
        bank_reference varchar(255),
        initialization_date timestamp,
        commit_date timestamp,
        amount float8,
        state varchar(15),
        home_folder_id int8 not null,
        requester_id int8 not null,
        payment_mode varchar(10),
        commit_alert bool,
        primary key (id)
    );

    create table perischool_activity_registration_request (
        id int8 not null,
        class_trip_permission bool,
        child_photo_exploitation_permission bool,
        school_id int8,
        hospitalization_permission bool,
        rules_and_regulations_acceptance bool,
        urgency_phone varchar(10),
        section varchar(32),
        primary key (id)
    );

    create table perischool_activity_registration_request_other_individual (
        perischool_activity_registration_request_id int8 not null,
        other_individual_id int8 not null,
        other_individual_index int4 not null,
        primary key (perischool_activity_registration_request_id, other_individual_index)
    );

    create table perischool_activity_registration_request_perischool_activity (
        perischool_activity_registration_request_id int8 not null,
        perischool_activity_id int8 not null,
        perischool_activity_index int4 not null,
        primary key (perischool_activity_registration_request_id, perischool_activity_index)
    );

    create table personal_details_request (
        id int8 not null,
        death_first_names varchar(255),
        format varchar(255),
        copies bytea,
        birth_city varchar(32),
        marriage_husband_last_name varchar(38),
        marriage_wife_first_names varchar(255),
        requester_quality_precision varchar(255),
        father_first_names varchar(255),
        marriage_postal_code varchar(2),
        certificate varchar(255),
        mother_maiden_name varchar(38),
        death_city varchar(32),
        marriage_husband_first_names varchar(255),
        usage varchar(255),
        requester_quality varchar(255),
        marriage_city varchar(32),
        marriage_wife_last_name varchar(38),
        birth_first_names varchar(255),
        death_last_name varchar(38),
        birth_last_name varchar(38),
        birth_postal_code varchar(2),
        marriage_date timestamp,
        death_date timestamp,
        birth_date timestamp,
        death_postal_code varchar(2),
        father_last_name varchar(38),
        relationship varchar(255),
        mother_first_names varchar(255),
        primary key (id)
    );

    create table place_reservation_data (
        id int8 not null,
        name varchar(255),
        primary key (id)
    );

    create table place_reservation_request (
        id int8 not null,
        subscriber_number varchar(255),
        is_subscriber bool,
        payment_reference varchar(255),
        primary key (id)
    );

    create table place_reservation_request_place_reservation (
        place_reservation_request_id int8 not null,
        place_reservation_id int8 not null,
        place_reservation_index int4 not null,
        primary key (place_reservation_request_id, place_reservation_index)
    );

    create table purchase_item (
        id int8 not null,
        item_type varchar(64) not null,
        label varchar(255),
        amount float8,
        request_id int8,
        external_item_id varchar(255),
        external_service_label varchar(255),
        old_value float8,
        old_value_date timestamp,
        issue_date timestamp,
        expiration_date timestamp,
        creation_date timestamp,
        max_buy int4,
        min_buy int4,
        quantity int4,
        subject_id int8,
        unit_price float8,
        old_quantity int4,
        reference varchar(255),
        payment_id int8,
        primary key (id)
    );

    create table purchase_item_specific_data (
        id int8 not null,
        value varchar(255),
        key varchar(255) not null,
        primary key (id, key)
    );

    create table recreation_activity_registration_request (
        id int8 not null,
        recreation_center_id int8,
        class_trip_permission bool,
        child_photo_exploitation_permission bool,
        hospitalization_permission bool,
        rules_and_regulations_acceptance bool,
        urgency_phone varchar(10),
        primary key (id)
    );

    create table recreation_activity_registration_request_other_individual (
        recreation_activity_registration_request_id int8 not null,
        other_individual_id int8 not null,
        other_individual_index int4 not null,
        primary key (recreation_activity_registration_request_id, other_individual_index)
    );

    create table recreation_activity_registration_request_recreation_activity (
        recreation_activity_registration_request_id int8 not null,
        recreation_activity_id int8 not null,
        recreation_activity_index int4 not null,
        primary key (recreation_activity_registration_request_id, recreation_activity_index)
    );

    create table recreation_center (
        id int8 not null,
        name varchar(255) not null,
        address varchar(255),
        active bool,
        primary key (id)
    );

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

    create table request (
        id int8 not null,
        home_folder_id int8,
        creation_date timestamp,
        last_modification_date timestamp,
        last_intervening_agent_id int8,
        state varchar(16) not null,
        data_state varchar(16) not null,
        means_of_contact_id int8,
        request_step varchar(16),
        requester_id int8,
        requester_last_name varchar(255),
        requester_first_name varchar(255),
        request_type_id int8,
        season_uuid varchar(255),
        orange_alert bool,
        red_alert bool,
        validation_date timestamp,
        subject_id int8,
        subject_last_name varchar(255),
        subject_first_name varchar(255),
        draft bool not null,
        step_states bytea,
        primary key (id)
    );

    create table request_action (
        id int8 not null,
        agent_id int8,
        label varchar(255),
        note varchar(255),
        date timestamp,
        resulting_state varchar(16),
        file bytea,
        request_id int8,
        primary key (id)
    );

    create table request_document (
        id int8 not null,
        document_id int8,
        request_id int8,
        primary key (id)
    );

    create table request_form (
        id int8 not null,
        type varchar(255) not null,
        label varchar(255),
        short_label varchar(255),
        personalized_data bytea,
        template_name varchar(255),
        xsl_fo_filename varchar(255),
        primary key (id)
    );

    create table request_note (
        id int8 not null,
        agent_id int8,
        type varchar(32),
        note varchar(255),
        request_id int8,
        primary key (id)
    );

    create table request_type (
        id int8 not null,
        label varchar(255),
        active bool,
        category_id int8,
        authorize_multiple_registrations_per_season bool,
        instruction_alert_delay int4,
        instruction_max_delay int4,
        has_automatic_activation bool,
        display_group_id int8,
        primary key (id)
    );

    create table requirement (
        request_type_id int8 not null,
        multiplicity int4,
        special bool,
        special_reason varchar(255),
        document_type_id int8
    );

    create table school (
        id int8 not null,
        name varchar(255),
        adress varchar(255),
        active bool,
        primary key (id)
    );

    create table school_canteen_registration_request (
        id int8 not null,
        food_allergy bool,
        doctor_phone varchar(10),
        doctor_name varchar(255),
        school_id int8,
        hospitalization_permission bool,
        rules_and_regulations_acceptance bool,
        urgency_phone varchar(10),
        section varchar(32),
        primary key (id)
    );

    create table school_canteen_registration_request_canteen_attending_days (
        school_canteen_registration_request_id int8 not null,
        canteen_attending_days_id int8 not null,
        canteen_attending_days_index int4 not null,
        primary key (school_canteen_registration_request_id, canteen_attending_days_index)
    );

    create table school_canteen_registration_request_food_diet (
        school_canteen_registration_request_id int8 not null,
        food_diet_id int8 not null,
        food_diet_index int4 not null,
        primary key (school_canteen_registration_request_id, food_diet_index)
    );

    create table school_registration_request (
        id int8 not null,
        current_school_address varchar(255),
        current_school_name varchar(255),
        current_section varchar(32),
        school_id int8,
        rules_and_regulations_acceptance bool,
        urgency_phone varchar(10),
        section varchar(32),
        primary key (id)
    );

    create table seasons (
        request_type_id int8 not null,
        uuid varchar(255),
        effect_end timestamp,
        effect_start timestamp,
        label varchar(255),
        registration_end timestamp,
        registration_start timestamp,
        validation_authorization_start timestamp
    );

    create table sewer_connection_request (
        id int8 not null,
        owner_last_name varchar(38),
        owner_first_names varchar(255),
        owner_address_id int8,
        requester_quality varchar(255),
        more_than_two_years bool,
        transportation_route varchar(255),
        locality varchar(255),
        number bytea,
        section varchar(255),
        primary key (id)
    );

    create table sms_notification_request (
        id int8 not null,
        clever_sms_contact_id varchar(255),
        subscription bool,
        primary key (id)
    );

    create table sms_notification_request_interests (
        sms_notification_request_id int8 not null,
        interests_id int8 not null,
        interests_index int4 not null,
        primary key (sms_notification_request_id, interests_index)
    );

    create table technical_intervention_request (
        id int8 not null,
        intervention_description varchar(255),
        intervention_place_id int8,
        primary key (id)
    );

    create table technical_intervention_request_intervention_type (
        technical_intervention_request_id int8 not null,
        intervention_type_id int8 not null,
        intervention_type_index int4 not null,
        primary key (technical_intervention_request_id, intervention_type_index)
    );

    create table ticket_type_selection (
        id int8 not null,
        name varchar(255),
        number int8,
        place_reservation_data_id int8,
        primary key (id)
    );

    create table vo_card_request (
        id int8 not null,
        primary key (id)
    );

    alter table adult 
        add constraint FK58621BA71A211CC 
        foreign key (id) 
        references individual;

    alter table agent_category_roles 
        add constraint FKBAFB98B6CE4D7137 
        foreign key (category_id) 
        references category;

    alter table agent_category_roles 
        add constraint FKBAFB98B6FB8D007D 
        foreign key (agent_id) 
        references agent;

    alter table agent_site_roles 
        add constraint FK1C3B6D3FFB8D007D 
        foreign key (agent_id) 
        references agent;

    alter table alignment_certificate_request 
        add constraint FK9EBFB38B82587E99 
        foreign key (id) 
        references request;

    alter table alignment_certificate_request 
        add constraint FK9EBFB38B1F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table birth_details_request 
        add constraint FKB356961282587E99 
        foreign key (id) 
        references request;

    alter table bulky_waste_collection_request 
        add constraint FK1F104ECB82587E99 
        foreign key (id) 
        references request;

    alter table bulky_waste_collection_request_bulky_waste_type 
        add constraint FK7E2C4DCBD1DA5141 
        foreign key (bulky_waste_collection_request_id) 
        references bulky_waste_collection_request;

    alter table bulky_waste_collection_request_bulky_waste_type 
        add constraint FK7E2C4DCB9891C203 
        foreign key (bulky_waste_type_id) 
        references local_referential_data;

    alter table category_emails 
        add constraint FKB9136EB8CE4D7137 
        foreign key (category_id) 
        references category;

    alter table child 
        add constraint FK5A3F51C71A211CC 
        foreign key (id) 
        references individual;

    alter table compostable_waste_collection_request 
        add constraint FKAFF7287782587E99 
        foreign key (id) 
        references request;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424BC1F23BD7 
        foreign key (compostable_waste_type_id) 
        references local_referential_data;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424BC116EEE9 
        foreign key (compostable_waste_collection_request_id) 
        references compostable_waste_collection_request;

    alter table death_details_request 
        add constraint FK85B0A9C782587E99 
        foreign key (id) 
        references request;

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

    alter table document 
        add constraint FK335CD11B8EAF8712 
        foreign key (document_type_id) 
        references document_type;

    alter table document_action 
        add constraint FKA42545DA7A6C6B5B 
        foreign key (document_id) 
        references document;

    alter table document_binary 
        add constraint FKA62BD3A57A6C6B5B 
        foreign key (document_id) 
        references document;

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

    alter table electoral_roll_registration_request 
        add constraint FK4562552982587E99 
        foreign key (id) 
        references request;

    alter table electoral_roll_registration_request 
        add constraint FK45625529F0159453 
        foreign key (subject_address_outside_city_id) 
        references address;

    alter table external_service_individual_mapping 
        add constraint FK5BC5D7E648C97698 
        foreign key (mapping_id) 
        references external_service_identifier_mapping;

    alter table forms 
        add constraint FK5D18C2FC5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table forms 
        add constraint FK5D18C2FD06E9C28 
        foreign key (request_form_id) 
        references request_form;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2BC49188 
        foreign key (studies_high_school_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACCA933FB6F 
        foreign key (social_security_agency_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC82587E99 
        foreign key (id) 
        references request;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2F7F7877 
        foreign key (professional_status_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2633BF01 
        foreign key (dwelling_reception_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2AF072D5 
        foreign key (dwelling_social_reception_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACCF813ECA3 
        foreign key (payment_agency_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC86312376 
        foreign key (professional_support_social_service_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2BC49188 
        foreign key (studies_high_school_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2EA933FB6F 
        foreign key (social_security_agency_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E82587E99 
        foreign key (id) 
        references request;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2F7F7877 
        foreign key (professional_status_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2EE215BDD5 
        foreign key (schooling_home_schooling_accompanist_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E356CE3FE 
        foreign key (social_service_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2633BF01 
        foreign key (dwelling_reception_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2AF072D5 
        foreign key (dwelling_social_reception_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2EF813ECA3 
        foreign key (payment_agency_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E489D3DBC 
        foreign key (schooling_school_address_id) 
        references address;

    alter table hcar_additional_fee 
        add constraint FKB357C9A19DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_care_service 
        add constraint FKD2D3BA7A7AB5BC78 
        foreign key (care_service_provider_address_id) 
        references address;

    alter table hcar_care_service 
        add constraint FKD2D3BA7A9DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_family_assistance_member 
        add constraint FKF63BE3D99DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_family_dependent 
        add constraint FK6E4B5579DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_home_intervenant 
        add constraint FK6294A7D79DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_other_benefit 
        add constraint FKA530B5D59DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_other_folder 
        add constraint FK4681FB709DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_professional 
        add constraint FK581A111AEB2A3B3A 
        foreign key (professional_address_id) 
        references address;

    alter table hcar_professional 
        add constraint FK581A111A9DDD11C5 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hccr_additional_fee 
        add constraint FK54AB85A32860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_care_service 
        add constraint FK868A8EFC2860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_care_service 
        add constraint FK868A8EFC7AB5BC78 
        foreign key (care_service_provider_address_id) 
        references address;

    alter table hccr_family_assistance_member 
        add constraint FK68DE055B2860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_family_dependent 
        add constraint FKA23978D92860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_home_intervenant 
        add constraint FKFDE96B592860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_other_benefit 
        add constraint FK685471932860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_other_folder 
        add constraint FKFA38CFF22860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_professional 
        add constraint FKBD0E59C2860A781 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_professional 
        add constraint FKBD0E59CEB2A3B3A 
        foreign key (professional_address_id) 
        references address;

    alter table holiday_security_request 
        add constraint FKED34C59782587E99 
        foreign key (id) 
        references request;

    alter table holiday_security_request 
        add constraint FKED34C597E2AF3D30 
        foreign key (other_contact_address_id) 
        references address;

    alter table home_folder 
        add constraint FKDB87BBCE6AB1E860 
        foreign key (adress_id) 
        references address;

    alter table home_folder_modification_request 
        add constraint FK26ED7ABD82587E99 
        foreign key (id) 
        references request;

    alter table individual 
        add constraint FKFD3DA2996AB1E860 
        foreign key (adress_id) 
        references address;

    alter table individual 
        add constraint FKFD3DA29948B0ABD2 
        foreign key (card_id) 
        references card;

    alter table individual 
        add constraint FKFD3DA2998BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table individual_role 
        add constraint FK3C7D4E5CD4C3A2D8 
        foreign key (owner_id) 
        references individual;

    alter table library_registration_request 
        add constraint FKEA37820D82587E99 
        foreign key (id) 
        references request;

    alter table library_registration_request_subscription 
        add constraint FK56C4BE0FD98B4AC2 
        foreign key (library_registration_request_id) 
        references library_registration_request;

    alter table library_registration_request_subscription 
        add constraint FK56C4BE0FE383A5FD 
        foreign key (subscription_id) 
        references local_referential_data;

    alter table local_referential_association 
        add constraint FK6B28F6775AC79CA3 
        foreign key (local_referential_child_data_id) 
        references local_referential_data;

    alter table local_referential_association 
        add constraint FK6B28F677DBACE805 
        foreign key (local_referential_parent_data_id) 
        references local_referential_data;

    alter table local_referential_data 
        add constraint FK49407E74DBACE805 
        foreign key (local_referential_parent_data_id) 
        references local_referential_data;

    alter table marriage_details_request 
        add constraint FK38315C1D82587E99 
        foreign key (id) 
        references request;

    alter table military_census_request 
        add constraint FK56137C4782587E99 
        foreign key (id) 
        references request;

    alter table music_school_registration_request 
        add constraint FK51A399DA82587E99 
        foreign key (id) 
        references request;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD4696ECB 
        foreign key (activity_id) 
        references local_referential_data;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD440404000 
        foreign key (music_school_registration_request_id) 
        references music_school_registration_request;

    alter table payment 
        add constraint FKD11C32061BC4A960 
        foreign key (requester_id) 
        references adult;

    alter table payment 
        add constraint FKD11C32068BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table perischool_activity_registration_request 
        add constraint FK76BAA59A82587E99 
        foreign key (id) 
        references request;

    alter table perischool_activity_registration_request 
        add constraint FK76BAA59A20540B7 
        foreign key (school_id) 
        references school;

    alter table perischool_activity_registration_request_other_individual 
        add constraint FKD6BDD32D96225F9E 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_activity_registration_request_other_individual 
        add constraint FKD6BDD32D8071FDD2 
        foreign key (other_individual_id) 
        references other_individual;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E996225F9E 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E9D633AA6C 
        foreign key (perischool_activity_id) 
        references local_referential_data;

    alter table personal_details_request 
        add constraint FKDA41259382587E99 
        foreign key (id) 
        references request;

    alter table place_reservation_request 
        add constraint FK10FCEDE482587E99 
        foreign key (id) 
        references request;

    alter table place_reservation_request_place_reservation 
        add constraint FK9493CEF912CBA22D 
        foreign key (place_reservation_request_id) 
        references place_reservation_request;

    alter table place_reservation_request_place_reservation 
        add constraint FK9493CEF96E5CE64D 
        foreign key (place_reservation_id) 
        references place_reservation_data;

    alter table purchase_item 
        add constraint FKB113279154BCD4FA 
        foreign key (payment_id) 
        references payment;

    alter table purchase_item_specific_data 
        add constraint FK455E96692BA69830 
        foreign key (id) 
        references purchase_item;

    alter table recreation_activity_registration_request 
        add constraint FKD1F8ECC82587E99 
        foreign key (id) 
        references request;

    alter table recreation_activity_registration_request 
        add constraint FKD1F8ECCF8EE79C 
        foreign key (recreation_center_id) 
        references recreation_center;

    alter table recreation_activity_registration_request_other_individual 
        add constraint FK8026343B8071FDD2 
        foreign key (other_individual_id) 
        references other_individual;

    alter table recreation_activity_registration_request_other_individual 
        add constraint FK8026343B4C4C853A 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA97F2ADC1E 
        foreign key (recreation_activity_id) 
        references local_referential_data;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA94C4C853A 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table remote_support_request 
        add constraint FKEAA6DC2682587E99 
        foreign key (id) 
        references request;

    alter table request 
        add constraint FK414EF28FC5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table request 
        add constraint FK414EF28F396D729D 
        foreign key (means_of_contact_id) 
        references means_of_contact;

    alter table request_action 
        add constraint FK7AC459E6848EB249 
        foreign key (request_id) 
        references request;

    alter table request_document 
        add constraint FK712980CB848EB249 
        foreign key (request_id) 
        references request;

    alter table request_note 
        add constraint FK4DABB7A2848EB249 
        foreign key (request_id) 
        references request;

    alter table request_type 
        add constraint FK4DAE96EACE4D7137 
        foreign key (category_id) 
        references category;

    alter table request_type 
        add constraint FK4DAE96EA1D0DF06 
        foreign key (display_group_id) 
        references display_group;

    alter table requirement 
        add constraint FK15A8DC438EAF8712 
        foreign key (document_type_id) 
        references document_type;

    alter table requirement 
        add constraint FK15A8DC43C5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table school_canteen_registration_request 
        add constraint FKDC4CBC6982587E99 
        foreign key (id) 
        references request;

    alter table school_canteen_registration_request 
        add constraint FKDC4CBC6920540B7 
        foreign key (school_id) 
        references school;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F9AAB3F7 
        foreign key (canteen_attending_days_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F990FF23A 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADF9D0BE4E5 
        foreign key (food_diet_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADF90FF23A 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_registration_request 
        add constraint FK7BDFE8F482587E99 
        foreign key (id) 
        references request;

    alter table school_registration_request 
        add constraint FK7BDFE8F420540B7 
        foreign key (school_id) 
        references school;

    alter table seasons 
        add constraint FK7552F1F0C5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table sewer_connection_request 
        add constraint FK50B057BB82587E99 
        foreign key (id) 
        references request;

    alter table sewer_connection_request 
        add constraint FK50B057BB1F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table sms_notification_request 
        add constraint FK33CA666182587E99 
        foreign key (id) 
        references request;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B756FB911 
        foreign key (interests_id) 
        references local_referential_data;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B16CF96DE 
        foreign key (sms_notification_request_id) 
        references sms_notification_request;

    alter table technical_intervention_request 
        add constraint FKC051B8C974526C97 
        foreign key (intervention_place_id) 
        references address;

    alter table technical_intervention_request 
        add constraint FKC051B8C982587E99 
        foreign key (id) 
        references request;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79AC7CF39D58 
        foreign key (intervention_type_id) 
        references local_referential_data;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79ACC8B7518E 
        foreign key (technical_intervention_request_id) 
        references technical_intervention_request;

    alter table ticket_type_selection 
        add constraint FK3B70C45A6592BACC 
        foreign key (place_reservation_data_id) 
        references place_reservation_data;

    alter table vo_card_request 
        add constraint FKC295D42682587E99 
        foreign key (id) 
        references request;

    create sequence hibernate_sequence;
