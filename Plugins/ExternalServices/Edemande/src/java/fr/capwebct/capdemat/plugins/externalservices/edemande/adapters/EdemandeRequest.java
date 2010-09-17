package fr.capwebct.capdemat.plugins.externalservices.edemande.adapters;

import java.util.Calendar;
import java.util.Map;

import fr.capwebct.capdemat.plugins.externalservices.edemande.service.EdemandeService;
import fr.cg95.cvq.xml.common.AddressType;
import fr.cg95.cvq.xml.common.FrenchRIBType;
import fr.cg95.cvq.xml.common.TitleType;

public interface EdemandeRequest {

    public static enum Config {
        SGR("Mobil_Etudes_Extranet", "Mobil'Etudes 77 Extranet", "/dep/?formID=dep", "Mobil'études", "Bourses Mobil'Etudes 77 - Extranet"),
        BGR("Bourses_BAFA_Extranet", "Bourses BAFA Extranet", "/dep/?formID=dep", "Bourses BAFA Extranet", "Bourses BAFA Extranet");
        public final String name;
        public final String label;
        public final String path;
        public final String description;
        public final String longDescription;
        private Config(String name, String label, String path, String description, String longDescription) {
            this.name = name;
            this.label = label;
            this.path = path;
            this.description = description;
            this.longDescription = longDescription;
        }
    }

    Calendar getAccountHolderBirthDate();

    Config getConfig();

    String getAccountHolderEdemandeId();

    String getAccountHolderFirstName();

    String getAccountHolderLastName();

    TitleType.Enum getAccountHolderTitle();

    Calendar getCreationDate();

    String getEdemandeId();

    FrenchRIBType getFrenchRIB();

    Long getHomeFolderId();

    Long getId();

    AddressType getSubjectAddress();

    String getSubjectBirthCity();

    Calendar getSubjectBirthDate();

    Long getSubjectId();

    String getSubjectEdemandeId();

    String getSubjectEmail();

    String getSubjectFirstName();

    String getSubjectLastName();

    String getSubjectPhone();

    TitleType.Enum getSubjectTitle();

    boolean isSubjectAccountHolder();

    void setAccountHolderEdemandeId(String id);

    void setSubjectEdemandeId(String id);

    void setEdemandeId(String id);

    Map<String, Object> getSpecificFields(EdemandeService service);
}
