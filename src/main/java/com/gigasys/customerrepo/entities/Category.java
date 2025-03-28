package com.gigasys.customerrepo.entities;

public enum Category {
	r("retailer"), c("customer"), p("professionnal");
	
	private final String label;
	
	private Category(String label) {
		this.label = label;
	}
	
	public String label() {
		return label;
	}
}
