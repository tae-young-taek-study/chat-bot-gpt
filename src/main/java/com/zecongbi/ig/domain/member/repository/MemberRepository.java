package com.zecongbi.ig.domain.member.repository;

import com.zecongbi.ig.domain.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  List<Member> findMembersByDesiredTime(int time);
}
