update request set state = 'Complete', request_step = 'Instruction' where subject_id = 7298 and request_type_id = 40;
delete from request_action where request_id = (SELECT id from request where subject_id = 7298 and request_type_id = 40) and resulting_state = 'Validated';
