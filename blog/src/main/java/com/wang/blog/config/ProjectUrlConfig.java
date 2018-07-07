package com.wang.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：泽非
 * @ Date       ：Created in 20:13 2018/7/7
 * @ Description：
 * @ Modified By：
 */
@Data
@ConfigurationProperties(prefix = "project-url")
@Component
public class ProjectUrlConfig {
    public String blog;
}
