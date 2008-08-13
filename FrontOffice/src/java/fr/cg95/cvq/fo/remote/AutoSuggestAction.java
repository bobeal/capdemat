package fr.cg95.cvq.fo.remote;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AutoSuggestAction extends Action {

    private class Town {

        String name = null;
        String postalCode = null;
        
        Town(String name, String postalCode) {
            this.name = name;
            this.postalCode = postalCode;
        }
    }

    private Town[] townList = {
        new Town("Saint-Germain-en-Laye","78100"),
        new Town("Franconville","95130"),
        new Town("Plessis-Bouchard","95130"),
        new Town("Sannois","95110"),
        new Town("Saint-Gratien","95210"),
        new Town("Ermont","95120")
    };
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String type = request.getParameter("type");
        String userInput = request.getParameter("userInput");
        String additionalUserInput = request.getParameter("additionalUserInput");
        
        response.setContentType("text/plain; charset=UTF-8");

        ServletOutputStream out = response.getOutputStream();

        List<String> suggestions = null;
        if (type.equals("town"))
            suggestions = getTowns(userInput, additionalUserInput);
        
        else if (type.equals("postalcode"))
            suggestions = getPostalCodes(userInput, additionalUserInput);
        
        out.print("[");
        boolean first = true;
        for (String suggestion : suggestions) {
            if (!first)
                out.print(",");
            else
                first = false;
            
            out.print("\"" + suggestion + "\"");
        }
        out.print("]");
        response.setStatus(200);

        return null;
    }
    
    private List<String> getTowns(String town, String postalCode) {
        ArrayList<String> towns = new ArrayList<String>();
        
        town = town.toLowerCase();
//        if ((town.length() > 1) || (postalCode.length() > 1))
//            for (int i = 0; i < townList.length; i++) {
//                if (townList[i].name.toLowerCase().startsWith(town))
////                    if (postalCode.length() < 5) {
//                       if (townList[i].postalCode.startsWith(postalCode)) {
//                           towns.add(townList[i].name.toUpperCase());
//                           towns.add(townList[i].postalCode);
//                       }
////                    } else {
////                        towns.add(townList[i].name);
////                        towns.add(townList[i].postalCode);
////                    }
//            }
        return towns;
    }

    private List<String> getPostalCodes(String postalCode, String town) {
        ArrayList<String> codes = new ArrayList<String>();
        
//        if (postalCode.length() > 1)
//            for (int i = 0; i < townList.length; i++) {
//                if (townList[i].postalCode.startsWith(postalCode)) {
//                    if ((i > 0) && (townList[i].postalCode.equals(townList[i-1].postalCode))) {
//                        codes.set(codes.size()-1, "");
//                    } else {
//                        codes.add(townList[i].postalCode);
//                        codes.add(townList[i].name.toUpperCase());
//                    }
//                }
//            }
        return codes;
    }

}
