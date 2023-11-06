package com.basic.JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionHandler extends BaseDrive{
String url="https://www.daraz.com.bd/";
@Test
public void ActionTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url);
	
	Actions action=new Actions(driver);
	
	WebElement home=driver.findElement(By.xpath("//span[contains(text(),'Home & Lifestyle')]"));
	action.moveToElement(home).perform();
	Thread.sleep(3000);
	
	WebElement furniture=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div/div/ul/ul[10]/li[3]/a/span"));
	action.moveToElement(furniture).perform();
	Thread.sleep(3000);
	
	WebElement HomeOffice=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div/div/ul/ul[10]/li[3]/ul/ul/li[2]/a/img"));
	action.click();
	Thread.sleep(3000);
	
}
}
