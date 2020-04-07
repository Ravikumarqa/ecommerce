package com.ecommerce.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage {
	public WebDriver driver = null;
	
	@BeforeClass
	public void setup(){
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://live.demoguru99.com/index.php/");
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
		driver.findElement(loc).click();;
		System.out.println("clicked : " +loc);
	}
	
	@Test(priority = 1)
	public void verifyTitleofHomePage() {
		String title_Home_page = driver.getPageSource();
		if(title_Home_page.contains("This is demo site")) {
			System.out.println("it contains : This is demo site");
		}else {
			System.out.println("not contain : This is demo site");
		}
	}
	@Test(priority = 2)
	public void clickonMobile() throws InterruptedException {
	By mobileLink = By.xpath("//*[@id=\"nav\"]/ol/li[1]/a");
		custumize_time_out(mobileLink);
		click(mobileLink);
	}
	@Test(priority = 3)
	public void verify_Title_of_MObile_Page() {
		String Title_of_Mobile_page = driver.getTitle();
		Assert.assertEquals(Title_of_Mobile_page, "Mobile","title mismatch");
		
	}
	@Test(priority = 4)
	public void selectMobilesByName() {
		new Select(driver.findElement(By.xpath("//select[@title='Sort By']"))).selectByVisibleText("Name");
		System.out.println("sorted by name");
		
	}
	@Test(priority = 5)
	public void sortedornot() {
		List<WebElement> productName = driver.findElements(By.className("product-name"));
		System.out.println("no of products : "+productName.size());
		for(int i =0; i<productName.size();i++) {
			System.out.println(productName.get(i).getText());
			
		}
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
