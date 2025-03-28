package com.gigasys.customerrepo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Accès rapide à swagger-ui
		registry.addRedirectViewController("/swagger-ui", "/webjars/swagger-ui/index.html");
		// Surchage du fichier swagger-initializer.js
		registry.addViewController("/webjars/swagger-ui/swagger-initializer.js")
				.setViewName("forward:/swagger-ui/custom-initializer.js");
	}

}
