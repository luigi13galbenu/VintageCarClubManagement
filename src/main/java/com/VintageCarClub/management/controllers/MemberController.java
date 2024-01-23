package com.VintageCarClub.management.controllers;

import com.VintageCarClub.management.models.dtos.MemberRequestDto;
import com.VintageCarClub.management.models.dtos.MemberResponseDto;
import com.VintageCarClub.management.services.MemberService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberRequestDto memberDto) {
        MemberResponseDto createdMember = memberService.saveMember(memberDto);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMemberById(@PathVariable Long id) {
        MemberResponseDto memberDto = memberService.findMemberById(id);
        return ResponseEntity.ok(memberDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberRequestDto memberDto) {
        MemberResponseDto updatedMember = memberService.updateMember(id, memberDto);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAllMembers() {
        List<MemberResponseDto> members = memberService.findAllMembers();
        return ResponseEntity.ok(members);

    }

    @GetMapping("/search")
    public ResponseEntity<List<MemberResponseDto>> findMembersByCriteria(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<MemberResponseDto> members = memberService.findMembersByCriteria(name, email, startDate, endDate);
        return ResponseEntity.ok(members);
    }
}

