alter table request_action add column message varchar(1024);
alter table request_action alter column note type varchar(1024);

alter table request_action add column type varchar(255);
update request_action set type = 'DraftDeleteNotification' where label = 'DRAFT_DELETE_NOTIFICATION';
update request_action set type = 'CreationNotification' where label = 'REQUEST_CREATION_NOTIFICATION';
update request_action set type = 'OrangeAlertNotification' where label = 'REQUEST_ORANGE_ALERT_NOTIFICATION';
update request_action set type = 'RedAlertNotification' where label = 'REQUEST_RED_ALERT_NOTIFICATION';
update request_action set type = 'Creation' where label = 'CREATION_ACTION';
update request_action set type = 'StateChange' where label = 'STATE_CHANGE_ACTION';
update request_action set type = 'ContactCitizen' where label = 'REQUEST_CONTACT_CITIZEN';
alter table request_action drop column label;