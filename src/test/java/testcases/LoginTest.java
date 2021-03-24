package testcases;

import java.io.IOException;

import org.apache.log4j.chainsaw.Main;
import org.testng.annotations.Test;

import baseTest.BasePage;
import pages.LandingPage;
import pages.LoginPage;
import utilities.DataProviderUtil;

public class LoginTest {
	
	@Test(dataProviderClass=DataProviderUtil.class,dataProvider="dp",priority=1)
	//@Test(priority=1)
	public void NotificationContent(String TemplateName, String DarwinDisplayName, String FromEmailAddressOverride, String SubjectDisplayName, String Source) throws IOException
	{
		
		LoginPage loginpage = new LoginPage();
		LandingPage landingpage = loginpage.CompanySelect();
		
		landingpage.NotificationTemplate(TemplateName, DarwinDisplayName, FromEmailAddressOverride, SubjectDisplayName, Source);
		
		
		//new LoginPage().CompanySelect().NotificationTemplate(DarwinDisplayName, TemplateName, FromEmailAddressOverride, SubjectDisplayName, Source);
		
	}

}
