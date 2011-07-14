UPDATE individual set first_name_2 = null where first_name_2 = '';
UPDATE individual set first_name_3 = null where first_name_3 = '';
UPDATE adult set maiden_name = null where maiden_name = '';
UPDATE adult set name_of_use = null where name_of_use = '';

ALTER TABLE user_action ALTER COLUMN note TYPE varchar(1024);
