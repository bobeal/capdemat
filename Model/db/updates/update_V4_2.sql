create or replace function migrate_drafts() returns void as $$
  declare
    r record;
  begin
    for r in select * from request where draft = 't' loop
      insert into request_action values (
        nextval('hibernate_sequence'),
        r.requester_id,
        null,
        r.creation_date,
        null,
        r.id,
        'Draft',
        null,
        'Creation'
      );
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_drafts();

drop function migrate_drafts();

alter table request drop column draft;