package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseTest.BasePage;
import utilities.DataProviderUtil;

public class LandingPage extends BasePage{
	
	//@Test(dataProviderClass=DataProviderUtil.class,dataProvider="dp",priority=3)
	public void NotificationTemplate(String TemplateName, String DarwinDisplayName, String FromEmailAddressOverride, String SubjectDisplayName, String Source) throws IOException
	{
		
		/*System.out.println("DarwinDisplayName: "+DarwinDisplayName);
		System.out.println("TemplateName: "+TemplateName);
		System.out.println("FromEmailAddressOverride: "+FromEmailAddressOverride);
		System.out.println("SubjectDisplayName: "+SubjectDisplayName);
		System.out.println("Source: "+Source);*/
		
		topNav.click("AddEvent_Xpath");
		
		WebElement el = topNav.findElement("Event_Xpath");
		Select select = new Select(el);		
		select.selectByVisibleText(TemplateName);
		System.out.println("TemplateName Selected");
		
		try
		{
		WebElement displayTxt = topNav.findElement("DarwinDisplayName_Xpath");
		wait.until(ExpectedConditions.textToBePresentInElementValue(displayTxt, "Welcome to your benefits portal"));
		}
		catch(Throwable t)
		{
			log.info("Unable to find the display Name!!");
		}
		
		try
		{
		WebElement el2 = topNav.findElement("Event_Xpath");
		Select select1 = new Select(el2);
		select1.wait();
		select1.selectByVisibleText("Personal details updates – New joiner username");

		}
		catch(Throwable t)
		{
			log.info("Unable to find the New Joiner Name!!");
		}
		
		
		//BasePage.driver.navigate().refresh();
		topNav.findElement("DarwinDisplayName_Xpath").clear();
		
		topNav.type("DarwinDisplayName_Xpath",SubjectDisplayName);
		System.out.println("Display Name ENtered!!");
		
		topNav.type("FromEmailAddressOverride_Xpath",FromEmailAddressOverride);
		
		WebElement checkBox = topNav.findElement("EmployeeCheckbox_Xpath");
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
	
		
		topNav.findElement("EmailDisplayName_Xpath").clear();
		
		topNav.type("EmailDisplayName_Xpath","EmailDisplayName");
		
		topNav.click("sourceCode_Xpath");
		
		topNav.type("SourceTextArea_Xpath",Source);
		
		topNav.click("SourceOk_Xpath");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		topNav.click("Update_Xpath");
		
		//return this;
		
		
		/*
		try
		{
		WebElement displayTxt = topNav.findElement("DarwinDisplayName_Xpath");
		wait.until(ExpectedConditions.textToBePresentInElementValue(displayTxt, "Welcome to your benefits portal"));
		}
		catch(Throwable t)
		{
			log.info("Unable to find the display Name!!");
		}
			
		try
		{
		WebElement el2 = topNav.findElement("Event_Xpath");
		Select select1 = new Select(el2);
		select1.wait();
		select1.selectByVisibleText("Personal details updates – New joiner username");

		}
		catch(Throwable t)
		{
			log.info("Unable to find the New Joiner Name!!");
		}*/
		
		
		//topNav.findElement("DarwinDisplayName_Xpath").clear();
	}

}
