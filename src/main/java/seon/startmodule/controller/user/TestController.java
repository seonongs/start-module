package seon.startmodule.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seon.startmodule.dto.TestDTO;
import seon.startmodule.service.TestService;

import java.util.List;
@AllArgsConstructor
@Controller
public class TestController {
    private final TestService testService;

    @ResponseBody
    @PostMapping("/test")
    public List<TestDTO> test () {
        return testService.getTest();
    }

}
