ALTER TABLE library_registration_request ADD COLUMN adult_content_authorization bool;

ALTER TABLE school_canteen_registration_request ADD COLUMN which_food_allergy varchar(255);
