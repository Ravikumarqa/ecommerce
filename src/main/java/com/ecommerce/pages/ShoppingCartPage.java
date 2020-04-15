package com.ecommerce.pages;

import org.openqa.selenium.By;

public class ShoppingCartPage {
	public By sonyXperia_qty = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input");
	public By update_quality_btn = By.xpath("//button[@name='update_cart_action' and @class='button btn-update']");
	public By error_msg = By.xpath("//p[@class='item-msg error']");
	public By empty_cart_link = By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tfoot/tr/td/button[2]/span/span");
	public By cart_msg = By.xpath("//div[@class='page-title']");
}
