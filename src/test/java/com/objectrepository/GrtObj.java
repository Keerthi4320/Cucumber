package com.objectrepository;

import baseclass.Utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class GrtObj {
	public static Utility utils=Utility.getUtilityObject();
	public GrtObj() {
      PageFactory.initElements(utils.driver,this);		
}
	@FindBy(xpath="//a[@class='inner tm-close']")
	private WebElement ad;
	
	@FindBy(xpath="//a[text()='All Jewellery']")
	private WebElement all_Jewellery;
	
	@FindBy(xpath="//span[text()='Male']")
	private WebElement male;
	
	@FindBy(xpath="//div[@class='product-title']")
	private List<WebElement> menu;
	
	@FindBy(xpath="//p[@class=\"item-label ms-md-3 ms-2\"]")
	private WebElement no_Of_Items;
	
	@FindBy(xpath="//h2[text()='Popular search']")
	private WebElement search;
	
	@FindBy(xpath="//h3[@class='formatted-price']")
	private List<WebElement> price;
	
	@FindBy(xpath="//div[@class='col-xl-3 col-md-4 col-6']/a")
	private List<WebElement> product;

	public WebElement getAd() {
		return ad;
	}

	public WebElement getAll_Jewellery() {
		return all_Jewellery;
	}

	public WebElement getMale() {
		return male;
	}

	public List<WebElement> getMenu() {
		return menu;
	}

	public WebElement getNo_Of_Items() {
		return no_Of_Items;
	}

	public WebElement getSearch() {
		return search;
	}

	public List<WebElement> getPrice() {
		return price;
	}

	public List<WebElement> getProduct() {
		return product;
	}

	
	
	
	
	
	
}