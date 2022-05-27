package Pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;

import Base.Base;


public class LaunchInstance extends Base{

	By search = By.xpath("//*[@id='edit-q']");
	By searchBtn = By.xpath("//*[@id='pega-search-core-search-form']/div/div/bolt-input-icons/ul/li[2]/button");
	By challenge = By.xpath("//*[@id='block-pegaacademy-theme-content']/bolt-band[2]/div/div/bolt-wrapper/div/div/div[3]/div[2]/bolt-list/bolt-list-item[1]/bolt-card-replacement");
	//By pegaInstance = By.xpath("//*[@id='esm-machine']/div/div/bolt-card-replacement/article/bolt-card-replacement-body/div/div/div/bolt-stack/bolt-button-group/ul/li[2]/bolt-button/a/span");
	By launchInstance = By.xpath("//*[text()='Launch Pega instance for this Challenge']");
	By pegaCRMSuite = By.xpath("//*[@id='sub']/span");
	By enterUsername = By.xpath("//*[@id='txtUserID']");
	By enterPassword = By.xpath("//*[@id='txtPassword']");
	By submitPEGA = By.xpath("//*[@id='sub']");
	
	public void launchInstance() throws InterruptedException, IOException {
		exttest = report.createTest("Launching and Starting the CRM Suite Instance");
		wait(30, search);
		driver.findElement(search).sendKeys(prop.getProperty("searchEntry"));
		driver.findElement(searchBtn).click();
		wait(30, challenge);
		driver.findElement(challenge).click();
		wait(30,launchInstance);
		driver.findElement(launchInstance).click();
		Thread.sleep(3000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		Thread.sleep(5000);
		wait(30,pegaCRMSuite);
		driver.findElement(pegaCRMSuite).click();
		Thread.sleep(3000);
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTab1.get(2));
		driver.navigate().refresh();
		driver.findElement(enterUsername).sendKeys(prop.getProperty("crmUsername"));
		driver.findElement(enterPassword).sendKeys(prop.getProperty("crmPassword"));
		Thread.sleep(2000);
		driver.findElement(submitPEGA).click();
		Thread.sleep(5000);
		exttest.log(Status.PASS, "Pega CRM Suite Instance launched Successfully");
		Thread.sleep(5000);
	}
}
