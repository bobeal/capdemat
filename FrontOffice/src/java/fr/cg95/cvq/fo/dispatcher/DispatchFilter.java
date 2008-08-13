package fr.cg95.cvq.fo.dispatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.security.SecurityContext;

public class DispatchFilter implements Filter {

    private final static String URL_WEBAPP_ASSETS = "/assets/";
    private final static String URL_WEBAPP_COMMON = "/assets/common";
    private final static String URL_PATTERN = "/assets/common";
    
    private static FilterConfig filterConfig = null;
    private static File assetsDir = null;
    
    public DispatchFilter() {
        super();
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        DispatchFilter.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException {
        
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            
            String uri = httpRequest.getServletPath();
            
            uri = uri.substring(URL_PATTERN.length());
            
            if (getTerminal(httpRequest) != null) {
                if (getAssetsBaseFile("/terminal" + uri).exists())
                    uri = "/terminal" + uri;
            }
            if (getAssetsFile(uri).exists()) {
                String site = SecurityContext.getCurrentSite().getName();
                RequestDispatcher rd = filterConfig.getServletContext().getRequestDispatcher(URL_WEBAPP_ASSETS + site + uri);
                if (rd != null) {
                    rd.forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request,response);
    }

    private String getTerminal(HttpServletRequest pRequest) {
        Cookie cookies[] = pRequest.getCookies();
        if (cookies == null)
            return null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(Constants.COOKIE_NAME))
                return cookies[i].getValue();
        }
        return null;
    }

    public void destroy() {

    }

    public static File getAssetsBaseFile(String uri) {
        if (assetsDir == null)
            assetsDir = new File(BusinessManager.getAssetsBase());
            
        String site = SecurityContext.getCurrentSite().getName();
        File referentialSiteDir = new File(assetsDir, site);
        return new File(referentialSiteDir, uri);
    }
    
    public static File getAssetsFile(String uri) {
        if (assetsDir == null)
            assetsDir = new File(BusinessManager.getAssetsBase());
            
        String site = SecurityContext.getCurrentSite().getName();

        File webappSiteDir = new File(filterConfig.getServletContext().getRealPath(URL_WEBAPP_ASSETS), site);
        File referentialSiteDir = new File(assetsDir, site);

        File webappFile = new File(webappSiteDir, uri);
        File referentialFile = new File(referentialSiteDir, uri);
        
        updateAssetsFile(referentialFile, webappFile);
        
        return webappFile;
    }
    
    public static File getCommonAssetsFile(String uri) {
        File webappCommonDir = new File(filterConfig.getServletContext().getRealPath(URL_WEBAPP_COMMON));
        return new File(webappCommonDir, uri);
    }
    
    private static void updateAssetsFile(File srcFile, File dstFile) {

        // The source file doesn't exist anymore, so we delete the destination file
        if (!srcFile.exists() && dstFile.exists())
            dstFile.delete();
        
        // The source file is more recent than the destination file, we copy the source file
        else if (srcFile.lastModified() > dstFile.lastModified()) 
           copyFile(srcFile,dstFile);
    }
    
    private static boolean copyFile(File srcFile, File dstFile) {
        try {
            if (!dstFile.getParentFile().exists())
                dstFile.getParentFile().mkdirs();
            
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(dstFile);
            
            byte[] buffer = new byte[1024];
            
            int len = 0;
            while ((len = fis.read(buffer)) != -1)
                fos.write(buffer,0,len);
            
            fis.close();
            fos.close();
            
            return true;
            
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
        
    }
}
