package seon.startmodule.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seon.startmodule.config.role.AdminAuthorize;
import seon.startmodule.domain.UserS;
import seon.startmodule.dto.BoardDTO;
import seon.startmodule.dto.UserDTO;
import seon.startmodule.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@AdminAuthorize
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController<Users> {

    private final UserService service;

    @GetMapping("/user/list")
    public String list(Model model) {
        List<UserS> list = service.getList();
        model.addAttribute("list", list);
        return "/admin/user/list";
    }
    @GetMapping("/user/{seq}")
    public String detail(@PathVariable("seq") Long seq, Model model ) {
        UserS data = service.getOne(seq);
        model.addAttribute("data", data);
        return "admin/user/detail";
    }
    @GetMapping("/user/save")
    public String savePage() {
        return "admin/user/save";
    }

    @PostMapping("/user/save")
    public String save(UserDTO dto) {
        service.save(dto);
        return "redirect:/admin/user/list";
    }
    @GetMapping("/user/modify/{seq}")
    public String modify(@PathVariable("seq") Long seq, Model model) {
        UserS data = service.getOne(seq);
        model.addAttribute("data", data);
        return "admin/user/modify";
    }
    @PostMapping("/user/modify")
    public String modify(UserS userS) {
        service.modify(userS);
        return "redirect:/admin/user/list";
    }
    @GetMapping("/user/delete/{seq}")
    public String deleteBoard(@PathVariable("seq") Long seq) {
        service.delete(seq);
        return "redirect:/admin/user/list";
    }


    @GetMapping("/setting")
    public String adminSettingPage() {
        return "admin/admin";
    }

}
