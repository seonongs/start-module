package seon.startmodule.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.AdminAuthorize;
import seon.startmodule.config.UserAuthorize;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/join")
    public String joinPage() {
        return "auth/join";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {

        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "auth/main";
    }

    @GetMapping("/setting/admin")
    @AdminAuthorize
    public String adminSettingPage() {
        return "auth/admin";
    }

    @GetMapping("/setting/user")
    @UserAuthorize
    public String userSettingPage() {
        return "auth/user";
    }
}
