package alt.playground;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test05_Button {
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
	public void clickAndConfirmTitle() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		assertTrue(driver.getTitle().contentEquals("Dashboard"));
	}
	
	//
	@Test
	public void confirmButtonDisabled() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
//		driver.findElement(By.id("j_idt88:j_idt92")).click();
		assertFalse(driver.findElement(By.id("j_idt88:j_idt92")).isEnabled());
	}
	
	//
	@Test
	public void findThePositionOfButton() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		WebElement submitButton = driver.findElement(By.id("j_idt88:j_idt94"));
		Rectangle buttonPositions = submitButton.getRect();
		System.out.println(buttonPositions.getDimension());
		System.out.println(buttonPositions.getX());
		System.out.println(buttonPositions.getY());
	}
	//
	@Test
	public void findTheButtonColor() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		WebElement saveButton = driver.findElement(By.id("j_idt88:j_idt96"));
		System.out.println(saveButton.getCssValue("color"));
	}
	
	//
	@Test
	public void findTheHeightAndWidth() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		WebElement saveButton = driver.findElement(By.id("j_idt88:j_idt98"));
		Rectangle rect = saveButton.getRect();
		System.out.println(rect.getHeight());
		System.out.println(rect.getWidth());
	}
	
	//
	@Test
	public void moveMouseOverAndConfirmColorChanges() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		WebElement testButton = driver.findElement(By.id("j_idt88:j_idt100"));
		System.out.println(testButton.getCssValue("background-color"));
		new Actions(driver).moveToElement(testButton).perform();
		System.out.println(testButton.getCssValue("background-color"));
	}
	
	//
	@Test
	public void clickImageAndHideClickAnywhere() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		WebElement testButton = driver.findElement(By.id("j_idt88:j_idt102:imageBtn"));
		testButton.click();
	}
	
	//
	@Test
	public void countRoundedButtons() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_button")).click();
		//
		int testButton = driver.findElements(By.className("rounded-button")).size();
		System.out.println(testButton);
	}
}
