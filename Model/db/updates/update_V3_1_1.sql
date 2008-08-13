alter table request_type add column instruction_alert_delay int4;
alter table request_type add column instruction_max_delay int4;

alter table request add column orange_alert bool;
alter table request add column red_alert bool;
update request set orange_alert = false, red_alert = false;

-- update all existing requests as being already notified of creation
CREATE OR REPLACE FUNCTION initialize_request_creation_notification() RETURNS void AS $$
DECLARE
  myrec RECORD;
  request_action_id integer;
BEGIN
  FOR myrec IN SELECT id FROM request LOOP
    request_action_id := nextval('hibernate_sequence');
    INSERT INTO request_action (id, agent_id, label, date, request_id) VALUES ( request_action_id, -1, 'REQUEST_CREATION_NOTIFICATION', now(), myrec.id);
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select initialize_request_creation_notification();

alter table document add column certified bool;
update document set certified = false;

-- resolv a bug due to a class renaming
update history_entry set clazz = 'fr.cg95.cvq.business.users.Address' where clazz = 'fr.cg95.cvq.business.users.Adress';

