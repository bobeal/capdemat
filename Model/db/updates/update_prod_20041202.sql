-- set identifier fields on existing requests
update request_type set identifier = 'VOCARD_REGISTRATION' where label = 'VO Card Request';
update request_type set identifier = 'SCHOOLCANTEEN_REGISTRATION' where label = 'School Restaurant Registration';
update request_type set identifier = 'PERISCHOOL_REGISTRATION' where label = 'Perischool Activity Registration';
update request_type set identifier = 'SCHOOL_REGISTRATION' where label = 'School Registration';
update request_type set identifier = 'VACATIONS_REGISTRATION' where label = 'Vacations Registration';

-- set postal codes on local authorities
update local_authority set postal_code = '95130' where name='Franconville';
update local_authority set postal_code = '95380' where name='Louvres';
update local_authority set postal_code = '95620' where name='Parmain';
update local_authority set postal_code = '95310' where name='SaintOuenlAumone';
update local_authority set postal_code = '95999' where name='CG95';
