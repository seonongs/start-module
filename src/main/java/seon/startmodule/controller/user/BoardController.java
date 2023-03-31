package seon.startmodule.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seon.startmodule.dto.BoardDTO;
import seon.startmodule.service.BoardService;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList (Model model) {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "user/board/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.getBoard(id);
        model.addAttribute("boardDTO", boardDTO);
        return "user/board/detail";
    }

    @GetMapping("/regPage")
    public String regPage() {
        return "user/board/reg";
    }

    @ResponseBody
    @PostMapping("/regBoard")
    public BoardDTO regBoard(@RequestBody BoardDTO boardDTO) {
        return boardService.regBoard(boardDTO);
    }

}
