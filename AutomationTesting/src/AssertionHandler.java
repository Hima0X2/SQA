package com.basic.JavaBasic;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class AssertionHandler extends BaseDrive{
	String url="https://www.selenium.dev/";
	@Test
public void assertionTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url);
	//Hard assertion
	String expected="baal";
	String actual=driver.getTitle();
//	Assert.assertEquals(actual, expected);
//	System.out.println("pass");
//	Thread.sleep(3000);
	//Soft assertion
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actual, expected);
	System.out.println("pass");
	soft.assertAll();
	Thread.sleep(3000);
}
}
