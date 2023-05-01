package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.common.config.OpenAIChatCompletionFeignClientConfig;
import com.zecongbi.ig.domain.question.dto.ChatGPTRequest;
import com.zecongbi.ig.domain.question.dto.ChatGPTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OpenAIChatCompletionFeignClient", url = "${openai.url}", configuration = OpenAIChatCompletionFeignClientConfig.class)
public interface OpenAIChatCompletionFeignClient {

  @PostMapping(value = "${openai.chat-completion-uri}")
  ChatGPTResponse sendQuestion(@RequestBody ChatGPTRequest chatGPTRequest);
}
