create table bafa_grant_request (
    id int8 not null,
    account_holder_birth_date timestamp,
    account_holder_edemande_id varchar(255),
    account_holder_first_name varchar(38),
    account_holder_last_name varchar(38),
    account_holder_title varchar(255),
    bank_account_id int8,
    edemande_id varchar(255),
    internship_end_date timestamp,
    internship_institute_address_id int8,
    internship_institute_name varchar(255),
    internship_start_date timestamp,
    is_subject_account_holder bool,
    subject_address_id int8,
    subject_birth_city varchar(32),
    subject_birth_date timestamp,
    subject_email varchar(255),
    subject_phone varchar(10),
    primary key (id)
);

alter table bafa_grant_request 
    add constraint FK50AFA827681FBDDD 
    foreign key (internship_institute_address_id) 
    references address;

alter table bafa_grant_request 
    add constraint FK50AFA82787B85F15 
    foreign key (subject_address_id) 
    references address;

alter table bafa_grant_request 
    add constraint FK50AFA827A4AB2F89 
    foreign key (bank_account_id) 
    references bank_account;

create table bank_account (
    id int8 not null,
    bic varchar(255) not null,
    iban varchar(255) not null,
    primary key (id)
);


-- only needed for CG77's platform
--alter table bafa_grant_request add column bank_account_id int8;
alter table study_grant_request add column bank_account_id int8;

alter table document_binary add column zdb_id varchar(255) unique;

alter table study_grant_request add column current_school_address_id int8;
alter table study_grant_request
    add constraint FK7D2F0A766A39B687
    foreign key (current_school_address_id)
    references address;

update study_grant_request set distance = 'undetermined' where distance is null;

create or replace function migrate_sgr_school_address() returns void as $$
  declare
    r record;
  begin
    for r in select * from study_grant_request where current_school_postal_code is not null or current_school_city is not null or current_school_country is not null loop
      insert into address (id, postal_code, city, country_name) values (
        nextval('hibernate_sequence'),
        r.current_school_postal_code,
        r.current_school_city,
        r.current_school_country
      );
      update study_grant_request set current_school_address_id = currval('hibernate_sequence') where id = r.id;
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_sgr_school_address();

drop function migrate_sgr_school_address();

alter table request_external_action alter key type bigint using key::text::bigint;
