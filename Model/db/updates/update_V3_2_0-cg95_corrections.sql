
--
-- 3.1.10 conformances script (louvres / parmain / valoise)
--
CREATE FUNCTION migration_food_diet_removal() RETURNS void AS $$
  BEGIN
    BEGIN
      -- migration's function removal script
      DROP FUNCTION migrate_food_diet(boolean, boolean, boolean, boolean, boolean);
      EXCEPTION WHEN undefined_function THEN
    END;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
SELECT migration_food_diet_removal();
DROP FUNCTION migration_food_diet_removal();


--
-- 3.1.10 conformances script (franconville / louvres / parmain / valdoise)
--

CREATE FUNCTION old_local_authorities_corrections() RETURNS void AS $$
  BEGIN
    BEGIN
      -- migration's function removal script
      DROP FUNCTION migrate_canteen_attending_days(boolean, boolean, boolean, boolean, boolean);
      -- vo_card_request table correction script
      ALTER TABLE vo_card_request DROP COLUMN home_folder_responsible_id CASCADE;
      ALTER TABLE adult DROP COLUMN vo_card_request_id CASCADE;
      ALTER TABLE child DROP COLUMN vo_card_request_id CASCADE;
      
      -- document_type table correction script
      ALTER TABLE document_type DROP CONSTRAINT document_type_type_idx;
      ALTER TABLE document_type ADD CONSTRAINT document_type_name_key UNIQUE (name);
      ALTER TABLE document_type  ADD CONSTRAINT document_type_type_key UNIQUE ("type");

      -- request table correction script
      ALTER TABLE request ADD CONSTRAINT fk414ef28ff8797b2c FOREIGN KEY (home_folder_id) REFERENCES home_folder;

      -- school_canteen table correction script
      ALTER TABLE school_canteen_registration_request 
        DROP COLUMN eat_monday,
        DROP COLUMN eat_tuesday,
        DROP COLUMN eat_wednesday,
        DROP COLUMN eat_thursday,
        DROP COLUMN eat_friday;
      
      -- child_legal_responsible table correction script
      ALTER TABLE child_legal_responsible_map DROP CONSTRAINT child_legal_responsible_map_temp_pkey; 
      ALTER TABLE child_legal_responsible_map ADD CONSTRAINT child_legal_responsible_map_pkey PRIMARY KEY (id);
      
      -- category table correction script
      ALTER TABLE category DROP CONSTRAINT service_pkey CASCADE; 
      ALTER TABLE category ADD CONSTRAINT category_pkey PRIMARY KEY (id);
      ALTER TABLE category_emails ADD CONSTRAINT fkb9136eb85ba8abfc FOREIGN KEY (category_id) REFERENCES category;
      ALTER TABLE category DROP CONSTRAINT fk7643c6b531c9afeb;
      ALTER TABLE category ADD CONSTRAINT fk302bcfe31c9afeb FOREIGN KEY (local_authority_id) REFERENCES local_authority;
      
      -- place_reservation tables correction script
      ALTER TABLE place_reservation_request ADD CONSTRAINT fk10fcede4d1b FOREIGN KEY (id) REFERENCES request;
      ALTER TABLE place_reservation_request_place_reservation ADD CONSTRAINT fk9493cef92e7d90a6 FOREIGN KEY (place_reservation_id) REFERENCES place_reservation_data;
      ALTER TABLE place_reservation_request_place_reservation ADD CONSTRAINT fk9493cef9e9a90956 FOREIGN KEY (place_reservation_request_id) REFERENCES place_reservation_request;
      
      -- vacation_diary table correction script
      ALTER TABLE vacations_diary ADD CONSTRAINT fk2890bf7a5dd9ac08 FOREIGN KEY (vacations_registration_request_id) REFERENCES vacations_registration_request;
      
      -- payment table correction script
      ALTER TABLE ticket_type_selection ADD CONSTRAINT fk3b70c45a25b36525 FOREIGN KEY (place_reservation_data_id) REFERENCES place_reservation_data;
      
      -- payment table correction script
      ALTER TABLE request_type ADD CONSTRAINT fk4dae96ea5ba8abfc FOREIGN KEY (category_id) REFERENCES category;
     
      -- vacation-ragistration_request table correction script
      ALTER TABLE vacations_registration_request ADD CONSTRAINT fk92f4987241c46f58 FOREIGN KEY (recreation_center_id) REFERENCES recreation_center;
      
      -- agent_categary_roles table correction script
      ALTER TABLE agent_category_roles DROP CONSTRAINT fke5e304f957919495;
      ALTER TABLE agent_category_roles ADD CONSTRAINT fkbafb98b657919495 FOREIGN KEY (agent_id) REFERENCES agent;
      ALTER TABLE agent_category_roles ADD CONSTRAINT fkbafb98b65ba8abfc FOREIGN KEY (category_id) REFERENCES category;

      EXCEPTION 
        WHEN undefined_object THEN
        WHEN undefined_function THEN
    END;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
SELECT old_local_authorities_corrections();
DROP FUNCTION old_local_authorities_corrections();


--
-- 3.1.10 conformances script (all local authoities)
--

-- local_referential_data table correction script
ALTER TABLE local_referential_data ALTER COLUMN name SET NOT NULL;

-- document_type table correction script
ALTER TABLE document_type
  ALTER COLUMN name SET NOT NULL,
  ALTER COLUMN "type" SET NOT NULL,
  ALTER COLUMN validity_duration SET NOT NULL;

-- payment table correction script
ALTER TABLE local_authority 
  ALTER COLUMN name SET NOT NULL,
  ALTER COLUMN postal_code SET NOT NULL;

-- recreation_center table correction script
ALTER TABLE recreation_center 
  ALTER COLUMN name SET NOT NULL;

-- home_foler table correction script
ALTER TABLE home_folder ALTER COLUMN state SET NOT NULL;

-- individual table correction script
ALTER TABLE individual ALTER COLUMN state SET NOT NULL;

-- request table correction script
ALTER TABLE request  ALTER COLUMN state SET NOT NULL;

-- category table correction script
ALTER TABLE agent_category_roles ADD CONSTRAINT fke5e304f9993232e5 FOREIGN KEY (category_id) REFERENCES category;
ALTER TABLE request_type ADD CONSTRAINT fk4dae96ea993232e5 FOREIGN KEY (category_id) REFERENCES category;

-- payment table correction script
ALTER TABLE request_type DROP CONSTRAINT fk4dae96ea993232e5;

-- agent_categary_roles table correction script
ALTER TABLE agent_category_roles DROP  CONSTRAINT fke5e304f9993232e5;

-- payment table correction script
ALTER TABLE payment ALTER COLUMN home_folder_id SET NOT NULL;

CREATE FUNCTION payment_constraint_correction() RETURNS void AS $$
  BEGIN
    BEGIN
      ALTER TABLE payment DROP CONSTRAINT FK2E2407F8797B2C;
      EXCEPTION WHEN undefined_object THEN
    END;
    BEGIN
      ALTER TABLE payment DROP CONSTRAINT FK2E2407210BEC8D;
      EXCEPTION WHEN undefined_object THEN
    END;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
SELECT payment_constraint_correction();
DROP FUNCTION  payment_constraint_correction();

ALTER TABLE payment DROP CONSTRAINT bill_pkey CASCADE;
ALTER TABLE payment ADD CONSTRAINT payment_pkey PRIMARY KEY (id);
ALTER TABLE purchase_item ADD CONSTRAINT fkb11327916022b9f4 FOREIGN KEY (payment_id) REFERENCES payment;
