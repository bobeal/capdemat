-- update GSRR 

-- @Text Drop table global_school_registration_request_regime_alimentaire

alter table global_school_registration_request_regime_alimentaire
    drop constraint FK261E5D0C85DE12C2;

drop table global_school_registration_request_regime_alimentaire cascade;

