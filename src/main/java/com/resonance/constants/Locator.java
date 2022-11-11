package com.resonance.constants;

public interface Locator {

	String homeScreen_closePopupBtn = "XPATH##//button[contains(text(),'✕')]";
	String homeScreen_travelLink = "XPATH##//a[contains(@href,'travel/fli')]";
	String homeScreen_fromCity = "XPATH##//label[contains(text(),'From')]/parent::div";
	String homeScreen_searchTxtBx = "XPATH##input[placeholder='Search for products, brands and more']";
	String homeScreen_fromCity_BOM = "XPATH##//label[contains(text(),'From')]/parent::div/following-sibling::div/descendant::div[contains(text(),'BOM')]";
	
}
