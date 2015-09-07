/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.TradeName;
import bfkltd.formulations.repservice.TradeNameServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
@Named("tradeNameService")
public class TradeNameService {

    @Inject
    public TradeNameServices tradeNameServices;

    @Transactional
    public List<TradeName> getAll() {
        return tradeNameServices.findAll();
    }

}