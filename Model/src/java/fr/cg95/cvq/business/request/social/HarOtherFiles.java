package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="har_other_files"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarOtherFiles implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarOtherFiles() {
        super();
    }


    public final String modelToXmlString() {

        HarOtherFilesType object = (HarOtherFilesType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HarOtherFilesType harOtherFiles = HarOtherFilesType.Factory.newInstance();
        harOtherFiles.setHarOtherNumber(this.harOtherNumber);
        harOtherFiles.setHarOtherDepartment(this.harOtherDepartment);
        harOtherFiles.setHarOtherFile(this.harOtherFile);
        return harOtherFiles;
    }

    public static HarOtherFiles xmlToModel(HarOtherFilesType harOtherFilesDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarOtherFiles harOtherFiles = new HarOtherFiles();
        harOtherFiles.setHarOtherNumber(harOtherFilesDoc.getHarOtherNumber());
        harOtherFiles.setHarOtherDepartment(harOtherFilesDoc.getHarOtherDepartment());
        harOtherFiles.setHarOtherFile(harOtherFilesDoc.getHarOtherFile());
        return harOtherFiles;
    }

    private Long id;


    public final void setId(final Long id) {
        this.id = id;
    }


    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

    private String harOtherNumber;

    public final void setHarOtherNumber(final String harOtherNumber) {
        this.harOtherNumber = harOtherNumber;
    }


    /**
     * @hibernate.property
     *  column="har_other_number"
     */
    public final String getHarOtherNumber() {
        return this.harOtherNumber;
    }

    private String harOtherDepartment;

    public final void setHarOtherDepartment(final String harOtherDepartment) {
        this.harOtherDepartment = harOtherDepartment;
    }


    /**
     * @hibernate.property
     *  column="har_other_department"
     */
    public final String getHarOtherDepartment() {
        return this.harOtherDepartment;
    }

    private String harOtherFile;

    public final void setHarOtherFile(final String harOtherFile) {
        this.harOtherFile = harOtherFile;
    }


    /**
     * @hibernate.property
     *  column="har_other_file"
     */
    public final String getHarOtherFile() {
        return this.harOtherFile;
    }

}
