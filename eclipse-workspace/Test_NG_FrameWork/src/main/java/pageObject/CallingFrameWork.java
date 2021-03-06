package pageObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CallingFrameWork {
	public WebDriver driver;
	public WebDriver initializedriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\82009\\eclipse-workspace\\BuildingFrameWork\\src\\main\\java\\resources\\data.properties");

		prop.load(file);
		String browserName=	prop.getProperty("Browser");
		if(browserName.equals("chrome")) {

			System.setProperty("Webdriver.chome.driver", "E://Library/chromedriver.exe");
			driver=new ChromeDriver();
			}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "E://Library/geckodriver.exe");
			driver =new FirefoxDriver();
			}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "E:\\Library\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
