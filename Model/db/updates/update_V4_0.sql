-- Document related refactorings (DRR)

-- DRR1 : constraint on individual
alter table document 
    drop constraint FK335CD11B59302132;
-- DRR2 : constraint on home folder
alter table document 
    drop constraint FK335CD11B8BD77771;

-- Request related refactorings (RRR)

-- RRR1 : constraint on home folder
alter table request 
    drop constraint FK414EF28F8BD77771;
    
-- RRR2 : constraint on individual (requester)
alter table request
    drop constraint FK414EF28F1BC4A960;

-- RRR3 : contraint on documents
create table request_document (
    id int8 not null,
    document_id int8,
    request_id int8,
    primary key (id)
);

alter table request_document 
    add constraint FK712980CB848EB249 
    foreign key (request_id) 
    references request;
         
insert into request_document select nextval('hibernate_sequence'), document_id, request_id from request_document_map;

drop table request_document_map cascade;

-- RRR4 : add requester and subject last name
alter table request add column requester_last_name varchar(255);
alter table request add column requester_first_name varchar(255);
alter table request add column subject_last_name varchar(255);
alter table request add column subject_first_name varchar(255);

UPDATE request set requester_last_name = (select last_name from individual where individual.id = request.requester_id);
UPDATE request set requester_first_name = (select first_name from individual where individual.id = request.requester_id);
UPDATE request set subject_first_name = (select first_name from individual where individual.id = request.subject_id);
UPDATE request set subject_last_name = (select last_name from individual where individual.id = request.subject_id);
alter table request drop column subject_table_name;

-- Home folder related constraints (HFRC)

-- HFRC1 : object model for roles 
create table individual_role (
    id int8 not null,
    role varchar(255),
    home_folder_id int8,
    individual_id int8,
    owner_id int8,
    primary key (id)
);

alter table individual_role 
    add constraint FK3C7D4E5CD4C3A2D8
    foreign key (owner_id)
    references individual;

-- migration of existing "home folder responsible" roles
insert into individual_role select nextval('hibernate_sequence'), 'HomeFolderResponsible', home_folder_id, null, adult.id from adult, individual where adult.id = individual.id and (home_folder_roles = 1 or home_folder_roles = 3);

alter table adult drop column home_folder_roles;

-- migration of existing "child legal responsible" roles
insert into individual_role select nextval('hibernate_sequence'), 'ClrFather', null, child_id, legal_responsible_id from child_legal_responsible_map where role = 'Father' and child_id is not null;
insert into individual_role select nextval('hibernate_sequence'), 'ClrMother', null, child_id, legal_responsible_id from child_legal_responsible_map where role = 'Mother' and child_id is not null;
insert into individual_role select nextval('hibernate_sequence'), 'ClrTutor', null, child_id, legal_responsible_id from child_legal_responsible_map where role = 'Tutor' and child_id is not null;

alter table child_legal_responsible_map 
    drop constraint FK62E1102A30CABB22;
alter table child_legal_responsible_map 
    drop constraint FK62E1102AC5C931EC;
drop table child_legal_responsible_map;

-- Side effet : Payment related refactorings (PRR)

-- PRR1 : purchase item constraint on request
alter table purchase_item
    drop constraint fkb1132791ef51c842;
    
-- request letter templates enhancements
alter table request_form add column personalized_data bytea ;
alter table request_form add column template_name varchar(255);

-- vacations registration request removal
drop table vacations_diary ;
drop table vacations_registration_request_other_individual ;
drop table vacations_registration_request ;
delete from requirement where request_type_id = (select id from request_type where label = 'Vacations Registration');
delete from request_type where label = 'Vacations Registration';

-- start of migration to indexed lists in requests collections elements

