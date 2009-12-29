package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.dao.request.IMeansOfContactDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IMeansOfContactService;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.util.sms.ISmsService;

/**
 * Implementation of the {@link IMeansOfContactService} service.
 *
 * @author rdj@zenexity.fr
 */
public class MeansOfContactService implements IMeansOfContactService, ILocalAuthorityLifecycleAware {

    static Logger logger = Logger.getLogger(MeansOfContactService.class);

    protected ILocalAuthorityRegistry localAuthorityRegistry;
    private IMeansOfContactDAO meansOfContactDAO;
    private Boolean performDbUpdates;

    private IMailService mailService;
    private ISmsService smsService;

    public MeansOfContact getById(Long id) throws CvqObjectNotFoundException {
        return (MeansOfContact) meansOfContactDAO.findById(MeansOfContact.class, id);
    }
    
    /* BE CAREFUL :
     *  - MeansOfContact removing not yet implement ...
     *  - EMAIL MeansOfContact is enabled by default
     */
    @Context(type=ContextType.SUPER_ADMIN)
    private void initAvalaibleMeansOfContact() {
        logger.debug("initAvalaibleMeansOfContact() init for " 
            + SecurityContext.getCurrentSite().getName());

        MeansOfContactEnum[] mocArray = MeansOfContactEnum.allMeansOfContactEnums;
        List<MeansOfContact> mocList = meansOfContactDAO.listAll();

        boolean isMocPersist;
        for (int i = 0; i < mocArray.length; i++) {
            isMocPersist = false;
            for (MeansOfContact moc : mocList) {
                if (moc.getType().equals(mocArray[i])) {
                    isMocPersist = true;
                    break;
                }
            }
            if (!isMocPersist) {
                MeansOfContact meansOfContact = new MeansOfContact(mocArray[i]);
                if(meansOfContact.getType().equals(MeansOfContactEnum.EMAIL))
                    meansOfContact.setEnabled(true);
                meansOfContactDAO.create(meansOfContact);
            }
        }
    }

    @Override
    @Context(type=ContextType.SUPER_ADMIN)
    public void addLocalAuthority(String localAuthorityName) {
        if (performDbUpdates) initAvalaibleMeansOfContact();
    }

    @Override
    @Context(type=ContextType.SUPER_ADMIN)
    public void removeLocalAuthority(String localAuthorityName) {
    }

    public MeansOfContact getMeansOfContactByType(MeansOfContactEnum type) {
        return meansOfContactDAO.findByType(type);
    }

    private boolean canDisableMeansOfContact(MeansOfContact meansOfContact) {
        List<MeansOfContact> enableMocList = meansOfContactDAO.listAllEnabled();
        if (enableMocList.size() == 1)
            if (enableMocList.get(0).equals(meansOfContact))
                return false;

        return true;
    }

    public void disableMeansOfContact(Long mocId)
        throws CvqModelException, CvqObjectNotFoundException {
        MeansOfContact moc = getById(mocId);
        disableMeansOfContact(moc);
    }
    
    public void disableMeansOfContact(MeansOfContact meansOfContact)
        throws CvqModelException {
        if (!canDisableMeansOfContact(meansOfContact))
            throw new CvqModelException("request.meansOfContact.message.mustHaveOneEnabled");
        meansOfContact.setEnabled(false);
        meansOfContactDAO.update(meansOfContact);
    }

    public void enableMeansOfContact(MeansOfContact meansOfContact) {
        meansOfContact.setEnabled(true);
        meansOfContactDAO.update(meansOfContact);
    }

    public List<MeansOfContact> getAvailableMeansOfContact() {
        List<MeansOfContact> results = meansOfContactDAO.listAll();
        Collections.sort(results);
        return results;
    }

    public List<MeansOfContact> getEnabledMeansOfContact() {
        return meansOfContactDAO.listAllEnabled();
    }

    private MeansOfContact getFromListByType(List<MeansOfContact> mocList, MeansOfContactEnum type){
        for (MeansOfContact moc : mocList){
            if (moc.getType().equals(type))
                return moc;
        }
        return null;
    }

    public List<MeansOfContact> getCurrentEcitizenEnabledMeansOfContact() {
        return getAdultEnabledMeansOfContact(SecurityContext.getCurrentEcitizen());
    }

    public List<MeansOfContact> getAdultEnabledMeansOfContact(Adult adult) {
        List<MeansOfContact> enableMocList = meansOfContactDAO.listAllEnabled();
        List<MeansOfContact> individualEnableMocList = new ArrayList<MeansOfContact>();

        if (adult != null) {
            MeansOfContact moc = getFromListByType(enableMocList, MeansOfContactEnum.MAIL);
            if(adult.getAdress() != null &&  moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.EMAIL);
            if(adult.getEmail() != null &&  adult.getEmail().length() > 0 && moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.HOME_PHONE);
            if(adult.getHomePhone() != null &&  adult.getHomePhone().length() > 0 && moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.OFFICE_PHONE);
            if(adult.getOfficePhone() != null && adult.getOfficePhone().length() > 0 && moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.MOBILE_PHONE);
            if(adult.getMobilePhone() != null && adult.getMobilePhone().length() > 0 && moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.SMS);
            if(adult.getMobilePhone() != null && adult.getMobilePhone().length() > 0 &&  moc != null)
                individualEnableMocList.add(moc);

            moc = getFromListByType(enableMocList, MeansOfContactEnum.LOCAL_AUTHORITY_OFFICE);
            if(moc != null)
                individualEnableMocList.add(moc);
        }
        if (individualEnableMocList.size() > 0)
            return individualEnableMocList;
        else
            return null;
    }

    public boolean supportAttachment(MeansOfContact moc) {
        if (moc.getType() == MeansOfContactEnum.MAIL || moc.getType() == MeansOfContactEnum.EMAIL)
            return true;
        return false;
    }

    public void notifyByEmail(String from, String to, String subject,
        String body, byte[] data, String attachmentName)
        throws CvqException {
        String fullSubject =
            "[" + SecurityContext.getCurrentSite().getDisplayTitle() + "] "
            + subject;
        mailService.send(from, to, null, fullSubject, body, data, attachmentName);
    }

    public void notifyBySms(String to, String body)
        throws CvqException {
        if (smsService.isEnabled()) {
            smsService.send(to, body);
        } else {
            throw new CvqException("sms_service.not.enabled");
        }
    }

    public void setMeansOfContactDAO(IMeansOfContactDAO meansOfContactDAO) {
        this.meansOfContactDAO = meansOfContactDAO;
    }

    public void setPerformDbUpdates(Boolean performDbUpdates) {
        if (performDbUpdates != null)
            this.performDbUpdates = performDbUpdates;
        else
            this.performDbUpdates = Boolean.FALSE;
    }

    public void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public void setSmsService(ISmsService smsService) {
        this.smsService = smsService;
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}
