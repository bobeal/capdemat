-- LocalAuthoriy model refactoring  script

ALTER TABLE recreation_center DROP COLUMN local_authority_id ;
ALTER TABLE school DROP COLUMN local_authority_id ;
ALTER TABLE agent_site_roles DROP COLUMN local_authority_id ;
ALTER TABLE category DROP COLUMN local_authority_id ;
ALTER TABLE home_folder DROP COLUMN local_authority_id ;
ALTER TABLE request_type DROP COLUMN xml_config_file;


-- Hibernate 3 migration  script

ALTER TABLE history_entry ALTER COLUMN old_value TYPE varchar(1024);
ALTER TABLE history_entry ALTER COLUMN new_value TYPE varchar(1024);

ALTER TABLE request_action DROP CONSTRAINT FK7AC459E623640CB;
ALTER TABLE birth_details_request DROP CONSTRAINT FKB3569612D1B;
ALTER TABLE vacations_registration_request DROP CONSTRAINT FK92F4987241C46F58;
ALTER TABLE vacations_registration_request DROP CONSTRAINT FK92F49872D1B;
ALTER TABLE vacations_registration_request DROP CONSTRAINT FK92F4987262EA171E;
ALTER TABLE individual DROP CONSTRAINT FKFD3DA29921045CAA;
ALTER TABLE individual DROP CONSTRAINT FKFD3DA29934DB784;
ALTER TABLE individual DROP CONSTRAINT FKFD3DA299F8797B2C;
ALTER TABLE school_canteen_registration_request_canteen_attending_days DROP CONSTRAINT FK1323D9F985DAF0B1;
ALTER TABLE school_canteen_registration_request_canteen_attending_days DROP CONSTRAINT FK1323D9F9C994B577;
ALTER TABLE dhr_personal_estate_and_saving DROP CONSTRAINT FK5EFB37677EAD7F68;
ALTER TABLE library_registration_request DROP CONSTRAINT FKEA37820DD1B;
ALTER TABLE recreation_activity_registration_request DROP CONSTRAINT FKD1F8ECC41C46F58;
ALTER TABLE recreation_activity_registration_request DROP CONSTRAINT FKD1F8ECCD1B;
ALTER TABLE music_school_registration_request DROP CONSTRAINT FK51A399DAD1B;
ALTER TABLE domestic_help_request DROP CONSTRAINT FK3C00811289821EF;
ALTER TABLE domestic_help_request DROP CONSTRAINT FK3C0081123B4E61AF;
ALTER TABLE domestic_help_request DROP CONSTRAINT FK3C0081124E875BF8;
ALTER TABLE domestic_help_request DROP CONSTRAINT FK3C008112D1B;
ALTER TABLE domestic_help_request DROP CONSTRAINT FK3C0081124C56A0A0;
ALTER TABLE death_details_request DROP CONSTRAINT FK85B0A9C7D1B;
ALTER TABLE handicap_allowance_request DROP CONSTRAINT FKF20630A1D1B;
ALTER TABLE handicap_allowance_request DROP CONSTRAINT FKF20630A15C37F22;
ALTER TABLE perischool_activity_registration_request_other_individual DROP CONSTRAINT FKD6BDD32DBF1AD192;
ALTER TABLE perischool_activity_registration_request_other_individual DROP CONSTRAINT FKD6BDD32DA24EADE0;
ALTER TABLE child_legal_responsible_map DROP CONSTRAINT FK62E1102A62EA171E;
ALTER TABLE child_legal_responsible_map DROP CONSTRAINT FK62E1102AF806614A;
ALTER TABLE home_folder DROP CONSTRAINT FKDB87BBCE34DB784;
ALTER TABLE forms DROP CONSTRAINT FK5D18C2FFAA598C6;
ALTER TABLE forms DROP CONSTRAINT FK5D18C2FF02D7A90;
ALTER TABLE request_means_of_contact DROP CONSTRAINT FK72CB44F98FCF3BD1;
ALTER TABLE request_means_of_contact DROP CONSTRAINT FK72CB44F923640CB;
ALTER TABLE library_registration_request_subscription DROP CONSTRAINT FK56C4BE0F1188988D;
ALTER TABLE library_registration_request_subscription DROP CONSTRAINT FK56C4BE0FAC6DA77D;
ALTER TABLE alignment_certificate_request DROP CONSTRAINT FK9EBFB38BD1B;
ALTER TABLE alignment_certificate_request DROP CONSTRAINT FK9EBFB38BB824A652;
ALTER TABLE electoral_roll_registration_request DROP CONSTRAINT FK45625529D1B;
ALTER TABLE electoral_roll_registration_request DROP CONSTRAINT FK4562552988B16377;
ALTER TABLE child DROP CONSTRAINT FK5A3F51CD1B;
ALTER TABLE vacations_diary DROP CONSTRAINT FK2890BF7A5DD9AC08;
ALTER TABLE perischool_activity_registration_request DROP CONSTRAINT FK76BAA59A812F1C6;
ALTER TABLE perischool_activity_registration_request DROP CONSTRAINT FK76BAA59AD1B;
ALTER TABLE request_type DROP CONSTRAINT FK4DAE96EA5BA8ABFC;
ALTER TABLE request_note DROP CONSTRAINT FK4DABB7A223640CB;
ALTER TABLE remote_support_request DROP CONSTRAINT FKEAA6DC26D1B;
ALTER TABLE place_reservation_request_place_reservation DROP CONSTRAINT FK9493CEF9E9A90956;
ALTER TABLE place_reservation_request_place_reservation DROP CONSTRAINT FK9493CEF92E7D90A6;
ALTER TABLE local_referential_data DROP CONSTRAINT FK49407E74A496E985;
ALTER TABLE purchase_item DROP CONSTRAINT FKB113279123640CB;
ALTER TABLE purchase_item DROP CONSTRAINT FKB11327916022B9F4;
ALTER TABLE seasons DROP CONSTRAINT FK7552F1F0F02D7A90;
ALTER TABLE recreation_activity_registration_request_recreation_activity DROP CONSTRAINT FK54117CA92B6BDF6E;
ALTER TABLE recreation_activity_registration_request_recreation_activity DROP CONSTRAINT FK54117CA94814DD9E;
ALTER TABLE personal_details_request DROP CONSTRAINT FKDA412593D1B;
ALTER TABLE agent_category_roles DROP CONSTRAINT FKBAFB98B65BA8ABFC;
ALTER TABLE agent_category_roles DROP CONSTRAINT FKBAFB98B657919495;
ALTER TABLE music_school_registration_request_activity DROP CONSTRAINT FK6393FFD46D6E51A0;
ALTER TABLE music_school_registration_request_activity DROP CONSTRAINT FK6393FFD4C953704B;
ALTER TABLE ticket_type_selection DROP CONSTRAINT FK3B70C45A25B36525;
ALTER TABLE document_action DROP CONSTRAINT FKA42545DA1E3346BF;
ALTER TABLE document_binary DROP CONSTRAINT FKA62BD3A51E3346BF;
ALTER TABLE perischool_activity_registration_request_perischool_activity DROP CONSTRAINT FK2007A4E99F1DABEC;
ALTER TABLE perischool_activity_registration_request_perischool_activity DROP CONSTRAINT FK2007A4E9A24EADE0;
ALTER TABLE local_referential_association DROP CONSTRAINT FK6B28F677A496E985;
ALTER TABLE local_referential_association DROP CONSTRAINT FK6B28F67723B19E23;
ALTER TABLE school_canteen_registration_request DROP CONSTRAINT FKDC4CBC69812F1C6;
ALTER TABLE school_canteen_registration_request DROP CONSTRAINT FKDC4CBC69D1B;
ALTER TABLE document DROP CONSTRAINT FK335CD11BF2EA0D1C;
ALTER TABLE document DROP CONSTRAINT FK335CD11BE78E1C81;
ALTER TABLE document DROP CONSTRAINT FK335CD11BF8797B2C;
ALTER TABLE category_emails DROP CONSTRAINT FKB9136EB85BA8ABFC;
ALTER TABLE dhr_previous_dwelling DROP CONSTRAINT FKB0B96E277EAD7F68;
ALTER TABLE dhr_previous_dwelling DROP CONSTRAINT FKB0B96E27909EB42D;
ALTER TABLE dhr_real_asset DROP CONSTRAINT FK6AA7D9807EAD7F68;
ALTER TABLE dhr_real_asset DROP CONSTRAINT FK6AA7D9803C8FCE76;
ALTER TABLE dhr_donation DROP CONSTRAINT FK917250437CF5D9A3;
ALTER TABLE dhr_donation DROP CONSTRAINT FK917250437EAD7F68;
ALTER TABLE adult DROP CONSTRAINT FK58621BAD1B;
ALTER TABLE home_folder_modification_request DROP CONSTRAINT FK26ED7ABDD1B;
ALTER TABLE request_document_map DROP CONSTRAINT FKCBC2F7E823640CB;
ALTER TABLE request_document_map DROP CONSTRAINT FKCBC2F7E81E3346BF;
ALTER TABLE purchase_item_specific_data DROP CONSTRAINT FK455E9669D1B;
ALTER TABLE place_reservation_request DROP CONSTRAINT FK10FCEDE4D1B;
ALTER TABLE recreation_activity_registration_request_other_individual DROP CONSTRAINT FK8026343B2B6BDF6E;
ALTER TABLE recreation_activity_registration_request_other_individual DROP CONSTRAINT FK8026343BBF1AD192;
ALTER TABLE payment DROP CONSTRAINT FKD11C32064E01D8BE;
ALTER TABLE payment DROP CONSTRAINT FKD11C3206F8797B2C;
ALTER TABLE requirement DROP CONSTRAINT FK15A8DC43F2EA0D1C;
ALTER TABLE requirement DROP CONSTRAINT FK15A8DC43F02D7A90;
ALTER TABLE school_canteen_registration_request_food_diet DROP CONSTRAINT FK5768CADF65F5E665;
ALTER TABLE school_canteen_registration_request_food_diet DROP CONSTRAINT FK5768CADF85DAF0B1;
ALTER TABLE sewer_connection_request DROP CONSTRAINT FK50B057BBD1B;
ALTER TABLE sewer_connection_request DROP CONSTRAINT FK50B057BBB824A652;
ALTER TABLE marriage_details_request DROP CONSTRAINT FK38315C1DD1B;
ALTER TABLE school_registration_request DROP CONSTRAINT FK7BDFE8F4812F1C6;
ALTER TABLE school_registration_request DROP CONSTRAINT FK7BDFE8F4D1B;
ALTER TABLE agent_site_roles DROP CONSTRAINT FK1C3B6D3F57919495;
ALTER TABLE request DROP CONSTRAINT FK414EF28F4E01D8BE;
ALTER TABLE request DROP CONSTRAINT FK414EF28FF8797B2C;
ALTER TABLE request DROP CONSTRAINT FK414EF28FF02D7A90;
ALTER TABLE vacations_registration_request_other_individual DROP CONSTRAINT FK567CEB55BF1AD192;
ALTER TABLE vacations_registration_request_other_individual DROP CONSTRAINT FK567CEB555DD9AC08;
ALTER TABLE vo_card_request DROP CONSTRAINT FKC295D426D1B;

