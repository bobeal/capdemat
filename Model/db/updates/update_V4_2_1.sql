-- documents
alter table document drop column session_uuid;
alter table document_binary add column content_type varchar(255);
alter table document_binary add column preview bytea;

create or replace function migrate_sgr_data() returns void as $$
  declare
    r record;
  begin
    for r in
      select subject_id, subject_email, subject_phone, subject_mobile_phone, sgr.subject_address_id
      from study_grant_request sgr, request re where sgr.id = re.id
    loop
      if r.subject_email is not null and r.subject_email != '' then
        update adult set email = r.subject_email where id = r.subject_id;
      end if;
      if r.subject_phone is not null and r.subject_phone != '' then
        update adult set home_phone = r.subject_phone where id = r.subject_id;
      end if;
      if r.subject_mobile_phone is not null and r.subject_mobile_phone != '' then
        update adult set mobile_phone = r.subject_mobile_phone where id = r.subject_id;
      end if;
      update address
        set additional_delivery_information = x.additional_delivery_information,
        additional_geographical_information = x.additional_geographical_information,
        city = x.city, country_name = x.country_name,
        place_name_or_service = x.place_name_or_service, postal_code = x.postal_code,
        street_name = x.street_name, street_number = x.street_number
      from (
        select
          additional_delivery_information, additional_geographical_information, city,
          country_name, place_name_or_service, postal_code, street_name, street_number
        from address where id = r.subject_address_id) x
      where id = (select adress_id from individual where id = r.subject_id);
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_sgr_data();

drop function migrate_sgr_data();

alter table study_grant_request drop constraint fk7d2f0a7687b85f15;
delete from address where id in (select subject_address_id from study_grant_request);
alter table study_grant_request drop column subject_address_id;
alter table study_grant_request drop column subject_phone;
alter table study_grant_request drop column subject_mobile_phone;
alter table study_grant_request drop column subject_email;

create table b_a_f_a_grant_request (
  id int8 not null,
  account_holder_first_name varchar(38),
  account_holder_edemande_id varchar(255),
  internship_institute_address_id int8,
  edemande_id varchar(255),
  internship_start_date timestamp,
  internship_end_date timestamp,
  is_subject_account_holder bool,
  french_r_i_b_id int8,
  subject_birth_city varchar(32),
  account_holder_birth_date timestamp,
  subject_birth_date timestamp,
  internship_institute_name varchar(255),
  subject_address_id int8,
  account_holder_last_name varchar(38),
  subject_phone varchar(10),
  subject_email varchar(255),
  account_holder_title varchar(255),
  primary key (id)
);

alter table b_a_f_a_grant_request
  add constraint FK2079D97A681FBDDD
  foreign key (internship_institute_address_id)
  references address;

alter table b_a_f_a_grant_request
  add constraint FK2079D97A87B85F15
  foreign key (subject_address_id)
  references address;

alter table b_a_f_a_grant_request
  add constraint FK2079D97A1EE1CD99
  foreign key (french_r_i_b_id)
  references french_r_i_b;
