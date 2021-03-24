package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DbManager;
import utilities.ExcelReader;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\NotificationContent.xlsx");
	public static Logger log = Logger.getLogger(BasePage.class.getSimpleName());
	public static WebDriverWait wait;
	public static WebElement element;
	public static Asserts asserts = new Asserts();
	public static TopNavigation topNav;
	
	
	public BasePage()
	{
		if(driver==null)
		{
			PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\or.properties");
			or.load(fis);
			log.info("Successfully Loaded OR property file");
		} catch (IOException e) {
			log.error("Unable to load or.properties", e);
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
			config.load(fis);
			log.info("Successfully Loaded config property file");
		} catch (IOException e) {
			log.error("Unable to load config.properties", e);
			e.printStackTrace();
		}
				
		if(config.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome driver successfully setup");
		}
		else if(config.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox driver successfully setup");
		}
		
		try {
			DbManager.setMysqlDbConnection();
			log.info("DB Connection Successfully done!!!");
		} catch (ClassNotFoundException e) {
			log.error("DB Connection Unsuccessful!!!",e);
			e.printStackTrace();
		} catch (SQLException e) {
			log.error("DB Connection Unsuccessful!!!",e);
			e.printStackTrace();
		}
		
		topNav = new TopNavigation();
		
		driver.get(config.getProperty("url"));
		log.info("URL Fetched");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		log.info("Implicit Wait");
		
		}

	}
	

	

}
