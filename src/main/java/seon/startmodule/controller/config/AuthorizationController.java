package seon.startmodule.controller.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seon.startmodule.dto.UserDTO;
import seon.startmodule.service.UserService;

import java.time.LocalDateTime;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthorizationController {
    private final UserService service;

    private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/loginPage")
    public String loginPage(@RequestParam(value = "error", required = false)String error,
                            Model model) {

        model.addAttribute("error", error);

        return "config/auth/login";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "config/auth/join";
    }

    @ResponseBody
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserDTO dto) {
        LocalDateTime now = LocalDateTime.now();
        try {
            service.join(dto.getId(), dto.getName(), dto.getPassword(), dto.getRole(), now);

            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
