-- Document related constraints (DRC)

-- DRC1 : constraint on individual
alter table document 
     drop constraint FK335CD11B59302132;
-- DRC2 : constraint on home folder
alter table document 
     drop constraint FK335CD11B8BD77771;

