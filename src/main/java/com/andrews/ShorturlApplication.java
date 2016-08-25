package com.andrews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.web.*;

@SpringBootApplication
@EnableAutoConfiguration
public class ShorturlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ShorturlApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShorturlApplication.class);
	}
}
