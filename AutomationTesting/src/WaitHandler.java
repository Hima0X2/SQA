package com.basic.JavaBasic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitHandler extends BaseDrive{
	String url="https://www.selenium.dev/";
	@Test
public void testWait() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url);
	//Implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//Explicit wait
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	WebElement blog=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Blog')]")));
	blog.click();
	Thread.sleep(3000);
}
}
