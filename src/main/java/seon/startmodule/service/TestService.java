package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import seon.startmodule.dto.TestDTO;
import seon.startmodule.mapper.TestMapper;

import java.util.List;
@Service
@AllArgsConstructor
public class TestService {

    private final TestMapper testMapper;

    public List<TestDTO> getTest() {
        return testMapper.getTest();
    }
}
