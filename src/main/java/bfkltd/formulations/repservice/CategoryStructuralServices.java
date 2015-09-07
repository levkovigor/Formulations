/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repservice;

import bfkltd.formulations.entity.CategoryStructural;
import java.util.List;

/**
 *
 * @author igor
 */
public interface CategoryStructuralServices {
    
    public List<CategoryStructural> findAll();
    public void update(CategoryStructural categoryStructural);
    public void save(CategoryStructural categoryStructural);
    public void removeById(Integer id);
    public CategoryStructural findOneById(Integer id);
    public List<CategoryStructural> findByParent(Integer parent);
    public void addByInciAndCategory(Integer categoryId, Integer inciId);
    public void removeByInciAndCategory(Integer categoryId, Integer inciId);
}
    
