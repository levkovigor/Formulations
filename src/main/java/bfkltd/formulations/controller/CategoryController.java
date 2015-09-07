/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.controller;

import bfkltd.formulations.entity.CategoryStructural;
import bfkltd.formulations.service.CategoryStructuralService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author igor
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    //public static String categoryOutput = "";
    @Inject
    @Qualifier("categoryStructuralService")
    private CategoryStructuralService categoryStructuralService;

    @RequestMapping(value = "/categoryManager", method = RequestMethod.GET)
    public ModelAndView categoryManager() {
        ModelAndView modelAndView = new ModelAndView();
        String output = buildCategory(0, "");
        modelAndView.addObject("categoryOutput", output);
        modelAndView.setViewName("category/categoryManager");
        return modelAndView;
    }

    public String buildCategory(Integer id, String output) {
        String categoryOutput = output;
        List<CategoryStructural> categoryList = categoryStructuralService.findByParent(id);
        for (CategoryStructural category : categoryList) {
            categoryOutput += "<li>"
                    + "<form method=\"POST\" action=\"updateCategory\" id=\"updateCategory\" name=\"updateCategory\">"
                    + "<label for=\"name_en\">Name_EN:</label>"
                    + "<input type=\"text\" id=\"name_en\" name=\"name_en\" value=\"" + category.getNameEn() + "\"/>"
                    + "<label for=\"name_ru\">Name_RU:</label>"
                    + "<input type=\"text\" id=\"name_ru\" name=\"name_ru\" value=\"" + category.getNameRu() + "\"/>"
                    + "<label for=\"name_ua\">Name_UA:</label>"
                    + "<input type=\"text\" id=\"name_ua\" name=\"name_ua\" value=\"" + category.getNameUa() + "\"/>"
                    + "<input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + category.getId() + "\"/>"
                    + "<input type=\"hidden\" id=\"parent\" name=\"parent\" value=\"" + id + "\"/>"
                    + "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Update\"/>"
                    + "</form>"    
                    + "<form method=\"POST\" action=\"deleteCategory\" id=\"deleteCategory\" name=\"deleteCategory\">"
                    + "<input type=\"hidden\" id=\"id\" name=\"id\" value=\"" + category.getId() + "\"/>"
                    + "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Delete\"/>"
                    + "</form>"
                    + "<ul>";
            categoryOutput = buildCategory(category.getId(), categoryOutput);
            categoryOutput += "</ul>" + "</li>";
        }
        categoryOutput += "<li><form method=\"POST\" action=\"addCategory\" id=\"addCategory\" name=\"addCategory\">"
                + "<label for=\"name_en\">Name_EN:</label>"
                + "<input type=\"text\" id=\"name_en\" name=\"name_en\"/>"
                + "<label for=\"name_ru\">Name_RU:</label>"
                + "<input type=\"text\" id=\"name_ru\" name=\"name_ru\"/>"
                + "<label for=\"name_ua\">Name_UA:</label>"
                + "<input type=\"text\" id=\"name_ua\" name=\"name_ua\"/>"
                + "<input type=\"hidden\" id=\"parent\" name=\"parent\" value=\"" + id + "\"/>"
                + "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Add New Category\"/>"
                + "</form>"
                + "</li>";
        return categoryOutput;
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView addCategory(HttpServletRequest request) {
        CategoryStructural category = new CategoryStructural();
        category.setNameEn(request.getParameter("name_en"));
        category.setNameRu(request.getParameter("name_ru"));
        category.setNameUa(request.getParameter("name_ua"));
        category.setParent(Integer.parseInt(request.getParameter("parent")));
        categoryStructuralService.addNew(category);
        return categoryManager();
    }

    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
    public ModelAndView deleteCategory(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        categoryStructuralService.delete(id);
        return categoryManager();
    }

    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
    public ModelAndView updateCategory(HttpServletRequest request) {
        CategoryStructural category = new CategoryStructural();
        category.setId(Integer.parseInt(request.getParameter("id")));
        category.setNameEn(request.getParameter("name_en"));
        category.setNameRu(request.getParameter("name_ru"));
        category.setNameUa(request.getParameter("name_ua"));
        category.setParent(Integer.parseInt(request.getParameter("parent")));
        categoryStructuralService.addNew(category);
        return categoryManager();
    }

}
