
    alter table adult 
        drop constraint FK58621BA71A211CC;

    alter table agent_category_roles 
        drop constraint FKBAFB98B6FB8D007D;

    alter table agent_category_roles 
        drop constraint FKBAFB98B6CE4D7137;

    alter table agent_site_roles 
        drop constraint FK1C3B6D3FFB8D007D;

    alter table alignment_certificate_request 
        drop constraint FK9EBFB38B1F88D72E;

    alter table alignment_certificate_request 
        drop constraint FK9EBFB38BED1B9492;

    alter table birth_details_request 
        drop constraint FKB3569612ED1B9492;

    alter table bulky_waste_collection_request 
        drop constraint FK1F104ECBED1B9492;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCBAEAD5FA0;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCB9891C203;

    alter table category_emails 
        drop constraint FKB9136EB8CE4D7137;

    alter table child 
        drop constraint FK5A3F51C71A211CC;

    alter table child_legal_responsible_map 
        drop constraint FK62E1102AC5C931EC;

    alter table child_legal_responsible_map 
        drop constraint FK62E1102A30CABB22;

    alter table compostable_waste_collection_request 
        drop constraint FKAFF72877ED1B9492;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424BAC577A08;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424BC1F23BD7;

    alter table death_details_request 
        drop constraint FK85B0A9C7ED1B9492;

    alter table dhr_donation 
        drop constraint FK91725043E45A0A7F;

    alter table dhr_donation 
        drop constraint FK9172504366C81F29;

    alter table dhr_personal_estate_and_saving 
        drop constraint FK5EFB376766C81F29;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E27F802E509;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E2766C81F29;

    alter table dhr_real_asset 
        drop constraint FK6AA7D980A3F3FF52;

    alter table dhr_real_asset 
        drop constraint FK6AA7D98066C81F29;

    alter table document 
        drop constraint FK335CD11B59302132;

    alter table document 
        drop constraint FK335CD11BDDD47DCE;

    alter table document 
        drop constraint FK335CD11B8BD77771;

    alter table document_action 
        drop constraint FKA42545DA1F561FF2;

    alter table document_binary 
        drop constraint FKA62BD3A51F561FF2;

    alter table domestic_help_request 
        drop constraint FK3C0081121C4A2C9A;

    alter table domestic_help_request 
        drop constraint FK3C008112A2B2928B;

    alter table domestic_help_request 
        drop constraint FK3C008112B3BAD17C;

    alter table domestic_help_request 
        drop constraint FK3C0081126FFC52CB;

    alter table domestic_help_request 
        drop constraint FK3C008112ED1B9492;

    alter table electoral_roll_registration_request 
        drop constraint FK45625529F0159453;

    alter table electoral_roll_registration_request 
        drop constraint FK45625529ED1B9492;

    alter table forms 
        drop constraint FK5D18C2F1808DF5C;

    alter table forms 
        drop constraint FK5D18C2FD97439C;

    alter table handicap_allowance_request 
        drop constraint FKF20630A16D27AFFE;

    alter table handicap_allowance_request 
        drop constraint FKF20630A1ED1B9492;

    alter table holiday_security_request 
        drop constraint FKED34C597E2AF3D30;

    alter table holiday_security_request 
        drop constraint FKED34C597ED1B9492;

    alter table home_folder 
        drop constraint FKDB87BBCE6AB1E860;

    alter table home_folder_modification_request 
        drop constraint FK26ED7ABDED1B9492;

    alter table individual 
        drop constraint FKFD3DA2996AB1E860;

    alter table individual 
        drop constraint FKFD3DA2998BD77771;

    alter table individual 
        drop constraint FKFD3DA29948B0ABD2;

    alter table library_registration_request 
        drop constraint FKEA37820DED1B9492;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0F6E60AC03;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0FE383A5FD;

    alter table local_referential_association 
        drop constraint FK6B28F6775AC79CA3;

    alter table local_referential_association 
        drop constraint FK6B28F677DBACE805;

    alter table local_referential_data 
        drop constraint FK49407E74DBACE805;

    alter table marriage_details_request 
        drop constraint FK38315C1DED1B9492;

    alter table military_census_request 
        drop constraint FK56137C47ED1B9492;

    alter table music_school_registration_request 
        drop constraint FK51A399DAED1B9492;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD4F5425501;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD4696ECB;

    alter table payment 
        drop constraint FKD11C32061BC4A960;

    alter table payment 
        drop constraint FKD11C32068BD77771;

    alter table perischool_activity_registration_request 
        drop constraint FK76BAA59A20540B7;

    alter table perischool_activity_registration_request 
        drop constraint FK76BAA59AED1B9492;

    alter table perischool_activity_registration_request_other_individual 
        drop constraint FKD6BDD32DDCC9C993;

    alter table perischool_activity_registration_request_other_individual 
        drop constraint FKD6BDD32D4B24749F;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E9D633AA6C;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E94B24749F;

    alter table personal_details_request 
        drop constraint FKDA412593ED1B9492;

    alter table place_reservation_request 
        drop constraint FK10FCEDE4ED1B9492;

    alter table place_reservation_request_place_reservation 
        drop constraint FK9493CEF96E5CE64D;

    alter table place_reservation_request_place_reservation 
        drop constraint FK9493CEF9E2EAB80C;

    alter table purchase_item 
        drop constraint FKB113279154BCD4FA;

    alter table purchase_item 
        drop constraint FKB1132791EF51C842;

    alter table purchase_item_specific_data 
        drop constraint FK455E96692BA69830;

    alter table recreation_activity_registration_request 
        drop constraint FKD1F8ECCF8EE79C;

    alter table recreation_activity_registration_request 
        drop constraint FKD1F8ECCED1B9492;

    alter table recreation_activity_registration_request_other_individual 
        drop constraint FK8026343BDCC9C993;

    alter table recreation_activity_registration_request_other_individual 
        drop constraint FK8026343B14E9A3B;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA914E9A3B;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA97F2ADC1E;

    alter table remote_support_request 
        drop constraint FKEAA6DC26ED1B9492;

    alter table request 
        drop constraint FK414EF28F1BC4A960;

    alter table request 
        drop constraint FK414EF28F3FFD6284;

    alter table request 
        drop constraint FK414EF28FD97439C;

    alter table request 
        drop constraint FK414EF28F8BD77771;

    alter table request_action 
        drop constraint FK7AC459E6EF51C842;

    alter table request_document_map 
        drop constraint FKCBC2F7E81F561FF2;

    alter table request_document_map 
        drop constraint FKCBC2F7E8EF51C842;

    alter table request_note 
        drop constraint FK4DABB7A2EF51C842;

    alter table request_type 
        drop constraint FK4DAE96EACE4D7137;

    alter table requirement 
        drop constraint FK15A8DC43DDD47DCE;

    alter table requirement 
        drop constraint FK15A8DC43D97439C;

    alter table school_canteen_registration_request 
        drop constraint FKDC4CBC6920540B7;

    alter table school_canteen_registration_request 
        drop constraint FKDC4CBC69ED1B9492;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F9AAB3F7;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F9E5E30099;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADF9D0BE4E5;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADFE5E30099;

    alter table school_registration_request 
        drop constraint FK7BDFE8F420540B7;

    alter table school_registration_request 
        drop constraint FK7BDFE8F4ED1B9492;

    alter table seasons 
        drop constraint FK7552F1F0D97439C;

    alter table sewer_connection_request 
        drop constraint FK50B057BB1F88D72E;

    alter table sewer_connection_request 
        drop constraint FK50B057BBED1B9492;

    alter table sms_notification_request 
        drop constraint FK33CA6661ED1B9492;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B37C4119F;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B756FB911;

    alter table technical_intervention_request 
        drop constraint FKC051B8C974526C97;

    alter table technical_intervention_request 
        drop constraint FKC051B8C9ED1B9492;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79AC7CF39D58;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79AC1A297B4F;

    alter table ticket_type_selection 
        drop constraint FK3B70C45A6592BACC;

    alter table vacations_diary 
        drop constraint FK2890BF7ACE7A2F50;

    alter table vacations_registration_request 
        drop constraint FK92F4987230CABB22;

    alter table vacations_registration_request 
        drop constraint FK92F49872F8EE79C;

    alter table vacations_registration_request 
        drop constraint FK92F49872ED1B9492;

    alter table vacations_registration_request_other_individual 
        drop constraint FK567CEB55DCC9C993;

    alter table vacations_registration_request_other_individual 
        drop constraint FK567CEB55CE7A2F50;

    alter table vo_card_request 
        drop constraint FKC295D426ED1B9492;

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

    drop table child_legal_responsible_map;

    drop table compostable_waste_collection_request;

    drop table compostable_waste_collection_request_compostable_waste_type;

    drop table death_details_request;

    drop table dhr_donation;

    drop table dhr_personal_estate_and_saving;

    drop table dhr_previous_dwelling;

    drop table dhr_real_asset;

    drop table document;

    drop table document_action;

    drop table document_binary;

    drop table document_type;

    drop table domestic_help_request;

    drop table electoral_roll_registration_request;

    drop table forms;

    drop table handicap_allowance_request;

    drop table history_entry;

    drop table holiday_security_request;

    drop table home_folder;

    drop table home_folder_modification_request;

    drop table individual;

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

    drop table request_document_map;

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

    drop table vacations_diary;

    drop table vacations_registration_request;

    drop table vacations_registration_request_other_individual;

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
        home_folder_roles int4,
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
        owner_address_id int8,
        section varchar(255),
        transportation_route varchar(255),
        locality varchar(255),
        owner_last_name varchar(38),
        number bytea,
        owner_first_names varchar(255),
        requester_quality varchar(255),
        primary key (id)
    );

    create table birth_details_request (
        id int8 not null,
        birth_first_names varchar(255),
        copies bytea,
        mother_first_names varchar(255),
        birth_last_name varchar(38),
        requester_quality_precision varchar(255),
        relationship varchar(255),
        usage varchar(255),
        requester_quality varchar(255),
        father_last_name varchar(38),
        birth_postal_code varchar(2),
        birth_city varchar(32),
        birth_date timestamp,
        mother_maiden_name varchar(38),
        father_first_names varchar(255),
        format varchar(255),
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
        primary key (bulky_waste_collection_request_id, bulky_waste_type_id)
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

    create table child_legal_responsible_map (
        id int8 not null,
        role varchar(8),
        child_id int8,
        legal_responsible_id int8,
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
        primary key (compostable_waste_collection_request_id, compostable_waste_type_id)
    );

    create table death_details_request (
        id int8 not null,
        copies bytea,
        mother_first_names varchar(255),
        death_first_names varchar(255),
        requester_quality_precision varchar(255),
        relationship varchar(255),
        usage varchar(255),
        requester_quality varchar(255),
        father_last_name varchar(38),
        death_date timestamp,
        death_city varchar(32),
        death_postal_code varchar(2),
        mother_maiden_name varchar(38),
        death_last_name varchar(38),
        father_first_names varchar(255),
        format varchar(255),
        primary key (id)
    );

    create table dhr_donation (
        id int8 not null,
        donation_date timestamp,
        donation_notary_first_name varchar(38),
        donation_beneficiary_name varchar(38),
        donation_beneficiary_first_name varchar(38),
        donation_value bytea,
        donation_notary_name varchar(38),
        donation_notary_address_id int8,
        donation_asset_place varchar(200),
        donation_asset varchar(255),
        domestic_help_request_id int8,
        primary key (id)
    );

    create table dhr_personal_estate_and_saving (
        id int8 not null,
        paybook_number varchar(30),
        paybook_amount bytea,
        domestic_help_request_id int8,
        primary key (id)
    );

    create table dhr_previous_dwelling (
        id int8 not null,
        previous_dwelling_arrival_date timestamp,
        previous_dwelling_address_id int8,
        previous_dwelling_departure_date timestamp,
        domestic_help_request_id int8,
        primary key (id)
    );

    create table dhr_real_asset (
        id int8 not null,
        real_asset_value bytea,
        real_asset_address_id int8,
        real_asset_net_floor_area bytea,
        real_asset_cadastre varchar(255),
        domestic_help_request_id int8,
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
        page_number int4,
        data bytea,
        document_id int8,
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
        current_dwelling_status varchar(255),
        tutor_name varchar(38),
        spouse_france_arrival_date timestamp,
        spouse_social_security_key_number varchar(2),
        social_security_number varchar(13),
        taxes_total bytea,
        capital_amount_total bytea,
        rent bytea,
        requester_incomes_annual_total bytea,
        spouse_pensionner bool,
        tutor_address_id int8,
        expenses_total bytea,
        spouse_employer_address_id int8,
        current_dwelling_room_number bytea,
        spouse_information_id int8,
        spouse_pensions bytea,
        tutor_first_name varchar(38),
        current_dwelling_arrival_date timestamp,
        current_dwelling_net_floor_area bytea,
        spouse_nationality varchar(32),
        savings_total bytea,
        current_dwelling_address_id int8,
        spouse_incomes_annual_total bytea,
        requester_allowances bytea,
        requester_pension_plan varchar(255),
        spouse_allowances bytea,
        income_tax bytea,
        requester_investment_income bytea,
        nationality varchar(32),
        requester_pensions bytea,
        property_taxes bytea,
        spouse_employer varchar(50),
        tutor varchar(255),
        donations_values_total bytea,
        spouse_pension_plan varchar(255),
        alimonies bytea,
        spouse_occupation varchar(50),
        current_dwelling_type varchar(255),
        bonds_amount bytea,
        spouse_investment_income bytea,
        social_security_key_number varchar(2),
        spouse_net_income bytea,
        france_arrival_date timestamp,
        requester_net_income bytea,
        professional_taxes bytea,
        shares_amount bytea,
        tutor_presence bool,
        local_rate bytea,
        real_assets_values_total bytea,
        spouse_social_security_number varchar(13),
        primary key (id)
    );

    create table electoral_roll_registration_request (
        id int8 not null,
        polling_station int8,
        polling_school_name varchar(255),
        electoral_number int8,
        subject_old_city varchar(32),
        motive varchar(255),
        subject_nationality varchar(255),
        subject_address_outside_city_id int8,
        primary key (id)
    );

    create table forms (
        request_form_id int8 not null,
        request_type_id int8 not null,
        primary key (request_form_id, request_type_id)
    );

    create table handicap_allowance_request (
        id int8 not null,
        legal_representative_address_id int8,
        legal_representative bool,
        hopes_and_needs bool,
        writing_help bool,
        needs varchar(255),
        helper_responsability varchar(255),
        legal_representative_phone varchar(10),
        legal_representative_family_relationship varchar(255),
        helper_name varchar(38),
        legal_representative_name varchar(38),
        legal_representative_firstame varchar(38),
        comments varchar(255),
        hopes varchar(255),
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
        absence_start_date timestamp,
        other_contact_last_name varchar(38),
        light bool,
        other_contact_phone varchar(10),
        rules_and_regulations_acceptance bool,
        alarm bool,
        other_contact_first_name varchar(38),
        other_contact_address_id int8,
        absence_end_date timestamp,
        alert_phone varchar(10),
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
        primary key (id)
    );

    create table library_registration_request (
        id int8 not null,
        parental_authorization bool,
        subscription_price int2,
        rules_and_regulations_acceptance bool,
        registration_number varchar(255),
        primary key (id)
    );

    create table library_registration_request_subscription (
        library_registration_request_id int8 not null,
        subscription_id int8 not null,
        primary key (library_registration_request_id, subscription_id)
    );

    create table local_authority (
        id int8 not null,
        name varchar(32) not null,
        postal_code varchar(5) not null,
        primary key (id)
    );

    create table local_referential_association (
        local_referential_parent_data_id int8 not null,
        local_referential_child_data_id int8 not null,
        primary key (local_referential_parent_data_id, local_referential_child_data_id)
    );

    create table local_referential_data (
        id int8 not null,
        name varchar(255) not null,
        priority int4,
        additional_information_label varchar(255),
        additional_information_value varchar(255),
        local_referential_parent_data_id int8,
        primary key (id)
    );

    create table marriage_details_request (
        id int8 not null,
        requester_quality_precision varchar(255),
        relationship varchar(255),
        marriage_postal_code varchar(2),
        marriage_wife_first_names varchar(255),
        marriage_husband_last_name varchar(38),
        father_first_names varchar(255),
        format varchar(255),
        copies bytea,
        marriage_city varchar(32),
        usage varchar(255),
        requester_quality varchar(255),
        father_last_name varchar(38),
        mother_maiden_name varchar(38),
        marriage_wife_last_name varchar(38),
        mother_first_names varchar(255),
        marriage_date timestamp,
        marriage_husband_first_names varchar(255),
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
        father_birth_country varchar(255),
        mother_first_name varchar(38),
        state_pupil bool,
        other_situation varchar(255),
        mother_birth_country varchar(255),
        alive_children bytea,
        father_first_name varchar(38),
        maiden_name varchar(38),
        father_birth_city varchar(255),
        mother_birth_city varchar(255),
        child_speciality varchar(255),
        prefect_pupil bool,
        child_diploma varchar(255),
        child_residence_country varchar(255),
        father_nationality varchar(255),
        child_country varchar(255),
        father_birth_department varchar(255),
        mother_nationality varchar(255),
        affection_or_disease bool,
        child_status varchar(255),
        mother_birth_date timestamp,
        children_in_charge bytea,
        mother_last_name varchar(38),
        child_title varchar(255),
        father_birth_date timestamp,
        child_convention varchar(255),
        child_mail varchar(255),
        mother_birth_department varchar(255),
        child_situation varchar(255),
        child_other_country varchar(255),
        father_last_name varchar(38),
        child_profession varchar(255),
        child_birth_country varchar(255),
        japd_exemption bool,
        highly_infirm bool,
        prefect_pupil_department varchar(255),
        child_phone varchar(10),
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
        primary key (music_school_registration_request_id, activity_id)
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
        hospitalization_permission bool,
        section varchar(32),
        school_id int8,
        urgency_phone varchar(10),
        rules_and_regulations_acceptance bool,
        child_photo_exploitation_permission bool,
        class_trip_permission bool,
        primary key (id)
    );

    create table perischool_activity_registration_request_other_individual (
        perischool_activity_registration_request_id int8 not null,
        other_individual_id int8 not null,
        primary key (perischool_activity_registration_request_id, other_individual_id)
    );

    create table perischool_activity_registration_request_perischool_activity (
        perischool_activity_registration_request_id int8 not null,
        perischool_activity_id int8 not null,
        primary key (perischool_activity_registration_request_id, perischool_activity_id)
    );

    create table personal_details_request (
        id int8 not null,
        birth_last_name varchar(38),
        death_first_names varchar(255),
        requester_quality_precision varchar(255),
        relationship varchar(255),
        marriage_postal_code varchar(2),
        birth_date timestamp,
        marriage_wife_first_names varchar(255),
        marriage_husband_last_name varchar(38),
        father_first_names varchar(255),
        format varchar(255),
        copies bytea,
        certificate varchar(255),
        marriage_city varchar(32),
        usage varchar(255),
        requester_quality varchar(255),
        father_last_name varchar(38),
        birth_city varchar(32),
        mother_maiden_name varchar(38),
        birth_first_names varchar(255),
        death_date timestamp,
        birth_postal_code varchar(2),
        death_postal_code varchar(2),
        marriage_wife_last_name varchar(38),
        mother_first_names varchar(255),
        death_city varchar(32),
        death_last_name varchar(38),
        marriage_date timestamp,
        marriage_husband_first_names varchar(255),
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
        primary key (place_reservation_request_id, place_reservation_id)
    );

    create table purchase_item (
        id int8 not null,
        item_type varchar(64) not null,
        label varchar(255),
        amount float8,
        request_id int8,
        payment_id int8,
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
        hospitalization_permission bool,
        urgency_phone varchar(10),
        rules_and_regulations_acceptance bool,
        child_photo_exploitation_permission bool,
        class_trip_permission bool,
        recreation_center_id int8,
        primary key (id)
    );

    create table recreation_activity_registration_request_other_individual (
        recreation_activity_registration_request_id int8 not null,
        other_individual_id int8 not null,
        primary key (recreation_activity_registration_request_id, other_individual_id)
    );

    create table recreation_activity_registration_request_recreation_activity (
        recreation_activity_registration_request_id int8 not null,
        recreation_activity_id int8 not null,
        primary key (recreation_activity_registration_request_id, recreation_activity_id)
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
        trustee_first_name varchar(38),
        taxable bool,
        floor bytea,
        contact_name varchar(38),
        appartment_number bytea,
        contact_first_name varchar(38),
        contact varchar(255),
        dwelling varchar(255),
        emergency bool,
        senior_assitance_beneficiary bool,
        trustee_name varchar(38),
        trustee_phone varchar(10),
        trustee varchar(255),
        contact_phone varchar(10),
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
        request_type_id int8,
        season_uuid varchar(255),
        orange_alert bool,
        red_alert bool,
        validation_date timestamp,
        subject_table_name varchar(255),
        subject_id int8,
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

    create table request_document_map (
        document_id int8 not null,
        request_id int8 not null,
        primary key (request_id, document_id)
    );

    create table request_form (
        id int8 not null,
        type varchar(255) not null,
        xsl_fo_filename varchar(255),
        label varchar(255),
        short_label varchar(255),
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
        doctor_phone varchar(10),
        doctor_name varchar(255),
        hospitalization_permission bool,
        section varchar(32),
        school_id int8,
        food_allergy bool,
        urgency_phone varchar(10),
        rules_and_regulations_acceptance bool,
        primary key (id)
    );

    create table school_canteen_registration_request_canteen_attending_days (
        school_canteen_registration_request_id int8 not null,
        canteen_attending_days_id int8 not null,
        primary key (school_canteen_registration_request_id, canteen_attending_days_id)
    );

    create table school_canteen_registration_request_food_diet (
        school_canteen_registration_request_id int8 not null,
        food_diet_id int8 not null,
        primary key (school_canteen_registration_request_id, food_diet_id)
    );

    create table school_registration_request (
        id int8 not null,
        current_school_name varchar(255),
        section varchar(32),
        school_id int8,
        current_school_address varchar(255),
        urgency_phone varchar(10),
        rules_and_regulations_acceptance bool,
        current_section varchar(32),
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
        owner_address_id int8,
        section varchar(255),
        requester_quality varchar(255),
        owner_last_name varchar(38),
        owner_first_names varchar(255),
        transportation_route varchar(255),
        locality varchar(255),
        more_than_two_years bool,
        number bytea,
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
        primary key (sms_notification_request_id, interests_id)
    );

    create table technical_intervention_request (
        id int8 not null,
        intervention_place_id int8,
        intervention_description varchar(255),
        primary key (id)
    );

    create table technical_intervention_request_intervention_type (
        technical_intervention_request_id int8 not null,
        intervention_type_id int8 not null,
        primary key (technical_intervention_request_id, intervention_type_id)
    );

    create table ticket_type_selection (
        id int8 not null,
        name varchar(255),
        number int8,
        place_reservation_data_id int8,
        primary key (id)
    );

    create table vacations_diary (
        id int8 not null,
        day timestamp,
        afternoon bool,
        noon bool,
        morning bool,
        evening bool,
        vacations_registration_request_id int8,
        primary key (id)
    );

    create table vacations_registration_request (
        id int8 not null,
        vacations varchar(255),
        urgency_phone varchar(10),
        child_id int8,
        recreation_center_id int8,
        primary key (id)
    );

    create table vacations_registration_request_other_individual (
        vacations_registration_request_id int8 not null,
        other_individual_id int8 not null,
        primary key (vacations_registration_request_id, other_individual_id)
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
        add constraint FKBAFB98B6FB8D007D 
        foreign key (agent_id) 
        references agent;

    alter table agent_category_roles 
        add constraint FKBAFB98B6CE4D7137 
        foreign key (category_id) 
        references category;

    alter table agent_site_roles 
        add constraint FK1C3B6D3FFB8D007D 
        foreign key (agent_id) 
        references agent;

    alter table alignment_certificate_request 
        add constraint FK9EBFB38B1F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table alignment_certificate_request 
        add constraint FK9EBFB38BED1B9492 
        foreign key (id) 
        references request;

    alter table birth_details_request 
        add constraint FKB3569612ED1B9492 
        foreign key (id) 
        references request;

    alter table bulky_waste_collection_request 
        add constraint FK1F104ECBED1B9492 
        foreign key (id) 
        references request;

    alter table bulky_waste_collection_request_bulky_waste_type 
        add constraint FK7E2C4DCBAEAD5FA0 
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

    alter table child_legal_responsible_map 
        add constraint FK62E1102AC5C931EC 
        foreign key (legal_responsible_id) 
        references adult;

    alter table child_legal_responsible_map 
        add constraint FK62E1102A30CABB22 
        foreign key (child_id) 
        references child;

    alter table compostable_waste_collection_request 
        add constraint FKAFF72877ED1B9492 
        foreign key (id) 
        references request;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424BAC577A08 
        foreign key (compostable_waste_collection_request_id) 
        references compostable_waste_collection_request;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424BC1F23BD7 
        foreign key (compostable_waste_type_id) 
        references local_referential_data;

    alter table death_details_request 
        add constraint FK85B0A9C7ED1B9492 
        foreign key (id) 
        references request;

    alter table dhr_donation 
        add constraint FK91725043E45A0A7F 
        foreign key (donation_notary_address_id) 
        references address;

    alter table dhr_donation 
        add constraint FK9172504366C81F29 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_personal_estate_and_saving 
        add constraint FK5EFB376766C81F29 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E27F802E509 
        foreign key (previous_dwelling_address_id) 
        references address;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E2766C81F29 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_real_asset 
        add constraint FK6AA7D980A3F3FF52 
        foreign key (real_asset_address_id) 
        references address;

    alter table dhr_real_asset 
        add constraint FK6AA7D98066C81F29 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table document 
        add constraint FK335CD11B59302132 
        foreign key (individual_id) 
        references individual;

    alter table document 
        add constraint FK335CD11BDDD47DCE 
        foreign key (document_type_id) 
        references document_type;

    alter table document 
        add constraint FK335CD11B8BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table document_action 
        add constraint FKA42545DA1F561FF2 
        foreign key (document_id) 
        references document;

    alter table document_binary 
        add constraint FKA62BD3A51F561FF2 
        foreign key (document_id) 
        references document;

    alter table domestic_help_request 
        add constraint FK3C0081121C4A2C9A 
        foreign key (spouse_information_id) 
        references adult;

    alter table domestic_help_request 
        add constraint FK3C008112A2B2928B 
        foreign key (current_dwelling_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C008112B3BAD17C 
        foreign key (spouse_employer_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C0081126FFC52CB 
        foreign key (tutor_address_id) 
        references address;

    alter table domestic_help_request 
        add constraint FK3C008112ED1B9492 
        foreign key (id) 
        references request;

    alter table electoral_roll_registration_request 
        add constraint FK45625529F0159453 
        foreign key (subject_address_outside_city_id) 
        references address;

    alter table electoral_roll_registration_request 
        add constraint FK45625529ED1B9492 
        foreign key (id) 
        references request;

    alter table forms 
        add constraint FK5D18C2F1808DF5C 
        foreign key (request_form_id) 
        references request_form;

    alter table forms 
        add constraint FK5D18C2FD97439C 
        foreign key (request_type_id) 
        references request_type;

    alter table handicap_allowance_request 
        add constraint FKF20630A16D27AFFE 
        foreign key (legal_representative_address_id) 
        references address;

    alter table handicap_allowance_request 
        add constraint FKF20630A1ED1B9492 
        foreign key (id) 
        references request;

    alter table holiday_security_request 
        add constraint FKED34C597E2AF3D30 
        foreign key (other_contact_address_id) 
        references address;

    alter table holiday_security_request 
        add constraint FKED34C597ED1B9492 
        foreign key (id) 
        references request;

    alter table home_folder 
        add constraint FKDB87BBCE6AB1E860 
        foreign key (adress_id) 
        references address;

    alter table home_folder_modification_request 
        add constraint FK26ED7ABDED1B9492 
        foreign key (id) 
        references request;

    alter table individual 
        add constraint FKFD3DA2996AB1E860 
        foreign key (adress_id) 
        references address;

    alter table individual 
        add constraint FKFD3DA2998BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table individual 
        add constraint FKFD3DA29948B0ABD2 
        foreign key (card_id) 
        references card;

    alter table library_registration_request 
        add constraint FKEA37820DED1B9492 
        foreign key (id) 
        references request;

    alter table library_registration_request_subscription 
        add constraint FK56C4BE0F6E60AC03 
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
        add constraint FK38315C1DED1B9492 
        foreign key (id) 
        references request;

    alter table military_census_request 
        add constraint FK56137C47ED1B9492 
        foreign key (id) 
        references request;

    alter table music_school_registration_request 
        add constraint FK51A399DAED1B9492 
        foreign key (id) 
        references request;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD4F5425501 
        foreign key (music_school_registration_request_id) 
        references music_school_registration_request;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD4696ECB 
        foreign key (activity_id) 
        references local_referential_data;

    alter table payment 
        add constraint FKD11C32061BC4A960 
        foreign key (requester_id) 
        references adult;

    alter table payment 
        add constraint FKD11C32068BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table perischool_activity_registration_request 
        add constraint FK76BAA59A20540B7 
        foreign key (school_id) 
        references school;

    alter table perischool_activity_registration_request 
        add constraint FK76BAA59AED1B9492 
        foreign key (id) 
        references request;

    alter table perischool_activity_registration_request_other_individual 
        add constraint FKD6BDD32DDCC9C993 
        foreign key (other_individual_id) 
        references other_individual;

    alter table perischool_activity_registration_request_other_individual 
        add constraint FKD6BDD32D4B24749F 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E9D633AA6C 
        foreign key (perischool_activity_id) 
        references local_referential_data;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E94B24749F 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table personal_details_request 
        add constraint FKDA412593ED1B9492 
        foreign key (id) 
        references request;

    alter table place_reservation_request 
        add constraint FK10FCEDE4ED1B9492 
        foreign key (id) 
        references request;

    alter table place_reservation_request_place_reservation 
        add constraint FK9493CEF96E5CE64D 
        foreign key (place_reservation_id) 
        references place_reservation_data;

    alter table place_reservation_request_place_reservation 
        add constraint FK9493CEF9E2EAB80C 
        foreign key (place_reservation_request_id) 
        references place_reservation_request;

    alter table purchase_item 
        add constraint FKB113279154BCD4FA 
        foreign key (payment_id) 
        references payment;

    alter table purchase_item 
        add constraint FKB1132791EF51C842 
        foreign key (request_id) 
        references request;

    alter table purchase_item_specific_data 
        add constraint FK455E96692BA69830 
        foreign key (id) 
        references purchase_item;

    alter table recreation_activity_registration_request 
        add constraint FKD1F8ECCF8EE79C 
        foreign key (recreation_center_id) 
        references recreation_center;

    alter table recreation_activity_registration_request 
        add constraint FKD1F8ECCED1B9492 
        foreign key (id) 
        references request;

    alter table recreation_activity_registration_request_other_individual 
        add constraint FK8026343BDCC9C993 
        foreign key (other_individual_id) 
        references other_individual;

    alter table recreation_activity_registration_request_other_individual 
        add constraint FK8026343B14E9A3B 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA914E9A3B 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA97F2ADC1E 
        foreign key (recreation_activity_id) 
        references local_referential_data;

    alter table remote_support_request 
        add constraint FKEAA6DC26ED1B9492 
        foreign key (id) 
        references request;

    alter table request 
        add constraint FK414EF28F1BC4A960 
        foreign key (requester_id) 
        references adult;

    alter table request 
        add constraint FK414EF28F3FFD6284 
        foreign key (means_of_contact_id) 
        references means_of_contact;

    alter table request 
        add constraint FK414EF28FD97439C 
        foreign key (request_type_id) 
        references request_type;

    alter table request 
        add constraint FK414EF28F8BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table request_action 
        add constraint FK7AC459E6EF51C842 
        foreign key (request_id) 
        references request;

    alter table request_document_map 
        add constraint FKCBC2F7E81F561FF2 
        foreign key (document_id) 
        references document;

    alter table request_document_map 
        add constraint FKCBC2F7E8EF51C842 
        foreign key (request_id) 
        references request;

    alter table request_note 
        add constraint FK4DABB7A2EF51C842 
        foreign key (request_id) 
        references request;

    alter table request_type 
        add constraint FK4DAE96EACE4D7137 
        foreign key (category_id) 
        references category;

    alter table requirement 
        add constraint FK15A8DC43DDD47DCE 
        foreign key (document_type_id) 
        references document_type;

    alter table requirement 
        add constraint FK15A8DC43D97439C 
        foreign key (request_type_id) 
        references request_type;

    alter table school_canteen_registration_request 
        add constraint FKDC4CBC6920540B7 
        foreign key (school_id) 
        references school;

    alter table school_canteen_registration_request 
        add constraint FKDC4CBC69ED1B9492 
        foreign key (id) 
        references request;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F9AAB3F7 
        foreign key (canteen_attending_days_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F9E5E30099 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADF9D0BE4E5 
        foreign key (food_diet_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADFE5E30099 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_registration_request 
        add constraint FK7BDFE8F420540B7 
        foreign key (school_id) 
        references school;

    alter table school_registration_request 
        add constraint FK7BDFE8F4ED1B9492 
        foreign key (id) 
        references request;

    alter table seasons 
        add constraint FK7552F1F0D97439C 
        foreign key (request_type_id) 
        references request_type;

    alter table sewer_connection_request 
        add constraint FK50B057BB1F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table sewer_connection_request 
        add constraint FK50B057BBED1B9492 
        foreign key (id) 
        references request;

    alter table sms_notification_request 
        add constraint FK33CA6661ED1B9492 
        foreign key (id) 
        references request;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B37C4119F 
        foreign key (sms_notification_request_id) 
        references sms_notification_request;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B756FB911 
        foreign key (interests_id) 
        references local_referential_data;

    alter table technical_intervention_request 
        add constraint FKC051B8C974526C97 
        foreign key (intervention_place_id) 
        references address;

    alter table technical_intervention_request 
        add constraint FKC051B8C9ED1B9492 
        foreign key (id) 
        references request;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79AC7CF39D58 
        foreign key (intervention_type_id) 
        references local_referential_data;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79AC1A297B4F 
        foreign key (technical_intervention_request_id) 
        references technical_intervention_request;

    alter table ticket_type_selection 
        add constraint FK3B70C45A6592BACC 
        foreign key (place_reservation_data_id) 
        references place_reservation_data;

    alter table vacations_diary 
        add constraint FK2890BF7ACE7A2F50 
        foreign key (vacations_registration_request_id) 
        references vacations_registration_request;

    alter table vacations_registration_request 
        add constraint FK92F4987230CABB22 
        foreign key (child_id) 
        references child;

    alter table vacations_registration_request 
        add constraint FK92F49872F8EE79C 
        foreign key (recreation_center_id) 
        references recreation_center;

    alter table vacations_registration_request 
        add constraint FK92F49872ED1B9492 
        foreign key (id) 
        references request;

    alter table vacations_registration_request_other_individual 
        add constraint FK567CEB55DCC9C993 
        foreign key (other_individual_id) 
        references other_individual;

    alter table vacations_registration_request_other_individual 
        add constraint FK567CEB55CE7A2F50 
        foreign key (vacations_registration_request_id) 
        references vacations_registration_request;

    alter table vo_card_request 
        add constraint FKC295D426ED1B9492 
        foreign key (id) 
        references request;

    create sequence hibernate_sequence;
