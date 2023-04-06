package seon.startmodule.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String id;
    private String name;
    private String password;
    private String role;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    private UserS(Long seq, String id, String name, String password, String role, LocalDateTime createDate) {
        this.seq = seq;
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
    }

    public static UserS createUser(String id, String name, String password, PasswordEncoder passwordEncoder, String role, LocalDateTime createDate) {
        return new UserS(null, id, name, passwordEncoder.encode(password), "USER", createDate);
    }


}
