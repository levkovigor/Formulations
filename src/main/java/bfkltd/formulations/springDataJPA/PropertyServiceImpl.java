/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.repository.PropertyRepository;
import bfkltd.formulations.repservice.PropertyServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

 
@Repository("springJpaPropertyService")
@Transactional(readOnly = true)
public class PropertyServiceImpl implements PropertyServices {

    @Autowired
    private PropertyRepository propertyRepository;
    
    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void update(Property property) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void removeById(Integer id) {
        propertyRepository.removeById(id);
    }

    @Override
    public Property findOneById(Integer id) {
       return propertyRepository.findOneById(id);
    }
    
}
