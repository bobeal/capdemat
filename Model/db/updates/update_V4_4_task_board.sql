alter table individual add column last_modification_date timestamp;

create or replace function migrate_individual_lastmodificationdate() returns void as $$
  declare
    r record;
  begin
    for r in select * from individual loop
      update individual i set last_modification_date = r.creation_date where i.id = r.id;
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_individual_lastmodificationdate();
drop function migrate_individual_lastmodificationdate();