package fr.cg95.cvq.service.users;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.MeansOfContactEnum;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.annotation.IsUser;

public interface IUserNotificationService {

    /** the notification type to use when a password is reset via secret question/answer */
    public static enum PasswordResetNotificationType {
        /** the adult has an email address it will be sent to*/
        ADULT_EMAIL,
        /** the adult has no email address but the VO Card Request category has one */
        CATEGORY_EMAIL,
        /** none have an address, the password will be output in the success message */
        INLINE;
    }

    void contact(@IsUser Adult adult, MeansOfContactEnum moc, String to, String message, String note)
        throws CvqException;

    /**
     * Send the new password by email to the home folder's responsible,
     * or to the category address if the responsible has no email address,
     * or does nothing if none have an address.
     *
     * @return the notification type used to send the new password
     */
    PasswordResetNotificationType notifyPasswordReset(Adult adult, String password, String categoryAddress)
        throws CvqException;

    void notifyByEmail(String from, String recipient, String subject, String body, byte[] data, String attachmentName)
        throws CvqException;

    void notifyBySms(String to, String body)
        throws CvqException;
}
