/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.InciPropertyPK;
import bfkltd.formulations.entity.Property;
import java.util.List;

/**
 *
 * @author igor
 */
public interface InciPropertyServices{
    
    public List<InciProperty> findAll();
    public void update(Integer inciId, Integer propertyId, String propertyValue, Integer propertyUnitId);
    public void save(InciProperty inciProperty);
    public List<InciProperty> findByInci(Inci inci);
    public InciProperty findOneByInciAndProperty(Inci inci, Property property);
    public void removeByInciIdAndPropertyId(Integer inciId, Integer propertyId);
    //public void removeById(Integer id);
    //public InciProperty findOneById(Integer id);
}
    
