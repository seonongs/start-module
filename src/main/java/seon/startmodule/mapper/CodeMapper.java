package seon.startmodule.mapper;

import org.apache.ibatis.annotations.Mapper;
import seon.startmodule.dto.CodeDTO;

import java.util.List;
@Mapper
public interface CodeMapper {
    public List<CodeDTO> getCode(CodeDTO dto);
}
