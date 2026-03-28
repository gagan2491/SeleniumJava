package tests;

import org.testng.annotations.Test;

import base.BaseClass;

public class DummyTest2 extends BaseClass {
	
	@Test
	public void dummy() {
		
		String actualTitle = driver.getTitle();
		assert actualTitle.equalsIgnoreCase("OrangeHRM") : "Title assert failed";
		
		System.out.println("Test passed");
	}

}
