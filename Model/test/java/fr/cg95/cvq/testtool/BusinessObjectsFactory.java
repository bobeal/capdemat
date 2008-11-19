package fr.cg95.cvq.testtool;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.LocalAuthority;
import fr.cg95.cvq.business.authority.RecreationCenter;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.document.DepositOrigin;
import fr.cg95.cvq.business.document.DepositType;
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.school.OtherIndividual;
import fr.cg95.cvq.business.request.school.OtherIndividualType;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.FamilyStatusType;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;

/**
 * A factory to create necessary referential objects.
 *
 * @author bor@zenexity.fr
 */
public class BusinessObjectsFactory {

    public static LocalAuthority gimmeLocalAuthority(String name) {
        LocalAuthority localAuthority = new LocalAuthority();
        localAuthority.setName(name);

        return localAuthority;
    }

    public static Category gimmeCategory(String name) {
        Category category = new Category();
        category.setName(name);

        return category;
    }

    public static School gimmeSchool(String name) {
        School school = new School();
        school.setName(name);
        school.setAdress("Rue du centre");

        return school;
    }

    public static RecreationCenter gimmeRecreationCenter(String name) {
        RecreationCenter recreationCenter = new RecreationCenter();
        recreationCenter.setName(name);

        return recreationCenter;
    }

    public static Adult gimmeAdult(TitleType title, String lastName,
            String firstName, Address adress, FamilyStatusType fs) {
        
        Adult adult = new Adult();
        adult.setTitle(title);
        adult.setLastName(lastName);
        adult.setFirstName(firstName);
        adult.setFirstName2("Firstname2");
        adult.setFirstName3("Firstname3");
        adult.setNameOfUse("NAMEOFUSE");
        adult.setFamilyStatus(fs);
        adult.setHomePhone("0101010101");
        adult.setMobilePhone("0606060606");
        adult.setOfficePhone("0202020202");
        adult.setEmail("rdj@zenexity.fr");
        adult.setCfbn("5050505E");
        adult.setProfession("Profession");
        adult.setSex(SexType.MALE);
        if (adress != null)
            adult.setAdress(adress);

        return adult;
    }

    public static OtherIndividual gimmeApac(String address, String lastName,
            String firstName, String officePhone, String homePhone, OtherIndividualType oit) {
        
        OtherIndividual otherIndividual = new OtherIndividual();
        otherIndividual.setAddress(address);
        otherIndividual.setLastName(lastName);
        otherIndividual.setFirstName(firstName);
        otherIndividual.setOfficePhone(officePhone);
        otherIndividual.setHomePhone(homePhone);
        otherIndividual.setType(oit);

        return otherIndividual;
    }

    public static Child gimmeChild(String lastName, String firstName) {
        
        Child child = new Child();
        child.setLastName(lastName);
        child.setFirstName(firstName);
        child.setSex(SexType.UNKNOWN);
        child.setNote("Et un enfant, un !");
        child.setBirthCity("Paris");
        child.setBirthPostalCode("75012");
        Calendar calendar = new GregorianCalendar();
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        child.setBirthDate(calendar.getTime());
        
        return child;
    }

    public static Address gimmeAdress(String streetNumber, String streetName,
            String city, String postalCode) {
        Address address = new Address();
        address.setAdditionalDeliveryInformation("Chez Zenxity");
        address.setAdditionalGeographicalInformation("Bat. ParisCyber Village");
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setPostalCode(postalCode);

        return address;
    }

    public static Document gimmeDocument(String note, DepositOrigin depOrig,
            DepositType depType, DocumentType docType) {
        
        Document doc = new Document();
        doc.setEcitizenNote(note);
        doc.setDepositOrigin(depOrig);
        doc.setDepositType(depType);
        doc.setDocumentType(docType);

        return doc;
    }

    public static LocalReferentialData gimmeLocalReferentialData() {

        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setPriority(Integer.valueOf("1"));
        lrd.setName("God");
        lrd.setAdditionalInformationLabel("AddLabel");
        lrd.setAdditionalInformationValue("AddValue");

        LocalReferentialData lrdChild1 = new LocalReferentialData();
        lrdChild1.setPriority(Integer.valueOf("1"));
        lrdChild1.setName("Child1");
        lrdChild1.setAdditionalInformationLabel("AddLabel");
        lrdChild1.setAdditionalInformationValue("AddValue");
        if (lrd.getChildren() == null) {
            Set<LocalReferentialData> data = new HashSet<LocalReferentialData>();
            data.add(lrdChild1);
            lrd.setChildren(data);
        } else {
            lrd.getChildren().add(lrdChild1);
        }
        lrdChild1.setParent(lrd);

        LocalReferentialData lrdChild2 = new LocalReferentialData();
        lrdChild2.setPriority(Integer.valueOf("2"));
        lrdChild2.setName("Child2");
        lrdChild2.setAdditionalInformationLabel("AddLabel");
        lrdChild2.setAdditionalInformationValue("AddValue");
        if (lrd.getChildren() == null) {
            Set<LocalReferentialData> data = new HashSet<LocalReferentialData>();
            data.add(lrdChild2);
            lrd.setChildren(data);
        } else {
            lrd.getChildren().add(lrdChild2);
        }
        lrdChild2.setParent(lrd);

        return lrd;
    }
    
    public static RequestSeason gimmeRequestSeason(final String label, 
            final int registrationStartOffset, final int registrationEndOffset, 
            final int effectStartOffset, final int effectEndOffset) {

        RequestSeason requestSeason = new RequestSeason();
        requestSeason.setLabel(label);
        Date now = new Date();
        Calendar calendar = new GregorianCalendar();
        
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, registrationStartOffset);
        requestSeason.setRegistrationStart(calendar.getTime());

        calendar.setTime(now);
        calendar.add(Calendar.MONTH, registrationEndOffset);
        requestSeason.setRegistrationEnd(calendar.getTime());
        requestSeason.setValidationAuthorizationStart(calendar.getTime());

        calendar.setTime(now);
        calendar.add(Calendar.MONTH, effectStartOffset);
        requestSeason.setEffectStart(calendar.getTime());

        calendar.setTime(now);
        calendar.add(Calendar.MONTH, effectEndOffset);
        requestSeason.setEffectEnd(calendar.getTime());
        
        return requestSeason;
    }
}
