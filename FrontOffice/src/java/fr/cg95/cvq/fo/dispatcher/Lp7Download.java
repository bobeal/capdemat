package fr.cg95.cvq.fo.dispatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.form.DocumentForm;

public class Lp7Download extends HttpServlet {

    public Lp7Download() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {
        FamilyHome familyHome = SessionManager.getFamilyHome(request);
        
        DocumentForm documentForm = familyHome.getCurrentDocument();

        File download = documentForm.getCertifiedFile();
        
        int fileSize = (int)download.length();
        
        response.setContentType("application/download");
        response.setHeader("Content-Disposition", "attachment;filename=" + download.getName());
        response.setContentLength(fileSize);
        
        byte[] buffer = new byte[fileSize];
        
        InputStream is = new FileInputStream(download);
        is.read(buffer);
        
        try {
            response.getOutputStream().write(buffer);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    IOException {
        doGet(request,response);
    }
    
}
