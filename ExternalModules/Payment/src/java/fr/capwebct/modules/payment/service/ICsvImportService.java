package fr.capwebct.modules.payment.service;

import java.util.List;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.exception.CpmParsingException;

public interface ICsvImportService {

    List<Object> parseData(final String importType, final ExternalDataType dataType, final byte[] data) 
            throws CpmParsingException;
}
