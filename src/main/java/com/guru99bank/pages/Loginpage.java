package com.guru99bank.pages;

import org.openqa.selenium.By;

import com.qa.utility.BankUtil;

public class Loginpage extends BankUtil {
	
	public By username = By.name("uid");

	public By password = By.name("password");

	public By loginbtn = By.name("btnLogin");

}