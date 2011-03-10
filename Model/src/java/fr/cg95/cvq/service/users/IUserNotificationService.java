package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserNotificationService {

    void contact(@IsUser Adult adult, MeansOfContactEnum moc, String to, String message, String note)
        throws CvqException;

    void notifyByEmail(String from, String recipient, String subject, String body, byte[] data, String attachmentName)
        throws CvqException;

    void notifyBySms(String to, String body)
        throws CvqException;
}
