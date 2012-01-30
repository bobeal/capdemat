alter table individual_mapping drop column home_folder_mapping_index;

-- old format found in CG95's prod logs : force migrate to Full Copy
UPDATE death_details_request SET format = 'FULL_COPY'  Where format = 'ExtractWithoutRelationship';