alter table library_registration_request_subscription drop constraint FK56C4BE0F6E60AC03;
alter table music_school_registration_request_activity drop constraint FK6393FFD4F5425501;
alter table perischool_activity_registration_request_other_individual drop constraint FKD6BDD32D4B24749F;
alter table perischool_activity_registration_request_other_individual drop constraint FKD6BDD32DDCC9C993;
alter table perischool_activity_registration_request_perischool_activity drop constraint FK2007A4E94B24749F;
alter table place_reservation_request_place_reservation drop constraint FK9493CEF9E2EAB80C;
alter table recreation_activity_registration_request_other_individual drop constraint FK8026343BDCC9C993;
alter table recreation_activity_registration_request_other_individual drop constraint FK8026343B14E9A3B;
alter table recreation_activity_registration_request_recreation_activity drop constraint FK54117CA914E9A3B;
alter table school_canteen_registration_request_canteen_attending_days drop constraint FK1323D9F9E5E30099;
alter table school_canteen_registration_request_food_diet drop constraint FK5768CADFE5E30099; 
alter table technical_intervention_request_intervention_type drop constraint FK5ADF79AC1A297B4F;

alter table bulky_waste_collection_request_bulky_waste_type add constraint FK7E2C4DCBD1DA5141 foreign key (bulky_waste_collection_request_id) references bulky_waste_collection_request;
alter table compostable_waste_collection_request_compostable_waste_type add constraint FK765E424BC116EEE9 foreign key (compostable_waste_collection_request_id) references compostable_waste_collection_request;
alter table library_registration_request_subscription add constraint FK56C4BE0FD98B4AC2 foreign key (library_registration_request_id) references library_registration_request;
alter table music_school_registration_request_activity add constraint FK6393FFD440404000 foreign key (music_school_registration_request_id) references music_school_registration_request;
alter table perischool_activity_registration_request_other_individual add constraint FKD6BDD32D96225F9E foreign key (perischool_activity_registration_request_id) references perischool_activity_registration_request;
alter table perischool_activity_registration_request_other_individual add constraint FKD6BDD32D8071FDD2 foreign key (other_individual_id) references other_individual;
alter table perischool_activity_registration_request_perischool_activity add constraint FK2007A4E996225F9E foreign key (perischool_activity_registration_request_id) references perischool_activity_registration_request;
alter table place_reservation_request_place_reservation add constraint FK9493CEF912CBA22D foreign key (place_reservation_request_id) references place_reservation_request;
alter table recreation_activity_registration_request_other_individual add constraint FK8026343B8071FDD2 foreign key (other_individual_id) references other_individual;
alter table recreation_activity_registration_request_other_individual add constraint FK8026343B4C4C853A foreign key (recreation_activity_registration_request_id) references recreation_activity_registration_request;
alter table recreation_activity_registration_request_recreation_activity add constraint FK54117CA94C4C853A foreign key (recreation_activity_registration_request_id) references recreation_activity_registration_request;
alter table school_canteen_registration_request_canteen_attending_days add constraint FK1323D9F990FF23A foreign key (school_canteen_registration_request_id) references school_canteen_registration_request;
alter table school_canteen_registration_request_food_diet add constraint FK5768CADF90FF23A foreign key (school_canteen_registration_request_id) references school_canteen_registration_request;
alter table sms_notification_request_interests add constraint FKCE60DA2B16CF96DE foreign key (sms_notification_request_id) references sms_notification_request;
alter table technical_intervention_request_intervention_type add constraint FK5ADF79ACC8B7518E foreign key (technical_intervention_request_id) references technical_intervention_request;


-- primary key name (colum data table name) is limited to 64 characters
create function max_lenght_pk_drop() returns void as $$
  begin
    begin
      alter table compostable_waste_collection_request_compostable_waste_type drop constraint compostable_waste_collection_request_compostable_waste_type_pkey;
      alter table perischool_activity_registration_request_perischool_activity drop constraint perischool_activity_registration_request_perischool_activity_pkey;
      alter table recreation_activity_registration_request_recreation_activity drop constraint recreation_activity_registration_request_recreation_activity_pkey ;
      exception when undefined_object then
    end;
    begin
      alter table compostable_waste_collection_request_compostable_waste_type drop constraint  compostable_waste_collection_request_compostable_waste_typ_pkey;
      alter table perischool_activity_registration_request_perischool_activity drop constraint perischool_activity_registration_request_perischool_activi_pkey;
      alter table recreation_activity_registration_request_recreation_activity drop constraint recreation_activity_registration_request_recreation_activi_pkey;
      exception when undefined_object then
    end;
    return;
  end;
