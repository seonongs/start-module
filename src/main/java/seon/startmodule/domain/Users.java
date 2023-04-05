package seon.startmodule.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(unique = true)
    private String id;

    private String name;
    private String password;
    private String role;
    public Users() {}

    private Users(Long seq, String id, String name, String password, String role) {
        this.seq = seq;
        this.name = name;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public static Users createUser(String id, String name, String password, PasswordEncoder passwordEncoder) {
        return new Users(null, id, name, passwordEncoder.encode(password), "USER");
    }


}
