-- string addresses have been transformed into address beans
alter table other_individual rename column address to address_id;
alter table other_individual alter column address_id type bigint using address_id::text::bigint;

ALTER TABLE bulky_waste_collection_request RENAME COLUMN collection_address to collection_address_id;
ALTER TABLE bulky_waste_collection_request ALTER COLUMN collection_address_id type bigint using collection_address_id::text::bigint;
ALTER TABLE bulky_waste_collection_request 
  ADD CONSTRAINT FK1F104ECB1AE70A63 
  FOREIGN KEY (collection_address_id) 
  REFERENCES address;

ALTER TABLE compostable_waste_collection_request RENAME COLUMN collection_address to collection_address_id;
ALTER TABLE compostable_waste_collection_request ALTER COLUMN collection_address_id type bigint using collection_address_id::text::bigint;
ALTER TABLE compostable_waste_collection_request 
  ADD CONSTRAINT FKAFF728771AE70A63 
  FOREIGN KEY (collection_address_id) 
  REFERENCES address;

-- temporary table to compute hibernate index when dispatching other_individuals
drop table current_values;
create temp table current_values (current_id bigint, current_index int4);

-- function to compute hibernate index
-- NOTE
-- always initialize current_values table before using it with :
-- delete from current_values;
-- insert into current_values values (null, 0);
create or replace function compute_other_individual_index(request_id bigint) returns int4 as $$
  declare
    current_vals record;
  begin
    for current_vals in select * from current_values limit 1 loop
      if current_vals.current_id is null or current_vals.current_id <> request_id then
        update current_values set current_id = request_id, current_index = 0;
      else
        update current_values set current_index = current_index + 1;
      end if;
    end loop;
    return (select current_index from current_values);
  end;
$$ LANGUAGE plpgsql;

-- migrate perischool authorized individuals
delete from current_values;
insert into current_values values (null, 0);
insert into perischool_authorized_individual
  select
    oi.id,
    oi.office_phone,
    oi.address_id,
    oi.first_name,
    oi.last_name,
    oi.home_phone,
    parroi.perischool_activity_registration_request_id,
    compute_other_individual_index(parroi.perischool_activity_registration_request_id)
  from other_individual oi, perischool_activity_registration_request_other_individual parroi
  where
    parroi.other_individual_id = oi.id
    and oi.type = 'PickupPerson'
;

-- migrate perischool contact individuals
delete from current_values;
insert into current_values values (null, 0);
insert into perischool_contact_individual
  select
    oi.id,
    oi.office_phone,
    oi.address_id,
    oi.first_name,
    oi.last_name,
    oi.home_phone,
    parroi.perischool_activity_registration_request_id,
    compute_other_individual_index(parroi.perischool_activity_registration_request_id)
  from other_individual oi, perischool_activity_registration_request_other_individual parroi
  where
    parroi.other_individual_id = oi.id
    and oi.type = 'ContactPerson'
;

-- migrate recreation authorized individuals
delete from current_values;
insert into current_values values (null, 0);
insert into recreation_authorized_individual
  select
    oi.id,
    oi.office_phone,
    oi.address_id,
    oi.first_name,
    oi.last_name,
    oi.home_phone,
    rarroi.recreation_activity_registration_request_id,
    compute_other_individual_index(rarroi.recreation_activity_registration_request_id)
  from other_individual oi, recreation_activity_registration_request_other_individual rarroi
  where
    rarroi.other_individual_id = oi.id
    and oi.type = 'PickupPerson'
;

-- migrate recreation contact individuals
delete from current_values;
insert into current_values values (null, 0);
insert into recreation_contact_individual
  select
    oi.id,
    oi.office_phone,
    oi.address_id,
    oi.first_name,
    oi.last_name,
    oi.home_phone,
    rarroi.recreation_activity_registration_request_id,
    compute_other_individual_index(rarroi.recreation_activity_registration_request_id)
  from other_individual oi, recreation_activity_registration_request_other_individual rarroi
  where
    rarroi.other_individual_id = oi.id
    and oi.type = 'ContactPerson'
;

drop table recreation_activity_registration_request_other_individual;
drop table perischool_activity_registration_request_other_individual;
drop table other_individual;
drop table current_values;