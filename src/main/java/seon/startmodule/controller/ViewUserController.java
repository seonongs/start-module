package seon.startmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.UserAuthorize;

@Controller
@UserAuthorize
@RequestMapping("/view/user")
public class ViewUserController {

    @GetMapping("/setting")
    public String userSettingPage() {
        return "user/user";
    }
}
