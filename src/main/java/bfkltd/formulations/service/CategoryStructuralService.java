/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.service;

import bfkltd.formulations.entity.CategoryStructural;
import bfkltd.formulations.repservice.CategoryStructuralServices;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
@Named("categoryStructuralService")
public class CategoryStructuralService {

    @Inject
    public CategoryStructuralServices categoryStructuralServices;

    @Transactional
    public List<CategoryStructural> getAll() {
        return categoryStructuralServices.findAll();
    }

    @Transactional
    public List<CategoryStructural> findByParent(Integer parent) {
        return categoryStructuralServices.findByParent(parent);
    }

    @Transactional
    public void addNew(CategoryStructural categoryStructural) {
        categoryStructuralServices.save(categoryStructural);
    }

    @Transactional
    public CategoryStructural getOne(Integer id) {
        return categoryStructuralServices.findOneById(id);
    }

    @Transactional
    public void delete(Integer id) {
        categoryStructuralServices.removeById(id);
    }

    @Transactional
    public void addByInciAndCategory(Integer categoryId, Integer inciId) {
        categoryStructuralServices.addByInciAndCategory(categoryId, inciId);
    }
    
    @Transactional
    public void removeByInciAndCategory(Integer categoryId, Integer inciId) {
        categoryStructuralServices.removeByInciAndCategory(categoryId, inciId);
    }

}
