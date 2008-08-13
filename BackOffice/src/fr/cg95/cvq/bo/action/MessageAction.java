package fr.cg95.cvq.bo.action;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.cg95.cvq.bo.dispatcher.DispatchFilter;
import fr.cg95.cvq.bo.form.MessageForm;

public class MessageAction extends BaseAction {

    protected ActionForward executeLogic(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        MessageForm messageForm = (MessageForm)form;

        if (messageForm.getMessage() == null) {
            File file = DispatchFilter.getAssetsBaseFile("html/paiementmessage.html");
            messageForm.setBlockPayment(file.exists());
            
            if (!file.exists()) {
                file = DispatchFilter.getAssetsBaseFile("html/paiementmessage.html.out");
            }
            if (file.exists()) {
                int size = new Long(file.length()).intValue();
                char[] buf = new char[size];
                FileReader reader = new FileReader(file);
                reader.read(buf);
                reader.close();
                messageForm.setMessage(new String(buf));
            }
            file.getParentFile().mkdirs();
        }        
        File file = DispatchFilter.getAssetsBaseFile("html/paiementmessage.html");
        
        if (messageForm.isBlockPayment()) {
            FileWriter writer = new FileWriter(file);
            writer.write(messageForm.getMessage());
            writer.close();
            file = DispatchFilter.getAssetsBaseFile("html/paiementmessage.html.out");
            file.delete();
            
        } else {
            if (file.exists())
                file.renameTo(DispatchFilter.getAssetsBaseFile("html/paiementmessage.html.out"));
        }
        
        request.setAttribute("MessageForm", messageForm);
        return null;
    }

}
