package baseTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.LandingPage;

public class TopNavigation {
	
	public void click(String locator)
	{
		try
		{
		if(locator.endsWith("_Xpath"))
		{
			BasePage.driver.findElement(By.xpath(BasePage.or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_Id"))
		{
			BasePage.driver.findElement(By.id(BasePage.or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_CSS"))
		{
			BasePage.driver.findElement(By.cssSelector(BasePage.or.getProperty(locator))).click();
		}
		}
		catch(Throwable t)
		{
			System.out.println("Unable to find element: "+t.getMessage());
		}
	}

	public void type(String locator, String value) throws IOException
	{
		try
		{
		if(locator.endsWith("_Id"))
		{
		BasePage.driver.findElement(By.id(BasePage.or.getProperty(locator))).sendKeys(BasePage.or.getProperty(value));
		}else if(locator.endsWith("_Xpath"))
		{
		BasePage.driver.findElement(By.xpath(BasePage.or.getProperty(locator))).sendKeys(BasePage.or.getProperty(value));
		}
		else if(locator.endsWith("_CSS"))
		{
		BasePage.driver.findElement(By.cssSelector(BasePage.or.getProperty(locator))).sendKeys(BasePage.or.getProperty(value));
		}
		
		BasePage.log.info("Text has been Entered Sucessfully for "+locator);
		
		}catch(Throwable t)
		{
			BasePage.log.info("Error while locating element: "+locator+"\n Error Message is: "+t.getMessage());
		}
	}
	
	public Boolean isElementPresent(String locator)
	{
		try
		{
		if(locator.endsWith("_Id"))
		{
		BasePage.driver.findElement(By.id(BasePage.or.getProperty(locator)));
		}else if(locator.endsWith("_Xpath"))
		{
		BasePage.driver.findElement(By.xpath(BasePage.or.getProperty(locator)));
		}
		else if(locator.endsWith("_CSS"))
		{
		BasePage.driver.findElement(By.cssSelector(BasePage.or.getProperty(locator)));
		}
		
		BasePage.log.info("Text has been Entered Sucessfully for "+locator);
		return true;
		
		}catch(Throwable t)
		{
			BasePage.log.info("Error while locating element: "+locator+"\n Error Message is: "+t.getMessage());
		return false;
		}
		
	}
	
	
	public WebElement findElement(String locator)
	{
		
		try
		{
		if(locator.endsWith("_Xpath"))
		{
			BasePage.element = BasePage.driver.findElement(By.xpath(BasePage.or.getProperty(locator)));
			 
		}
		else if(locator.endsWith("_Id"))
		{
			BasePage.element = BasePage.driver.findElement(By.id(BasePage.or.getProperty(locator)));
			
		}
		else if(locator.endsWith("_CSS"))
		{
			BasePage.element = BasePage.driver.findElement(By.cssSelector(BasePage.or.getProperty(locator)));
		}
		}
		catch(Throwable t)
		{
			System.out.println("Unable to find element: "+t.getMessage());
		}
		return BasePage.element;
	}

	public void tearDown()
	{
		
		BasePage.driver.quit();
		BasePage.log.info("Execution Successful!!!");
		
	}
	
	public LandingPage returnCommonObjects()
	{
		return new LandingPage();
	}

}
