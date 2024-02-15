package alt.playground;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test00_LeafGround {
	//
	WebDriver driver;

	//
	@BeforeTest
	public void setUp() {
		//
		driver = new ChromeDriver();
	}

	//
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	//
	@Test
	public void loadPage() {
		//
		driver.get("https://www.leafground.com/");
		assertEquals(driver.getTitle(), "Dashboard");
	}

}
