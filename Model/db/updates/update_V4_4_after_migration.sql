delete from request_action where request_id in
    (select id from request where request_type_id in
        (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification'));

delete from request_note where request_id in 
    (select id from request where request_type_id in
        (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification'));

delete from request_document where request_id in 
    (select id from request where request_type_id in
        (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification'));

delete from home_folder_modification_request where id in
    (select specific_data_id from request where request_type_id in
        (select id from request_type where label = 'Home Folder Modification'));

delete from vo_card_request where id in
    (select specific_data_id from request where request_type_id in
        (select id from request_type where label = 'VO Card'));

delete from request where request_type_id in
    (select id from request_type where label = 'VO Card' or label = 'Home Folder Modification');

drop table history_entry;

-- Delete VOCR / HFMR oldies

DELETE FROM requirement where request_type_id in (select id FROM request_type where label = 'VO Card' or label = 'Home Folder Modification');
DELETE FROM forms where request_type_id in (select id FROM request_type where label = 'VO Card' or label = 'Home Folder Modification');
DELETE FROM request_type where label = 'VO Card' or label = 'Home Folder Modification';

DROP TABLE vo_card_request ;
DROP TABLE home_folder_modification_request ;
