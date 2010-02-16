create or replace function migrate_drafts() returns void as $$
  declare
    r record;
  begin
    for r in select * from request where draft = 't' loop
      insert into request_action values (
        nextval('hibernate_sequence'),
        r.requester_id,
        null,
        r.creation_date,
        null,
        r.id,
        'Draft',
        null,
        'Creation'
      );
    end loop;
  end;
$$ LANGUAGE plpgsql;

select * from migrate_drafts();

drop function migrate_drafts();

alter table request drop column draft;

-- requests refactoring
alter table request add column specific_data_class varchar(255);
alter table request add column specific_data_id int8;
alter table request_action alter column request_id drop not null;

alter table alignment_certificate_request drop constraint FK9EBFB38B82587E99;

alter table alignment_numbering_connection_request drop constraint FKEBD1311082587E99;

alter table birth_details_request drop constraint FKB356961282587E99;

alter table bulky_waste_collection_request drop constraint FK1F104ECB82587E99;
alter table bulky_waste_collection_request_bulky_waste_type drop constraint FK7E2C4DCBD1DA5141;
alter table bulky_waste_collection_request_bulky_waste_type
    add constraint FK7E2C4DCB94784C0B
    foreign key (bulky_waste_collection_request_id)
    references bulky_waste_collection_request;

alter table compostable_waste_collection_request drop constraint FKAFF7287782587E99;
alter table compostable_waste_collection_request_compostable_waste_type drop constraint FK765E424BC116EEE9;
alter table compostable_waste_collection_request_compostable_waste_type
    add constraint FK765E424B28FD5FB3
    foreign key (compostable_waste_collection_request_id)
    references compostable_waste_collection_request;

alter table death_details_request drop constraint FK85B0A9C782587E99;

alter table dhr_not_real_asset drop constraint FK2BA9F1ECD6AE1BE8;
alter table dhr_previous_dwelling drop constraint FKB0B96E27D6AE1BE8;
alter table dhr_real_asset drop constraint FK6AA7D980D6AE1BE8;
alter table dhr_not_real_asset
    add constraint FK2BA9F1EC742C3FB2
    foreign key (domestic_help_request_id)
    references domestic_help_request;
alter table dhr_previous_dwelling
    add constraint FKB0B96E27742C3FB2
    foreign key (domestic_help_request_id)
    references domestic_help_request;
alter table dhr_real_asset
    add constraint FK6AA7D980742C3FB2
    foreign key (domestic_help_request_id)
    references domestic_help_request;

alter table domestic_help_request drop constraint FK3C00811282587E99;

alter table electoral_roll_registration_request drop constraint FK4562552982587E99;

alter table handicap_compensation_adult_request drop constraint FK73D0EACC82587E99;
alter table hcar_additional_fee drop constraint FKB357C9A19DDD11C5;
alter table hcar_care_service drop constraint FKD2D3BA7A9DDD11C5;
alter table hcar_family_assistance_member drop constraint FKF63BE3D99DDD11C5;
alter table hcar_family_dependent drop constraint FK6E4B5579DDD11C5;
alter table hcar_home_intervenant drop constraint FK6294A7D79DDD11C5;
alter table hcar_other_benefit drop constraint FKA530B5D59DDD11C5;
alter table hcar_other_folder drop constraint FK4681FB709DDD11C5;
alter table hcar_professional drop constraint FK581A111A9DDD11C5;
alter table hcar_additional_fee
    add constraint FKB357C9A17010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_care_service
    add constraint FKD2D3BA7A7010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_family_assistance_member
    add constraint FKF63BE3D97010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_family_dependent
    add constraint FK6E4B5577010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_home_intervenant
    add constraint FK6294A7D77010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_other_benefit
    add constraint FKA530B5D57010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_other_folder
    add constraint FK4681FB707010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;
alter table hcar_professional
    add constraint FK581A111A7010720F
    foreign key (handicap_compensation_adult_request_id)
    references handicap_compensation_adult_request;

alter table handicap_compensation_child_request drop constraint FK309E3C2E82587E99;
alter table hccr_additional_fee drop constraint FK54AB85A32860A781;
alter table hccr_care_service drop constraint FK868A8EFC2860A781;
alter table hccr_family_assistance_member drop constraint FK68DE055B2860A781;
alter table hccr_family_dependent drop constraint FKA23978D92860A781;
alter table hccr_home_intervenant drop constraint FKFDE96B592860A781;
alter table hccr_other_benefit drop constraint FK685471932860A781;
alter table hccr_other_folder drop constraint FKFA38CFF22860A781;
alter table hccr_professional drop constraint FKBD0E59C2860A781;
alter table hccr_additional_fee
    add constraint FK54AB85A3A233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_care_service
    add constraint FK868A8EFCA233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_family_assistance_member
    add constraint FK68DE055BA233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_family_dependent
    add constraint FKA23978D9A233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_home_intervenant
    add constraint FKFDE96B59A233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_other_benefit
    add constraint FK68547193A233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_other_folder
    add constraint FKFA38CFF2A233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;