$$ language plpgsql;
select max_lenght_pk_drop();
drop function max_lenght_pk_drop();

alter table bulky_waste_collection_request_bulky_waste_type drop constraint bulky_waste_collection_request_bulky_waste_type_pkey ;
alter table library_registration_request_subscription drop constraint library_registration_request_subscription_pkey ;
alter table music_school_registration_request_activity drop constraint music_school_registration_request_activity_pkey ;
alter table perischool_activity_registration_request_other_individual drop constraint perischool_activity_registration_request_other_individual_pkey ;
alter table place_reservation_request_place_reservation drop constraint place_reservation_request_place_reservation_pkey ;
alter table recreation_activity_registration_request_other_individual drop constraint recreation_activity_registration_request_other_individual_pkey ;
alter table school_canteen_registration_request_canteen_attending_days drop constraint school_canteen_registration_request_canteen_attending_days_pkey ;
alter table school_canteen_registration_request_food_diet drop constraint school_canteen_registration_request_food_diet_pkey ;
alter table sms_notification_request_interests drop constraint sms_notification_request_interests_pkey ;
alter table technical_intervention_request_intervention_type drop constraint technical_intervention_request_intervention_type_pkey ;

-- Add an int hibernate list index
CREATE FUNCTION init_hibernate_list_index(table_name text, foreign_id_col_name text, id_col_name text, index_col_name text) RETURNS void AS $$
 DECLARE
    current_index integer := 0;
    current_foreign_id integer := -1;
    current_rec record;
    select_cmd text := 'SELECT ' || quote_ident(id_col_name) || ' AS id, '
                       || quote_ident(foreign_id_col_name) || ' AS foreign_id'
                       || ' FROM ' || quote_ident(table_name)
                       || ' ORDER BY ' || quote_ident(foreign_id_col_name);
    update_cmd text ;
  BEGIN
    FOR current_rec IN EXECUTE select_cmd LOOP
      IF current_foreign_id <> current_rec.foreign_id THEN
        current_foreign_id := current_rec.foreign_id;
        current_index := 0;
      ELSE
        current_index := current_index + 1;
      END IF;
 
      update_cmd := 'UPDATE ' || quote_ident(table_name)
                    || ' SET ' || quote_ident(index_col_name) || ' = ' || current_index
                    || ' WHERE ' || quote_ident(id_col_name) || ' = ' || current_rec.id;
      EXECUTE update_cmd;
           
    END LOOP;
    RETURN;
  END;
$$ LANGUAGE plpgsql;

alter table bulky_waste_collection_request_bulky_waste_type add column bulky_waste_type_index int4;
select init_hibernate_list_index('bulky_waste_collection_request_bulky_waste_type', 'bulky_waste_collection_request_id', 'bulky_waste_type_id', 'bulky_waste_type_index');
alter table bulky_waste_collection_request_bulky_waste_type add constraint bulky_waste_collection_request_bulky_waste_type_pkey primary key (bulky_waste_collection_request_id, bulky_waste_type_index);

alter table compostable_waste_collection_request_compostable_waste_type add column compostable_waste_type_index int4;
select init_hibernate_list_index('compostable_waste_collection_request_compostable_waste_type', 'compostable_waste_collection_request_id', 'compostable_waste_type_id', 'compostable_waste_type_index');
-- truncate primary key
alter table compostable_waste_collection_request_compostable_waste_type add constraint compostable_waste_collection_request_compostable_waste_typ_pkey primary key (compostable_waste_collection_request_id, compostable_waste_type_index);
 
alter table library_registration_request_subscription add column subscription_index int4;
select init_hibernate_list_index('library_registration_request_subscription', 'library_registration_request_id', 'subscription_id', 'subscription_index');
alter table library_registration_request_subscription add constraint library_registration_request_subscription_pkey primary key (library_registration_request_id, subscription_index); 

