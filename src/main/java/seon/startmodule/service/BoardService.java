package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public BoardDTO getBoard(long boardId) {
        return boardMapper.getBoard(boardId);
    }

    @Transactional
    public void saveBoard(BoardDTO boardDTO) {
        boardMapper.saveBoard(boardDTO);
    }
    public void modifyBoard(BoardDTO boardDTO) {
        boardMapper.modifyBoard(boardDTO);
    }

    public void deleteBoard(long boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
