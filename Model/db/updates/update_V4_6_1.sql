alter table sagr_activite_association add column identifiant_e_demande_activite varchar(255);
alter table sagr_activite_association drop column somme_allouee_activite;
alter table sagr_activite_association add column somme_allouee_activite numeric(19, 2);
alter table sagr_activite_association add column somme_sollicitee_activite numeric(19, 2);

alter table sports_associations_grant_request drop column montant_subvention;
alter table sports_associations_grant_request add column montant_subvention numeric(19, 2);
alter table sports_associations_grant_request add column identifiant_e_demande_association varchar(255);
alter table sports_associations_grant_request drop column subvention_sollicite_conseil_general;
alter table sports_associations_grant_request add column subvention_sollicite_conseil_general numeric(19, 2);


