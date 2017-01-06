package com.tistory.one0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@SpringBootApplication
public class SpringbootHandlermappingApplication {

	 @Autowired
	 private RequestMappingHandlerMapping handlerMapping;

	private static final Logger logger = LoggerFactory.getLogger(SpringbootHandlermappingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHandlermappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			logger.info("###############################################");
			Map<RequestMappingInfo, HandlerMethod> mappings = handlerMapping.getHandlerMethods();
			Set<RequestMappingInfo> keys = mappings.keySet();
			Iterator<RequestMappingInfo> iterator = keys.iterator();

			List<String> urlList = new ArrayList<String>();
			while (iterator.hasNext()) {
				RequestMappingInfo key = iterator.next();
				HandlerMethod value = mappings.get(key);
				urlList.add(key.getPatternsCondition().toString());

				logger.info(key.getPatternsCondition()  + "[" + key.getMethodsCondition()  + "] : " + value);
			}
			logger.info("###############################################");
		};
	}

	@Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
       RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
       return requestMappingHandlerMapping;
    }
}
