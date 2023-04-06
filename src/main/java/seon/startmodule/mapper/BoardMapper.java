package seon.startmodule.mapper;

import org.apache.ibatis.annotations.Mapper;
import seon.startmodule.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> getList();

    BoardDTO getOne(long id);

    void save(BoardDTO dto);
    void modify(BoardDTO dto);
    void delete(long id);
}
