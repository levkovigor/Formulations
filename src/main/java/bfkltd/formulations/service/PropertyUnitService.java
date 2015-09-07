/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import bfkltd.formulations.repservice.PropertyUnitServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

@Named("propertyUnitService")
public class PropertyUnitService {
    
    @Inject
    public PropertyUnitServices propertyUnitServices;

    @Transactional
    public List<PropertyUnit> getAll() {
        return propertyUnitServices.findAll();
    }
    
    @Transactional
    public void addNew(PropertyUnit propertyUnit) {
        propertyUnitServices.save(propertyUnit);
    }
    
    @Transactional
    public PropertyUnit getOne(Integer id) {
        return propertyUnitServices.findOneById(id);
    }
    
    @Transactional
    public void delete(Integer id) {
        propertyUnitServices.removeById(id);
    }
    
    @Transactional
    public List<PropertyUnit> getByProperty(Property property) {
        return propertyUnitServices.findByPropertyId(property);
    }
    
}
