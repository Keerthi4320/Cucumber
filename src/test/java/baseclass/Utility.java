package baseclass;


import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import baseclass.IntUtility;
import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class Utility implements IntUtility{

	public static WebDriver driver;
	public static Actions act;
	public static List<String> exp_menu;
	public static List<WebElement> act_menu;
	public static JavascriptExecutor js;
	public static List<WebElement> list;
	public static List<WebElement> price;
	public static TakesScreenshot ts;
	public static Utility utils= null;
	
	private Utility() {}
	
	public static Utility getUtilityObject() {
		if(utils==null)
			return utils = new Utility();
		
		return utils;
	}
	public static Response getHttp(String endPoint, String header,String key, String value,int statusCode) {
		Response res = given().log().all().headers("Content-type",header).pathParams(key,value).
		when().get(endPoint).
		then().log().all().assertThat().statusCode(statusCode).extract().response();
		return res;
	}
	public List<Map<String,String>> sql(){
		List<Map<String,String>> li = new ArrayList<>();
	    Map<String,String> mp = new HashMap<>();
	    Connection conn = null;
		try {
			Class.forName("com.mysql.server");
			String connect = "localhost:9090/username:user/password:pass";
			try {
			    conn = DriverManager.getConnection(connect);
				System.out.println("Database Connected");
				Statement state = conn.createStatement();
				ResultSet resultSet = state.executeQuery("Select * from Customers");
				while(resultSet.next()) {
					String name = resultSet.getString("username");
					mp.put("username", name);
					String id = resultSet.getString(0);
					mp.put("userid", id);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		li.add(mp);
		return li;
	}
	
	public static void browserLaunch() {
		Properties prop = new Properties();
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("Chrome");
		caps.setVersion("121");
		caps.setCapability("platform", "Windows 11");
		
		System.out.println(caps.getBrowserName());
		System.out.println(caps.getBrowserVersion());
		System.out.println(caps.getCapability("platform"));
		
		String grturl = null;
		options.addArguments("--start-maximized");
//		options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.setAcceptInsecureCerts(true);
		try {
		FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\data.properties");
		prop.load(ip);
		grturl = prop.getProperty("grt");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(grturl);
		List<WebElement> link = driver.findElements(By.xpath("//link[@href]"));
		List<WebElement> img = driver.findElements(By.tagName("img"));
		Iterator<WebElement> it = link.iterator();
		while(it.hasNext()) {
			String links = it.next().getAttribute("href");
			if(links == null) {
				System.out.println("Link is Empty");
			}
			else {
				try {
					HttpsURLConnection urls = (HttpsURLConnection) (new URL(links).openConnection());
					urls.setRequestMethod("HEAD");
					urls.connect();
					int code = urls.getResponseCode();
					System.out.println(code);
					if(code==200 || code<=300)
						System.out.println("Link is not a broken link");
					else
						System.out.println("Link is a broken link");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		Iterator<WebElement> it1 = img.iterator();
		while(it1.hasNext()) {
			String image = it1.next().getAttribute("src");
			if(image == null) {
				System.out.println("Image is Empty");
			}
			else {
				try {
					HttpsURLConnection urls = (HttpsURLConnection) (new URL(image).openConnection());
					urls.setRequestMethod("HEAD");
					urls.connect();
					int code = urls.getResponseCode();
					System.out.println(code);
					if(code==200 || code<=300)
						System.out.println("Image is not broken image");
					else
						System.out.println("Image is broken image");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
}
	public static void applicationLaunch(String url) {
		driver.get(url);
//		List<WebElement> link = driver.findElements(By.tagName("link"));
//		List<WebElement> img = driver.findElements(By.tagName("img"));
//		Iterator<WebElement> it = link.iterator();
//		while(it.hasNext()) {
//			String links = it.next().getAttribute("href");
//			if(links == null) {
//				System.out.println("Link is Empty");
//			}
//			else {
//				try {
//					HttpsURLConnection urls = (HttpsURLConnection) (new URL(links).openConnection());
//					urls.setRequestMethod("HEAD");
//					urls.setConnectTimeout(6000);
//					urls.connect();
//					int code = urls.getResponseCode();
//					System.out.println(code);
//					if(code<=300)
//						System.out.println("Link is not a broken link");
//					else
//						System.out.println("Link is a broken link");
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		}
//		Iterator<WebElement> it1 = img.iterator();
//		while(it1.hasNext()) {
//			String image = it1.next().getAttribute("src");
//			if(image == null) {
//				System.out.println("Image is Empty");
//			}
//			else {
//				try {
//					HttpsURLConnection urls = (HttpsURLConnection) (new URL(image).openConnection());
//					urls.setRequestMethod("HEAD");
//					urls.connect();
//					int code = urls.getResponseCode();
//					System.out.println(code);
//					if(code==200)
//						System.out.println("Image is not broken image");
//					else
//						System.out.println("Image is broken image");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
	
	public void button(WebElement el) {
		el.click();
	}
	public void button(WebElement el, int i) {
		act.click(el).build().perform();
		
	}
	public void button(int j, WebElement el) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", el);
	}
	public void sendText(WebElement el, String input) {
		el.sendKeys(input);
		
	}
	public String returnTitle() {
		String title = driver.getTitle();
		return title;
	}
	public String returnText(WebElement el) {
		String text = el.getText();
		return text;
	}
	public void mouseHover(WebElement el) {
		act.moveToElement(el).build().perform();
	}
	public void dragAndDrop(WebElement el1, WebElement el2) {
		act.dragAndDrop(el1, el2);
		}
	public void rightClick(WebElement el) {
		act.contextClick(el);
	}
	public void doubleClick(WebElement el) {
		act.doubleClick(el);
	}
	public void alert_Accept(Alert a) {
		a = driver.switchTo().alert();
		a.accept();
	}
	public void alert_Dismiss(Alert a) {
		a = driver.switchTo().alert();
		a.dismiss();
	}
	public void alert_sendText(Alert a, String input) {
		a = driver.switchTo().alert();
		a.sendKeys(input);
	}
	public String alert_ReturnText(Alert a) {
		a = driver.switchTo().alert();
		String text = a.getText();	
		return text;
	}
	public void scrollUp(WebElement el) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", el);
	}
	public void scrollDown(WebElement el) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", el);
	}
	public void setAttribute(WebElement el, String name) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+name+")", el);
	}
	public String getAttribute(WebElement el, String name) {
		js=(JavascriptExecutor) driver;
		Object obj = js.executeScript("arguments[0].getAttribute('value')", el);
		String s = (String) obj;
		return s;
	}
	public String getAttri(WebElement el, String input) {
		String s = el.getAttribute(input);
		return s;
	}
	public void screenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./target/"+name+".jpg");
		try {
		FileUtils.copyFile(src, des);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void frame_Name(String name) {
		driver.switchTo().frame(name);
	}
	public void frame_Element(WebElement el) {
		driver.switchTo().frame(el);
		
	}
	public void frame_index(int index) {
		driver.switchTo().frame(index);
		
	}
	public void parentFrame() {
		driver.switchTo().parentFrame();
		
	}
	public void mainFrame() {
		driver.switchTo().defaultContent();
	}
	public boolean isdisplay(WebElement el) {
		return el.isDisplayed();
	}
}