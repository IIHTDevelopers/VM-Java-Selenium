package com.iiht.evaluation.automation.functional;


import static com.iiht.evaluation.automation.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.automation.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.automation.testutils.TestUtils.yakshaAssert;


import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.iiht.evaluation.automation.UITest;


public class AutomationTest {
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void preset() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	
	@Test
	public void testGetTitleCorrectData() throws IOException {
		try {
			
			String baseUrl = "https://www.yaksha.com/"; 
			String title = "Yaksha Tech Assessments Platform"; 
			boolean isTitlePresent = UITest.checkTitle(driver, baseUrl, title); 
			yakshaAssert(currentTest(), isTitlePresent, businessTestFile);
			
		}catch(Exception ex) {
			yakshaAssert(currentTest(), false, businessTestFile);
		}
	}
	
	@Test 
	public void testIsTextPresentCorrectData() throws IOException { 
		try {
			  String baseUrl = "https://www.yaksha.com/"; 
			  String text = "Request a Demo"; 
			  boolean isTextPresent = UITest.findByText(driver,baseUrl, text); 
			  yakshaAssert(currentTest(), isTextPresent, businessTestFile);
		  }catch(Exception ex) { 
			  yakshaAssert(currentTest(), false, businessTestFile); 
		  } 
	}
		  
	
	  @Test 
	  public void testIsLinkExistsCorrectData() throws IOException { 
		  try {
			  	String baseUrl = "https://www.yaksha.com/"; 
			  	String linkText = "View All Assessments >>"; 
			  	boolean isLinkExists = UITest.linkExists(driver, baseUrl, linkText); 
			  	yakshaAssert(currentTest(), isLinkExists, businessTestFile); 
			  }catch(Exception ex) {
				  yakshaAssert(currentTest(), false, businessTestFile); 
			  } 
	  }
	  
	  @Test 
	  public void testIsLinkClickedCorrectData() throws IOException { 
		  try {
			  	String baseUrl = "https://www.yaksha.com/"; 
			  	String linkText = "View All Assessments >>"; 
			  	boolean isLinkClicked = UITest.linkClick(driver,baseUrl, linkText);
			  	yakshaAssert(currentTest(), isLinkClicked, businessTestFile); 
			  	}catch(Exception ex) { 
			  		yakshaAssert(currentTest(), false, businessTestFile);
			  	} 
	 }
	 
	  @Test
		public void testGetTitleInCorrectData() throws IOException {
			try {
				
				String baseUrl = "https://www.yaksha.com/"; 
				String title = "Yaksha Platform"; 
				boolean isTitlePresent = UITest.checkTitle(driver, baseUrl, title); 
				yakshaAssert(currentTest(), !isTitlePresent, businessTestFile);
				
			}catch(Exception ex) {
				yakshaAssert(currentTest(), false, businessTestFile);
			}
		}
		
		@Test 
		public void testIsTextPresentInCorrectData() throws IOException { 
			try {
				  String baseUrl = "https://www.yaksha.com/"; 
				  String text = "Request"; 
				  boolean isTextPresent = UITest.findByText(driver,baseUrl, text); 
				  yakshaAssert(currentTest(), !isTextPresent, businessTestFile);
			  }catch(Exception ex) { 
				  yakshaAssert(currentTest(), false, businessTestFile); 
			  } 
		}
			  
		
		  @Test 
		  public void testIsLinkExistsInCorrectData() throws IOException { 
			  try {
				  	String baseUrl = "https://www.yaksha.com/"; 
				  	String linkText = "View Assessments >>"; 
				  	boolean isLinkExists = UITest.linkExists(driver, baseUrl, linkText); 
				  	yakshaAssert(currentTest(), !isLinkExists, businessTestFile); 
				  }catch(Exception ex) {
					  yakshaAssert(currentTest(), false, businessTestFile); 
				  } 
		  }
		  
		  @Test 
		  public void testIsLinkClickedInCorrectData() throws IOException { 
			  try {
				  	String baseUrl = "https://www.yaksha.com/"; 
				  	String linkText = "View Assessments >>"; 
				  	boolean isLinkClicked = UITest.linkClick(driver,baseUrl, linkText);
				  	yakshaAssert(currentTest(), !isLinkClicked, businessTestFile); 
				  	}catch(Exception ex) { 
				  		yakshaAssert(currentTest(), false, businessTestFile);
				  	} 
		} 
	  
	  @AfterAll
	  public static void cleanUp() {
			driver.quit();
	  } 	 
}

