package com.VintageCarClub.management.repositories;

import com.VintageCarClub.management.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    List<Member> findByEmail(String email);
    @Query("SELECT m FROM Member m WHERE " +
            "(:name IS NULL OR m.name = :name) AND " +
            "(:email IS NULL OR m.email = :email) AND " +
            "(:startDate IS NULL OR m.registrationDate >= :startDate) AND " +
            "(:endDate IS NULL OR m.registrationDate <= :endDate)")

    List<Member> findMembersByMultipleCriteria(
            @Param("name") String name,
            @Param("email") String email,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

}
