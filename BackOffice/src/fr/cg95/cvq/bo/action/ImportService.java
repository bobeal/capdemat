package fr.cg95.cvq.bo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.bo.form.ImportExportForm;
import fr.cg95.cvq.bo.manager.RequestManager;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.RequestsDocument;

public class ImportService extends Action {

    public ImportService() {
        super();
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String callback = request.getParameter("callback");
        if (callback != null) {
            callback += "?ack=" + request.getSession().getId();
            response.sendRedirect(callback);
            
        } else {
            InputStream stream = null;
            if ((form != null) && (form instanceof ImportExportForm)) {
                stream = ((ImportExportForm)form).getFile().getInputStream();
            } else {
                stream = request.getInputStream();
            }                
            if (stream != null) {
                RequestType[] demands = loadImportFile(stream);
    
                ArrayList<Object> result = importRequests(new RequestManager(), demands);
                
                writeResponse(response.getWriter(), demands, result);
    
                response.setContentType("text/xml; charset=UTF-8");
                response.setStatus(200);
            } else {
                response.setStatus(500);
            }
        }
        return null;
    }

    private void writeResponse(PrintWriter out, RequestType[] demands, ArrayList<Object> result) {
        out.write("<result>\n");
        for (int i = 0; i < demands.length; i ++) {
            out.write("<request index=\"" + i + "\">\n");
            out.write(result.get(i).toString() + "\n");
            out.write("</request>\n");
        }
        out.write("</result>\n");
    }

    private RequestType[] loadImportFile(InputStream stream) throws XmlException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));  
        RequestsDocument document = RequestsDocument.Factory.parse(reader);
        RequestType[] requests = document.getRequests().getRequestArray();
        RequestType[] xmlRequests = new RequestType[document.getRequests().sizeOfRequestArray()];
        for (int i = 0; i < requests.length; i ++) {
            try {
                Object xmlObject = XmlObject.Factory.parse(requests[i].getDomNode().getFirstChild().getNextSibling());

                String name = requests[i].getDomNode().getFirstChild().getNextSibling().getNodeName();
                Method method = xmlObject.getClass().getMethod("get"+name, (Class[])null);
                
                xmlRequests[i] = (RequestType)method.invoke(xmlObject, (Object[])null);;

            } catch (XmlException e) {
                e.getMessage();
            } catch (SecurityException e) {
                e.getMessage();
            } catch (NoSuchMethodException e) {
                e.getMessage();
            } catch (IllegalArgumentException e) {
                e.getMessage();
            } catch (IllegalAccessException e) {
                e.getMessage();
            } catch (InvocationTargetException e) {
                e.getMessage();
            }
        }
        return xmlRequests;
    }

    private ArrayList<Object> importRequests(RequestManager requestManager, RequestType[] demands) {
        ArrayList<Object> result = new ArrayList<Object>();
        
        for (int i = 0; i < demands.length; i++) {
            try {
                if (demands[i] != null) {
                    Long id = requestManager.importRequest(demands[i]);
                    result.add(id);

                } else {
                    result.add("Error obtaining parsed requesttype.");
                }
                
            } catch (Exception e) {
                result.add(e.toString());
            }
        }
        return result;
    }
    
}
