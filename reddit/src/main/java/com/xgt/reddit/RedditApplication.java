package com.xgt.reddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

import com.xgt.reddit.config.RsaKeyProperties;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(RsaKeyProperties.class)
public class RedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

}
