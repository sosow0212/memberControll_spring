package com.example.studyspring.repository;

import com.example.studyspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String id);
    List<Member> findAll();
}
