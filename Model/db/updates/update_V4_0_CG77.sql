alter table study_grant_request 
  drop constraint FK7D2F0A7682587E99;

alter table study_grant_request 
  drop constraint FK7D2F0A7687B85F15;

alter table study_grant_request 
  drop constraint FK7D2F0A76CE2FC851;

alter table study_grant_request 
  drop constraint FK7D2F0A766A43CE96;

drop table study_grant_request;

create table study_grant_request (
  id int8 not null,
  current_studies varchar(255),
  abroad_internship_end_date timestamp,
  tax_household_address_id int8,
  future_school_phone varchar(10),
  abroad_internship_start_date timestamp,
  bank_name varchar(255),
  tax_household_first_name varchar(38),
  future_school_name varchar(255),
  sandwich_courses_label varchar(255),
  last_year_type varchar(255),
  bank_code varchar(5),
  subject_birth_date timestamp,
  future_school_is_abroad bool,
  counter_code varchar(5),
  has_c_r_o_u_s_help bool,
  subject_email varchar(255),
  has_parents_address bool,
  future_school_address_id int8,
  abroad_internship_school_country varchar(255),
  abroad_internship_school_address varchar(255),
  tax_household_phone varchar(10),
  bank_agency varchar(255),
  tax_household_last_name varchar(38),
  account_number varchar(11),
  distance varchar(255),
  subject_mobile_phone varchar(10),
  is_in_last_year bool,
  abroad_internship_school_name varchar(255),
  other_help_informations varchar(255),
  account_key varchar(2),
  other_studies_label varchar(255),
  subject_birth_place varchar(255),
  future_diploma_level varchar(255),
  last_year_date varchar(4),
  tax_household_income float8,
  has_other_help bool,
  future_diploma_name varchar(255),
  subject_address_id int8,
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

alter table study_grant_request 
  add constraint FK7D2F0A76CE2FC851 
  foreign key (future_school_address_id) 
  references address;

alter table study_grant_request 
  add constraint FK7D2F0A766A43CE96 
  foreign key (tax_household_address_id) 
  references address;
  
UPDATE request_type SET
display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'school' LIMIT 1)  
WHERE label = 'Study Grant';

