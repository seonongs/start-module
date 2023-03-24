package seon.startmodule.service;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seon.startmodule.dto.TestDTO;
import seon.startmodule.mapper.TestMapper;

import java.util.List;
@Service
public class TestService {

    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public List<TestDTO> getTest() {
        return testMapper.getTest();
    }
}