alter table music_school_registration_request_activity add column activity_index int4;
select init_hibernate_list_index('music_school_registration_request_activity', 'music_school_registration_request_id', 'activity_id', 'activity_index');
alter table music_school_registration_request_activity add constraint music_school_registration_request_activity_pkey primary key (music_school_registration_request_id, activity_index);
     
alter table perischool_activity_registration_request_other_individual add other_individual_index int4;
select init_hibernate_list_index('perischool_activity_registration_request_other_individual', 'perischool_activity_registration_request_id', 'other_individual_id', 'other_individual_index');
alter table perischool_activity_registration_request_other_individual add constraint perischool_activity_registration_request_other_individual_pkey primary key (perischool_activity_registration_request_id, other_individual_index);
     
alter table perischool_activity_registration_request_perischool_activity add perischool_activity_index int4;
select init_hibernate_list_index('perischool_activity_registration_request_perischool_activity', 'perischool_activity_registration_request_id', 'perischool_activity_id', 'perischool_activity_index');
-- truncate primary key
alter table perischool_activity_registration_request_perischool_activity add constraint perischool_activity_registration_request_perischool_activi_pkey primary key (perischool_activity_registration_request_id, perischool_activity_index);

alter table place_reservation_request_place_reservation add column place_reservation_index int4;
select init_hibernate_list_index('place_reservation_request_place_reservation', 'place_reservation_request_id', 'place_reservation_id', 'place_reservation_index');
alter table place_reservation_request_place_reservation add constraint place_reservation_request_place_reservation_pkey primary key (place_reservation_request_id, place_reservation_index);

alter table recreation_activity_registration_request_other_individual add column other_individual_index int4;
select init_hibernate_list_index('recreation_activity_registration_request_other_individual', 'recreation_activity_registration_request_id', 'other_individual_id', 'other_individual_index');
alter table recreation_activity_registration_request_other_individual add constraint recreation_activity_registration_request_other_individual_pkey primary key (recreation_activity_registration_request_id, other_individual_index);
     
alter table recreation_activity_registration_request_recreation_activity add column recreation_activity_index int4;
select init_hibernate_list_index('recreation_activity_registration_request_recreation_activity', 'recreation_activity_registration_request_id', 'recreation_activity_id', 'recreation_activity_index');
-- truncate primary key
alter table recreation_activity_registration_request_recreation_activity add constraint recreation_activity_registration_request_recreation_activi_pkey primary key (recreation_activity_registration_request_id, recreation_activity_index); 

alter table school_canteen_registration_request_canteen_attending_days add column canteen_attending_days_index int4;
select init_hibernate_list_index('school_canteen_registration_request_canteen_attending_days', 'school_canteen_registration_request_id', 'canteen_attending_days_id', 'canteen_attending_days_index');
alter table school_canteen_registration_request_canteen_attending_days add constraint school_canteen_registration_request_canteen_attending_days_pkey primary key (school_canteen_registration_request_id, canteen_attending_days_index);

alter table school_canteen_registration_request_food_diet add column food_diet_index int4;
select init_hibernate_list_index('school_canteen_registration_request_food_diet', 'school_canteen_registration_request_id', 'food_diet_id', 'food_diet_index');
alter table school_canteen_registration_request_food_diet add constraint school_canteen_registration_request_food_diet_pkey primary key (school_canteen_registration_request_id, food_diet_index);

alter table sms_notification_request_interests add column interests_index int4;
select init_hibernate_list_index('sms_notification_request_interests', 'sms_notification_request_id', 'interests_id', 'interests_index');
alter table sms_notification_request_interests add constraint sms_notification_request_interests_pkey primary key (sms_notification_request_id, interests_index);

alter table technical_intervention_request_intervention_type add column intervention_type_index int4;
select init_hibernate_list_index('technical_intervention_request_intervention_type', 'technical_intervention_request_id', 'intervention_type_id', 'intervention_type_index');
alter table technical_intervention_request_intervention_type add constraint technical_intervention_request_intervention_type_pkey primary key (technical_intervention_request_id, intervention_type_index);

alter table individual add column home_folder_index int4;
select init_hibernate_list_index('individual', 'home_folder_id', 'id', 'home_folder_index');
ALTER TABLE individual ADD constraint "home_folder_index_key" unique (home_folder_id, home_folder_index);

