/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.Property;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
public interface InciPropertyRepository extends CrudRepository<InciProperty, Long> {

    public List<InciProperty> findAll();

    public List<InciProperty> findByInci(Inci inci);

    public InciProperty findOneByInciAndProperty(Inci inci, Property property);
    
    @Transactional
    @Modifying
    @Query(value="UPDATE inci_property SET property_value = ?3, property_unit_id = ?4 WHERE inci_id = ?1 AND property_id = ?2", nativeQuery=true)
     public void update(Integer inciId, Integer propertyId, String propertyValue, Integer propertyUnitId);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM inci_property WHERE inci_id = ?1 AND property_id = ?2", nativeQuery=true)
    public void removeByInciIdAndPropertyId(Integer inciId, Integer propertyId);

}
