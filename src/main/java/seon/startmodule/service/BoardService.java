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

    private final BoardMapper mapper;

    public List<BoardDTO> getList() {
        return mapper.getList();
    }

    public BoardDTO getOne(long id) {
        return mapper.getOne(id);
    }

    @Transactional
    public void save(BoardDTO dto) {
        mapper.save(dto);
    }
    public void modify(BoardDTO dto) {
        mapper.modify(dto);
    }

    public void delete(long id) {
        mapper.delete(id);
    }
}
