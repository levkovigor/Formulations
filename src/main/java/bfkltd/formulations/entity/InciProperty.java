/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "inci_property")
@NamedQueries({
    @NamedQuery(name = "InciProperty.findAll", query = "SELECT i FROM InciProperty i"),
    @NamedQuery(name = "InciProperty.findByInciId", query = "SELECT i FROM InciProperty i WHERE i.inciPropertyPK.inciId = :inciId"),
    @NamedQuery(name = "InciProperty.findByPropertyId", query = "SELECT i FROM InciProperty i WHERE i.inciPropertyPK.propertyId = :propertyId"),
    @NamedQuery(name = "InciProperty.findByPropertyValue", query = "SELECT i FROM InciProperty i WHERE i.propertyValue = :propertyValue")})
public class InciProperty implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InciPropertyPK inciPropertyPK;
    @Size(max = 50)
    @Column(name = "property_value")
    private String propertyValue;
    @JoinColumn(name = "inci_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inci inci;
    @JoinColumn(name = "property_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Property property;
    @JoinColumn(name = "property_unit_id", referencedColumnName = "id")
    @ManyToOne
    private PropertyUnit propertyUnitId;

    public InciProperty() {
    }

    public InciProperty(InciPropertyPK inciPropertyPK) {
        this.inciPropertyPK = inciPropertyPK;
    }

    public InciProperty(int inciId, int propertyId) {
        this.inciPropertyPK = new InciPropertyPK(inciId, propertyId);
    }

    public InciPropertyPK getInciPropertyPK() {
        return inciPropertyPK;
    }

    public void setInciPropertyPK(InciPropertyPK inciPropertyPK) {
        this.inciPropertyPK = inciPropertyPK;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Inci getInci() {
        return inci;
    }

    public void setInci(Inci inci) {
        this.inci = inci;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public PropertyUnit getPropertyUnitId() {
        return propertyUnitId;
    }

    public void setPropertyUnitId(PropertyUnit propertyUnitId) {
        this.propertyUnitId = propertyUnitId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inciPropertyPK != null ? inciPropertyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InciProperty)) {
            return false;
        }
        InciProperty other = (InciProperty) object;
        if ((this.inciPropertyPK == null && other.inciPropertyPK != null) || (this.inciPropertyPK != null && !this.inciPropertyPK.equals(other.inciPropertyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.InciProperty[ inciPropertyPK=" + inciPropertyPK + " ]";
    }
    
}
