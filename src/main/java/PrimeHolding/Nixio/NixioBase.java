package PrimeHolding.Nixio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NixioBase {
	
	public WebDriver driver;
	public Properties prop;
	String projectPath = System.getProperty("user.dir");

	public WebDriver initializeDriver() throws IOException {

	prop=new Properties();
	FileInputStream fis=new FileInputStream(projectPath + "\\src\\DataProperties");
	prop.load(fis);
	String browser=prop.getProperty("browser");
	
	if(browser.contains("chrome"))
	{
		String chromePath = projectPath + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromePath);
		ChromeOptions options = new ChromeOptions();
		if(browser.contains("headless"))
		{
			options.addArguments("headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	else if(browser.equals("firefox"))
	{
		//String firefoxPath = projectPath + "\\drivers\\.browser..";
		
	}
	else if(browser=="IE")
	{
		//String iePath = projectPath + "\\drivers\\
	}
	return driver;
	
	}

	public void getScreenshot (String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String saveFileTo = projectPath +"\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(saveFileTo));
	}
}
