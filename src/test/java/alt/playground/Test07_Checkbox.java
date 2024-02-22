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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test07_Checkbox {
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
	public void basicCheckBox() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		driver.findElement(By.className("ui-chkbox-label")).click();
		Thread.sleep(3000);
	}

	//
	@Test
	public void notification() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt91\"]/span")).click();
		Thread.sleep(2000);
	}
	
	//
	@Test
	public void favoriteLanguage() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		List<WebElement> favoriteLanguages = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
		for(WebElement element: favoriteLanguages) {
			System.out.println(element.getText());
		}
		driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[1]/label")).click();
	}
	
	//
	@Test
	public void triStateCheckbox() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		driver.findElement(By.xpath("//*[@id=\"j_idt87:ajaxTriState\"]/div[2]/span")).click();
	}
	
	//
	@Test
	public void toggleSwitch() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		
	}
	
	//
	@Test
	public void disabledCheckbox() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
		
	}
	
	//
	@Test
	public void selectMultiple() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_checkbox")).click();
		//
	}
		
	
}
