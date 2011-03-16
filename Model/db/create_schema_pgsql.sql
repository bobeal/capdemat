
    alter table adult 
        drop constraint FK58621BA71A211CC;

    alter table agent_category_roles 
        drop constraint FKBAFB98B63ED1C7EB;

    alter table agent_site_roles 
        drop constraint FK1C3B6D3FFB8D007D;

    alter table alignment_certificate_request 
        drop constraint FK9EBFB38B1F88D72E;

    alter table alignment_numbering_connection_request 
        drop constraint FKEBD131101F88D72E;

    alter table alignment_numbering_connection_request 
        drop constraint FKEBD13110C6C3DEB1;

    alter table bafa_grant_request 
        drop constraint FK50AFA827681FBDDD;

    alter table bafa_grant_request 
        drop constraint FK50AFA82787B85F15;

    alter table bafa_grant_request 
        drop constraint FK50AFA8271EE1CD99;

    alter table bulky_waste_collection_request 
        drop constraint FK1F104ECB1AE70A63;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCB94784C0B;

    alter table bulky_waste_collection_request_bulky_waste_type 
        drop constraint FK7E2C4DCB4C319B5C;

    alter table category_emails 
        drop constraint FKB9136EB83ED1C7EB;

    alter table child 
        drop constraint FK5A3F51C71A211CC;

    alter table compostable_waste_collection_request 
        drop constraint FKAFF728771AE70A63;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424B75921530;

    alter table compostable_waste_collection_request_compostable_waste_type 
        drop constraint FK765E424B28FD5FB3;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC6D5B4A55;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC79D85259;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC1F99E36F;

    alter table dhr_not_real_asset 
        drop constraint FK2BA9F1EC742C3FB2;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E274AF76B3A;

    alter table dhr_previous_dwelling 
        drop constraint FKB0B96E27742C3FB2;

    alter table dhr_real_asset 
        drop constraint FK6AA7D9809D2A9E41;

    alter table dhr_real_asset 
        drop constraint FK6AA7D980742C3FB2;

    alter table document 
        drop constraint FK335CD11B8EAF8712;

    alter table document_action 
        drop constraint FKA42545DA7A6C6B5B;

    alter table document_binary 
        drop constraint FKA62BD3A57A6C6B5B;

    alter table domestic_help_request 
        drop constraint FK3C00811289BB4925;

    alter table domestic_help_request 
        drop constraint FK3C0081123044483F;

    alter table domestic_help_request 
        drop constraint FK3C008112D045047B;

    alter table domestic_help_request 
        drop constraint FK3C008112D6EC023A;

    alter table electoral_roll_registration_request 
        drop constraint FK45625529F0159453;

    alter table external_application_broker 
        drop constraint FK839CD69C2C94FF5A;

    alter table external_deposit_account_item_detail 
        drop constraint FK4A90965670F56907;

    alter table external_home_folder 
        drop constraint FKA9D7255A2C94FF5A;

    alter table external_individual 
        drop constraint FKC1D4D78DF1C1B621;

    alter table external_invoice_item_detail 
        drop constraint FKFB8FF2772062B3BC;

    alter table forms 
        drop constraint FK5D18C2FC5FD0068;

    alter table forms 
        drop constraint FK5D18C2FD06E9C28;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2BC49188;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACCA933FB6F;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2F7F7877;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2AF072D5;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC2633BF01;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACCF813ECA3;

    alter table handicap_compensation_adult_request 
        drop constraint FK73D0EACC86312376;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2BC49188;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EA933FB6F;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EE215BDD5;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2F7F7877;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E356CE3FE;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2AF072D5;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E2633BF01;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2EF813ECA3;

    alter table handicap_compensation_child_request 
        drop constraint FK309E3C2E489D3DBC;

    alter table hcar_additional_fee 
        drop constraint FKB357C9A17010720F;

    alter table hcar_care_service 
        drop constraint FKD2D3BA7A7AB5BC78;

    alter table hcar_care_service 
        drop constraint FKD2D3BA7A7010720F;

    alter table hcar_family_assistance_member 
        drop constraint FKF63BE3D97010720F;

    alter table hcar_family_dependent 
        drop constraint FK6E4B5577010720F;

    alter table hcar_home_intervenant 
        drop constraint FK6294A7D77010720F;

    alter table hcar_other_benefit 
        drop constraint FKA530B5D57010720F;

    alter table hcar_other_folder 
        drop constraint FK4681FB707010720F;

    alter table hcar_professional 
        drop constraint FK581A111AEB2A3B3A;

    alter table hcar_professional 
        drop constraint FK581A111A7010720F;

    alter table hccr_additional_fee 
        drop constraint FK54AB85A3A233A8CB;

    alter table hccr_care_service 
        drop constraint FK868A8EFCA233A8CB;

    alter table hccr_care_service 
        drop constraint FK868A8EFC7AB5BC78;

    alter table hccr_family_assistance_member 
        drop constraint FK68DE055BA233A8CB;

    alter table hccr_family_dependent 
        drop constraint FKA23978D9A233A8CB;

    alter table hccr_home_intervenant 
        drop constraint FKFDE96B59A233A8CB;

    alter table hccr_other_benefit 
        drop constraint FK68547193A233A8CB;

    alter table hccr_other_folder 
        drop constraint FKFA38CFF2A233A8CB;

    alter table hccr_professional 
        drop constraint FKBD0E59CA233A8CB;

    alter table hccr_professional 
        drop constraint FKBD0E59CEB2A3B3A;

    alter table holiday_security_request 
        drop constraint FKED34C597E2AF3D30;

    alter table home_folder 
        drop constraint FKDB87BBCEB7531222;

    alter table individual 
        drop constraint FKFD3DA299B7531222;

    alter table individual 
        drop constraint FKFD3DA2998BD77771;

    alter table individual_mapping 
        drop constraint FK19DDB92881C62393;

    alter table individual_role 
        drop constraint FK3C7D4E5CD4C3A2D8;

    alter table learning_activities_discovery_registration_request_atelier_eveil 
        drop constraint FK6631159E51ABD2B5;

    alter table learning_activities_discovery_registration_request_atelier_eveil 
        drop constraint FK6631159E9AA8EC9F;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0FD7ED8C0C;

    alter table library_registration_request_subscription 
        drop constraint FK56C4BE0F97237F56;

    alter table local_referential_association 
        drop constraint FK6B28F677E6775FC;

    alter table local_referential_association 
        drop constraint FK6B28F6778F4CC15E;

    alter table local_referential_data 
        drop constraint FK49407E748F4CC15E;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD4B4094824;

    alter table music_school_registration_request_activity 
        drop constraint FK6393FFD48F0273CA;

    alter table perischool_activity_registration_request 
        drop constraint FK76BAA59A20540B7;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E93D77B468;

    alter table perischool_activity_registration_request_perischool_activity 
        drop constraint FK2007A4E989D383C5;

    alter table perischool_authorized_individual 
        drop constraint FKEE33EA1E3D77B468;

    alter table perischool_authorized_individual 
        drop constraint FKEE33EA1EB7531222;

    alter table perischool_contact_individual 
        drop constraint FK5B659D573D77B468;

    alter table perischool_contact_individual 
        drop constraint FK5B659D57B7531222;

    alter table purchase_item 
        drop constraint FKB1132791A8364360;

    alter table purchase_item_specific_data 
        drop constraint FK455E9669669F9D96;

    alter table recreation_activity_registration_request 
        drop constraint FKD1F8ECCF8EE79C;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA932CAB577;

    alter table recreation_activity_registration_request_recreation_activity 
        drop constraint FK54117CA9FCCD2304;

    alter table recreation_authorized_individual 
        drop constraint FK5BA62550B7531222;

    alter table recreation_authorized_individual 
        drop constraint FK5BA62550FCCD2304;

    alter table recreation_contact_individual 
        drop constraint FK52B67F65B7531222;

    alter table recreation_contact_individual 
        drop constraint FK52B67F65FCCD2304;

    alter table request 
        drop constraint FK414EF28F85577048;

    alter table request 
        drop constraint FK414EF28FC5FD0068;

    alter table request 
        drop constraint FK414EF28F3FFD6284;

    alter table request_action 
        drop constraint FK7AC459E6D7FE2713;

    alter table request_admin_action_complementary_data 
        drop constraint FK783DC15070D87F22;

    alter table request_document 
        drop constraint FK712980CBD7FE2713;

    alter table request_external_action_complementary_data 
        drop constraint FKB088082C294C4979;

    alter table request_note 
        drop constraint FK4DABB7A2D7FE2713;

    alter table request_season 
        drop constraint FK998F4693C5FD0068;

    alter table request_type 
        drop constraint FK4DAE96EA3ED1C7EB;

    alter table request_type 
        drop constraint FK4DAE96EA1D0DF06;

    alter table requirement 
        drop constraint FK15A8DC438EAF8712;

    alter table requirement 
        drop constraint FK15A8DC43C5FD0068;

    alter table school_canteen_registration_request 
        drop constraint FKDC4CBC6920540B7;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F9B44A8D50;

    alter table school_canteen_registration_request_canteen_attending_days 
        drop constraint FK1323D9F97C526984;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADF50ABBE3E;

    alter table school_canteen_registration_request_food_diet 
        drop constraint FK5768CADF7C526984;

    alter table school_registration_request 
        drop constraint FK7BDFE8F420540B7;

    alter table sewer_connection_request 
        drop constraint FK50B057BB1F88D72E;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B290F926A;

    alter table sms_notification_request_interests 
        drop constraint FKCE60DA2B10A7E028;

    alter table study_grant_request 
        drop constraint FK7D2F0A761EE1CD99;

    alter table study_grant_request_current_school_name 
        drop constraint FK49484F6719BB0CC1;

    alter table study_grant_request_current_school_name 
        drop constraint FK49484F671E1FCE3;

    alter table study_grant_request_tax_household_city 
        drop constraint FK1B56894857A06C54;

    alter table study_grant_request_tax_household_city 
        drop constraint FK1B56894819BB0CC1;

    alter table tbr_ticket 
        drop constraint FK231823E7CFCF80C3;

    alter table technical_intervention_request 
        drop constraint FKC051B8C974526C97;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79AC309376B1;

    alter table technical_intervention_request_intervention_type 
        drop constraint FK5ADF79AC43EECED8;

    alter table ticket_event 
        drop constraint FK9B59C7A7E386AF5C;

    alter table ticket_fare 
        drop constraint FK15872D81914D9745;

    alter table ticket_place_category 
        drop constraint FK228856C92803C01C;

    alter table ticket_subscriber_limits 
        drop constraint FK2A415CAF42EA14;

    alter table user_action 
        drop constraint FKD768C52A8BD77771;

    drop table address;

    drop table adult;

    drop table agent;

    drop table agent_category_roles;

    drop table agent_site_roles;

    drop table alignment_certificate_request;

    drop table alignment_numbering_connection_request;

    drop table bafa_grant_request;

    drop table birth_details_request;

    drop table bulky_waste_collection_request;

    drop table bulky_waste_collection_request_bulky_waste_type;

    drop table category;

    drop table category_emails;

    drop table child;

    drop table compostable_waste_collection_request;

    drop table compostable_waste_collection_request_compostable_waste_type;

    drop table day_care_center_registration_request;

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

    drop table external_application;

    drop table external_application_broker;

    drop table external_deposit_account_item_detail;

    drop table external_home_folder;

    drop table external_individual;

    drop table external_invoice_item_detail;

    drop table forms;

    drop table french_r_i_b;

    drop table global_request_type_configuration;

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

    drop table holiday_security_request;

    drop table home_emergency_registration_request;

    drop table home_folder;

    drop table home_folder_mapping;

    drop table home_folder_modification_request;

    drop table individual;

    drop table individual_mapping;

    drop table individual_role;

    drop table learning_activities_discovery_registration_request;

    drop table learning_activities_discovery_registration_request_atelier_eveil;

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

    drop table payment;

    drop table perischool_activity_registration_request;

    drop table perischool_activity_registration_request_perischool_activity;

    drop table perischool_authorized_individual;

    drop table perischool_contact_individual;

    drop table purchase_item;

    drop table purchase_item_specific_data;

    drop table recreation_activity_registration_request;

    drop table recreation_activity_registration_request_recreation_activity;

    drop table recreation_authorized_individual;

    drop table recreation_center;

    drop table recreation_contact_individual;

    drop table remote_support_request;

    drop table request;

    drop table request_action;

    drop table request_admin_action;

    drop table request_admin_action_complementary_data;

    drop table request_document;

    drop table request_external_action;

    drop table request_external_action_complementary_data;

    drop table request_form;

    drop table request_lock;

    drop table request_note;

    drop table request_season;

    drop table request_type;

    drop table requirement;

    drop table school;

    drop table school_canteen_registration_request;

    drop table school_canteen_registration_request_canteen_attending_days;

    drop table school_canteen_registration_request_food_diet;

    drop table school_registration_request;

    drop table sewer_connection_request;

    drop table sms_notification_request;

    drop table sms_notification_request_interests;

    drop table study_grant_request;

    drop table study_grant_request_current_school_name;

    drop table study_grant_request_tax_household_city;

    drop table tbr_ticket;

    drop table technical_intervention_request;

    drop table technical_intervention_request_intervention_type;

    drop table ticket_booking_request;

    drop table ticket_entertainment;

    drop table ticket_event;

    drop table ticket_fare;

    drop table ticket_place_category;

    drop table ticket_subscriber;

    drop table ticket_subscriber_limits;

    drop table user_action;

    drop table user_external_action;

    drop table user_security_rule;

    drop table vo_card_request;

    drop sequence hibernate_sequence;

    create table address (
        id int8 not null,
        additional_delivery_information varchar(38),
        additional_geographical_information varchar(38),
        street_number varchar(5),
        street_name varchar(32),
        street_matriculation varchar(8),
        street_rivoli_code varchar(10),
        place_name_or_service varchar(38),
        postal_code varchar(5),
        city_insee_code varchar(5),
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
        login varchar(255) unique,
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
        email varchar(255),
        primary key (id)
    );

    create table agent_category_roles (
        category_id int8 not null,
        agent_id int8,
        profile varchar(16)
    );

    create table agent_site_roles (
        agent_id int8 not null,
        profile varchar(16)
    );

    create table alignment_certificate_request (
        id int8 not null,
        locality varchar(255),
        number bytea,
        owner_address_id int8,
        owner_first_names varchar(255),
        owner_last_name varchar(38),
        requester_quality varchar(255),
        section varchar(255),
        transportation_route varchar(255),
        primary key (id)
    );

    create table alignment_numbering_connection_request (
        id int8 not null,
        area bytea,
        is_account_address bool,
        is_alignment bool,
        is_connection bool,
        is_numbering bool,
        locality varchar(255),
        more_than_two_years bool,
        number bytea,
        other_address_id int8,
        owner_address_id int8,
        owner_first_names varchar(255),
        owner_last_name varchar(38),
        requester_quality varchar(255),
        section varchar(255),
        transportation_route varchar(255),
        primary key (id)
    );

    create table bafa_grant_request (
        id int8 not null,
        account_holder_birth_date timestamp,
        account_holder_edemande_id varchar(255),
        account_holder_first_name varchar(38),
        account_holder_last_name varchar(38),
        account_holder_title varchar(255),
        edemande_id varchar(255),
        french_r_i_b_id int8,
        internship_end_date timestamp,
        internship_institute_address_id int8,
        internship_institute_name varchar(255),
        internship_start_date timestamp,
        is_subject_account_holder bool,
        subject_address_id int8,
        subject_birth_city varchar(32),
        subject_birth_date timestamp,
        subject_email varchar(255),
        subject_phone varchar(10),
        primary key (id)
    );

    create table birth_details_request (
        id int8 not null,
        birth_city varchar(32),
        birth_date timestamp,
        birth_first_names varchar(255),
        birth_last_name varchar(38),
        birth_marriage_name varchar(38),
        birth_postal_code varchar(2),
        comment varchar(255),
        copies bytea,
        father_first_names varchar(255),
        father_last_name varchar(38),
        format varchar(255),
        mother_first_names varchar(255),
        mother_maiden_name varchar(38),
        motive varchar(255),
        requester_quality varchar(255),
        requester_quality_precision varchar(255),
        primary key (id)
    );

    create table bulky_waste_collection_request (
        id int8 not null,
        collection_address_id int8,
        other_waste varchar(255),
        primary key (id)
    );

    create table bulky_waste_collection_request_bulky_waste_type (
        bulky_waste_collection_request_id int8 not null,
        bulky_waste_type_id int8 not null,
        bulky_waste_type_index int4 not null,
        primary key (bulky_waste_collection_request_id, bulky_waste_type_index)
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
        born bool,
        sex varchar(8),
        primary key (id)
    );

    create table compostable_waste_collection_request (
        id int8 not null,
        collection_address_id int8,
        other_waste varchar(255),
        primary key (id)
    );

    create table compostable_waste_collection_request_compostable_waste_type (
        compostable_waste_collection_request_id int8 not null,
        compostable_waste_type_id int8 not null,
        compostable_waste_type_index int4 not null,
        primary key (compostable_waste_collection_request_id, compostable_waste_type_index)
    );

    create table day_care_center_registration_request (
        id int8 not null,
        accueil_anterieur varchar(255),
        choix_horaires_accueil varchar(255),
        choix_type_date_placement_accueil_regulier varchar(255),
        choix_type_rendez_vous varchar(255),
        commentaire_citoyen varchar(600),
        commune_lieu_travail_mere varchar(255),
        commune_lieu_travail_pere varchar(255),
        date_placement_debut timestamp,
        date_placement_fin timestamp,
        dix_huit_mois_enfant timestamp,
        est_horaires_reguliers_mere bool,
        est_horaires_reguliers_pere bool,
        horaire_placement_apres_midi_debut bytea,
        horaire_placement_apres_midi_debut_jeudi bytea,
        horaire_placement_apres_midi_debut_lundi bytea,
        horaire_placement_apres_midi_debut_mardi bytea,
        horaire_placement_apres_midi_debut_mercredi bytea,
        horaire_placement_apres_midi_debut_vendredi bytea,
        horaire_placement_apres_midi_fin bytea,
        horaire_placement_apres_midi_fin_jeudi bytea,
        horaire_placement_apres_midi_fin_lundi bytea,
        horaire_placement_apres_midi_fin_mardi bytea,
        horaire_placement_apres_midi_fin_mercredi bytea,
        horaire_placement_apres_midi_fin_vendredi bytea,
        horaire_placement_matin_debut bytea,
        horaire_placement_matin_debut_jeudi bytea,
        horaire_placement_matin_debut_lundi bytea,
        horaire_placement_matin_debut_mardi bytea,
        horaire_placement_matin_debut_mercredi bytea,
        horaire_placement_matin_debut_vendredi bytea,
        horaire_placement_matin_fin bytea,
        horaire_placement_matin_fin_jeudi bytea,
        horaire_placement_matin_fin_lundi bytea,
        horaire_placement_matin_fin_mardi bytea,
        horaire_placement_matin_fin_mercredi bytea,
        horaire_placement_matin_fin_vendredi bytea,
        horaires_reguliers_mere varchar(255),
        horaires_reguliers_pere varchar(255),
        horaires_travail_jeudi_mere varchar(255),
        horaires_travail_jeudi_pere varchar(255),
        horaires_travail_lundi_mere varchar(255),
        horaires_travail_lundi_pere varchar(255),
        horaires_travail_mardi_mere varchar(255),
        horaires_travail_mardi_pere varchar(255),
        horaires_travail_mercredi_mere varchar(255),
        horaires_travail_mercredi_pere varchar(255),
        horaires_travail_vendredi_mere varchar(255),
        horaires_travail_vendredi_pere varchar(255),
        mode_accueil bool,
        mode_accueil_choix_deux varchar(255),
        mode_accueil_choix_un varchar(255),
        plage_horaire_contact varchar(255),
        precision_autre_situation_actuelle_mere varchar(255),
        precision_autre_situation_actuelle_pere varchar(255),
        profession_mere varchar(255),
        profession_pere varchar(255),
        situation_actuelle_mere varchar(255),
        situation_actuelle_pere varchar(255),
        telephone_contact varchar(10),
        primary key (id)
    );

    create table death_details_request (
        id int8 not null,
        comment varchar(255),
        copies bytea,
        death_city varchar(32),
        death_date timestamp,
        death_first_names varchar(255),
        death_last_name varchar(38),
        death_postal_code varchar(2),
        format varchar(255),
        motive varchar(255),
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
        deposit_id int8,
        home_folder_id int8,
        individual_id int8,
        document_type_id int8,
        certified bool,
        primary key (id)
    );

    create table document_action (
        id int8 not null,
        user_id int8,
        type varchar(255) not null,
        note varchar(255),
        date timestamp,
        resulting_state varchar(16),
        document_id int8,
        primary key (id)
    );

    create table document_binary (
        id int8 not null,
        data bytea,
        content_type varchar(255),
        preview bytea,
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
        dhr_allowances bytea,
        dhr_complementary_pension_plan varchar(255),
        dhr_current_dwelling_address_id int8,
        dhr_current_dwelling_arrival_date timestamp,
        dhr_current_dwelling_kind varchar(255),
        dhr_current_dwelling_net_area numeric(19, 2),
        dhr_current_dwelling_number_of_room numeric(19, 2),
        dhr_current_dwelling_phone varchar(10),
        dhr_current_dwelling_status varchar(255),
        dhr_furniture_investment_income bytea,
        dhr_guardian_address_id int8,
        dhr_guardian_measure varchar(255),
        dhr_guardian_name varchar(38),
        dhr_have_family_referent bool,
        dhr_income_tax bytea,
        dhr_incomes_annual_total bytea,
        dhr_is_spouse_retired bool,
        dhr_net_income bytea,
        dhr_pension_plan_detail varchar(255),
        dhr_principal_pension_plan varchar(255),
        dhr_real_estate_investment_income bytea,
        dhr_referent_address_id int8,
        dhr_referent_first_name varchar(38),
        dhr_referent_name varchar(38),
        dhr_request_kind varchar(255),
        dhr_requester_birth_date timestamp,
        dhr_requester_birth_place varchar(255),
        dhr_requester_france_arrival_date timestamp,
        dhr_requester_have_guardian bool,
        dhr_requester_is_french_resident bool,
        dhr_requester_nationality varchar(32),
        dhr_spouse_address_id int8,
        dhr_spouse_birth_date timestamp,
        dhr_spouse_birth_place varchar(255),
        dhr_spouse_complementary_pension_plan varchar(255),
        dhr_spouse_employer varchar(255),
        dhr_spouse_family_status varchar(255),
        dhr_spouse_first_name varchar(38),
        dhr_spouse_france_arrival_date timestamp,
        dhr_spouse_is_french_resident bool,
        dhr_spouse_maiden_name varchar(38),
        dhr_spouse_name varchar(38),
        dhr_spouse_nationality varchar(32),
        dhr_spouse_pension_plan_detail varchar(255),
        dhr_spouse_principal_pension_plan varchar(255),
        dhr_spouse_profession varchar(255),
        dhr_spouse_title varchar(255),
        local_rate bytea,
        pensions bytea,
        professional_taxes bytea,
        property_taxes bytea,
        primary key (id)
    );

    create table electoral_roll_registration_request (
        id int8 not null,
        electoral_number int8,
        motive varchar(255),
        polling_school_name varchar(255),
        polling_station int8,
        subject_address_outside_city_id int8,
        subject_nationality varchar(32),
        subject_old_city varchar(5),
        primary key (id)
    );

    create table external_application (
        id int8 not null,
        label varchar(255),
        description varchar(255),
        primary key (id)
    );

    create table external_application_broker (
        external_application_id int8 not null,
        broker varchar(255)
    );

    create table external_deposit_account_item_detail (
        id int8 not null,
        date timestamp,
        holder_name varchar(255),
        holder_surname varchar(255),
        payment_id varchar(255),
        payment_type varchar(255),
        value int4,
        bank_reference varchar(255),
        external_deposit_account_item_id int8 not null,
        primary key (id)
    );

    create table external_home_folder (
        id int8 not null,
        mapping_state varchar(255) not null,
        external_id varchar(255),
        external_application_id int8,
        address varchar(255),
        external_home_application_index int4,
        primary key (id)
    );

    create table external_individual (
        id int8 not null,
        first_name varchar(255),
        external_id varchar(255),
        last_name varchar(255),
        email varchar(255),
        home_phone varchar(255),
        responsible bool,
        external_home_folder_id int8,
        external_home_folder_index int4,
        primary key (id)
    );

    create table external_invoice_item_detail (
        id int8 not null,
        subject_name varchar(255),
        label varchar(255),
        quatity numeric(19, 2),
        subject_surname varchar(255),
        unit_price int4,
        value int4,
        external_invoice_item_id int8 not null,
        primary key (id)
    );

    create table forms (
        request_form_id int8 not null,
        request_type_id int8 not null,
        primary key (request_form_id, request_type_id)
    );

    create table french_r_i_b (
        id int8 not null,
        bank_code int4 not null,
        counter_code int4 not null,
        account_number varchar(11) not null,
        account_key int4 not null,
        primary key (id)
    );

    create table global_request_type_configuration (
        id int8 not null,
        draft_live_duration int4 not null,
        draft_notification_before_delete int4 not null,
        requests_creation_notification_enabled bool not null,
        instruction_alerts_enabled bool not null,
        instruction_alerts_detailed bool not null,
        instruction_max_delay int4 not null,
        instruction_alert_delay int4 not null,
        request_lock_max_delay int4 not null,
        archives_password varchar(255),
        primary key (id)
    );

    create table handicap_compensation_adult_request (
        id int8 not null,
        benefits_compensatory_allowance_for_expenses bool,
        benefits_daily_allowances bool,
        benefits_disability_card bool,
        benefits_disability_compensation bool,
        benefits_disability_pension bool,
        benefits_disability_pension_category varchar(60),
        benefits_disability_ratio varchar(3),
        benefits_disability_recognition bool,
        benefits_disabled_adult_allocation bool,
        benefits_disabled_worker_recognition bool,
        benefits_education_allocation_of_disabled_children bool,
        benefits_education_of_disabled_children bool,
        benefits_education_of_disabled_children_details varchar(60),
        benefits_increase_for_independent_living bool,
        benefits_other_benefits bool,
        benefits_painful_standing_card bool,
        benefits_parking_card bool,
        benefits_professional_orientation bool,
        benefits_professional_orientation_details varchar(60),
        benefits_social_welfare bool,
        benefits_supplement_for_single_parents bool,
        benefits_supported_by_an_institution bool,
        benefits_supported_by_an_institution_details varchar(60),
        benefits_third_party_compensatory_allowance bool,
        benefits_third_party_supplement bool,
        benefits_third_person_compensatory_allowance bool,
        benefits_unemployment_benefits bool,
        benefits_work_accident_annuity bool,
        benefits_work_accident_annuity_ratio varchar(3),
        care_care_services bool,
        dwelling_establishment_reception bool,
        dwelling_kind varchar(255),
        dwelling_precision varchar(120),
        dwelling_reception_address_id int8,
        dwelling_reception_naming varchar(80),
        dwelling_reception_type varchar(255),
        dwelling_social_reception bool,
        dwelling_social_reception_address_id int8,
        dwelling_social_reception_naming varchar(80),
        facilities_animal_aid bool,
        facilities_animal_aid_details varchar(60),
        facilities_custom_car bool,
        facilities_custom_car_details varchar(60),
        facilities_housing bool,
        facilities_housing_details varchar(60),
        facilities_specialized_transport bool,
        facilities_specialized_transport_details varchar(60),
        facilities_technical_assistance bool,
        facilities_technical_assistance_details varchar(60),
        family_family_dependents bool,
        family_status varchar(255),
        folders_cdes bool,
        folders_cdes_department varchar(2),
        folders_cdes_number varchar(30),
        folders_cotorep bool,
        folders_cotorep_department varchar(2),
        folders_cotorep_number varchar(30),
        folders_mdph bool,
        folders_mdph_department varchar(2),
        folders_mdph_number varchar(30),
        folders_other_folders bool,
        formation_current_formation varchar(120),
        formation_diploma varchar(120),
        formation_previous_formation varchar(180),
        formation_studies_level varchar(30),
        health_doctor_first_name varchar(38),
        health_doctor_last_name varchar(38),
        health_followed_by_doctor bool,
        health_followed_by_hospital bool,
        health_followed_by_professional bool,
        health_hospital_name varchar(60),
        health_professional_first_name varchar(38),
        health_professional_last_name varchar(38),
        home_intervention_home_intervenant bool,
        is_family_assistance bool,
        legal_access_kind varchar(255),
        legal_access_presence bool,
        legal_access_representative_first_name varchar(38),
        legal_access_representative_kind varchar(255),
        legal_access_representative_kind_detail varchar(80),
        legal_access_representative_name varchar(38),
        payment_agency_address_id int8,
        payment_agency_beneficiary varchar(255),
        payment_agency_beneficiary_number varchar(20),
        payment_agency_name varchar(50),
        professional_status_address_id int8,
        professional_status_date timestamp,
        professional_status_elective_function bool,
        professional_status_elective_function_details varchar(60),
        professional_status_employer_name varchar(38),
        professional_status_environment varchar(255),
        professional_status_indemnified bool,
        professional_status_indemnified_date timestamp,
        professional_status_kind varchar(255),
        professional_status_profession varchar(60),
        professional_status_register_as_unemployed bool,
        professional_status_register_as_unemployed_date timestamp,
        professional_support_deals_with_same_professional bool,
        professional_support_professionals bool,
        professional_support_social_service_address_id int8,
        professional_support_social_service_name varchar(60),
        professional_support_social_service_support bool,
        project_comments varchar(600),
        project_needs varchar(600),
        project_requests_a_c_t_p_renewal bool,
        project_requests_assistance bool,
        project_requests_custom_car bool,
        project_requests_disability_card bool,
        project_requests_disability_cost_allocation bool,
        project_requests_disabled_adult_allowance bool,
        project_requests_disabled_priority_card bool,
        project_requests_disabled_worker_recognition bool,
        project_requests_education_allocation_of_disabled_children bool,
        project_requests_european_parking_card bool,
        project_requests_free_pension_membership bool,
        project_requests_handicap_recognition bool,
        project_requests_housing_facilities bool,
        project_requests_increase_for_independent_living bool,
        project_requests_institution_support bool,
        project_requests_ordinary_working bool,
        project_requests_other bool,
        project_requests_other_details varchar(60),
        project_requests_professional_orientation bool,
        project_requests_sheltered_work bool,
        project_requests_technical_help bool,
        project_requests_third_party_help bool,
        project_requests_transport_cost_allocation bool,
        project_requests_vocational_training bool,
        project_wish varchar(600),
        social_security_agency_address_id int8,
        social_security_agency_name varchar(50),
        social_security_member_ship_kind varchar(255),
        social_security_number varchar(13),
        studies_assistance_under_disability bool,
        studies_assistance_under_disability_details varchar(60),
        studies_high_school bool,
        studies_high_school_address_id int8,
        studies_high_school_grade varchar(60),
        studies_high_school_name varchar(60),
        subject_birth_city varchar(32),
        subject_birth_country varchar(50),
        subject_birth_date timestamp,
        subject_maiden_name varchar(38),
        subject_title varchar(255),
        primary key (id)
    );

    create table handicap_compensation_child_request (
        id int8 not null,
        ase_referent_department varchar(2),
        ase_referent_last_name varchar(38),
        benefits_compensatory_allowance_for_expenses bool,
        benefits_daily_allowances bool,
        benefits_disability_card bool,
        benefits_disability_compensation bool,
        benefits_disability_pension bool,
        benefits_disability_pension_category varchar(60),
        benefits_disability_ratio varchar(3),
        benefits_disability_recognition bool,
        benefits_disabled_adult_allocation bool,
        benefits_disabled_worker_recognition bool,
        benefits_education_allocation_of_disabled_children bool,
        benefits_education_of_disabled_children bool,
        benefits_education_of_disabled_children_details varchar(60),
        benefits_increase_for_independent_living bool,
        benefits_other_benefits bool,
        benefits_painful_standing_card bool,
        benefits_parking_card bool,
        benefits_professional_orientation bool,
        benefits_professional_orientation_details varchar(60),
        benefits_social_welfare bool,
        benefits_supplement_for_single_parents bool,
        benefits_supported_by_an_institution bool,
        benefits_supported_by_an_institution_details varchar(60),
        benefits_third_party_compensatory_allowance bool,
        benefits_third_party_supplement bool,
        benefits_third_person_compensatory_allowance bool,
        benefits_unemployment_benefits bool,
        benefits_work_accident_annuity bool,
        benefits_work_accident_annuity_ratio varchar(3),
        care_care_services bool,
        dwelling_establishment_reception bool,
        dwelling_kind varchar(255),
        dwelling_precision varchar(120),
        dwelling_reception_address_id int8,
        dwelling_reception_naming varchar(80),
        dwelling_reception_type varchar(255),
        dwelling_social_reception bool,
        dwelling_social_reception_address_id int8,
        dwelling_social_reception_naming varchar(80),
        facilities_animal_aid bool,
        facilities_animal_aid_details varchar(60),
        facilities_custom_car bool,
        facilities_custom_car_details varchar(60),
        facilities_housing bool,
        facilities_housing_details varchar(60),
        facilities_specialized_transport bool,
        facilities_specialized_transport_details varchar(60),
        facilities_technical_assistance bool,
        facilities_technical_assistance_details varchar(60),
        father_activity_reduction bool,
        father_activity_reduction_ratio bytea,
        father_first_name varchar(38),
        father_job varchar(60),
        father_last_name varchar(38),
        folders_cdes bool,
        folders_cdes_department varchar(2),
        folders_cdes_number varchar(30),
        folders_cotorep bool,
        folders_cotorep_department varchar(2),
        folders_cotorep_number varchar(30),
        folders_mdph bool,
        folders_mdph_department varchar(2),
        folders_mdph_number varchar(30),
        folders_other_folders bool,
        formation_current_formation varchar(120),
        formation_diploma varchar(120),
        formation_previous_formation varchar(180),
        formation_studies_level varchar(30),
        health_doctor_first_name varchar(38),
        health_doctor_last_name varchar(38),
        health_followed_by_doctor bool,
        health_followed_by_hospital bool,
        health_followed_by_professional bool,
        health_hospital_name varchar(60),
        health_professional_first_name varchar(38),
        health_professional_last_name varchar(38),
        home_intervention_home_intervenant bool,
        is_family_assistance bool,
        mother_activity_reduction bool,
        mother_activity_reduction_ratio bytea,
        mother_first_name varchar(38),
        mother_job varchar(60),
        mother_last_name varchar(38),
        payment_agency_address_id int8,
        payment_agency_beneficiary varchar(255),
        payment_agency_beneficiary_number varchar(20),
        payment_agency_name varchar(50),
        professional_status_address_id int8,
        professional_status_date timestamp,
        professional_status_elective_function bool,
        professional_status_elective_function_details varchar(60),
        professional_status_employer_name varchar(38),
        professional_status_environment varchar(255),
        professional_status_indemnified bool,
        professional_status_indemnified_date timestamp,
        professional_status_kind varchar(255),
        professional_status_profession varchar(60),
        professional_status_register_as_unemployed bool,
        professional_status_register_as_unemployed_date timestamp,
        professional_support_deals_with_same_professional bool,
        professional_support_professionals bool,
        project_comments varchar(600),
        project_needs varchar(600),
        project_requests_a_c_t_p_renewal bool,
        project_requests_assistance bool,
        project_requests_custom_car bool,
        project_requests_disability_card bool,
        project_requests_disability_cost_allocation bool,
        project_requests_disabled_adult_allowance bool,
        project_requests_disabled_priority_card bool,
        project_requests_disabled_worker_recognition bool,
        project_requests_education_allocation_of_disabled_children bool,
        project_requests_european_parking_card bool,
        project_requests_free_pension_membership bool,
        project_requests_handicap_recognition bool,
        project_requests_housing_facilities bool,
        project_requests_increase_for_independent_living bool,
        project_requests_institution_support bool,
        project_requests_ordinary_working bool,
        project_requests_other bool,
        project_requests_other_details varchar(60),
        project_requests_professional_orientation bool,
        project_requests_sheltered_work bool,
        project_requests_technical_help bool,
        project_requests_third_party_help bool,
        project_requests_transport_cost_allocation bool,
        project_requests_vocational_training bool,
        project_wish varchar(600),
        referent_birth_city varchar(32),
        referent_birth_country varchar(50),
        referent_birth_date timestamp,
        referent_family_dependents bool,
        referent_family_status varchar(255),
        referent_first_name varchar(38),
        referent_last_name varchar(38),
        referent_maiden_name varchar(38),
        referent_title varchar(255),
        schooling_attended_grade varchar(32),
        schooling_enrolment bool,
        schooling_extra_curricular bool,
        schooling_extra_curricular_details varchar(50),
        schooling_home_schooling bool,
        schooling_home_schooling_accompanist_address_id int8,
        schooling_home_schooling_accompanist_first_name varchar(38),
        schooling_home_schooling_accompanist_last_name varchar(38),
        schooling_home_schooling_kind varchar(255),
        schooling_personalized_schooling_plan bool,
        schooling_school_address_id int8,
        schooling_school_name varchar(80),
        schooling_schooling_kind varchar(255),
        schooling_send_to_school bool,
        schooling_specialized_grade bool,
        schooling_specialized_grade_details varchar(30),
        schooling_time varchar(4),
        social_security_agency_address_id int8,
        social_security_agency_name varchar(50),
        social_security_member_ship_kind varchar(255),
        social_security_number varchar(13),
        social_service_address_id int8,
        social_service_name varchar(60),
        social_service_support bool,
        studies_assistance_under_disability bool,
        studies_assistance_under_disability_details varchar(60),
        studies_high_school bool,
        studies_high_school_address_id int8,
        studies_high_school_grade varchar(60),
        studies_high_school_name varchar(60),
        subject_birth_city varchar(32),
        subject_birth_country varchar(50),
        subject_birth_date timestamp,
        subject_parental_authority_holder varchar(255),
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

    create table holiday_security_request (
        id int8 not null,
        absence_end_date timestamp,
        absence_start_date timestamp,
        alarm bool,
        alert_phone varchar(10),
        light bool,
        other_contact bool,
        other_contact_address_id int8,
        other_contact_first_name varchar(38),
        other_contact_last_name varchar(38),
        other_contact_phone varchar(10),
        rules_and_regulations_acceptance bool,
        primary key (id)
    );

    create table home_emergency_registration_request (
        id int8 not null,
        date_depart timestamp,
        duree varchar(2),
        telephone varchar(10),
        primary key (id)
    );

    create table home_folder (
        id int8 not null,
        state varchar(16) not null,
        address_id int8,
        enabled bool,
        is_temporary bool,
        family_quotient varchar(255),
        primary key (id)
    );

    create table home_folder_mapping (
        id int8 not null,
        external_service_label varchar(255),
        home_folder_id int8,
        external_capdemat_id varchar(255),
        external_id varchar(255),
        primary key (id)
    );

    create table home_folder_modification_request (
        id int8 not null,
        primary key (id)
    );

    create table individual (
        id int8 not null,
        federation_key varchar(64) unique,
        last_name varchar(38),
        first_name varchar(38),
        first_name_2 varchar(38),
        first_name_3 varchar(38),
        birth_date timestamp,
        birth_country varchar(255),
        birth_city varchar(32),
        birth_postal_code varchar(5),
        creation_date timestamp,
        last_modification_date timestamp,
        state varchar(16) not null,
        address_id int8,
        home_folder_id int8,
        q_o_s varchar(16),
        home_folder_index int4,
        primary key (id)
    );

    create table individual_mapping (
        id int8 not null,
        individual_id int8,
        external_capdemat_id varchar(255),
        external_id varchar(255),
        home_folder_mapping_id int8,
        home_folder_mapping_index int4,
        primary key (id)
    );

    create table individual_role (
        id int8 not null,
        role varchar(255),
        home_folder_id int8,
        individual_id int8,
        individual_name varchar(255),
        owner_id int8,
        primary key (id)
    );

    create table learning_activities_discovery_registration_request (
        id int8 not null,
        primary key (id)
    );

    create table learning_activities_discovery_registration_request_atelier_eveil (
        learning_activities_discovery_registration_request_id int8 not null,
        atelier_eveil_id int8 not null,
        atelier_eveil_index int4 not null,
        primary key (learning_activities_discovery_registration_request_id, atelier_eveil_index)
    );

    create table library_registration_request (
        id int8 not null,
        parental_authorization bool,
        registration_number varchar(255),
        rules_and_regulations_acceptance bool,
        subscription_price numeric(19, 2),
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
        document_digitalization_enabled bool not null,
        token varchar(255),
        admin_email varchar(255),
        payment_deactivation_start_date timestamp,
        payment_deactivation_end_date timestamp,
        display_in_progress_payments bool not null,
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
        comment varchar(255),
        copies bytea,
        father_first_names varchar(255),
        father_last_name varchar(38),
        format varchar(255),
        marriage_city varchar(32),
        marriage_date timestamp,
        marriage_husband_first_names varchar(255),
        marriage_husband_last_name varchar(38),
        marriage_postal_code varchar(2),
        marriage_wife_first_names varchar(255),
        marriage_wife_last_name varchar(38),
        mother_first_names varchar(255),
        mother_maiden_name varchar(38),
        motive varchar(255),
        relationship varchar(255),
        requester_quality varchar(255),
        requester_quality_precision varchar(255),
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
        affection_or_disease bool,
        alive_children bytea,
        child_birth_country varchar(255),
        child_convention varchar(255),
        child_country varchar(255),
        child_diploma varchar(255),
        child_mail varchar(255),
        child_other_country varchar(255),
        child_phone varchar(10),
        child_profession varchar(255),
        child_residence_country varchar(255),
        child_situation varchar(255),
        child_speciality varchar(255),
        child_status varchar(255),
        child_title varchar(255),
        children_in_charge bytea,
        father_birth_city varchar(255),
        father_birth_country varchar(255),
        father_birth_date timestamp,
        father_birth_department varchar(255),
        father_first_name varchar(38),
        father_last_name varchar(38),
        father_nationality varchar(255),
        highly_infirm bool,
        japd_exemption bool,
        maiden_name varchar(38),
        mother_birth_city varchar(255),
        mother_birth_country varchar(255),
        mother_birth_date timestamp,
        mother_birth_department varchar(255),
        mother_first_name varchar(38),
        mother_last_name varchar(38),
        mother_nationality varchar(255),
        other_situation varchar(255),
        prefect_pupil bool,
        prefect_pupil_department varchar(255),
        state_pupil bool,
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
        requester_last_name varchar(38) not null,
        requester_first_name varchar(38) not null,
        payment_mode varchar(10),
        commit_alert bool,
        primary key (id)
    );

    create table perischool_activity_registration_request (
        id int8 not null,
        child_photo_exploitation_permission bool,
        class_trip_permission bool,
        hospitalization_permission bool,
        rules_and_regulations_acceptance bool,
        school_id int8,
        section varchar(32),
        urgency_phone varchar(10),
        primary key (id)
    );

    create table perischool_activity_registration_request_perischool_activity (
        perischool_activity_registration_request_id int8 not null,
        perischool_activity_id int8 not null,
        perischool_activity_index int4 not null,
        primary key (perischool_activity_registration_request_id, perischool_activity_index)
    );

    create table perischool_authorized_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        perischool_activity_registration_request_id int8,
        authorized_individuals_index int4,
        primary key (id)
    );

    create table perischool_contact_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        perischool_activity_registration_request_id int8,
        contact_individuals_index int4,
        primary key (id)
    );

    create table purchase_item (
        id int8 not null,
        item_type varchar(64) not null,
        label varchar(255),
        amount float8,
        supported_broker varchar(255),
        external_item_id varchar(255),
        external_service_label varchar(255),
        external_application_id varchar(255),
        external_home_folder_id varchar(255),
        external_individual_id varchar(255),
        old_value float8,
        old_value_date timestamp,
        issue_date timestamp,
        is_paid bool,
        expiration_date timestamp,
        payment_date timestamp,
        creation_date timestamp,
        max_buy int4,
        min_buy int4,
        quantity int4,
        subject_id int8,
        unit_price float8,
        old_quantity int4,
        key varchar(255),
        key_owner varchar(255),
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
        child_photo_exploitation_permission bool,
        class_trip_permission bool,
        hospitalization_permission bool,
        recreation_center_id int8,
        rules_and_regulations_acceptance bool,
        urgency_phone varchar(10),
        primary key (id)
    );

    create table recreation_activity_registration_request_recreation_activity (
        recreation_activity_registration_request_id int8 not null,
        recreation_activity_id int8 not null,
        recreation_activity_index int4 not null,
        primary key (recreation_activity_registration_request_id, recreation_activity_index)
    );

    create table recreation_authorized_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        recreation_activity_registration_request_id int8,
        authorized_individuals_index int4,
        primary key (id)
    );

    create table recreation_center (
        id int8 not null,
        name varchar(255) not null,
        address varchar(255),
        active bool,
        primary key (id)
    );

    create table recreation_contact_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        recreation_activity_registration_request_id int8,
        contact_individuals_index int4,
        primary key (id)
    );

    create table remote_support_request (
        id int8 not null,
        contact_first_name varchar(38),
        contact_kind varchar(255),
        contact_last_name varchar(38),
        contact_phone varchar(10),
        request_information_emergency bool,
        request_information_emergency_motive varchar(180),
        request_information_request_kind varchar(255),
        second_contact_first_name varchar(38),
        second_contact_last_name varchar(38),
        second_contact_phone varchar(10),
        spouse_birth_date timestamp,
        spouse_first_name varchar(38),
        spouse_is_disabled_person bool,
        spouse_last_name varchar(38),
        spouse_title varchar(255),
        subject_birth_date timestamp,
        subject_is_a_p_a_beneficiary bool,
        subject_is_disabled_person bool,
        subject_is_taxable bool,
        subject_reside_with varchar(255),
        subject_title varchar(255),
        trustee_first_name varchar(38),
        trustee_last_name varchar(38),
        trustee_phone varchar(10),
        primary key (id)
    );

    create table request (
        id int8 not null,
        home_folder_id int8,
        creation_date timestamp,
        last_modification_date timestamp,
        last_intervening_user_id int8,
        state varchar(16) not null,
        data_state varchar(16) not null,
        means_of_contact_id int8,
        request_step varchar(16),
        requester_id int8,
        requester_last_name varchar(255),
        requester_first_name varchar(255),
        request_type_id int8,
        request_season_id int8,
        orange_alert bool,
        red_alert bool,
        validation_date timestamp,
        subject_id int8,
        subject_last_name varchar(255),
        subject_first_name varchar(255),
        step_states bytea,
        specific_data_class varchar(255),
        specific_data_id int8,
        documents_archive bytea,
        primary key (id)
    );

    create table request_action (
        id int8 not null,
        agent_id int8,
        note varchar(1024),
        date timestamp,
        resulting_state varchar(16),
        message varchar(1024),
        filename varchar(255),
        file bytea,
        type varchar(255),
        request_id int8,
        primary key (id)
    );

    create table request_admin_action (
        id int8 not null,
        type varchar(255) not null,
        admin_id int8 not null,
        date timestamp not null,
        primary key (id)
    );

    create table request_admin_action_complementary_data (
        id int8 not null,
        value bytea,
        key varchar(255) not null,
        primary key (id, key)
    );

    create table request_document (
        id int8 not null,
        document_id int8,
        request_id int8,
        primary key (id)
    );

    create table request_external_action (
        id int8 not null,
        date timestamp,
        key varchar(255),
        key_owner varchar(255),
        message varchar(255),
        name varchar(255),
        status varchar(255),
        primary key (id)
    );

    create table request_external_action_complementary_data (
        id int8 not null,
        value bytea,
        key varchar(255) not null,
        primary key (id, key)
    );

    create table request_form (
        id int8 not null,
        type varchar(255) not null,
        label varchar(255),
        short_label varchar(255),
        personalized_data bytea,
        template_name varchar(255),
        primary key (id)
    );

    create table request_lock (
        id int8 not null,
        request_id int8 not null,
        user_id int8 not null,
        date timestamp not null,
        primary key (id)
    );

    create table request_note (
        id int8 not null,
        user_id int8,
        type varchar(32),
        note varchar(1024),
        date timestamp,
        request_id int8,
        primary key (id)
    );

    create table request_season (
        id int8 not null,
        request_type_id int8 not null,
        effect_end timestamp not null,
        effect_start timestamp not null,
        label varchar(255) not null,
        registration_end timestamp not null,
        registration_start timestamp not null,
        validation_authorization_start timestamp,
        primary key (id)
    );

    create table request_type (
        id int8 not null,
        label varchar(255),
        active bool,
        category_id int8,
        display_group_id int8,
        authorize_multiple_registrations_per_season bool,
        instruction_alert_delay int4,
        instruction_max_delay int4,
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
        address varchar(255),
        active bool,
        primary key (id)
    );

    create table school_canteen_registration_request (
        id int8 not null,
        doctor_name varchar(255),
        doctor_phone varchar(10),
        food_allergy bool,
        hospitalization_permission bool,
        rules_and_regulations_acceptance bool,
        school_id int8,
        section varchar(32),
        urgency_phone varchar(10),
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
        rules_and_regulations_acceptance bool,
        school_id int8,
        section varchar(32),
        urgency_phone varchar(10),
        primary key (id)
    );

    create table sewer_connection_request (
        id int8 not null,
        locality varchar(255),
        more_than_two_years bool,
        number bytea,
        owner_address_id int8,
        owner_first_names varchar(255),
        owner_last_name varchar(38),
        requester_quality varchar(255),
        section varchar(255),
        transportation_route varchar(255),
        primary key (id)
    );

    create table sms_notification_request (
        id int8 not null,
        clever_sms_contact_id varchar(255),
        mobile_phone varchar(10),
        subscription bool,
        primary key (id)
    );

    create table sms_notification_request_interests (
        sms_notification_request_id int8 not null,
        interests_id int8 not null,
        interests_index int4 not null,
        primary key (sms_notification_request_id, interests_index)
    );

    create table study_grant_request (
        id int8 not null,
        abroad_internship bool,
        abroad_internship_end_date timestamp,
        abroad_internship_school_country varchar(255),
        abroad_internship_school_name varchar(255),
        abroad_internship_start_date timestamp,
        account_holder_birth_date timestamp,
        account_holder_edemande_id varchar(255),
        account_holder_first_name varchar(38),
        account_holder_last_name varchar(38),
        account_holder_title varchar(255),
        alevels varchar(255),
        alevels_date varchar(4),
        current_school_city varchar(32),
        current_school_country varchar(255),
        current_school_name_precision varchar(255),
        current_school_postal_code varchar(5),
        current_studies_diploma varchar(255),
        current_studies_level varchar(255),
        distance varchar(255),
        edemande_id varchar(255),
        french_r_i_b_id int8,
        has_c_r_o_u_s_help bool,
        has_europe_help bool,
        has_other_help bool,
        has_regional_council_help bool,
        is_subject_account_holder bool,
        other_studies_label varchar(255),
        sandwich_courses bool,
        subject_birth_date timestamp,
        subject_first_request bool,
        tax_household_city_precision varchar(255),
        tax_household_first_name varchar(38),
        tax_household_income float8,
        tax_household_last_name varchar(38),
        primary key (id)
    );

    create table study_grant_request_current_school_name (
        study_grant_request_id int8 not null,
        current_school_name_id int8 not null,
        current_school_name_index int4 not null,
        primary key (study_grant_request_id, current_school_name_index)
    );

    create table study_grant_request_tax_household_city (
        study_grant_request_id int8 not null,
        tax_household_city_id int8 not null,
        tax_household_city_index int4 not null,
        primary key (study_grant_request_id, tax_household_city_index)
    );

    create table tbr_ticket (
        id int8 not null,
        event_name varchar(255),
        event_place varchar(255),
        place_category_id int8,
        place_number bytea,
        price numeric(19, 2),
        fare_type varchar(255),
        place_category varchar(255),
        event_date timestamp,
        ticket_booking_request_id int8,
        tbr_ticket_index int4,
        primary key (id)
    );

    create table technical_intervention_request (
        id int8 not null,
        intervention_description varchar(255),
        intervention_place_id int8,
        other_intervention_label varchar(255),
        primary key (id)
    );

    create table technical_intervention_request_intervention_type (
        technical_intervention_request_id int8 not null,
        intervention_type_id int8 not null,
        intervention_type_index int4 not null,
        primary key (technical_intervention_request_id, intervention_type_index)
    );

    create table ticket_booking_request (
        id int8 not null,
        rules_and_regulations_acceptance bool,
        subscriber_last_name varchar(255),
        total_price numeric(19, 2),
        subscriber_number varchar(255),
        subscriber_first_name varchar(255),
        is_subscriber bool,
        payment_reference varchar(255),
        primary key (id)
    );

    create table ticket_entertainment (
        id int8 not null,
        external_id varchar(255),
        information varchar(255),
        name varchar(255),
        link varchar(255),
        category varchar(255),
        logo bytea,
        primary key (id)
    );

    create table ticket_event (
        id int8 not null,
        external_id varchar(255),
        date timestamp,
        booking_start timestamp,
        booking_end timestamp,
        place varchar(255),
        link varchar(255),
        address varchar(255),
        ticket_entertainment_id int8 not null,
        primary key (id)
    );

    create table ticket_fare (
        id int8 not null,
        external_id varchar(255),
        name varchar(255),
        price float4,
        with_subscriber bool,
        ticket_place_category_id int8,
        fares_index int4,
        primary key (id)
    );

    create table ticket_place_category (
        id int8 not null,
        external_id varchar(255),
        name varchar(255),
        place_number int4,
        booked_place_number int4,
        ticket_event_id int8,
        place_categories_index int4,
        primary key (id)
    );

    create table ticket_subscriber (
        id int8 not null,
        number varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    );

    create table ticket_subscriber_limits (
        id int8 not null,
        value int4,
        key varchar(255) not null,
        primary key (id, key)
    );

    create table user_action (
        id int8 not null,
        date timestamp not null,
        user_id int8 not null,
        target_id int8 not null,
        type varchar(255) not null,
        note varchar(255),
        data text,
        home_folder_id int8,
        home_folder_index int4,
        primary key (id)
    );

    create table user_external_action (
        id int8 not null,
        date timestamp not null,
        key varchar(255) not null,
        key_owner varchar(255) not null,
        label varchar(255) not null,
        status varchar(255) not null,
        message varchar(255),
        primary key (id)
    );

    create table user_security_rule (
        id int8 not null,
        agent_id int8,
        profile varchar(16),
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
        add constraint FKBAFB98B63ED1C7EB 
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

    alter table alignment_numbering_connection_request 
        add constraint FKEBD131101F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table alignment_numbering_connection_request 
        add constraint FKEBD13110C6C3DEB1 
        foreign key (other_address_id) 
        references address;

    alter table bafa_grant_request 
        add constraint FK50AFA827681FBDDD 
        foreign key (internship_institute_address_id) 
        references address;

    alter table bafa_grant_request 
        add constraint FK50AFA82787B85F15 
        foreign key (subject_address_id) 
        references address;

    alter table bafa_grant_request 
        add constraint FK50AFA8271EE1CD99 
        foreign key (french_r_i_b_id) 
        references french_r_i_b;

    alter table bulky_waste_collection_request 
        add constraint FK1F104ECB1AE70A63 
        foreign key (collection_address_id) 
        references address;

    alter table bulky_waste_collection_request_bulky_waste_type 
        add constraint FK7E2C4DCB94784C0B 
        foreign key (bulky_waste_collection_request_id) 
        references bulky_waste_collection_request;

    alter table bulky_waste_collection_request_bulky_waste_type 
        add constraint FK7E2C4DCB4C319B5C 
        foreign key (bulky_waste_type_id) 
        references local_referential_data;

    alter table category_emails 
        add constraint FKB9136EB83ED1C7EB 
        foreign key (category_id) 
        references category;

    alter table child 
        add constraint FK5A3F51C71A211CC 
        foreign key (id) 
        references individual;

    alter table compostable_waste_collection_request 
        add constraint FKAFF728771AE70A63 
        foreign key (collection_address_id) 
        references address;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424B75921530 
        foreign key (compostable_waste_type_id) 
        references local_referential_data;

    alter table compostable_waste_collection_request_compostable_waste_type 
        add constraint FK765E424B28FD5FB3 
        foreign key (compostable_waste_collection_request_id) 
        references compostable_waste_collection_request;

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
        add constraint FK2BA9F1EC742C3FB2 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E274AF76B3A 
        foreign key (dhr_previous_dwelling_address_id) 
        references address;

    alter table dhr_previous_dwelling 
        add constraint FKB0B96E27742C3FB2 
        foreign key (domestic_help_request_id) 
        references domestic_help_request;

    alter table dhr_real_asset 
        add constraint FK6AA7D9809D2A9E41 
        foreign key (dhr_real_asset_address_id) 
        references address;

    alter table dhr_real_asset 
        add constraint FK6AA7D980742C3FB2 
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
        add constraint FK45625529F0159453 
        foreign key (subject_address_outside_city_id) 
        references address;

    alter table external_application_broker 
        add constraint FK839CD69C2C94FF5A 
        foreign key (external_application_id) 
        references external_application;

    alter table external_deposit_account_item_detail 
        add constraint FK4A90965670F56907 
        foreign key (external_deposit_account_item_id) 
        references purchase_item;

    alter table external_home_folder 
        add constraint FKA9D7255A2C94FF5A 
        foreign key (external_application_id) 
        references external_application;

    alter table external_individual 
        add constraint FKC1D4D78DF1C1B621 
        foreign key (external_home_folder_id) 
        references external_home_folder;

    alter table external_invoice_item_detail 
        add constraint FKFB8FF2772062B3BC 
        foreign key (external_invoice_item_id) 
        references purchase_item;

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
        add constraint FK73D0EACC2F7F7877 
        foreign key (professional_status_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2AF072D5 
        foreign key (dwelling_social_reception_address_id) 
        references address;

    alter table handicap_compensation_adult_request 
        add constraint FK73D0EACC2633BF01 
        foreign key (dwelling_reception_address_id) 
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
        add constraint FK309E3C2EE215BDD5 
        foreign key (schooling_home_schooling_accompanist_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2F7F7877 
        foreign key (professional_status_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E356CE3FE 
        foreign key (social_service_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2AF072D5 
        foreign key (dwelling_social_reception_address_id) 
        references address;

    alter table handicap_compensation_child_request 
        add constraint FK309E3C2E2633BF01 
        foreign key (dwelling_reception_address_id) 
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
        add constraint FKB357C9A17010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_care_service 
        add constraint FKD2D3BA7A7AB5BC78 
        foreign key (care_service_provider_address_id) 
        references address;

    alter table hcar_care_service 
        add constraint FKD2D3BA7A7010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_family_assistance_member 
        add constraint FKF63BE3D97010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_family_dependent 
        add constraint FK6E4B5577010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_home_intervenant 
        add constraint FK6294A7D77010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_other_benefit 
        add constraint FKA530B5D57010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_other_folder 
        add constraint FK4681FB707010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hcar_professional 
        add constraint FK581A111AEB2A3B3A 
        foreign key (professional_address_id) 
        references address;

    alter table hcar_professional 
        add constraint FK581A111A7010720F 
        foreign key (handicap_compensation_adult_request_id) 
        references handicap_compensation_adult_request;

    alter table hccr_additional_fee 
        add constraint FK54AB85A3A233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_care_service 
        add constraint FK868A8EFCA233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_care_service 
        add constraint FK868A8EFC7AB5BC78 
        foreign key (care_service_provider_address_id) 
        references address;

    alter table hccr_family_assistance_member 
        add constraint FK68DE055BA233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_family_dependent 
        add constraint FKA23978D9A233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_home_intervenant 
        add constraint FKFDE96B59A233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_other_benefit 
        add constraint FK68547193A233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_other_folder 
        add constraint FKFA38CFF2A233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_professional 
        add constraint FKBD0E59CA233A8CB 
        foreign key (handicap_compensation_child_request_id) 
        references handicap_compensation_child_request;

    alter table hccr_professional 
        add constraint FKBD0E59CEB2A3B3A 
        foreign key (professional_address_id) 
        references address;

    alter table holiday_security_request 
        add constraint FKED34C597E2AF3D30 
        foreign key (other_contact_address_id) 
        references address;

    alter table home_folder 
        add constraint FKDB87BBCEB7531222 
        foreign key (address_id) 
        references address;

    alter table individual 
        add constraint FKFD3DA299B7531222 
        foreign key (address_id) 
        references address;

    alter table individual 
        add constraint FKFD3DA2998BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    alter table individual_mapping 
        add constraint FK19DDB92881C62393 
        foreign key (home_folder_mapping_id) 
        references home_folder_mapping;

    alter table individual_role 
        add constraint FK3C7D4E5CD4C3A2D8 
        foreign key (owner_id) 
        references individual;

    alter table learning_activities_discovery_registration_request_atelier_eveil 
        add constraint FK6631159E51ABD2B5 
        foreign key (learning_activities_discovery_registration_request_id) 
        references learning_activities_discovery_registration_request;

    alter table learning_activities_discovery_registration_request_atelier_eveil 
        add constraint FK6631159E9AA8EC9F 
        foreign key (atelier_eveil_id) 
        references local_referential_data;

    alter table library_registration_request_subscription 
        add constraint FK56C4BE0FD7ED8C0C 
        foreign key (library_registration_request_id) 
        references library_registration_request;

    alter table library_registration_request_subscription 
        add constraint FK56C4BE0F97237F56 
        foreign key (subscription_id) 
        references local_referential_data;

    alter table local_referential_association 
        add constraint FK6B28F677E6775FC 
        foreign key (local_referential_child_data_id) 
        references local_referential_data;

    alter table local_referential_association 
        add constraint FK6B28F6778F4CC15E 
        foreign key (local_referential_parent_data_id) 
        references local_referential_data;

    alter table local_referential_data 
        add constraint FK49407E748F4CC15E 
        foreign key (local_referential_parent_data_id) 
        references local_referential_data;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD4B4094824 
        foreign key (activity_id) 
        references local_referential_data;

    alter table music_school_registration_request_activity 
        add constraint FK6393FFD48F0273CA 
        foreign key (music_school_registration_request_id) 
        references music_school_registration_request;

    alter table perischool_activity_registration_request 
        add constraint FK76BAA59A20540B7 
        foreign key (school_id) 
        references school;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E93D77B468 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_activity_registration_request_perischool_activity 
        add constraint FK2007A4E989D383C5 
        foreign key (perischool_activity_id) 
        references local_referential_data;

    alter table perischool_authorized_individual 
        add constraint FKEE33EA1E3D77B468 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_authorized_individual 
        add constraint FKEE33EA1EB7531222 
        foreign key (address_id) 
        references address;

    alter table perischool_contact_individual 
        add constraint FK5B659D573D77B468 
        foreign key (perischool_activity_registration_request_id) 
        references perischool_activity_registration_request;

    alter table perischool_contact_individual 
        add constraint FK5B659D57B7531222 
        foreign key (address_id) 
        references address;

    alter table purchase_item 
        add constraint FKB1132791A8364360 
        foreign key (payment_id) 
        references payment;

    alter table purchase_item_specific_data 
        add constraint FK455E9669669F9D96 
        foreign key (id) 
        references purchase_item;

    alter table recreation_activity_registration_request 
        add constraint FKD1F8ECCF8EE79C 
        foreign key (recreation_center_id) 
        references recreation_center;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA932CAB577 
        foreign key (recreation_activity_id) 
        references local_referential_data;

    alter table recreation_activity_registration_request_recreation_activity 
        add constraint FK54117CA9FCCD2304 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table recreation_authorized_individual 
        add constraint FK5BA62550B7531222 
        foreign key (address_id) 
        references address;

    alter table recreation_authorized_individual 
        add constraint FK5BA62550FCCD2304 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table recreation_contact_individual 
        add constraint FK52B67F65B7531222 
        foreign key (address_id) 
        references address;

    alter table recreation_contact_individual 
        add constraint FK52B67F65FCCD2304 
        foreign key (recreation_activity_registration_request_id) 
        references recreation_activity_registration_request;

    alter table request 
        add constraint FK414EF28F85577048 
        foreign key (request_season_id) 
        references request_season;

    alter table request 
        add constraint FK414EF28FC5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table request 
        add constraint FK414EF28F3FFD6284 
        foreign key (means_of_contact_id) 
        references means_of_contact;

    alter table request_action 
        add constraint FK7AC459E6D7FE2713 
        foreign key (request_id) 
        references request;

    alter table request_admin_action_complementary_data 
        add constraint FK783DC15070D87F22 
        foreign key (id) 
        references request_admin_action;

    alter table request_document 
        add constraint FK712980CBD7FE2713 
        foreign key (request_id) 
        references request;

    alter table request_external_action_complementary_data 
        add constraint FKB088082C294C4979 
        foreign key (id) 
        references request_external_action;

    alter table request_note 
        add constraint FK4DABB7A2D7FE2713 
        foreign key (request_id) 
        references request;

    alter table request_season 
        add constraint FK998F4693C5FD0068 
        foreign key (request_type_id) 
        references request_type;

    alter table request_type 
        add constraint FK4DAE96EA3ED1C7EB 
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
        add constraint FKDC4CBC6920540B7 
        foreign key (school_id) 
        references school;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F9B44A8D50 
        foreign key (canteen_attending_days_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_canteen_attending_days 
        add constraint FK1323D9F97C526984 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADF50ABBE3E 
        foreign key (food_diet_id) 
        references local_referential_data;

    alter table school_canteen_registration_request_food_diet 
        add constraint FK5768CADF7C526984 
        foreign key (school_canteen_registration_request_id) 
        references school_canteen_registration_request;

    alter table school_registration_request 
        add constraint FK7BDFE8F420540B7 
        foreign key (school_id) 
        references school;

    alter table sewer_connection_request 
        add constraint FK50B057BB1F88D72E 
        foreign key (owner_address_id) 
        references address;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B290F926A 
        foreign key (interests_id) 
        references local_referential_data;

    alter table sms_notification_request_interests 
        add constraint FKCE60DA2B10A7E028 
        foreign key (sms_notification_request_id) 
        references sms_notification_request;

    alter table study_grant_request 
        add constraint FK7D2F0A761EE1CD99 
        foreign key (french_r_i_b_id) 
        references french_r_i_b;

    alter table study_grant_request_current_school_name 
        add constraint FK49484F6719BB0CC1 
        foreign key (study_grant_request_id) 
        references study_grant_request;

    alter table study_grant_request_current_school_name 
        add constraint FK49484F671E1FCE3 
        foreign key (current_school_name_id) 
        references local_referential_data;

    alter table study_grant_request_tax_household_city 
        add constraint FK1B56894857A06C54 
        foreign key (tax_household_city_id) 
        references local_referential_data;

    alter table study_grant_request_tax_household_city 
        add constraint FK1B56894819BB0CC1 
        foreign key (study_grant_request_id) 
        references study_grant_request;

    alter table tbr_ticket 
        add constraint FK231823E7CFCF80C3 
        foreign key (ticket_booking_request_id) 
        references ticket_booking_request;

    alter table technical_intervention_request 
        add constraint FKC051B8C974526C97 
        foreign key (intervention_place_id) 
        references address;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79AC309376B1 
        foreign key (intervention_type_id) 
        references local_referential_data;

    alter table technical_intervention_request_intervention_type 
        add constraint FK5ADF79AC43EECED8 
        foreign key (technical_intervention_request_id) 
        references technical_intervention_request;

    alter table ticket_event 
        add constraint FK9B59C7A7E386AF5C 
        foreign key (ticket_entertainment_id) 
        references ticket_entertainment;

    alter table ticket_fare 
        add constraint FK15872D81914D9745 
        foreign key (ticket_place_category_id) 
        references ticket_place_category;

    alter table ticket_place_category 
        add constraint FK228856C92803C01C 
        foreign key (ticket_event_id) 
        references ticket_event;

    alter table ticket_subscriber_limits 
        add constraint FK2A415CAF42EA14 
        foreign key (id) 
        references ticket_subscriber;

    alter table user_action 
        add constraint FKD768C52A8BD77771 
        foreign key (home_folder_id) 
        references home_folder;

    create sequence hibernate_sequence;
