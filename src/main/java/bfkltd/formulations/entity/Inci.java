/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "inci")
@NamedQueries({
    @NamedQuery(name = "Inci.findAll", query = "SELECT i FROM Inci i"),
    @NamedQuery(name = "Inci.findById", query = "SELECT i FROM Inci i WHERE i.id = :id"),
    @NamedQuery(name = "Inci.findByNameEn", query = "SELECT i FROM Inci i WHERE i.nameEn = :nameEn"),
    @NamedQuery(name = "Inci.findByNameRu", query = "SELECT i FROM Inci i WHERE i.nameRu = :nameRu"),
    @NamedQuery(name = "Inci.findByNameUa", query = "SELECT i FROM Inci i WHERE i.nameUa = :nameUa"),
    @NamedQuery(name = "Inci.findByCas", query = "SELECT i FROM Inci i WHERE i.cas = :cas"),
    @NamedQuery(name = "Inci.findByEinecs", query = "SELECT i FROM Inci i WHERE i.einecs = :einecs"),
    @NamedQuery(name = "Inci.findBySmile", query = "SELECT i FROM Inci i WHERE i.smile = :smile")})
public class Inci implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "name_en")
    private String nameEn;
    @Size(max = 200)
    @Column(name = "name_ru")
    private String nameRu;
    @Size(max = 200)
    @Column(name = "name_ua")
    private String nameUa;
    @Size(max = 100)
    @Column(name = "cas")
    private String cas;
    @Size(max = 100)
    @Column(name = "einecs")
    private String einecs;
    @Size(max = 200)
    @Column(name = "smile")
    private String smile;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "inciCollection")
    private Collection<CategoryApplication> categoryApplicationCollection;
    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "inciCollection")
    private Collection<CategoryStructural> categoryStructuralCollection;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "inci")
    private Collection<InciProperty> inciPropertyCollection;

    public Inci() {
    }

    public Inci(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getEinecs() {
        return einecs;
    }

    public void setEinecs(String einecs) {
        this.einecs = einecs;
    }

    public String getSmile() {
        return smile;
    }

    public void setSmile(String smile) {
        this.smile = smile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<CategoryApplication> getCategoryApplicationCollection() {
        return categoryApplicationCollection;
    }

    public void setCategoryApplicationCollection(Collection<CategoryApplication> categoryApplicationCollection) {
        this.categoryApplicationCollection = categoryApplicationCollection;
    }

    public Collection<CategoryStructural> getCategoryStructuralCollection() {
        return categoryStructuralCollection;
    }

    public void setCategoryStructuralCollection(Collection<CategoryStructural> categoryStructuralCollection) {
        this.categoryStructuralCollection = categoryStructuralCollection;
    }

    public Collection<InciProperty> getInciPropertyCollection() {
        return inciPropertyCollection;
    }

    public void setInciPropertyCollection(Collection<InciProperty> inciPropertyCollection) {
        this.inciPropertyCollection = inciPropertyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inci)) {
            return false;
        }
        Inci other = (Inci) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.Inci[ id=" + id + " ]";
    }
    
}
