/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.springDataJPA;

import bfkltd.formulations.entity.CategoryStructural;
import bfkltd.formulations.repository.CategoryStructuralRepository;
import bfkltd.formulations.repservice.CategoryStructuralServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */

 
@Repository("springJpaCategoryStructuralService")
@Transactional(readOnly = true)
public class CategoryStructuralServiceImpl implements CategoryStructuralServices {

    @Autowired
    private CategoryStructuralRepository categoryStructuralRepository;
    
    @Override
    public List<CategoryStructural> findAll() {
        return categoryStructuralRepository.findAll();
    }

    @Override
    public void update(CategoryStructural categoryStructural) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(CategoryStructural categoryStructural) {
        categoryStructuralRepository.save(categoryStructural);
    }

    @Override
    public void removeById(Integer id) {
        categoryStructuralRepository.removeById(id);
    }

    @Override
    public CategoryStructural findOneById(Integer id) {
       return categoryStructuralRepository.findOneById(id);
    }

    @Override
    public List<CategoryStructural> findByParent(Integer parent) {
        return categoryStructuralRepository.findByParent(parent);
    }
    
    @Override
    public void addByInciAndCategory(Integer categoryId, Integer inciId) {
        categoryStructuralRepository.addByInciAndCategory(categoryId, inciId);
    }
    
    @Override
    public void removeByInciAndCategory(Integer categoryId, Integer inciId) {
        categoryStructuralRepository.removeByInciAndCategory(categoryId, inciId);
    }
}
