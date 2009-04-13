alter table local_authority add column display_title varchar(100)
update local_authority set display_title=name;
alter table local_authority alter column display_title set not null;

alter table local_authority add column server_names bytea;

alter table local_authority add column requests_creation_notification_enabled bool;
update local_authority set requests_creation_notification_enabled=false;
alter table local_authority alter column requests_creation_notification_enabled set not null;

alter table local_authority add column document_digitalization_enabled bool;
update local_authority set document_digitalization_enabled=true;
alter table local_authority alter column document_digitalization_enabled set not null;

alter table local_authority add column instruction_alerts_enabled bool;
update local_authority set instruction_alerts_enabled=false;
alter table local_authority alter column instruction_alerts_enabled set not null;

alter table local_authority add column instruction_alerts_detailed bool;
update local_authority set instruction_alerts_detailed=false;
alter table local_authority alter column instruction_alerts_detailed set not null;

alter table local_authority add column instruction_default_max_delay int4;
update local_authority set instruction_default_max_delay=10;
alter table local_authority alter column instruction_default_max_delay set not null;

alter table local_authority add column instruction_default_alert_delay int4;
update local_authority set instruction_default_alert_delay=3;
alter table local_authority alter column instruction_default_alert_delay set not null;
