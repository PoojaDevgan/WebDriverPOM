package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseTest.BasePage;
import baseTest.TopNavigation;

public class LoginPage extends BasePage{
	
	@Test(priority=2)
	public LandingPage CompanySelect() 
	{
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[14]//a[1]//img[1]"))).click();
		
		topNav.isElementPresent("SSOimg_Xpath");
		
		topNav.click("SSOimg_Xpath");
		
		Set<String> winid = driver.getWindowHandles();
		Iterator<String> itr = winid.iterator();
		String first_WindowId = itr.next();
		System.out.println("First windowId: "+ first_WindowId);
		
		winid = driver.getWindowHandles();
		itr = winid.iterator();
		System.out.println("FirstWindow Id: "+itr.next());
		String second_WindowId = itr.next();
		driver.switchTo().window(second_WindowId);
		System.out.println("Second Window id: "+second_WindowId);
		
		driver.switchTo().window(second_WindowId);
		
		try {
			topNav.type("SSL2text_Xpath","CompanySelect");
			log.info("Company found Successfully");
		} catch (IOException e) {
			log.error("Sorry, company doesnt exist!!! ", e);
			e.printStackTrace();
		}
		
		topNav.click("Search_Xpath");
		
		topNav.click("CompanySelect_Xpath");
		
		topNav.click("Notification_Xpath");
		
		return new LandingPage();
	}
	
	/*
	public void NotificationTemplate(String TemplateName, String DarwinDisplayName, String FromEmailAddressOverride, String SubjectDisplayName, String Source) throws IOException
	{
		topNav.isElementPresent("SSOimg_Xpath");
		
		topNav.click("SSOimg_Xpath");
		
		Set<String> winid = driver.getWindowHandles();
		Iterator<String> itr = winid.iterator();
		String first_WindowId = itr.next();
		System.out.println("First windowId: "+ first_WindowId);
		
		winid = driver.getWindowHandles();
		itr = winid.iterator();
		System.out.println("FirstWindow Id: "+itr.next());
		String second_WindowId = itr.next();
		driver.switchTo().window(second_WindowId);
		System.out.println("Second Window id: "+second_WindowId);
		
		driver.switchTo().window(second_WindowId);
		
		try {
			topNav.type("SSL2text_Xpath","CompanySelect");
			log.info("Company found Successfully");
		} catch (IOException e) {
			log.error("Sorry, company doesnt exist!!! ", e);
			e.printStackTrace();
		}
		
		topNav.click("Search_Xpath");
		
		topNav.click("CompanySelect_Xpath");
		
		topNav.click("Notification_Xpath");
		
		topNav.click("AddEvent_Xpath");
		
		System.out.println("DarwinDisplayName: "+DarwinDisplayName);
		System.out.println("TemplateName: "+TemplateName);
		System.out.println("FromEmailAddressOverride: "+FromEmailAddressOverride);
		System.out.println("SubjectDisplayName: "+SubjectDisplayName);
		System.out.println("Source: "+Source);
		
		WebElement el = topNav.findElement("Event_Xpath");
		Select select = new Select(el);		
		select.selectByVisibleText(TemplateName);
		
		topNav.type("DarwinDisplayName_Xpath",SubjectDisplayName);
		
		topNav.type("FromEmailAddressOverride_Xpath",FromEmailAddressOverride);
		
		WebElement checkBox = topNav.findElement("EmployeeCheckbox_Xpath");
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
	
		
		topNav.findElement("EmailDisplayName_Xpath").clear();
		
		topNav.type("EmailDisplayName_Xpath","EmailDisplayName");
		
		topNav.click("sourceCode_Xpath");
		
		topNav.type("SourceTextArea_Xpath",Source);
		
		topNav.click("SourceOk_Xpath");
		
		topNav.click("Update_Xpath");
	}*/
	
	

}
