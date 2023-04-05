package seon.startmodule.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private String seq;
    private String id;
    private String name;
    private String password;
    private String role;
}
