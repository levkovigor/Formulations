/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfkltd.formulations.controller;

import bfkltd.formulations.entity.CategoryStructural;
import bfkltd.formulations.entity.Inci;
import bfkltd.formulations.entity.InciProperty;
import bfkltd.formulations.entity.InciPropertyPK;
import bfkltd.formulations.entity.Property;
import bfkltd.formulations.entity.PropertyUnit;
import bfkltd.formulations.service.CategoryStructuralService;
import bfkltd.formulations.service.InciPropertyService;
import bfkltd.formulations.service.InciService;
import bfkltd.formulations.service.PropertyService;
import bfkltd.formulations.service.PropertyUnitService;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author igor
 */
@Controller
@RequestMapping("inci")
public class InciController {

    @Inject
    @Qualifier("inciService")
    private InciService inciService;

    @Inject
    @Qualifier("inciPropertyService")
    private InciPropertyService inciPropertyService;

    @Inject
    @Qualifier("propertyService")
    private PropertyService propertyService;

    @Inject
    @Qualifier("propertyUnitService")
    private PropertyUnitService propertyUnitService;

    @Inject
    @Qualifier("categoryStructuralService")
    private CategoryStructuralService categoryStructuralService;
    
    @RequestMapping(value = "/inciList", method = RequestMethod.GET)
    public ModelAndView inciList() {
        ModelAndView modelAndView = new ModelAndView();
        List<Inci> inciList = inciService.getAll();
        modelAndView.addObject("inciList", inciList);
        modelAndView.setViewName("inci/inciList");
        return modelAndView;
    }

