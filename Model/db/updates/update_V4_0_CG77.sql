alter table study_grant_request 
  drop constraint FK7D2F0A7682587E99;

alter table study_grant_request 
  drop constraint FK7D2F0A7687B85F15;

drop table study_grant_request;

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

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'school' LIMIT 1)
WHERE label = 'Study Grant';


-- optional cleanup instructions : old label
DELETE FROM forms where request_type_id = (select id from request_type where label = 'Study Grant Request');
DELETE FROM request_type where label = 'Study Grant Request';

-- optional cleanup instructions : old requests
-- DELETE FROM request_action where request_id in (SELECT id from request where request_type_id = (select id from request_type where label = 'Study Grant'));
-- DELETE FROM request where id in (SELECT id from request where request_type_id = (select id from request_type where label = 'Study Grant'));

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

alter table study_grant_request add column account_holder_edemande_id varchar(255);

alter table external_service_traces add column subkey varchar(255);
update external_service_traces set subkey = 'subject' where message like '%tiers%';