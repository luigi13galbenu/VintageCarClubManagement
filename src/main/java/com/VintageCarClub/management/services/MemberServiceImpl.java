package com.VintageCarClub.management.services;

import com.VintageCarClub.management.models.dtos.MemberRequestDto;
import com.VintageCarClub.management.models.dtos.MemberResponseDto;
import com.VintageCarClub.management.models.entities.Member;
import com.VintageCarClub.management.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberResponseDto saveMember(MemberRequestDto memberDto) {
        Member member = new Member();

        member.setName(memberDto.getName());
        member.setEmail(memberDto.getEmail());


        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getEmail());
    }

    @Override
    public MemberResponseDto updateMember(Long id, MemberRequestDto memberDto) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        existingMember.setName(memberDto.getName());
        existingMember.setEmail(memberDto.getEmail());


        Member updatedMember = memberRepository.save(existingMember);
        return mapToDto(updatedMember);
    }

    @Override
    public MemberResponseDto findMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        return mapToDto(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<MemberResponseDto> findAllMembers() {
        return memberRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private MemberResponseDto convertToDto(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        return dto;
    }

    private MemberResponseDto mapToDto(Member member) {
        return new MemberResponseDto(member.getId(), member.getName(), member.getEmail());

    }

    @Override
    public List<MemberResponseDto> findMembersByCriteria(String name, String email, LocalDate startDate, LocalDate endDate) {
        return memberRepository.findMembersByMultipleCriteria(name, email, startDate, endDate).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}