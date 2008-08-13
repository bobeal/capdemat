-- normalization with XML Schemas
update child_legal_responsible_map set role = 'Tutor' where role = 'Other';

-- add a reference to the payment for place reservation request
-- (aimed to be a temporary solution)
alter table place_reservation_request add column payment_reference varchar(255);
