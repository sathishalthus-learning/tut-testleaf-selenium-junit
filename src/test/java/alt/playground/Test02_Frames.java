package alt.playground;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test02_Frames {
	//
	WebDriver driver;

	//
	@BeforeTest
	public void setUp() {
		//
		driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	//
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	//
	@Test
	public void confirmNewWindowOpens() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_frame")).click();
		//
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		assertTrue(driver.findElement(By.tagName("button")).getText()!="Click Me");
	}

	//
	@Test
	public void countTheFrames() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_frame")).click();
		//
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(1);
		driver.findElement(By.tagName("button")).click();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
	}
	
	//
	@Test
	public void nestedFrames() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_frame")).click();
		//
		driver.switchTo().frame(2);
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		driver.switchTo().defaultContent();
	}
}
