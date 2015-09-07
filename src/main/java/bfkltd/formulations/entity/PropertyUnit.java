/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "property_unit")
@NamedQueries({
    @NamedQuery(name = "PropertyUnit.findAll", query = "SELECT p FROM PropertyUnit p"),
    @NamedQuery(name = "PropertyUnit.findById", query = "SELECT p FROM PropertyUnit p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyUnit.findByName", query = "SELECT p FROM PropertyUnit p WHERE p.name = :name")})
public class PropertyUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Property propertyId;
    @OneToMany(mappedBy = "propertyUnitId")
    private Collection<InciProperty> inciPropertyCollection;

    public PropertyUnit() {
    }

    public PropertyUnit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
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
        if (!(object instanceof PropertyUnit)) {
            return false;
        }
        PropertyUnit other = (PropertyUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.PropertyUnit[ id=" + id + " ]";
    }
    
}
