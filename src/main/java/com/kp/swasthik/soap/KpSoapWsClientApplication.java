package com.kp.swasthik.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kp.swasthik.ws.HelloWorld;

@SpringBootApplication
public class KpSoapWsClientApplication {

	private static final Logger LOG = LoggerFactory.getLogger(KpSoapWsClientApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(KpSoapWsClientApplication.class, args);
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		LOG.info(helloWorld.sayHello("Karthik Prasad"));
		SpringApplication.exit(context, () -> 0);
	}
}
