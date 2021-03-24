package utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseTest.BasePage;
import pages.LandingPage;
import pages.LoginPage;

public class DataProviderUtil extends BasePage {

	@DataProvider(name="dp",parallel=false)
	public static Object[][] getdata(Method m)
	{

		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\NotificationContent.xlsx");
		String sheetName = m.getName();
		System.out.println(sheetName);
		int rownum = excel.getRowCount(sheetName);
		int colnum = excel.getColumnCount(sheetName);
		
		Object[][] obj = new Object[rownum-1][colnum];
		
		for(int rows=2; rows<=rownum; rows++)
		{
			for(int cols=0; cols<colnum; cols++)
			{
				obj[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
	
		return obj;

	}
	/*
	@Test(dataProvider="dp")
	public void NotificationContent(String DarwinDisplayName, String TemplateName, String FromEmailAddressOverride, String SubjectDisplayName, String Source)
	{
	//LoginPage loginpage = new LoginPage();
	//LandingPage landingpage = loginpage.CompanySelect();
		
		System.out.println("DarwinDisplayName: "+DarwinDisplayName);
		System.out.println("TemplateName: "+TemplateName);
		System.out.println("FromEmailAddressOverride: "+FromEmailAddressOverride);
		System.out.println("SubjectDisplayName: "+SubjectDisplayName);
		System.out.println("Source: "+Source);
		
		LandingPage landingpage = new LandingPage();
		
	try {
		landingpage.NotificationTemplate(DarwinDisplayName, TemplateName, FromEmailAddressOverride, SubjectDisplayName, Source);		
		
		System.out.println("DarwinDisplayName: "+DarwinDisplayName);
		System.out.println("TemplateName: "+TemplateName);
		System.out.println("FromEmailAddressOverride: "+FromEmailAddressOverride);
		System.out.println("SubjectDisplayName: "+SubjectDisplayName);
		System.out.println("Source: "+Source);
		
		BasePage.log.info("Data Fetched successfully!!!");
		
	} catch (IOException e) {
		BasePage.log.error("Unable to fetch the data from Excel",e);
		e.printStackTrace();
	*/

	
}