ALTER TABLE adult ADD CONSTRAINT FK58621BA71A211CC FOREIGN KEY (id) REFERENCES individual;
ALTER TABLE agent_category_roles ADD CONSTRAINT FKBAFB98B6FB8D007D FOREIGN KEY (agent_id) REFERENCES agent;
ALTER TABLE agent_category_roles ADD CONSTRAINT FKBAFB98B6CE4D7137 FOREIGN KEY (category_id) REFERENCES category;
ALTER TABLE agent_site_roles ADD CONSTRAINT FK1C3B6D3FFB8D007D FOREIGN KEY (agent_id) REFERENCES agent;
ALTER TABLE alignment_certificate_request ADD CONSTRAINT FK9EBFB38B1F88D72E FOREIGN KEY (owner_address_id) REFERENCES adress;
ALTER TABLE alignment_certificate_request ADD CONSTRAINT FK9EBFB38BED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE birth_details_request ADD CONSTRAINT FKB3569612ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE category_emails ADD CONSTRAINT FKB9136EB8CE4D7137 FOREIGN KEY (category_id) REFERENCES category;
ALTER TABLE child ADD CONSTRAINT FK5A3F51C71A211CC FOREIGN KEY (id) REFERENCES individual;
ALTER TABLE child_legal_responsible_map ADD CONSTRAINT FK62E1102AC5C931EC FOREIGN KEY (legal_responsible_id) REFERENCES adult;
ALTER TABLE child_legal_responsible_map ADD CONSTRAINT FK62E1102A30CABB22 FOREIGN KEY (child_id) REFERENCES child;
ALTER TABLE death_details_request ADD CONSTRAINT FK85B0A9C7ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE dhr_donation ADD CONSTRAINT FK91725043E45A0A7F FOREIGN KEY (donation_notary_address_id) REFERENCES adress;
ALTER TABLE dhr_donation ADD CONSTRAINT FK9172504366C81F29 FOREIGN KEY (domestic_help_request_id) REFERENCES domestic_help_request;
ALTER TABLE dhr_personal_estate_and_saving ADD CONSTRAINT FK5EFB376766C81F29 FOREIGN KEY (domestic_help_request_id) REFERENCES domestic_help_request;
ALTER TABLE dhr_previous_dwelling ADD CONSTRAINT FKB0B96E27F802E509 FOREIGN KEY (previous_dwelling_address_id) REFERENCES adress;
ALTER TABLE dhr_previous_dwelling ADD CONSTRAINT FKB0B96E2766C81F29 FOREIGN KEY (domestic_help_request_id) REFERENCES domestic_help_request;
ALTER TABLE dhr_real_asset ADD CONSTRAINT FK6AA7D980A3F3FF52 FOREIGN KEY (real_asset_address_id) REFERENCES adress;
ALTER TABLE dhr_real_asset ADD CONSTRAINT FK6AA7D98066C81F29 FOREIGN KEY (domestic_help_request_id) REFERENCES domestic_help_request;
ALTER TABLE document ADD CONSTRAINT FK335CD11B59302132 FOREIGN KEY (individual_id) REFERENCES individual;
ALTER TABLE document ADD CONSTRAINT FK335CD11BDDD47DCE FOREIGN KEY (document_type_id) REFERENCES document_type;
ALTER TABLE document ADD CONSTRAINT FK335CD11B8BD77771 FOREIGN KEY (home_folder_id) REFERENCES home_folder;
ALTER TABLE document_action ADD CONSTRAINT FKA42545DA1F561FF2 FOREIGN KEY (document_id) REFERENCES document;
ALTER TABLE document_binary ADD CONSTRAINT FKA62BD3A51F561FF2 FOREIGN KEY (document_id) REFERENCES document;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C0081121C4A2C9A FOREIGN KEY (spouse_information_id) REFERENCES adult;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C008112A2B2928B FOREIGN KEY (current_dwelling_address_id) REFERENCES adress;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C008112B3BAD17C FOREIGN KEY (spouse_employer_address_id) REFERENCES adress;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C0081126FFC52CB FOREIGN KEY (tutor_address_id) REFERENCES adress;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C008112ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE electoral_roll_registration_request ADD CONSTRAINT FK45625529F0159453 FOREIGN KEY (subject_address_outside_city_id) REFERENCES adress;
ALTER TABLE electoral_roll_registration_request ADD CONSTRAINT FK45625529ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE forms ADD CONSTRAINT FK5D18C2F1808DF5C FOREIGN KEY (request_form_id) REFERENCES request_form;
ALTER TABLE forms ADD CONSTRAINT FK5D18C2FD97439C FOREIGN KEY (request_type_id) REFERENCES request_type;
ALTER TABLE handicap_allowance_request ADD CONSTRAINT FKF20630A16D27AFFE FOREIGN KEY (legal_representative_address_id) REFERENCES adress;
ALTER TABLE handicap_allowance_request ADD CONSTRAINT FKF20630A1ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE home_folder ADD CONSTRAINT FKDB87BBCE6AB1E860 FOREIGN KEY (adress_id) REFERENCES adress;
ALTER TABLE home_folder_modification_request ADD CONSTRAINT FK26ED7ABDED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE individual ADD CONSTRAINT FKFD3DA2996AB1E860 FOREIGN KEY (adress_id) REFERENCES adress;
ALTER TABLE individual ADD CONSTRAINT FKFD3DA2998BD77771 FOREIGN KEY (home_folder_id) REFERENCES home_folder;
ALTER TABLE individual ADD CONSTRAINT FKFD3DA29948B0ABD2 FOREIGN KEY (card_id) REFERENCES card;
ALTER TABLE library_registration_request ADD CONSTRAINT FKEA37820DED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE library_registration_request_subscription ADD CONSTRAINT FK56C4BE0F6E60AC03 FOREIGN KEY (library_registration_request_id) REFERENCES library_registration_request;
ALTER TABLE library_registration_request_subscription ADD CONSTRAINT FK56C4BE0FE383A5FD FOREIGN KEY (subscription_id) REFERENCES local_referential_data;
ALTER TABLE local_referential_association ADD CONSTRAINT FK6B28F6775AC79CA3 FOREIGN KEY (local_referential_child_data_id) REFERENCES local_referential_data;
ALTER TABLE local_referential_association ADD CONSTRAINT FK6B28F677DBACE805 FOREIGN KEY (local_referential_parent_data_id) REFERENCES local_referential_data;
ALTER TABLE local_referential_data ADD CONSTRAINT FK49407E74DBACE805 FOREIGN KEY (local_referential_parent_data_id) REFERENCES local_referential_data;
ALTER TABLE marriage_details_request ADD CONSTRAINT FK38315C1DED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE music_school_registration_request ADD CONSTRAINT FK51A399DAED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE music_school_registration_request_activity ADD CONSTRAINT FK6393FFD4F5425501 FOREIGN KEY (music_school_registration_request_id) REFERENCES music_school_registration_request;
ALTER TABLE music_school_registration_request_activity ADD CONSTRAINT FK6393FFD4696ECB FOREIGN KEY (activity_id) REFERENCES local_referential_data;
ALTER TABLE payment ADD CONSTRAINT FKD11C32061BC4A960 FOREIGN KEY (requester_id) REFERENCES adult;
ALTER TABLE payment ADD CONSTRAINT FKD11C32068BD77771 FOREIGN KEY (home_folder_id) REFERENCES home_folder;
ALTER TABLE perischool_activity_registration_request ADD CONSTRAINT FK76BAA59A20540B7 FOREIGN KEY (school_id) REFERENCES school;
ALTER TABLE perischool_activity_registration_request ADD CONSTRAINT FK76BAA59AED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE perischool_activity_registration_request_other_individual ADD CONSTRAINT FKD6BDD32DDCC9C993 FOREIGN KEY (other_individual_id) REFERENCES other_individual;
ALTER TABLE perischool_activity_registration_request_other_individual ADD CONSTRAINT FKD6BDD32D4B24749F FOREIGN KEY (perischool_activity_registration_request_id) REFERENCES perischool_activity_registration_request;
ALTER TABLE perischool_activity_registration_request_perischool_activity ADD CONSTRAINT FK2007A4E9D633AA6C FOREIGN KEY (perischool_activity_id) REFERENCES local_referential_data;
ALTER TABLE perischool_activity_registration_request_perischool_activity ADD CONSTRAINT FK2007A4E94B24749F FOREIGN KEY (perischool_activity_registration_request_id) REFERENCES perischool_activity_registration_request;
ALTER TABLE personal_details_request ADD CONSTRAINT FKDA412593ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE place_reservation_request ADD CONSTRAINT FK10FCEDE4ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE place_reservation_request_place_reservation ADD CONSTRAINT FK9493CEF96E5CE64D FOREIGN KEY (place_reservation_id) REFERENCES place_reservation_data;
ALTER TABLE place_reservation_request_place_reservation ADD CONSTRAINT FK9493CEF9E2EAB80C FOREIGN KEY (place_reservation_request_id) REFERENCES place_reservation_request;
ALTER TABLE purchase_item ADD CONSTRAINT FKB113279154BCD4FA FOREIGN KEY (payment_id) REFERENCES payment;
ALTER TABLE purchase_item ADD CONSTRAINT FKB1132791EF51C842 FOREIGN KEY (request_id) REFERENCES request;
ALTER TABLE purchase_item_specific_data ADD CONSTRAINT FK455E96692BA69830 FOREIGN KEY (id) REFERENCES purchase_item;
ALTER TABLE recreation_activity_registration_request ADD CONSTRAINT FKD1F8ECCF8EE79C FOREIGN KEY (recreation_center_id) REFERENCES recreation_center;
ALTER TABLE recreation_activity_registration_request ADD CONSTRAINT FKD1F8ECCED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE recreation_activity_registration_request_other_individual ADD CONSTRAINT FK8026343BDCC9C993 FOREIGN KEY (other_individual_id) REFERENCES other_individual;
ALTER TABLE recreation_activity_registration_request_other_individual ADD CONSTRAINT FK8026343B14E9A3B FOREIGN KEY (recreation_activity_registration_request_id) REFERENCES recreation_activity_registration_request;
ALTER TABLE recreation_activity_registration_request_recreation_activity ADD CONSTRAINT FK54117CA914E9A3B FOREIGN KEY (recreation_activity_registration_request_id) REFERENCES recreation_activity_registration_request;
ALTER TABLE recreation_activity_registration_request_recreation_activity ADD CONSTRAINT FK54117CA97F2ADC1E FOREIGN KEY (recreation_activity_id) REFERENCES local_referential_data;
ALTER TABLE remote_support_request ADD CONSTRAINT FKEAA6DC26ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE request ADD CONSTRAINT FK414EF28F1BC4A960 FOREIGN KEY (requester_id) REFERENCES adult;
ALTER TABLE request ADD CONSTRAINT FK414EF28FD97439C FOREIGN KEY (request_type_id) REFERENCES request_type;
ALTER TABLE request ADD CONSTRAINT FK414EF28F8BD77771 FOREIGN KEY (home_folder_id) REFERENCES home_folder;
ALTER TABLE request_action ADD CONSTRAINT FK7AC459E6EF51C842 FOREIGN KEY (request_id) REFERENCES request;
ALTER TABLE request_document_map ADD CONSTRAINT FKCBC2F7E81F561FF2 FOREIGN KEY (document_id) REFERENCES document;
ALTER TABLE request_document_map ADD CONSTRAINT FKCBC2F7E8EF51C842 FOREIGN KEY (request_id) REFERENCES request;
ALTER TABLE request_means_of_contact ADD CONSTRAINT FK72CB44F9EF51C842 FOREIGN KEY (request_id) REFERENCES request;
ALTER TABLE request_means_of_contact ADD CONSTRAINT FK72CB44F9C6E53A51 FOREIGN KEY (means_of_contact_id) REFERENCES local_referential_data;
ALTER TABLE request_note ADD CONSTRAINT FK4DABB7A2EF51C842 FOREIGN KEY (request_id) REFERENCES request;
ALTER TABLE request_type ADD CONSTRAINT FK4DAE96EACE4D7137 FOREIGN KEY (category_id) REFERENCES category;
ALTER TABLE requirement ADD CONSTRAINT FK15A8DC43DDD47DCE FOREIGN KEY (document_type_id) REFERENCES document_type;
ALTER TABLE requirement ADD CONSTRAINT FK15A8DC43D97439C FOREIGN KEY (request_type_id) REFERENCES request_type;
ALTER TABLE school_canteen_registration_request ADD CONSTRAINT FKDC4CBC6920540B7 FOREIGN KEY (school_id) REFERENCES school;
ALTER TABLE school_canteen_registration_request ADD CONSTRAINT FKDC4CBC69ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE school_canteen_registration_request_canteen_attending_days ADD CONSTRAINT FK1323D9F9AAB3F7 FOREIGN KEY (canteen_attending_days_id) REFERENCES local_referential_data;
ALTER TABLE school_canteen_registration_request_canteen_attending_days ADD CONSTRAINT FK1323D9F9E5E30099 FOREIGN KEY (school_canteen_registration_request_id) REFERENCES school_canteen_registration_request;
ALTER TABLE school_canteen_registration_request_food_diet ADD CONSTRAINT FK5768CADF9D0BE4E5 FOREIGN KEY (food_diet_id) REFERENCES local_referential_data;
ALTER TABLE school_canteen_registration_request_food_diet ADD CONSTRAINT FK5768CADFE5E30099 FOREIGN KEY (school_canteen_registration_request_id) REFERENCES school_canteen_registration_request;
ALTER TABLE school_registration_request ADD CONSTRAINT FK7BDFE8F420540B7 FOREIGN KEY (school_id) REFERENCES school;
ALTER TABLE school_registration_request ADD CONSTRAINT FK7BDFE8F4ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE seasons ADD CONSTRAINT FK7552F1F0D97439C FOREIGN KEY (request_type_id) REFERENCES request_type;
ALTER TABLE sewer_connection_request ADD CONSTRAINT FK50B057BB1F88D72E FOREIGN KEY (owner_address_id) REFERENCES adress;
ALTER TABLE sewer_connection_request ADD CONSTRAINT FK50B057BBED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE ticket_type_selection ADD CONSTRAINT FK3B70C45A6592BACC FOREIGN KEY (place_reservation_data_id) REFERENCES place_reservation_data;
ALTER TABLE vacations_diary ADD CONSTRAINT FK2890BF7ACE7A2F50 FOREIGN KEY (vacations_registration_request_id) REFERENCES vacations_registration_request;
ALTER TABLE vacations_registration_request ADD CONSTRAINT FK92F4987230CABB22 FOREIGN KEY (child_id) REFERENCES child;
ALTER TABLE vacations_registration_request ADD CONSTRAINT FK92F49872F8EE79C FOREIGN KEY (recreation_center_id) REFERENCES recreation_center;
ALTER TABLE vacations_registration_request ADD CONSTRAINT FK92F49872ED1B9492 FOREIGN KEY (id) REFERENCES request;
ALTER TABLE vacations_registration_request_other_individual ADD CONSTRAINT FK567CEB55DCC9C993 FOREIGN KEY (other_individual_id) REFERENCES other_individual;
ALTER TABLE vacations_registration_request_other_individual ADD CONSTRAINT FK567CEB55CE7A2F50 FOREIGN KEY (vacations_registration_request_id) REFERENCES vacations_registration_request;
ALTER TABLE vo_card_request ADD CONSTRAINT FKC295D426ED1B9492 FOREIGN KEY (id) REFERENCES request;


