package TestSuite;

import java.io.IOException;

import Pages.casestudy;
import org.testng.annotations.Test;

import Pages.LaunchInstance;
import Pages.Login;


public class AllTest {
	
	@Test
	public void testing() throws InterruptedException, IOException
	{
		Login lg= new Login();
		LaunchInstance li= new LaunchInstance();
		casestudy pg= new casestudy();
		li.driverSetup();
	    li.openUrl();
		lg.login();
		li.launchInstance();
		pg.pegaCaseStudy();
		li.closeBrowser();
	}

}
