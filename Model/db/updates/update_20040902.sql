ALTER TABLE individual add column login varchar(255);
ALTER TABLE individual drop column birth_place;
ALTER TABLE individual add column birth_country varchar(255);
ALTER TABLE individual add column birth_city varchar(255);
ALTER TABLE individual add column birth_postal_code varchar(255);

ALTER TABLE adult drop column ssn;
ALTER TABLE adult ADD column ssn varchar(13);
ALTER TABLE adult ADD column ssn_key varchar(2);
ALTER TABLE adult drop column cfbn;
ALTER TABLE adult ADD column cfbn varchar(8);
ALTER TABLE adult ADD column question varchar(255);
ALTER TABLE adult ADD column answer varchar(255);
ALTER TABLE adult ADD column password varchar(255);

ALTER TABLE agent rename column last_name to lastName;
ALTER TABLE agent rename column first_name to firstName;
ALTER TABLE agent drop column password;
ALTER TABLE agent add column login varchar(255);
ALTER TABLE agent add column title varchar(255);
ALTER TABLE agent add column personalTitle varchar(255);
ALTER TABLE agent add column phoneNumber varchar(255);
