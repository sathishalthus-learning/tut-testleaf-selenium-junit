package alt.playground;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test00_LeafGround {
	//
	WebDriver driver;

	//
	@Before
	public void setUp() {
		//
		driver = new ChromeDriver();
	}

	//
	@After
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