--
-- Address normalization script
--
-- Add new address's field
ALTER TABLE adress ADD COLUMN  additional_delivery_information varchar(38);
ALTER TABLE adress ADD COLUMN  additional_geographical_information varchar(38);
ALTER TABLE adress ADD COLUMN  street_number varchar(5);
ALTER TABLE adress ADD COLUMN  street_name varchar(114); -- 'street_name is set temporaly with 'adress size''
ALTER TABLE adress ADD COLUMN  place_name_or_service varchar(38);
ALTER TABLE adress ADD COLUMN  country_name varchar(38); 

-- Copy 'adress' field values into 'street_name' field
CREATE FUNCTION address_normalization_migration() RETURNS void AS $$
  DECLARE
    current_rec RECORD; 
  BEGIN
    FOR current_rec IN SELECT id, adress FROM adress LOOP
      UPDATE adress SET street_name = current_rec.adress WHERE id = current_rec.id;
    END LOOP;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
SELECT address_normalization_migration();
DROP FUNCTION address_normalization_migration();

-- Drop adress field
ALTER TABLE adress DROP COLUMN adress;

-- Rename to 'address' table
ALTER TABLE adress RENAME TO address ;

ALTER TABLE address DROP CONSTRAINT adress_pkey CASCADE;
ALTER TABLE address ADD CONSTRAINT address_pkey PRIMARY KEY (id);

