-- remove nationality column from individual table
alter table individual drop column nationality;

-- remove ssn-related columns from adult table
alter table adult drop column ssn;
alter table adult drop column ssn_key;

-- change urgency_phone from 32 to 10 ?
alter table child_registration add column urgency_phone_temp varchar(10);
update child_registration set urgency_phone_temp = urgency_phone;
alter table child_registration drop column urgency_phone;
alter table child_registration rename column urgency_phone_temp to urgency_phone;

-- change doctor_phone from 32 to 10
alter table school_canteen_registration add column doctor_phone_temp varchar(10);
update school_canteen_registration set doctor_phone_temp = doctor_phone;
alter table school_canteen_registration drop column doctor_phone;
alter table school_canteen_registration rename column doctor_phone_temp to doctor_phone;

-- rename adress to address in other_individual
alter table other_individual rename column adress to address;

-- migrate data from school_canteen_registration and child_registration
-- to school_canteen_registration_request
create table school_canteen_registration_request as (
	select request.id, 
	       child_registration.urgency_phone,
	       child_registration.start_date, 
	       child_registration.end_date,
	       child_registration.child_id,
	       school_canteen_registration.eat_monday,
	       school_canteen_registration.eat_tuesday,
	       school_canteen_registration.eat_wednesday,
	       school_canteen_registration.eat_thursday,
	       school_canteen_registration.eat_friday,
	       school_canteen_registration.food_allergy,
	       school_canteen_registration.eat_pork,
	       school_canteen_registration.eat_soy,
	       school_canteen_registration.eat_milk,
	       school_canteen_registration.eat_salt,
	       school_canteen_registration.eat_sugar,
	       school_canteen_registration.hospitalization_permission,
	       school_canteen_registration.rules_and_regulations_acceptance,
	       school_canteen_registration.doctor_name,
	       school_canteen_registration.doctor_phone,
	       school_canteen_registration.current_class as section,
	       school_canteen_registration.school_id
	where request.id = child_registration_request.id
	and child_registration_request.child_registration_id = child_registration.id
	and child_registration.id = school_canteen_registration.id);

-- add primary key and constraints on new table
alter table school_canteen_registration_request add primary key (id);
alter table school_canteen_registration_request add constraint FKDC4CBC69812F1C6 foreign key (school_id) references school;
alter table school_canteen_registration_request add constraint FKDC4CBC6962EA171E foreign key (child_id) references child;
alter table school_canteen_registration_request add constraint FKDC4CBC69D1B foreign key (id) references request;

-- update section to "official" enum values
update school_canteen_registration_request set section = 'First Section' where section = 'Petite section maternelle';
update school_canteen_registration_request set section = 'Second Section' where section = 'Moyenne section maternelle';
update school_canteen_registration_request set section = 'Third Section' where section = 'Grande section maternelle';

-- then drop obsolete school_canteen_registration
drop table school_canteen_registration;

-- migrate data from school_registration and child_registration
-- to school_registration_request
create table school_registration_request as (
	select request.id, 
	       child_registration.urgency_phone,
	       child_registration.start_date, 
	       child_registration.end_date,
	       child_registration.child_id,
	       school_registration.current_school_name,
	       school_registration.current_school_address,
	       school_registration.section,
	       school_registration.school_id
	where request.id = child_registration_request.id
	and child_registration_request.child_registration_id = child_registration.id
	and child_registration.id = school_registration.id);

-- add primary key and constraints on new table
alter table school_registration_request add primary key (id);
alter table school_registration_request add constraint FK7BDFE8F4812F1C6 foreign key (school_id) references school;
alter table school_registration_request add constraint FK7BDFE8F4D1B foreign key (id) references request;
alter table school_registration_request add constraint FK7BDFE8F462EA171E foreign key (child_id) references child;

-- add a column for current section and drop unvaluable current_class column
alter table school_registration_request add column current_section varchar(32);
-- alter table school_registration_request drop column current_class;

-- then drop obsolete school_registration
drop table school_registration;

