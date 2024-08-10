package com.example.wh_backend.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "emailconfig")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmailConfiguration {
    private String adminEmail;
    private String infoEmail;
    private String contactEmail;
    private String noReplyEmail;
    private String promotionsEmail;
}
