package com.ecommerce.pages;
import org.openqa.selenium.By;

import com.qa.utility.EcommerceUtils;

public class HomePage extends EcommerceUtils {
	
	
	public void verifyTitleofHomePage() {
		String title_Home_page = driver.getPageSource();
		if(title_Home_page.contains("This is demo site")) {
			System.out.println("it contains : This is demo site");
		}else {
			System.out.println("not contain : This is demo site");
		}
	}
	
	public void clickonMobile() throws InterruptedException {
	By mobileLink = By.xpath("//*[@id=\"nav\"]/ol/li[1]/a");
		custumize_time_out(mobileLink);
		click(mobileLink);
	}
		
	

}
