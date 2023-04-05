package seon.startmodule.mapper;


import org.apache.ibatis.annotations.Mapper;
import seon.startmodule.dto.UsersDTO;
import seon.startmodule.dto.UsersDTO;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<UsersDTO> getUsersList();
}
