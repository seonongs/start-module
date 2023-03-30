package seon.startmodule.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seon.startmodule.dto.MemberJoinDTO;
import seon.startmodule.service.RegisterMemberService;
@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    private final RegisterMemberService registerMemberService;

    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error", required = false)String error,
                            @RequestParam(value = "exception", required = false)String exception,
                            Model model) {

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "auth/login";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "auth/join";
    }

    @ResponseBody
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberJoinDTO dto) {
        try {
            registerMemberService.join(dto.getUserid(), dto.getPw());
            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
