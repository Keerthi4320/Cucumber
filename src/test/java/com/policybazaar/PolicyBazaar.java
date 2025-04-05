package com.policybazaar;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.databind.util.Converter;
import com.objectrepository.Policy;

import baseclass.Utility;
import io.cucumber.datatable.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PolicyBazaar{
	public static Utility utils=Utility.getUtilityObject();
	Policy pol = new Policy();
	@Given("Launch the PolicyBazaar application {string}")
	public void launch_the_policy_bazaar_application(String string) {
		Utility.applicationLaunch(string);
	}

	@Then("Validate user lands on PB HomePage")
	public void Validate_user_lands_on_HomePage() {
		String exp_Title="Insurance";
	    if(utils.returnTitle().contains(exp_Title))
	    	System.out.println("User lands on HomePage correctly");
	    else
	    	System.out.println("User not lands on HomePage correctly");
	}
	@When("User clicks Car Insurance option")
	public void user_clicks_car_insurance_option() {
		utils.button(pol.getCarInsurance());
	}

	@Then("Validate user lands on Car Insurance section page")
	public void validate_user_lands_on_car_insurance_section_page() {
		String exp_Title="Car Insurance";
	    if(utils.returnTitle().contains(exp_Title))
	    	System.out.println("User lands on HomePage correctly");
	}

	@When("User giving car details")
	public void user_giving_car_details() {
		utils.sendText(pol.getCarDetails(), "TN-19-AQ-7654");
	}

	@When("User clicks the View Prices for car insurance")
	public void user_clicks_the_view_prices_car() {
		utils.button(pol.getCarPrice());
	}
	@When("User clicks the View Prices for Bike insurance")
	public void user_clicks_the_view_prices_bike() {
		utils.button(pol.getBikePrice());
	}
	@When("User clicks the View Prices for E-Bike insurance")
	public void user_clicks_the_view_prices_ebike() {
		utils.button(pol.getEbikePrice());
	}

	@When("User prints the how many total no. of insurance companies present in that web page")
	public void user_prints_the_how_many_total_no_of_insurance_companies_present_in_that_web_page() {
		utils.list = pol.getIns_Name();
	   System.out.println("No.of insurance companies in web page"+utils.list.size());
	}

	@When("User prints the Insurance company and price")
	public void user_prints_the_insurance_company_and_price() {
		utils.list = pol.getIns_Name();
		utils.price = pol.getPrice();
	    for(int i=0;i<utils.list.size();i++) {
	    	System.out.println("Company name: "+utils.returnText(utils.list.get(i))+"   price values is: "+utils.returnText(utils.price.get(i)));
	    }
	}

	@When("User clicks the Insurance options {string}")
	public void user_clicks_bike_insurance_option(String data) {
		utils.button(utils.driver.findElement(By.xpath("(//div[@class='prd-icon add shadowHandler short']/p)["+data+"]")));
	}

	@Then("Validate user lands on Bike Insurance section page")
	public void validate_user_lands_on_bike_insurance_section_page() {
		String exp_Title="Two Wheeler Insurance";
	    if(utils.returnTitle().contains(exp_Title))
	    	System.out.println("User lands on HomePage correctly");
	}

	@When("User giving Bike details")
	public void user_giving_bike_details() {
		utils.sendText( pol.getBikeDetails(), "TN-19-AQ-8506");
	}

	@When("User MouseHover to Insurance Products option")
	public void user_mouse_hover_to_insurance_products_option() {
		utils.mouseHover(pol.getInsuranceProducts());
	}

	@When("User clicks E-Bike Insurance option")
	public void user_clicks_e_bike_insurance_option() {
		utils.button(pol.geteBikeInsurance(), 0);
	}

	@Then("Validate user lands on E-Bike Insurance section page")
	public void validate_user_lands_on_e_bike_insurance_section_page() {
		String exp_Title="e-Bike Insurance";
	    if(utils.returnTitle().contains(exp_Title))
	    	System.out.println("User lands on HomePage correctly");
	}

	@When("User giving E-Bike details")
	public void user_giving_e_bike_details() {
		utils.sendText(pol.geteBikeDetails(), "KA04KE8603");
	}
}
