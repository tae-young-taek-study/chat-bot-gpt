package com.zecongbi.ig.domain.common.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zecongbi.ig.domain.question.model.OpenAIQuestionGenerator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    classes = {FeignTestContext.class, OpenAIQuestionGenerator.class, ObjectMapper.class}
)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FeignTest {

}
