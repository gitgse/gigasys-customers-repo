package com.gigasys.customerrepo.entities;

/**
 * Category.java
 * Enum listant les différentes catégories de cliens
 * @author Gilles
 */
public enum Category {
	r("retailer"), c("consumer"), p("professionnal");
	
	private final String label;
	
	private Category(String label) {
		this.label = label;
	}
	
	public String label() {
		return label;
	}
}
