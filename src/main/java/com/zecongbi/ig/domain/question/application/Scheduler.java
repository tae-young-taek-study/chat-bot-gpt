package com.zecongbi.ig.domain.question.application;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {

  private final QuestionLoader questionLoader;
  private final QuestionSender questionSender;

  public Scheduler(QuestionLoader questionLoader, QuestionSender questionSender) {
    this.questionLoader = questionLoader;
    this.questionSender = questionSender;
  }

  // 사용자가 입력하지 않을 시간 대에 질문을 가져오자. (새벽 4시 ~ 5시)
  @Scheduled(cron = "0 0 4 * * *")
  public void loadQuestions() {
    String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    log.info(MessageFormat.format("{0} - [QuestionSender] load questions to database.", startTime));
    questionLoader.load();
    String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    log.info(MessageFormat.format("{0} - [QuestionSender] load complete.", endTime));
  }

  @Scheduled(cron = "0 32 6-23,0-3 * * *")
  public void sendQuestions() {
    String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    log.info(MessageFormat.format("{0} - [QuestionSender] send questions to members.", startTime));
    questionSender.send();
    String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    log.info(MessageFormat.format("{0} - [QuestionSender] send complete.", endTime));
  }
}
