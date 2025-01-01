package org.marouanedbibih.car.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * Creates and configures a {@link RestTemplate} bean.
     * 
     * The {@link RestTemplate} is configured with a
     * {@link SimpleClientHttpRequestFactory}
     * that sets the connection timeout and read timeout to 5000 milliseconds (5
     * seconds).
     * 
     * @return a configured {@link RestTemplate} instance
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

}
