package com.grt;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.objectrepository.GrtObj;
import com.sun.jna.StringArray;

import baseclass.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;

public class Grt{
	public static Utility utils=Utility.getUtilityObject();
	 GrtObj grt = new GrtObj();
	@Given("Launch the GRT application {string}")
	public void launch_the_grt_application(String string) {
//	    Utility.applicationLaunch(string);
	}
	
	@Then("Validate user lands on HomePage")
	public void validate_user_lands_on_home_page() {
		String exp_Title = "GRT Jewellers | Jewellery India";
	    if(utils.returnTitle().contains(exp_Title))
	    	System.out.println("User Lands on Homepage successfully");
	    else
	    	System.err.println("User not Lands on Homepage successfully");
	}

	@When("mouse hover to All Jewellery option")
	public void mouse_hover_to_all_jewellery_option() {
		if(utils.isdisplay(grt.getAd()))
			utils.button(grt.getAd());
		utils.mouseHover(grt.getAll_Jewellery());
	}

	@When("User clicks Male option")
	public void user_clicks_male_option() {
		utils.button(grt.getMale(), 0);
	}

	@Then("User validates the menu options")
	public void user_validates_the_menu_options() {
		utils.exp_menu = new ArrayList();
		utils.exp_menu.add("Bangles & Bracelets"); utils.exp_menu.add("Chain");
		utils.exp_menu.add("Earrings");utils.exp_menu.add("Pendants");utils.exp_menu.add("Ring");
		utils.exp_menu.add("Necklace");utils.exp_menu.add("Mangalsutra");
		utils.act_menu = grt.getMenu();
	   for(int i=0;i<utils.exp_menu.size();i++) {
		   Boolean find = utils.returnText(utils.act_menu.get(i)).equals(utils.exp_menu.get(i));
	   }
	}

	@When("User prints the how many total no. of items should display in that page")
	public void user_prints_the_how_many_total_no_of_items_should_display_in_that_page() {
	    String txt = utils.returnText(grt.getNo_Of_Items());
	    System.out.println(txt);
	}

	@Then("User validates that total items are displaying in that page")
	public void user_validates_that_total_items_are_displaying_in_that_page() {
		utils.js= (JavascriptExecutor) utils.driver;
		try {
	    for(int i=0;i<=10;i++) {
	    	utils.js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    	utils.scrollUp(grt.getSearch());
	    	Thread.sleep(2000);
	    	}}
		catch(Exception e){
			e.printStackTrace();
		}
    	List<WebElement> size = grt.getPrice();
    	System.out.println(size.size());
	    }
	

	@When("User prints the Product name and price")
	public void user_prints_the_product_name_and_price() {
		List<WebElement> name = grt.getProduct();
		List<WebElement> price = grt.getPrice();
		for(int i=0;i<name.size();i++) {
			System.out.println(utils.getAttri(name.get(i), "href")+"  "+utils.returnText(price.get(i)));
			}
	}
}

