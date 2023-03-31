package seon.startmodule.mapper;

import org.apache.ibatis.annotations.Mapper;
import seon.startmodule.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> getBoardList();

    BoardDTO getBoard(long id);

    BoardDTO regBoard(BoardDTO boardDTO);
}
