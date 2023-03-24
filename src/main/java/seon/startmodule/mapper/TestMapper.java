package seon.startmodule.mapper;

import seon.startmodule.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TestMapper {

    List<TestDTO> getTest();

}
