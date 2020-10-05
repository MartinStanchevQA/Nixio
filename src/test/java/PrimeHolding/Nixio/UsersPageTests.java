package PrimeHolding.Nixio;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Nixio.PajeObject.LoginPageObjects;
import Nixio.PajeObject.UsersPageObjects;
import junit.framework.Assert;

public class UsersPageTests extends NixioBase {
	
	UsersPageObjects up = null;
	LoginPageObjects lp = null;
	
	@BeforeMethod
	public void initializeDriverAndGoToUsersPage() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("LoginPage"));
		up = new UsersPageObjects (driver);
		lp = new LoginPageObjects (driver);
		lp.enterEmail("admin@xprmnt.xyz");
		lp.enterPassword("P@ssword1");
		lp.clickOnLoginButton();
		Thread.sleep(4000);
	}
	
	/*@Test
	
	public void verifyTheTextOfAddNewUserButton () {
		
		String actualText = up.getAddNewUserButton().getText();
		Assert.assertEquals("Add New User",actualText);		
	}*/
	
	@Test
	
	public void addNewUser() throws InterruptedException {
		
		up.clickOnAddNewUserButton();
		up.enterEmailInAddNewUserForm("mstanchev1992@gmail.com");
		up.enterPasswordInAddNewUserForm("Martin123!");
		up.clickOnAddButtonInAddNewUserForm();
	}

	/*@Test
	
	public void verifyTheNewUserIsAdded () {
		
	User testUserEmail = up.getAllEmails().stream().filter(Email -> "mstanchev@gmail.com".equals(Email.getText())).findAny().orElse(Null);

	} */
}