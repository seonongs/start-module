package seon.startmodule.controller.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import seon.startmodule.dto.CodeDTO;
import seon.startmodule.service.CodeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CodeController {

    private final CodeService service;

    @PostMapping("/code")
    public List<CodeDTO> getCode(CodeDTO dto) {
        return service.getCode(dto);
    }

}
