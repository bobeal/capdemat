package fr.cg95.cvq.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.cg95.cvq.dao.hibernate.SimpleQuery;


public class GenericDAO implements IGenericDAO {

    private JpaTemplate<Object, Long> jpaTemplate = new JpaTemplate<Object, Long>() {
    };

    public Object getEntityClass() {
        return jpaTemplate.getEntityClass();
    }

    public EntityManager getEntityManager() {
        return jpaTemplate.getEntityManager();
    }

    public void setEntityManager(EntityManager entityManager) {
        jpaTemplate.setEntityManager(entityManager);
    }

    /* -- CRUD -- */

    @Override
    public Object create(Object object) {
        return jpaTemplate.create(object);
    }

    @Override
    public Object saveOrUpdate(Object object) {
        return jpaTemplate.saveOrUpdate(object);
    }

    @Override
    public void update(Object object) {
        jpaTemplate.update(object);
    }

    @Override
    public void delete(Object object) {
        jpaTemplate.delete(object);
    }

    /* -- Payload -- */

    @SuppressWarnings("rawtypes")
    @Override
    public List findBy(Class<?> clazz, String query, Object... params) {
        Query q = getEntityManager().createQuery(
                jpaTemplate.createFindByQuery(clazz.getName(), query, params));
        return jpaTemplate.bindParameters(q, params).getResultList();
    }

    @Override
    public Object findById(Class<?> clazz, Long id) {
        return getEntityManager().find(clazz, id);
    };

    @SuppressWarnings("rawtypes")
    @Override
    public List findAll(Class<?> clazz) {
        return getEntityManager().createQuery("select e from " + clazz.getName() + " e").getResultList();
    }

    @Override
    public Long count(Class<?> clazz) {
        return Long.parseLong(getEntityManager()
                .createQuery("select count(e) from " + clazz.getName() + " e").getSingleResult().toString());
    }

    @Override
    public SimpleQuery simpleSelect(Class<?> clazz) {
        return jpaTemplate.simpleSelect(clazz);
    }

    @Override
    public SimpleQuery simpleSelect() {
        return jpaTemplate.simpleSelect();
    }
}
