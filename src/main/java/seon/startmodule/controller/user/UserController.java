package seon.startmodule.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.UserAuthorize;

@Controller
@UserAuthorize
@RequestMapping("/user")
public class UserController {

    @GetMapping("/setting")
    public String userSettingPage() {
        return "user/user";
    }
}
