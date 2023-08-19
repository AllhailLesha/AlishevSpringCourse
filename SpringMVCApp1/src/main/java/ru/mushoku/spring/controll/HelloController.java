package ru.mushoku.spring.controll;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main-pages")
public class HelloController {

    @GetMapping("/home")
    public String homePage() {
        return "main-pages/home";
    }

    @GetMapping("/profile")
    public String profilePage(@RequestParam(value = "firstname", required = false) String firstname,
                              @RequestParam(value = "lastname", required = false) String lastname,
                              Model model) {

        model.addAttribute("message", firstname + " " + lastname);
        return "main-pages/profile";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model) {

        double result = 0;

        switch (action) {
            case "multiplication" ->  result = a * b;
            case "addition" -> result = a + b;
            case "subtraction" -> result = a - b;
            case "division" -> result = a / (double)b;
        }

        model.addAttribute("result", result);

        return "main-pages/calculator";
    }
}
