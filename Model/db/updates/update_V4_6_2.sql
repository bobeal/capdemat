-- Mise à jour du TS Multi-accueil
ALTER TABLE day_care_center_registration_request DROP COLUMN date_placement_fin;

-- Update TS LearningActivitiesDiscoveryRegistration
ALTER TABLE learning_activities_discovery_registration_request ADD atelier_eveil_precision_choix varchar(255);
