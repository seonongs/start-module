package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import seon.startmodule.dto.CodeDTO;
import seon.startmodule.mapper.CodeMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class CodeService {

    private final CodeMapper mapper;
    public List<CodeDTO> getCode(CodeDTO dto) {
        return mapper.getCode(dto);
    }
}