-- paph requests (drop / create <= no production data)
alter table domestic_help_request drop constraint FK3C0081121C4A2C9A;
alter table domestic_help_request drop constraint FK3C008112A2B2928B;
alter table domestic_help_request drop constraint FK3C008112B3BAD17C;
alter table domestic_help_request drop constraint FK3C0081126FFC52CB;
alter table domestic_help_request drop constraint FK3C008112ED1B9492;
drop table dhr_donation;
drop table dhr_personal_estate_and_saving;
drop table dhr_previous_dwelling;
drop table dhr_real_asset;
drop table domestic_help_request;

alter table remote_support_request drop constraint FKEAA6DC26ED1B9492;
drop table remote_support_request;

alter table handicap_allowance_request drop constraint FKF20630A16D27AFFE;
alter table handicap_allowance_request drop constraint FKF20630A1ED1B9492;
drop table handicap_allowance_request;
delete from forms where request_type_id=(select id from request_type where label='Handicap Allowance');
delete from request where request_type_id = (select id from request_type where label='Handicap Allowance');
delete from requirement where request_type_id = (select id from request_type where label = 'Handicap Allowance');
delete from request_type where id=(select id from request_type where label='Handicap Allowance');

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

/*********************************************
  *                                       *
  *           DOCUMENT BINARY             *
  *                                       *
**********************************************/  
ALTER TABLE document_binary DROP COLUMN page_number;
ALTER TABLE document_binary ADD COLUMN document_binary_index int4;
select init_hibernate_list_index('document_binary', 'document_id', 'id', 'document_binary_index');
ALTER TABLE document_binary ADD CONSTRAINT "document_binary_index_key" UNIQUE (document_id, document_binary_index);


DROP function init_hibernate_list_index(text,text,text,text);

-- end of migration to indexed lists in requests collections elements

-- agents preferences enhancements
ALTER TABLE agent ADD COLUMN preferences bytea;        

-- draft requests
ALTER TABLE request ADD COLUMN draft bool;
UPDATE request SET draft = false WHERE draft IS NULL;
ALTER TABLE request ALTER COLUMN draft SET NOT NULL;
ALTER TABLE request ALTER COLUMN draft SET DEFAULT false;

--local authority initial draft configuration 
ALTER TABLE local_authority ADD COLUMN draft_live_duration int4;
ALTER TABLE local_authority ADD COLUMN draft_notification_before_delete int4;

UPDATE local_authority 
SET
  draft_live_duration = 20,
  draft_notification_before_delete = 7;

ALTER TABLE local_authority ALTER COLUMN draft_live_duration SET NOT NULL;
ALTER TABLE local_authority ALTER COLUMN draft_notification_before_delete SET NOT NULL;

-- stepState support in requests
ALTER TABLE request ADD COLUMN step_states bytea;


/*********************************************
  *                                       *
  *             DISPLAY GROUP             *
  *                                       *
**********************************************/  
CREATE TABLE display_group (
    id int8 NOT NULL,
    name VARCHAR(255),
    label VARCHAR(255),
    PRIMARY KEY (id) 
);

ALTER TABLE request_type ADD COLUMN display_group_id int8;
ALTER TABLE request_type ADD CONSTRAINT FK4DAE96EA1D0DF06 FOREIGN KEY (
  display_group_id) REFERENCES display_group;

-- update to Birth and Death Details request
alter table birth_details_request add column birth_marriage_name varchar(38);

-- assets configuration
alter table local_authority add column display_title varchar(100);
update local_authority set display_title=name;
alter table local_authority alter column display_title set not null;

alter table local_authority add column server_names bytea;

alter table local_authority add column requests_creation_notification_enabled bool;
update local_authority set requests_creation_notification_enabled=false;
alter table local_authority alter column requests_creation_notification_enabled set not null;

alter table local_authority add column document_digitalization_enabled bool;
update local_authority set document_digitalization_enabled=true;
alter table local_authority alter column document_digitalization_enabled set not null;

