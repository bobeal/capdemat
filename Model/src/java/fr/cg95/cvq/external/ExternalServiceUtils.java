package fr.cg95.cvq.external;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.jdom.output.XMLOutputter;

import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.payment.ExternalAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.users.payment.ExternalTicketingContractItem;
import fr.cg95.cvq.business.users.payment.PurchaseItem;
import fr.cg95.cvq.security.SecurityContext;

public class ExternalServiceUtils {

    private static Logger logger = Logger.getLogger(ExternalServiceUtils.class);

    private static String encoding = "UTF-8";

    public static String paymentToXml(final Collection<PurchaseItem> purchaseItems, 
            final String cvqReference, final String bankReference, final HomeFolder homeFolder, 
            final Date validationDate) 
        throws IOException {
        
        int total = 0;
        for (PurchaseItem purchaseItem : purchaseItems) {
            total = total + purchaseItem.getAmount().intValue();
        }

        // build XML attachment
        // TODO : use XMLBeans to generate all that shit according to BankTransaction.xsd
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS");
        org.jdom.Document document = new org.jdom.Document();
        org.jdom.Element rootNode = new org.jdom.Element("bank-transaction");
        rootNode.setAttribute("version", "1.0");
        org.jdom.Element payment = new org.jdom.Element("payment");
        payment.setAttribute("payment-date", simpleDateFormat.format(validationDate));
        payment.setAttribute("payment-amount", total + "");
        payment.setAttribute("payment-ack", bankReference);
        payment.setAttribute("cvq-ack", cvqReference);
        rootNode.addContent(payment);
        org.jdom.Element family = new org.jdom.Element("family");
        family.setAttribute("id", homeFolder.getId().toString());
        family.setAttribute("zip", SecurityContext.getCurrentSite().getPostalCode());
        rootNode.addContent(family);
        org.jdom.Element accounts = new org.jdom.Element("accounts");
        rootNode.addContent(accounts);
        document.setRootElement(rootNode);
        for (Iterator i = purchaseItems.iterator(); i.hasNext();) {
            ExternalAccountItem eai = (ExternalAccountItem) i.next();
            org.jdom.Element account = new org.jdom.Element("account");
            account.setAttribute("account-id", eai.getExternalItemId());
            if (eai.getRequest() != null)
                account.setAttribute("request-id", eai.getRequest().getId().toString());
            if (eai instanceof ExternalDepositAccountItem) {
                ExternalDepositAccountItem edai = (ExternalDepositAccountItem) eai;
                account.setAttribute("account-old-value", edai.getOldValue().intValue() + "");
                account.setAttribute("account-old-value-date", 
                        simpleDateFormat.format(edai.getOldValueDate()));
                account.setAttribute("account-new-value", 
                        String.valueOf(edai.getOldValue().intValue() 
                                + edai.getAmount().intValue()));
                // FIX for HoraNet that wants a quantity and price attribute even
                // when it has no sense
                account.setAttribute("qantity", "0");
                account.setAttribute("price", "0");
            } else if (eai instanceof ExternalTicketingContractItem) {
                ExternalTicketingContractItem etci = (ExternalTicketingContractItem) eai;
                // FIX for HoraNet that wants accounts related values even
                // when it has no sense
//                account.setAttribute("account-old-value", "0");
//                account.setAttribute("account-old-value-date", 
//                        simpleDateFormat.format(new Date()));
//                account.setAttribute("account-new-value", "0");
                account.setAttribute("qantity", etci.getQuantity() + "");
                account.setAttribute("price", etci.getUnitPrice().intValue() + "");
                account.setAttribute("child-id", String.valueOf(etci.getSubjectId()));
            }
            account.setAttribute("amount", String.valueOf(eai.getAmount().intValue()));
            accounts.addContent(account);
        }
        StringWriter stringWriter = new StringWriter();
        XMLOutputter outputter = new XMLOutputter();
        outputter.getFormat().setEncoding(encoding);
        outputter.output(document, stringWriter);
        stringWriter.close();
        logger.debug("paymentsToXml() Preparing to send : " + stringWriter.toString());
        
        return stringWriter.toString();
    }
}
