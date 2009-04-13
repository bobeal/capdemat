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
  a_levels varchar(255),
  current_studies_level varchar(255),
  current_school_postal_code varchar(5),
  abroad_internship_start_date timestamp,
  tax_household_first_name varchar(38),
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
  tax_household_postal_code varchar(5),
  subject_mobile_phone varchar(10),
  abroad_internship_school_name varchar(255),
  account_key varchar(2),
  other_studies_label varchar(255),
  a_levels_date varchar(4),
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
