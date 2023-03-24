package seon.startmodule.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.UserAuthorize;

@Controller
@UserAuthorize
@RequestMapping("/view")
public class ViewCommonController {

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "common/dashboard";
    }

    @GetMapping("/setting")
    public String settingPage() {
        return "common/everybody";
    }

}
