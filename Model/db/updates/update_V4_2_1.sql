-- documents
alter table document drop column session_uuid;
alter table document_binary add column content_type varchar(255);
alter table document_binary add column preview bytea;
