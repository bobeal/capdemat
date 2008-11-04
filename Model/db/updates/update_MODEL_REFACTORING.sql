-- Document related constraints (DRC)

-- DRC1 : constraint on individual
alter table document 
    drop constraint FK335CD11B59302132;
-- DRC2 : constraint on home folder
alter table document 
    drop constraint FK335CD11B8BD77771;

-- Request related constraints (RRC)

-- RRC1 : constraint on home folder
alter table request 
    drop constraint FK414EF28F8BD77771;
    
-- RRC1 : constraint on individual (requester)
alter table request
    drop constraint FK414EF28F1BC4A960;


