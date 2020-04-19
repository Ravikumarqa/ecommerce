package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BankUtil {

	public static WebDriver driver = null;

	public static final String baseurl = "http://www.demo.guru99.com/V4/";
	public static final String username = "mngr253786";
	public static final String password = "vadyqeq";
	public static final String firefox_path = "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe";

	public static void setUp() {

		System.setProperty("webdriver.gecko.driver",firefox_path);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(baseurl);
	}

	public static void capture_Screenshot(String fileName) throws IOException {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,
				new File("C:\\Users\\hp\\git\\ecommerce\\screenshot" + fileName + System.currentTimeMillis() + ".png"));
	}

	public static void customizedTimeout(By loc) throws InterruptedException {

		boolean flag = false;
		for (int i = 0; i < 30; i++) {
			try {
				driver.findElement(loc);
				System.out.println("found locator : "+loc);
				flag = true;
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
			}

		}
		if(flag == false) {
			System.out.println("could not found locator : "+loc);
		}

	}
	public static void click(By loc) {
		try {
		driver.findElement(loc).click();
		System.out.println("clicked on locator : "+loc);
		
		}catch (Exception e) {
			
			System.out.println(" cloud not clicked on locator : " +loc);
		}
	}
	public void sendData(By loc ,String data) {
		
		WebElement ele = driver.findElement(loc);
		ele.clear();
		ele.sendKeys(data);
		System.out.println("data entered into : "+loc + " data is : "+data);
		
	}
	@AfterClass
	public void browserClosed() {
		driver.quit();
	}

}
