package com.basic.JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CopyPasteHandler extends BaseDrive{
	String url = "https://demoqa.com/automation-practice-form";

    @Test
    public void CopyPasteTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);
        
        Actions actions=new Actions(driver);
        
        WebElement first=driver.findElement(By.id("firstName"));
        first.sendKeys("Sanjida");
        
        //copy
        actions.keyDown(Keys.CONTROL);
        first.sendKeys("A");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(3000);
        actions.keyDown(Keys.CONTROL);
        first.sendKeys("C");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(3000);
        first.sendKeys(Keys.TAB);
        
        WebElement last=driver.findElement(By.id("lastName"));
        actions.keyDown(Keys.CONTROL);
        last.sendKeys("V");
        actions.keyUp(Keys.CONTROL);
        actions.build().perform();
        Thread.sleep(3000);
    }
}
