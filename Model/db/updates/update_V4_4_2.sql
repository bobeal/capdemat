UPDATE individual set first_name_2 = null where first_name_2 = '';
UPDATE individual set first_name_3 = null where first_name_3 = '';
UPDATE adult set maiden_name = null where maiden_name = '';
UPDATE adult set name_of_use = null where name_of_use = '';

ALTER TABLE user_action ALTER COLUMN note TYPE varchar(1024);

-- Delete VOCR / HFMR oldies

DELETE FROM requirement where request_type_id in (select id FROM request_type where label = 'VO Card' or label = 'Home Folder Modification');
DELETE FROM forms where request_type_id in (select id FROM request_type where label = 'VO Card' or label = 'Home Folder Modification');
DELETE FROM request_type where label = 'VO Card' or label = 'Home Folder Modification';

DROP TABLE vo_card_request ;
DROP TABLE home_folder_modification_request ;
