/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.Inci;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author igor
 */
public interface InciRepository extends CrudRepository<Inci, Long> {
   
    public List<Inci> findAll();
    public void removeById(Integer id);
    public Inci findOneById(Integer id);
    
}
