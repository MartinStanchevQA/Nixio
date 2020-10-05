package PrimeHolding.Nixio;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Nixio.PajeObject.LoginPageObjects;
import junit.framework.Assert;

public class LoginPageTests extends NixioBase {
	
	LoginPageObjects lp=null;
	
	@BeforeTest
	public void initializeDriverAngGoToLoginPage() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("LoginPage"));
		lp=new LoginPageObjects(driver);
	}
	
	@Test
	
	public void verifyPasswordIsRequiredMessage () {
		
		lp.enterPassword("a");
		lp.getPasswordTextBox().sendKeys(Keys.BACK_SPACE);
		Assert.assertEquals("This is a required field!",lp.getHelpMessage());
		lp.getPasswordTextBox().sendKeys(Keys.DELETE);
	}
	
	@Test
	
	public void unsuccessfulLoginWrongPassword() {
		
		lp.enterEmail("admin@xprmnt.xyz");
		lp.enterPassword("Password1");
		lp.clickOnLoginButton();
		lp.verifyIfTheLoginFormIsDisplayed();
	}
	
	@Test
	
	public void unsuccessfulLoginWrongEmail() {
		
		lp.enterEmail("admin123@xprmnt.xyz"); 
		lp.enterPassword("P@ssword1");
		lp.clickOnLoginButton();
		lp.verifyIfTheLoginFormIsDisplayed();
	}
	
	@Test
	
	public void verifyBadCredentialsMessage () throws InterruptedException {
		
		lp.enterEmail("stanchev.m@abv.bg");
		lp.enterPassword("P@ssword1");
		lp.clickOnLoginButton();
		Thread.sleep(1000);
		Assert.assertEquals("Bad Credentials Provided - Please, try again!",lp.getPopUpMessage());
		
	}
	
	@Test
	
	public void verifyPageTitle () {
		
		Assert.assertEquals("Nixio",lp.getPageTitle());
	}
	
	@Test
	
	public void verifyPageUrl () {
		
		Assert.assertEquals("http://xprmnt.xyz:3030/auth/login",lp.getPageUrl());
	}
	
	@Test
	
	public void verifyNotValidEmailMessage () {
		
		lp.enterEmail("12");
		Assert.assertEquals("This is not a valid email!",lp.getHelpMessage());
	}
	
	@Test
	
	public void verifyEmailIsRequiredMessage () {
		
		lp.enterEmail("a");
		lp.getEmailTextBox().sendKeys(Keys.BACK_SPACE);
		Assert.assertEquals("This is a required field!",lp.getHelpMessage());
	}
	
	@Test
	
	public void verifyLoginButtonIsDisabled () {
		
		Assert.assertFalse(lp.getLoginButton().isEnabled());
	}
	
	@Test
	
	public void verifyLoginButtonIsDisabledNoPassword () {
		
		lp.enterEmail("stanchev.m@abv.bg");
		Assert.assertFalse(lp.getLoginButton().isEnabled());
	}
	
	@Test
	
	public void verifyLoginButtonisDisabledNoEmail () {
		
		lp.enterPassword("123");
		Assert.assertFalse(lp.getLoginButton().isEnabled());
	}
	
	@Test
	
	public void successfulLogin() throws InterruptedException {
		
		lp.enterEmail("admin@xprmnt.xyz");
		lp.enterPassword("P@ssword1");
		lp.clickOnLoginButton();
		Thread.sleep(2000);
		Assert.assertEquals("Successful Login!",lp.getPopUpMessage());
		Assert.assertEquals("http://xprmnt.xyz:3030/main/users",lp.getPageUrl());
	}
	
	@AfterTest
	
	public void closeTheBrowser() {
		driver.close();
	}
	
	
}
