package com.sbmicroservices.limits.model;

public class Limit {

	private String minimum;
	
	private String maximum;

	
	public Limit() {
		super();
	}

	public Limit(String minimum, String maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public String getMinumum() {
		return minimum;
	}

	public void setMinumum(String minumum) {
		this.minimum = minumum;
	}

	public String getMaximum() {
		return maximum;
	}

	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	
}
