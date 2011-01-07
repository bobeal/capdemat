package fr.cg95.cvq.dao.users.hibernate;

import java.util.List;

import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.dao.hibernate.GenericDAO;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.users.IMeansOfContactDAO;

public class MeansOfContactDAO extends GenericDAO implements IMeansOfContactDAO {

    @Override
    public MeansOfContact findByType(MeansOfContactEnum type) {
        return (MeansOfContact) HibernateUtil.getSession()
            .createQuery("from MeansOfContact as meansOfContact where meansOfContact.type = :type")
            .setParameter("type", type)
            .uniqueResult();
    }

    @Override
    public List<MeansOfContact> listAll() {
        return HibernateUtil.getSession().createQuery("from MeansOfContact").list();
    }

    @Override
    public List<MeansOfContact> listAllEnabled() {
        return HibernateUtil.getSession()
            .createQuery("from MeansOfContact as meansOfContact where meansOfContact.enabled = true")
            .list();
    }
}
