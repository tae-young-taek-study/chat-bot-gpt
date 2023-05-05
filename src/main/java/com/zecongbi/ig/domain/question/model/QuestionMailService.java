package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.member.application.MemberService;
import com.zecongbi.ig.domain.member.dto.MemberResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class QuestionMailService implements QuestionSendService {

  private static final String TITLE = "오늘의 질문드립니다.";

  private final JavaMailSender emailSender;
  private final MailMessage emailMessage;
  private final MemberService memberService;

  @Autowired
  public QuestionMailService(JavaMailSender emailSender, MailMessage emailMessage,
      MemberService memberService) {
    this.emailSender = emailSender;
    this.emailMessage = emailMessage;
    this.memberService = memberService;
  }

  @Override
  public void sendQuestions(String text) {
    List<MemberResponse> targetMembers = memberService.getMembersByDesiredTime();
    targetMembers.parallelStream().forEach(members -> {
      emailMessage.setTo(members.email());
      emailMessage.setSubject(TITLE);
      emailMessage.setText(text);

      emailSender.send((SimpleMailMessage) emailMessage);
    });
  }
}
