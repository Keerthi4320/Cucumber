package com.hooksclass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseclass.Utility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static Utility utils = Utility.getUtilityObject();

	@Before
	public void before(Scenario sce) {
		utils.browserLaunch();
	utils.ts = (TakesScreenshot) utils.driver;
	byte[] img = utils.ts.getScreenshotAs(OutputType.BYTES);
	sce.embed(img, "image/png");
	}
	@After
	public void after() {
		utils.driver.quit();
	}
}
