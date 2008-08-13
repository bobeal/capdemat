package fr.cg95.cvq.dao.users;

import java.util.List;

import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.dao.IGenericDAO;

public interface IMeansOfContactDAO extends IGenericDAO {
   
    MeansOfContact findByType(MeansOfContactEnum type);
    
    List<MeansOfContact> listAllEnabled();
    List<MeansOfContact> listAll();
    
}