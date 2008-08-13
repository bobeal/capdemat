package fr.cg95.cvq.bo.dispatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.security.SecurityContext;

/**
 * Very simple filter used to serve Back Office logo from the current local authority's assets
 * directory.
 */
public class DispatchFilter implements Filter {

    private final static String ASSETS_BASE = "/assets";
    
    private static File assetsDir = null;
    
    public DispatchFilter() {
        super();
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException {
        
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            
            String uri = httpRequest.getServletPath();
            uri = uri.substring(ASSETS_BASE.length());
            FileInputStream fis = null;
            try {
                File assetsFile = getAssetsBaseFile(uri);
                if (assetsFile == null || !assetsFile.exists())
                    return;
                fis = new FileInputStream(assetsFile);
                OutputStream os = response.getOutputStream();
                final byte[] buffer = new byte[4096];
                int n;
                while (-1 != (n = fis.read(buffer))) {
                    os.write(buffer, 0, n);
                }
                os.flush();
            } finally {
                if (fis != null)
                    fis.close();
            }
            return;
        }
    }

    public void destroy() {
    }

    public static File getAssetsBaseFile(String uri) {
        if (assetsDir == null)
            assetsDir = new File(BusinessManager.getAssetsBase());
            
        String site = SecurityContext.getCurrentSite().getName();
        File assetsSiteDir = new File(assetsDir, site);
        return new File(assetsSiteDir, uri);
    }
    
    public static String[] getAssetsBaseFiles(String dir, FilenameFilter filter) {
        if (assetsDir == null)
            assetsDir = new File(BusinessManager.getAssetsBase());
            
        String site = SecurityContext.getCurrentSite().getName();
        File assetsSiteDir = new File(assetsDir, site);
        File subDir = new File(assetsSiteDir, dir);
        return subDir.list(filter);
    }
    
    public static boolean copyFile(InputStream is, File dstFile) {
        try {
            if (!dstFile.getParentFile().exists())
                dstFile.getParentFile().mkdirs();
            
            FileOutputStream fos = new FileOutputStream(dstFile);
            
            byte[] buffer = new byte[1024];
            
            int len = 0;
            while ((len = is.read(buffer)) != -1)
                fos.write(buffer,0,len);
            
            fos.close();
            
            return true;
            
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }
}
