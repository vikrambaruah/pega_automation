package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Base.Base;


public class Login extends Base{
		By accountIcon = By.xpath("//*[@id='js-bolt-page-header-primary-nav']/div/ul[3]/li[1]/button/span[2]");
		By loginInLink = By.xpath("//a[text()='Log in']");
		By companyEmail = By.xpath("//*[@id='idp-discovery-username']");
		By submitEmail = By.xpath("//*[@id='idp-discovery-submit']");
		By password = By.xpath("//*[@id='okta-signin-password']");
		By submitPassword = By.xpath("//*[@id='okta-signin-submit']");
		
		public void login() throws InterruptedException, IOException {
			exttest = report.createTest("The user was able to login in: ");
			Thread.sleep(1000);
			WebElement ele = driver.findElement(accountIcon);
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			driver.findElement(loginInLink).click();
			wait(10, companyEmail);
			driver.findElement(companyEmail).click();
			driver.findElement(companyEmail).sendKeys(prop.getProperty("loginUserName"));
			driver.findElement(submitEmail).click();
			exttest.log(Status.PASS, "Company Email entered Successfully");
			wait(10, password);
			driver.findElement(password).click();
			driver.findElement(password).sendKeys(prop.getProperty("password"));
			driver.findElement(submitPassword).click();
			exttest.log(Status.PASS, "Password entered Successfully");
			
			exttest.log(Status.PASS, "Login Task Successfully");
			Thread.sleep(1000);
		}
}
