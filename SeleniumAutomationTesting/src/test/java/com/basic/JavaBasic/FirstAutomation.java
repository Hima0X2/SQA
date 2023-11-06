package com.basic.JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstAutomation extends BaseDrive{
	@Test
public void firstTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get("http://localhost/sign/LogIn.php");
	Thread.sleep(5000);
	
	WebElement bus=driver.findElement(By.id("email"));
	bus.sendKeys("sanjidasamanta277@gmail.com");
	Thread.sleep(5000);
	
	WebElement pass=driver.findElement(By.id("password"));
	pass.sendKeys("1234");
	Thread.sleep(5000);
	
	WebElement enter=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/button"));
	enter.click();
	Thread.sleep(5000);
	System.out.println("Attribute value :"+enter.getAttribute("type"));
}
}
