package com.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;




public class BaseClass{
public  WebDriver driver = null;
	
	public Properties prop;
	public FileInputStream  ip = null;
	
	@BeforeClass

	public void loadProperties() throws IOException {
		prop = new Properties();
		ip = new FileInputStream("C:\\Users\\hp\\git\\ecommerce\\src\\main\\java\\com\\guru99bank\\config\\login_details.properties");
	  prop.load(ip);
	}
	
	
	public void openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\git\\ecommerce\\lib\\geckodriver.exe");
    		driver=new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("ie")) {
        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");
        	
            driver = new InternetExplorerDriver();

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
	}

