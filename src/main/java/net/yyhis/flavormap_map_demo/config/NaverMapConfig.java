package net.yyhis.flavormap_map_demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "naver.map")
public class NaverMapConfig {
    private String clientId;
    private String secretKey;
    private String url;
}
