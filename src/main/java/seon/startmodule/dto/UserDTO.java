package seon.startmodule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long seq;
    private String id;
    private String name;
    private String password;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
