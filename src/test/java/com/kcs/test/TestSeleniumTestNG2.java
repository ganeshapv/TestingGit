package com.kcs.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSeleniumTestNG2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws Exception
	{
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
	}
	
	@Test
	public void launchUrl() throws Exception
	{
		driver.get("http://google.com");
	}
	
	@Test(dependsOnMethods= {"launchUrl"})
	public void searchGoogle() throws Exception
	{
		driver.findElement(By.id("APjFqb")).sendKeys("Automation Testing");
		//sleep for some time for viewing the changes
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() throws Exception
	{
		//close browser
		driver.close();
		
		driver.quit();
	}
}
