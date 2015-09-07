/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.repository;

import bfkltd.formulations.entity.CategoryStructural;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author igor
 */
public interface CategoryStructuralRepository extends CrudRepository<CategoryStructural, Long> {
   
    public List<CategoryStructural> findAll();
    
    @Transactional
    @Modifying
    @Query(value="SELECT * FROM category_structural WHERE parent = ?1", nativeQuery=true)
    public List<CategoryStructural> findByParent(Integer parent);
    
    public void removeById(Integer id);
    public CategoryStructural findOneById(Integer id);
    
    @Transactional
    @Modifying
    @Query(value="INSERT INTO inci_cat_struc (inci_id, category_structural_id) VALUES (?2, ?1)", nativeQuery=true)
    public void addByInciAndCategory(Integer categoryId, Integer inciId);
    
    @Transactional
    @Modifying
    @Query(value="DELETE FROM inci_cat_struc WHERE inci_id = ?2 AND category_structural_id = ?1", nativeQuery=true)
    public void removeByInciAndCategory(Integer categoryId, Integer inciId);
  
}
