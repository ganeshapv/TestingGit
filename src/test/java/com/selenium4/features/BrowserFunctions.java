package com.selenium4.features;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFunctions {

	public static void main(String[] args) {
		
		
		try {
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
			
			driver.get("http://google.com");
			
			driver.findElement(By.id("APjFqb")).sendKeys("Automation Testing");
			
			
			
			driver.navigate().to("https://selenium.dev/");
			
			String url 		= driver.getCurrentUrl();
			String title 	= driver.getTitle();
			
			System.out.println("Current Url:"+url); //Current Url:https://www.selenium.dev/
			System.out.println("title:"+title); //title:Selenium
			
			//driver.navigate().back();
			//driver.navigate().refresh();
			//driver.navigate().forward();
			
			String orignalWindow = driver.getWindowHandle();
			System.out.println("Window Handle:"+orignalWindow);  //Window Handle:88E5395F0759F7672900D757B46BD132
			
			/*
			************************ TABS && WINDOW ***************************
			*
			driver.switchTo().newWindow(WindowType.TAB);
			ArrayList<String> openedwindows = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(openedwindows.get(1));
			Thread.sleep(2000);
			driver.get("//https://www.selenium.dev/selenium/docs/api/java/index.html");
			Thread.sleep(2000);
			
			driver.switchTo().window(orignalWindow);
			System.out.println("Switch to new tab completed");
			
			Set<String> openedwindows1 = driver.getWindowHandles();
			//Window Handles:[EC4712776D3FD4E5C620822F7CE8D09E, 2080655FB68A77B376D121BD99113ED1]
			//Two tabs opened at this point of time.
			System.out.println("Window Handles:"+openedwindows1.toString());
			
			Thread.sleep(5000);
			
			driver.switchTo().newWindow(WindowType.WINDOW);
			System.out.println("Switch to new window completed");
			
			//driver.close();
			//System.out.println("Switch to new window completed");
			
			 * 
			 */
			
			
			/******************* Frames **********************************************************
			
			//Frames
			driver.navigate().to("//https://www.selenium.dev/selenium/docs/api/java/index.html");
			driver.switchTo().frame("classFrame");
			
			//driver.switchTo().frame(1);
			
			/***
			
			Write the statements to work on iFrame
			driver.findElement(By.link("Alert").click();
			
			driver.switchTo().defaultContent(); // It will point to main window
			
			 **/
			
			
			
			//******************* ScreenShots **********************************************************
			
			driver.navigate().to("http://google.com");
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File("./screenshot.png"));//Stores in project folder
			
			System.out.println("Page screenshot completed");
			
			WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
			File scrFile1 = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("./screenshot1.png"));//Stores in project folder
			
			System.out.println("Element screenshot completed");
			
			
			
			
			//******************* Java Script **********************************************************
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			
			WebElement textfiled = driver.findElement(By.id("APjFqb"));
			js.executeScript("arguments[0].value = arguments[1] ", textfiled, "Automation");
			
			js.executeScript("document.getElementById('APjFqb').value= arguments[0] ", "Automation By Javascript");
			
			WebElement button = driver.findElement(By.name("btnI"));
			js.executeScript("arguments[0].click()", button);
			
			
			
			//String text = (String) js.executeScript("return document.getElementById('firstName').value");
			
			String sText =  js.executeScript("return document.title;").toString();
			
			 js.executeScript("window.scrollBy(0,150)");
			
			//*******************************************************************************************************			
			
			
			
			//https://www.selenium.dev/selenium/docs/api/java/index.html
			
			Thread.sleep(2000);
			
			driver.close();
			
			driver.quit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
