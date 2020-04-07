package com.guru99bank.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;




public class Loginpage {
	public WebDriver driver = null;

	public static Properties prop;
	public static FileInputStream  ip = null;
	
	
	public static void loadProperties() throws IOException {
		prop = new Properties();
		ip = new FileInputStream("C:\\Users\\hp\\git\\ecommerce\\src\\main\\java\\com\\guru99bank\\config\\login_details.properties");
	  prop.load(ip);
	}
	
	
	public void openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe");
    		driver=new FirefoxDriver();
        }
                else if (browserName.equalsIgnoreCase("chrome")) {
        	//System.setProperty("webdriver.chrome.driver", ".\\Lib\\chromedriver.exe");
        	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
            driver = new ChromeDriver();	
        }
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }
	
	public void openURL(String url) throws Exception {
		try {
			driver.get(url);
			
		} catch (RuntimeException e) {
			
		}
	
	
	}


	

	WebElement username = driver.findElement(By.name("uid"));

	WebElement password = driver.findElement(By.name("password"));
	
	WebElement loginbtn = driver.findElement(By.name("btnLogin"));
		
	public void enterusername(String user) {
		username.clear();
		username.sendKeys(user);
	} 
	public void enterpassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickonloginbtn() {
		loginbtn.click();
	}

}
