package Nixio.PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PrimeHolding.Nixio.NixioBase;

public class LoginPageObjects extends NixioBase {
	
	public WebDriver driver = null;
	
	private By textbox_email = By.id("email");
	
	private By textbox_password = By.id("password");
	
	private By button_login = By.xpath("//button[@type='submit']");
	
	private By msg_popup = By.xpath("//div[@class='ant-message']");
	
	private By msg_help = By.cssSelector("div[class*='helpMotion']");
	
	
	
	public LoginPageObjects (WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void verifyIfTheLoginFormIsDisplayed () {
		
		driver.findElement(textbox_email).isDisplayed();
		driver.findElement(textbox_password).isDisplayed();
		driver.findElement(button_login).isDisplayed();
	}
	
	public WebElement getEmailTextBox () {
		
		return driver.findElement(textbox_email);
	}
	
	public WebElement getPasswordTextBox () {
		
		return driver.findElement(textbox_password);
	}
	
	public WebElement getLoginButton () {
		
		return driver.findElement(button_login);
	}
	
	public void enterEmail (String email) {
		
		driver.findElement(textbox_email).sendKeys(email);
	}
	
	public void enterPassword (String password) {
		
		driver.findElement(textbox_password).sendKeys(password);
	}
	
	public void clickOnLoginButton () {
		
		driver.findElement(button_login).click();
	}
	
	public String getPopUpMessage () {
		
		return driver.findElement(msg_popup).getText();
	}
		
	public String getPageTitle () {
		
		return driver.getTitle();
	}
	
	public String getPageUrl () {
		
		return driver.getCurrentUrl();
	}
	
	public String getHelpMessage () {
		
		return driver.findElement(msg_help).getText();
	}
}
