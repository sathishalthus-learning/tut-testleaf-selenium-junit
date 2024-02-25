package alt.playground;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.dom.model.Rect;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test10_Waits {
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
	public void waitForVisibility() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_wait")).click();
		//
		WebElement buttonClick = driver.findElement(By.id("j_idt87:j_idt89"));
		buttonClick.click();
//		Thread.sleep(10000);
		WebElement buttonIAmHere = driver.findElement(By.id("j_idt87:j_idt90"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(d ->buttonIAmHere.isDisplayed());
		buttonIAmHere.click();
	}
	
	//
	@Test
	public void waitForInVisibility() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_wait")).click();
		//
		driver.findElement(By.id("j_idt87:j_idt92")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d->!(driver.findElement(By.id("j_idt87:j_idt93")).isDisplayed()));
		System.out.println(driver.findElement(By.id("j_idt87:j_idt93")).isDisplayed());
	}

	//
	@Test
	public void waitForClickability() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_wait")).click();
		//

	}
	
	//
	@Test
	public void waitForTextChange() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_wait")).click();
		//

	}
}
