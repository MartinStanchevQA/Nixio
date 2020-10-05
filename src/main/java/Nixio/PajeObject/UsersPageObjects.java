package Nixio.PajeObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PrimeHolding.Nixio.NixioBase;

public class UsersPageObjects extends NixioBase {
	
	public WebDriver driver = null;
	
	By button_AddNewUser = By.id("addBtn");
	
	By text_AddNewUser_Email = By.id("email");
	
	By text_AddNewUser_Password = By.id("password");
	
	By button_AddNewUser_Add = By.cssSelector("button[type='submit']");
	
	By msg_AddNewUser_help = By.cssSelector("div[class*='helpMotion']");
	
	By emails = By.xpath("//td[@class='ant-table-cell'][2]");
	
	public UsersPageObjects(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void clickOnAddNewUserButton () {
		
		driver.findElement(button_AddNewUser).click();
	}
	
	public WebElement getAddNewUserButton () {
		
		return driver.findElement(button_AddNewUser);
	}
	
	public void enterEmailInAddNewUserForm (String email) {
		
		driver.findElement(text_AddNewUser_Email).sendKeys(email);
	}
	
	public void enterPasswordInAddNewUserForm (String password) {
		
		driver.findElement(text_AddNewUser_Password).sendKeys(password);
	}
	
	public void clickOnAddButtonInAddNewUserForm () {
		
		driver.findElement(button_AddNewUser_Add).click();
	}
	
	public List<WebElement> getAllEmails () {
		
		return driver.findElements(emails);
	}
	
	
}
