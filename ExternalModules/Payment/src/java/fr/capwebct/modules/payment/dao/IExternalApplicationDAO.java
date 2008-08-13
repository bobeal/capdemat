package fr.capwebct.modules.payment.dao;

import org.springframework.dao.DataAccessException;

import fr.capwebct.modules.payment.business.ExternalApplication;

public interface IExternalApplicationDAO extends IGenericDAO<ExternalApplication, Long> {

    ExternalApplication findByLabel(String label) throws DataAccessException;
}
