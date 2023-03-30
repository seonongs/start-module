package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import seon.startmodule.domain.Member;
import seon.startmodule.repository.MemberRepository;

import java.util.Optional;
@AllArgsConstructor
@Service
public class MemberService {
    private final MemberRepository repository;

    public Optional<Member> findOne(String userId) {
        return repository.findByUserid(userId);
    }
}
