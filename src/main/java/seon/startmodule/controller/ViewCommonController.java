package seon.startmodule.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import seon.startmodule.config.role.UserAuthorize;
import seon.startmodule.dto.BoardDTO;
import seon.startmodule.service.BoardService;

import java.util.List;

@Controller
@UserAuthorize
@AllArgsConstructor
@RequestMapping("/view")
public class ViewCommonController {

    private final BoardService boardService;

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

    @GetMapping("/board")
    public String boardPage(Model model) {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "board/list";
    }

}
