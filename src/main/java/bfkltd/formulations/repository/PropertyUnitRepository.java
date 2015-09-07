/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author igor
 */
public interface PropertyUnitRepository extends CrudRepository<PropertyUnit, Long> {
   
    public List<PropertyUnit> findAll();
    public void removeById(Integer id);
    public PropertyUnit findOneById(Integer id);
    public List<PropertyUnit> findByPropertyId(Property property);
    
}
