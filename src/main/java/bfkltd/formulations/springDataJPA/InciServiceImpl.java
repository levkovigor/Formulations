/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.repository.InciRepository;
import bfkltd.formulations.repservice.InciServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

 
@Repository("springJpaInciService")
@Transactional(readOnly = true)
public class InciServiceImpl implements InciServices {

    @Autowired
    private InciRepository inciRepository;
    
    @Override
    public List<Inci> findAll() {
        return inciRepository.findAll();
    }

    @Override
    public void update(Inci inci) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Inci inci) {
        inciRepository.save(inci);
    }

    @Override
    public void removeById(Integer id) {
        inciRepository.removeById(id);
    }

    @Override
    public Inci findOneById(Integer id) {
       return inciRepository.findOneById(id);
    }
    
}
