package com.VintageCarClub.management.repositories;

import com.VintageCarClub.management.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    List<Member> findByEmail(String email);
}
