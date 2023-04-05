package seon.startmodule.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.AdminAuthorize;
import seon.startmodule.domain.Users;
import seon.startmodule.dto.UsersDTO;
import seon.startmodule.service.UsersService;

import java.util.List;
import java.util.Optional;

@Controller
@AdminAuthorize
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UsersService usersService;

    @GetMapping("/user/list")
    public String userList(Model model) {
        List<UsersDTO> list = usersService.getUsersList();
        model.addAttribute("list", list);
        return "/admin/user/list";
    }

    @GetMapping("/user/{seq}")
    public String detail(@PathVariable("seq") long seq, Model model ) {
        Optional<Users> users = usersService.findOne(seq);
        model.addAttribute("users", users);
        return "admin/user/detail";
    }

    @GetMapping("/setting")
    public String adminSettingPage() {
        return "admin/admin";
    }

}
