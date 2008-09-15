package fr.cg95.cvq.dao.request;

import java.util.List;

import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.dao.IGenericDAO;

public interface IMeansOfContactDAO extends IGenericDAO {
   
    MeansOfContact findByType(MeansOfContactEnum type);
    
    List<MeansOfContact> listAllEnabled();
    List<MeansOfContact> listAll();
    
}