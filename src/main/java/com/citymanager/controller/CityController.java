package com.citymanager.controller;

import com.citymanager.model.City;
import com.citymanager.model.Country;
import com.citymanager.service.city.CityService;
import com.citymanager.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @ModelAttribute("country")
    public Iterable<Country> listCountry() {
        return countryService.findAll();
    }

    @GetMapping("")
    public String showAllCity(Model model){
        model.addAttribute("city", cityService.findAll());
        return "/city/index";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("city", new City());
        return "/city/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("city") City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Add new city success");
        return "redirect:/cities";
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.findById(id);
        model.addAttribute("city", city.get());
        return "city/update";
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("city") City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Update city success");
        return "redirect:/cities";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        cityService.remove(id);
        return "redirect:/cities";
    }
    @GetMapping("/detail/{id}")
    public String detailForm(@PathVariable Long id, Model model) {
        Optional<City> city = cityService.findById(id);
        model.addAttribute("city", city.get());
        return "city/detail";
    }
}


