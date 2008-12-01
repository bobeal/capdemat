-- request letter templates enhancements
alter table request_form add column personalized_data bytea ;
alter table request_form add column template_name varchar(255);

-- vacations registration request removal
drop table vacations_diary ;
drop table vacations_registration_request_other_individual ;
drop table vacations_registration_request ;
delete from requirement where request_type_id = (select id from request_type where label = 'Vacations Registration');
delete from request_type where label = 'Vacations Registration';

-- migration to indexed lists in requests collections elements

-- stgl specific drop contraint managment
create function stgl_constraint_drop() returns void as $$
  begin
    begin
      alter table bulky_waste_collection_request_bulky_waste_type drop constraint FK7E2C4DCBAEAD5FA0;
      alter table compostable_waste_collection_request_compostable_waste_type drop constraint FK765E424BAC577A08;
      alter table sms_notification_request_interests drop constraint FKCE60DA2B37C4119F; 
      exception when undefined_object then
    end;
    begin
      alter table bulky_waste_collection_request_bulky_waste_type drop constraint FK7E2C4DCBEAC2AB0F;
      alter table compostable_waste_collection_request_compostable_waste_type drop constraint FK765E424B4B0F61E3;
      alter table sms_notification_request_interests drop constraint FKCE60DA2BEE8163B9;
      exception when undefined_object then
    end;
    return;
  end;
$$ language plpgsql;
select stgl_constraint_drop();
drop function  stgl_constraint_drop();

alter table dhr_not_real_asset drop constraint FK2BA9F1EC66C81F29;
alter table dhr_real_asset drop constraint FK6AA7D98066C81F29;
alter table har_family_dependent drop constraint FK6EEA28CAE3200797;
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
alter table dhr_not_real_asset add constraint FK2BA9F1ECD6AE1BE8 foreign key (domestic_help_request_id) references domestic_help_request;
alter table dhr_real_asset add constraint FK6AA7D980D6AE1BE8 foreign key (domestic_help_request_id) references domestic_help_request;
alter table har_family_dependent add constraint FK6EEA28CAE5852A38 foreign key (handicap_allowance_request_id) references handicap_allowance_request;
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
CREATE FUNCTION init_hibernate_list_index(table_name text, id_col_name text, index_col_name text) RETURNS void AS $$
 DECLARE
    current_index integer := 0;
    current_rec record;
    select_cmd text := 'SELECT ' || quote_ident(id_col_name) || ' AS id'
                       || ' FROM ' || quote_ident(table_name);
    update_cmd text ;
  BEGIN
    FOR current_rec IN EXECUTE select_cmd LOOP
      update_cmd := 'UPDATE ' || quote_ident(table_name)
                    || ' SET ' || quote_ident(index_col_name) || ' = ' || current_index
                    || ' WHERE ' || quote_ident(id_col_name) || ' = ' || current_rec.id;
      EXECUTE update_cmd;
      current_index := current_index + 1;
    END LOOP;
    RETURN;
  END;
$$ LANGUAGE plpgsql;

alter table bulky_waste_collection_request_bulky_waste_type add column bulky_waste_type_index int4;
select init_hibernate_list_index('bulky_waste_collection_request_bulky_waste_type', 'bulky_waste_type_id', 'bulky_waste_type_index');
alter table bulky_waste_collection_request_bulky_waste_type add constraint bulky_waste_collection_request_bulky_waste_type_pkey primary key (bulky_waste_collection_request_id, bulky_waste_type_index);

alter table compostable_waste_collection_request_compostable_waste_type add column compostable_waste_type_index int4;
select init_hibernate_list_index('compostable_waste_collection_request_compostable_waste_type', 'compostable_waste_type_id', 'compostable_waste_type_index');
-- truncate primary key
alter table compostable_waste_collection_request_compostable_waste_type add constraint compostable_waste_collection_request_compostable_waste_typ_pkey primary key (compostable_waste_collection_request_id, compostable_waste_type_index);
     
alter table dhr_not_real_asset add column not_real_assets_index int4;

alter table dhr_real_asset add column real_assets_index int4;
 
alter table har_family_dependent add column family_dependents_index int4;
 
