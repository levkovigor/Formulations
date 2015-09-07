/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.InciPropertyPK;
import bfkltd.formulations.entity.Property;
import bfkltd.formulations.repservice.InciPropertyServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

@Named("inciPropertyService")
public class InciPropertyService {
    
    @Inject
    public InciPropertyServices inciPropertyServices;

    @Transactional
    public List<InciProperty> getAll() {
        return inciPropertyServices.findAll();
    }
    
    @Transactional
    public void addNew(InciProperty inciProperty) {
        inciPropertyServices.save(inciProperty);
    }
    
    @Transactional
    public List<InciProperty> findByInci(Inci inci) {
        return inciPropertyServices.findByInci(inci);
    }
    
  
    @Transactional
    public InciProperty findOneByInciAndProperty(Inci inci, Property property) {
       return inciPropertyServices.findOneByInciAndProperty(inci, property);
    }
    
    @Transactional
    public void removeByInciIdAndPropertyId(Integer inciId, Integer propertyId) {
        inciPropertyServices.removeByInciIdAndPropertyId(inciId, propertyId);
    }
    
    @Transactional
    public void update(Integer inciId, Integer propertyId, String propertyValue, Integer propertyUnitId){
        inciPropertyServices.update(inciId, propertyId, propertyValue, propertyUnitId);
    }
    
    
}
