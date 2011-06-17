package fr.cg95.cvq.util.admin;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.transform.Transformers;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.users.BankAccount;
import fr.cg95.cvq.business.users.FrenchRIB;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.request.hibernate.RequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;

public class FrenchRIBToIBAN {

    private static final BigDecimal c1 = new BigDecimal(97);

    private static final BigDecimal c2 = new BigDecimal(98);

    private LocalAuthorityRegistry localAuthorityRegistry;

    private CustomDAO customDAO = new CustomDAO();

    public static void main(final String[] args) {
        ClassPathXmlApplicationContext context = SpringApplicationContextLoader.loadContext(null);
        FrenchRIBToIBAN frti = new FrenchRIBToIBAN();
        frti.localAuthorityRegistry = (LocalAuthorityRegistry)context.getBean("localAuthorityRegistry");
        frti.localAuthorityRegistry.browseAndCallback(frti, "migrate", new String[]{args[0]});
        System.exit(0);
    }

    public void migrate(String requestType)
        throws CvqException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        for (SpecificDTO s : customDAO.select(requestType)) {
            Object requestData = customDAO.findById(s.clazz, s.id);
            FrenchRIB rib = customDAO.get(s);
            if (rib == null) continue;
            BankAccount ba = new BankAccount();
            ba.setBIC("");
            String temp = rib.format(null) + "FR00";
            StringBuilder extendedIban = new StringBuilder(temp.length());
            for (char currentChar : temp.toCharArray()) {
                extendedIban.append(Character.digit(currentChar,Character.MAX_RADIX));
            }
            ba.setIBAN("FR" + c2.subtract(new BigDecimal(extendedIban.toString()).remainder(c1)) + rib.format(null));
            s.clazz.getMethod("setBankAccount", BankAccount.class).invoke(requestData, ba);
            customDAO.saveOrUpdate(requestData);
        }
    }

    private class CustomDAO extends RequestDAO {
        public List<SpecificDTO> select(String label) {
            return HibernateUtil.getSession().createSQLQuery(
                "select specific_data_id as id, specific_data_class as clazz from request where request_type_id = (select id from request_type where label = :label) and state != :state"
            ).addScalar("id").addScalar("clazz").setString("label", label).setString("state", RequestState.ARCHIVED.toString())
                .setResultTransformer(Transformers.aliasToBean(SpecificDTO.class))
                .list();
        }
        public FrenchRIB get(SpecificDTO s) {
            return (FrenchRIB)HibernateUtil.getSession().createSQLQuery(
                "select * from french_r_i_b where id = (select french_r_i_b_id from "
                    + ((AbstractEntityPersister)HibernateUtil.getSessionFactory()
                        .getClassMetadata(s.clazz)).getTableName() + " where id = :id)")
                .addEntity(FrenchRIB.class).setLong("id", s.id).uniqueResult();
        }
    }

    public static class SpecificDTO {
        private Long id;
        public Class clazz;
        public void setId(BigInteger id) {
            if (id != null) this.id = id.longValue();
        }
        public void setClazz(String clazz)
            throws ClassNotFoundException {
            if (clazz != null) this.clazz = Class.forName(clazz);
        }
    }
}
