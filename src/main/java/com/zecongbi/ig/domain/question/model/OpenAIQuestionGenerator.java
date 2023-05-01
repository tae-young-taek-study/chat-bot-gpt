package com.zecongbi.ig.domain.question.model;

import com.zecongbi.ig.domain.common.config.OpenAIChatCompletionFeignClientConfig;
import com.zecongbi.ig.domain.question.dto.ChatGPTRequest;
import com.zecongbi.ig.domain.question.dto.ChatGPTResponse;
import com.zecongbi.ig.domain.question.dto.Message;
import com.zecongbi.ig.domain.question.vo.Category;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OpenAIQuestionGenerator implements QuestionGenerator{

  private final OpenAIChatCompletionFeignClient feignClient;
  private final OpenAIChatCompletionFeignClientConfig feignClientConfig;

  public OpenAIQuestionGenerator(OpenAIChatCompletionFeignClient feignClient,
      OpenAIChatCompletionFeignClientConfig feignClientConfig) {
    this.feignClient = feignClient;
    this.feignClientConfig = feignClientConfig;
  }

  @Override
  public List<String> generate() {
    ChatGPTRequest chatGPTRequest = new ChatGPTRequest(
        feignClientConfig.getModel(),
        List.of(new Message(feignClientConfig.getRole(), Category.DB.toString())));
    ChatGPTResponse chatGPTResponse = feignClient.sendQuestion(chatGPTRequest);
    return chatGPTResponse.choices().stream()
        .map(choice -> choice.message().getContent()).collect(Collectors.toList());
  }
}
