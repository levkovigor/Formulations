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
@Table(name = "property")
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p"),
    @NamedQuery(name = "Property.findById", query = "SELECT p FROM Property p WHERE p.id = :id"),
    @NamedQuery(name = "Property.findByNameEn", query = "SELECT p FROM Property p WHERE p.nameEn = :nameEn"),
    @NamedQuery(name = "Property.findByNameRu", query = "SELECT p FROM Property p WHERE p.nameRu = :nameRu"),
    @NamedQuery(name = "Property.findByNameUa", query = "SELECT p FROM Property p WHERE p.nameUa = :nameUa")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name_en")
    private String nameEn;
    @Size(max = 100)
    @Column(name = "name_ru")
    private String nameRu;
    @Size(max = 100)
    @Column(name = "name_ua")
    private String nameUa;
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "propertyId")
    private Collection<PropertyUnit> propertyUnitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property")
    private Collection<InciProperty> inciPropertyCollection;

    public Property() {
    }

    public Property(Integer id) {
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

    public Collection<PropertyUnit> getPropertyUnitCollection() {
        return propertyUnitCollection;
    }

    public void setPropertyUnitCollection(Collection<PropertyUnit> propertyUnitCollection) {
        this.propertyUnitCollection = propertyUnitCollection;
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
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.Property[ id=" + id + " ]";
    }
    
}