ALTER TABLE alignment_certificate_request ADD CONSTRAINT FK9EBFB38B1F88D72E FOREIGN KEY (owner_address_id) REFERENCES address;
ALTER TABLE dhr_donation ADD CONSTRAINT FK91725043E45A0A7F FOREIGN KEY (donation_notary_address_id) REFERENCES address;
ALTER TABLE dhr_previous_dwelling ADD CONSTRAINT FKB0B96E27F802E509 FOREIGN KEY (previous_dwelling_address_id) REFERENCES address;
ALTER TABLE dhr_real_asset ADD CONSTRAINT FK6AA7D980A3F3FF52 FOREIGN KEY (real_asset_address_id) REFERENCES address;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C008112A2B2928B FOREIGN KEY (current_dwelling_address_id) REFERENCES address;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C008112B3BAD17C FOREIGN KEY (spouse_employer_address_id) REFERENCES address;
ALTER TABLE domestic_help_request ADD CONSTRAINT FK3C0081126FFC52CB FOREIGN KEY (tutor_address_id) REFERENCES address;
ALTER TABLE electoral_roll_registration_request ADD CONSTRAINT FK45625529F0159453 FOREIGN KEY (subject_address_outside_city_id) REFERENCES address;
ALTER TABLE handicap_allowance_request ADD CONSTRAINT FKF20630A16D27AFFE FOREIGN KEY (legal_representative_address_id) REFERENCES address;
ALTER TABLE home_folder ADD CONSTRAINT FKDB87BBCE6AB1E860 FOREIGN KEY (adress_id) REFERENCES address;
ALTER TABLE individual ADD CONSTRAINT FKFD3DA2996AB1E860 FOREIGN KEY (adress_id) REFERENCES address;
ALTER TABLE sewer_connection_request ADD CONSTRAINT FK50B057BB1F88D72E FOREIGN KEY (owner_address_id) REFERENCES address;


