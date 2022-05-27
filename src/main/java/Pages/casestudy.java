package Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.Base;

public class casestudy extends Base {

    By newTask = By.xpath("//*[text()='New']");
    By phoneCall = By.xpath("//*[text()='Demo Pop - CONNOR']");
    By addTask = By.xpath("//*[@title='Add task']");
    By wrapup = By.xpath("//*[@title='Wrap up']");


    public void pegaCaseStudy() throws InterruptedException, IOException {
        exttest = report.createTest("Starting an interaction in Pega");
        wait(10, newTask);
        driver.findElement(newTask).click();
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Demo Screen Pops']")));
        actions.build().perform();
        driver.findElement(phoneCall).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Accept']")).click();
        //Thread.sleep(3000);
        exttest.log(Status.PASS, "Interaction Started Successfully");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='PegaGadget1Ifr']")));
        wait(30,addTask);
        driver.findElement(addTask).click();
        Thread.sleep(5000);
        wait(30,By.xpath("//*[@title='Select  Lost or stolen card  ']"));
        driver.findElement(By.xpath("//*[@title='Select  Lost or stolen card  ']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@title='Add tasks']")).click();
        driver.findElement(By.xpath("//*[text()='Product description']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Volkswagen Finance']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*text['Volkswagen Finance']")).click();
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@title='Acknowledge customer disclosure']//input/following-sibling::input")).click();
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        Thread.sleep(5000);
        Select s=new Select(driver.findElement(By.id("CPMCardDeliveryMethod")));
        s.selectByValue("Mail");
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        Thread.sleep(3000);
        String msg=driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/section/div/div/div[2]/div/span[1]/div/div[2]/div/fieldset/div[2]/" +
                "div/section/div/div/div/div/div[2]/div/span[2]/div/div/div/div/div/div[1]/div/span/div/div/div/div/div[2]")).getText();
        exttest.log(Status.PASS, msg);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Confirm']")).click();
        exttest.log(Status.PASS, "Completed File a Complaint Case Successfully");
        Thread.sleep(3000);
        driver.findElement(wrapup).click();
        Thread.sleep(3000);
        Select s2=new Select(driver.findElement(By.id("ReasonForInteraction")));
        s2.selectByVisibleText("Lost or stolen card");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Submit']")).click();
        exttest.log(Status.PASS, "Wrap up Successfully");
        //driver.quit();
        System.out.println("Automation Completed Successfully");
        Thread.sleep(3000);
    }
}