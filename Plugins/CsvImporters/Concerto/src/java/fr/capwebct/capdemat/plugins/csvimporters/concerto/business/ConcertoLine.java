package fr.capwebct.capdemat.plugins.csvimporters.concerto.business;

import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;

public class ConcertoLine {

    private Long idConcerto;
    private Child child;
    private SchoolCanteenRegistrationRequest scrr;
    private SchoolRegistrationRequest srr;
    private Boolean registeredToSchoolCanteen;
    private Adult homeFolderResponsible;
    private Adult otherHomeFolderAdult;
    private String familyQuotient;
    private Boolean registeredToPerischoolActivity;
    private String schoolName;
    
    public ConcertoLine() {
    }

    public final Long getIdConcerto() {
        return idConcerto;
    }

    public final void setIdConcerto(Long idConcerto) {
        this.idConcerto = idConcerto;
    }

    public final Child getChild() {
        return child;
    }

    public final void setChild(Child child) {
        this.child = child;
    }

    public final SchoolCanteenRegistrationRequest getScrr() {
        return scrr;
    }

    public final void setScrr(SchoolCanteenRegistrationRequest scrr) {
        this.scrr = scrr;
    }

    public final SchoolRegistrationRequest getSrr() {
        return srr;
    }

    public final void setSrr(SchoolRegistrationRequest srr) {
        this.srr = srr;
    }

    public final Boolean isRegisteredToSchoolCanteen() {
        return registeredToSchoolCanteen;
    }

    public final void setRegisteredToSchoolCanteen(Boolean registeredToSchoolCanteen) {
        this.registeredToSchoolCanteen = registeredToSchoolCanteen;
    }

    public final Adult getHomeFolderResponsible() {
        return homeFolderResponsible;
    }

    public final void setHomeFolderResponsible(Adult homeFolderResponsible) {
        this.homeFolderResponsible = homeFolderResponsible;
    }

    public final Adult getOtherHomeFolderAdult() {
        return otherHomeFolderAdult;
    }

    public final void setOtherHomeFolderAdult(Adult otherHomeFolderAdult) {
        this.otherHomeFolderAdult = otherHomeFolderAdult;
    }

    public final String getFamilyQuotient() {
        return familyQuotient;
    }

    public final void setFamilyQuotient(String familyQuotient) {
        this.familyQuotient = familyQuotient;
    }

    public final Boolean isRegisteredToPerischoolActivity() {
        return registeredToPerischoolActivity;
    }

    public void setRegisteredToPerischoolActivity(Boolean registeredToPerischoolActivity) {
        this.registeredToPerischoolActivity = registeredToPerischoolActivity;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
