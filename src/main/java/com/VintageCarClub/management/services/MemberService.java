package com.VintageCarClub.management.services;

import com.VintageCarClub.management.exceptions.ResourceNotFoundException;
import com.VintageCarClub.management.models.entities.Member;
import com.VintageCarClub.management.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member saveMember(Member member) {
        validateMember(member);
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member member) {
        validateMember(member);
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member not found with id " + id);
        }
        member.setId(id);
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member not found with id " + id);
        }
        memberRepository.deleteById(id);
    }

    private void validateMember(Member member) {
        if (member == null || !StringUtils.hasText(member.getName()) || !StringUtils.hasText(member.getEmail())) {
            throw new IllegalArgumentException("Member name and email must not be empty");
        }
    }
}