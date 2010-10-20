-- MPG Fusion
alter table external_service_individual_mapping drop constraint FK5BC5D7E648C97698;
alter table external_service_identifier_mapping rename to home_folder_mapping;
alter table external_service_individual_mapping rename to individual_mapping;

alter table individual_mapping add constraint FK19DDB92881C62393 foreign key (home_folder_mapping_id);
alter table individual_mapping rename column mapping_id to home_folder_mapping_id;
alter table individual_mapping add column home_folder_mapping_index int8;
alter table individual_mapping add column id int8 not null;
update individual_mapping set id = nextval('hibernate_sequence');

-- Add an int hibernate list index
CREATE FUNCTION init_hibernate_list_index(table_name text, foreign_id_col_name text, id_col_name text, index_col_name text) RETURNS void AS $$
 DECLARE
    current_index integer := 0;
    current_foreign_id integer := -1;
    current_rec record;
    select_cmd text := 'SELECT ' || quote_ident(id_col_name) || ' AS id, '
                       || quote_ident(foreign_id_col_name) || ' AS foreign_id'
                       || ' FROM ' || quote_ident(table_name)
                       || ' ORDER BY ' || quote_ident(foreign_id_col_name);
    update_cmd text ;
  BEGIN
    FOR current_rec IN EXECUTE select_cmd LOOP
      IF current_foreign_id <> current_rec.foreign_id THEN
        current_foreign_id := current_rec.foreign_id;
        current_index := 0;
      ELSE
        current_index := current_index + 1;
      END IF;

      update_cmd := 'UPDATE ' || quote_ident(table_name)
                    || ' SET ' || quote_ident(index_col_name) || ' = ' || current_index
                    || ' WHERE ' || quote_ident(id_col_name) || ' = ' || current_rec.id;
      EXECUTE update_cmd;

    END LOOP;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
select init_hibernate_list_index('individual_mapping', 'home_folder_mapping_id', 'id', 'home_folder_mapping_index');
drop function init_hibernate_list_index(text,text,text,text);

create table external_application (
    id int8 not null,
    label varchar(255),
    description varchar(255),
    primary key (id)
);

create table external_application_broker (
    external_application_id int8 not null,
    broker varchar(255)
);

create table external_home_folder (
    id int8 not null,
    mapping_state varchar(255) not null,
    external_id varchar(255),
    external_application_id int8,
    address varchar(255),
    external_home_application_index int4,
    primary key (id)
);

create table external_individual (
    id int8 not null,
    first_name varchar(255),
    external_id varchar(255),
    last_name varchar(255),
    responsible bool,
    external_home_folder_id int8,
    external_home_folder_index int4,
    primary key (id)
);

alter table external_application_broker add constraint FK839CD69CEC40A718 foreign key (external_application_id) references external_application;
alter table external_home_folder add constraint FKA9D7255AEC40A718 foreign key (external_application_id) references external_application;
alter table external_individual add constraint FKC1D4D78D42431EA3 foreign key (external_home_folder_id) references external_home_folder;

create table external_deposit_account_item_detail (
    external_deposit_account_item_id int8 not null,
    subject_name varchar(255),
    label varchar(255),
    quatity numeric(19, 2),
    subject_surname varchar(255),
    unit_price int4,
    value int4
);

create table external_invoice_item_detail (
    external_invoice_item_id int8 not null,
    subject_name varchar(255),
    label varchar(255),
    quatity numeric(19, 2),
    subject_surname varchar(255),
    unit_price int4,
    value int4
);

alter table external_deposit_account_item_detail add constraint FK4A90965670F56907 foreign key (external_deposit_account_item_id) references purchase_item;
alter table external_invoice_item_detail add constraint FKFB8FF2772062B3BC foreign key (external_invoice_item_id) references purchase_item;


alter table purchase_item add column external_application_id varchar(255);
alter table purchase_item add column external_home_folder_id varchar(255);
alter table purchase_item add column external_individual_id varchar(255);
alter table purchase_item add column supported_broker varchar(255);
alter table purchase_item add column is_paid bool;
update purchase_item SET is_paid = false where item_type='EXTERNAL_INVOICE_ITEM';
alter table purchase_item add column payment_date timestamp;

alter table external_service_traces rename to request_external_action;
alter table request_external_action drop constraint external_service_traces_pkey;
alter table request_external_action add constraint request_external_action_pkey primary key (id);

