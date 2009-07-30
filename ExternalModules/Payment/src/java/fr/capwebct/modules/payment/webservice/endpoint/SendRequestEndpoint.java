package fr.capwebct.modules.payment.webservice.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.oxm.Marshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.CapwebctIndividual;
import fr.capwebct.modules.payment.exception.CpmBusinessException;
import fr.capwebct.modules.payment.schema.sre.SendRequestRequestDocument;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.HomeFolderType;
import fr.cg95.cvq.xml.common.IndividualRoleType;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.RequestType;

public class SendRequestEndpoint extends AbstractMarshallingPayloadEndpoint {

    private IFamilyAccountService familyAccountService;

    public SendRequestEndpoint(Marshaller marshaller,
        IFamilyAccountService familyAccountService) {
        super(marshaller);
        this.familyAccountService = familyAccountService;
    }

    @Override
    protected Object invokeInternal(Object requestObject) throws Exception {
        RequestType request = ((SendRequestRequestDocument) requestObject)
            .getSendRequestRequest().getRequest();
        if (!"Home Folder Modification".equals(request.getRequestTypeLabel())
            && !"VO Card".equals(request.getRequestTypeLabel())) {
            throw new CpmBusinessException("Received an unsupported request type : "
                + request.getRequestTypeLabel());
        }
        List<CapwebctFamilyAccount> accounts = new ArrayList<CapwebctFamilyAccount>(1);
        CapwebctFamilyAccount cfa = new CapwebctFamilyAccount();
        accounts.add(cfa);
        HomeFolderType homeFolder = request.getHomeFolder();
        cfa.setCapwebctFamilyAccountId(homeFolder.getId());
        cfa.setAddress(homeFolder.getAddress().getStreetNumber()
            + " " + homeFolder.getAddress().getStreetName());
        for (IndividualType individualType : homeFolder.getIndividualsArray()) {
            CapwebctIndividual capwebctIndividual = new CapwebctIndividual();
            capwebctIndividual.setCapwebctIndividualId(individualType.getId());
            capwebctIndividual.setFirstName(individualType.getFirstName());
            capwebctIndividual.setLastName(individualType.getLastName());
            capwebctIndividual.setChild(individualType instanceof ChildType);
            capwebctIndividual.setResponsible(false);
            for (IndividualRoleType individualRoleType :
                individualType.getRoleArray()) {
                if (individualRoleType.isSetHomeFolderId()) {
                    capwebctIndividual.setResponsible(true);
                    cfa.setResponsibleFullName(individualType.getLastName() + " " + individualType.getFirstName());
                    break;
                }
            }
            cfa.addIndividual(capwebctIndividual);
        }
        familyAccountService.importCapwebctFamilyAccounts(accounts);
        return null;
    }
}
