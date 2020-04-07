package com.guru99bank.tests;



import org.testng.annotations.Test;

import com.guru99bank.pages.Loginpage;


public class Guru99_LoginTest{
	
	Loginpage lpage = new Loginpage();

	@Test
	public void loginTest() throws Exception {
		Loginpage.loadProperties();
		lpage.openBrowser(Loginpage.prop.getProperty("browser"));
		lpage.openURL(Loginpage.prop.getProperty("url"));
		lpage.enterusername(Loginpage.prop.getProperty("username"));
		lpage.enterpassword(Loginpage.prop.getProperty("password"));
		lpage.clickonloginbtn();
		
		
	}

}
