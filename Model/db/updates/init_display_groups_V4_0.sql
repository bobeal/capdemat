ALTER TABLE display_group ALTER id SET DEFAULT NEXTVAL('hibernate_sequence');

INSERT INTO display_group( name, label) VALUES( 'school', 'Scolaire');
INSERT INTO display_group( name, label) VALUES( 'civil', 'Etat civil');
INSERT INTO display_group( name, label) VALUES( 'social', 'Social');
INSERT INTO display_group( name, label) VALUES( 'environment', 'Environnement');
INSERT INTO display_group( name, label) VALUES( 'election', 'Election');
INSERT INTO display_group( name, label) VALUES( 'security', 'Sécurité');
INSERT INTO display_group( name, label) VALUES( 'leisure', 'Loisirs');
INSERT INTO display_group( name, label) VALUES( 'culture', 'Culturel');
INSERT INTO display_group( name, label) VALUES( 'technical', 'Service technique');
INSERT INTO display_group( name, label) VALUES( 'urbanism', 'Urbanisme');

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'school' LIMIT 1)  
WHERE label = 'School Registration' OR
label = 'Perischool Activity Registration' OR
label = 'School Canteen Registration' OR
label = 'Recreation Activity Registration' OR
label = 'Study Grant';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'civil' LIMIT 1)  
WHERE label = 'Death Details' OR
label = 'Marriage Details' OR
label = 'Birth Details' OR
label = 'Personal Details' OR
label = 'Military Census';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'social' LIMIT 1)  
WHERE label = 'Domestic Help' OR
label = 'Handicap Compensation Adult' OR
label = 'Handicap Compensation Child' OR
label = 'Remote Support';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'environment' LIMIT 1)  
WHERE label = 'Bulky Waste Collection' OR
label = 'Compostable Waste Collection';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'election' LIMIT 1)  
WHERE label = 'Electoral Roll Registration';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'security' LIMIT 1)  
WHERE label = 'Holiday Security';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'leisure' LIMIT 1)  
WHERE label = 'Sms Notification' OR
label = 'Music School Registration';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'culture' LIMIT 1)  
WHERE label = 'Place Reservation' OR
label = 'Library Registration';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'technical' LIMIT 1)  
WHERE label = 'Technical Intervention';

UPDATE request_type SET
  display_group_id = (SELECT dg.id FROM display_group dg WHERE dg.name = 'urbanism' LIMIT 1)  
WHERE label = 'Sewer Connection' OR
label = 'Alignment Certificate' OR
label = 'Alignment Numbering Connection'; 

-- End of statement
ALTER TABLE display_group ALTER id SET DEFAULT NULL;

