package com.czort.app.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "standard")
public class StandardProperties {
    @NotNull private String path;
    @NotNull private Integer count;
}
