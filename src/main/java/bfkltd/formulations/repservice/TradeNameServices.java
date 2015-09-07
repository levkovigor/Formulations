/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.TradeName;
import java.util.List;

/**
 *
 * @author igor
 */
public interface TradeNameServices {
    
    public List<TradeName> findAll();
    public void update(TradeName tradeName);
    public void save(TradeName tradeName);
    public void removeById(Integer id);
    public TradeName findOneById(Integer id);
    
}
