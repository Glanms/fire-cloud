package cn.fire.common.web.config;

import cn.fire.common.web.handler.ExceptionFeignDecoder;
import feign.*;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wangzc
 * @Date: 2020/7/31 11:30
 */

@Configuration
@ConditionalOnClass(feign.Retryer.class)
public class GlobalFeignConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> objectFactory;

    /**
     * feign构造器
     * @return
     */
    @Bean
    public Feign.Builder feignBuilder() { return Feign.builder(); }

    /**
     * 设置不重试
     * @return
     */
    @Bean
    Retryer retryer () { return Retryer.NEVER_RETRY; }

    /**
     * 自定义Feign解码器
     * @return
     */
    @Bean
    Decoder decoder() {
        return new ExceptionFeignDecoder(objectFactory);
    }

//    /**
//     * Consumer和Producer间增加基础的Basic认证
//     * @return
//     */
//    @Bean
//    BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor(httpBasicUserName, httpBasicPassword);
//    }

}