-- rename rules_and_regulations_knowledge to rules_and_regulations_acceptance 
-- in perischool_activity_registration
alter table perischool_activity_registration rename column rules_and_regulations_knowledge to rules_and_regulations_acceptance;

-- then migrate data from perischool_activity_registration and child_registration
-- to perischool_activity_registration_request
create table perischool_activity_registration_request as (
	select request.id, 
	       child_registration.urgency_phone,
	       child_registration.start_date, 
	       child_registration.end_date,
	       child_registration.child_id,
	       perischool_activity_registration.class_trip_permission,
	       perischool_activity_registration.hospitalization_permission,
	       perischool_activity_registration.rules_and_regulations_acceptance,
	       perischool_activity_registration.child_photo_exploitation_permission
	where request.id = child_registration_request.id
	and child_registration_request.child_registration_id = child_registration.id
	and child_registration.id = perischool_activity_registration.id);

-- add primary key and constraints on new table
alter table perischool_activity_registration_request add primary key (id);
alter table perischool_activity_registration_request add constraint FK76BAA59A62EA171E foreign key (child_id) references child;
alter table perischool_activity_registration_request add constraint FK76BAA59AD1B foreign key (id) references request;

-- migrate data in association table between perischool_activity_registration
-- and perischool_activity
alter table perischool_activity_registration_map rename to perischool_activity_registration_request_perischool_activity;
-- FIXME : will the constraint name be the same in each database ?
alter table perischool_activity_registration_request_perischool_activity drop constraint fk35be95e7e768a261;
alter table perischool_activity_registration_request_perischool_activity rename column registration_id to perischool_activity_registration_request_id;
-- migration old registrations id to new requests id
update perischool_activity_registration_request_perischool_activity set perischool_activity_registration_request_id = perischool_activity_registration_request.id where perischool_activity_registration_request_id = perischool_activity_registration.id and perischool_activity_registration.id = child_registration_request.child_registration_id and child_registration_request.id = perischool_activity_registration_request.id;
alter table perischool_activity_registration_request_perischool_activity add constraint FK2007A4E9A24EADE0 foreign key (perischool_activity_registration_request_id) references perischool_activity_registration_request;
-- rename primary key constraint to be homogenous with our naming conventions
alter table perischool_activity_registration_request_perischool_activity drop constraint perischool_activity_registration_map_pkey;
alter table perischool_activity_registration_request_perischool_activity add primary key (perischool_activity_registration_request_id, perischool_activity_id);

-- create association table with other individuals
create table perischool_activity_registration_request_other_individual as (
	select child_registration.child_registration_request_id as perischool_activity_registration_request_id,
	       other_individual.id as other_individual_id
	where other_individual.child_registration_id = child_registration.id
	and child_registration.child_registration_request_id = perischool_activity_registration_request.id);

-- add primary keys and constraints
alter table perischool_activity_registration_request_other_individual add primary key (perischool_activity_registration_request_id, other_individual_id);
alter table perischool_activity_registration_request_other_individual add constraint FKD6BDD32DBF1AD192 foreign key (other_individual_id) references other_individual;
alter table perischool_activity_registration_request_other_individual add constraint FKD6BDD32DA24EADE0 foreign key (perischool_activity_registration_request_id) references perischool_activity_registration_request;

-- then drop obsolete perischool_activity_registration
drop table perischool_activity_registration;

-- as we don't have any vacations registrations yet, simply create the new tables
-- and drop the old ones
create table vacations_registration_request (
   id int8 not null,
   end_date timestamp,
   urgency_phone varchar(10),
   child_id int8,
   start_date timestamp,
   recreation_center_id int8,
   vacations_id int8,
   primary key (id)
);

alter table vacations_registration_request add constraint FK92F49872D1B foreign key (id) references request;
alter table vacations_registration_request add constraint FK92F49872250324C4 foreign key (vacations_id) references vacations;
alter table vacations_registration_request add constraint FK92F4987262EA171E foreign key (child_id) references child;

create table vacations_registration_request_other_individual (
   vacations_registration_request_id int8 not null,
   other_individual_id int8 not null,
   primary key (vacations_registration_request_id, other_individual_id)
);

