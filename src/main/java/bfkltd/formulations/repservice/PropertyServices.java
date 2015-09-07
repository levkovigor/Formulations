/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.Property;
import java.util.List;

/**
 *
 * @author igor
 */
public interface PropertyServices{
    
    public List<Property> findAll();
    public void update(Property property);
    public void save(Property property);
    public void removeById(Integer id);
    public Property findOneById(Integer id);
}
    
