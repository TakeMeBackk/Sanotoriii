package com.sanatorii.Sanatoriii.models.Controllers;

import com.sanatorii.Sanatoriii.models.Text;
import com.sanatorii.Sanatoriii.repo.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private TextRepository textRepository;

    @GetMapping("/product")
    public String ProductMain(Model model) {
        Iterable<Text> texts = textRepository.findAll();
        model.addAttribute("texts", texts);
        return "product-main";
    }
    @GetMapping("/text/add")
    public String textadd(Model model) {
        return "text-add";
    }

    @PostMapping("/text/add")
    public String textPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Text Text = new Text(title, anons, full_text);
        textRepository.save(Text);
        return "redirect:/product";
    }

    @GetMapping("/product/{id}")
    public String TextDetails(@PathVariable(value = "id") long id, Model model) {
        if(!textRepository.existsById(id)){
            return "redirect:/product";
        }
        Optional<Text> text=textRepository.findById(id);
        ArrayList<Text> res = new ArrayList<>();
        text.ifPresent(res::add);
        model.addAttribute("text", res);
        return "text-details";
    }
    @GetMapping("/product/{id}/edit")
    public String TextEdit(@PathVariable(value = "id") long id, Model model) {
        if(!textRepository.existsById(id)){
            return "redirect:/product";
        }
        Optional<Text> text=textRepository.findById(id);
        ArrayList<Text> res = new ArrayList<>();
        text.ifPresent(res::add);
        model.addAttribute("text", res);
        return "text-edit";
    }
    @PostMapping("/product/{id}/edit")
    public String textPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Text Text = textRepository.findById(id).orElseThrow();
        Text.setTitle(title);
        Text.setAnons(anons);
        Text.setFull_text(full_text);
        textRepository.save(Text);

        return "redirect:/product";
    }
    @PostMapping("/product/{id}/remove")
    public String textPostDelete(@PathVariable(value = "id") long id, Model model){
        Text Text = textRepository.findById(id).orElseThrow();
       textRepository.delete(Text);
        return "redirect:/product";
    }
}
