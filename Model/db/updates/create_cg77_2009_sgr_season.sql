create or replace function create_cg77_2009_sgr_season() returns void as $$
  begin
    insert into request_season (id, request_type_id, label, registration_start, registration_end,
      validation_authorization_start, effect_start, effect_end) values (
      nextval('hibernate_sequence'),
      (select id from request_type where label = 'Study Grant'),
      '2009/2010',
      '2009-07-01 00:00:00',
      '2010-04-30 00:00:00',
      null,
      '2009-09-02 00:00:00',
      '2010-07-04 00:00:00'
    );
    update request set request_season_id = currval('hibernate_sequence') where request_type_id =
      (select id from request_type where label = 'Study Grant');
  end;
$$ LANGUAGE plpgsql;

select * from create_cg77_2009_sgr_season();
