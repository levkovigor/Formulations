/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.Property;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author igor
 */
public interface PropertyRepository extends CrudRepository<Property, Long> {
   
    public List<Property> findAll();
    public void removeById(Integer id);
    public Property findOneById(Integer id);
    
}
