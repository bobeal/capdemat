alter table agent_category_roles drop constraint fkbafb98b6fb8d007d;
alter table agent_category_roles drop constraint fkbafb98b6ce4d7137;
alter table agent_category_roles add constraint FKBAFB98B63ED1C7EB foreign key (category_id) references category;

alter table agent_category_roles alter column category_id set not null;

alter table category_emails drop constraint FKB9136EB8CE4D7137;
alter table category_emails add constraint FKB9136EB83ED1C7EB foreign key (category_id) references category;

alter table request_type drop constraint FK4DAE96EACE4D7137;
alter table request_type add constraint FK4DAE96EA3ED1C7EB foreign key (category_id) references category;
