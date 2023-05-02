package com.zecongbi.ig.domain.question.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zecongbi.ig.domain.common.config.OpenAIChatCompletionFeignClientConfig;
import com.zecongbi.ig.domain.common.exception.APIResultFormatException;
import com.zecongbi.ig.domain.common.exception.BusinessException;
import com.zecongbi.ig.domain.question.dto.ChatGPTRequest;
import com.zecongbi.ig.domain.question.dto.ChatGPTResponse;
import com.zecongbi.ig.domain.question.dto.Choice;
import com.zecongbi.ig.domain.question.dto.InterviewResponse;
import com.zecongbi.ig.domain.question.dto.Message;
import com.zecongbi.ig.domain.question.dto.MessageResponse;
import com.zecongbi.ig.domain.question.vo.Category;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OpenAIQuestionGenerator implements QuestionGenerator {

  private final OpenAIChatCompletionFeignClient feignClient;
  private final OpenAIChatCompletionFeignClientConfig feignClientConfig;
  private final ObjectMapper objectMapper;
  private static final String API_EXCEPTION_MESSAGE = "Open AI API 결과 데이터 형식 오류";

  public OpenAIQuestionGenerator(OpenAIChatCompletionFeignClient feignClient,
      OpenAIChatCompletionFeignClientConfig feignClientConfig, ObjectMapper objectMapper) {
    this.feignClient = feignClient;
    this.feignClientConfig = feignClientConfig;
    this.objectMapper = objectMapper;
    objectMapper.registerModule(new JavaTimeModule());
  }

  @Override
  public List<InterviewResponse> generate() {
    ChatGPTRequest chatGPTRequest = new ChatGPTRequest(
        feignClientConfig.getModel(),
        List.of(new Message(feignClientConfig.getRole(), Category.collectCategories())));
    ChatGPTResponse chatGPTResponse = feignClient.sendQuestion(chatGPTRequest);
    String interviewResponse = chatGPTResponse.getChoices().get(0).getMessage().getContent();
    try {
      return objectMapper.readValue(interviewResponse, new TypeReference<>() {});
    } catch (JsonProcessingException e) {
      throw new BusinessException(API_EXCEPTION_MESSAGE, e);
    }
  }
}
