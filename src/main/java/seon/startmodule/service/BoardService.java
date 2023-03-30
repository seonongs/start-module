package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import seon.startmodule.dto.BoardDTO;
import seon.startmodule.mapper.BoardMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }
}
