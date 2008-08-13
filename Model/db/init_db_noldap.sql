INSERT INTO agent VALUES (nextval('hibernate_sequence'), 'admin');
INSERT INTO agent_site_roles (agent_id, local_authority_id, profile) VALUES ( (select id from agent where login = 'admin'), (select max(id) from local_authority), 'Admin');

INSERT INTO agent VALUES (nextval('hibernate_sequence'), 'agent');
INSERT INTO agent_site_roles (agent_id, local_authority_id, profile) VALUES ( (select id from agent where login = 'agent'), (select max(id) from local_authority), 'None');

INSERT INTO school VALUES (nextval('hibernate_sequence'), 'Ecole de la ville', NULL, 't', (select max(id) from local_authority));

INSERT INTO recreation_center VALUES (nextval('hibernate_sequence'), 'Centre de loisirs de la ville', (select max(id) from local_authority), NULL, 't');
