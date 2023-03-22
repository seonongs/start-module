package seon.startmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "secret");
        return "common/index";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("data", "secret");
        return "common/main";
    }

    @GetMapping("/deny")
    public String deny(Model model) {
        model.addAttribute("data", "secret");
        return "common/deny";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("data", "secret");
        return "common/admin";
    }




}
