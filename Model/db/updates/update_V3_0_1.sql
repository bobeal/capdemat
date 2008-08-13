-- local referential migration
alter table school_canteen_registration_request add column canteen_attending_days varchar(255);

CREATE OR REPLACE FUNCTION migrate_canteen_attending_days(boolean, boolean, boolean, boolean, boolean) RETURNS varchar AS $$
DECLARE
  -- declarations
  canteen_attending_days varchar(255) := '';

  eat_monday alias for $1;
  eat_tuesday alias for $2;
  eat_wednesday alias for $3;
  eat_thursday alias for $4;
  eat_friday alias for $5;
BEGIN
  IF $1 THEN canteen_attending_days := canteen_attending_days || 'Monday ';
  END IF;
  IF $2 THEN canteen_attending_days := canteen_attending_days || 'Tuesday ';
  END IF;
  IF $3 THEN canteen_attending_days := canteen_attending_days || 'Wednesday ';
  END IF;
  IF $4 THEN canteen_attending_days := canteen_attending_days || 'Thursday ';
  END IF;
  IF $5 THEN canteen_attending_days := canteen_attending_days || 'Friday ';
  END IF;
  RETURN canteen_attending_days;
END;
$$ LANGUAGE plpgsql;

update school_canteen_registration_request set canteen_attending_days = migrate_canteen_attending_days(eat_monday, eat_tuesday, eat_wednesday, eat_thursday, eat_friday);

-- update means of contact keys (no whitespace)
update request set means_of_contact = 'HomePhone' where means_of_contact = 'Home Phone';
update request set means_of_contact = 'MobilePhone' where means_of_contact = 'Mobile Phone';
update request set means_of_contact = 'OfficePhone' where means_of_contact = 'Office Phone';

-- update section keys (no whitespace)
update school_canteen_registration_request set section = 'FirstSection' where section = 'First Section';
update school_canteen_registration_request set section = 'SecondSection' where section = 'Second Section';
update school_canteen_registration_request set section = 'ThirdSection' where section = 'Third Section';
update school_registration_request set section = 'FirstSection' where section = 'First Section';
update school_registration_request set section = 'SecondSection' where section = 'Second Section';
update school_registration_request set section = 'ThirdSection' where section = 'Third Section';
update school_registration_request set current_section = 'FirstSection' where current_section = 'First Section';
update school_registration_request set current_section = 'SecondSection' where current_section = 'Second Section';
update school_registration_request set current_section = 'ThirdSection' where current_section = 'Third Section';

-- update family status (no whitespace)
update adult set family_status = 'CommonLawMarriage' where family_status = 'Common Law Marriage';

-- yet another local referential migration
alter table vacations_registration_request drop column vacations_id;
alter table vacations_registration_request add column vacations varchar(255);
drop table vacations;

-- add table for personal details request
create table personal_details_request (
   id int8 not null,
   birth_first_names varchar(255),
   birth_last_name varchar(38),
   death_first_names varchar(255),
   relationship varchar(255),
   marriage_postal_code varchar(5),
   precision varchar(255),
   birth_postal_code varchar(5),
   quality varchar(255),
   death_date timestamp,
   birth_date timestamp,
   death_postal_code varchar(5),
   marriage_wife_first_names varchar(255),
   marriage_wife_last_name varchar(38),
   marriage_husband_last_name varchar(38),
   father_first_names varchar(255),
   format varchar(255),
   copies bytea,
   mother_first_names varchar(255),
   certificate varchar(255),
   marriage_city varchar(32),
   usage varchar(255),
   father_last_name varchar(38),
   birth_city varchar(32),
   death_city varchar(32),
   mother_maiden_name varchar(38),
   death_last_name varchar(38),
   marriage_date timestamp,
   marriage_husband_first_names varchar(255),
   primary key (id)
);
alter table personal_details_request add constraint FKDA412593D1B foreign key (id) references request;
alter table personal_details_request owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Personal Details', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Personal Details Request Certificat', 'personalDetailsRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Personal Details Request Certificat' and request_type.label = 'Personal Details';

-- migration from EatXXX to NoXXX
update school_canteen_registration_request set food_diet = replace(food_diet, 'Eat', 'No');

-- CNIL recommandation : remove company name and address
alter table adult drop column company_name;
alter table adult drop column company_adress;

-- add last intervening agent information
alter table request add column last_intervening_agent_id int8;
update request set last_intervening_agent_id = lastaction.agent_id from (select agent_id, request_id from request_action, agent where request_action.agent_id = agent.id order by date desc ) as lastaction where request.id = lastaction.request_id;

-- add rules and regulations acceptance field on school registrations
alter table school_registration_request add column rules_and_regulations_acceptance bool;
