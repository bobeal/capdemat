package fr.cg95.cvq.business.users.external;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="individual_mapping")
public class IndividualMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="individual_id")
    private Long individualId;

    @Column(name="external_capdemat_id")
    private String externalCapDematId;

    @Column(name="external_id")
    private String externalId;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="home_folder_mapping_id")
    private HomeFolderMapping homeFolderMapping;

    public IndividualMapping() {
    }

    public IndividualMapping(Long individualId, String externalId, HomeFolderMapping homeFolderMapping) {
        this.externalCapDematId = UUID.randomUUID().toString();
        this.individualId = individualId;
        this.externalId = externalId;
        this.homeFolderMapping = homeFolderMapping;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndividualId() {
        return individualId;
    }

    public void setIndividualId(Long individualId) {
        this.individualId = individualId != null ? individualId : 0L;
    }

    public String getExternalCapDematId() {
        return externalCapDematId;
    }

    public void setExternalCapDematId(String externalCapDematId) {
        this.externalCapDematId =
            externalCapDematId != null ? externalCapDematId : "";
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId != null ? externalId : "";
    }

    public HomeFolderMapping getHomeFolderMapping() {
        return homeFolderMapping;
    }

    public void setHomeFolderMapping(HomeFolderMapping homeFolderMapping) {
        this.homeFolderMapping = homeFolderMapping;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IndividualMapping))
            return false;
        if (this == object)
            return true;
        IndividualMapping mapping = (IndividualMapping) object;
        if (this.id == null && mapping.id == null)
            return (this.externalId.equals(mapping.externalId));
        else
            return this.id == mapping.id;
    }

    @Override
    public int hashCode() {
        return id == null ? System.identityHashCode(this) : id.hashCode();
    }
}
