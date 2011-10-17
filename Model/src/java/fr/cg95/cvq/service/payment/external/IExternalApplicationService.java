package fr.cg95.cvq.service.payment.external;

import java.util.List;
import java.util.Map;

import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.payment.external.ExternalApplication;
import fr.cg95.cvq.business.payment.external.ExternalHomeFolder;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

public interface IExternalApplicationService {

    final static String EXTERNAL_APPLICATION_LABEL = "CAPDEMAT";

    ExternalApplication getExternalApplicationById(final Long id) throws CvqObjectNotFoundException;

    List<ExternalApplication> allExternalApplications();

    void createExternalApplication(ExternalApplication externalApplication) throws CvqModelException;

    void modifyExternalApplication(ExternalApplication externalApplication) throws CvqModelException;

    void deleteExternalApplication(final Long id) throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importHomeFolders(Long externalApplicationId, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importInvoices(Long externalApplicationId, String broker, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importInvoicesDetails(Long externalApplicationId, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importDepositAccounts(Long externalApplicationId, String broker, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importDepositAccountsDetails(Long externalApplicationId, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    Map<String,Integer> importTicketingContracts(Long externalApplicationId, String broker, byte[] csvDatas)
            throws CvqModelException, CvqObjectNotFoundException;

    List<ExternalHomeFolder> getHomeFolders(Integer offset, Integer max) throws CvqException;

    ExternalHomeFolder getHomeFolder(Long id) throws CvqException;

    ExternalHomeFolder getHomeFolder(Long externalApplicationId, String externalId) throws CvqException;

    List<ExternalHomeFolder> getHomeFolders(Long externalApplicationId, Integer offset, Integer max) throws CvqException;

    void modifyHomeFolder(ExternalHomeFolder eh) throws CvqException;

    List<Adult> matchAdults(Long externalHomeFolderId);

    List<ExternalInvoiceItem> getExternalInvoiceItems(String externalApplicationId);

    List<ExternalDepositAccountItem> getExternalDepositAccountItems(String externalApplicationId);

    List<ExternalTicketingContractItem> getExternalTicketingContractItems(
            String externalApplicationId);
}