-- Mean Of Contact refactoring

-- request_means_of_contact will be drop after the execution of the migration script
--DROP TABLE request_means_of_contact;

CREATE TABLE means_of_contact (
     id int8 not null,
     type varchar(255),
     enabled bool,
     primary key (id)
 );

ALTER TABLE request ADD COLUMN means_of_contact_id int8;

ALTER TABLE request ADD CONSTRAINT FK414EF28F3FFD6284 FOREIGN KEY (means_of_contact_id) REFERENCES means_of_contact;

-- Manager profile
UPDATE agent_site_roles SET profile = 'Agent' WHERE profile = 'None';


-- RequestForm extension
ALTER TABLE request_form ADD COLUMN label varchar(255);
ALTER TABLE request_form ADD COLUMN short_label varchar(255);


-- Adding HolidaySecurityRequest table

CREATE TABLE holiday_security_request (
    id int8 not null,
    other_contact_phone varchar(10),
    other_contact_last_name varchar(38),
    other_contact_address_id int8,
    rules_and_regulations_acceptance bool,
    light bool,
    absence_end_date timestamp,
    absence_start_date timestamp,
    alert_phone varchar(10),
    alarm bool,
    other_contact_first_name varchar(38),
    primary key (id)
);
ALTER TABLE holiday_security_request OWNER TO cvq95;
ALTER TABLE holiday_security_request  ADD CONSTRAINT FKED34C597E2AF3D30 FOREIGN KEY (other_contact_address_id) REFERENCES address;
ALTER TABLE holiday_security_request ADD CONSTRAINT FKED34C597ED1B9492 FOREIGN KEY (id) REFERENCES request;


