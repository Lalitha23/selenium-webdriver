package com.jabong.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Basic {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lalit\\AppData\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.macys.com");
		searchItem();
	}
	public void searchItem(){
		
		driver.findElement(By.id("globalSearchInputField")).sendKeys("shoes");
		driver.findElement(By.id("subnavSearchSubmit")).click();
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 500)");
		driver.findElement(By.partialLinkText("Basketball")).click();
	}

	public static void main(String[] args) {
		
		Basic myObj = new Basic();
		myObj.invokeBrowser();

	}

}
