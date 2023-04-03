package seon.startmodule.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seon.startmodule.config.role.UserAuthorize;

import java.util.HashMap;
import java.util.Map;

@Controller
@UserAuthorize
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "user/common/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "user/common/dashboard";
    }
    @ResponseBody
    @GetMapping("/userInfo")
    public Map<String, Object> userInfo(@AuthenticationPrincipal User user, Model model) {

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("loginId", user.getUsername());
        userInfo.put("loginRoles", user.getAuthorities());

        return userInfo;
    }

    @GetMapping("/setting")
    public String settingPage() {
        return "user/common/everybody";
    }

}
