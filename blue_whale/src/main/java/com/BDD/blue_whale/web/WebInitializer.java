package com.BDD.blue_whale.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.BDD.blue_whale.BlueWhaleApplication;

public class WebInitializer extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BlueWhaleApplication.class);
	}
}
