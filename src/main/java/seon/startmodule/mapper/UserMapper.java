package seon.startmodule.mapper;


import org.apache.ibatis.annotations.Mapper;
import seon.startmodule.dto.UserDTO;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> getUserList();
}
