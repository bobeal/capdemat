package fr.cg95.cvq.fo.taglib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.jsp.JspWriter;

import fr.cg95.cvq.fo.dispatcher.DispatchFilter;

public class InformationTag extends BaseTag {

    public InformationTag() {
        super();
    }

    public int doEndTag() {
        File file = DispatchFilter.getAssetsFile("html/" + getName());
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);

                fis = new FileInputStream(file);
                int length = fis.available();
                byte buffer[] = new byte[length];
                fis.read(buffer);
                fis.close();
                fis = null;

                JspWriter out = pageContext.getOut();

                out.write(new String(buffer));

            } catch (IOException ioe) {
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                } catch (IOException ioe) {
                }
            }
        }
        return EVAL_PAGE;
    }

}