alter table vacations_registration_request_other_individual add constraint FK567CEB55BF1AD192 foreign key (other_individual_id) references other_individual;
alter table vacations_registration_request_other_individual add constraint FK567CEB555DD9AC08 foreign key (vacations_registration_request_id) references vacations_registration_request;

drop table vacations_registration cascade;

drop table vacations_diary;
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

-- remove dimension from vacations ?
alter table vacations drop column dimension;

-- update other_individual to the new way of referencing it
alter table other_individual drop constraint fkcae6f286038353e;
alter table other_individual drop column child_registration_id;

-- finally remove now unuseful child_registration and child_registration_request
-- tables
drop table child_registration cascade;
drop table child_registration_request cascade;

-- add a column to store path to XSL-FO files
alter table request_form add column xsl_fo_filename varchar(255);

-- add XSL-FO for school canteen registration request
insert into request_form (id, type, file, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'School Canteen Registration Request Certificat', NULL, 'schoolCanteenRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'School Canteen Registration Request Certificat' and request_type.label = 'School Restaurant Registration';

-- update data for existing XSL-FO files
update request_form set xsl_fo_filename = 'voCardRequest.xsl' where type = 'VO Card Request Certificat';
update request_form set xsl_fo_filename = 'voCardRequest.xsl' where type = 'Home Folder Modification Request Certificat';

-- finally remove now unused file column
alter table request_form drop column file;

-- remove unused identifier column on request types
alter table request_type drop column identifier;

-- uniform request type naming
update request_type set label = 'School Canteen Registration' where label = 'School Restaurant Registration';

-- local referential migration
alter table school_canteen_registration_request add column food_diet varchar(255);

CREATE OR REPLACE FUNCTION migrate_food_diet(boolean, boolean, boolean, boolean, boolean) RETURNS varchar AS $$
DECLARE
  -- declarations
  food_diet varchar(255) := '';

  eat_pork alias for $1;
  eat_milk alias for $2;
  eat_soy alias for $3;
  eat_salt alias for $4;
  eat_sugar alias for $5;
BEGIN
  IF $1 THEN food_diet := food_diet || 'EatPork ';
  END IF;
  IF $2 THEN food_diet := food_diet || 'EatMilk ';
  END IF;
  IF $3 THEN food_diet := food_diet || 'EatSoy ';
  END IF;
  IF $4 THEN food_diet := food_diet || 'EatSalt ';
  END IF;
  IF $5 THEN food_diet := food_diet || 'EatSugar ';
  END IF;
  RETURN food_diet;
END;
$$ LANGUAGE plpgsql;

update school_canteen_registration_request set food_diet = migrate_food_diet(eat_pork, eat_milk, eat_soy, eat_salt, eat_sugar);

alter table school_canteen_registration_request drop column eat_pork;
alter table school_canteen_registration_request drop column eat_milk;
alter table school_canteen_registration_request drop column eat_soy;
alter table school_canteen_registration_request drop column eat_salt;
alter table school_canteen_registration_request drop column eat_sugar;

-- archive all existing perischool activity registration requests
update request set state = 'Archived' where request.id = school_canteen_registration_request.id;

alter table perischool_activity_registration_request add column perischool_activity varchar(255);
drop table perischool_activity_registration_request_perischool_activity;
drop table perischool_activity;

-- add XSL-FO for perischool activity registration request
insert into request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'Perischool Activity Registration Request Certificat', 'perischoolActivityRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Perischool Activity Registration Request Certificat' and request_type.label = 'Perischool Activity Registration';

alter table request add column data_state varchar(16);
update request set data_state = 'Pending' where state = 'Pending' or state = 'Uncomplete' or state = 'Rejected' or state = 'Cancelled';
update request set data_state = 'Valid' where state = 'Complete' or state = 'Validated' or state = 'Notified' or state = 'Closed' or state = 'Archived';
alter table request alter column data_state set not null;


-- add XSL-FO for schoo registration request
insert into request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'School Registration Request Certificat', 'schoolRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'School Registration Request Certificat' and request_type.label = 'School Registration';
