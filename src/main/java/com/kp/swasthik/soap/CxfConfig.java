package com.kp.swasthik.soap;

import java.util.Collections;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kp.swasthik.ws.HelloWorld;

@Configuration
@ConfigurationProperties(prefix = "cxf")
public class CxfConfig {

	private String serverUrl;

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	@Bean
	public HelloWorld bus(SpringBus bus) {
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setServiceClass(HelloWorld.class);
		bean.setAddress(serverUrl);
		bean.setBus(bus);
		bean.setFeatures(Collections.singletonList(new LoggingFeature()));
		return bean.create(HelloWorld.class);
	}
}