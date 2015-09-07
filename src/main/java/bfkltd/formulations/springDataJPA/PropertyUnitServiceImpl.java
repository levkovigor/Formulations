/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import bfkltd.formulations.repository.PropertyUnitRepository;
import bfkltd.formulations.repservice.PropertyUnitServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

 
@Repository("springJpaPropertyUnitService")
@Transactional(readOnly = true)
public class PropertyUnitServiceImpl implements PropertyUnitServices {

    @Autowired
    private PropertyUnitRepository propertyUnitRepository;
    
    @Override
    public List<PropertyUnit> findAll() {
        return propertyUnitRepository.findAll();
    }

    @Override
    public void update(PropertyUnit propertyUnit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(PropertyUnit propertyUnit) {
        propertyUnitRepository.save(propertyUnit);
    }

    @Override
    public void removeById(Integer id) {
        propertyUnitRepository.removeById(id);
    }

    @Override
    public PropertyUnit findOneById(Integer id) {
       return propertyUnitRepository.findOneById(id);
    }

    @Override
    public List<PropertyUnit> findByPropertyId(Property property) {
        return propertyUnitRepository.findByPropertyId(property);
    }
    
}
