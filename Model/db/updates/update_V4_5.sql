create table bank_account (
    id int8 not null,
    bic varchar(255) not null,
    iban varchar(255) not null,
    primary key (id)
);

alter table bafa_grant_request add column bank_account_id int8;
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
