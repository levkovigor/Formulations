/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.repservice.InciServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
@Named("inciService")
public class InciService {

    @Inject
    public InciServices inciServices;

    @Transactional
    public List<Inci> getAll() {
        return inciServices.findAll();
    }
    
    @Transactional
    public void addNew(Inci inci) {
        inciServices.save(inci);
    }
    
    @Transactional
    public Inci getOne(Integer id) {
        return inciServices.findOneById(id);
    }
    
    @Transactional
    public void delete(Integer id) {
        inciServices.removeById(id);
    }


}
