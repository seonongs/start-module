package seon.startmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.AdminAuthorize;

@Controller
@AdminAuthorize
@RequestMapping("/view/admin")
public class ViewAdminController {

    @GetMapping("/setting")
    public String adminSettingPage() {
        return "admin/admin";
    }

}
