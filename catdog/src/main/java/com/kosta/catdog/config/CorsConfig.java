package com.kosta.catdog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*"); // Access-Control-Allow-Origin ( Response에 자동으로 추가해줌)
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*"); // Access-Control-Allow-Headers 
		config.addAllowedMethod("*"); // Access-Control-Allow-Method 
		
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
