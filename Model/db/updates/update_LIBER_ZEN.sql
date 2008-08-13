alter table service rename to category;
alter table agent_service_roles rename to agent_category_roles;
alter table agent_category_roles rename column service_id to category_id;
alter table request_type rename column service_id to category_id;

alter table school add column active bool;
update school set active = true;
alter table recreation_center add column active bool;
update recreation_center set active = true;
