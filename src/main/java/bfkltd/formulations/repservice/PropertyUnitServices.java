/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import java.util.List;

/**
 *
 * @author igor
 */
public interface PropertyUnitServices{
    
    public List<PropertyUnit> findAll();
    public void update(PropertyUnit propertyUnit);
    public void save(PropertyUnit propertyUnit);
    public void removeById(Integer id);
    public PropertyUnit findOneById(Integer id);
    public List<PropertyUnit> findByPropertyId(Property property);
}
    
