package seon.startmodule.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import seon.startmodule.dto.BoardDTO;
import seon.startmodule.service.BoardService;

import java.util.List;

@AllArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public String boardList (Model model) {

        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "board/list";
    }

}