-- Adding HolidaySecurityRequest tables

CREATE TABLE technical_intervention_request (
    id int8 not null,
    intervention_place_id int8,
    intervention_description varchar(255),
    primary key (id)
);
ALTER TABLE technical_intervention_request owner to cvq95;
ALTER TABLE technical_intervention_request ADD CONSTRAINT FKC051B8C974526C97 FOREIGN KEY (intervention_place_id) REFERENCES address;
ALTER TABLE technical_intervention_request ADD CONSTRAINT FKC051B8C9ED1B9492 FOREIGN KEY (id) REFERENCES request;

CREATE TABLE technical_intervention_request_intervention_type (
    technical_intervention_request_id int8 not null,
    intervention_type_id int8 not null,
    primary key (technical_intervention_request_id, intervention_type_id)
);
ALTER TABLE technical_intervention_request_intervention_type OWNER TO cvq95;
ALTER TABLE technical_intervention_request_intervention_type ADD CONSTRAINT FK5ADF79AC7CF39D58 FOREIGN KEY (intervention_type_id) REFERENCES local_referential_data;
ALTER TABLE technical_intervention_request_intervention_type ADD CONSTRAINT FK5ADF79AC1A297B4F FOREIGN KEY (technical_intervention_request_id) REFERENCES technical_intervention_request;

