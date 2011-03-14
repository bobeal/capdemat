package fr.cg95.cvq.service.authority.impl;

import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.dao.authority.ISchoolDAO;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ISchoolService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * This class provides School related business logic and
 * services to other layers
 *
 * @author bor@zenexity.fr
 *
 */
public class SchoolService implements ISchoolService {

    private static Logger logger = Logger.getLogger(SchoolService.class);

    private ISchoolDAO schoolDAO;

    @Override
    public School getByName(final String schoolName) {
        return schoolDAO.findByName(schoolName);
    }

    @Override
    public School getById(Long id)
        throws CvqObjectNotFoundException {
        return (School)schoolDAO.findById(School.class, id);
    }

    @Override
    public List<School> getAll() {
        return schoolDAO.listAll();
    }

    @Override
    public List<School> getActives() {
        return schoolDAO.getActives();
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.WRITE)
    public Long create(final School school) {
        Long schoolId = null;
        if (school != null)
            schoolId = schoolDAO.create(school);
        logger.debug("Created school object with id : " + schoolId);
        return schoolId;
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.WRITE)
    public void modify(final School school) {
        if (school != null)
            schoolDAO.update(school);
    }

    public void setDAO(ISchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }
}
