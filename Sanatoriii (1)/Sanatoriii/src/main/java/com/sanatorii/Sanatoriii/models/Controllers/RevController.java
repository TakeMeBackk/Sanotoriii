package com.sanatorii.Sanatoriii.models.Controllers;

import com.sanatorii.Sanatoriii.models.Rev;
import com.sanatorii.Sanatoriii.models.Text;
import com.sanatorii.Sanatoriii.repo.RevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RevController {

    @Autowired
    private RevRepository RevRepository;

    @GetMapping("/reviews")
    public String ReviewsMain(Model model) {
        Iterable<Rev> revs = RevRepository.findAll();
        model.addAttribute("revs", revs);
        return "reviews-main";
    }
    @GetMapping("/rev/add")
    public String revAdd(Model model){
        return "rev-add";
    }
    @PostMapping("/rev/add")
    public String revPostAdd(@RequestParam String shortt, @RequestParam String full_rev, Model model){
        Rev rev = new Rev(shortt, full_rev);
        RevRepository.save(rev);
        return "redirect:/home";
    }
    @PostMapping("/rev/{id2}/remove")
    public String revPostDelete(@PathVariable(value = "id2") long id, Model model){
        Rev rev = RevRepository.findById(id).orElseThrow();
        RevRepository.delete(rev);
        return "redirect:/reviews";
    }

}