    @RequestMapping(value = "/addInci", method = RequestMethod.GET)
    public ModelAndView addInciView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("action", "addInciData");
        modelAndView.setViewName("inci/addInci");
        return modelAndView;
    }

    @RequestMapping(value = "/addInciData", method = RequestMethod.POST)
    public ModelAndView addInciData(HttpServletRequest request) {

        Inci inci = new Inci();
        inci.setNameEn(request.getParameter("name_en"));
        inci.setNameRu(request.getParameter("name_ru"));
        inci.setNameUa(request.getParameter("name_ua"));
        inci.setCas(request.getParameter("cas"));
        inci.setEinecs(request.getParameter("einecs"));
        inci.setSmile(request.getParameter("smile"));
        inci.setDescription(request.getParameter("desc"));
        inciService.addNew(inci);

        return inciUpdateView(inciService.getOne(inci.getId()).getId().toString());
    }

    @RequestMapping(value = "/inciView", method = RequestMethod.GET)
    public ModelAndView getInciView(@RequestParam String id) {
        Integer id_int = Integer.parseInt(id);
        Inci inci = inciService.getOne(id_int);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inci/inciView");
        modelAndView.addObject(inci);
        return modelAndView;
    }

    @RequestMapping(value = "/inciDelete", method = RequestMethod.GET)
    public ModelAndView inciDelete(@RequestParam String id) {
        Integer id_int = Integer.parseInt(id);
        inciService.delete(id_int);
        return inciList();
    }

    @RequestMapping(value = "/inciUpdate", method = RequestMethod.GET)
    public ModelAndView inciUpdateView(@RequestParam String id) {
        Integer id_int = Integer.parseInt(id);
        Inci inci = inciService.getOne(id_int);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(inci);
        modelAndView.setViewName("inci/addInci");
        modelAndView.addObject("propertyList", propertyService.getAll());
        String output = buildCategory(0, "", inci.getId());
        modelAndView.addObject("categoryOutput", output);
        modelAndView.addObject("action", "updateInciData");
        return modelAndView;
    }
    
    public String buildCategory(Integer id, String output, Integer inciId) {
        String categoryOutput = output;
        List<CategoryStructural> categoryList = categoryStructuralService.findByParent(id);
        for (CategoryStructural category : categoryList) {
            categoryOutput += "<li>"
                    + category.getNameEn() + "/" + category.getNameRu() + "/" + category.getNameUa() 
                    + "<ul>";
            categoryOutput = buildCategory(category.getId(), categoryOutput, inciId);
            categoryOutput += "</ul>" + "</li>";
        }
        categoryOutput += "<li><form method=\"POST\" action=\"addInciToStructuralCategory\" id=\"addInciToStructuralCategory\" name=\"addInciToStructuralCategory\">"
                + "<input type=\"hidden\" id=\"parent\" name=\"parent\" value=\"" + id + "\"/>"
                + "<input type=\"hidden\" id=\"inci_id\" name=\"inci_id\" value=\"" + inciId + "\"/>"
                + "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Add Inci\"/>"
                + "</form>"
                + "</li>";
        return categoryOutput;
    }

    @RequestMapping(value = "/addInciToStructuralCategory", method = RequestMethod.POST)
    public ModelAndView addInciToStructuralCategory(HttpServletRequest request) {
       categoryStructuralService.addByInciAndCategory(Integer.parseInt(request.getParameter("parent")), Integer.parseInt(request.getParameter("inci_id")));
       return inciUpdateView(request.getParameter("inci_id")); 
    }
    
      @RequestMapping(value = "/deleteStructuralCategory", method = RequestMethod.POST)
    public ModelAndView deleteStructuralCategory(HttpServletRequest request) {
       categoryStructuralService.removeByInciAndCategory(Integer.parseInt(request.getParameter("cat_struc_id")), Integer.parseInt(request.getParameter("inci_id")));
       return inciUpdateView(request.getParameter("inci_id")); 
    }

    @RequestMapping(value = "/updateInciData", method = RequestMethod.POST)
    public ModelAndView updateInciData(HttpServletRequest request) {
        Inci inci = new Inci();
        inci.setId(Integer.parseInt(request.getParameter("id")));
        inci.setNameEn(request.getParameter("name_en"));
        inci.setNameRu(request.getParameter("name_ru"));
        inci.setNameUa(request.getParameter("name_ua"));
        inci.setCas(request.getParameter("cas"));
        inci.setEinecs(request.getParameter("einecs"));
        inci.setSmile(request.getParameter("smile"));
        inci.setDescription(request.getParameter("desc"));
        inciService.addNew(inci);
        return inciList();
    }

    @RequestMapping(value = "/addProperty", method = RequestMethod.POST)
    public ModelAndView addProperty(HttpServletRequest request) {
        Inci inci = inciService.getOne(Integer.parseInt(request.getParameter("id")));
        Property property = propertyService.getOne(Integer.parseInt(request.getParameter("newProperty")));
        System.out.println(inci.getNameEn());
        System.out.println(property.getNameEn());
        InciProperty inciProperty = new InciProperty();
        InciPropertyPK inciPropertyPK = new InciPropertyPK();
        inciPropertyPK.setInciId(inci.getId());
        inciPropertyPK.setPropertyId(property.getId());
        inciProperty.setInciPropertyPK(inciPropertyPK);
        inciProperty.setInci(inci);
        inciProperty.setProperty(property);
        inciProperty.setPropertyUnitId(null);
        inciPropertyService.addNew(inciProperty);
        return inciUpdateView(request.getParameter("id"));
    }
    
    @RequestMapping(value = "/createProperty", method = RequestMethod.POST)
    public ModelAndView createProperty(HttpServletRequest request) {
        Property property = new Property();
        property.setNameEn(request.getParameter("prop_name_en"));
        property.setNameRu(request.getParameter("prop_name_ru"));
        property.setNameUa(request.getParameter("prop_name_ua"));
        propertyService.addNew(property);
        return inciUpdateView(request.getParameter("inci_id"));
    }
    
    @RequestMapping(value = "/updateProperty", method = RequestMethod.POST)
    public ModelAndView updateProperty(HttpServletRequest request) {
        String propertyValue = request.getParameter("prop_value");
        String propertyUnit = request.getParameter("prop_unit");
        Integer propertyUnitId;
        if (propertyUnit == "") {
            propertyUnitId = null;
        } else {
            propertyUnitId =  Integer.parseInt(propertyUnit);
        }
        inciPropertyService.update(Integer.parseInt(request.getParameter("inci_id")), Integer.parseInt(request.getParameter("prop_id")), propertyValue, propertyUnitId);
        return inciUpdateView(request.getParameter("inci_id"));
    }
    
    @RequestMapping(value = "/deleteProperty", method = RequestMethod.POST)
    public ModelAndView deleteProperty(HttpServletRequest request) {
        inciPropertyService.removeByInciIdAndPropertyId(Integer.parseInt(request.getParameter("inci_id")), Integer.parseInt(request.getParameter("prop_id")));
        return inciUpdateView(request.getParameter("inci_id"));
    }
    
    @RequestMapping(value = "/createPropertyUnit", method = RequestMethod.POST)
    public ModelAndView createPropertyUnit(HttpServletRequest request) {
        PropertyUnit propertyUnit = new PropertyUnit();
        propertyUnit.setName(request.getParameter("new_prop_unit"));
        Property property = propertyService.getOne(Integer.parseInt(request.getParameter("prop_id")));
        propertyUnit.setPropertyId(property);
        propertyUnitService.addNew(propertyUnit);
        return inciUpdateView(request.getParameter("inci_id"));
    }

}
