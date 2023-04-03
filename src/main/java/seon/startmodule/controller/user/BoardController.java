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
    @GetMapping
    public String boardList(Model model) {
        List<BoardDTO> list = boardService.getBoardList();
        model.addAttribute("list", list);
        return "user/board/list";
    }

    @GetMapping("/{boardId}")
    public String detail(@PathVariable("boardId") Long boardId, Model model) {
        BoardDTO boardDTO = boardService.getBoard(boardId);
        model.addAttribute("boardDTO", boardDTO);
        return "user/board/detail";
    }

    @GetMapping("/savePage")
    public String savePage() {
        return "user/board/save";
    }

    @PostMapping("/saveBoard")
    public String saveBoard(BoardDTO boardDTO) {
         boardService.saveBoard(boardDTO);
        return "redirect:/board";
    }

    @GetMapping("/modifyPage/{boardId}")
    public String modifyPage(@PathVariable("boardId") Long boardId, Model model) {
        BoardDTO boardDTO = boardService.getBoard(boardId);
        model.addAttribute("boardDTO", boardDTO);
        return "user/board/modify";
    }
    @PostMapping("/modifyBoard")
    public String modifyBoard(BoardDTO boardDTO) {
        boardService.modifyBoard(boardDTO);
        return "redirect:/board";
    }

    @GetMapping("/deleteBoard/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/board";
    }
}
