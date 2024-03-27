package com.citymanager.controller;

import com.citymanager.model.City;
import com.citymanager.model.Country;
import com.citymanager.service.city.CityService;
import com.citymanager.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String create(@ModelAttribute("city") City city) {
        cityService.save(city);
        return "redirect:/cities";
    }

}
