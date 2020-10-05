package pajeFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PrimeHolding.Nixio.NixioBase;

public class LoginPage extends NixioBase{
	
	@FindBy(id="email")
	WebElement txt_email;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[type='submit']")
	WebElement btn_login;
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver) throws Throwable {
		driver=initializeDriver();
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmail (String email) {
		txt_email.sendKeys(email);
	}
	
	public void enterPassword (String password) {
		txt_password.sendKeys(password);
	}
	
	public void clinkOnLoginButton () {
		btn_login.click();
	}

}
