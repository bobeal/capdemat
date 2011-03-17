delete from home_folder_modification_request where id in
    (select specific_data_id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

delete from vo_card_request where id in
    (select specific_data_id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

-- todo : autres TS

delete from request_action where request_id in
    (select id from request where home_folder_id in
        (select id from home_folder hf where
            (select count(*) from individual where home_folder_id = hf.id) = 0));

delete from request where home_folder_id in
    (select id from home_folder hf where
        (select count(*) from individual where home_folder_id = hf.id) = 0);

delete from home_folder hf where (select count(*) from individual where home_folder_id = hf.id) = 0;
