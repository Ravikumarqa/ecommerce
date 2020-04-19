package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.qa.utility.EcommerceUtils;

public class MobilesPage extends EcommerceUtils{
	
	public By sonyXperia_price_in_listpage = By.xpath("//span[@id='product-price-1']//span[1]");
	public By sonyXperia_mobile_img = By.xpath("//img[@id='product-collection-image-1']");
	public By sonyXperia_cart = By.xpath("//button[@title='Add to Cart'][1]");
	
	public void verify_Title_of_MObile_Page() {
		String Title_of_Mobile_page = driver.getTitle();
		Assert.assertEquals(Title_of_Mobile_page, "Mobile","title mismatch");
	}
	public void selectMobilesByName() {
		new Select(driver.findElement(By.xpath("//select[@title='Sort By']"))).selectByVisibleText("Name");
		System.out.println("sorted by name");
		
	}
	
	public void sortedornot() {
		List<WebElement> productName = driver.findElements(By.className("product-name"));
		System.out.println("no of products : "+productName.size());
		for(int i =0; i<productName.size();i++) {
			System.out.println(productName.get(i).getText());
			
		}
	}


}
