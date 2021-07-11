package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
// this keyword	actually represents all the variables and methods within that(LoginPage) specific class. In addition to connecting the drivers.
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	} 
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGNIN_FIELD;

	// interactive methods: Technique 1(individual methods)
	
	public void enterusername(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}

	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}

	public void clickSigninButton() {
		SIGNIN_FIELD.click();
	}


}
