package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import baseTest.BasePage;
import pages.LandingPage;
import pages.LoginPage;
import utilities.DataProviderUtil;

public class createNotificationTest {

	@Test(dataProviderClass=DataProviderUtil.class,dataProvider="dp",priority=2)
	//@Test
	public void NotificationContent(String TemplateName, String DarwinDisplayName, String FromEmailAddressOverride, String SubjectDisplayName, String Source)
	{
		/*
		System.out.println("DarwinDisplayName: "+DarwinDisplayName);
		System.out.println("TemplateName: "+TemplateName);
		System.out.println("FromEmailAddressOverride: "+FromEmailAddressOverride);
		System.out.println("SubjectDisplayName: "+SubjectDisplayName);
		System.out.println("Source: "+Source);*/
		
	LoginPage loginpage = new LoginPage();
	LandingPage landingpage = loginpage.CompanySelect();
		
	//loginpage.NotificationTemplate(TemplateName, DarwinDisplayName, FromEmailAddressOverride, SubjectDisplayName, Source);
	try{
		landingpage.NotificationTemplate(TemplateName, DarwinDisplayName, FromEmailAddressOverride, SubjectDisplayName, Source);		
		BasePage.log.info("Data Fetched successfully!!!");
		} 
	catch (IOException e) {
		BasePage.log.error("Unable to fetch the data from Excel",e);
		e.printStackTrace();
	}

	}
}
