package fr.cg95.cvq.business.users.payment;

import java.util.Date;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.util.DateUtils;

/**
 * Represent an invoice emitted by a collectivity that can be paid online.
 * 
 * @hibernate.subclass
 *  discriminator-value="INVOICE"
 *  lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public class Invoice extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    private String reference;
    private Date issueDate;

    public Invoice() {
    }
    
    public Invoice(final String label, final Double amount,
            final Request request, final String supportedBroker, final String reference,
            final Date issueDate) {
        
        super(label, amount, request, supportedBroker);
        
        this.reference = reference;
        this.issueDate = issueDate;
    }
    
    /**
     * @hibernate.property
     *  column="reference"
     */
    public final String getReference() {
        return reference;
    }
    
    public final void setReference(String reference) {
        this.reference = reference;
    }
    
    /**
     * @hibernate.property
     *  column="issue_date"
     */
    public final Date getIssueDate() {
        return issueDate;
    }
    
    public final void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String getFriendlyLabel() {

        StringBuffer sb = new StringBuffer().append("Facture ").append(getLabel())
            .append(" (n° ").append(getReference()).append(") du ")
            .append(DateUtils.format(getIssueDate())).append(" de ")
            .append(getEuroAmount());
    
        return sb.toString();
    }

    @Override
    public String getInformativeFriendlyLabel() {

        StringBuffer sb = new StringBuffer().append("Facture ").append(getLabel())
            .append(" (n° ").append(getReference()).append(") du ")
            .append(DateUtils.format(getIssueDate()));

        return sb.toString();
    }
}
