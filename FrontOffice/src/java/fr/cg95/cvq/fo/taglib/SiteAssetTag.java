package fr.cg95.cvq.fo.taglib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.fo.dispatcher.DispatchFilter;

public class SiteAssetTag extends BaseTag {

    public int doEndTag() {
        try {
            JspWriter out = pageContext.getOut();
            File file = DispatchFilter.getAssetsFile(getProperty() + "/" + getName());

            if (!file.exists())
                file = DispatchFilter.getCommonAssetsFile(getProperty() + "/" + getName());
            
            if (file.exists()) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    int length = fis.available();
                    byte buffer[] = new byte[length];
                    fis.read(buffer);
                    out.write(new String(buffer));
                    fis.close();
                } catch (IOException ioe) {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException io) {
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return EVAL_PAGE;
    }
}
