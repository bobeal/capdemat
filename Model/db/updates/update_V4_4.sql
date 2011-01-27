update home_folder set is_temporary = true where id in (select home_folder_id from request where has_tied_home_folder is true);
alter table request drop column has_tied_home_folder;
