package com.zecongbi.ig.domain.member.application;

import com.zecongbi.ig.domain.member.dto.MemberResponse;
import com.zecongbi.ig.domain.member.entity.Member;
import com.zecongbi.ig.domain.member.repository.MemberRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public List<MemberResponse> getMembersByDesiredTime() {
    int currentHour = LocalDateTime.now().getHour();
    List<Member> members = memberRepository.findMembersByDesiredTime(currentHour);
    return members.stream().map(MemberResponse::from).toList();
  }
}
