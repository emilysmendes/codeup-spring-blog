package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Ad;
import edu.codeup.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AdController {

    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/ads")
    public String index(Ad ad) {
        ad.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

}

