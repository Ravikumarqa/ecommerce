package com.guru99bank.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	
	public WebDriver driver = null;
	
	@Test
	public void test() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.demo.guru99.com/V4/");
	
	WebElement username = driver.findElement(By.name("uid"));

	WebElement password = driver.findElement(By.name("password"));
	
	WebElement loginbtn = driver.findElement(By.name("btnLogin"));
		
	
		username.clear();
		username.sendKeys("mngr253786");
	
	
		password.clear();
		password.sendKeys("vadyqeq");
	

		loginbtn.click();
		
		driver.quit();
	


	}
}
