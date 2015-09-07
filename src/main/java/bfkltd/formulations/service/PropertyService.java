/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.repservice.PropertyServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

@Named("propertyService")
public class PropertyService {
    
    @Inject
    public PropertyServices propertyServices;

    @Transactional
    public List<Property> getAll() {
        return propertyServices.findAll();
    }
    
    @Transactional
    public void addNew(Property property) {
        propertyServices.save(property);
    }
    
    @Transactional
    public Property getOne(Integer id) {
        return propertyServices.findOneById(id);
    }
    
    @Transactional
    public void delete(Integer id) {
        propertyServices.removeById(id);
    }

    
}
