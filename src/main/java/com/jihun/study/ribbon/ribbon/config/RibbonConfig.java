package com.jihun.study.ribbon.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfig {
    /*
     * You can customize your ribbon loadBalancer in here
     */

    private IClientConfig clientConfig;

    @Autowired
    public RibbonConfig(IClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @Bean
    public IPing getPing(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public IRule getRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
