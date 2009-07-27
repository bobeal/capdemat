package fr.cg95.cvq.util.sms.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import cleversms.services.CleverSMSServiceProvider;
import cleversms.services.soap.CleverSMSMessageSEI;
import cleversms.services.soap.InvalidNumberException;
import cleversms.services.soap.NotEnoughCreditException;
import cleversms.services.soap.SmsMessage;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.util.sms.ISmsService;

public class SmsService implements ISmsService {

    private Logger logger = Logger.getLogger(SmsService.class);
    
    private String endportpath;
    private String username;
    private String password;
    private boolean enabled; 
    
    public void send(String number, String message) throws CvqException {
        try {
            CleverSMSServiceProvider provider = 
                new CleverSMSServiceProvider(endportpath, username, password);
            CleverSMSMessageSEI smsMessageService = provider.getMessageService();
            SmsMessage smsMessage = new SmsMessage();
            smsMessage.setMessage(message);
            // Hack to send internationalized phone numbers
            if (number.startsWith("06")) {
                smsMessage.setNumber("+33" + number.substring(1));
            } else {
                smsMessage.setNumber(number);
            }
            
            logger.debug("send() gonna send message " + message 
                    + " to " + number);
            int id = smsMessageService.sendSMSMessage(smsMessage);
            logger.debug("send() got SMS message ack " + id);
        } catch (ServiceException se) {
            logger.error("send() service exception : " + se.getMessage());
            se.printStackTrace();
            throw new CvqException("sms.technical_problem");
        } catch (InvalidNumberException ine) {
            logger.error("send() invalid number exception : " + ine.getMessage());
            ine.printStackTrace();            
            throw new CvqException("sms.invalid_number");
        } catch (NotEnoughCreditException nece) {
            logger.error("send() not enough credit exception : " + nece.getMessage());
            nece.printStackTrace();
            throw new CvqException("sms.not_enough_credit");
        } catch (RemoteException re) {
            logger.error("send() remote exception : " + re.getMessage());
            re.printStackTrace();
            throw new CvqException("sms.technical_problem");
        }
    }

    public void setEndportpath(String endportpath) {
        this.endportpath = endportpath;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