alter table hccr_professional
    add constraint FKBD0E59CA233A8CB
    foreign key (handicap_compensation_child_request_id)
    references handicap_compensation_child_request;

alter table holiday_security_request drop constraint FKED34C59782587E99;

alter table home_folder_modification_request drop constraint FK26ED7ABD82587E99;

alter table library_registration_request drop constraint FKEA37820D82587E99;
alter table library_registration_request_subscription drop constraint FK56C4BE0FD98B4AC2;
alter table library_registration_request_subscription
    add constraint FK56C4BE0FD7ED8C0C
    foreign key (library_registration_request_id)
    references library_registration_request;

alter table marriage_details_request drop constraint FK38315C1D82587E99;

alter table military_census_request drop constraint FK56137C4782587E99;

alter table music_school_registration_request drop constraint FK51A399DA82587E99;
alter table music_school_registration_request_activity drop constraint FK6393FFD440404000;
alter table music_school_registration_request_activity
    add constraint FK6393FFD48F0273CA
    foreign key (music_school_registration_request_id)
    references music_school_registration_request;

alter table perischool_activity_registration_request drop constraint FK76BAA59A82587E99;
alter table perischool_activity_registration_request_perischool_activity drop constraint FK2007A4E996225F9E;
alter table perischool_authorized_individual drop constraint FKEE33EA1E96225F9E;
alter table perischool_contact_individual drop constraint FK5B659D5796225F9E;
alter table perischool_activity_registration_request_perischool_activity
    add constraint FK2007A4E93D77B468
    foreign key (perischool_activity_registration_request_id)
    references perischool_activity_registration_request;
alter table perischool_authorized_individual
    add constraint FKEE33EA1E3D77B468
    foreign key (perischool_activity_registration_request_id)
    references perischool_activity_registration_request;
alter table perischool_contact_individual
    add constraint FK5B659D573D77B468
    foreign key (perischool_activity_registration_request_id)
    references perischool_activity_registration_request;

alter table place_reservation_request drop constraint FK10FCEDE482587E99;
alter table place_reservation_request_place_reservation drop constraint FK9493CEF912CBA22D;
alter table place_reservation_request_place_reservation
    add constraint FK9493CEF91BB5C277
    foreign key (place_reservation_request_id)
    references place_reservation_request;

alter table recreation_activity_registration_request drop constraint FKD1F8ECC82587E99;
alter table recreation_activity_registration_request_recreation_activity drop constraint FK54117CA94C4C853A;
alter table recreation_authorized_individual drop constraint FK5BA625504C4C853A;
alter table recreation_contact_individual drop constraint FK52B67F654C4C853A;
alter table recreation_activity_registration_request_recreation_activity
    add constraint FK54117CA9FCCD2304
    foreign key (recreation_activity_registration_request_id)
    references recreation_activity_registration_request;
alter table recreation_authorized_individual
    add constraint FK5BA62550FCCD2304
    foreign key (recreation_activity_registration_request_id)
    references recreation_activity_registration_request;
alter table recreation_contact_individual
    add constraint FK52B67F65FCCD2304
    foreign key (recreation_activity_registration_request_id)
    references recreation_activity_registration_request;

alter table remote_support_request drop constraint FKEAA6DC2682587E99;

alter table request_action drop constraint FK7AC459E6848EB249;
alter table request_action
    add constraint FK7AC459E6D7FE2713
    foreign key (request_id)
    references request;

alter table request_document drop constraint FK712980CB848EB249;
alter table request_document
    add constraint FK712980CBD7FE2713
    foreign key (request_id)
    references request;

alter table request_note drop constraint FK4DABB7A2848EB249;
alter table request_note
    add constraint FK4DABB7A2D7FE2713
    foreign key (request_id)
    references request;

alter table school_canteen_registration_request drop constraint FKDC4CBC6982587E99;
alter table school_canteen_registration_request_canteen_attending_days drop constraint FK1323D9F990FF23A;
alter table school_canteen_registration_request_food_diet drop constraint FK5768CADF90FF23A;
alter table school_canteen_registration_request_canteen_attending_days
    add constraint FK1323D9F97C526984
    foreign key (school_canteen_registration_request_id)
    references school_canteen_registration_request;
alter table school_canteen_registration_request_food_diet
    add constraint FK5768CADF7C526984
    foreign key (school_canteen_registration_request_id)
    references school_canteen_registration_request;

alter table school_registration_request drop constraint FK7BDFE8F482587E99;

alter table sewer_connection_request drop constraint FK50B057BB82587E99;

alter table sms_notification_request drop constraint FK33CA666182587E99;
alter table sms_notification_request_interests drop constraint FKCE60DA2B16CF96DE;
alter table sms_notification_request_interests
    add constraint FKCE60DA2B10A7E028
    foreign key (sms_notification_request_id)
    references sms_notification_request;

alter table study_grant_request drop constraint FK7D2F0A7682587E99;
alter table study_grant_request_current_school_name drop constraint FK49484F67C1B15A77;
alter table study_grant_request_tax_household_city drop constraint FK1B568948C1B15A77;
alter table study_grant_request_current_school_name
    add constraint FK49484F6719BB0CC1
    foreign key (study_grant_request_id)
    references study_grant_request;
