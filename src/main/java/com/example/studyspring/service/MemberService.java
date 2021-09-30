package com.example.studyspring.service;

import com.example.studyspring.domain.Member;
import com.example.studyspring.repository.MemberRepository;
import com.example.studyspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


    // 회원가입
    public Long join(Member member) {

        validateDuplicateMember(member);    // 같은 이름이 있는 중복 회원은 안된다.
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {  // 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