alter table local_authority add column instruction_alerts_enabled bool;
update local_authority set instruction_alerts_enabled=false;
alter table local_authority alter column instruction_alerts_enabled set not null;

alter table local_authority add column instruction_alerts_detailed bool;
update local_authority set instruction_alerts_detailed=false;
alter table local_authority alter column instruction_alerts_detailed set not null;

alter table local_authority add column instruction_default_max_delay int4;
update local_authority set instruction_default_max_delay=10;
alter table local_authority alter column instruction_default_max_delay set not null;

alter table local_authority add column instruction_default_alert_delay int4;
update local_authority set instruction_default_alert_delay=3;
alter table local_authority alter column instruction_default_alert_delay set not null;

alter table local_authority add column admin_email varchar(255);

alter table technical_intervention_request add column other_intervention_label varchar(255);

-- update to electoral roll registration request
UPDATE electoral_roll_registration_request SET subject_nationality='French' WHERE subject_nationality='FR';
UPDATE electoral_roll_registration_request SET subject_nationality='EuropeanUnion' WHERE subject_nationality='EEC';
UPDATE electoral_roll_registration_request SET subject_nationality='OutsideEuropeanUnion' WHERE subject_nationality='OUTSIDE_EEC';

-- update to sms notification request
alter table sms_notification_request add column mobile_phone varchar(10);

-- update to perischool activity registration request
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
    
alter table perischool_authorized_individual 
  add constraint FKEE33EA1E96225F9E 
  foreign key (perischool_activity_registration_request_id) 
  references perischool_activity_registration_request;

alter table perischool_authorized_individual 
  add constraint FKEE33EA1EB7531222 
  foreign key (address_id) 
  references address;

alter table perischool_contact_individual 
  add constraint FK5B659D5796225F9E 
  foreign key (perischool_activity_registration_request_id) 
  references perischool_activity_registration_request;

alter table perischool_contact_individual 
  add constraint FK5B659D57B7531222 
  foreign key (address_id) 
  references address;
        
-- update to recreation activity registration request
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
    
alter table recreation_authorized_individual 
  add constraint FK5BA62550B7531222 
  foreign key (address_id) 
  references address;

alter table recreation_authorized_individual 
  add constraint FK5BA625504C4C853A 
  foreign key (recreation_activity_registration_request_id) 
  references recreation_activity_registration_request;

alter table recreation_contact_individual 
  add constraint FK52B67F65B7531222 
  foreign key (address_id) 
  references address;

alter table recreation_contact_individual 
  add constraint FK52B67F654C4C853A 
  foreign key (recreation_activity_registration_request_id) 
  references recreation_activity_registration_request; 

drop table personal_details_request;
delete from request_note where request_id in (select id from request where request_type_id = (select id from request_type where label='Personal Details'));
delete from request_document where request_id in (select id from request where request_type_id = (select id from request_type where label='Personal Details'));
delete from request_action where request_id in (select id from request where request_type_id = (select id from request_type where label='Personal Details'));
delete from forms where request_type_id=(select id from request_type where label='Personal Details');
delete from request where request_type_id = (select id from request_type where label='Personal Details');
delete from requirement where request_type_id = (select id from request_type where label = 'Personal Details');
delete from request_type where id=(select id from request_type where label='Personal Details');

create table alignment_numbering_connection_request (
  id int8 not null,
  is_numbering bool,
  other_address_id int8,
  owner_first_names varchar(255),
  number bytea,
  area bytea,
  more_than_two_years bool,
  owner_address_id int8,
  requester_quality varchar(255),
  section varchar(255),
  transportation_route varchar(255),
  locality varchar(255),
  is_connection bool,
  is_account_address bool,
  is_alignment bool,
  owner_last_name varchar(38),
  primary key (id)
);

alter table alignment_numbering_connection_request 
  add constraint FKEBD1311082587E99 
  foreign key (id) 
  references request;

alter table alignment_numbering_connection_request 
  add constraint FKEBD131101F88D72E 
  foreign key (owner_address_id) 
  references address;

alter table alignment_numbering_connection_request 
  add constraint FKEBD13110C6C3DEB1 
  foreign key (other_address_id) 
  references address;
  
