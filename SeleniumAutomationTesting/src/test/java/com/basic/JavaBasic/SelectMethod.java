package com.basic.JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectMethod extends BaseDrive{
	String url="https://www.amazon.com/";
	@Test
	public void ActionTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement menu=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(menu);
		select.selectByIndex(5); //5 no index er value select
		Thread.sleep(3000);
		
		select.selectByVisibleText("Baby");
		Thread.sleep(3000);
		
	}
}
