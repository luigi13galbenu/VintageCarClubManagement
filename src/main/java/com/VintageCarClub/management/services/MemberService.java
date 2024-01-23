package com.VintageCarClub.management.services;


import com.VintageCarClub.management.models.dtos.MemberRequestDto;
import com.VintageCarClub.management.models.dtos.MemberResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface MemberService {

    MemberResponseDto saveMember(MemberRequestDto memberDto);

    MemberResponseDto updateMember(Long id, MemberRequestDto memberDto);

    MemberResponseDto findMemberById(Long id);

    void deleteMember(Long id);

    List<MemberResponseDto> findAllMembers();

    List<MemberResponseDto> findMembersByCriteria(String name, String email, LocalDate startDate, LocalDate endDate);
}
