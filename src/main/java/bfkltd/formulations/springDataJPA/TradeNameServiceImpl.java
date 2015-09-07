/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.TradeName;
import bfkltd.formulations.repository.TradeNameRepository;
import bfkltd.formulations.repservice.TradeNameServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
@Repository("springJpaTradeNameService")
@Transactional(readOnly = true)
public class TradeNameServiceImpl implements TradeNameServices {

    @Autowired
    private TradeNameRepository tradeNameRepository;
    
    @Override
    public List<TradeName> findAll() {
        return tradeNameRepository.findAll();
    }

    @Override
    public void update(TradeName tradeName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(TradeName tradeName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TradeName findOneById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
