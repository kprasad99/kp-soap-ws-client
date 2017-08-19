package com.kp.swasthik.soap;

import java.util.Collections;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kp.swasthik.ws.HelloWorld;

@Configuration
public class CxfConfig {

	@Bean
	public HelloWorld bus(SpringBus bus) {
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setServiceClass(HelloWorld.class);
		bean.setAddress("http://localhost:8484/services/kp?wsdl");
		bean.setBus(bus);
		bean.setFeatures(Collections.singletonList(new LoggingFeature()));
		return bean.create(HelloWorld.class);
	}
}