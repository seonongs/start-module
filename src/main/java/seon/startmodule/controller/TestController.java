package seon.startmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seon.startmodule.config.role.UserAuthorize;
import seon.startmodule.dto.TestDTO;
import seon.startmodule.service.TestService;

import java.util.List;

@Controller
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    @ResponseBody
    @UserAuthorize
    public List<TestDTO> Test() {
        return testService.getTest();
    }

}
