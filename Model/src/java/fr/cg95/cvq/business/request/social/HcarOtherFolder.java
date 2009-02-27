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
 *  table="hcar_other_folder"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HcarOtherFolder implements Serializable {

    private static final long serialVersionUID = 1L;



    public HcarOtherFolder() {
        super();
    }


    public final String modelToXmlString() {

        HcarOtherFolderType object = (HcarOtherFolderType) this.modelToXml();
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
        HcarOtherFolderType hcarOtherFolder = HcarOtherFolderType.Factory.newInstance();
        hcarOtherFolder.setOtherFolderDepartment(this.otherFolderDepartment);
        hcarOtherFolder.setOtherFolderName(this.otherFolderName);
        hcarOtherFolder.setOtherFolderNumber(this.otherFolderNumber);
        return hcarOtherFolder;
    }

    public static HcarOtherFolder xmlToModel(HcarOtherFolderType hcarOtherFolderDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarOtherFolder hcarOtherFolder = new HcarOtherFolder();
        hcarOtherFolder.setOtherFolderDepartment(hcarOtherFolderDoc.getOtherFolderDepartment());
        hcarOtherFolder.setOtherFolderName(hcarOtherFolderDoc.getOtherFolderName());
        hcarOtherFolder.setOtherFolderNumber(hcarOtherFolderDoc.getOtherFolderNumber());
        return hcarOtherFolder;
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

    private String otherFolderDepartment;

    public final void setOtherFolderDepartment(final String otherFolderDepartment) {
        this.otherFolderDepartment = otherFolderDepartment;
    }


    /**
     * @hibernate.property
     *  column="other_folder_department"
     *  length="2"
     */
    public final String getOtherFolderDepartment() {
        return this.otherFolderDepartment;
    }

    private String otherFolderName;

    public final void setOtherFolderName(final String otherFolderName) {
        this.otherFolderName = otherFolderName;
    }


    /**
     * @hibernate.property
     *  column="other_folder_name"
     *  length="60"
     */
    public final String getOtherFolderName() {
        return this.otherFolderName;
    }

    private String otherFolderNumber;

    public final void setOtherFolderNumber(final String otherFolderNumber) {
        this.otherFolderNumber = otherFolderNumber;
    }


    /**
     * @hibernate.property
     *  column="other_folder_number"
     *  length="30"
     */
    public final String getOtherFolderNumber() {
        return this.otherFolderNumber;
    }

}
