alter table request_action add column message varchar(1024);
alter table request_action alter column note type varchar(1024);