package com.zecongbi.ig.domain.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {

  @Bean
  MailMessage mailMessage() {
    return new SimpleMailMessage();
  }

}