-- STGL updates

-- updates for military census request
create table military_census_request (
   id int8 not null,
   mother_first_name varchar(38),
   state_pupil bool,
   other_situation varchar(255),
   alive_children bytea,
   mother_birth_postal varchar(5),
   father_first_name varchar(38),
   maiden_name varchar(38),
   father_birth_city varchar(255),
   mother_birth_city varchar(255),
   child_speciality varchar(255),
   prefect_pupil bool,
   child_diploma varchar(255),
   child_residence_country varchar(255),
   child_country varchar(255),
   father_birth_postal varchar(5),
   affection_or_disease bool,
   child_status varchar(255),
   mother_birth_date timestamp,
   children_in_charge bytea,
   mother_last_name varchar(38),
   child_title varchar(255),
   father_birth_date timestamp,
   child_convention varchar(255),
   child_mail varchar(255),
   child_situation varchar(255),
   child_other_country varchar(255),
   father_last_name varchar(38),
   child_profession varchar(255),
   child_birth_country varchar(255),
   japd_exemption bool,
   highly_infirm bool,
   child_phone varchar(10),
   primary key (id)
);
alter table military_census_request owner to cvq95;

alter table military_census_request add constraint FK56137C47D1B foreign key (id) references request;

-- updates for sms notification request
create table sms_notification_request (
   id int8 not null,
   subscription bool,
   primary key (id)
);
alter table sms_notification_request owner to cvq95;

