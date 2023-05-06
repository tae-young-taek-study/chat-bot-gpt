package com.zecongbi.ig.domain.member.dto;

import com.zecongbi.ig.domain.member.entity.Member;

public record MemberResponse(
    String email,
    int desiredTime
) {
  public static MemberResponse from(Member member) {
    return new MemberResponse(member.getEmail(), member.getDesiredTime());
  }
}
