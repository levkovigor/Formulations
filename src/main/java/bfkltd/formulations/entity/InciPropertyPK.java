/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Embeddable
public class InciPropertyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "inci_id")
    private int inciId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "property_id")
    private int propertyId;

    public InciPropertyPK() {
    }

    public InciPropertyPK(int inciId, int propertyId) {
        this.inciId = inciId;
        this.propertyId = propertyId;
    }

    public int getInciId() {
        return inciId;
    }

    public void setInciId(int inciId) {
        this.inciId = inciId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) inciId;
        hash += (int) propertyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InciPropertyPK)) {
            return false;
        }
        InciPropertyPK other = (InciPropertyPK) object;
        if (this.inciId != other.inciId) {
            return false;
        }
        if (this.propertyId != other.propertyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.InciPropertyPK[ inciId=" + inciId + ", propertyId=" + propertyId + " ]";
    }
    
}
