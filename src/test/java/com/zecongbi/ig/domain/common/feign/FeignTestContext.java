package com.zecongbi.ig.domain.common.feign;

import com.zecongbi.ig.domain.common.config.OpenAIChatCompletionFeignClientConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@ImportAutoConfiguration({
    OpenAIChatCompletionFeignClientConfig.class,
    FeignAutoConfiguration.class,
    HttpMessageConvertersAutoConfiguration.class,
})
public class FeignTestContext {

}
