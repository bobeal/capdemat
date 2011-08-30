package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.cg95.cvq.business.document.DocumentType;

@SuppressWarnings("serial")
@Entity
@Table(name="global_home_folder_configuration")
/**
 * Global settings related to home folders.
 */
public class GlobalHomeFolderConfiguration implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    /**
     * Whether or not a home folder can be created without starting a request.
     */
    @Column(nullable=false)
    private Boolean independentCreation = false;

    /**
     * Document types wished at home folder creation time.
     */
    @OneToMany
    @JoinTable(
        name="home_folder_wished_document_types",
        joinColumns={ @JoinColumn(name="global_home_folder_configuration_id") },
        inverseJoinColumns={ @JoinColumn(name="document_type_id") }
    )
    private Set<DocumentType> wishedDocumentTypes = new HashSet<DocumentType>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIndependentCreation() {
        return independentCreation;
    }

    public void setIndependentCreation(Boolean independent) {
        this.independentCreation = independent;
    }

    public Set<DocumentType> getWishedDocumentTypes() {
        return wishedDocumentTypes;
    }

    public void setWishedDocumentTypes(Set<DocumentType> documentTypes) {
        this.wishedDocumentTypes = documentTypes;
    }
}