create table sms_notification_request_interests (
   sms_notification_request_id int8 not null,
   interests_id int8 not null,
   primary key (sms_notification_request_id, interests_id)
);
alter table sms_notification_request_interests owner to cvq95;

alter table sms_notification_request_interests add constraint FKCE60DA2B3E59BA91 foreign key (interests_id) references local_referential_data;
alter table sms_notification_request_interests add constraint FKCE60DA2BEE8163B9 foreign key (sms_notification_request_id) references sms_notification_request;
alter table sms_notification_request add constraint FK33CA6661D1B foreign key (id) references request;
alter table sms_notification_request add column clever_sms_contact_id varchar(255);

-- updates for waste collection requests
create table bulky_waste_collection_request (
   id int8 not null,
   collection_address varchar(255),
   email varchar(255),
   telephone varchar(10),
   other_waste varchar(255),
   primary key (id)
);
alter table bulky_waste_collection_request owner to cvq95;

create table bulky_waste_collection_request_bulky_waste_type (
   bulky_waste_collection_request_id int8 not null,
   bulky_waste_type_id int8 not null,
   primary key (bulky_waste_collection_request_id, bulky_waste_type_id)
);
alter table bulky_waste_collection_request_bulky_waste_type owner to cvq95;

alter table bulky_waste_collection_request_bulky_waste_type add constraint FK7E2C4DCB617BC383 foreign key (bulky_waste_type_id) references local_referential_data;
alter table bulky_waste_collection_request_bulky_waste_type add constraint FK7E2C4DCBEAC2AB0F foreign key (bulky_waste_collection_request_id) references bulky_waste_collection_request;
alter table bulky_waste_collection_request add constraint FK1F104ECBD1B foreign key (id) references request;

create table compostable_waste_collection_request (
   id int8 not null,
   collection_address varchar(255),
   email varchar(255),
   telephone varchar(10),
   other_waste varchar(255),
   primary key (id)
);
alter table compostable_waste_collection_request owner to cvq95;

create table compostable_waste_collection_request_compostable_waste_type (
   compostable_waste_collection_request_id int8 not null,
   compostable_waste_type_id int8 not null,
   primary key (compostable_waste_collection_request_id, compostable_waste_type_id)
);
alter table compostable_waste_collection_request_compostable_waste_type owner to cvq95;

alter table compostable_waste_collection_request_compostable_waste_type add constraint FK765E424B4B0F61E3 foreign key (compostable_waste_collection_request_id) references compostable_waste_collection_request;
alter table compostable_waste_collection_request_compostable_waste_type add constraint FK765E424B8ADC3D57 foreign key (compostable_waste_type_id) references local_referential_data;
alter table compostable_waste_collection_request add constraint FKAFF72877D1B foreign key (id) references request;

alter table military_census_request add column prefect_pupil_department varchar(255);
update military_census_request set prefect_pupil_department = 'None';
update military_census_request set child_diploma = 'Unknown';

alter table military_census_request add column father_birth_country varchar(255);
update military_census_request set father_birth_country = 'Unknown';
alter table military_census_request add column father_birth_department varchar(255);
update military_census_request set father_birth_department = 'None';
alter table military_census_request add column father_nationality varchar(255);
update military_census_request set father_nationality = 'None';
alter table military_census_request drop column father_birth_postal;

alter table military_census_request add column mother_birth_country varchar(255);
update military_census_request set mother_birth_country = 'Unknown';
alter table military_census_request add column mother_birth_department varchar(255);
update military_census_request set mother_birth_department = 'None';
alter table military_census_request add column mother_nationality varchar(255);
update military_census_request set mother_nationality = 'None';
alter table military_census_request drop column mother_birth_postal;

alter table bulky_waste_collection_request drop column email;
alter table bulky_waste_collection_request drop column telephone;

alter table compostable_waste_collection_request drop column email;
alter table compostable_waste_collection_request drop column telephone;

