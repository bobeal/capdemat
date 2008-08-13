-- tables for local referential data associated to requets
create table local_referential_data (
   id int8 not null,
   name varchar(255),
   priority int4,
   additional_information_label varchar(255),
   additional_information_value varchar(255),
   local_referential_parent_data_id int8,
   primary key (id)
);

create table local_referential_association (
   local_referential_parent_data_id int8 not null,
   local_referential_child_data_id int8 not null,
   primary key (local_referential_parent_data_id, local_referential_child_data_id)
);

alter table local_referential_data add constraint FK49407E74A496E985 foreign key (local_referential_parent_data_id) references local_referential_data;
alter table local_referential_association add constraint FK6B28F677A496E985 foreign key (local_referential_parent_data_id) references local_referential_data;
alter table local_referential_association add constraint FK6B28F67723B19E23 foreign key (local_referential_child_data_id) references local_referential_data;
ALTER TABLE local_referential_association OWNER TO cvq95;
ALTER TABLE local_referential_data OWNER TO cvq95;

-- music school registration request
create table music_school_registration_request (
   id int8 not null,
   end_date timestamp,
   rules_and_regulations_acceptance bool,
   subject_id int8,
   start_date timestamp,
   primary key (id)
);

create table music_school_registration_request_activity (
   music_school_registration_request_id int8 not null,
   activity_id int8 not null,
   primary key (music_school_registration_request_id, activity_id)
);

alter table music_school_registration_request add constraint FK51A399DADDCEFD0E foreign key (subject_id) references individual;
alter table music_school_registration_request add constraint FK51A399DAD1B foreign key (id) references request;
alter table music_school_registration_request_activity add constraint FK6393FFD46D6E51A0 foreign key (music_school_registration_request_id) references music_school_registration_request;
alter table music_school_registration_request_activity add constraint FK6393FFD4C953704B foreign key (activity_id) references local_referential_data;
ALTER TABLE music_school_registration_request OWNER TO cvq95;
ALTER TABLE music_school_registration_request_activity OWNER TO cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Music School Registration', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Music School Registration Request Certificat', 'musicSchoolRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Music School Registration Request Certificat' and request_type.label = 'Music School Registration';

-- migrate existing means of contact data
create table request_means_of_contact (
   request_id int8 not null,
   means_of_contact_id int8 not null,
   primary key (request_id, means_of_contact_id)
);

alter table request_means_of_contact add constraint FK72CB44F98FCF3BD1 foreign key (means_of_contact_id) references local_referential_data;
alter table request_means_of_contact add constraint FK72CB44F923640CB foreign key (request_id) references request;
ALTER TABLE request_means_of_contact OWNER TO cvq95;

CREATE OR REPLACE FUNCTION migrate_means_of_contact_data() RETURNS void AS $$
DECLARE
  myrec RECORD;
  ref_data_id integer;
BEGIN
  FOR myrec IN SELECT id, means_of_contact FROM request LOOP
    ref_data_id := nextval('hibernate_sequence');
    INSERT INTO local_referential_data (id, name) VALUES ( ref_data_id, myrec.means_of_contact);
    INSERT INTO request_means_of_contact (request_id, means_of_contact_id) VALUES ( myrec.id, ref_data_id);
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select migrate_means_of_contact_data();
alter table request drop column means_of_contact;

-- migrate local referential associated to school canteen registration requests
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

alter table school_canteen_registration_request_canteen_attending_days add constraint FK1323D9F985DAF0B1 foreign key (school_canteen_registration_request_id) references school_canteen_registration_request;
alter table school_canteen_registration_request_canteen_attending_days add constraint FK1323D9F9C994B577 foreign key (canteen_attending_days_id) references local_referential_data;

alter table school_canteen_registration_request_food_diet add constraint FK5768CADF65F5E665 foreign key (food_diet_id) references local_referential_data;
alter table school_canteen_registration_request_food_diet add constraint FK5768CADF85DAF0B1 foreign key (school_canteen_registration_request_id) references school_canteen_registration_request;

ALTER TABLE school_canteen_registration_request_canteen_attending_days OWNER TO cvq95;
ALTER TABLE school_canteen_registration_request_food_diet OWNER TO cvq95;

CREATE OR REPLACE FUNCTION migrate_food_diet_data() RETURNS void AS $$
DECLARE
  myrec RECORD;
  ref_data_id integer;
  current_food_diet text;
  count integer;
BEGIN
  FOR myrec IN SELECT id, food_diet FROM school_canteen_registration_request LOOP
    count := 1;
    WHILE split_part(myrec.food_diet, ' ', count) != '' LOOP
      current_food_diet := split_part(myrec.food_diet, ' ', count);
      ref_data_id := nextval('hibernate_sequence');
      INSERT INTO local_referential_data (id, name) VALUES ( ref_data_id, current_food_diet);
      INSERT INTO school_canteen_registration_request_food_diet (school_canteen_registration_request_id, food_diet_id) VALUES ( myrec.id, ref_data_id);
      count := count + 1;
    END LOOP;
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select migrate_food_diet_data();
alter table school_canteen_registration_request drop column food_diet;

