alter table local_authority add column display_title varchar(100), server_names bytea;
update local_authority set display_title="name";
alter table local_authority alter column display_title set not null;
