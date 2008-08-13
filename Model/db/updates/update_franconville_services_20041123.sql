-- Manual update of services emails
-- Can also be done by updating this information in LDAP directory
-- and running LDAP synchronizer afterwards
update service set email = 'evelyne.pegis@ville-franconville.fr' where name = 'AFFAIRES GENERALES';
update service set email = 'michele.briec@ville-franconville.fr' where name = 'SCOLAIRE';
update service set email = 'jocelyne.jacquin@ville-franconville.fr' where name = 'ENFANCE JEUNESSE';
update service set email = 'vincent.moulin@ville-franconville.fr' where name = 'INFORMATIQUE';
