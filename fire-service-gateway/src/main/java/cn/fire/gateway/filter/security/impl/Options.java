package cn.fire.gateway.filter.security.impl;

import cn.fire.gateway.filter.security.AbstractProtect;
import com.google.common.collect.Lists;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;

/**
 * Options全部为通过
 * @Author: wangzc
 * @Date: 2020/9/25 11:17
 */
public class Options extends AbstractProtect {

    public Options(ServerHttpRequest httpRequest, String timestamp, String nonce, String sign) {
        super(httpRequest, timestamp, nonce, sign);
    }

    @Override
    protected List<HttpMethod> supportMethods() {
        return Lists.newArrayList(HttpMethod.OPTIONS);
    }

    @Override
    protected Boolean verify() {
        return Boolean.TRUE;
    }
}