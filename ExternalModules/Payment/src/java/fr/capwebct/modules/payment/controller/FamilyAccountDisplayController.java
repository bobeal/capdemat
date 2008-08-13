package fr.capwebct.modules.payment.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.capwebct.modules.payment.business.Account;
import fr.capwebct.modules.payment.business.CapwebctFamilyAccount;
import fr.capwebct.modules.payment.business.Contract;
import fr.capwebct.modules.payment.business.ExternalFamilyAccount;
import fr.capwebct.modules.payment.business.Invoice;
import fr.capwebct.modules.payment.service.IAccountService;
import fr.capwebct.modules.payment.service.IContractService;
import fr.capwebct.modules.payment.service.IFamilyAccountService;
import fr.capwebct.modules.payment.service.IInvoiceService;

public class FamilyAccountDisplayController extends AbstractController {

    private IFamilyAccountService familyAccountService;
    private IInvoiceService invoiceService;
    private IContractService contractService;
    private IAccountService accountService;
    
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setContractService(IContractService contractService) {
        this.contractService = contractService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("display");
        
        String origin = request.getParameter("origin");
        
        if (origin != null) {
            // store the search query the user entered, to be able to send him back to search screen
            StringBuffer searchQueryBuffer = new StringBuffer();
            searchQueryBuffer.append("?origin=").append(origin);
            
            if (origin.equals("searchCapwebct")) {
                if (!request.getParameter("searchedCfaId").equals(""))
                    searchQueryBuffer.append("&cfaId=")
                        .append(request.getParameter("searchedCfaId"));
                if (!request.getParameter("searchedCfaResponsible").equals(""))
                    searchQueryBuffer.append("&cfaResponsible=")
                        .append(request.getParameter("searchedCfaResponsible"));                
            } else if (origin.equals("searchExternal")) {
                if (!request.getParameter("searchedEfaId").equals(""))
                    searchQueryBuffer.append("&efaId=")
                        .append(request.getParameter("searchedEfaId"));
                if (!request.getParameter("searchedExternalApplicationId").equals(""))
                    searchQueryBuffer.append("&externalApplicationId=")
                        .append(request.getParameter("searchedExternalApplicationId"));                
            }
            
            mav.addObject("searchOrigin", origin);
            mav.addObject("familyAccountSearchQuery", searchQueryBuffer.toString());            
        }
        
        String cfaId = request.getParameter("cfaId");
        if (cfaId == null) {
            mav.addObject("error_message", "familyaccount.display.error.no_cfa_id");
            return mav;
        }
            
        Long parsedCfaId = null;
        try {
            parsedCfaId = Long.valueOf(cfaId);
        } catch (NumberFormatException nfe) {
            mav.addObject("error_message", "familyaccount.display.error.bad_format_cfa_id");
            mav.addObject("error_message_param", cfaId);            
            return mav;
        }
        
        CapwebctFamilyAccount cfa = familyAccountService.getCfaByCapwebctId(parsedCfaId);
        if (cfa == null) {
            mav.addObject("error_message", "familyaccount.display.error.unknown_cfa_id");
            mav.addObject("error_message_param", cfaId);            
            return mav;
        }
        
        List<ExternalFamilyAccount> efaList = 
            familyAccountService.getByCapWebctFamilyAccountId(parsedCfaId);
        Set<Invoice> invoices = new HashSet<Invoice>();
        Set<Account> accounts = new HashSet<Account>();
        Set<Contract> contracts = new HashSet<Contract>();
        for (ExternalFamilyAccount efa : efaList) {
            if (efa.getInvoices() != null)
                invoices.addAll(invoiceService.getByExternalId(efa.getExternalFamilyAccountId(), 0));
            if (efa.getAccounts() != null)
                accounts.addAll(accountService.getByExternalId(efa.getExternalFamilyAccountId(), 0));
            if (efa.getContracts() != null)
                contracts.addAll(contractService.getByExternalId(efa.getExternalFamilyAccountId(), 0, null));
        }
        
        mav.addObject("familyaccount", cfa);
        
        if (invoices.size() > 0) {
            mav.addObject("invoices", invoices);
            mav.addObject("invoicesSize", invoices.size());
        }

        if (accounts.size() > 0) {
            mav.addObject("accounts", accounts);
            mav.addObject("accountsSize", accounts.size());
        }
        
        if (contracts.size() > 0) {
            mav.addObject("contracts", contracts);
            mav.addObject("contractsSize", contracts.size());
        }
        
        return mav;
    }

    public void setFamilyAccountService(IFamilyAccountService familyAccountService) {
        this.familyAccountService = familyAccountService;
    }
}
