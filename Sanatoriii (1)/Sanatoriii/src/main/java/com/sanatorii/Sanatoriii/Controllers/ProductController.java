package com.sanatorii.Sanatoriii.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String ProductMain(Model model) {
        model.addAttribute("title", "Наші продукти");
        return "product-main";
    }
}
