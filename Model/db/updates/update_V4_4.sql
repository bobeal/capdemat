update home_folder set is_temporary = true where id in (select home_folder_id from request where has_tied_home_folder is true);
alter table request drop column has_tied_home_folder;

alter table home_folder drop constraint FKDB87BBCE6AB1E860;
alter table home_folder rename adress_id to address_id;
alter table home_folder add constraint FKDB87BBCEB7531222 foreign key (address_id) references address;

alter table individual drop constraint FKFD3DA2996AB1E860;
alter table individual rename adress_id to address_id;
alter table individual add constraint FKFD3DA299B7531222 foreign key (address_id) references address;

alter table child rename child_born to born;

alter table school rename column adress to address;

alter table document_action rename agent_id to user_id;
alter table document_action rename label to type;
alter table document_action alter column type set not null;
update document_action set type = 'Creation' where type = 'CREATION_ACTION';
update document_action set type = 'StateChange' where type = 'STATE_CHANGE_ACTION';
update document_action set type = 'PageAddition' where type = 'PAGE_ADD_ACTION';
update document_action set type = 'PageEdition' where type = 'PAGE_EDIT_ACTION';
update document_action set type = 'PageDeletion' where type = 'PAGE_DELETE_ACTION';
update document_action set type = 'Merge' where type = 'MERGE_ACTION';

-- New data in external home folder's CSV export files
alter table external_individual add column email varchar(255);
alter table external_individual add column home_phone varchar(255);

create table request_external_action_complementary_data (
    id int8 not null,
    value bytea,
    key varchar(255) not null,
    primary key (id, key)
);

alter table request_external_action_complementary_data
    add constraint FKB088082C294C4979
    foreign key (id)
    references request_external_action;

create or replace function migrate_request_external_action_subkeys() returns void as $$
  declare
    r record;
  begin
    for r in select * from request_external_action where subkey = 'document' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'nature',
        '\\254\\355\\000\\005t\\000\\010document'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'summary' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'nature',
        '\\254\\355\\000\\005t\\000\\007summary'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'subject' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'individual',
        '\\254\\355\\000\\005t\\000\\007subject'
      );
    end loop;
    for r in select * from request_external_action where subkey = 'accountHolder' loop
      insert into request_external_action_complementary_data (id, key, value) values (
        r.id,
        'individual',
        '\\254\\355\\000\\005t\\000\\015accountHolder'
      );
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_request_external_action_subkeys();
drop function migrate_request_external_action_subkeys();

alter table request_external_action drop column subkey;

alter table child drop column note;
alter table child drop column badge_number;
alter table individual drop column version;
alter table individual drop column public_key;
alter table adult add column login varchar(255) unique;
alter table child add column sex varchar(8);

create or replace function migrate_individual_model() returns void as $$
  declare
    r record;
  begin
    for r in select * from individual loop
      update adult set login = r.login where id = r.id;
      update child set sex = r.sex where id = r.id;
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_individual_model();
drop function migrate_individual_model();

alter table individual drop column login;
alter table individual drop column sex;

create table user_action (
    id int8 not null,
    date timestamp not null,
    type varchar(255) not null,
    note varchar(255),
    data text,
    user_id int8 not null,
    target_id int8 not null,
    home_folder_id int8,
    home_folder_index int4,
    primary key (id)
);

alter table user_action
    add constraint FKD768C52A8BD77771
    foreign key (home_folder_id)
    references home_folder;

update individual set state = 'Modified' where state = 'Pending' and
    (select count(*) from home_folder_modification_request where id in
        (select specific_data_id from request r where r.home_folder_id = home_folder_id)) > 0;
update individual set state = 'New' where state = 'Pending';
update home_folder set state = 'Modified' where state = 'Pending' and id in
    (select r.home_folder_id from request r where
        (select count(*) from home_folder_modification_request hfmr where hfmr.id = r.specific_data_id) > 0);
update home_folder set state = 'New' where state = 'Pending';

create table user_external_action (
    id int8 not null,
    date timestamp not null,
    key varchar(255) not null,
    key_owner varchar(255) not null,
    label varchar(255) not null,
    status varchar(255) not null,
    message varchar(255),
    primary key (id)
);

insert into user_external_action
    select nextval('hibernate_sequence'), date, cast(home_folder_id as varchar), key_owner, name, status, message
    from request_external_action, request
    where request_external_action.key = cast(request.id as varchar)
    and request_type_id in (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification');

delete from request_external_action where key in
    (select cast(id as varchar) from request where request_type_id in
        (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification'));

alter table individual add column q_o_s varchar(16);

-- task board related updates

alter table individual add column last_modification_date timestamp;

create or replace function migrate_individual_lastmodificationdate() returns void as $$
  declare
    r record;
  begin
    for r in select * from individual loop
      update individual set last_modification_date = r.creation_date where id = r.id;
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_individual_lastmodificationdate();
drop function migrate_individual_lastmodificationdate();

-- Clean data related to home folders without individuals

delete from home_folder_modification_request where id in
    (select specific_data_id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

delete from vo_card_request where id in
    (select specific_data_id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

delete from request_action where request_id in
    (select id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

delete from request where home_folder_id in
    (select id from home_folder hf where
        (select count(*) from individual where home_folder_id = hf.id) = 0);

delete from home_folder where id not in (select distinct home_folder_id from individual);

-- User referential security

create table user_security_rule (
    id int8 not null,
    agent_id int8,
    profile varchar(16),
    primary key (id)
);

-- Remove table used for old modification requests

drop table history_entry;
