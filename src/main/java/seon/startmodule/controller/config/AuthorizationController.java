package seon.startmodule.controller.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error", required = false)String error,
                            @RequestParam(value = "exception", required = false)String exception,
                            Model model) {

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        log.info("loginForm view resolve");

        return "config/auth/login";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "config/auth/join";
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
