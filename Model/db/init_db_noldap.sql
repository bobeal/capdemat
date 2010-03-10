INSERT INTO agent (id, login, last_name, first_name, active) VALUES (nextval('hibernate_sequence'), 'admin', 'administrateur', '', true);
INSERT INTO agent_site_roles (agent_id, profile) VALUES ( (select id from agent where login = 'admin'), 'Admin');

INSERT INTO agent (id, login, last_name, first_name, active) VALUES (nextval('hibernate_sequence'), 'agent', 'agent', '', true);
INSERT INTO agent_site_roles (agent_id, profile) VALUES ( (select id from agent where login = 'agent'), 'Agent');

INSERT INTO school VALUES (nextval('hibernate_sequence'), 'Ecole de la ville', NULL, 't');

INSERT INTO recreation_center VALUES (nextval('hibernate_sequence'), 'Centre de loisirs de la ville', NULL, 't');

