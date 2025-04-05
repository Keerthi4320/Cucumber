package baseclass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public interface IntUtility {
	public void button(WebElement el);
	public void button(WebElement el, int i);
	public void button(int j, WebElement el);
	public void sendText(WebElement el, String input);
	public String returnTitle(); 
	public String returnText(WebElement el);
	public void mouseHover(WebElement el);
	public void dragAndDrop(WebElement el1,WebElement el2);
	public void rightClick(WebElement el);
	public void doubleClick(WebElement el);
	public void alert_Accept(Alert a);
	public void alert_Dismiss(Alert a);
	public void alert_sendText(Alert a,  String input);
	public String alert_ReturnText(Alert a);
	public void scrollUp(WebElement el);
	public void scrollDown(WebElement el);
	public void setAttribute(WebElement el, String name);
	public String getAttribute(WebElement el, String name);
	public String getAttri(WebElement el, String name);
	public void screenshot(String name);
	public void frame_Name(String name);
	public void frame_Element(WebElement el);
	public void frame_index(int index);
	public void parentFrame();
	public void mainFrame();
	
	
	
}
