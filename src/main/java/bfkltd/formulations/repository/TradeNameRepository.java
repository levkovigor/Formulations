/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.TradeName;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author igor
 */
public interface TradeNameRepository extends CrudRepository<TradeName, Long> {
   
    public List<TradeName> findAll();
    public void removeById(Integer id);
    public TradeName findOneById(Integer id);
    
}
