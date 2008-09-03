ALTER TABLE history_entry ALTER COLUMN old_value TYPE varchar(1024);
ALTER TABLE history_entry ALTER COLUMN new_value TYPE varchar(1024);

DELETE FROM agent_category_roles where profile = 'None';
