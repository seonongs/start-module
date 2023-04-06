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

    private final BoardService service;

    @GetMapping("/list")
    public String boardList(Model model) {
        List<BoardDTO> list = service.getList();
        model.addAttribute("list", list);
        return "user/board/list";
    }
    @GetMapping("/{seq}")
    public String detail(@PathVariable("seq") Long seq, Model model) {
        BoardDTO data = service.getOne(seq);
        model.addAttribute("data", data);
        return "user/board/detail";
    }
    @GetMapping("/save")
    public String save() {
        return "user/board/save";
    }

    @PostMapping("/save")
    public String save(BoardDTO dto) {
         service.save(dto);
        return "redirect:/board/list";
    }
    @GetMapping("/modify/{seq}")
    public String modify(@PathVariable("seq") Long seq, Model model) {
        BoardDTO data = service.getOne(seq);
        model.addAttribute("data", data);
        return "user/board/modify";
    }
    @PostMapping("/modify")
    public String modify(BoardDTO dto) {
        service.modify(dto);
        return "redirect:/board/list";
    }
    @GetMapping("/delete/{seq}")
    public String delete(@PathVariable("seq") Long id) {
        service.delete(id);
        return "redirect:/board/list";
    }
}
