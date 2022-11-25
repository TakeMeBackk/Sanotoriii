package com.sanatorii.Sanatoriii.models.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Помиканов");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Про нас");
        return "about";

    }

    @Controller
    public class GymController {

        @GetMapping("/gym")
        public String GymMain(Model model) {
            model.addAttribute("title", "Дозвілля");
            return "gym";
        }
    }

    @Controller
    public class TerapiyaController {

        @GetMapping("/terapiya")
        public String TerapiyaMain(Model model) {
            model.addAttribute("title", "Терапія");
            return "terapiya";
        }
    }
    @Controller
    public class ReviewsController {

        @GetMapping("/reviews")
        public String ReviewsMain(Model model) {
            model.addAttribute("title", "Відгуки");
            return "reviews";
        }
    }

    @Controller
    public class СontactsController {

        @GetMapping("/contacts")
        public String ContactsMain(Model model) {
            model.addAttribute("title", "Контакти");
            return "contacts";
        }
    }
    @Controller
    public class BookController {

        @GetMapping("/book")
        public String BookMain(Model model) {
            model.addAttribute("title", "Забронювати");
            return "book";
        }
    }
}