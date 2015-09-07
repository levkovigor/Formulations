/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.InciPropertyPK;
import bfkltd.formulations.entity.Property;
import bfkltd.formulations.repository.InciPropertyRepository;
import bfkltd.formulations.repservice.InciPropertyServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

 
@Repository("springJpaInciPropertyService")
@Transactional(readOnly = true)
public class InciPropertyServiceImpl implements InciPropertyServices {

    @Autowired
    private InciPropertyRepository inciPropertyRepository;
    
    @Override
    public List<InciProperty> findAll() {
        return inciPropertyRepository.findAll();
    }


    @Override
    public void save(InciProperty inciProperty) {
        inciPropertyRepository.save(inciProperty);
    }

    @Override
    public List<InciProperty> findByInci(Inci inci) {
        return inciPropertyRepository.findByInci(inci);
    }

    @Override
    public InciProperty findOneByInciAndProperty(Inci inci, Property property) {
        return  inciPropertyRepository.findOneByInciAndProperty(inci, property);
    }

    @Override
    public void removeByInciIdAndPropertyId(Integer inciId, Integer propertyId) {
        inciPropertyRepository.removeByInciIdAndPropertyId(inciId, propertyId);
    }

    @Override
    public void update(Integer inciId, Integer propertyId, String propertyValue, Integer propertyUnitId) {
        inciPropertyRepository.update(inciId, propertyId, propertyValue, propertyUnitId);
    }

    
    
}
