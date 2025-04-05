package com.objectrepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseclass.Utility;

public class Policy{
	public static Utility utils = Utility.getUtilityObject();
	public Policy() {
	      PageFactory.initElements(utils.driver,this);		
	}
	@FindBy(xpath="//div[@class='prd-icon add shadowHandler short']/p)[5]")
	private WebElement carInsurance;
	
	@FindBy(id="regNoTextBox")
	private WebElement carDetails;
	
	@FindBy(xpath="//button[text()='View Prices ']")
	private WebElement carPrice;
	
	@FindBy(xpath="//button[text()='View Prices']")
	private WebElement bikePrice;
	
	@FindBy(id="btntwSubmit")
	private WebElement ebikePrice;
	
	@FindBy(xpath="//div[@class='ins_name']")
	private List<WebElement> Ins_name;
	
	@FindBy(xpath="//button[@class='buy-now-btn']")
	private List<WebElement>  price;
	
	@FindBy(xpath="//input[@id='rto']")
	private WebElement bikeDetails;
	
	@FindBy(xpath="//a[text()='Insurance Products ']")
	private WebElement insuranceProducts;
	
	@FindBy(xpath="//span[text()='E-Bike Insurance']")
	private WebElement eBikeInsurance;
	
	@FindBy(className="fullWidht")
	private WebElement eBikeDetails;

	public WebElement getCarInsurance() {
		return carInsurance;
	}

	public WebElement getCarDetails() {
		return carDetails;
	}

	public WebElement getCarPrice() {
		return carPrice;
	}

	public WebElement getBikePrice() {
		return bikePrice;
	}

	public WebElement getEbikePrice() {
		return ebikePrice;
	}

	public List<WebElement>  getIns_Name() {
		return Ins_name;
	}

	public List<WebElement>  getPrice() {
		return price;
	}

	public WebElement getBikeDetails() {
		return bikeDetails;
	}

	public WebElement getInsuranceProducts() {
		return insuranceProducts;
	}

	public WebElement geteBikeInsurance() {
		return eBikeInsurance;
	}

	public WebElement geteBikeDetails() {
		return eBikeDetails;
	}
}