CREATE OR REPLACE FUNCTION migrate_canteen_attending_days_data() RETURNS void AS $$
DECLARE
  myrec RECORD;
  ref_data_id integer;
  current_canteen_attending_days text;
  count integer;
BEGIN
  FOR myrec IN SELECT id, canteen_attending_days FROM school_canteen_registration_request LOOP
    count := 1;
    WHILE split_part(myrec.canteen_attending_days, ' ', count) != '' LOOP
      current_canteen_attending_days := split_part(myrec.canteen_attending_days, ' ', count);
      ref_data_id := nextval('hibernate_sequence');
      INSERT INTO local_referential_data (id, name) VALUES ( ref_data_id, current_canteen_attending_days);
      INSERT INTO school_canteen_registration_request_canteen_attending_days (school_canteen_registration_request_id, canteen_attending_days_id) VALUES ( myrec.id, ref_data_id);
      count := count + 1;
    END LOOP;
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select migrate_canteen_attending_days_data();
alter table school_canteen_registration_request drop column canteen_attending_days;

-- migrate local referential associated to perischool activity registration requests
create table perischool_activity_registration_request_perischool_activity (
   perischool_activity_registration_request_id int8 not null,
   perischool_activity_id int8 not null,
   primary key (perischool_activity_registration_request_id, perischool_activity_id)
);

alter table perischool_activity_registration_request_perischool_activity add constraint FK2007A4E99F1DABEC foreign key (perischool_activity_id) references local_referential_data;
alter table perischool_activity_registration_request_perischool_activity add constraint FK2007A4E9A24EADE0 foreign key (perischool_activity_registration_request_id) references perischool_activity_registration_request;
ALTER TABLE perischool_activity_registration_request_perischool_activity OWNER TO cvq95;

CREATE OR REPLACE FUNCTION migrate_perischool_activity_data() RETURNS void AS $$
DECLARE
  myrec RECORD;
  ref_data_id integer;
  current_perischool_activity text;
  count integer;
BEGIN
  FOR myrec IN SELECT id, perischool_activity FROM perischool_activity_registration_request LOOP
    count := 1;
    WHILE split_part(myrec.perischool_activity, ' ', count) != '' LOOP
      current_perischool_activity := split_part(myrec.perischool_activity, ' ', count);
      ref_data_id := nextval('hibernate_sequence');
      INSERT INTO local_referential_data (id, name) VALUES ( ref_data_id, current_perischool_activity);
      INSERT INTO perischool_activity_registration_request_perischool_activity (perischool_activity_registration_request_id, perischool_activity_id) VALUES ( myrec.id, ref_data_id);
      count := count + 1;
    END LOOP;
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select migrate_perischool_activity_data();
alter table perischool_activity_registration_request drop column perischool_activity;

-- migrate local referential data associated to library registration request
create table library_registration_request_subscription (
   library_registration_request_id int8 not null,
   subscription_id int8 not null,
   primary key (library_registration_request_id, subscription_id)
);

alter table library_registration_request_subscription add constraint FK56C4BE0F1188988D foreign key (library_registration_request_id) references library_registration_request;
alter table library_registration_request_subscription add constraint FK56C4BE0FAC6DA77D foreign key (subscription_id) references local_referential_data;
ALTER TABLE library_registration_request_subscription OWNER TO cvq95;

CREATE OR REPLACE FUNCTION migrate_library_registration_subscription_data() RETURNS void AS $$
DECLARE
  myrec RECORD;
  ref_data_id integer;
BEGIN
  FOR myrec IN SELECT id, subscription FROM library_registration_request LOOP
    ref_data_id := nextval('hibernate_sequence');
    INSERT INTO local_referential_data (id, name) VALUES ( ref_data_id, myrec.subscription);
    INSERT INTO library_registration_request_subscription (library_registration_request_id, subscription_id) VALUES ( myrec.id, ref_data_id);
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select migrate_library_registration_subscription_data();
alter table library_registration_request drop column subscription;

-- delete migration functions
drop function migrate_canteen_attending_days_data();
drop function migrate_food_diet_data();
drop function migrate_library_registration_subscription_data();
drop function migrate_means_of_contact_data();
drop function migrate_perischool_activity_data();

-- add limited lifecycle home folders
alter table home_folder add column bound_to_request bool;
update home_folder set bound_to_request = false;

alter table home_folder add column origin_request_id int8;
-- update existing home folders with id of their VO Card request
update home_folder set origin_request_id = (select vo_card_request.id from vo_card_request, request where vo_card_request.id = request.id and request.home_folder_id = home_folder.id);

-- migrate contact and pickup persons from other_individual
update other_individual set type = 'ContactPerson' where type = 'Contact Person';
update other_individual set type = 'PickupPerson' where type = 'Pickup Person';

