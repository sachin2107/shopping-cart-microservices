package com.sbmicroservices.limits.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	private String minimum;

	private String maximum;

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getMaximum() {
		return maximum;
	}

	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

}
