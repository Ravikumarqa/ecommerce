package com.guru99bank.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99bank.pages.Loginpage;
import com.qa.utility.BankUtil;



public class Guru99_LoginTest extends BankUtil {

	Loginpage lpage = new Loginpage();

	@Test(priority = 1)
	public void loginTest() throws Exception {

		setUp();
		try {
			customizedTimeout(lpage.username);
			sendData(lpage.username, username);
			customizedTimeout(lpage.password);
			sendData(lpage.password, password);
			customizedTimeout(lpage.loginbtn);
			click(lpage.loginbtn);
			
		} catch (Exception e) {
			capture_Screenshot("login");
		}

	}
	@Test(priority = 2)
	public void verify_Homepage_Title() throws IOException {
		try {
			Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePag");
			
		}catch (Exception e) {
			capture_Screenshot("login");
			
		}
	}

}
