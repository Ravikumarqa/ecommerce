package com.qa.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.BeforeMethod;

public class EcommerceUtils {

	public static WebDriver driver = null;
    public static final String ecommerce_url = "http://live.demoguru99.com/index.php/";
    public static final String firefox_path = "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe";
	
	@BeforeMethod
	public void setup(){
		
		System.setProperty("webdriver.gecko.driver", firefox_path);
	driver=new FirefoxDriver();
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	}
	
	public static void openUrl() {
		driver.get(ecommerce_url);
		System.out.println("url is opend : "+ecommerce_url);
		
	}
	
	public void custumize_time_out(By loc) throws InterruptedException {
		
			for(int i =0; i<30;i++) {
				try {
				driver.findElement(loc);
				System.out.println("locator fond : "+loc);
				break;
			}
		
		catch (Exception e) {
			 Thread.sleep(1000);
			
		}
			}
		
	}
	
	public void click(By loc) {
		try {
		driver.findElement(loc).click();;
		System.out.println("clicked : " +loc);
		}catch (Exception e) {
			System.out.println("Not clicked : " +loc);
		}
	}
	
	public String getText(By loc) {
		String text ="";
		try {
		text = driver.findElement(loc).getText();
		System.out.println("Text found "+loc);
		}catch (Exception e) {
			System.out.println("Not Text found "+loc);
		}
		return text;
		
	}
	
	public void enterText(By loc,String data) {
		driver.findElement(loc).clear();
		driver.findElement(loc).sendKeys(data);
		
	}
	public void teardown() {
		driver.quit();
		System.out.println("Browser is closed");
	}
	

}