alter table library_registration_request_subscription add column subscription_index int4;
select init_hibernate_list_index('library_registration_request_subscription', 'subscription_id', 'subscription_index');
alter table library_registration_request_subscription add constraint library_registration_request_subscription_pkey primary key (library_registration_request_id, subscription_index); 

alter table music_school_registration_request_activity add column activity_index int4;
select init_hibernate_list_index('music_school_registration_request_activity', 'activity_id', 'activity_index');
alter table music_school_registration_request_activity add constraint music_school_registration_request_activity_pkey primary key (music_school_registration_request_id, activity_index);
     
alter table perischool_activity_registration_request_other_individual add other_individual_index int4;
select init_hibernate_list_index('perischool_activity_registration_request_other_individual', 'other_individual_id', 'other_individual_index');
alter table perischool_activity_registration_request_other_individual add constraint perischool_activity_registration_request_other_individual_pkey primary key (perischool_activity_registration_request_id, other_individual_index);
     
alter table perischool_activity_registration_request_perischool_activity add perischool_activity_index int4;
select init_hibernate_list_index('perischool_activity_registration_request_perischool_activity', 'perischool_activity_id', 'perischool_activity_index');
-- truncate primary key
alter table perischool_activity_registration_request_perischool_activity add constraint perischool_activity_registration_request_perischool_activi_pkey primary key (perischool_activity_registration_request_id, perischool_activity_index);

alter table place_reservation_request_place_reservation add column place_reservation_index int4;
select init_hibernate_list_index('place_reservation_request_place_reservation', 'place_reservation_id', 'place_reservation_index');
alter table place_reservation_request_place_reservation add constraint place_reservation_request_place_reservation_pkey primary key (place_reservation_request_id, place_reservation_index);

alter table recreation_activity_registration_request_other_individual add column other_individual_index int4;
select init_hibernate_list_index('recreation_activity_registration_request_other_individual', 'other_individual_id', 'other_individual_index');
alter table recreation_activity_registration_request_other_individual add constraint recreation_activity_registration_request_other_individual_pkey primary key (recreation_activity_registration_request_id, other_individual_index);
     
alter table recreation_activity_registration_request_recreation_activity add column recreation_activity_index int4;
select init_hibernate_list_index('recreation_activity_registration_request_recreation_activity', 'recreation_activity_id', 'recreation_activity_index');
-- truncate primary key
alter table recreation_activity_registration_request_recreation_activity add constraint recreation_activity_registration_request_recreation_activi_pkey primary key (recreation_activity_registration_request_id, recreation_activity_index); 

alter table school_canteen_registration_request_canteen_attending_days add column canteen_attending_days_index int4;
select init_hibernate_list_index('school_canteen_registration_request_canteen_attending_days', 'canteen_attending_days_id', 'canteen_attending_days_index');
alter table school_canteen_registration_request_canteen_attending_days add constraint school_canteen_registration_request_canteen_attending_days_pkey primary key (school_canteen_registration_request_id, canteen_attending_days_index);

alter table school_canteen_registration_request_food_diet add column food_diet_index int4;
select init_hibernate_list_index('school_canteen_registration_request_food_diet', 'food_diet_id', 'food_diet_index');
alter table school_canteen_registration_request_food_diet add constraint school_canteen_registration_request_food_diet_pkey primary key (school_canteen_registration_request_id, food_diet_index);

alter table sms_notification_request_interests add column interests_index int4;
select init_hibernate_list_index('sms_notification_request_interests', 'interests_id', 'interests_index');
alter table sms_notification_request_interests add constraint sms_notification_request_interests_pkey primary key (sms_notification_request_id, interests_index);

alter table technical_intervention_request_intervention_type add column intervention_type_index int4;
select init_hibernate_list_index('technical_intervention_request_intervention_type', 'intervention_type_id', 'intervention_type_index');
alter table technical_intervention_request_intervention_type add constraint technical_intervention_request_intervention_type_pkey primary key (technical_intervention_request_id, intervention_type_index);

alter table individual add column home_folder_index int4;
select init_hibernate_list_index('individual', 'id', 'home_folder_index');
ALTER TABLE individual ADD constraint "home_folder_index_key" unique (home_folder_id, home_folder_index);

DROP function init_hibernate_list_index(text,text,text);

-- agents preferences enhancements
ALTER TABLE agent ADD COLUMN preferences bytea;        


