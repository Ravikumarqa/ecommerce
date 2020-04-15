package com.ecommerce.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.MobilesPage;
import com.ecommerce.pages.ShoppingCartPage;
import com.ecommerce.pages.SonyXperiaMobilePage;
import com.qa.utility.EcommerceUtils;



public class MobilePageTest extends EcommerceUtils{
	
	MobilesPage mobilepage = new MobilesPage();
	HomePage homepage = new HomePage();
	SonyXperiaMobilePage smpage = new SonyXperiaMobilePage();
	ShoppingCartPage shoppingcart = new ShoppingCartPage();
	
	@Test(priority = 1, enabled =false)
	public void verify_items_inmobiles_byName() throws InterruptedException {
		EcommerceUtils.openUrl();
		homepage.verifyTitleofHomePage();
		homepage.clickonMobile();
		mobilepage.verify_Title_of_MObile_Page();
		mobilepage.selectMobilesByName();
		mobilepage.sortedornot();
		teardown();

		
	}
	@Test(priority = 2,enabled = false)
	public void verify_costofproduct_inmobilepage_andDetailspage_Test() throws InterruptedException{
		
		EcommerceUtils.openUrl();
		homepage.clickonMobile();
		custumize_time_out(mobilepage.sonyXperia_price_in_listpage);
		
		String sonyXperia_price_in_listpage = getText(mobilepage.sonyXperia_price_in_listpage);
		System.out.println("sonyXperia_price_in_listpage : "+sonyXperia_price_in_listpage);
		custumize_time_out(mobilepage.sonyXperia_mobile_img);
		click(mobilepage.sonyXperia_mobile_img);
		String sonyXperia_price_indetailsPage = getText(smpage.sonyXperia_price_indetailsPage);
		System.out.println("sonyXperia_price_indetailsPage : " +sonyXperia_price_indetailsPage);
		if(sonyXperia_price_in_listpage.equals(sonyXperia_price_indetailsPage)) {
			System.out.println("Both prices are equal");
			
		}
		else {
			System.out.println("Both prices are not equal");
		}
		
		teardown();
		
	}
	
	@Test(priority =3)
	public void cannotaddmoreproduct_incart_than_productavailableinstore() throws InterruptedException {
		openUrl();
		homepage.clickonMobile();
		click(mobilepage.sonyXperia_cart);
		enterText(shoppingcart.sonyXperia_qty, "1000");
		click(shoppingcart.update_quality_btn);
		String actual_error_msg = getText(shoppingcart.error_msg);
		try {
			if(actual_error_msg.equalsIgnoreCase("The requested quantity for \"Sony Xperia\" is not available.")) {
				System.out.println("error mgs matched");
			}
		}catch (Exception e) {
			System.out.println("error msg not equal");
		}
		click(shoppingcart.empty_cart_link);
		String actual_empty_cart_msg = getText(shoppingcart.cart_msg);
		System.out.println("actual_empty_cart_msg :"+actual_empty_cart_msg);
		try {
			Assert.assertEquals(actual_empty_cart_msg, "SHOPPING CART IS EMPTY","shopping cart is not empty");
		}
		catch (Exception e) {
			System.out.println("shopping cart not empty");
			// TODO: handle exception
		}
		
		teardown();
		
		
	}


	

}