alter table study_grant_request_tax_household_city
    add constraint FK1B56894819BB0CC1
    foreign key (study_grant_request_id)
    references study_grant_request;

alter table technical_intervention_request drop constraint FKC051B8C982587E99;
alter table technical_intervention_request_intervention_type drop constraint FK5ADF79ACC8B7518E;
alter table technical_intervention_request_intervention_type
    add constraint FK5ADF79AC43EECED8
    foreign key (technical_intervention_request_id)
    references technical_intervention_request;

alter table vo_card_request drop constraint FKC295D42682587E99;

update request set specific_data_id = id;
update request set specific_data_class = 'fr.cg95.cvq.business.request.urbanism.AlignmentCertificateRequestData' where request_type_id = (select id from request_type where label = 'Alignment Certificate');
update request set specific_data_class = 'fr.cg95.cvq.business.request.urbanism.AlignmentNumberingConnectionRequestData' where request_type_id = (select id from request_type where label = 'Alignment Numbering Connection');
update request set specific_data_class = 'fr.cg95.cvq.business.request.civil.BirthDetailsRequestData' where request_type_id = (select id from request_type where label = 'Birth Details');
update request set specific_data_class = 'fr.cg95.cvq.business.request.environment.BulkyWasteCollectionRequestData' where request_type_id = (select id from request_type where label = 'Bulky Waste Collection');
update request set specific_data_class = 'fr.cg95.cvq.business.request.environment.CompostableWasteCollectionRequestData' where request_type_id = (select id from request_type where label = 'Compostable Waste Collection');
update request set specific_data_class = 'fr.cg95.cvq.business.request.civil.DeathDetailsRequestData' where request_type_id = (select id from request_type where label = 'Death Details');
update request set specific_data_class = 'fr.cg95.cvq.business.request.social.DomesticHelpRequestData' where request_type_id = (select id from request_type where label = 'Domestic Help');
update request set specific_data_class = 'fr.cg95.cvq.business.request.election.ElectoralRollRegistrationRequestData' where request_type_id = (select id from request_type where label = 'Electoral Roll Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.social.HandicapCompensationAdultRequestData' where request_type_id = (select id from request_type where label = 'Handicap Compensation Adult');
update request set specific_data_class = 'fr.cg95.cvq.business.request.social.HandicapCompensationChildRequestData' where request_type_id = (select id from request_type where label = 'Handicap Compensation Child');
update request set specific_data_class = 'fr.cg95.cvq.business.request.localpolice.HolidaySecurityRequestData' where request_type_id = (select id from request_type where label = 'Holiday Security');
update request set specific_data_class = 'fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequestData' where request_type_id = (select id from request_type where label = 'Home Folder Modification');
update request set specific_data_class = 'fr.cg95.cvq.business.request.leisure.culture.LibraryRegistrationRequestData' where request_type_id = (select id from request_type where label = 'Library Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.civil.MarriageDetailsRequestData' where request_type_id = (select id from request_type where label = 'Marriage Details');
update request set specific_data_class = 'fr.cg95.cvq.business.request.military.MilitaryCensusRequestData' where request_type_id = (select id from request_type where label = 'Military Census');
update request set specific_data_class = 'fr.cg95.cvq.business.request.leisure.music.MusicSchoolRegistrationRequestData' where request_type_id = (select id from request_type where label = 'Music School Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequestData' where request_type_id = (select id from request_type where label = 'Perischool Activity Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.reservation.PlaceReservationRequestData' where request_type_id = (select id from request_type where label = 'Place Reservation');
update request set specific_data_class = 'fr.cg95.cvq.business.request.school.RecreationActivityRegistrationRequestData' where request_type_id = (select id from request_type where label = 'Recreation Activity Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.social.RemoteSupportRequestData' where request_type_id = (select id from request_type where label = 'Remote Support');
update request set specific_data_class = 'fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequestData' where request_type_id = (select id from request_type where label = 'School Canteen Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.school.SchoolRegistrationRequestData' where request_type_id = (select id from request_type where label = 'School Registration');
update request set specific_data_class = 'fr.cg95.cvq.business.request.urbanism.SewerConnectionRequestData' where request_type_id = (select id from request_type where label = 'Sewer Connection');
update request set specific_data_class = 'fr.cg95.cvq.business.request.leisure.SmsNotificationRequestData' where request_type_id = (select id from request_type where label = 'Sms Notification');
update request set specific_data_class = 'fr.cg95.cvq.business.request.school.StudyGrantRequestData' where request_type_id = (select id from request_type where label = 'Study Grant');
update request set specific_data_class = 'fr.cg95.cvq.business.request.technical.TechnicalInterventionRequestData' where request_type_id = (select id from request_type where label = 'Technical Intervention');
update request set specific_data_class = 'fr.cg95.cvq.business.request.ecitizen.VoCardRequestData' where request_type_id = (select id from request_type where label = 'VO Card');
