--
-- Correction script : for initialization of new hibernate list index column
--

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

select init_hibernate_list_index('bulky_waste_collection_request_bulky_waste_type', 'bulky_waste_collection_request_id', 'bulky_waste_type_id', 'bulky_waste_type_index');
alter table bulky_waste_collection_request_bulky_waste_type add constraint bulky_waste_collection_request_bulky_waste_type_pkey primary key (bulky_waste_collection_request_id, bulky_waste_type_index);

select init_hibernate_list_index('compostable_waste_collection_request_compostable_waste_type', 'compostable_waste_collection_request_id', 'compostable_waste_type_id', 'compostable_waste_type_index');
-- truncate primary key
alter table compostable_waste_collection_request_compostable_waste_type add constraint compostable_waste_collection_request_compostable_waste_typ_pkey primary key (compostable_waste_collection_request_id, compostable_waste_type_index);
 
select init_hibernate_list_index('library_registration_request_subscription', 'library_registration_request_id', 'subscription_id', 'subscription_index');
alter table library_registration_request_subscription add constraint library_registration_request_subscription_pkey primary key (library_registration_request_id, subscription_index); 

select init_hibernate_list_index('music_school_registration_request_activity', 'music_school_registration_request_id', 'activity_id', 'activity_index');
alter table music_school_registration_request_activity add constraint music_school_registration_request_activity_pkey primary key (music_school_registration_request_id, activity_index);
     
select init_hibernate_list_index('perischool_activity_registration_request_other_individual', 'perischool_activity_registration_request_id', 'other_individual_id', 'other_individual_index');
alter table perischool_activity_registration_request_other_individual add constraint perischool_activity_registration_request_other_individual_pkey primary key (perischool_activity_registration_request_id, other_individual_index);
     
select init_hibernate_list_index('perischool_activity_registration_request_perischool_activity', 'perischool_activity_registration_request_id', 'perischool_activity_id', 'perischool_activity_index');
-- truncate primary key
alter table perischool_activity_registration_request_perischool_activity add constraint perischool_activity_registration_request_perischool_activi_pkey primary key (perischool_activity_registration_request_id, perischool_activity_index);

select init_hibernate_list_index('place_reservation_request_place_reservation', 'place_reservation_request_id', 'place_reservation_id', 'place_reservation_index');
alter table place_reservation_request_place_reservation add constraint place_reservation_request_place_reservation_pkey primary key (place_reservation_request_id, place_reservation_index);

select init_hibernate_list_index('recreation_activity_registration_request_other_individual', 'recreation_activity_registration_request_id', 'other_individual_id', 'other_individual_index');
alter table recreation_activity_registration_request_other_individual add constraint recreation_activity_registration_request_other_individual_pkey primary key (recreation_activity_registration_request_id, other_individual_index);
     
select init_hibernate_list_index('recreation_activity_registration_request_recreation_activity', 'recreation_activity_registration_request_id', 'recreation_activity_id', 'recreation_activity_index');
-- truncate primary key
alter table recreation_activity_registration_request_recreation_activity add constraint recreation_activity_registration_request_recreation_activi_pkey primary key (recreation_activity_registration_request_id, recreation_activity_index); 

select init_hibernate_list_index('school_canteen_registration_request_canteen_attending_days', 'school_canteen_registration_request_id', 'canteen_attending_days_id', 'canteen_attending_days_index');
alter table school_canteen_registration_request_canteen_attending_days add constraint school_canteen_registration_request_canteen_attending_days_pkey primary key (school_canteen_registration_request_id, canteen_attending_days_index);

select init_hibernate_list_index('school_canteen_registration_request_food_diet', 'school_canteen_registration_request_id', 'food_diet_id', 'food_diet_index');
alter table school_canteen_registration_request_food_diet add constraint school_canteen_registration_request_food_diet_pkey primary key (school_canteen_registration_request_id, food_diet_index);

select init_hibernate_list_index('sms_notification_request_interests', 'sms_notification_request_id', 'interests_id', 'interests_index');
alter table sms_notification_request_interests add constraint sms_notification_request_interests_pkey primary key (sms_notification_request_id, interests_index);

select init_hibernate_list_index('technical_intervention_request_intervention_type', 'technical_intervention_request_id', 'intervention_type_id', 'intervention_type_index');
alter table technical_intervention_request_intervention_type add constraint technical_intervention_request_intervention_type_pkey primary key (technical_intervention_request_id, intervention_type_index);

DROP function init_hibernate_list_index(text,text,text,text);
