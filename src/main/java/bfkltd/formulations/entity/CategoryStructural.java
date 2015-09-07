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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "category_structural")
@NamedQueries({
    @NamedQuery(name = "CategoryStructural.findAll", query = "SELECT c FROM CategoryStructural c"),
    @NamedQuery(name = "CategoryStructural.findById", query = "SELECT c FROM CategoryStructural c WHERE c.id = :id"),
    @NamedQuery(name = "CategoryStructural.findByNameEn", query = "SELECT c FROM CategoryStructural c WHERE c.nameEn = :nameEn"),
    @NamedQuery(name = "CategoryStructural.findByNameRu", query = "SELECT c FROM CategoryStructural c WHERE c.nameRu = :nameRu"),
    @NamedQuery(name = "CategoryStructural.findByNameUa", query = "SELECT c FROM CategoryStructural c WHERE c.nameUa = :nameUa"),
    @NamedQuery(name = "CategoryStructural.findByParent", query = "SELECT c FROM CategoryStructural c WHERE c.parent = :parent")})
public class CategoryStructural implements Serializable {
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
    @Column(name = "parent")
    private Integer parent;
    @JoinTable(name = "inci_cat_struc", joinColumns = {
        @JoinColumn(name = "category_structural_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "inci_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Inci> inciCollection;

    public CategoryStructural() {
    }

    public CategoryStructural(Integer id) {
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

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Collection<Inci> getInciCollection() {
        return inciCollection;
    }

    public void setInciCollection(Collection<Inci> inciCollection) {
        this.inciCollection = inciCollection;
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
        if (!(object instanceof CategoryStructural)) {
            return false;
        }
        CategoryStructural other = (CategoryStructural) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bfkltd.formulations.entity.CategoryStructural[ id=" + id + " ]";
    }
    
}
