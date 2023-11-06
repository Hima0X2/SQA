package com.basic.JavaBasic;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class tabHandler extends BaseDrive{
	String url1="https://www.selenium.dev/";
	String url2="https://www.selenium.dev/downloads/";
	@Test
public void tabTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url1);
	String first=driver.getWindowHandle();
	Thread.sleep(3000);
	//create new tab and open url2
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get(url2);
	String second=driver.getWindowHandle();
	Thread.sleep(3000);
	driver.close();
	driver.switchTo().window(second);
	Thread.sleep(3000);
}
}
