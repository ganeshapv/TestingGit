package com.kcs.test;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumnTest {
	
	public static void main(String[] args) {
		try {
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
			
			driver.get("http://google.com");
			
			driver.findElement(By.id("APjFqb")).sendKeys("Automation Testing");
			
			Thread.sleep(2000);
			
			driver.close();
			driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
