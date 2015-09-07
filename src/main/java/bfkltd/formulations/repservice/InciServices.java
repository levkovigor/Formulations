/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.Inci;
import java.util.List;

/**
 *
 * @author igor
 */
public interface InciServices {
    
    public List<Inci> findAll();
    public void update(Inci inci);
    public void save(Inci inci);
    public void removeById(Integer id);
    public Inci findOneById(Integer id);
}
    