-- update individual_role (to enable hibernate merge)
alter table individual_role add column individual_name varchar(255);

create table study_grant_request (
  id int8 not null,
  abroad_internship_end_date timestamp,
  has_europe_help bool,
  current_studies varchar(255),
  current_studies_level varchar(255),
  current_school_postal_code varchar(5),
  abroad_internship_start_date timestamp,
  tax_household_first_name varchar(38),
  alevels_date varchar(4),
  bank_code varchar(5),
  subject_birth_date timestamp,
  counter_code varchar(5),
  current_school_city varchar(32),
  has_c_r_o_u_s_help bool,
  subject_email varchar(255),
  current_school_name varchar(255),
  sandwich_courses bool,
  abroad_internship_school_country varchar(255),
  tax_household_city varchar(32),
  abroad_internship bool,
  tax_household_last_name varchar(38),
  account_number varchar(11),
  distance varchar(255),
  alevels varchar(255),
  tax_household_postal_code varchar(5),
  subject_mobile_phone varchar(10),
  abroad_internship_school_name varchar(255),
  account_key varchar(2),
  other_studies_label varchar(255),
  has_regional_council_help bool,
  tax_household_income float8,
  has_other_help bool,
  subject_address_id int8,
  current_school_country varchar(255),
  subject_phone varchar(10),
  primary key (id)
);

alter table study_grant_request 
  add constraint FK7D2F0A7682587E99 
  foreign key (id) 
  references request;

alter table study_grant_request 
  add constraint FK7D2F0A7687B85F15 
  foreign key (subject_address_id) 
  references address;

alter table study_grant_request add column subject_first_request bool;

alter table study_grant_request add column edemande_id varchar(255);

alter table request_note rename column agent_id to user_id;
alter table request rename column last_intervening_agent_id to last_intervening_user_id;

alter table request_note add column date timestamp;

update request_note set type = 'Internal' where type like '%Internal';
update request_note set type = 'Public' where type like '%External' or type like 'Default%';

-- study grant refectoring 5
alter table study_grant_request drop column current_school_name;
alter table study_grant_request drop column tax_household_city;

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

alter table study_grant_request_current_school_name 
    add constraint FK49484F67C1B15A77 
    foreign key (study_grant_request_id) 
    references study_grant_request;

alter table study_grant_request_current_school_name 
    add constraint FK49484F674E42238A 
    foreign key (current_school_name_id) 
    references local_referential_data;

alter table study_grant_request_tax_household_city 
    add constraint FK1B568948A40092FB 
    foreign key (tax_household_city_id) 
    references local_referential_data;

alter table study_grant_request_tax_household_city 
    add constraint FK1B568948C1B15A77 
    foreign key (study_grant_request_id) 
    references study_grant_request;

alter table study_grant_request drop column tax_household_postal_code;
alter table study_grant_request add column tax_household_city_precision varchar(255);
alter table study_grant_request add column current_school_name_precision  varchar(255);
alter table study_grant_request add column is_subject_account_holder bool;
alter table study_grant_request add column account_holder_birth_date timestamp;
alter table study_grant_request add column account_holder_last_name  varchar(38);
alter table study_grant_request add column account_holder_title varchar(255);
alter table study_grant_request add column account_holder_first_name  varchar(38);


alter table external_service_traces alter column key type character varying(255);

update request_type set label = 'VO Card' where label = 'VO Card Request';

alter table study_grant_request add column account_holder_edemande_id varchar(255);

alter table external_service_traces add column subkey varchar(255);
update external_service_traces set subkey = 'subject' where message like '%tiers%';

alter table local_authority add column payment_deactivation_start_date timestamp;
alter table local_authority add column payment_deactivation_end_date timestamp;

alter table local_authority add column display_in_progress_payments bool not null default false;

-- remove card data
alter table individual drop constraint FKFD3DA29948B0ABD2;
drop table card;

alter table request_note alter column note type varchar(1024);

UPDATE request_form set template_name = substring(template_name from 1 for position('.html' in template_name) - 1) ;
