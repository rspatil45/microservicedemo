package com.rspatil.microservice.limitsservice.bean;

public class Limits {
	
	int minmum;
	int maximum;
	public Limits(int minmum, int maximum) {
		super();
		this.minmum = minmum;
		this.maximum = maximum;
	}
	public int getMinmum() {
		return minmum;
	}
	public void setMinmum(int minmum) {
		this.minmum = minmum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public Limits() {
		super();
	}
	
}
