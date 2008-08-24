package fr.cg95.cvq.dao.request.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.IMeansOfContactDAO;
import fr.cg95.cvq.util.Critere;

public class MeansOfContactDAO extends GenericDAO implements IMeansOfContactDAO {

    public MeansOfContact findByType(MeansOfContactEnum type) {
        return (MeansOfContact) HibernateUtil.getSession()
            .createQuery("from MeansOfContact as meansOfContact where meansOfContact.type = :type")
            .setParameter("type", type)
            .uniqueResult(); 
    }

    public List<MeansOfContact> listAll() {
        return HibernateUtil.getSession().createQuery("from MeansOfContact").list();
    }

    public List<MeansOfContact> listAllEnabled() {
        return HibernateUtil.getSession()
            .createQuery("from MeansOfContact as meansOfContact where meansOfContact.enabled = true")
            .list();
    }
}